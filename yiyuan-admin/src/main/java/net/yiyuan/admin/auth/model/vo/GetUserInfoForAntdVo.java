package net.yiyuan.admin.auth.model.vo;

import lombok.Data;
import net.yiyuan.core.auth.model.AuthRole;

import java.util.List;

/**
 * 查询用户信息请求响应vo
 *
 * @author 一源团队-花和尚
 * @date 2023/06/24
 */
@Data
public class GetUserInfoForAntdVo {
  /**
   * 用户名
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see String
   */
  private String username;
  /**
   * 角色列表
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see String
   */
  private List<AuthRole> roleList;

  /**
   * 异步路由
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see String
   */
  private List<SysMenuTreeForAntdVo> asyncRoutes;

  /**
   * 权限表达式（包含按钮表达式）
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see String
   */
  private List<PermissionsForAntdVo> permissions;

  /**
   * antd所需要角色数组（包含按钮表达式）
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see String
   */
  private List<AuthRole> roleAntdList;
}
