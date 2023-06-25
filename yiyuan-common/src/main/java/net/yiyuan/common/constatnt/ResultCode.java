package net.yiyuan.common.constatnt;

import net.yiyuan.common.model.vo.IErrorCode;

/** 枚举了一些常用API操作码 Created by macro on 2019/4/19. */
public enum ResultCode implements IErrorCode {
  //  SUCCESS(200, "操作成功"),
  //  FAILED(500, "操作失败"),
  //  VALIDATE_FAILED(404, "参数检验失败"),
  //  UNAUTHORIZED(401, "暂未登录或token已经过期"),
  //  FORBIDDEN(403, "没有相关权限");

  /**
   * 成功状态码
   *
   * @see ResultCode
   * @author 一源团队-花和尚
   * @date 2023/06/24
   */
  SUCCESS(200, "成功"),
  /**
   * 参数错误：10001-19999
   *
   * @see ResultCode
   * @author 一源团队-花和尚
   * @date 2023/06/24
   */
  PARAM_IS_INVALID(10001, "参数错误"),
  /**
   * 未提供token
   *
   * @see ResultCode
   * @author 一源团队-花和尚
   * @date 2023/06/24
   */
  UNAUTHORIZED(10401, "未提供token"),

  /**
   * 用户相关错误：20001-29999
   *
   * @see ResultCode
   * @author 一源团队-花和尚
   * @date 2023/06/24
   */
  USER_NOAUTH(20000, "用户未登录"),
  USER_HAS_EXISTED(20001, "用户名已存在"),
  USER_NOT_FIND(20002, "用户名不存在"),
  USER_PASS_ERROR(20003, "密码不正确"),
  USER_LOCKED(20004, "账户已锁定"),
  USER_PASS_OUT(20005, "用户名或密码错误次数过多"),
  USER_NOTFIND_ERROR(20006, "没有找到用户"),
  USER_ERROR(20007, "用户名或密码不正确"),
  /**
   * 服务未知异常
   *
   * @see ResultCode
   * @author 一源团队-花和尚
   * @date 2023/06/24
   */
  UNKNOWN_ERROR(99999, "服务未知异常");

  private long code;
  private String message;

  private ResultCode(long code, String message) {
    this.code = code;
    this.message = message;
  }

  public long getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
