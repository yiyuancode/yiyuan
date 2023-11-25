package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 菜单管理-是否缓存枚举类
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
//@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum SysMenuIsCacheEnum implements IEnum<Integer> {

  /**
   * 是否缓存#0=否|1=是
   *
   * @see SysMenuIsCacheEnum
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  NO(0, "否"),
  /**
   * 是否缓存#0=否|1=是
   *
   * @see SysMenuIsCacheEnum
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  YES(1, "是");

  @JsonValue @EnumValue private final int value;
  private final String desc;

  SysMenuIsCacheEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}