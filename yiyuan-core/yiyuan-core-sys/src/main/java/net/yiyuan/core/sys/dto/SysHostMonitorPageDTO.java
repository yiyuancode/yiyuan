package net.yiyuan.core.sys.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 服务器监控采集分页接口请求入参实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-30
 */
@Data
public class SysHostMonitorPageDTO implements Serializable {
  /**
   * 分页条数
   *
   * @mock 10
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @NotNull(message = "分页条数不能为空")
  private Integer pageSize;
  /**
   * 分页页数
   *
   * @mock 1
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @NotNull(message = "分页页数不能为空")
  private Integer pageNum;

  /**
   * 采集记录的唯一标识
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
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

  /**
   * 创建时间(查询开始时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeEnd;

  /**
   * 修改时间(查询开始时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeEnd;

  /**
   * 创建人
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  private String updateUser;
}
