package net.yiyuan.operator;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.exception.FileOperatorException;
import net.yiyuan.pojo.dto.ObjectResponse;
import net.yiyuan.pojo.dto.UploadRequestParam;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/** 本地文件操作器 */
@Slf4j
public class LocalFileOperator extends AbstractFileOperator {

  /** 缓冲大小 500KB */
  private static final int BUFFER_SIZE = 500 * 1024;
  /** 文件操作根路径 例："D:/file"，"/"等 */
  private Path rootPath;

  @Override
  public void init(Map<String, String> params) {
    log.info("本地文件服务-初始化开始 | params:[{}]", params);
    String rootPathStr = params.get("rootPath");
    Path rootPath = Paths.get(rootPathStr);
    if (!rootPath.toFile().isDirectory()) {
      try {
        Path directories = Files.createDirectories(rootPath);
        log.info("本地文件服务-初始化根目录[{}]", directories);
      } catch (IOException e) {
        log.error("本地文件服务-初始化根目录异常", e);
        throw new FileOperatorException("本地文件服务-初始化根目录异常", e);
      }
    }
    this.rootPath = rootPath;
    log.info("本地文件服务-初始化完成");
  }

  @Override
  public ObjectResponse uploadFile(UploadRequestParam requestParam, InputStream inputStream) {
    final String bucketName = this.getOrDefaultBucket(requestParam.getBucketName());
    // 目录创建 | 实际上传路径为：root+bucketName+日期(yyyy-MM-dd)
    Path directoryPath = rootPath.resolve(bucketName).resolve(LocalDate.now().toString());
    if (!Files.isDirectory(directoryPath)) {
      try {
        Files.createDirectories(directoryPath);
      } catch (IOException e) {
        log.error("本地文件服务-上传文件 | 目录[{}]创建失败", directoryPath, e);
        throw new FileOperatorException("本地文件服务-上传文件 | 目录创建失败", e);
      }
    }
    // 文件创建 | 本地文件最终存储时加上扩展名
    Path filePath = directoryPath.resolve(requestParam.getKey() + "." + requestParam.getExtName());
    if (!filePath.toFile().isFile()) {
      try {
        Files.createFile(filePath);
      } catch (IOException e) {
        log.error("本地文件服务-上传文件 | 文件[{}]创建失败", filePath, e);
        throw new FileOperatorException("本地文件服务-上传文件 | 文件创建失败", e);
      }
    }
    // 流输出
    try (FileOutputStream outputStream = new FileOutputStream(filePath.toFile())) {
      byte[] buffer = new byte[BUFFER_SIZE];
      int len;
      while ((len = inputStream.read(buffer)) != -1) {
        outputStream.write(buffer, 0, len);
      }
      outputStream.flush();
    } catch (IOException e) {
      log.error("本地文件服务-上传文件 | 上传过程异常", e);
      throw new FileOperatorException("本地文件服务-上传文件 | 上传过程异常", e);
    }
    // 返回上传相关结果数据
    return ObjectResponse.builder()
        .key(requestParam.getKey())
        .storePath(filePath.toString())
        .build();
  }

  @Override
  public void getFileAsStream(String storePath, Consumer<InputStream> streamConsumer) {
    File file = Paths.get(storePath).toFile();
    if (!file.exists() || !file.isFile()) {
      throw new FileOperatorException("文件不存在");
    }
    try (InputStream stream = new FileInputStream(file)) {
      streamConsumer.accept(stream);
    } catch (Exception e) {
      log.error("本地文件服务-获取文件下载流异常", e);
      throw new FileOperatorException("本地文件服务-获取文件下载流异常", e);
    }
  }

  @Override
  public ObjectResponse copyFile(String storePath, UploadRequestParam targetParam) {
    Path source = Paths.get(storePath);
    Path target =
        rootPath
            .resolve(targetParam.getBucketName())
            .resolve(targetParam.getKey() + "." + targetParam.getExtName());
    try {
      Files.copy(
          source,
          target,
          StandardCopyOption.REPLACE_EXISTING,
          StandardCopyOption.ATOMIC_MOVE,
          StandardCopyOption.COPY_ATTRIBUTES);
    } catch (IOException e) {
      log.error("本地文件服务-文件复制异常", e);
      throw new FileOperatorException("本地文件服务-文件复制异常", e);
    }
    // 返回文件操作相关结果数据
    return ObjectResponse.builder().key(targetParam.getKey()).storePath(target.toString()).build();
  }

  @Override
  public void deleteFile(String storePath) {
    try {
      Files.deleteIfExists(Paths.get(storePath));
    } catch (IOException e) {
      log.error("本地文件服务-文件删除异常", e);
      throw new FileOperatorException("本地文件服务-文件删除异常", e);
    }
  }

  @Override
  public String getFileDownloadUrl(String storePath, int duration, TimeUnit unit) {
    //    throw new NotImplementedException();
    throw new RuntimeException();
  }
}
