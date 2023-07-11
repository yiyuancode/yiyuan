package net.yiyuan.core.auth.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.core.auth.model.AuthRole;
import net.yiyuan.core.auth.model.req.AssignMenuReq;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * 角色管理Service层接口
 *
 * @author 一源团队--花和尚
 * @date 2023-07-11
 */
public interface AuthRoleService extends JoinIService<AuthRole> {

  /**
   * 角色列表(全部)
   *
   * @param request 角色实体
   * @return {@link List}
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  List<AuthRole> list(AuthRole request) throws Exception;

  /**
   * 角色列表(分页)
   *
   * @param request 角色实体
   * @return {@link Page}
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  Page<AuthRole> pages(AuthRole request, Integer pageSize, Integer pageNum) throws Exception;

  /**
   * 角色详情
   *
   * @param id 角色id
   * @return {@link AuthRole}
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  AuthRole details(String id) throws Exception;

  /**
   * 角色详情
   *
   * @param request 角色实体
   * @return {@link AuthRole}
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  AuthRole details(AuthRole request) throws Exception;

  /**
   * 删除角色(支持批量)
   *
   * @param ids 角色id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  boolean delete(String ids) throws Exception;

  /**
   * 批量删除角色表(根据同一属性,针对中间表)
   *
   * @param request 角色实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  boolean delete(AuthRole request) throws Exception;

  /**
   * 编辑角色表
   *
   * @param request 角色实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  boolean edit(AuthRole request) throws Exception;

  /**
   * 新增角色表
   *
   * @param request 角色实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  boolean add(AuthRole request) throws Exception;

  /**
   * 分配菜单
   *
   * @param request 分配菜单请求实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  @Transactional
  boolean assignMenu(AssignMenuReq request) throws Exception;
}
