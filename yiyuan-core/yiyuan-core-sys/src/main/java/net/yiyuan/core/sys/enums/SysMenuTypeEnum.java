package net.yiyuan.core.sys.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 菜单表-类型枚举类
 *
 * @author 一源团队--花和尚
 * @date 2023-07-14
 */
public enum SysMenuTypeEnum {

  /**
   * 类型#0=目录|1=菜单|2=按钮
   *
   * @see SysMenuTypeEnum
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  DIRECTORY(0, "目录"),
  /**
   * 类型#0=目录|1=菜单|2=按钮
   *
   * @see SysMenuTypeEnum
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  THE_MENU(1, "菜单"),
  /**
   * 类型#0=目录|1=菜单|2=按钮
   *
   * @see SysMenuTypeEnum
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  BUTTON(2, "按钮");

  @EnumValue private final int code;
  @JsonValue private final String desc;
  SysMenuTypeEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
