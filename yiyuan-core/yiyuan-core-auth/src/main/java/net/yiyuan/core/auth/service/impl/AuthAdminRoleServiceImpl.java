package net.yiyuan.core.auth.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.core.auth.mapper.AuthAdminRoleMapper;
import net.yiyuan.core.auth.model.AuthAdminRole;
import net.yiyuan.core.auth.service.AuthAdminRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
/**
 * 用户_角色管理Service层接口实现
 *
 * @author 一源团队--花和尚
 * @date 2023-07-09
 */
@Slf4j
@Service
public class AuthAdminRoleServiceImpl extends JoinServiceImpl<AuthAdminRoleMapper, AuthAdminRole>
    implements AuthAdminRoleService {
  @Resource private AuthAdminRoleMapper authAdminRoleMapper;

  /**
   * 用户_角色列表(全部)
   *
   * @param request 用户_角色实体
   * @return {@link List}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  @Override
  public List<AuthAdminRole> list(AuthAdminRole request) throws Exception {
    AuthAdminRole query = new AuthAdminRole();
    JoinLambdaWrapper<AuthAdminRole> wrapper = new JoinLambdaWrapper<>(request);
    return joinList(wrapper, AuthAdminRole.class);
  }

  /**
   * 用户_角色列表(分页)
   *
   * @param request 用户_角色实体
   * @return {@link Page}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  @Override
  public Page<AuthAdminRole> pages(AuthAdminRole request, Integer pageSize, Integer pageNum)
      throws Exception {
    AuthAdminRole query = new AuthAdminRole();
    JoinLambdaWrapper<AuthAdminRole> wrapper = new JoinLambdaWrapper<>(request);
    wrapper.orderByDesc(AuthAdminRole::getCreatedTime);

    Page<AuthAdminRole> page =
        joinPage(new Page<>(pageNum, pageSize), wrapper, AuthAdminRole.class);
    return page;
  }

  /**
   * 用户_角色详情
   *
   * @param request 用户_角色实体
   * @return {@link AuthAdminRole}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  @Override
  public AuthAdminRole details(AuthAdminRole request) throws Exception {
    AuthAdminRole query = new AuthAdminRole();
    JoinLambdaWrapper<AuthAdminRole> wrapper = new JoinLambdaWrapper<>(request);
    return joinGetOne(wrapper, AuthAdminRole.class);
  }

  /**
   * 删除用户_角色表
   *
   * @param request 用户_角色实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  @Override
  public boolean del(AuthAdminRole request) throws Exception {
    return removeById(request);
  }

  /**
   * 批量删除用户_角色表
   *
   * @param ids 逗号分割id
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  @Override
  public boolean dels(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids.split(",")));
  }

  /**
   * 批量删除用户_角色表(根据同一属性)
   *
   * @param request 角色_菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @Override
  public boolean dels(AuthAdminRole request) throws Exception {
    JoinLambdaWrapper<AuthAdminRole> wrapper = new JoinLambdaWrapper<>(request);
    return remove(wrapper);
  }

  /**
   * 编辑用户_角色表
   *
   * @param request 用户_角色实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  @Override
  public boolean edit(AuthAdminRole request) throws Exception {
    request.setUpdatedTime(new Date());
    return updateById(request);
  }

  /**
   * 新增用户_角色表
   *
   * @param request 用户_角色实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  @Override
  public boolean add(AuthAdminRole request) throws Exception {
    request.setCreatedTime(new Date());
    request.setUpdatedTime(new Date());
    return save(request);
  }
}
