package net.yiyuan.core.auth.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
/**
 * 用户_角色管理实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-11
 */
@Data
public class AuthAdminRole implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 用户ID
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  private String userId;

  /**
   * 角色ID
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  private String roleId;

  /**
   * 修改时间 DateTimeFormat//请求非body json时候 JsonFormat//请求为body json时候
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updatedTime;

  /**
   * 创建时间 DateTimeFormat//请求非body json时候 JsonFormat//请求为body json时候
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createdTime;

  /**
   * 租户id
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  private String tenantId;
}
