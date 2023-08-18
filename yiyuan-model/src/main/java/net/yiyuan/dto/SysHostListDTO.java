package net.yiyuan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.enums.SysHostIsMonitorEnabledEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 主机记录列表接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
@Data
public class SysHostListDTO implements Serializable {

  /**
   * 主键ID
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String id;

  /**
   * 主机名
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String hostName;

  /**
   * IP地址
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String host;

  /**
   * SSH端口
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Integer sshPort;

  /**
   * SSH登录用户名
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String sshUsername;

  /**
   * SSH登录密码
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String sshPassword;

  /**
   * 开启监控#0=开启|1=关闭|
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private SysHostIsMonitorEnabledEnum isMonitorEnabled;

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
