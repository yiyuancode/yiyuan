package net.yiyuan.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.constatnt.ResultCode;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.common.utils.StringUtilsPlus;
import net.yiyuan.dto.*;
import net.yiyuan.mapper.*;
import net.yiyuan.model.SysRole;
import net.yiyuan.model.SysUser;
import net.yiyuan.model.SysUserRole;
import net.yiyuan.service.SysUserService;
import net.yiyuan.vo.SysUserAdminAccoutLoginVO;
import net.yiyuan.vo.SysUserQueryVO;
import net.yiyuan.vo.SysUserTenantAccoutLoginVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 管理端用户Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Slf4j
@Service
public class SysUserServiceImpl extends JoinServiceImpl<SysUserMapper, SysUser>
    implements SysUserService {
  @Resource private SysUserMapper sysUserMapper;
  @Resource private SysUserRoleMapper sysUserRoleMapper;
  @Resource private SysRoleMapper sysRoleMapper;
  @Resource private SysMenuMapper sysMenuMapper;
  @Resource private SysRoleMenuMapper sysRoleMenuMapper;
  /**
   * 管理端用户列表(全部)
   *
   * @param request 管理端用户实体
   * @return {@link List< SysUserQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public List<SysUserQueryVO> list(SysUserListDTO request) throws Exception {

    SysUser po = new SysUser();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysUser> wrapper = new JoinLambdaWrapper<>(po);
    List<SysUserQueryVO> voList = sysUserMapper.joinSelectList(wrapper, SysUserQueryVO.class);

    return voList;
  }

  /**
   * 管理端用户列表(分页)
   *
   * @param request 管理端用户实体
   * @return {@link Page< SysUserQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public Page<SysUserQueryVO> page(SysUserPageDTO request) throws Exception {
    SysUser po = new SysUser();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysUser> wrapper = new JoinLambdaWrapper<>(po);
    Page<SysUserQueryVO> voPage =
        sysUserMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()), wrapper, SysUserQueryVO.class);
    return voPage;
  }

  /**
   * 管理端用户详情
   *
   * @param id 管理端用户id
   * @return {@link SysUserQueryVO}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public SysUserQueryVO details(String id) throws Exception {
    SysUser po = new SysUser();
    po.setId(id);
    JoinLambdaWrapper<SysUser> wrapper = new JoinLambdaWrapper<>(po);
    SysUserQueryVO voBean = sysUserMapper.joinSelectOne(wrapper, SysUserQueryVO.class);
    return voBean;
  }

  /**
   * 管理端用户详情
   *
   * @param request 管理端用户实体
   * @return {@link SysUser}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public SysUserQueryVO details(SysUser request) throws Exception {
    JoinLambdaWrapper<SysUser> wrapper = new JoinLambdaWrapper<>(request);
    SysUserQueryVO voBean = sysUserMapper.joinSelectOne(wrapper, SysUserQueryVO.class);
    return voBean;
  }

  /**
   * 删除管理端用户(支持批量)
   *
   * @param ids 管理端用户id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    int i = sysUserMapper.deleteBatchIds(idList);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑管理端用户
   *
   * @param request 管理端用户实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean edit(SysUserEditDTO request) throws Exception {
    SysUser po = new SysUser();
    BeanUtilsPlus.copy(request, po);
    int i = sysUserMapper.updateById(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增管理端用户
   *
   * @param request 管理端用户实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean add(SysUserAddDTO request) throws Exception {
    SysUser po = new SysUser();
    BeanUtilsPlus.copy(request, po);
    int i = sysUserMapper.insert(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }

  @Override
  public SysUserAdminAccoutLoginVO adminAccoutLogin(SysUserAdminAccoutLoginDTO request)
      throws Exception {
    SysUser po = new SysUser();
    BeanUtilsPlus.copy(request, po);
    // 查询用户名是否存在
    JoinLambdaWrapper<SysUser> sysUserwrapper = new JoinLambdaWrapper<>(SysUser.class);
    sysUserwrapper.eq(SysUser::getUsername, po.getUsername());
    SysUserQueryVO sysUserResp = sysUserMapper.joinSelectOne(sysUserwrapper, SysUserQueryVO.class);
    if (StringUtilsPlus.isNull(sysUserResp)) {
      throw new BusinessException(ResultCode.USER_NOT_FIND);
    }
    if (sysUserResp.getPassword().equals(po.getPassword())) {
      throw new BusinessException(ResultCode.USER_PASS_ERROR);
    }
    // 使用用户id完成satoken登录,并返回token
    StpUtil.login(sysUserResp.getId());
    SysUserAdminAccoutLoginVO voBean = new SysUserAdminAccoutLoginVO();
    voBean.setToken(StpUtil.getTokenValue());
    // 关联查询角色信息
    sysUserResp = this.joinSysRoleOne(sysUserResp);
    return voBean;
  }

  @Override
  public SysUserTenantAccoutLoginVO tenantAccoutLogin(SysUserTenantAccoutLoginDTO request)
      throws Exception {
    return null;
  }

  /**
   * 关联查询角色信息-单个
   *
   * @param sysUser 用户查询对象
   * @return {@link SysUserQueryVO}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  public SysUserQueryVO joinSysRoleOne(SysUserQueryVO sysUser) {
    List<SysUserQueryVO> list = new ArrayList<>();
    list.add(sysUser);
    this.joinSysRoleList(list);
    return list.get(list.size() - 1);
  }

  /**
   * 关联查询角色信息-多个
   *
   * @param sysUserList 用户查询对象集合
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  public void joinSysRoleList(List<SysUserQueryVO> sysUserList) {
    // 获取idList
    List<String> sysUserIdsList =
        sysUserList.stream()
            .map(SysUserQueryVO::getId)
            .map(String::toString)
            .distinct()
            .collect(Collectors.toList());
    // id去重
    sysUserIdsList =
        sysUserIdsList.stream().map(String::toString).distinct().collect(Collectors.toList());

    // 根据去重得用户id查询关联表得所有角色id
    JoinLambdaWrapper<SysUserRole> sysUserRolewrapper = new JoinLambdaWrapper<>(SysUserRole.class);
    sysUserRolewrapper.in(SysUserRole::getSysUserId, sysUserIdsList);
    // 指定只查询关联角色id
    sysUserRolewrapper.select(SysUserRole::getSysRoleId);
    List<SysUserRole> sysUserRoleRespList =
        sysUserRoleMapper.joinSelectList(sysUserRolewrapper, SysUserRole.class);
    // 转成纯角色id的集合,因为mp查询支持id集合
    List<String> roleIdsList =
        sysUserRoleRespList.stream()
            .map(SysUserRole::getSysRoleId)
            .map(String::toString)
            .distinct()
            .collect(Collectors.toList());

    JoinLambdaWrapper<SysRole> sysRolewrapper = new JoinLambdaWrapper<>(SysRole.class);
    sysRolewrapper.in(SysRole::getId, roleIdsList);
    // 不指定select,默认查询所有字段
    List<SysRole> sysRoleRespList = sysRoleMapper.joinSelectList(sysRolewrapper, SysRole.class);
    // 使用流操作将List转换为Map,便于根据id直接获取,避免再次循环
    Map<String, SysRole> map =
        sysRoleRespList.stream().collect(Collectors.toMap(SysRole::getId, obj -> obj));
    // 给list设置

  }
}
