package net.yiyuan.core.sys.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 菜单表-固定多页签枚举类
 *
 * @author 一源团队--花和尚
 * @date 2023-07-15
 */
public enum SysMenuIsAffixEnum {

  /**
   * 固定多页签#0=关闭|1=开启
   *
   * @see SysMenuIsAffixEnum
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  SHUT_DOWN(0, "关闭"),
  /**
   * 固定多页签#0=关闭|1=开启
   *
   * @see SysMenuIsAffixEnum
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  OPEN(1, "开启");

  @EnumValue private final int code;
  @JsonValue private final String desc;

  SysMenuIsAffixEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
