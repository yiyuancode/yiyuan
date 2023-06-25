package net.yiyuan.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.net.UnknownHostException;

@SpringBootApplication(scanBasePackages = {"net.yiyuan"})
@Slf4j
public class AdminApplication {
  public static void main(String[] args) throws UnknownHostException {
    // 启动类
    ConfigurableApplicationContext application =
        SpringApplication.run(AdminApplication.class, args);
    // 打印基础信息
    info(application);
  }

  static void info(ConfigurableApplicationContext application) throws UnknownHostException {
    log.info(
        "\n----------------------------------------------------------\n\t"
            + "admin模块启动完成，欢迎访问  \thttps://www.yicode.net\n\t"
            + "----------------------------------------------------------");
  }
}
