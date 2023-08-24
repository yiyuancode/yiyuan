package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 租户修改接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
@Data
public class SysTenantEditDTO implements Serializable {

  /**
   * 租户id
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @NotBlank(message = "租户id不能为空")
  private String id;

  /**
   * 租户店铺分类id
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String tenantCategoryId;

  /**
   * 租户分类id
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String tenantTypeId;

  /**
   * 租户名称
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String name;

  /**
   * 租户法人
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String loard;

  /**
   * 租户邮箱
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String email;

  /**
   * 租户手机号
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String phone;

  /**
   * 平台手续费
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private Integer transFee;

  /**
   * 租户地址
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String address;

  /**
   * 租户地理位置坐标
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String location;

  /**
   * 是否自营#0=非自营|1=自营
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private SysTenantIsSelfEnum isSelf;

  /**
   * 是否推荐#0=不推荐|1=推荐
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private SysTenantIsRecomeEnum isRecome;

  /**
   * 商户开关#0=未关闭|1=关闭
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private SysTenantIsCloseEnum isClose;

  /**
   * 商品是否审核#0=不审核|1=审核
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private SysTenantIsProductAuditEnum isProductAudit;

  /**
   * 商品自提#0=不自提|1=自提
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private SysTenantIsSelfPickupEnum isSelfPickup;

  /**
   * 租户备注，管理端显示
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String note;

  /**
   * 租户资质图片
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String credential;

  /**
   * 租户背景图
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String background;

  /**
   * 租户头像
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String avatar;

  /**
   * 租户logo
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String rectangleLogo;

  /**
   * 租户封面图
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String coverImage;

  /**
   * 租户排行背景图
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String rankingBackground;

  /**
   * 租户简介，商城显示
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String overview;

  /**
   * 租户余额
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private BigDecimal balance;

  /**
   * 租户星级
   *
   * @mock 3
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private Byte starLevel;

  /**
   * pc商城banner
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String bannerPc;

  /**
   * pc商城背景图
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private byte[] groundImagePc;

  /**
   * 排序
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private Byte sort;

  /**
   * 创建类型#0=平台创建|1=自主申请
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private SysTenantCreateTypeEnum createType;

  /**
   * 创建者id
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private Integer createdId;

  /**
   * 商城标记#0=未删除|1=已删除
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private SysTenantIsDelEnum isDel;
}
