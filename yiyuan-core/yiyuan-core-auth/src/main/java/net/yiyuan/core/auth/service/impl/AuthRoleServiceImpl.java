package net.yiyuan.core.auth.service.impl;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.context.model.SaRequest;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.core.auth.mapper.AuthRoleMapper;
import net.yiyuan.core.auth.model.AuthRole;
import net.yiyuan.core.auth.model.AuthRoleMenu;
import net.yiyuan.core.auth.model.req.AssignMenuReq;
import net.yiyuan.core.auth.service.AuthRoleMenuService;
import net.yiyuan.core.auth.service.AuthRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
/**
 * 角色管理Service层接口实现
 *
 * @author 一源团队--花和尚
 * @date 2023-07-11
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
   * @return {@link List}
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  @Override
  public List<AuthRole> list(AuthRole request) throws Exception {
    AuthRole query = new AuthRole();
    JoinLambdaWrapper<AuthRole> wrapper = new JoinLambdaWrapper<>(request);
    return joinList(wrapper, AuthRole.class);
  }

  /**
   * 角色列表(分页)
   *
   * @param request 角色实体
   * @return {@link Page}
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  @Override
  public Page<AuthRole> pages(AuthRole request, Integer pageSize, Integer pageNum)
      throws Exception {
    AuthRole query = new AuthRole();
    JoinLambdaWrapper<AuthRole> wrapper = new JoinLambdaWrapper<>(request);
    wrapper.orderByDesc(AuthRole::getCreatedTime);

    Page<AuthRole> page = joinPage(new Page<>(pageNum, pageSize), wrapper, AuthRole.class);
    return page;
  }

  /**
   * 角色详情
   *
   * @param id 角色id
   * @return {@link AuthRole}
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  @Override
  public AuthRole details(String id) throws Exception {
    AuthRole query = new AuthRole();
    query.setId(id);
    JoinLambdaWrapper<AuthRole> wrapper = new JoinLambdaWrapper<>(query);
    return joinGetOne(wrapper, AuthRole.class);
  }

  /**
   * 角色详情
   *
   * @param request 角色实体
   * @return {@link AuthRole}
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  @Override
  public AuthRole details(AuthRole request) throws Exception {
    JoinLambdaWrapper<AuthRole> wrapper = new JoinLambdaWrapper<>(request);
    return joinGetOne(wrapper, AuthRole.class);
  }

  /**
   * 删除角色(支持批量)
   *
   * @param ids 角色id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  @Override
  public boolean delete(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids.split(",")));
  }

  /**
   * 批量删除角色表(根据同一属性,针对中间表)
   *
   * @param request 角色实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  @Override
  public boolean delete(AuthRole request) throws Exception {
    JoinLambdaWrapper<AuthRole> wrapper = new JoinLambdaWrapper<>(request);
    return remove(wrapper);
  }

  /**
   * 编辑角色表
   *
   * @param request 角色实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  @Override
  public boolean edit(AuthRole request) throws Exception {
    request.setUpdatedTime(new Date());
    return updateById(request);
  }

  /**
   * 新增角色表
   *
   * @param request 角色实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  @Override
  public boolean add(AuthRole request) throws Exception {
    request.setCreatedTime(new Date());
    request.setUpdatedTime(new Date());
    return save(request);
  }

  /**
   * 分配菜单
   *
   * @param request 分配菜单请求实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  @Override
  public boolean assignMenu(AssignMenuReq request) throws Exception {
    List<AuthRoleMenu> addList = new ArrayList<>();
    List<String> menuIdList = request.getMenuIdList();
    SaRequest httpRequest = SaHolder.getRequest();
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
}
