package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.SysRedisIsMonitorEnabledEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Redis记录新增接口请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Data
public class SysRedisAddDTO implements Serializable {

  /**
   * redis名称
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @NotBlank(message = "redis名称不能为空")
  private String name;

  /**
   * ip地址
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @NotBlank(message = "ip地址不能为空")
  private String host;

  /**
   * reids端口
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @NotNull(message = "reids端口不能为空")
  private Integer port;

  /**
   * redis密码
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String password;

  /**
   * Redis 服务器版本号
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String redisVersion;

  /**
   * Redis 服务器运行模式
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String redisMode;

  /**
   * Redis 服务器运行的操作系统
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String os;

  /**
   * Redis 服务器当前已连接客户端数量
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private Integer connectedClients;

  /**
   * Redis 服务器集群模式下已连接的客户端数量
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private Integer clusterConnections;

  /**
   * Redis 服务器支持的最大客户端数量
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private Integer maxClients;

  /**
   * 正在等待阻塞命令执行的客户端数量
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private Integer blockedClients;

  /**
   * 正在等待 TRACKING 命令执行的客户端数量
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private Integer trackingClients;

  /**
   * 在客户端超时表中的客户端数量
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private Integer clientsInTimeoutTable;

  /**
   * Redis 服务器接收的网络数据总字节数(KB)
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private Long totalNetInputBytes;

  /**
   * Redis 服务器发送的网络数据总字节数(KB)
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private Long totalNetOutputBytes;

  /**
   * Redis 服务器历史已接受的连接请求数量
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private Long totalConnectionsReceived;

  /**
   * Redis 服务器历史已执行的命令数量
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private Long totalCommandsProcessed;

  /**
   * Redis 服务器瞬时执行的命令数量
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private Long instantaneousOpsPerSec;

  /**
   * Redis 所有库的key总和
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private Long totalKeyCount;

  /**
   * Redis 所有库将要过期的key总和
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private Long totalExpiredKeyCount;

  /**
   * Redis 实例当前占用的内存大小(KB)
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private Long usedMemory;

  /**
   * Redis 实例所在系统总内存大小(KB)
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private Long totalSystemMemory;

  /**
   * Redis 实例配置的最大内存限制(KB)
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private Long maxmemory;

  /**
   * Redis 实例占用的当前内存峰值大小(KB)
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private Long usedMemoryPeak;

  /**
   * 开启监控#0=开启|1=关闭|
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @NotNull(message = "开启监控#0=开启|1=关闭|不能为空")
  private SysRedisIsMonitorEnabledEnum isMonitorEnabled;

  /**
   * 排序字段
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private Integer sortBy;
}
