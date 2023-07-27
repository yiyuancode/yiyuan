package net.yiyuan.core.auth.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.plugins.mp.constant.CustomSqlCondition;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户_角色管理实体
 *
 * @author 一源团队-花和尚
 * @date 2023-07-27
 */
@Data
public class AuthAdminRole implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 主键
   *
   * @date 2023-07-27
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)

  /**
   * 主键
   *
   * @see String
   * @author 一源团队-花和尚
   * @date 2023-07-27
   */
  private String id;

  /**
   * 用户ID
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String userId;

  /**
   * 角色ID
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String roleId;

  /**
   * 修改时间
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see Date
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
  /**
   * 修改时间(查询开始时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see Date
   */
  @TableField(value = "update_time", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see Date
   */
  @TableField(value = "update_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date updateTimeEnd;

  /**
   * 租户id
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String tenantId;

  /**
   * 创建时间
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see Date
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  /**
   * 创建时间(查询开始时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see Date
   */
  @TableField(value = "create_time", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see Date
   */
  @TableField(value = "create_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date createTimeEnd;

  /**
   * 创建人
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String updateUser;
}
