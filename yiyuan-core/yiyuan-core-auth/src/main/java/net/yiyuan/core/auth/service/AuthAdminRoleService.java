package net.yiyuan.core.auth.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.core.auth.model.AuthAdminRole;

import java.util.List;

/**
 * 用户_角色管理Service层接口
 *
 * @author 一源团队--花和尚
 * @date 2023-07-09
 */
public interface AuthAdminRoleService extends JoinIService<AuthAdminRole> {

  /**
   * 用户_角色列表(全部)
   *
   * @param request 用户_角色实体
   * @return {@link List}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  List<AuthAdminRole> list(AuthAdminRole request) throws Exception;

  /**
   * 用户_角色列表(分页)
   *
   * @param request 用户_角色实体
   * @return {@link Page}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  Page<AuthAdminRole> pages(AuthAdminRole request, Integer pageSize, Integer pageNum)
      throws Exception;

  /**
   * 用户_角色详情
   *
   * @param request 用户_角色实体
   * @return {@link AuthAdminRole}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  AuthAdminRole details(AuthAdminRole request) throws Exception;

  /**
   * 删除用户_角色表
   *
   * @param request 用户_角色实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  boolean del(AuthAdminRole request) throws Exception;

  /**
   * 批量删除用户_角色表
   *
   * @param ids 逗号分割id
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  boolean dels(String ids) throws Exception;

  /**
   * 批量删除用户_角色表(根据1对多属性)
   *
   * @param request 角色_菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  boolean dels(AuthAdminRole request) throws Exception;

  /**
   * 编辑用户_角色表
   *
   * @param request 用户_角色实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  boolean edit(AuthAdminRole request) throws Exception;

  /**
   * 新增用户_角色表
   *
   * @param request 用户_角色实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  boolean add(AuthAdminRole request) throws Exception;
}
