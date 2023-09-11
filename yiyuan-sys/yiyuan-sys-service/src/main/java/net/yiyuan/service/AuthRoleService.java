package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.*;
import net.yiyuan.model.AuthRole;
import net.yiyuan.vo.AuthRoleQueryVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 角色Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
public interface AuthRoleService extends JoinIService<AuthRole> {

  /**
   * 角色列表(全部)
   *
   * @param request 角色实体
   * @return {@link List< AuthRoleQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  List<AuthRoleQueryVO> list(AuthRoleListDTO request) throws Exception;

  /**
   * 角色列表(分页)
   *
   * @param request 角色实体
   * @return {@link Page< AuthRoleQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  Page<AuthRoleQueryVO> page(AuthRolePageDTO request) throws Exception;

  /**
   * 角色详情
   *
   * @param id 角色id
   * @return {@link AuthRoleQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  AuthRoleQueryVO details(String id) throws Exception;

  /**
   * 角色详情
   *
   * @param request 角色实体
   * @return {@link AuthRole}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  AuthRoleQueryVO details(AuthRole request) throws Exception;

  /**
   * 删除角色(支持批量)
   *
   * @param ids 角色id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑角色
   *
   * @param request 角色实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  boolean edit(AuthRoleEditDTO request) throws Exception;

  /**
   * 新增角色
   *
   * @param request 角色实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  boolean add(AuthRoleAddDTO request) throws Exception;

  /**
   * 分配菜单
   *
   * @param request 分配菜单请求实体
   * @return {@link boolean}
   * @author ${author}
   * @date 2023-06-24
   */
  @Transactional
  boolean assignMenu(AuthRoleAssignMenuDTO request) throws Exception;
}
