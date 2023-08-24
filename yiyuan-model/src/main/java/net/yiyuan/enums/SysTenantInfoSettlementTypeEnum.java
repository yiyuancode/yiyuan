package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 租户信息管理-结算类型枚举类
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum SysTenantInfoSettlementTypeEnum implements IEnum<Integer> {

  /**
   * 结算类型#0=银行卡|1=微信|2=支付宝
   *
   * @see SysTenantInfoSettlementTypeEnum
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  BANK_CARD(0, "银行卡"),
  /**
   * 结算类型#0=银行卡|1=微信|2=支付宝
   *
   * @see SysTenantInfoSettlementTypeEnum
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  WECHAT(1, "微信"),
  /**
   * 结算类型#0=银行卡|1=微信|2=支付宝
   *
   * @see SysTenantInfoSettlementTypeEnum
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  ALIPAY(2, "支付宝");

  @EnumValue private final int value;
  private final String desc;

  SysTenantInfoSettlementTypeEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
