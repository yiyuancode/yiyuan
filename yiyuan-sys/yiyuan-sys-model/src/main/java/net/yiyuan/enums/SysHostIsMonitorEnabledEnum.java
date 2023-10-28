package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 服务器管理-开启监控枚举类
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum SysHostIsMonitorEnabledEnum implements IEnum<Integer> {

  /**
   * 开启监控#0=开启|1=关闭|
   *
   * @see SysHostIsMonitorEnabledEnum
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  OPEN(0, "开启"),
  /**
   * 开启监控#0=开启|1=关闭|
   *
   * @see SysHostIsMonitorEnabledEnum
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  CLOSE(1, "关闭");

  @EnumValue private final int value;
  private final String desc;

  SysHostIsMonitorEnabledEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
