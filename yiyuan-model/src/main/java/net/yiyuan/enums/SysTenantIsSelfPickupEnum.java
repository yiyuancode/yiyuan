package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 租户管理-商品自提枚举类
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum SysTenantIsSelfPickupEnum implements IEnum<Integer> {

  /**
   * 商品自提#0=不自提|1=自提
   *
   * @see SysTenantIsSelfPickupEnum
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  NO_SELF_PICKUP(0, "不自提"),
  /**
   * 商品自提#0=不自提|1=自提
   *
   * @see SysTenantIsSelfPickupEnum
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  SELF_PICKUP(1, "自提");

  @EnumValue private final int value;
  private final String desc;

  SysTenantIsSelfPickupEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
