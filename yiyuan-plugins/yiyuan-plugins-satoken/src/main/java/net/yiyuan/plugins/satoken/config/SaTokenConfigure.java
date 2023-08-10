package net.yiyuan.plugins.satoken.config;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.context.model.SaRequest;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpLogic;
import cn.dev33.satoken.strategy.SaStrategy;
import cn.dev33.satoken.util.SaFoxUtil;
import cn.dev33.satoken.util.SaResult;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SaToken配置bean
 *
 * @author 一源团队-花和尚
 * @date 2023/06/23
 */
@Slf4j
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

  /**
   * 得到stp逻辑jwt
   *
   * @return {@link StpLogic }
   * @author 一源团队-花和尚
   * @date 2023/06/23
   */
  @Bean
  public StpLogic getStpLogicJwt() {
    return new StpLogicJwtForSimple();
  }

  /**
   * 添加拦截器
   *
   * @param registry 注册表
   * @author 一源团队-花和尚
   * @date 2023/06/23
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 使用注解式健权限
    // 注册 Sa-Token 拦截器，打开注解式鉴权功能
    registry.addInterceptor(new SaInterceptor()).addPathPatterns("/**");
  }

  /**
   * 重写Sa-Token默认的注解处理器,增加自定义注解处理user表的鉴权
   *
   * @author 一源团队-花和尚
   * @date 2023/06/23
   */
  @Autowired
  public void rewriteSaStrategy() {
    // 重写Sa-Token的注解处理器，增加注解合并功能
    SaStrategy.me.getAnnotation =
        (element, annotationClass) -> {
          return AnnotatedElementUtils.getMergedAnnotation(element, annotationClass);
        };
  }

  /** 注册 [Sa-Token全局过滤器] */
  @Bean
  public SaServletFilter getSaServletFilter() {
    //// 根据 path 路由排除匹配
    //// 功能说明: 使用 .html , .css 或者 .js 结尾的任意路由都将跳过, 不会进入 check 方法
    // SaRouter.match("/**").notMatch("*.html", "*.css", "*.js").check( /* 要执行的校验函数 */ );
    return new SaServletFilter()

        // 指定 所有拦截路由
        .addInclude("/**")
        // 前置函数：在每次认证函数之前执行
        .setBeforeAuth(r -> {})

        // 认证函数: 每次请求执行,只要不发生异常就会自己放行, 如果发生意外进入setError回调
        .setAuth(
            obj -> {

              // 功能说明: 使用 .html , .css 或者 .js 结尾的任意路由都将跳过, 不会进入 check 方法,放行
              String url = SaHolder.getRequest().getUrl();
              boolean match = SaRouter.isMatch("druid", url);

              SaRouter.match("/**")
                  .notMatch("/druid/**")
                  .notMatch("/druid")
                  .notMatch("*.html*", "*.css*", "*.js*", "*swagger*", "*api-docs*", "druid")
                  //                  .notMatch("*druid*")
                  .check(
                      () -> {
                        SaRequest request = SaHolder.getRequest();
                        // platform 平台区分 0 平台  1 租户 2 c端
                        String platform = request.getHeader("platform");
                        String tenantId = request.getHeader("tenantId");

                        log.info("---------- 头部信息：平台信息{}  租户信息{} -----------", platform, tenantId);
                        String requestUrl = request.getUrl();
                        if (!requestUrl.contains(".html")
                            && !requestUrl.contains(".css")
                            && !requestUrl.contains(".js")
                            && !requestUrl.contains("swagger")
                            && !requestUrl.contains("api-docs")) {
                          if (StrUtil.isEmpty(platform)) {
                            throw new Error("缺少平台类型");
                          }
                          if (SaFoxUtil.equals("1", platform) && SaFoxUtil.isEmpty(tenantId)) {
                            throw new Error("缺少租户ID");
                          }
                        } else {

                        }
                      });

              // 更多拦截处理方式，请参考“路由拦截式鉴权”章节 */
            })

        // 异常处理函数：每次认证函数发生异常时执行此函数
        .setError(
            e -> {
              log.error("Sa-Token鉴权异常");
              return SaResult.error(e.getMessage());
            }); // 前置函数：在每次认证函数之前执行（BeforeAuth 不受 includeList 与 excludeList 的限制，所有请求都会进入）
    //        .setBeforeAuth(
    //            r -> {
    //              // ---------- 设置一些安全响应头 ----------
    //              SaHolder.getResponse()
    ////                  // 服务器名称
    ////                  .setServer("sa-server")
    //                  // 是否可以在iframe显示视图： DENY=不可以 | SAMEORIGIN=同域下可以 | ALLOW-FROM uri=指定域名下可以
    //                  .setHeader("TRACEID", TLogContext.getTraceId());
    //            });
  }
}
