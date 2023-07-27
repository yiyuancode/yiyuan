package net.yiyuan.core.auth.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 角色_菜单修改接口请求入参实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Data
public class AuthRoleMenuEditDTO implements Serializable {

  /**
   * 主键
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @NotBlank(message = "主键不能为空")
  private String id;

  /**
   * 角色ID
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  private String roleId;

  /**
   * 菜单ID
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  private String menuId;
}
