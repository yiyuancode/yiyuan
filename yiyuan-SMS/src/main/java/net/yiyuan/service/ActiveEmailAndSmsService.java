package net.yiyuan.service;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.smscontext.SmsOperatorContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class ActiveEmailAndSmsService {

  @Resource private SmsOperatorContext smsOperatorContext;

  public CommonResult<String> verifySms(String phoneAndEmail) throws Exception {
    // 获取操作器
    SmsAndEmailService active = smsOperatorContext.active();
    // 执行获取验证码
    return active.verifySms(phoneAndEmail);
  }

  public boolean checkSmsCode(String phoneOrEmail, String code) {

    // 获取操作器
    SmsAndEmailService active = smsOperatorContext.active();

    return active.checkSmsCode(phoneOrEmail, code);
  }
}
