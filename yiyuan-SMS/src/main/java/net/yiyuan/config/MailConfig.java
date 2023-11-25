package net.yiyuan.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class MailConfig {

  @Value("${email.config.define.emailAccount:''}")
  private String emailAccount;

  @Value("${email.config.define.emailPassword:''}")
  private String emailPassword;

  @Value("${email.config.define.emailSmtphost:''}")
  private String emailSmtphost;
}
