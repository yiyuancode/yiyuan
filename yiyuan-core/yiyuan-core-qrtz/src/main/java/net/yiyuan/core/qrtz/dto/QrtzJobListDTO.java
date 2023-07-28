package net.yiyuan.core.qrtz.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.core.qrtz.enums.QrtzJobJobStatusEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 定时任务管理列表接口请求入参实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-28
 */
@Data
public class QrtzJobListDTO implements Serializable {

  /**
   * 主键ID
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  private String id;

  /**
   * 任务名称(和任务组组成唯一值)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  private String jobName;

  /**
   * 任务组（和名称组合唯一值）
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  private String jobGroup;

  /**
   * 任务执行类
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  private String jobClassName;

  /**
   * 任务执行时间表达式
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  private String jobCronExpression;

  /**
   * 任务描述备注
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  private String jobDesc;

  /**
   * 任务状态#0=暂停|1=执行中|2=已结束
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  private QrtzJobJobStatusEnum jobStatus;

  /**
   * 任务开始执行时间(查询开始时间)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date startTimeStart;
  /**
   * 任务开始执行时间(查询结束时间)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date startTimeEnd;

  /**
   * 任务结束执行时间(查询开始时间)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date endTimeStart;
  /**
   * 任务结束执行时间(查询结束时间)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date endTimeEnd;

  /**
   * 修改时间(查询开始时间)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeEnd;

  /**
   * 创建时间(查询开始时间)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeEnd;

  /**
   * 创建人
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  private String updateUser;
}
