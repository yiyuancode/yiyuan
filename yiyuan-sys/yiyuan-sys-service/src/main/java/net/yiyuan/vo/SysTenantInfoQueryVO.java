package net.yiyuan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.enums.SysTenantInfoServiceTypeEnum;
import net.yiyuan.enums.SysTenantInfoSettlementTypeEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 租户信息查询请求响应参数实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
@Data
public class SysTenantInfoQueryVO implements Serializable {

  /**
   * 租户信息ID
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String id;

  /**
   * 结算类型#0=银行卡|1=微信|2=支付宝
   *
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
   * 创建时间
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  /**
   * 更新时间
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;

  /**
   * 创建人
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String updateUser;

  /**
   * 租户ID
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private Integer tenantId;
}
