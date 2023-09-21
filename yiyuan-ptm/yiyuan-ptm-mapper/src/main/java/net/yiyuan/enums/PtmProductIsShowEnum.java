package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 商品管理-状态枚举类
 *
 * @author 一源-花和尚
 * @date 2023-09-22
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum PtmProductIsShowEnum implements IEnum<Integer> {

  /**
   * 状态#0=未上架|1=上架
   *
   * @see PtmProductIsShowEnum
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  NOT_LISTED(0, "未上架"),
  /**
   * 状态#0=未上架|1=上架
   *
   * @see PtmProductIsShowEnum
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  LISTING(1, "上架");

  @EnumValue private final int value;
  private final String desc;

  PtmProductIsShowEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
