package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.*;
import net.yiyuan.mapper.AuthRoleMapper;
import net.yiyuan.model.AuthRole;
import net.yiyuan.model.AuthRoleMenu;
import net.yiyuan.model.SysMenu;
import net.yiyuan.service.AuthRoleMenuService;
import net.yiyuan.service.AuthRoleService;
import net.yiyuan.vo.AuthRoleQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 角色Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
@Slf4j
@Service
public class AuthRoleServiceImpl extends JoinServiceImpl<AuthRoleMapper, AuthRole>
    implements AuthRoleService {
  @Resource private AuthRoleMapper authRoleMapper;
  @Resource private AuthRoleMenuService authRoleMenuService;

  /**
   * 角色列表(全部)
   *
   * @param request 角色实体
   * @return {@link List< AuthRoleQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public List<AuthRoleQueryVO> list(AuthRoleListDTO request) throws Exception {

    AuthRole po = new AuthRole();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<AuthRole> wrapper = new JoinLambdaWrapper<>(po);
    List<AuthRoleQueryVO> voList = joinList(wrapper, AuthRoleQueryVO.class);

    return voList;
  }

  /**
   * 角色列表(分页)
   *
   * @param request 角色实体
   * @return {@link Page< AuthRoleQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public Page<AuthRoleQueryVO> page(AuthRolePageDTO request) throws Exception {
    AuthRole po = new AuthRole();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<AuthRole> wrapper = new JoinLambdaWrapper<>(po);

    Page<AuthRoleQueryVO> voPage =
        joinPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            AuthRoleQueryVO.class);

    return voPage;
  }

  /**
   * 角色详情
   *
   * @param id 角色id
   * @return {@link AuthRoleQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public AuthRoleQueryVO details(String id) throws Exception {
    AuthRole po = new AuthRole();
    po.setId(id);
    JoinLambdaWrapper<AuthRole> wrapper = new JoinLambdaWrapper<>(po);
    AuthRoleQueryVO voBean = joinGetOne(wrapper, AuthRoleQueryVO.class);
    List<SysMenu> sysMenuList = joinMenuList(voBean.getId());
    voBean.setSysMenuList(sysMenuList);
    return voBean;
  }

  /**
   * 角色详情
   *
   * @param request 角色实体
   * @return {@link AuthRole}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public AuthRoleQueryVO details(AuthRole request) throws Exception {

    JoinLambdaWrapper<AuthRole> wrapper = new JoinLambdaWrapper<>(request);
    AuthRoleQueryVO voBean = joinGetOne(wrapper, AuthRoleQueryVO.class);
    return voBean;
  }

  /**
   * 删除角色(支持批量)
   *
   * @param ids 角色id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public boolean delete(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids.split(",")));
  }

  /**
   * 编辑角色
   *
   * @param request 角色实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public boolean edit(AuthRoleEditDTO request) throws Exception {
    AuthRole po = new AuthRole();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<AuthRole> wrapper = new JoinLambdaWrapper<>(po);
    return updateById(po);
  }

  /**
   * 新增角色
   *
   * @param request 角色实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public boolean add(AuthRoleAddDTO request) throws Exception {
    AuthRole po = new AuthRole();
    BeanUtilsPlus.copy(request, po);
    return save(po);
  }

  @Override
  public boolean assignMenu(AuthRoleAssignMenuDTO request) throws Exception {
    List<AuthRoleMenu> addList = new ArrayList<>();
    List<String> menuIdList = request.getMenuIdList();
    menuIdList.forEach(
        (e) -> {
          AuthRoleMenu item = new AuthRoleMenu();
          item.setRoleId(request.getRoleId());
          item.setMenuId(e);
          addList.add(item);
        });

    // 先删除原来绑定的菜单id
    authRoleMenuService.deleteByRoleId(request.getRoleId());
    // 在全量增加现在的
    authRoleMenuService.saveBatch(addList);
    return true;
  }

  public List<SysMenu> joinMenuList(String roleId) {
    AuthRoleMenu po = new AuthRoleMenu();
    po.setRoleId(roleId);
    JoinLambdaWrapper<AuthRoleMenu> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.notDefaultSelectAll();
    wrapper
        .leftJoin(SysMenu.class, SysMenu::getId, AuthRoleMenu::getMenuId)
        .selectAll()
        //        .manyToManySelect(AuthRoleQueryVO::getSysMenuList, SysMenu.class)
        .end();

    List<SysMenu> sysMenuList = authRoleMenuService.joinList(wrapper, SysMenu.class);
    return sysMenuList;
  }
}
