package net.yiyuan.core.auth.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.core.auth.model.AuthAdmin;
import net.yiyuan.core.auth.model.req.AssignRoleReq;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * 用户管理Service层接口
 *
 * @author 一源团队--花和尚
 * @date 2023-07-15
 */
public interface AuthAdminService extends JoinIService<AuthAdmin> {

  /**
   * 用户列表(全部)
   *
   * @param request 用户实体
   * @return {@link List}
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  List<AuthAdmin> list(AuthAdmin request) throws Exception;

  /**
   * 用户列表(分页)
   *
   * @param request 用户实体
   * @return {@link Page}
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  Page<AuthAdmin> pages(AuthAdmin request, Integer pageSize, Integer pageNum) throws Exception;

  /**
   * 用户详情
   *
   * @param id 用户id
   * @return {@link AuthAdmin}
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  AuthAdmin details(String id) throws Exception;

  /**
   * 用户详情
   *
   * @param request 用户实体
   * @return {@link AuthAdmin}
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  AuthAdmin details(AuthAdmin request) throws Exception;

  /**
   * 删除用户(支持批量)
   *
   * @param ids 用户id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  boolean delete(String ids) throws Exception;

  /**
   * 批量删除用户表(根据同一属性,针对中间表)
   *
   * @param request 用户实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  boolean delete(AuthAdmin request) throws Exception;

  /**
   * 编辑用户表
   *
   * @param request 用户实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  boolean edit(AuthAdmin request) throws Exception;

  /**
   * 新增用户表
   *
   * @param request 用户实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-15
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
  @Transactional
  boolean assignRole(AssignRoleReq request) throws Exception;
}
