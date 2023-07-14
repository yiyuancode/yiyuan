package net.yiyuan.core.task.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TaskDeatilVo {

  /**
   * 调度名称
   *
   * @author 一源团队--花和尚
   * @date 2023-07-06
   * @see String
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
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date nextFireTime;

  /**
   * 下一次触发时间（默认为-1表示不触发）
   *
   * @author 一源团队--花和尚
   * @date 2023-07-06
   * @see Long
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date prevFireTime;

  /**
   * 优先级
   *
   * @author 一源团队--花和尚
   * @date 2023-07-06
   * @see Integer
   */
  private Integer priority;

  /**
   * 触发器状态(ACQUIRED=运行中,PAUSED=暂停中)
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
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date startTime;

  /**
   * 结束时间
   *
   * @author 一源团队--花和尚
   * @date 2023-07-06
   * @see Long
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
}
