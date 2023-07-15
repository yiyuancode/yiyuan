package net.yiyuan.core.auth.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.core.auth.model.AuthRoleMenu;

import java.util.List;
/**
 * 角色_菜单管理Service层接口
 *
 * @author 一源团队--花和尚
 * @date 2023-07-15
 */
public interface AuthRoleMenuService extends JoinIService<AuthRoleMenu> {

  /**
   * 角色_菜单列表(全部)
   *
   * @param request 角色_菜单实体
   * @return {@link List}
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  List<AuthRoleMenu> list(AuthRoleMenu request) throws Exception;

  /**
   * 角色_菜单列表(分页)
   *
   * @param request 角色_菜单实体
   * @return {@link Page}
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  Page<AuthRoleMenu> pages(AuthRoleMenu request, Integer pageSize, Integer pageNum)
      throws Exception;

  /**
   * 角色_菜单详情
   *
   * @param id 角色_菜单id
   * @return {@link AuthRoleMenu}
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  AuthRoleMenu details(String id) throws Exception;

  /**
   * 角色_菜单详情
   *
   * @param request 角色_菜单实体
   * @return {@link AuthRoleMenu}
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  AuthRoleMenu details(AuthRoleMenu request) throws Exception;

  /**
   * 删除角色_菜单(支持批量)
   *
   * @param ids 角色_菜单id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  boolean delete(String ids) throws Exception;

  /**
   * 批量删除角色_菜单表(根据同一属性,针对中间表)
   *
   * @param request 角色_菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  boolean delete(AuthRoleMenu request) throws Exception;

  /**
   * 编辑角色_菜单表
   *
   * @param request 角色_菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  boolean edit(AuthRoleMenu request) throws Exception;

  /**
   * 新增角色_菜单表
   *
   * @param request 角色_菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  boolean add(AuthRoleMenu request) throws Exception;
}
