package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 菜单管理-菜单状态枚举类
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum SysMenuStatusEnum implements IEnum<Integer> {

  /**
   * 菜单状态#0=停用|1=正常
   *
   * @see SysMenuStatusEnum
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  DEACTIVATE(0, "停用"),
  /**
   * 菜单状态#0=停用|1=正常
   *
   * @see SysMenuStatusEnum
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  NORMAL(1, "正常");

  @EnumValue private final int value;
  private final String desc;

  SysMenuStatusEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
