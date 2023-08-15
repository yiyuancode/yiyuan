package net.yiyuan.core.file.operator;

import net.yiyuan.core.file.pojo.dto.ObjectResponse;
import net.yiyuan.core.file.pojo.dto.UploadRequestParam;

import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/** 文件操作接口 */
public interface FileOperatorInter {

  /**
   * 初始化
   *
   * @param params 初始化参数
   */
  void init(Map<String, String> params);

  /**
   * 上传文件
   *
   * @param requestParam 上传参数
   * @param inputStream 文件流
   * @return ObjectResponse
   */
  ObjectResponse uploadFile(UploadRequestParam requestParam, InputStream inputStream);

  /**
   * 获取指定文件流
   *
   * @param storePath 上传返回的存储路径
   * @param streamConsumer 流消费者
   */
  void getFileAsStream(String storePath, Consumer<InputStream> streamConsumer);

  /**
   * 复制文件
   *
   * @param storePath 上传返回的存储路径
   * @param targetParam 目标参数
   * @return ObjectResponse
   */
  ObjectResponse copyFile(String storePath, UploadRequestParam targetParam);

  /**
   * 删除文件
   *
   * @param storePath 上传返回的存储路径
   */
  void deleteFile(String storePath);

  /**
   * 获取指定文件下载地址
   *
   * @param storePath 上传返回的存储路径
   * @param duration 下载时效
   * @param unit 时效单位
   * @return 下载地址
   */
  String getFileDownloadUrl(String storePath, int duration, TimeUnit unit);

  /** 销毁时处理方法 */
  void destroy();
}
