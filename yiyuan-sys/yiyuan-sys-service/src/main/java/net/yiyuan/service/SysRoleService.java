package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.SysRoleAddDTO;
import net.yiyuan.dto.SysRoleEditDTO;
import net.yiyuan.dto.SysRoleListDTO;
import net.yiyuan.dto.SysRolePageDTO;
import net.yiyuan.model.SysRole;
import net.yiyuan.vo.SysRoleQueryVO;

import java.util.List;

/**
 * 管理端角色Service层接口
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
public interface SysRoleService extends JoinIService<SysRole> {

  /**
   * 管理端角色列表(全部)
   *
   * @param request 管理端角色实体
   * @return {@link List< SysRoleQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  List<SysRoleQueryVO> list(SysRoleListDTO request) throws Exception;

  /**
   * 管理端角色列表(分页)
   *
   * @param request 管理端角色实体
   * @return {@link Page< SysRoleQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  Page<SysRoleQueryVO> page(SysRolePageDTO request) throws Exception;

  /**
   * 管理端角色详情
   *
   * @param id 管理端角色id
   * @return {@link SysRoleQueryVO}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  SysRoleQueryVO details(String id) throws Exception;

  /**
   * 管理端角色详情
   *
   * @param request 管理端角色实体
   * @return {@link SysRole}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  SysRoleQueryVO details(SysRole request) throws Exception;

  /**
   * 删除管理端角色(支持批量)
   *
   * @param ids 管理端角色id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑管理端角色
   *
   * @param request 管理端角色实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  boolean edit(SysRoleEditDTO request) throws Exception;

  /**
   * 新增管理端角色
   *
   * @param request 管理端角色实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  boolean add(SysRoleAddDTO request) throws Exception;
}
