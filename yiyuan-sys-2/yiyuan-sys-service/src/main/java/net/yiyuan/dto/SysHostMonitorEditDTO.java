package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 服务器监控采集修改接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
@Data
public class SysHostMonitorEditDTO implements Serializable {

  /**
   * 采集记录的唯一标识
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @NotBlank(message = "采集记录的唯一标识不能为空")
  private String id;

  /**
   * 主机表id
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String hostId;

  /**
   * CPU 使用率
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Float cpuUsage;

  /**
   * 内存使用率
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Float memoryUsage;

  /**
   * 已使用内存量（单位：MB）
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Float memoryUsed;

  /**
   * 总内存量（单位：MB）
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Float memoryTotal;

  /**
   * 磁盘使用率
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Float diskUsage;

  /**
   * 已使用磁盘空间（单位：GB）
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Float diskUsed;

  /**
   * 总磁盘空间（单位：GB）
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Float diskTotal;

  /**
   * 网络使用量（单位：字节）
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Float networkUsage;

  /**
   * 进程数量
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Integer processCount;
}
