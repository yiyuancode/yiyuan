package net.yiyuan.tenant.cofig.mp;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.handlers.MybatisEnumTypeHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import com.fasterxml.jackson.databind.SerializationFeature;
import icu.mhb.mybatisplus.plugln.injector.JoinDefaultSqlInjector;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import net.yiyuan.common.utils.StringUtilsPlus;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

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
    // 多租户插件
    interceptor.addInnerInterceptor(
        new TenantLineInnerInterceptor(
            new TenantLineHandler() {
              /**
               * 获取租户 ID 值表达式，只支持单个 ID 值，用于从当前请求中获取租户ID
               *
               * <p>
               *
               * @return 租户 ID 值表达式
               */
              @Override
              public Expression getTenantId() {
                HttpServletRequest request =
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                        .getRequest();
                String tenantId = request.getHeader("tenantId");
                // 为空表示平台管理元查询,获取租户id字段进行sql数据隔离,不为空表示租户查询
                if (StringUtilsPlus.isEmpty(tenantId)) {
                  throw new RuntimeException("租户id不合法");
                } else {
                  return new StringValue(tenantId);
                }
              }

              /**
               * 获取租户字段名
               *
               * <p>默认字段名叫: tenant_id
               *
               * @return 租户字段名
               */
              @Override
              public String getTenantIdColumn() {
                return "tenant_id";
              }

              /**
               * 根据表名判断是否忽略拼接多租户条件
               *
               * <p>默认都要进行解析并拼接多租户条件
               *
               * @param tableName 表名
               * @return 是否忽略, true:表示忽略，false:需要解析并拼接多租户条件 可 以加上咱们的satoken的判断账户平台还是啥 如果是平台
               *     所有加了tenlent的id都不自动拼接 并且平台超管的角色编码也可以用Root这个来作为
               */
              @Override
              public boolean ignoreTable(String tableName) {
                HttpServletRequest request =
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                        .getRequest();
                String requestURI = request.getRequestURI();
                if (requestURI.contains("/sys/user/login")) {
                  return true;
                }

                // 租户平台过来的数据全部需要拼接（mp的sql解析会根据表字段中有没有租户id字段来解析拼接，没有租户id的表，租户查询也不会拼接id）
                //                return "sys_menu".equalsIgnoreCase(tableName);
                return false;
              }
            }));

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
