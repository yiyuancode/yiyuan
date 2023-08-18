package net.yiyuan.tenant;

import com.yomahub.tlog.core.enhance.bytes.AspectLogEnhance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.UnknownHostException;

// 开启注解事务
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {"net.yiyuan"})
@Slf4j
public class TenantApplication {
  // 进行日志增强，自动判断日志框架
  static {
    AspectLogEnhance.enhance();
  }

  public static void main(String[] args) throws UnknownHostException {
    // 启动类
    ConfigurableApplicationContext application =
        SpringApplication.run(TenantApplication.class, args);
    // 打印基础信息
    info(application);
  }

  static void info(ConfigurableApplicationContext application) throws UnknownHostException {
    log.info(
        "\n----------------------------------------------------------\n\t"
            + "租户端启动完成，欢迎访问  \thttps://www.yicode.net\n\t"
            + "----------------------------------------------------------");
  }
}
