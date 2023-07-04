package net.yiyuan.core.task.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfiguration {

  // quartz数据库 dataSourceTask数据源，使用@QuartzDataSource后，不需要动态配置
  @Bean(name = "dataSourceTask")
  //  @ConfigurationProperties("spring.datasource.quartz")
  @QuartzDataSource
  public DruidDataSource dataSourceTask() {
    return DruidDataSourceBuilder.create().build();
  }
}
