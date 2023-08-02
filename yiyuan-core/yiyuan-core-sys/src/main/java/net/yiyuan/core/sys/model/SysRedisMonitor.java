package net.yiyuan.core.sys.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.plugins.mp.constant.CustomSqlCondition;

import java.io.Serializable;
import java.util.Date;
/**
 * Redis监控采集管理实体
 *
 * @author 一源团队--花和尚
 * @date 2023-08-02
 */
@Data
public class SysRedisMonitor implements Serializable {
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.ASSIGN_UUID)

  /**
   * 主键ID
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  private String id;

  /**
   * redis主键id
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String redisId;

  /**
   * Redis 服务器当前已连接客户端数量
   *
   * @see Integer
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  private Integer connectedClients;

  /**
   * Redis 服务器集群模式下已连接的客户端数量
   *
   * @see Integer
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  private Integer clusterConnections;

  /**
   * Redis 服务器支持的最大客户端数量
   *
   * @see Integer
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  private Integer maxClients;

  /**
   * 正在等待阻塞命令执行的客户端数量
   *
   * @see Integer
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  private Integer blockedClients;

  /**
   * 正在等待 TRACKING 命令执行的客户端数量
   *
   * @see Integer
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  private Integer trackingClients;

  /**
   * 在客户端超时表中的客户端数量
   *
   * @see Integer
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  private Integer clientsInTimeoutTable;

  /**
   * Redis 服务器接收的网络数据总字节数(KB)
   *
   * @see Long
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  private Long totalNetInputBytes;

  /**
   * Redis 服务器发送的网络数据总字节数(KB)
   *
   * @see Long
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  private Long totalNetOutputBytes;

  /**
   * Redis 服务器历史已接受的连接请求数量
   *
   * @see Long
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  private Long totalConnectionsReceived;

  /**
   * Redis 服务器历史已执行的命令数量
   *
   * @see Long
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  private Long totalCommandsProcessed;

  /**
   * Redis 服务器瞬时执行的命令数量
   *
   * @see Long
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  private Long instantaneousOpsPerSec;

  /**
   * Redis 所有库的key总和
   *
   * @see Long
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  private Long totalKeyCount;

  /**
   * Redis 所有库将要过期的key总和
   *
   * @see Long
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  private Long totalExpiredKeyCount;

  /**
   * Redis 实例当前占用的内存大小(KB)
   *
   * @see Long
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  private Long usedMemory;

  /**
   * Redis 实例所在系统总内存大小(KB)
   *
   * @see Long
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  private Long totalSystemMemory;

  /**
   * Redis 实例配置的最大内存限制(KB)
   *
   * @see Long
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  private Long maxmemory;

  /**
   * Redis 实例占用的当前内存峰值大小(KB)
   *
   * @see Long
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  private Long usedMemoryPeak;

  /**
   * 排序字段
   *
   * @see Integer
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  private Integer sortBy;

  /**
   * 创建时间
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  /**
   * 创建时间(查询开始时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  @TableField(value = "create_time", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  @TableField(value = "create_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date createTimeEnd;

  /**
   * 修改时间
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
  /**
   * 修改时间(查询开始时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  @TableField(value = "update_time", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  @TableField(value = "update_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date updateTimeEnd;

  /**
   * 创建人
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String createUser;

  /**
   * 修改人
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String updateUser;
}
