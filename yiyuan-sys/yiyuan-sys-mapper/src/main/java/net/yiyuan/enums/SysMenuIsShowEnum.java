package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 菜单管理-显示状态枚举类
 *
 * @author 一源-花和尚
 * @date 2023-09-26
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum SysMenuIsShowEnum implements IEnum<Integer> {

  /**
   * 显示状态#0=不显示|1=显示
   *
   * @see SysMenuIsShowEnum
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  DO_NOT_DISPLAY(0, "不显示"),
  /**
   * 显示状态#0=不显示|1=显示
   *
   * @see SysMenuIsShowEnum
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  DISPLAY(1, "显示");

  @EnumValue private final int value;
  private final String desc;

  SysMenuIsShowEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
