package net.yiyuan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.enums.SpmShopIsDelEnum;
import net.yiyuan.enums.SpmShopIsShowEnum;
import net.yiyuan.enums.SpmShopSettlementTypeEnum;
import net.yiyuan.enums.SpmShopSupportsSelfPickupEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 店铺分页接口请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Data
public class SpmShopPageDTO implements Serializable {
  /**
   * 分页条数
   *
   * @mock 10
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @NotNull(message = "分页条数不能为空")
  private Integer pageSize;
  /**
   * 分页页数
   *
   * @mock 1
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @NotNull(message = "分页页数不能为空")
  private Integer pageNum;

  /**
   * 店铺id
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String id;

  /**
   * 店铺类型id
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String spmShopTypeId;

  /**
   * 地址id
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String sysAreaId;

  /**
   * 商户名称
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String merchantName;

  /**
   * 商户邮箱
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String merchantEmail;

  /**
   * 商户手机号
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String merchantPhone;

  /**
   * 商户法人
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String merchantLegalRepresentative;

  /**
   * 商户分类
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String merchantCategory;

  /**
   * 商户类别
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String merchantType;

  /**
   * 商户手续费
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private BigDecimal merchantFee;

  /**
   * 商户星级
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private Integer merchantRating;

  /**
   * 资质图片
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String qualificationImages;

  /**
   * 店铺名称
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String shopName;

  /**
   * 店铺主头像
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String shopOwnerAvatar;

  /**
   * 店铺背景图
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String shopBackgroundImage;

  /**
   * 推荐店铺背景图
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String recommendedShopBackgroundImage;

  /**
   * 店铺封面图
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String shopCover;

  /**
   * 店铺logo
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String shopLogo;

  /**
   * 店铺简介
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String shopDescription;

  /**
   * 店铺类型
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String shopType;

  /**
   * 库存告警阈值
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private Integer inventoryAlert;

  /**
   * 是否支持自提#1=是|2=否
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private SpmShopSupportsSelfPickupEnum supportsSelfPickup;

  /**
   * 店铺地址
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String shopAddress;

  /**
   * 结算类型#1=银行卡|2=微信|3=支付宝
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private SpmShopSettlementTypeEnum settlementType;

  /**
   * 银行卡结算-收款人
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String bankPayee;

  /**
   * 银行卡结算-开户银行
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String bankNumber;

  /**
   * 银行卡结算-开户行地址
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String bankAddress;

  /**
   * 微信结算-真实姓名
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String wechatRealName;

  /**
   * 微信结算-微信号
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String wechatAccount;

  /**
   * 微信结算-收款二维码
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String wechatQrCode;

  /**
   * 支付宝结算-真实姓名
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String alipayRealName;

  /**
   * 支付宝结算-微信号
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String alipayAccount;

  /**
   * 支付宝结算-收款二维码
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String alipayQrCode;

  /**
   * 排序
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private Integer sort;

  /**
   * 显示状态#0=不显示|1=显示
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private SpmShopIsShowEnum isShow;

  /**
   * 是否删除#0=未删除|1=已删除
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private SpmShopIsDelEnum isDel;

  /**
   * 创建时间(查询开始时间)
   *
   * @see Date
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @see Date
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeEnd;

  /**
   * 修改时间(查询开始时间)
   *
   * @see Date
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @see Date
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeEnd;

  /**
   * 创建人
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String updateUser;
}
