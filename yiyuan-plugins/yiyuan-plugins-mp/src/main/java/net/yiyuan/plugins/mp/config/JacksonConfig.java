package net.yiyuan.plugins.mp.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 字符串枚举代码转换器工厂 编码 -> 枚举 转化器工厂类 解决post body请求参数的映射，要不然springboot默认是根据索引0开始的 映射枚举，顺序不对
 *
 * @author 一源团队-花和尚
 * @date 2023/07/13
 */
@Component
public class JacksonConfig implements SmartInitializingSingleton {

  @Resource private ObjectMapper objectMapper;

  @Override
  public void afterSingletonsInstantiated() {
    SimpleModule simpleModule = new SimpleModule();
    simpleModule.addDeserializer(Enum.class, new EnumDeserializer());
    objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);

    objectMapper.registerModule(simpleModule);
  }
}
