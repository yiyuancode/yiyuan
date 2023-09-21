package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 商品管理-规格枚举类
 *
 * @author 一源-花和尚
 * @date 2023-09-22
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum PtmProductSpecTypeEnum implements IEnum<Integer> {

  /**
   * 规格#0=单|1=多
   *
   * @see PtmProductSpecTypeEnum
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  SINGLE(0, "单"),
  /**
   * 规格#0=单|1=多
   *
   * @see PtmProductSpecTypeEnum
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  MANY(1, "多");

  @EnumValue private final int value;
  private final String desc;

  PtmProductSpecTypeEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
