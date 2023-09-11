package net.yiyuan.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.common.constatnt.CustomSqlCondition;

import java.io.Serializable;
import java.util.Date;
/**
 * 租户类型实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
@Data
public class SysTenantType implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 租户分类id
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * 租户分类名称
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String name;

  /**
   * 租户初始化手续费%
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Integer transFee;

  /**
   * 租户分类删除标记
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Byte isDel;

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
