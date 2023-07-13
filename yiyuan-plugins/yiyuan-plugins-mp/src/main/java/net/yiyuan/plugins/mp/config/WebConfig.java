package net.yiyuan.plugins.mp.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.TimeZone;

/**
 * Web MVC配置
 *
 * @author eden
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(new ByteArrayHttpMessageConverter());
    converters.add(new StringHttpMessageConverter());
    converters.add(new ResourceHttpMessageConverter());
    converters.add(new AllEncompassingFormHttpMessageConverter());
    converters.add(new StringHttpMessageConverter());
    converters.add(jackson2HttpMessageConverter());
  }

  /** 枚举字段可以使用null、空字符串、非匹配的任意字符串进行传参，而不引发异常 */
  @Bean
  @Order(0)
  public ObjectMapper myObjectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    // 解决enum不匹配问题 默认值为false
    objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
    return objectMapper;
  }

  @Bean
  public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    ObjectMapper mapper = myObjectMapper();

    // 忽略未知属性
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    // 统一日期格式转换，不建议开启
    // mapper.setDateFormat(new SimpleDateFormat(DateUtils.DATE_TIME_PATTERN));
    mapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));

    converter.setObjectMapper(mapper);
    return converter;
  }
}
