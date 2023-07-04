package net.yiyuan.core.task.model.add_task;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

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
  private String jobClassName;

  /**
   * 任务组名
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @NotEmpty(message = "任务组名不能为空")
  private String jobGroupName;

  /**
   * 任务执行表达式
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @NotEmpty(message = "任务执行表达式不能为空")
  private String cronExpression;
}
