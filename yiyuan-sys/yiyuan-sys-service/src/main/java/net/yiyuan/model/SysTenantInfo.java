package net.yiyuan.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.common.constatnt.CustomSqlCondition;
import net.yiyuan.enums.SysTenantInfoServiceTypeEnum;
import net.yiyuan.enums.SysTenantInfoSettlementTypeEnum;

import java.io.Serializable;
import java.util.Date;
/**
 * 租户信息实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
@Data
public class SysTenantInfo implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 租户信息ID
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * 结算类型#0=银行卡|1=微信|2=支付宝
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private SysTenantInfoSettlementTypeEnum settlementType;

  /**
   * 持卡人姓名
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String cardholderName;

  /**
   * 银行名称
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String cardholderBank;

  /**
   * 银行卡号
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String cardholderNo;

  /**
   * 开户地址
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String bankAddress;

  /**
   * 微信号
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String wechatCode;

  /**
   * 微信收款二维码
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String wechatQrcodeUrl;

  /**
   * 支付宝账号
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String alipayCode;

  /**
   * 支付宝收款二维码
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String alipayQrcodeUrl;

  /**
   * 警戒库存
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Integer alertStock;

  /**
   * 客服类型#0=H5链接|1=电话
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private SysTenantInfoServiceTypeEnum serviceType;

  /**
   * 客服H5链接
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String serviceLink;

  /**
   * 客服电话
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String servicePhone;

  /**
   * 真实姓名
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String realName;

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

  /**
   * 租户ID
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.EQUAL)
  private Integer tenantId;
}
