package net.yiyuan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Redis监控采集分页接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
@Data
public class SysRedisMonitorPageDTO implements Serializable {
  /**
   * 分页条数
   *
   * @mock 10
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @NotNull(message = "分页条数不能为空")
  private Integer pageSize;
  /**
   * 分页页数
   *
   * @mock 1
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @NotNull(message = "分页页数不能为空")
  private Integer pageNum;

  /**
   * 主键ID
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String id;

  /**
   * redis主键id
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String redisId;

  /**
   * Redis 服务器当前已连接客户端数量
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Integer connectedClients;

  /**
   * Redis 服务器集群模式下已连接的客户端数量
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Integer clusterConnections;

  /**
   * Redis 服务器支持的最大客户端数量
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Integer maxClients;

  /**
   * 正在等待阻塞命令执行的客户端数量
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Integer blockedClients;

  /**
   * 正在等待 TRACKING 命令执行的客户端数量
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Integer trackingClients;

  /**
   * 在客户端超时表中的客户端数量
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Integer clientsInTimeoutTable;

  /**
   * Redis 服务器接收的网络数据总字节数(KB)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Long totalNetInputBytes;

  /**
   * Redis 服务器发送的网络数据总字节数(KB)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Long totalNetOutputBytes;

  /**
   * Redis 服务器历史已接受的连接请求数量
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Long totalConnectionsReceived;

  /**
   * Redis 服务器历史已执行的命令数量
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Long totalCommandsProcessed;

  /**
   * Redis 服务器瞬时执行的命令数量
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Long instantaneousOpsPerSec;

  /**
   * Redis 所有库的key总和
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Long totalKeyCount;

  /**
   * Redis 所有库将要过期的key总和
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Long totalExpiredKeyCount;

  /**
   * Redis 实例当前占用的内存大小(KB)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Long usedMemory;

  /**
   * Redis 实例所在系统总内存大小(KB)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Long totalSystemMemory;

  /**
   * Redis 实例配置的最大内存限制(KB)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Long maxmemory;

  /**
   * Redis 实例占用的当前内存峰值大小(KB)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Long usedMemoryPeak;

  /**
   * 排序字段
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Integer sortBy;

  /**
   * 创建时间(查询开始时间)
   *
   * @see Date
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @see Date
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeEnd;

  /**
   * 修改时间(查询开始时间)
   *
   * @see Date
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @see Date
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeEnd;

  /**
   * 创建人
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String updateUser;
}
