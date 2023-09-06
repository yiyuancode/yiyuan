package net.yiyuan.common.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by wuwf on 17/4/27. 日志切面 让AOP日志处理类实现Ordered
 * 接口，并重写getOrder()方法，使其返回值为1，返回值越小，执行的顺序越靠前，使其执行顺序优先于全部异常处理类。
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

  //  private Logger logger = LoggerFactory.getLogger(getClass().getName());
  private ObjectError error;

  @Pointcut("execution(public * net.yiyuan.controller.*.*(..))")
  public void webLog() {}

  @Before("webLog()")
  public void doBefore(JoinPoint joinPoint) throws Throwable {

    // 开始打印请求日志
    ServletRequestAttributes attributes =
        (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();
    Signature signature = joinPoint.getSignature();
    String name = signature.getName();

    // 打印前端请求信息
    log.info("=== 开始 ===");
    log.info("请求地址: {} {}", request.getRequestURL().toString(), request.getMethod());
    log.info("类名方法: {}.{}", signature.getDeclaringTypeName(), name);
    log.info("远程地址: {}", request.getRemoteAddr());

    // 打印请求参数
    Object[] args = joinPoint.getArgs();

    Object[] arguments = new Object[args.length];
    for (int i = 0; i < args.length; i++) {
      if (args[i] instanceof ServletRequest
          || args[i] instanceof ServletResponse
          || args[i] instanceof MultipartFile) {
        continue;
      }
      arguments[i] = args[i];
    }

    // 当某些字段太敏感，或者是太长时，就不显示
    String[] excludeProperties = {"password", "file"};
    SimplePropertyPreFilter filters = new SimplePropertyPreFilter();
    for (String str : excludeProperties) {
      filters.getExcludes().add(str);
    }
    log.info("请求的参数: {}", JSON.toJSONString(arguments, filters));
  }

  @Around("webLog()")
  public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    long startTime = System.currentTimeMillis();
    Object result = proceedingJoinPoint.proceed();

    // 当某些字段太敏感，或者是太长时，就不显示
    String[] excludeProperties = {"password", "file"};
    SimplePropertyPreFilter filters = new SimplePropertyPreFilter();
    for (String str : excludeProperties) {
      filters.getExcludes().add(str);
    }
    log.info("返回的结果: {}", JSON.toJSONString(result, filters));
    log.info("=== 结束时，总耗时：{} ms ===", System.currentTimeMillis() - startTime);
    return result;
  }

  /**
   * 使用 Nginx 进行反向代理，这个方法主要是用来获取远程 IP
   *
   * @param request
   * @return
   */
  public String getRemoteIp(HttpServletRequest request) {
    String ip = request.getHeader("x-forwarded-for");
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getRemoteAddr();
    }
    return ip;
  }

  //  @Before("webLog()")
  //  public void deBefore(JoinPoint joinPoint) throws Throwable {
  //    // 接收到请求，记录请求内容
  //    ServletRequestAttributes attributes =
  //        (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
  //    HttpServletRequestWrapper request = (HttpServletRequestWrapper) attributes.getRequest();
  //    //   log.info("-------------------用户发起请求-----------------");
  //    // 记录下请求内容
  //   log.info("URL : " + request.getRequestURL().toString());
  //   log.info("HTTP_METHOD : " + request.getMethod());
  //    // 如果是表单，参数值是普通键值对。如果是application/json，则request.getParameter是取不到的。
  //   log.info("HTTP_HEAD Type : " + request.getHeader("Content-Type"));
  //   log.info("IP : " + request.getRemoteAddr());
  //   log.info(
  //        "CLASS_METHOD : "
  //            + joinPoint.getSignature().getDeclaringTypeName()
  //            + "."
  //            + joinPoint.getSignature().getName());
  //
  //    if ("application/json".equals(request.getHeader("Content-Type"))) {
  //      // 记录application/json时的传参，SpringMVC中使用@RequestBody接收的值
  //     log.info(JSONObject.toJSONString(getRequestPayload(request)));
  //    } else {
  //      // 记录请求的键值对
  //     log.info("请求参数 : " + JSONObject.toJSONString(request.getParameterMap()));
  //    }
  //  }
  //
  //  @AfterReturning(returning = "ret", pointcut = "webLog()")
  //  public void doAfterReturning(Object ret) throws Throwable {
  //    // 处理完请求，返回内容
  //   log.info("方法的返回值 : " + JSONObject.toJSONString(ret));
  //   log.info("------------------请求结束------------------");
  //  }
  //
  //  // 后置异常通知
  //  @AfterThrowing(throwing = "ex", pointcut = "webLog()")
  //  public void throwss(JoinPoint jp, Exception ex) {
  //   log.error("方法异常时执行{}", ex.getMessage());
  //  }
  //
  //  // 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
  //  @After("webLog()")
  //  public void after(JoinPoint jp) {
  //    //       log.info("方法最后执行.....");
  //  }
  //
  //  private String getRequestPayload(HttpServletRequestWrapper req) {
  //    StringBuilder sb = new StringBuilder();
  //    try (BufferedReader reader = req.getReader()) {
  //      char[] buff = new char[1024];
  //      int len;
  //      while ((len = reader.read(buff)) != -1) {
  //        sb.append(buff, 0, len);
  //      }
  //    } catch (IOException e) {
  //      e.printStackTrace();
  //    }
  //    return sb.toString();
  //  }
  //
  //  //  private String getRequestBody(HttpServletRequest request) {
  //  //    int contentLength = request.getContentLength();
  //  //    if (contentLength <= 0) {
  //  //      return "";
  //  //    }
  //  //    try {
  //  //      return IOUtils.toString(request.getReader());
  //  //    } catch (IOException e) {
  //  //     log.error("获取请求体失败", e);
  //  //      return "";
  //  //    }
  //  //  }
}
