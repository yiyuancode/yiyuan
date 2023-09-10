package net.yiyuan.common.exception;

import net.yiyuan.common.constatnt.ResultCode;

public class BusinessException extends RuntimeException {
  private Long code;

  public BusinessException(Long code, String message) {
    super(message);
    this.code = code;
  }

  public BusinessException(String message) {
    super(message);
    this.code = 500L;
  }

  public BusinessException(ResultCode resultCode) {
    super(resultCode.getMessage());
    this.code = resultCode.getCode();
  }

  public Long getCode() {
    return code;
  }
}
