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
 * 服务器监控采集实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
@Data
public class SysHostMonitor implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 采集记录的唯一标识
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * 主机表id
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String hostId;

  /**
   * CPU 使用率
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Float cpuUsage;

  /**
   * 内存使用率
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Float memoryUsage;

  /**
   * 已使用内存量（单位：MB）
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Float memoryUsed;

  /**
   * 总内存量（单位：MB）
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Float memoryTotal;

  /**
   * 磁盘使用率
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Float diskUsage;

  /**
   * 已使用磁盘空间（单位：GB）
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Float diskUsed;

  /**
   * 总磁盘空间（单位：GB）
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Float diskTotal;

  /**
   * 网络使用量（单位：字节）
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Float networkUsage;

  /**
   * 进程数量
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Integer processCount;

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
