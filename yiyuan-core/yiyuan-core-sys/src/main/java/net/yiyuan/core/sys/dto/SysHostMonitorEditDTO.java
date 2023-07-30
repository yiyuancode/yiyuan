package net.yiyuan.core.sys.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 服务器监控采集修改接口请求入参实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-30
 */
@Data
public class SysHostMonitorEditDTO implements Serializable {

  /**
   * 采集记录的唯一标识
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @NotBlank(message = "采集记录的唯一标识不能为空")
  private String id;

  /**
   * 主机表id
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  private String hostId;

  /**
   * CPU 使用率
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  private Float cpuUsage;

  /**
   * 内存使用率
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  private Float memoryUsage;

  /**
   * 已使用内存量（单位：MB）
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  private Float memoryUsed;

  /**
   * 总内存量（单位：MB）
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  private Float memoryTotal;

  /**
   * 磁盘使用率
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  private Float diskUsage;

  /**
   * 已使用磁盘空间（单位：GB）
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  private Float diskUsed;

  /**
   * 总磁盘空间（单位：GB）
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  private Float diskTotal;

  /**
   * 网络使用量（单位：字节）
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  private Float networkUsage;

  /**
   * 进程数量
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  private Integer processCount;
}
