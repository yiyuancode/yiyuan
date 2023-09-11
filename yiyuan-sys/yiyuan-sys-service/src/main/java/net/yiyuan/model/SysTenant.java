package net.yiyuan.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.common.constatnt.CustomSqlCondition;
import net.yiyuan.enums.SysTenantIsDelEnum;
import net.yiyuan.enums.SysTenantStatusEnum;

import java.io.Serializable;
import java.util.Date;
/**
 * 商户实体
 *
 * @author 一源团队-花和尚
 * @date 2023-09-08
 */
@Data
public class SysTenant implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 商户id
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * 归属区域
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String spmShopCityId;

  /**
   * 商户名称
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String name;

  /**
   * 法人名称
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String legalPersonName;

  /**
   * 联系邮箱
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String email;

  /**
   * 联系手机
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String phone;

  /**
   * 详细地址
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String detailedAddress;

  /**
   * 统一社会信用代码
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String socialCreditCode;

  /**
   * 营业执照电子版
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String businessLicenseImage;

  /**
   * 法人身份证正面
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String legalPersonIdFrontImage;

  /**
   * 法人身份证反面
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String legalPersonIdBackImage;

  /**
   * 申请备注
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String remark;

  /**
   * 入驻状态#0=待审核|1=通过|2=被驳回
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private SysTenantStatusEnum status;

  /**
   * 排序
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Integer sort;

  /**
   * 逻辑删除标记#0=未删除|1=已删除
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private SysTenantIsDelEnum isDel;

  /**
   * 创建时间
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  /**
   * 创建时间(查询开始时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @TableField(value = "create_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @TableField(value = "create_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date createTimeEnd;

  /**
   * 更新时间
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
  /**
   * 更新时间(查询开始时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @TableField(value = "update_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date updateTimeStart;
  /**
   * 更新时间(查询结束时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @TableField(value = "update_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date updateTimeEnd;

  /**
   * 创建人
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @TableField(fill = FieldFill.INSERT)
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private String updateUser;
}
