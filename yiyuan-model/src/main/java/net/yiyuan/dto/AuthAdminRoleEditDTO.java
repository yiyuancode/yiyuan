package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 用户_角色修改接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
@Data
public class AuthAdminRoleEditDTO implements Serializable {

  /**
   * 主键
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @NotBlank(message = "主键不能为空")
  private String id;

  /**
   * 用户ID
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String userId;

  /**
   * 角色ID
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String roleId;

  /**
   * 租户id
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String tenantId;
}
