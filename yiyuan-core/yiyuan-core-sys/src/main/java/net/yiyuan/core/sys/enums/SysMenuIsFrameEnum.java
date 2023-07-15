package net.yiyuan.core.sys.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 菜单表-外链枚举类
 *
 * @author 一源团队--花和尚
 * @date 2023-07-15
 */
public enum SysMenuIsFrameEnum {

  /**
   * 外链#0=否|1=是
   *
   * @see SysMenuIsFrameEnum
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  NO(0, "否"),
  /**
   * 外链#0=否|1=是
   *
   * @see SysMenuIsFrameEnum
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  IS(1, "是");

  @EnumValue private final int code;
  @JsonValue private final String desc;

  SysMenuIsFrameEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
