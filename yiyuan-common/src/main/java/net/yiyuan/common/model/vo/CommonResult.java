package net.yiyuan.common.model.vo;

import net.yiyuan.common.constatnt.ResultCode;

/**
 * 共同结果共同结果 通用返回对象 Created by macro on 2019/4/19. @author 一源-悟空
 *
 * @date 2023/06/20
 * @author 一源-悟空
 */
public class CommonResult<T> {
  /** 代码 */
  private long code;
  /** 消息 */
  private String message;
  /** 数据 */
  private T data;

  protected CommonResult() {}

  protected CommonResult(long code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  /**
   * 成功返回结果
   *
   * @param data 获取的数据
   */
  public static <T> CommonResult<T> success(T data) {
    return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
  }

  /**
   * 成功返回结果
   *
   * @param data 获取的数据
   * @param message 提示信息
   */
  public static <T> CommonResult<T> success(T data, String message) {
    return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);
  }

  /**
   * 失败返回结果
   *
   * @param errorCode 错误码
   */
  public static <T> CommonResult<T> failed(IErrorCode errorCode) {
    return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
  }

  /**
   * 失败返回结果
   *
   * @param errorCode 错误码
   * @param message 错误信息
   */
  public static <T> CommonResult<T> failed(long errorCode, String message) {
    return new CommonResult<T>(errorCode, message, null);
  }
  /**
   * 失败返回结果
   *
   * @param errorCode 错误码
   * @param message 错误信息
   */
  public static <T> CommonResult<T> failed(IErrorCode errorCode, String message) {
    return new CommonResult<T>(errorCode.getCode(), message, null);
  }
  /**
   * 失败返回结果
   *
   * @param message 提示信息
   */
  public static <T> CommonResult<T> failed(String message) {
    return new CommonResult<T>(ResultCode.UNKNOWN_ERROR.getCode(), message, null);
  }

  /** 失败返回结果 */
  public static <T> CommonResult<T> failed() {
    return failed(ResultCode.UNKNOWN_ERROR);
  }

  /** 参数验证失败返回结果 */
  public static <T> CommonResult<T> validateFailed() {
    return failed(ResultCode.PARAM_IS_INVALID);
  }

  /**
   * 参数验证失败返回结果
   *
   * @param message 提示信息
   */
  public static <T> CommonResult<T> validateFailed(String message) {
    return new CommonResult<T>(ResultCode.PARAM_IS_INVALID.getCode(), message, null);
  }

  /** 未登录返回结果 */
  public static <T> CommonResult<T> unauthorized(T data) {
    return new CommonResult<T>(
        ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
  }

  /** 未授权返回结果 */
  public static <T> CommonResult<T> forbidden(T data) {
    return new CommonResult<T>(
        ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
  }

  public long getCode() {
    return code;
  }

  public void setCode(long code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
