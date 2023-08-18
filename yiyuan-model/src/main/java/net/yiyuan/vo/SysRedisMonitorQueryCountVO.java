package net.yiyuan.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 服务器监控采集新增接口请求入参实体
 *
 * @author ${author}
 * @date 2023-07-30
 */
@Data
public class SysRedisMonitorQueryCountVO implements Serializable {
  /**
   * 统计分组时间
   *
   * @author ${author}
   * @date 2023-08-02
   */
  private String time;

  /**
   * 平均已连接客户端数
   *
   * @author ${author} @date 2023-08-02
   */
  private Long avgConnectedClients;

  /**
   * 平均集群连接数
   *
   * @author ${author} @date 2023-08-02
   */
  private Long avgClusterConnections;

  /**
   * 平均最大客户端数
   *
   * @author ${author} @date 2023-08-02
   */
  private Long avgMaxClients;

  /**
   * 平均被阻塞客户端数
   *
   * @author ${author} @date 2023-08-02
   */
  private Long avgBlockedClients;

  /**
   * 平均正在追踪的客户端数
   *
   * @author ${author} @date 2023-08-02
   */
  private Long avgTrackingClients;

  /**
   * 平均在超时表中的客户端数
   *
   * @author ${author} @date 2023-08-02
   */
  private Long avgClientsInTimeoutTable;

  /**
   * 平均总网络输入字节数
   *
   * @author ${author} @date 2023-08-02
   */
  private Long avgTotalNetInputBytes;

  /**
   * 平均总网络输出字节数
   *
   * @author ${author} @date 2023-08-02
   */
  private Long avgTotalNetOutputBytes;

  /**
   * 平均接收连接总数
   *
   * @author ${author} @date 2023-08-02
   */
  private Long avgTotalConnectionsReceived;

  /**
   * 平均处理命令总数
   *
   * @author ${author} @date 2023-08-02
   */
  private Long avgTotalCommandsProcessed;

  /**
   * 平均瞬时操作数
   *
   * @author ${author} @date 2023-08-02
   */
  private Long avgInstantaneousOpsPerSec;

  /**
   * 平均键总数
   *
   * @author ${author} @date 2023-08-02
   */
  private Long avgTotalKeyCount;

  /**
   * 平均过期键总数
   *
   * @author ${author} @date 2023-08-02
   */
  private Long avgTotalExpiredKeyCount;

  /**
   * 平均已使用内存量
   *
   * @author ${author} @date 2023-08-02
   */
  private Long avgUsedMemory;

  /**
   * 平均系统总内存量
   *
   * @author ${author} @date 2023-08-02
   */
  private Long avgTotalSystemMemory;

  /**
   * 平均最大内存限制
   *
   * @author ${author} @date 2023-08-02
   */
  private Long avgMaxmemory;
}
