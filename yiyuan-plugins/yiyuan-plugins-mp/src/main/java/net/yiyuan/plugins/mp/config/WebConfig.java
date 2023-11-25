package net.yiyuan.plugins.mp.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 网络配置 Web MVC配置
 *
 * @author eden
 * @date 2023/07/13
 */
@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {

  /** 枚举类的转换器工厂 addConverterFactory */
  @Override
  public void addFormatters(FormatterRegistry registry) {
    // 枚举 转化器工厂类 添加进 Spring Boot 配置
    registry.addConverterFactory(new StringCodeToEnumConverterFactory());
  }


}
