package net.yiyuan.core.sys.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 菜单表-固定多页签枚举类
 *
 * @author 一源团队--花和尚
 * @date 2023-07-16
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum SysMenuIsAffixEnum implements IEnum<Integer> {

  /**
   * 固定多页签#0=关闭|1=开启
   *
   * @see SysMenuIsAffixEnum
   * @author 一源团队--花和尚
   * @date 2023-07-16
   */
  SHUT_DOWN(0, "关闭"),
  /**
   * 固定多页签#0=关闭|1=开启
   *
   * @see SysMenuIsAffixEnum
   * @author 一源团队--花和尚
   * @date 2023-07-16
   */
  OPEN(1, "开启");

  @EnumValue private final int value;
  private final String desc;
  SysMenuIsAffixEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
