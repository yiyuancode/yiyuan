package net.yiyuan.smscontext;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.service.SmsAndEmailService;
import net.yiyuan.service.impl.EmailSmsServiceImpl;
import net.yiyuan.service.impl.PhoneSmsServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class SmsOperatorContext {

  @Value("${email.config.define.active}")
  private String active;

  @Resource private EmailSmsServiceImpl emailSmsService;
  @Resource private PhoneSmsServiceImpl phoneSmsService;

  public SmsAndEmailService active() {

    if ("phone".equals(active)) {
      return phoneSmsService;
    }
    if ("email".equals(active)) {
      return emailSmsService;
    }

    return null;
  }
}
