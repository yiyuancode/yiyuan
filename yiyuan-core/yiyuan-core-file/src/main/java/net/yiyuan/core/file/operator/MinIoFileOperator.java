package net.yiyuan.core.file.operator;




import io.minio.*;
import io.minio.errors.ErrorResponseException;
import io.minio.http.Method;
import io.minio.messages.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.core.file.exception.FileOperatorException;
import net.yiyuan.core.file.pojo.dto.ObjectResponse;
import net.yiyuan.core.file.pojo.dto.UploadRequestParam;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * MinIo文件操作器
 */
@Slf4j
public class MinIoFileOperator extends AbstractFileOperator {

    private MinioClient minioClient;
    /**
     * 不存在文件KEY的返回值
     */
    private static final String NO_SUCH_KEY = "NoSuchKey";
    /**
     * 不存在桶的返回值
     */
    private static final String NO_SUCH_BUCKET = "NoSuchBucket";

    @Override
    public void init(Map<String, String> params) {
        log.info("MinIo文件服务-初始化开始 | params:[{}]", params);
        String endpoint = params.get("endpoint");
        String accessKey = params.get("accessKey");
        String secretKey = params.get("secretKey");
        if (StringUtils.isAnyBlank(endpoint, accessKey, secretKey)) {
            throw new FileOperatorException("MinIo文件服务-初始化参数错误");
        }
        minioClient = MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
        log.info("MinIo文件服务-初始化完成");
    }

    @Override
    public ObjectResponse uploadFile(UploadRequestParam requestParam, InputStream inputStream) {
        final String bucketName = this.getOrDefaultBucket(requestParam.getBucketName());
        //桶创建
        if (!this.hasBucket(bucketName)) {
            try {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            } catch (Exception e) {
                log.error("MinIo文件服务-桶创建异常", e);
                throw new FileOperatorException("MinIo文件服务-桶创建异常", e);
            }
        }
        //参数组织
        PutObjectArgs objectArgs = PutObjectArgs.builder()
                .bucket(bucketName)
                .object(requestParam.getKey())
                .stream(inputStream,
                        requestParam.getSize() == null ? -1 : requestParam.getSize(),
                        requestParam.getPartSize() == null ? ObjectWriteArgs.MIN_MULTIPART_SIZE : requestParam.getPartSize())
                .contentType(requestParam.getContentType())
                .userMetadata(requestParam.getMetadata())
                .build();
        //上传操作
        try {
            ObjectWriteResponse writeResponse = minioClient.putObject(objectArgs);
            return ObjectResponse.builder()
                    .key(writeResponse.object())
                    .storePath(writeResponse.bucket() + STORE_SPLIT + writeResponse.object())
                    .build();
        } catch (Exception e) {
            log.error("MinIo文件服务-上传文件异常", e);
            throw new FileOperatorException("MinIo文件服务-上传文件异常", e);
        }
    }

    @Override
    public void getFileAsStream(String storePath, Consumer<InputStream> streamConsumer) {
        String[] paths = storePath.split(STORE_SPLIT, 2);
        String bucketName = paths[0];
        String key = paths[1];
        if (!this.hasFile(bucketName, key)) {
            throw new FileOperatorException("文件不存在");
        }
        try (InputStream stream = minioClient.getObject(
                GetObjectArgs.builder()
                        .bucket(bucketName)
                        .object(key)
                        .build())) {
            streamConsumer.accept(stream);
        } catch (Exception e) {
            log.error("MinIo文件服务-获取文件下载流异常", e);
            throw new FileOperatorException("MinIo文件服务-获取文件下载流异常", e);
        }
    }

    @Override
    public ObjectResponse copyFile(String storePath, UploadRequestParam targetParam) {
        String[] paths = storePath.split(STORE_SPLIT, 2);
        try {
            ObjectWriteResponse writeResponse = minioClient.copyObject(CopyObjectArgs.builder()
                    .source(CopySource.builder().bucket(paths[0]).object(paths[1]).build())
                    .bucket(targetParam.getBucketName()).object(targetParam.getKey())
                    .metadataDirective(Directive.REPLACE)
                    .taggingDirective(Directive.REPLACE).build());
            return ObjectResponse.builder()
                    .key(writeResponse.object())
                    .storePath(writeResponse.bucket() + STORE_SPLIT + writeResponse.object())
                    .build();
        } catch (Exception e) {
            log.error("MinIo文件服务-文件复制异常", e);
            throw new FileOperatorException("MinIo文件服务-文件复制异常", e);
        }
    }

    @Override
    public void deleteFile(String storePath) {
        String[] paths = storePath.split(STORE_SPLIT, 2);
        try {
            minioClient.removeObject(
                    RemoveObjectArgs.builder().bucket(paths[0]).object(paths[1]).build());
        } catch (Exception e) {
            log.error("MinIo文件服务-文件删除异常", e);
            throw new FileOperatorException("MinIo文件服务-文件删除异常", e);
        }
    }

    @Override
    public String getFileDownloadUrl(String storePath, int duration, TimeUnit unit) {
        String[] paths = storePath.split(STORE_SPLIT, 2);
        try {
            return minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .method(Method.GET)
                            .bucket(paths[0])
                            .object(paths[1])
                            .expiry(duration, unit)
                            .build());
        } catch (Exception e) {
            log.error("MinIo文件服务-获取文件下载地址异常", e);
            throw new FileOperatorException("MinIo文件服务-获取文件下载地址异常", e);
        }
    }

    public boolean hasBucket(String bucketName) {
        try {
            return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        } catch (Exception e) {
            log.error("MinIo文件服务-桶判定异常", e);
            throw new FileOperatorException("MinIo文件服务-桶判定异常", e);
        }
    }

    public boolean hasFile(String bucketName, String key) {
        try {
            minioClient.statObject(StatObjectArgs.builder().bucket(bucketName).object(key).build());
            return true;
        } catch (Exception e) {
            if (e instanceof ErrorResponseException) {
                ErrorResponse errorResponse = ((ErrorResponseException) e).errorResponse();
                if (StringUtils.equalsAny(errorResponse.code(), NO_SUCH_KEY, NO_SUCH_BUCKET)) {
                    return false;
                }
            }
            log.error("MinIo文件服务-文件判定异常", e);
            throw new FileOperatorException("MinIo文件服务-文件判定异常", e);
        }
    }
}
