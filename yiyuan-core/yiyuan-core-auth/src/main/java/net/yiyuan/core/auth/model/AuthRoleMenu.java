package net.yiyuan.core.auth.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.plugins.mp.constant.CustomSqlCondition;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
/**
 * 角色_菜单管理实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-15
 */
@Data
public class AuthRoleMenu implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 角色ID
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String roleId;

  /**
   * 菜单ID
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String menuId;

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
