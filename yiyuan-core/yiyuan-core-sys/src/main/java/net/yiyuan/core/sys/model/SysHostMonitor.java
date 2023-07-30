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
 * 服务器监控采集管理实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-30
 */
@Data
public class SysHostMonitor implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 采集记录的唯一标识
   *
   * @date 2023-07-30
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)

  /**
   * 采集记录的唯一标识
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  private String id;

  /**
   * 主机表id
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String hostId;

  private Float cpuUsage;

  private Float memoryUsage;

  private Float memoryUsed;

  private Float memoryTotal;

  private Float diskUsage;

  private Float diskUsed;

  private Float diskTotal;

  private Float networkUsage;

  private Integer processCount;

  /**
   * 创建时间
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  /**
   * 创建时间(查询开始时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @TableField(value = "create_time", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @TableField(value = "create_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date createTimeEnd;

  /**
   * 修改时间
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
  /**
   * 修改时间(查询开始时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @TableField(value = "update_time", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @TableField(value = "update_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date updateTimeEnd;

  /**
   * 创建人
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String createUser;

  /**
   * 修改人
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String updateUser;
}
