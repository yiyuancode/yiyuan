package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.SysTenantInfoServiceTypeEnum;
import net.yiyuan.enums.SysTenantInfoSettlementTypeEnum;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 租户信息修改接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
@Data
public class SysTenantInfoEditDTO implements Serializable {

  /**
   * 租户信息ID
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @NotBlank(message = "租户信息ID不能为空")
  private String id;

  /**
   * 结算类型#0=银行卡|1=微信|2=支付宝
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private SysTenantInfoSettlementTypeEnum settlementType;

  /**
   * 持卡人姓名
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String cardholderName;

  /**
   * 银行名称
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String cardholderBank;

  /**
   * 银行卡号
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String cardholderNo;

  /**
   * 开户地址
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String bankAddress;

  /**
   * 微信号
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String wechatCode;

  /**
   * 微信收款二维码
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String wechatQrcodeUrl;

  /**
   * 支付宝账号
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String alipayCode;

  /**
   * 支付宝收款二维码
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String alipayQrcodeUrl;

  /**
   * 警戒库存
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private Integer alertStock;

  /**
   * 客服类型#0=H5链接|1=电话
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private SysTenantInfoServiceTypeEnum serviceType;

  /**
   * 客服H5链接
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String serviceLink;

  /**
   * 客服电话
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String servicePhone;

  /**
   * 真实姓名
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String realName;

  /**
   * 租户ID
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private Integer tenantId;
}
