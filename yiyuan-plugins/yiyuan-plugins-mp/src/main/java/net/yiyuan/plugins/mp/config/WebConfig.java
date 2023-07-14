package net.yiyuan.plugins.mp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 网络配置 Web MVC配置
 *
 * @author eden
 * @date 2023/07/13
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

  /** 枚举类的转换器工厂 addConverterFactory */
  @Override
  public void addFormatters(FormatterRegistry registry) {
    // 枚举 转化器工厂类 添加进 Spring Boot 配置
    registry.addConverterFactory(new StringCodeToEnumConverterFactory());
  }
}
