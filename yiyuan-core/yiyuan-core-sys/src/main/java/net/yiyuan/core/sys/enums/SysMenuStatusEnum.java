package net.yiyuan.core.sys.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 菜单表-菜单状态枚举类
 *
 * @author 一源团队--花和尚
 * @date 2023-07-14
 */
public enum SysMenuStatusEnum {

  /**
   * 菜单状态#0=停用|1=正常
   *
   * @see SysMenuStatusEnum
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  DISABLE(0, "停用"),
  /**
   * 菜单状态#0=停用|1=正常
   *
   * @see SysMenuStatusEnum
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  NORMAL(1, "正常");

  @EnumValue private final int code;
  @JsonValue private final String desc;
  SysMenuStatusEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
