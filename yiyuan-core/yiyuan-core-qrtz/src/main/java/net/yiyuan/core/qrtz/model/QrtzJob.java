package net.yiyuan.core.qrtz.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.core.qrtz.enums.QrtzJobJobStatusEnum;
import net.yiyuan.plugins.mp.constant.CustomSqlCondition;

import java.io.Serializable;
import java.util.Date;

/**
 * 定时任务管理管理实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-28
 */
@Data
public class QrtzJob implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 主键ID
   *
   * @date 2023-07-28
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)

  /**
   * 主键ID
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  private String id;

  /**
   * 任务名称(和任务组组成唯一值)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String jobName;

  /**
   * 任务组（和名称组合唯一值）
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String jobGroup;

  /**
   * 任务执行类
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String jobClassName;

  /**
   * 任务执行时间表达式
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String jobCronExpression;

  /**
   * 任务描述备注
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String jobDesc;

  /**
   * 任务状态#0=暂停|1=执行中|2=已结束
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see Integer
   */
  private QrtzJobJobStatusEnum jobStatus;

  /**
   * 任务开始执行时间
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see Date
   */
  private Date startTime;
  /**
   * 任务开始执行时间(查询开始时间)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see Date
   */
  @TableField(value = "start_time", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date startTimeStart;
  /**
   * 任务开始执行时间(查询结束时间)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see Date
   */
  @TableField(value = "start_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date startTimeEnd;

  /**
   * 任务结束执行时间
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see Date
   */
  private Date endTime;
  /**
   * 任务结束执行时间(查询开始时间)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see Date
   */
  @TableField(value = "end_time", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date endTimeStart;
  /**
   * 任务结束执行时间(查询结束时间)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see Date
   */
  @TableField(value = "end_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date endTimeEnd;

  /**
   * 修改时间
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see Date
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
  /**
   * 修改时间(查询开始时间)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see Date
   */
  @TableField(value = "update_time", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see Date
   */
  @TableField(value = "update_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date updateTimeEnd;

  /**
   * 创建时间
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see Date
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  /**
   * 创建时间(查询开始时间)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see Date
   */
  @TableField(value = "create_time", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see Date
   */
  @TableField(value = "create_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date createTimeEnd;

  /**
   * 创建人
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String updateUser;
}
