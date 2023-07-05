package net.yiyuan.core.task.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfiguration {

  @QuartzDataSource
  public DruidDataSource dataSourceTask() {
    return DruidDataSourceBuilder.create().build();
  }
}
