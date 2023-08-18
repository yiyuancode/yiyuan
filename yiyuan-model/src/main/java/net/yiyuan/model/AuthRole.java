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
 * 角色实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
@Data
public class AuthRole implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 主键ID
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * 角色中文名称(可以修改)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String name;

  /**
   * 角色英文编码(例如Root等，无法修改,satoken会用)唯一性
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String code;

  /**
   * 角色备注
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String roleDesc;

  /**
   * 所属部门
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String deptId;

  /**
   * 数据权限范围(部门id集合)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String deptScope;

  /**
   * 所属租户
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.EQUAL)
  private String tenantId;

  /**
   * 创建时间
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  /**
   * 创建时间(查询开始时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(value = "create_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(value = "create_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date createTimeEnd;

  /**
   * 修改时间
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
  /**
   * 修改时间(查询开始时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(value = "update_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(value = "update_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date updateTimeEnd;

  /**
   * 创建人
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(fill = FieldFill.INSERT)
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private String updateUser;
}
