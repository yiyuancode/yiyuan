package net.yiyuan.core.auth.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.core.auth.dto.*;
import net.yiyuan.core.auth.model.AuthAdmin;
import net.yiyuan.core.auth.vo.AuthAdminQueryVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户管理Service层接口
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
public interface AuthAdminService extends JoinIService<AuthAdmin> {

  /**
   * 用户列表(全部)
   *
   * @param request 用户实体
   * @return {@link List< AuthAdminQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  List<AuthAdminQueryVO> list(AuthAdminListDTO request) throws Exception;

  /**
   * 用户列表(分页)
   *
   * @param request 用户实体
   * @return {@link Page< AuthAdminQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  Page<AuthAdminQueryVO> page(AuthAdminPageDTO request) throws Exception;

  /**
   * 用户详情
   *
   * @param id 用户id
   * @return {@link AuthAdminQueryVO}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  AuthAdminQueryVO details(String id) throws Exception;

  /**
   * 用户详情
   *
   * @param request 用户实体
   * @return {@link AuthAdmin}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  AuthAdminQueryVO details(AuthAdmin request) throws Exception;

  /**
   * 用户详情-精准匹配
   *
   * @param request 用户实体
   * @return {@link AuthAdmin}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  AuthAdminQueryVO detailsEqual(AuthAdmin request) throws Exception;

  /**
   * 删除用户(支持批量)
   *
   * @param ids 用户id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  boolean delete(String ids) throws Exception;

  /**
   * 批量删除用户(根据同一属性,针对中间表)
   *
   * @param request 用户实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  boolean delete(AuthAdmin request) throws Exception;

  /**
   * 编辑用户
   *
   * @param request 用户实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  boolean edit(AuthAdminEditDTO request) throws Exception;

  /**
   * 新增用户
   *
   * @param request 用户实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  boolean add(AuthAdminAddDTO request) throws Exception;

  /**
   * 分配角色
   *
   * @param request 分配角色请求实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  @Transactional
  boolean assignRole(AuthAdminAssignRoleDTO request) throws Exception;

  /**
   * 查询用户信息关联查询角色和菜单信息
   *
   * @param id 用户id
   * @return {@link AuthAdminQueryVO}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  AuthAdminQueryVO detailsJoinRoleAndPermission(String id) throws Exception;

  /**
   * 查询在线用户列表
   *
   * @return {@link Page<AuthAdminQueryVO>}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  Page<AuthAdminQueryVO> online(AuthAdminPageDTO request) throws Exception;
}
