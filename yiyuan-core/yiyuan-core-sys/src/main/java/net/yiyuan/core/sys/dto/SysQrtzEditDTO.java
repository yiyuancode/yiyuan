package net.yiyuan.core.sys.dto;

import lombok.Data;
import net.yiyuan.core.sys.enums.SysQrtzJobStatusEnum;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 定时任务修改接口请求入参实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-28
 */
@Data
public class SysQrtzEditDTO implements Serializable {

  /**
   * 主键ID
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @NotBlank(message = "主键ID不能为空")
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
   * @mock 1
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  private SysQrtzJobStatusEnum jobStatus;

  /**
   * 任务开始执行时间
   *
   * @mock CURRENT_TIMESTAMP
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  private Date startTime;

  /**
   * 任务结束执行时间
   *
   * @mock CURRENT_TIMESTAMP
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  private Date endTime;
}
