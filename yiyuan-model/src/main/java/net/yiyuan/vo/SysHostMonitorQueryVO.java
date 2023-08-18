package net.yiyuan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 服务器监控采集查询请求响应参数实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
@Data
public class SysHostMonitorQueryVO implements Serializable {

  /**
   * 采集记录的唯一标识
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
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

  /**
   * 创建时间
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  /**
   * 修改时间
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;

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
