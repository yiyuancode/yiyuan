package net.yiyuan.tenant.login.vo;

import cn.hutool.core.lang.tree.Tree;
import lombok.Data;
import net.yiyuan.model.AuthRole;

import java.util.List;
import java.util.Map;

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
   * @author ${author}
   * @date 2023-06-24
   * @see String
   */
  private String username;

  /**
   * 对应角色信息
   *
   * @author ${author}
   * @date 2023-07-27
   */
  private List<AuthRole> roleList;

  /**
   * 对应菜单权限信息
   *
   * @author ${author}
   * @date 2023-07-27
   */
  private List<Tree<String>> menuTreeList;

  /**
   * antd前端所需权限表达式集合
   *
   * @author ${author}
   * @date 2023-07-27
   */
  private List<Map<String, Object>> permissionsList;
}
