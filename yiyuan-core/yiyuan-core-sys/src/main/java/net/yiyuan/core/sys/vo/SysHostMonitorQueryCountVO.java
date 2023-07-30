package net.yiyuan.core.sys.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 服务器监控采集新增接口请求入参实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-30
 */
@Data
public class SysHostMonitorQueryCountVO implements Serializable {
  /**
   * 统计分组时间
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  private String time;
  /**
   * 统计cpu平均值
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  private Double avgCpuUsage;
  /**
   * 统计内存平均使用率 单位百分比
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  private Double avgMemoryUsage;
  /**
   * 统计内存平均使用值 单位MB
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  private Double avgMemoryUsed;
  /**
   * 统计内存平均总值 单位MB
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  private Double avgMemoryTotal;
  /**
   * 统计内存平均使用率 单位百分比
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  private Double avgDiskUsage;
  /**
   * 统计内存平均使用率 单位百分比
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  private Double avgDiskUsed;
  /**
   * 统计内存平均总值 单位GB
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  private Double avgDiskTotal;
  /**
   * 统计总的网络流量 单位KB
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  private Long totalNetworkUsage;
  /**
   * 统计总的进程数
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  private Long totalProcessCount;
}
