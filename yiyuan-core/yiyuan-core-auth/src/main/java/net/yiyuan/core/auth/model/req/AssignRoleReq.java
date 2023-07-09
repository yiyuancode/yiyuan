package net.yiyuan.core.auth.model.assign_role;

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
public class AssignRoleReq {
  /**
   * 用户id
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @NotBlank(message = "用户id不能为空")
  private String userId;

  /**
   * 角色id List
   *
   * @see List
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @NotEmpty(message = "角色数组不能为空")
  private List<String> rolesIdList;
}
