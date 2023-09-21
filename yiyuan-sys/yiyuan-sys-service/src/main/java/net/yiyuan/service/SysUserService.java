package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.*;
import net.yiyuan.model.SysUser;
import net.yiyuan.vo.SysUserGetUserInfoVO;
import net.yiyuan.vo.SysUserLoginVO;
import net.yiyuan.vo.SysUserQueryVO;

import java.util.List;

/**
 * 管理端用户Service层接口
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
public interface SysUserService extends JoinIService<SysUser> {

  /**
   * 管理端用户列表(全部)
   *
   * @param request 管理端用户实体
   * @return {@link List< SysUserQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  List<SysUserQueryVO> list(SysUserListDTO request) throws Exception;

  /**
   * 管理端用户列表(分页)
   *
   * @param request 管理端用户实体
   * @return {@link Page< SysUserQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  Page<SysUserQueryVO> page(SysUserPageDTO request) throws Exception;

  /**
   * 管理端用户详情
   *
   * @param id 管理端用户id
   * @return {@link SysUserQueryVO}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  SysUserQueryVO details(String id) throws Exception;

  /**
   * 管理端用户详情
   *
   * @param request 管理端用户实体
   * @return {@link SysUser}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  SysUserQueryVO details(SysUser request) throws Exception;

  /**
   * 删除管理端用户(支持批量)
   *
   * @param ids 管理端用户id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑管理端用户
   *
   * @param request 管理端用户实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  boolean edit(SysUserEditDTO request) throws Exception;

  /**
   * 新增管理端用户
   *
   * @param request 管理端用户实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  boolean add(SysUserAddDTO request) throws Exception;

  /**
   * 登录
   *
   * @param request 管理端用户实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  SysUserLoginVO adminAccoutLogin(SysUserLoginDTO request) throws Exception;

  /**
   * 获取用户信息
   *
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  SysUserGetUserInfoVO getUserInfo() throws Exception;
}
