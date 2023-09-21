package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 商品管理-是否加入审核枚举类
 *
 * @author 一源-花和尚
 * @date 2023-09-21
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum PtmProductIsAuditEnum implements IEnum<Integer> {

  /**
   * 是否加入审核#0=正常|1=审核流程中
   *
   * @see PtmProductIsAuditEnum
   * @author 一源-花和尚
   * @date 2023-09-21
   */
  NORMAL(0, "正常"),
  /**
   * 是否加入审核#0=正常|1=审核流程中
   *
   * @see PtmProductIsAuditEnum
   * @author 一源-花和尚
   * @date 2023-09-21
   */
  IN_THE_REVIEW_PROCESS(1, "审核流程中");

  @EnumValue private final int value;
  private final String desc;
  PtmProductIsAuditEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
