package net.yiyuan.admin.cofig.druid;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.util.Utils;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class DruidConfig {
  // 登陆账号
  private final String USERNAME = "admin";
  // 登陆密码
  private final String PASSWORD = "123456";

  @Value("${spring.datasource.url:#{null}}")
  private String dbUrl;

  @Value("${spring.datasource.username: #{null}}")
  private String username;

  @Value("${spring.datasource.password:#{null}}")
  private String password;

  @Value("${spring.datasource.driverClassName:#{null}}")
  private String driverClassName;

  @Value("${spring.datasource.initialSize:#{null}}")
  private Integer initialSize;

  @Value("${spring.datasource.minIdle:#{null}}")
  private Integer minIdle;

  @Value("${spring.datasource.maxActive:#{null}}")
  private Integer maxActive;

  @Value("${spring.datasource.maxWait:#{null}}")
  private Integer maxWait;

  @Value("${spring.datasource.timeBetweenEvictionRunsMillis:#{null}}")
  private Integer timeBetweenEvictionRunsMillis;

  @Value("${spring.datasource.minEvictableIdleTimeMillis:#{null}}")
  private Integer minEvictableIdleTimeMillis;

  @Value("${spring.datasource.validationQuery:#{null}}")
  private String validationQuery;

  @Value("${spring.datasource.testWhileIdle:#{null}}")
  private Boolean testWhileIdle;

  @Value("${spring.datasource.testOnBorrow:#{null}}")
  private Boolean testOnBorrow;

  @Value("${spring.datasource.testOnReturn:#{null}}")
  private Boolean testOnReturn;

  @Value("${spring.datasource.poolPreparedStatements:#{null}}")
  private Boolean poolPreparedStatements;

  @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize:#{null}}")
  private Integer maxPoolPreparedStatementPerConnectionSize;

  @Value("${spring.datasource.filters:#{null}}")
  private String filters;

  @Value("{spring.datasource.connectionProperties:#{null}}")
  private String connectionProperties;

  @Bean
  @Primary
  public DruidDataSource dataSource() {
    DruidDataSource datasource = new DruidDataSource();
    datasource.setUrl(this.dbUrl);
    datasource.setUsername(username);
    datasource.setPassword(password);
    datasource.setDriverClassName(driverClassName);
    // configuration
    if (initialSize != null) {
      datasource.setInitialSize(initialSize);
    }
    if (minIdle != null) {
      datasource.setMinIdle(minIdle);
    }
    if (maxActive != null) {
      datasource.setMaxActive(maxActive);
    }
    if (maxWait != null) {
      datasource.setMaxWait(maxWait);
    }
    if (timeBetweenEvictionRunsMillis != null) {
      datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
    }
    if (minEvictableIdleTimeMillis != null) {
      datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
    }
    if (validationQuery != null) {
      datasource.setValidationQuery(validationQuery);
    }
    if (testWhileIdle != null) {
      datasource.setTestWhileIdle(testWhileIdle);
    }
    if (testOnBorrow != null) {
      datasource.setTestOnBorrow(testOnBorrow);
    }
    if (testOnReturn != null) {
      datasource.setTestOnReturn(testOnReturn);
    }
    if (poolPreparedStatements != null) {
      datasource.setPoolPreparedStatements(poolPreparedStatements);
    }
    if (maxPoolPreparedStatementPerConnectionSize != null) {
      datasource.setMaxPoolPreparedStatementPerConnectionSize(
          maxPoolPreparedStatementPerConnectionSize);
    }
    if (connectionProperties != null) {
      datasource.setConnectionProperties(connectionProperties);
    }
    List<com.alibaba.druid.filter.Filter> filters = new ArrayList<>();
    filters.add(statFilter());
    filters.add(wallFilter());
    datasource.setProxyFilters(filters);
    return datasource;
  }

  @Bean
  public ServletRegistrationBean druidServlet() {
    ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
    servletRegistrationBean.setServlet(new StatViewServlet());
    servletRegistrationBean.addUrlMappings("/druid/*");
    Map<String, String> initParameters = new HashMap<>();
    initParameters.put("resetEnable", "false"); // 禁用HTML页面上的“Rest All”功能
    // initParameters.put("allow", "10.8.9.115");  //ip白名单(没有配置或者为空，则允许所有访问)
    // 如果不设置用户名和密码  则是无需登录的 可以直接集成vue的外链
    initParameters.put("loginUsername", ""); // ++监控页面登录用户名
    initParameters.put("loginPassword", ""); // ++监控页面登录用户密码
    // initParameters.put("deny", ""); //ip黑名单
    // 如果某个ip同时存在，deny优先于allow
    servletRegistrationBean.setInitParameters(initParameters);
    return servletRegistrationBean;
  }

  @Bean
  public StatFilter statFilter() {
    StatFilter statFilter = new StatFilter();
    statFilter.setLogSlowSql(true);
    statFilter.setMergeSql(true);
    statFilter.setSlowSqlMillis(3000);
    return statFilter;
  }

  @Bean
  public WallFilter wallFilter() {
    WallFilter wallFilter = new WallFilter();
    // 允许执行多条SQL
    WallConfig config = new WallConfig();
    config.setMultiStatementAllow(true);
    wallFilter.setConfig(config);
    return wallFilter;
  }

  /**
   * 删除durid底部阿里云广告过滤器bean注册
   *
   * @param properties 属性
   * @return {@link FilterRegistrationBean }
   * @author 一源团队-花和尚
   * @date 2023/07/16
   */
  @Bean
  public FilterRegistrationBean removeDruidAdFilterRegistrationBean(
      DruidStatProperties properties) {
    // 获取web监控页面的参数
    DruidStatProperties.StatViewServlet config = properties.getStatViewServlet();
    // 提取common.js的配置路径
    String pattern = config.getUrlPattern() != null ? config.getUrlPattern() : "/druid/*";
    String commonJsPattern = pattern.replaceAll("\\*", "js/common.js");

    final String filePath = "support/http/resources/js/common.js";
    // 创建filter进行过滤
    Filter filter =
        new Filter() {
          @Override
          public void doFilter(
              ServletRequest servletRequest,
              ServletResponse servletResponse,
              FilterChain filterChain)
              throws IOException, ServletException {
            filterChain.doFilter(servletRequest, servletResponse);
            // 重置缓冲区，响应头不会被重置
            servletResponse.resetBuffer();
            // 获取common.js
            // import com.alibaba.druid.util.Utils;
            String text = Utils.readFromResource(filePath);

            // 正则替换banner, 除去底部的广告信息
            text = text.replaceAll("<a.*?banner\"></a><br/>", "");
            text = text.replaceAll("powered.*?shrek.wang</a>", "");
            servletResponse.getWriter().write(text);
          }
        };

    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
    registrationBean.setFilter(filter);
    registrationBean.addUrlPatterns(commonJsPattern);

    return registrationBean;
  }
}
