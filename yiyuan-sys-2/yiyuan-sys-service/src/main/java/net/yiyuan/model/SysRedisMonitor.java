package net.yiyuan.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.common.constatnt.CustomSqlCondition;

import java.io.Serializable;
import java.util.Date;

/**
 * Redis监控采集实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
@Data
public class SysRedisMonitor implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 主键ID
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * redis主键id
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String redisId;

  /**
   * Redis 服务器当前已连接客户端数量
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Integer connectedClients;

  /**
   * Redis 服务器集群模式下已连接的客户端数量
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Integer clusterConnections;

  /**
   * Redis 服务器支持的最大客户端数量
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Integer maxClients;

  /**
   * 正在等待阻塞命令执行的客户端数量
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Integer blockedClients;

  /**
   * 正在等待 TRACKING 命令执行的客户端数量
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Integer trackingClients;

  /**
   * 在客户端超时表中的客户端数量
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Integer clientsInTimeoutTable;

  /**
   * Redis 服务器接收的网络数据总字节数(KB)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Long totalNetInputBytes;

  /**
   * Redis 服务器发送的网络数据总字节数(KB)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Long totalNetOutputBytes;

  /**
   * Redis 服务器历史已接受的连接请求数量
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Long totalConnectionsReceived;

  /**
   * Redis 服务器历史已执行的命令数量
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Long totalCommandsProcessed;

  /**
   * Redis 服务器瞬时执行的命令数量
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Long instantaneousOpsPerSec;

  /**
   * Redis 所有库的key总和
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Long totalKeyCount;

  /**
   * Redis 所有库将要过期的key总和
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Long totalExpiredKeyCount;

  /**
   * Redis 实例当前占用的内存大小(KB)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Long usedMemory;

  /**
   * Redis 实例所在系统总内存大小(KB)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Long totalSystemMemory;

  /**
   * Redis 实例配置的最大内存限制(KB)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Long maxmemory;

  /**
   * Redis 实例占用的当前内存峰值大小(KB)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Long usedMemoryPeak;

  /**
   * 排序字段
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Integer sortBy;

  /**
   * 创建时间
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  /**
   * 创建时间(查询开始时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(value = "create_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(value = "create_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date createTimeEnd;

  /**
   * 修改时间
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
  /**
   * 修改时间(查询开始时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(value = "update_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(value = "update_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date updateTimeEnd;

  /**
   * 创建人
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(fill = FieldFill.INSERT)
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private String updateUser;
}