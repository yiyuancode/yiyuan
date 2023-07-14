package net.yiyuan.core.sys.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 租户表-状态枚举类
 *
 * @author 一源团队--花和尚
 * @date 2023-07-14
 */
public enum SysTenantStatusEnum {

  /**
   * 状态#0=正常|1=冻结
   *
   * @see SysTenantStatusEnum
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  NORMAL(0, "正常"),
  /**
   * 状态#0=正常|1=冻结
   *
   * @see SysTenantStatusEnum
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  FREEZE(1, "冻结");

  @EnumValue private final int code;
  @JsonValue private final String desc;
  SysTenantStatusEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
