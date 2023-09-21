package net.yiyuan.vo;

import cn.hutool.core.lang.tree.Tree;
import lombok.Data;
import net.yiyuan.model.SysRole;

import java.util.List;
import java.util.Map;

/**
 * 平台端-登录请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Data
public class SysUserGetUserInfoVO {
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
  private List<SysRole> roleList;

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
