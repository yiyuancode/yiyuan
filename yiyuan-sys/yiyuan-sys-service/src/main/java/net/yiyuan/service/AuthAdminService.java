package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.*;
import net.yiyuan.model.AuthAdmin;
import net.yiyuan.vo.AuthAdminQueryVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
public interface AuthAdminService extends JoinIService<AuthAdmin> {

  /**
   * 用户列表(全部)
   *
   * @param request 用户实体
   * @return {@link List< AuthAdminQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  List<AuthAdminQueryVO> list(AuthAdminListDTO request) throws Exception;

  /**
   * 用户列表(分页)
   *
   * @param request 用户实体
   * @return {@link Page< AuthAdminQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  Page<AuthAdminQueryVO> page(AuthAdminPageDTO request) throws Exception;

  /**
   * 用户详情
   *
   * @param id 用户id
   * @return {@link AuthAdminQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  AuthAdminQueryVO details(String id) throws Exception;

  /**
   * 用户详情
   *
   * @param request 用户实体
   * @return {@link AuthAdmin}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  AuthAdminQueryVO details(AuthAdmin request) throws Exception;

  /**
   * 删除用户(支持批量)
   *
   * @param ids 用户id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑用户
   *
   * @param request 用户实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  boolean edit(AuthAdminEditDTO request) throws Exception;

  /**
   * 新增用户
   *
   * @param request 用户实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  boolean add(AuthAdminAddDTO request) throws Exception;

  /**
   * 查询用户信息关联查询角色和菜单信息
   *
   * @param id 用户id
   * @return {@link AuthAdminQueryVO}
   * @author ${author}
   * @date 2023-07-27
   */
  AuthAdminQueryVO detailsJoinRoleAndPermission(String id) throws Exception;

  /**
   * 分配角色
   *
   * @param request 分配角色请求实体
   * @return {@link boolean}
   * @author ${author}
   * @date 2023-06-24
   */
  @Transactional
  boolean assignRole(AuthAdminAssignRoleDTO request) throws Exception;
}
