package net.yiyuan.common.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

/** MinIo文件操作器配置 */
@Getter
@Component
// 是否使用minio配置
@ConditionalOnExpression("${file.server.minio.enabled:false}")
public class MinIoConfigProperties implements FileOperatorConfigInter {
  // 终端地址
  @Value("${file.server.minio.endpoint:''}")
  private String endpoint;
  // accessKey
  @Value("${file.server.minio.accessKey:''}")
  private String accessKey;
  // secrtKey
  @Value("${file.server.minio.secretKey:''}")
  private String secretKey;
}
