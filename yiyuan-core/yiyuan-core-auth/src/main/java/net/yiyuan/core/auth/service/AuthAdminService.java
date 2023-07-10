package net.yiyuan.core.auth.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.core.auth.model.AuthAdmin;
import net.yiyuan.core.auth.model.req.AssignRoleReq;

import java.util.List;

/**
 * 用户管理Service层接口
 *
 * @author 一源团队--花和尚
 * @date 2023-07-09
 */
public interface AuthAdminService extends JoinIService<AuthAdmin> {

  /**
   * 用户列表(全部)
   *
   * @param request 用户实体
   * @return {@link List}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  List<AuthAdmin> list(AuthAdmin request) throws Exception;

  /**
   * 用户列表(分页)
   *
   * @param request 用户实体
   * @return {@link Page}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  Page<AuthAdmin> pages(AuthAdmin request, Integer pageSize, Integer pageNum) throws Exception;

  /**
   * 用户详情
   *
   * @param request 用户实体
   * @return {@link AuthAdmin}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  AuthAdmin details(AuthAdmin request) throws Exception;

  /**
   * 删除用户表
   *
   * @param request 用户实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  boolean del(AuthAdmin request) throws Exception;

  /**
   * 批量删除用户表
   *
   * @param ids 逗号分割id
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  boolean dels(String ids) throws Exception;

  /**
   * 批量删除用户表(根据1对多属性)
   *
   * @param request 角色_菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  boolean dels(AuthAdmin request) throws Exception;

  /**
   * 编辑用户表
   *
   * @param request 用户实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  boolean edit(AuthAdmin request) throws Exception;

  /**
   * 新增用户表
   *
   * @param request 用户实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  boolean add(AuthAdmin request) throws Exception;

  /**
   * 分配角色
   *
   * @param request 分配角色请求实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  boolean assignRole(AssignRoleReq request) throws Exception;
}
