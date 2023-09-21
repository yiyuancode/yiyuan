package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 商品管理-是否删除枚举类
 *
 * @author 一源-花和尚
 * @date 2023-09-22
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum PtmProductIsDelEnum implements IEnum<Integer> {

  /**
   * 是否删除#0=否|1=是
   *
   * @see PtmProductIsDelEnum
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  NO(0, "否"),
  /**
   * 是否删除#0=否|1=是
   *
   * @see PtmProductIsDelEnum
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  YES(1, "是");

  @EnumValue private final int value;
  private final String desc;

  PtmProductIsDelEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
