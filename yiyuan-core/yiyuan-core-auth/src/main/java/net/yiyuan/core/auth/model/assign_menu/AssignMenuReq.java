package net.yiyuan.core.auth.model.assign_menu;

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
public class AssignMenuReq {
  /**
   * 角色Id
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @NotBlank(message = "角色Id不能为空")
  private String roleId;

  /**
   * 菜单id List
   *
   * @see List
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @NotEmpty(message = "菜单id数组不能为空")
  private List<String> menuIdList;

  /**
   * 租户 id
   *
   * @see List
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  private String tenantId;
}
