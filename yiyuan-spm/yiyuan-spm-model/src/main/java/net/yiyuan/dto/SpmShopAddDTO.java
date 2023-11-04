package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.SpmShopSettlementTypeEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 店铺新增接口请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-11-03
 */
@Data
public class SpmShopAddDTO implements Serializable {

  /**
   * 店铺类型id
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  @NotBlank(message = "店铺类型id不能为空")
  private String spmShopTypeId;

  /**
   * 店铺主营类目ids(多个用逗号分割,对应商品分类中-平台分类)
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  private String mainCategoryIds;

  /**
   * 地址id
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  @NotBlank(message = "地址id不能为空")
  private String sysAreaId;

  /**
   * 商户名称
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  @NotBlank(message = "商户名称不能为空")
  private String merchantName;

  /**
   * 商户邮箱
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  @NotBlank(message = "商户邮箱不能为空")
  private String merchantEmail;

  /**
   * 商户手机号
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  @NotBlank(message = "商户手机号不能为空")
  private String merchantPhone;

  /**
   * 商户法人
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  @NotBlank(message = "商户法人不能为空")
  private String merchantLegalRepresentative;

  /**
   * 商户手续费
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  @NotNull(message = "商户手续费不能为空")
  private BigDecimal merchantFee;

  /**
   * 商户星级
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  @NotNull(message = "商户星级不能为空")
  private Integer merchantRating;

  /**
   * 资质图片
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  @NotBlank(message = "资质图片不能为空")
  private String qualificationImages;

  /**
   * 店铺名称
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  @NotBlank(message = "店铺名称不能为空")
  private String shopName;

  /**
   * 店铺主头像
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  @NotBlank(message = "店铺主头像不能为空")
  private String shopOwnerAvatar;

  /**
   * 店铺背景图
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  @NotBlank(message = "店铺背景图不能为空")
  private String shopBackgroundImage;

  /**
   * 推荐店铺背景图
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  @NotBlank(message = "推荐店铺背景图不能为空")
  private String recommendedShopBackgroundImage;

  /**
   * 店铺封面图
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  @NotBlank(message = "店铺封面图不能为空")
  private String shopCover;

  /**
   * 店铺logo
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  @NotBlank(message = "店铺logo不能为空")
  private String shopLogo;

  /**
   * 店铺简介
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  @NotBlank(message = "店铺简介不能为空")
  private String shopDescription;

  /**
   * 库存告警阈值
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  @NotNull(message = "库存告警阈值不能为空")
  private Integer inventoryAlert;

  /**
   * 是否支持自提0=否|1=是
   *
   * @mock 1
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  @NotNull(message = "是否支持自提0=否|1=是不能为空")
  private Boolean isSupportsSelfPickup;

  /**
   * 店铺地址
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  @NotBlank(message = "店铺地址不能为空")
  private String shopAddress;

  /**
   * 结算类型#1=银行卡|2=微信|3=支付宝
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  @NotNull(message = "结算类型#1=银行卡|2=微信|3=支付宝不能为空")
  private SpmShopSettlementTypeEnum settlementType;

  /**
   * 银行卡结算-收款人
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  private String bankPayee;

  /**
   * 银行卡结算-开户银行
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  private String bankNumber;

  /**
   * 银行卡结算-开户行地址
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  private String bankAddress;

  /**
   * 微信结算-真实姓名
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  private String wechatRealName;

  /**
   * 微信结算-微信号
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  private String wechatAccount;

  /**
   * 微信结算-收款二维码
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  private String wechatQrCode;

  /**
   * 支付宝结算-真实姓名
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  private String alipayRealName;

  /**
   * 支付宝结算-微信号
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  private String alipayAccount;

  /**
   * 支付宝结算-收款二维码
   *
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  private String alipayQrCode;

  /**
   * 是否加入审核0=否|1=是
   *
   * @mock 1
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  @NotNull(message = "是否加入审核0=否|1=是不能为空")
  private Boolean isAudit;

  /**
   * 显示状态0=不显示|1=显示
   *
   * @mock 1
   * @author 一源-花和尚
   * @date 2023-11-03
   */
  @NotNull(message = "显示状态0=不显示|1=显示不能为空")
  private Boolean isShow;
}
