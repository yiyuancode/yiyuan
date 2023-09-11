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
public class AuthAdminAssignRoleDTO {
  /**
   * 用户id
   *
   * @author ${author}
   * @date 2023-06-23
   * @see String
   */
  @NotBlank(message = "用户id不能为空")
  private String userId;

  /**
   * 角色id List
   *
   * @author ${author}
   * @date 2023-06-23
   * @see List
   */
  @NotEmpty(message = "角色数组不能为空")
  private List<String> rolesIdList;
}
