package net.yiyuan.service;

import net.yiyuan.common.model.vo.CommonResult;

public interface SmsAndEmailService {

  /**
   * 获取验证码
   *
   * @param phoneOrEmail
   * @return
   */
  CommonResult<String> verifySms(String phoneOrEmail) throws Exception;

  /**
   * 验证验证码是否正确
   *
   * @param phoneOrEmail
   * @param code
   * @return
   */
  boolean checkSmsCode(String phoneOrEmail, String code);
}
