package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 菜单管理-meta部分:打开方式枚举类
 *
 * @author 一源-花和尚
 * @date 2023-09-26
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
//@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum SysMenuOpenTypeEnum implements IEnum<Integer> {

  /**
   * meta部分:打开方式#0=当前窗口|1=新窗口
   *
   * @see SysMenuOpenTypeEnum
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  CURRENT_WINDOW(0, "当前窗口"),
  /**
   * meta部分:打开方式#0=当前窗口|1=新窗口
   *
   * @see SysMenuOpenTypeEnum
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  NEW_WINDOW(1, "新窗口");

  @JsonValue @EnumValue private final int value;
  private final String desc;

  SysMenuOpenTypeEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
