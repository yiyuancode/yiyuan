package net.yiyuan.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.common.constatnt.CustomSqlCondition;
import net.yiyuan.enums.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 租户实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
@Data
public class SysTenant implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 租户id
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * 租户店铺分类id
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String tenantCategoryId;

  /**
   * 租户分类id
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String tenantTypeId;

  /**
   * 租户名称
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String name;

  /**
   * 租户法人
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String loard;

  /**
   * 租户邮箱
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String email;

  /**
   * 租户手机号
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String phone;

  /**
   * 平台手续费
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Integer transFee;

  /**
   * 租户地址
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String address;

  /**
   * 租户地理位置坐标
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String location;

  /**
   * 是否自营#0=非自营|1=自营
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private SysTenantIsSelfEnum isSelf;

  /**
   * 是否推荐#0=不推荐|1=推荐
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private SysTenantIsRecomeEnum isRecome;

  /**
   * 商户开关#0=未关闭|1=关闭
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private SysTenantIsCloseEnum isClose;

  /**
   * 商品是否审核#0=不审核|1=审核
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private SysTenantIsProductAuditEnum isProductAudit;

  /**
   * 商品自提#0=不自提|1=自提
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private SysTenantIsSelfPickupEnum isSelfPickup;

  /**
   * 租户备注，管理端显示
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String note;

  /**
   * 租户资质图片
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String credential;

  /**
   * 租户背景图
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String background;

  /**
   * 租户头像
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String avatar;

  /**
   * 租户logo
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String rectangleLogo;

  /**
   * 租户封面图
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String coverImage;

  /**
   * 租户排行背景图
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String rankingBackground;

  /**
   * 租户简介，商城显示
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String overview;

  /**
   * 租户余额
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private BigDecimal balance;

  /**
   * 租户星级
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Byte starLevel;

  /**
   * pc商城banner
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String bannerPc;

  /**
   * pc商城背景图
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private byte[] groundImagePc;

  /**
   * 排序
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Byte sort;

  /**
   * 创建类型#0=平台创建|1=自主申请
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private SysTenantCreateTypeEnum createType;

  /**
   * 创建者id
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Integer createdId;

  /**
   * 商城标记#0=未删除|1=已删除
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private SysTenantIsDelEnum isDel;

  /**
   * 创建时间
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  /**
   * 创建时间(查询开始时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(value = "create_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(value = "create_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date createTimeEnd;

  /**
   * 更新时间
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
  /**
   * 更新时间(查询开始时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(value = "update_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date updateTimeStart;
  /**
   * 更新时间(查询结束时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(value = "update_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date updateTimeEnd;

  /**
   * 创建人
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(fill = FieldFill.INSERT)
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private String updateUser;
}
