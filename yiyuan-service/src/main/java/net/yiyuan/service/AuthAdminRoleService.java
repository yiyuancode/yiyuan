package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.AuthAdminRoleAddDTO;
import net.yiyuan.dto.AuthAdminRoleEditDTO;
import net.yiyuan.dto.AuthAdminRoleListDTO;
import net.yiyuan.dto.AuthAdminRolePageDTO;
import net.yiyuan.model.AuthAdminRole;
import net.yiyuan.vo.AuthAdminRoleQueryVO;

import java.util.List;

/**
 * 用户_角色Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
public interface AuthAdminRoleService extends JoinIService<AuthAdminRole> {

  /**
   * 用户_角色列表(全部)
   *
   * @param request 用户_角色实体
   * @return {@link List< AuthAdminRoleQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  List<AuthAdminRoleQueryVO> list(AuthAdminRoleListDTO request) throws Exception;

  /**
   * 用户_角色列表(分页)
   *
   * @param request 用户_角色实体
   * @return {@link Page< AuthAdminRoleQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  Page<AuthAdminRoleQueryVO> page(AuthAdminRolePageDTO request) throws Exception;

  /**
   * 用户_角色详情
   *
   * @param id 用户_角色id
   * @return {@link AuthAdminRoleQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  AuthAdminRoleQueryVO details(String id) throws Exception;

  /**
   * 用户_角色详情
   *
   * @param request 用户_角色实体
   * @return {@link AuthAdminRole}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  AuthAdminRoleQueryVO details(AuthAdminRole request) throws Exception;

  /**
   * 删除用户_角色(支持批量)
   *
   * @param ids 用户_角色id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑用户_角色
   *
   * @param request 用户_角色实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  boolean edit(AuthAdminRoleEditDTO request) throws Exception;

  /**
   * 新增用户_角色
   *
   * @param request 用户_角色实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  boolean add(AuthAdminRoleAddDTO request) throws Exception;

  /**
   * 根据用户id批量删除
   *
   * @param userId 用户id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  boolean deleteByUserId(String userId) throws Exception;
}
