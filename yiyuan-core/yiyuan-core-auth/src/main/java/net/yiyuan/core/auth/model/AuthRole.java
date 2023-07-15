package net.yiyuan.core.auth.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.plugins.mp.constant.CustomSqlCondition;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
/**
 * 角色管理实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-15
 */
@Data
public class AuthRole implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 主键ID
   *
   * @date 2023-07-15
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * 角色中文名称(可以修改)
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String name;

  /**
   * 角色英文编码(例如Root等，无法修改,satoken会用)唯一性
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String code;

  /**
   * 角色备注
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String roleDesc;

  /**
   * 所属部门
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String deptId;

  /**
   * 数据权限范围(部门id集合)
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String deptScope;

  /**
   * 所属租户
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String tenantId;

  /**
   * 创建时间
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  /**
   * 创建时间(查询开始时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @TableField(value = "created_time", condition = CustomSqlCondition.GET_EQUAL, select = false)
  private Date createTimeGte;
  /**
   * 创建时间(查询结束时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @TableField(value = "created_time", condition = CustomSqlCondition.LT_EQUAL, select = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeLt;

  /**
   * 修改时间
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
  /**
   * 修改时间(查询开始时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @TableField(value = "created_time", condition = CustomSqlCondition.GET_EQUAL, select = false)
  private Date updateTimeGte;
  /**
   * 修改时间(查询结束时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @TableField(value = "created_time", condition = CustomSqlCondition.LT_EQUAL, select = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeLt;

  /**
   * 创建人
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String createUser;

  /**
   * 修改人
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String updateUser;
}
