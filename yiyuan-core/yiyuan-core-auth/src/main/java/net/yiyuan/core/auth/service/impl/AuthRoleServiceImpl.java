package net.yiyuan.core.auth.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.core.auth.dto.*;
import net.yiyuan.core.auth.mapper.AuthRoleMapper;
import net.yiyuan.core.auth.model.AuthRole;
import net.yiyuan.core.auth.model.AuthRoleMenu;
import net.yiyuan.core.auth.service.AuthRoleMenuService;
import net.yiyuan.core.auth.service.AuthRoleService;
import net.yiyuan.core.auth.vo.AuthAdminQueryVO;
import net.yiyuan.core.auth.vo.AuthRoleQueryVO;
import net.yiyuan.core.sys.model.SysMenu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 角色管理Service层接口实现
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
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
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public List<AuthRoleQueryVO> list(AuthRoleListDTO request) throws Exception {

    AuthRole po = new AuthRole();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<AuthRole> wrapper = new JoinLambdaWrapper<>(po);
    joinMenuList(wrapper);
    List<AuthRoleQueryVO> voList = joinList(wrapper, AuthRoleQueryVO.class);

    return voList;
  }

  /**
   * 角色列表(分页)
   *
   * @param request 角色实体
   * @return {@link Page< AuthRoleQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public Page<AuthRoleQueryVO> page(AuthRolePageDTO request) throws Exception {
    AuthRole po = new AuthRole();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<AuthRole> wrapper = new JoinLambdaWrapper<>(po);
    joinMenuList(wrapper);
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
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public AuthRoleQueryVO details(String id) throws Exception {
    AuthRole po = new AuthRole();
    po.setId(id);
    JoinLambdaWrapper<AuthRole> wrapper = new JoinLambdaWrapper<>(po);
    AuthRoleQueryVO voBean = joinGetOne(wrapper, AuthRoleQueryVO.class);
    return voBean;
  }

  /**
   * 角色详情
   *
   * @param request 角色实体
   * @return {@link AuthRole}
   * @author 一源团队--花和尚
   * @date 2023-07-27
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
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public boolean delete(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids.split(",")));
  }

  /**
   * 批量删除角色(根据同一属性,针对中间表)
   *
   * @param request 角色实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public boolean delete(AuthRole request) throws Exception {
    JoinLambdaWrapper<AuthRole> wrapper = new JoinLambdaWrapper<>(request);
    return remove(wrapper);
  }

  /**
   * 编辑角色
   *
   * @param request 角色实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
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
   * @author 一源团队--花和尚
   * @date 2023-07-27
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
    AuthRoleMenu query = new AuthRoleMenu();
    query.setRoleId(request.getRoleId());
    authRoleMenuService.delete(query);
    // 在全量增加现在的
    authRoleMenuService.saveBatch(addList);
    return true;
  }

  public void joinMenuList(JoinLambdaWrapper<AuthRole> wrapper) {
    wrapper
        .leftJoin(AuthRoleMenu.class, AuthRoleMenu::getRoleId, AuthRole::getId)
        .end()
        .leftJoin(SysMenu.class, SysMenu::getId, AuthRoleMenu::getMenuId)
        .manyToManySelect(AuthRoleQueryVO::getMenuList, SysMenu.class)
        .end();
  }
}
