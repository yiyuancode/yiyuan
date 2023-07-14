package net.yiyuan.core.auth.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色_菜单管理实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-11
 */
@Data
public class AuthRoleMenu implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 角色ID
   *
   * @author 一源团队--花和尚
   * @date 2023-07-11
   * @see String
   */
  private String roleId;

  /**
   * 菜单ID
   *
   * @author 一源团队--花和尚
   * @date 2023-07-11
   * @see String
   */
  private String menuId;

  /**
   * 修改时间 DateTimeFormat//请求非body json时候 JsonFormat//请求为body json时候
   *
   * @author 一源团队--花和尚
   * @date 2023-07-11
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updatedTime;

  /**
   * 创建时间 DateTimeFormat//请求非body json时候 JsonFormat//请求为body json时候
   *
   * @author 一源团队--花和尚
   * @date 2023-07-11
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createdTime;
}
