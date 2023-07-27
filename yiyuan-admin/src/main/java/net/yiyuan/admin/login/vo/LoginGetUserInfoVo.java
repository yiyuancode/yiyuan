package net.yiyuan.admin.login.vo;

import cn.hutool.core.lang.tree.Tree;
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
public class LoginGetUserInfoVo {
  /**
   * 用户名
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  private String username;
  /**
   * 角色列表
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  private List<AuthRole> roleList;

  /**
   * 权限表达式
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  private List<String> permList;

//  /**
//   * 菜单（树结构）
//   *
//   * @see String
//   * @author 一源团队--花和尚
//   * @date 2023-06-24
//   */
//  private List<SysMenuTreeVo> menuTreeVoList;
  
  /**
   * 菜单（树结构）
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see String
   */
  List<Tree<String>> trees;
}
