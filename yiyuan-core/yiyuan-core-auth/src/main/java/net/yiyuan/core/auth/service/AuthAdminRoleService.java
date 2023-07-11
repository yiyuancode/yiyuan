package net.yiyuan.core.auth.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.core.auth.model.AuthAdminRole;

import java.util.List;
/**
 * 用户_角色管理Service层接口
 *
 * @author 一源团队--花和尚
 * @date 2023-07-11
 */
public interface AuthAdminRoleService extends JoinIService<AuthAdminRole> {

  /**
   * 用户_角色列表(全部)
   *
   * @param request 用户_角色实体
   * @return {@link List}
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  List<AuthAdminRole> list(AuthAdminRole request) throws Exception;

  /**
   * 用户_角色列表(分页)
   *
   * @param request 用户_角色实体
   * @return {@link Page}
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  Page<AuthAdminRole> pages(AuthAdminRole request, Integer pageSize, Integer pageNum)
      throws Exception;

  /**
   * 用户_角色详情
   *
   * @param id 用户_角色id
   * @return {@link AuthAdminRole}
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  AuthAdminRole details(String id) throws Exception;

  /**
   * 用户_角色详情
   *
   * @param request 用户_角色实体
   * @return {@link AuthAdminRole}
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  AuthAdminRole details(AuthAdminRole request) throws Exception;

  /**
   * 删除用户_角色(支持批量)
   *
   * @param ids 用户_角色id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  boolean delete(String ids) throws Exception;

  /**
   * 批量删除用户_角色表(根据同一属性,针对中间表)
   *
   * @param request 用户_角色实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  boolean delete(AuthAdminRole request) throws Exception;

  /**
   * 编辑用户_角色表
   *
   * @param request 用户_角色实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  boolean edit(AuthAdminRole request) throws Exception;

  /**
   * 新增用户_角色表
   *
   * @param request 用户_角色实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  boolean add(AuthAdminRole request) throws Exception;
}
