package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 分配角色请求实体
 *
 * @author 一源团队-花和尚
 * @date 2023/06/24
 */
@Data
public class AuthRoleAssignMenuDTO {
  /**
   * 角色Id
   *
   * @author ${author}
   * @date 2023-06-23
   * @see String
   */
  @NotBlank(message = "角色Id不能为空")
  private String roleId;

  /**
   * 菜单id List
   *
   * @author ${author}
   * @date 2023-06-23
   * @see List
   */
  @NotEmpty(message = "菜单id数组不能为空")
  private List<String> menuIdList;
}
