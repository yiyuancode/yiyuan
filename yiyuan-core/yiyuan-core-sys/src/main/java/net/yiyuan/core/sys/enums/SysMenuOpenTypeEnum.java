package net.yiyuan.core.sys.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 菜单表-打开方式枚举类
 *
 * @author 一源团队--花和尚
 * @date 2023-07-15
 */
public enum SysMenuOpenTypeEnum {

  /**
   * 打开方式#0=当前窗口|1=新窗口
   *
   * @see SysMenuOpenTypeEnum
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  THE_CURRENT_WINDOW(0, "当前窗口"),
  /**
   * 打开方式#0=当前窗口|1=新窗口
   *
   * @see SysMenuOpenTypeEnum
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  A_NEW_WINDOW(1, "新窗口");

  @EnumValue private final int code;
  @JsonValue private final String desc;

  SysMenuOpenTypeEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
