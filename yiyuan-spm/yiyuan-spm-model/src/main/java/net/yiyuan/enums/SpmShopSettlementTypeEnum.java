package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * 店铺管理-结算类型枚举类
 *
 * @author 一源-花和尚
 * @date 2023-11-03
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
// //@JsonFormat(shape = JsonFormat.Shape.STRING) // 实现场景2，只需要加上这个注解
public enum SpmShopSettlementTypeEnum implements IEnum<Integer> {

  /**
   * 结算类型#1=银行卡|2=微信|3=支付宝
   *
   * @see SpmShopSettlementTypeEnum
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  BANK_CARD(1, "银行卡"),
  /**
   * 结算类型#1=银行卡|2=微信|3=支付宝
   *
   * @see SpmShopSettlementTypeEnum
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  WECHAT(2, "微信"),
  /**
   * 结算类型#1=银行卡|2=微信|3=支付宝
   *
   * @see SpmShopSettlementTypeEnum
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  ALIPAY(3, "支付宝");
  @JsonValue @EnumValue private final int value;
  private final String desc;

  SpmShopSettlementTypeEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
