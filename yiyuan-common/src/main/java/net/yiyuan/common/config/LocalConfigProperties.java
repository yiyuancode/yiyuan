package net.yiyuan.common.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/** 本地文件操作器配置 */
@Getter
@Component
public class LocalConfigProperties implements FileOperatorConfigInter {
  // 本地地址 E:/files/yiyuan
  @Value("${file.server.local.rootPath:''}")
  private String rootPath;
}
