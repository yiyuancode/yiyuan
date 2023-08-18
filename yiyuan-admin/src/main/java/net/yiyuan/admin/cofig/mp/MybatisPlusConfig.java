package net.yiyuan.admin.cofig.mp;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.handlers.MybatisEnumTypeHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.fasterxml.jackson.databind.SerializationFeature;
import icu.mhb.mybatisplus.plugln.injector.JoinDefaultSqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/** MyBatis配置类 */
@Configuration
@EnableTransactionManagement
// 扫描多包通配符设置
@MapperScan({
  "net.yiyuan.*.mapper",
  "net.yiyuan.**.mapper",
  "net.yiyuan.***.mapper",
  "net.yiyuan.****.mapper",
  "net.yiyuan.*****.mapper"
})
// @MapperScan(value = "net.yicode.yiyuan.admin.ums.mapper", annotationClass = Mapper.class) //
// Mapper 懒加载，目前仅用于单元测试
public class MybatisPlusConfig extends JoinDefaultSqlInjector {
  @Bean
  public MybatisPlusInterceptor mybatisPlusInterceptor() {
    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    // 分页插件(如果要配置mp的多租户，分页插件需要放在多租户插件后面加入)
    interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
    return interceptor;
  }

  @Bean
  public MybatisPlusPropertiesCustomizer mybatisPlusPropertiesCustomizer() {
    return properties -> {
      GlobalConfig globalConfig = properties.getGlobalConfig();
      globalConfig.setBanner(false);
      MybatisConfiguration configuration = new MybatisConfiguration();
      configuration.setDefaultEnumTypeHandler(MybatisEnumTypeHandler.class);
      properties.setConfiguration(configuration);
    };
  }

  @Bean
  public Jackson2ObjectMapperBuilderCustomizer customizer() {
    FastJsonConfig config = new FastJsonConfig();
    config.setSerializerFeatures(SerializerFeature.WriteEnumUsingToString);
    return builder -> builder.featuresToEnable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
  }
}
