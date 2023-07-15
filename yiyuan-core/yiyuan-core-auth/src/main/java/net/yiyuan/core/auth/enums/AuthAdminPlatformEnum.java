package net.yiyuan.core.auth.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 用户表-平台类型枚举类
 *
 * @author 一源团队--花和尚
 * @date 2023-07-15
 */
public enum AuthAdminPlatformEnum {

  /**
   * 平台类型#0=平台端|1=租户端|2=移动端
   *
   * @see AuthAdminPlatformEnum
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  NAME_AND_ADDRESS_OF_FLAT(0, "平台端"),
  /**
   * 平台类型#0=平台端|1=租户端|2=移动端
   *
   * @see AuthAdminPlatformEnum
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  THE_TENANT_SIDE(1, "租户端"),
  /**
   * 平台类型#0=平台端|1=租户端|2=移动端
   *
   * @see AuthAdminPlatformEnum
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  THE_MOBILE_TERMINAL(2, "移动端");

  @EnumValue private final int code;
  @JsonValue private final String desc;

  AuthAdminPlatformEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
