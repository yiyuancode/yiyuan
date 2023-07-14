package net.yiyuan.core.task.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.sql.Blob;

/**
 * 触发器详细信息管理实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-06
 */
@Data
public class QrtzTriggers implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 调度名称
   *
   * @date 2023-07-06
   */
  @TableId(value = "schedName", type = IdType.ASSIGN_UUID)

  /**
   * 调度名称
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-06
   */
  private String schedName;

  /**
   * 触发器的名字
   *
   * @author 一源团队--花和尚
   * @date 2023-07-06
   * @see String
   */
  private String triggerName;

  /**
   * 触发器所属组的名字
   *
   * @author 一源团队--花和尚
   * @date 2023-07-06
   * @see String
   */
  private String triggerGroup;

  /**
   * qrtz_job_details表job_name的外键
   *
   * @author 一源团队--花和尚
   * @date 2023-07-06
   * @see String
   */
  private String jobName;

  /**
   * qrtz_job_details表job_group的外键
   *
   * @author 一源团队--花和尚
   * @date 2023-07-06
   * @see String
   */
  private String jobGroup;

  /**
   * 相关介绍
   *
   * @author 一源团队--花和尚
   * @date 2023-07-06
   * @see String
   */
  private String description;

  /**
   * 上一次触发时间（毫秒）
   *
   * @author 一源团队--花和尚
   * @date 2023-07-06
   * @see Long
   */
  private Long nextFireTime;

  /**
   * 下一次触发时间（默认为-1表示不触发）
   *
   * @author 一源团队--花和尚
   * @date 2023-07-06
   * @see Long
   */
  private Long prevFireTime;

  /**
   * 优先级
   *
   * @author 一源团队--花和尚
   * @date 2023-07-06
   * @see Integer
   */
  private Integer priority;

  /**
   * 触发器状态
   *
   * @author 一源团队--花和尚
   * @date 2023-07-06
   * @see String
   */
  private String triggerState;

  /**
   * 触发器的类型
   *
   * @author 一源团队--花和尚
   * @date 2023-07-06
   * @see String
   */
  private String triggerType;

  /**
   * 开始时间
   *
   * @author 一源团队--花和尚
   * @date 2023-07-06
   * @see Long
   */
  private Long startTime;

  /**
   * 结束时间
   *
   * @author 一源团队--花和尚
   * @date 2023-07-06
   * @see Long
   */
  private Long endTime;

  /**
   * 日程表名称
   *
   * @author 一源团队--花和尚
   * @date 2023-07-06
   * @see String
   */
  private String calendarName;

  /**
   * 补偿执行的策略
   *
   * @author 一源团队--花和尚
   * @date 2023-07-06
   * @see Integer
   */
  private Integer misfireInstr;

  /**
   * 存放持久化job对象
   *
   * @author 一源团队--花和尚
   * @date 2023-07-06
   * @see Blob
   */
  private Blob jobData;
}
