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
   * @author 一源团队-花和尚
   * @date 2023/06/24
   * @see ResultCode
   */
  SUCCESS(200, "成功"),
  /**
   * 参数错误：10001-19999
   *
   * @author 一源团队-花和尚
   * @date 2023/06/24
   * @see ResultCode
   */
  PARAM_IS_INVALID(10001, "参数错误"),
  /**
   * 未提供token
   *
   * @author 一源团队-花和尚
   * @date 2023/06/24
   * @see ResultCode
   */
  UNAUTHORIZED(10401, "未提供token"),

  /**
   * 用户相关错误：20001-29999
   *
   * @author 一源团队-花和尚
   * @date 2023/06/24
   * @see ResultCode
   */
  USER_NOAUTH(500, "用户未登录"),
  USER_HAS_EXISTED(500, "用户名已存在"),
  USER_NOT_FIND(500, "用户名不存在"),
  USER_PASS_ERROR(500, "密码不正确"),
  USER_LOCKED(500, "账户已锁定"),
  USER_PASS_OUT(500, "用户名或密码错误次数过多"),
  USER_NOTFIND_ERROR(500, "没有找到用户"),
  USER_ERROR(500, "用户名或密码不正确"),
  UNBOUND_ROLE(500, "未绑定角色"),
  UNBOUND_MENU(500, "未绑定菜单"),

  /**
   * 定时任务相关：600-699
   *
   * @author 一源团队-花和尚
   * @date 2023/06/24
   * @see ResultCode
   */
  JOB_EXISTS(500, "任务已存在"),

  /**
   * 服务未知异常
   *
   * @author 一源团队-花和尚
   * @date 2023/06/24
   * @see ResultCode
   */
  UNKNOWN_ERROR(500, "服务未知异常"),

  /**
   * 服务未知异常
   *
   * @author 一源团队-花和尚
   * @date 2023/06/24
   * @see ResultCode
   */
  PARAMETER_TO_ENUM_ERROR(500, "无法匹配对应的枚举类型");

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
