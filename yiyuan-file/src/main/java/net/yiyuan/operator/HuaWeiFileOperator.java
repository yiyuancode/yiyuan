package net.yiyuan.operator;

import com.obs.services.ObsClient;
import com.obs.services.exception.ObsException;
import com.obs.services.model.*;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.exception.FileOperatorException;
import net.yiyuan.pojo.dto.ObjectResponse;
import net.yiyuan.pojo.dto.UploadRequestParam;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/** 华为云OSS文件操作器 */
@Slf4j
public class HuaWeiFileOperator extends AbstractFileOperator {

  /** 文件不存在的状态码 */
  private static final int FILE_NOT_FOUND = 404;
  private ObsClient obsClient;

  @Override
  public void init(Map<String, String> params) {
    log.info("华为云OSS文件服务-初始化开始 | params:[{}]", params);
    String endpoint = params.get("endpoint");
    String accessKey = params.get("accessKey");
    String secretKey = params.get("secretKey");
    if (StringUtils.isAnyBlank(endpoint, accessKey, secretKey)) {
      throw new FileOperatorException("华为云OSS文件服务-初始化参数错误");
    }
    obsClient = new ObsClient(accessKey, secretKey, endpoint);
    log.info("华为云OSS文件服务-初始化完成");
  }

  @Override
  public ObjectResponse uploadFile(UploadRequestParam requestParam, InputStream inputStream) {
    final String bucketName = this.getOrDefaultBucket(requestParam.getBucketName());
    // 桶创建
    if (!this.hasBucket(bucketName)) {
      try {
        obsClient.createBucket(requestParam.getBucketName());
      } catch (Exception e) {
        log.error("华为云OSS文件服务-桶创建异常", e);
        throw new FileOperatorException("华为云OSS文件服务-桶创建异常", e);
      }
    }
    // 上传
    PutObjectResult objectResult;
    try {
      objectResult = obsClient.putObject(bucketName, requestParam.getKey(), inputStream);
    } catch (Exception e) {
      log.error("华为云OSS文件服务-上传文件异常", e);
      throw new FileOperatorException("华为云OSS文件服务-上传文件异常", e);
    }
    return ObjectResponse.builder()
        .key(objectResult.getObjectKey())
        .storePath(objectResult.getBucketName() + STORE_SPLIT + objectResult.getObjectKey())
        .build();
  }

  @Override
  public void getFileAsStream(String storePath, Consumer<InputStream> streamConsumer) {
    String[] paths = storePath.split(STORE_SPLIT, 2);
    String bucketName = paths[0];
    String key = paths[1];
    if (!this.hasFile(bucketName, key)) {
      throw new FileOperatorException("文件不存在");
    }
    try {
      ObsObject obsObject = obsClient.getObject(bucketName, key);
      try (InputStream inputStream = obsObject.getObjectContent()) {
        streamConsumer.accept(inputStream);
      }
    } catch (Exception e) {
      log.error("华为云OSS文件服务-获取文件下载流异常", e);
      throw new FileOperatorException("华为云OSS文件服务-获取文件下载流异常", e);
    }
  }

  @Override
  public ObjectResponse copyFile(String storePath, UploadRequestParam targetParam) {
    String[] paths = storePath.split(STORE_SPLIT, 2);
    try {
      obsClient.copyObject(paths[0], paths[1], targetParam.getBucketName(), targetParam.getKey());
      return ObjectResponse.builder()
          .key(targetParam.getKey())
          .storePath(targetParam.getBucketName() + STORE_SPLIT + targetParam.getKey())
          .build();
    } catch (Exception e) {
      log.error("华为云OSS文件服务-文件复制异常", e);
      throw new FileOperatorException("华为云OSS文件服务-文件复制异常", e);
    }
  }

  @Override
  public void deleteFile(String storePath) {
    String[] paths = storePath.split(STORE_SPLIT, 2);
    try {
      if (!obsClient.deleteObject(paths[0], paths[1]).isDeleteMarker()) {
        throw new FileOperatorException("华为云OSS文件服务-文件删除失败");
      }
    } catch (Exception e) {
      log.error("华为云OSS文件服务-文件删除异常", e);
      throw new FileOperatorException("华为云OSS文件服务-文件删除异常", e);
    }
  }

  @Override
  public String getFileDownloadUrl(String storePath, int duration, TimeUnit unit) {
    String[] paths = storePath.split(STORE_SPLIT, 2);
    TemporarySignatureRequest request =
        new TemporarySignatureRequest(HttpMethodEnum.GET, unit.toSeconds(duration));
    request.setBucketName(paths[0]);
    request.setObjectKey(paths[1]);
    try {
      TemporarySignatureResponse response = obsClient.createTemporarySignature(request);
      return response.getSignedUrl();
    } catch (Exception e) {
      log.error("华为云OSS文件服务-获取文件下载地址异常", e);
      throw new FileOperatorException("华为云OSS文件服务-获取文件下载地址异常", e);
    }
  }

  public boolean hasBucket(String bucketName) {
    try {
      return obsClient.headBucket(bucketName);
    } catch (Exception e) {
      log.error("华为云OSS文件服务-桶判定异常", e);
      throw new FileOperatorException("华为云OSS文件服务-桶判定异常", e);
    }
  }

  public boolean hasFile(String bucketName, String key) {
    try {
      obsClient.getObjectMetadata(bucketName, key);
      return true;
    } catch (Exception e) {
      if (e instanceof ObsException) {
        if (((ObsException) e).getResponseCode() == FILE_NOT_FOUND) {
          return false;
        }
      }
      log.error("MinIo文件服务-文件判定异常", e);
      throw new FileOperatorException("MinIo文件服务-文件判定异常", e);
    }
  }
}
