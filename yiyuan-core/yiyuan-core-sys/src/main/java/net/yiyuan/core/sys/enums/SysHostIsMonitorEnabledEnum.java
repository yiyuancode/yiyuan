package net.yiyuan.core.sys.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 主机记录表-开启监控枚举类
 *
 * @author 一源团队--花和尚
 * @date 2023-07-16
 */
public enum SysHostIsMonitorEnabledEnum {

  /**
   * 开启监控#0=开启|1=关闭|
   *
   * @see SysHostIsMonitorEnabledEnum
   * @author 一源团队--花和尚
   * @date 2023-07-16
   */
  OPEN(0, "开启"),
  /**
   * 开启监控#0=开启|1=关闭|
   *
   * @see SysHostIsMonitorEnabledEnum
   * @author 一源团队--花和尚
   * @date 2023-07-16
   */
  SHUT_DOWN(1, "关闭");

  @EnumValue private final int code;
  @JsonValue private final String desc;
  SysHostIsMonitorEnabledEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
