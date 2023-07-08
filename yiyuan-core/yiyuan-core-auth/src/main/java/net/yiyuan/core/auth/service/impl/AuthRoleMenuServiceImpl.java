package net.yiyuan.core.auth.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.core.auth.mapper.AuthRoleMenuMapper;
import net.yiyuan.core.auth.model.AuthRoleMenu;
import net.yiyuan.core.auth.service.AuthRoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
/**
 * 角色_菜单管理Service层接口实现
 *
 * @author 一源团队--花和尚
 * @date 2023-07-02
 */
@Slf4j
@Service
public class AuthRoleMenuServiceImpl extends JoinServiceImpl<AuthRoleMenuMapper, AuthRoleMenu>
    implements AuthRoleMenuService {
  @Resource private AuthRoleMenuMapper authRoleMenuMapper;

  /**
   * 角色_菜单列表(全部)
   *
   * @param request 角色_菜单实体
   * @return {@link List}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @Override
  public List<AuthRoleMenu> list(AuthRoleMenu request) throws Exception {
    AuthRoleMenu query = new AuthRoleMenu();
    JoinLambdaWrapper<AuthRoleMenu> wrapper = new JoinLambdaWrapper<>(request);
    return joinList(wrapper, AuthRoleMenu.class);
  }

  /**
   * 角色_菜单列表(分页)
   *
   * @param request 角色_菜单实体
   * @return {@link Page}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @Override
  public Page<AuthRoleMenu> pages(AuthRoleMenu request, Integer pageSize, Integer pageNum)
      throws Exception {
    AuthRoleMenu query = new AuthRoleMenu();
    JoinLambdaWrapper<AuthRoleMenu> wrapper = new JoinLambdaWrapper<>(request);
    wrapper.orderByDesc(AuthRoleMenu::getCreatedTime);

    Page<AuthRoleMenu> page = joinPage(new Page<>(pageNum, pageSize), wrapper, AuthRoleMenu.class);
    return page;
  }

  /**
   * 角色_菜单详情
   *
   * @param request 角色_菜单实体
   * @return {@link AuthRoleMenu}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @Override
  public AuthRoleMenu details(AuthRoleMenu request) throws Exception {
    AuthRoleMenu query = new AuthRoleMenu();
    JoinLambdaWrapper<AuthRoleMenu> wrapper = new JoinLambdaWrapper<>(request);
    return joinGetOne(wrapper, AuthRoleMenu.class);
  }

  /**
   * 删除角色_菜单表
   *
   * @param request 角色_菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @Override
  public boolean del(AuthRoleMenu request) throws Exception {
    return removeById(request);
  }

  /**
   * 批量删除角色_菜单表
   *
   * @param ids 逗号分割id
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @Override
  public boolean dels(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids.split(",")));
  }

  /**
   * 批量删除角色_菜单表(根据同一属性)
   *
   * @param request 角色_菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @Override
  public boolean dels(AuthRoleMenu request) throws Exception {
    JoinLambdaWrapper<AuthRoleMenu> wrapper = new JoinLambdaWrapper<>(request);
    return remove(wrapper);
  }

  /**
   * 编辑角色_菜单表
   *
   * @param request 角色_菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @Override
  public boolean edit(AuthRoleMenu request) throws Exception {
    request.setUpdatedTime(new Date());
    return updateById(request);
  }

  /**
   * 新增角色_菜单表
   *
   * @param request 角色_菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @Override
  public boolean add(AuthRoleMenu request) throws Exception {
    request.setCreatedTime(new Date());
    request.setUpdatedTime(new Date());
    return save(request);
  }
}
