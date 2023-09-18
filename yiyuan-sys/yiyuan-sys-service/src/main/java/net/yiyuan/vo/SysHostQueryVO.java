package net.yiyuan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.enums.SysHostIsMonitorEnabledEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 服务器查询请求响应参数实体
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Data
public class SysHostQueryVO implements Serializable {

  /**
   * 主键ID
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String id;

  /**
   * 主机名
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String hostName;

  /**
   * IP地址
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String host;

  /**
   * SSH端口
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private Integer sshPort;

  /**
   * SSH登录用户名
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String sshUsername;

  /**
   * SSH登录密码
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String sshPassword;

  /**
   * 开启监控#0=开启|1=关闭|
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private SysHostIsMonitorEnabledEnum isMonitorEnabled;

  /**
   * 排序字段
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private Integer sortBy;

  /**
   * 创建时间
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  /**
   * 修改时间
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;

  /**
   * 创建人
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String updateUser;
}
