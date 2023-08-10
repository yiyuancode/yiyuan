package net.yiyuan.common.aop;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

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

  @Pointcut("execution(public * net.yiyuan.core.*.controller.*.*(..))")
  public void webLog() {}

  @Before("webLog()")
  public void deBefore(JoinPoint joinPoint) throws Throwable {
    // 接收到请求，记录请求内容
    ServletRequestAttributes attributes =
        (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();
    //    log.info("-------------------用户发起请求-----------------");
    // 记录下请求内容
    log.info("URL : " + request.getRequestURL().toString());
    log.info("HTTP_METHOD : " + request.getMethod());
    // 如果是表单，参数值是普通键值对。如果是application/json，则request.getParameter是取不到的。
    log.info("HTTP_HEAD Type : " + request.getHeader("Content-Type"));
    log.info("IP : " + request.getRemoteAddr());
    log.info(
        "CLASS_METHOD : "
            + joinPoint.getSignature().getDeclaringTypeName()
            + "."
            + joinPoint.getSignature().getName());

    if ("application/json".equals(request.getHeader("Content-Type"))) {
      // 记录application/json时的传参，SpringMVC中使用@RequestBody接收的值
      log.info(JSONObject.toJSONString(getRequestPayload(request)));
    } else {
      // 记录请求的键值对
      log.info("请求参数 : " + JSONObject.toJSONString(request.getParameterMap()));
    }
  }

  @AfterReturning(returning = "ret", pointcut = "webLog()")
  public void doAfterReturning(Object ret) throws Throwable {
    // 处理完请求，返回内容
    log.info("方法的返回值 : " + JSONObject.toJSONString(ret));
    log.info("------------------请求结束------------------");
  }

  // 后置异常通知
  @AfterThrowing(throwing = "ex", pointcut = "webLog()")
  public void throwss(JoinPoint jp, Exception ex) {
    log.error("方法异常时执行{}", ex.getMessage());
  }

  // 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
  @After("webLog()")
  public void after(JoinPoint jp) {
    //        log.info("方法最后执行.....");
  }

  private String getRequestPayload(HttpServletRequest req) {
    StringBuilder sb = new StringBuilder();
    try (BufferedReader reader = req.getReader()) {
      char[] buff = new char[1024];
      int len;
      while ((len = reader.read(buff)) != -1) {
        sb.append(buff, 0, len);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return sb.toString();
  }
}
