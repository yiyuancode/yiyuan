package net.yiyuan.core.task.model.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * 登录请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023/06/24
 */
@Data
public class AddTaskReq {
  /**
   * 任务类名
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @NotEmpty(message = "任务类名不能为空")
  private String jobName;

  /**
   * 任务组名
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @NotEmpty(message = "任务组名不能为空")
  private String jobGroup;

  /**
   * 任务执行表达式
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @NotEmpty(message = "任务执行表达式不能为空")
  private String cronExpression;

  /**
   * 任务开始时间
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date startTime;

  /**
   * 任务结束时间
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date endTime;
}
