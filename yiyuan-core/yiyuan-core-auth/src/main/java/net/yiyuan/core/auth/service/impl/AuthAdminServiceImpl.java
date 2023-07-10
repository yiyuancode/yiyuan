package net.yiyuan.core.auth.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.core.auth.mapper.AuthAdminMapper;
import net.yiyuan.core.auth.model.AuthAdmin;
import net.yiyuan.core.auth.model.AuthAdminRole;
import net.yiyuan.core.auth.model.req.AssignRoleReq;
import net.yiyuan.core.auth.service.AuthAdminRoleService;
import net.yiyuan.core.auth.service.AuthAdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
/**
 * 用户管理Service层接口实现
 *
 * @author 一源团队--花和尚
 * @date 2023-07-09
 */
@Slf4j
@Service
public class AuthAdminServiceImpl extends JoinServiceImpl<AuthAdminMapper, AuthAdmin>
    implements AuthAdminService {
  @Resource private AuthAdminMapper authAdminMapper;
  @Resource private AuthAdminRoleService authAdminRoleService;
  @Resource private TransactionTemplate transactionTemplate;
  /**
   * 用户列表(全部)
   *
   * @param request 用户实体
   * @return {@link List}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  @Override
  public List<AuthAdmin> list(AuthAdmin request) throws Exception {
    AuthAdmin query = new AuthAdmin();
    JoinLambdaWrapper<AuthAdmin> wrapper = new JoinLambdaWrapper<>(request);
    return joinList(wrapper, AuthAdmin.class);
  }

  /**
   * 用户列表(分页)
   *
   * @param request 用户实体
   * @return {@link Page}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  @Override
  public Page<AuthAdmin> pages(AuthAdmin request, Integer pageSize, Integer pageNum)
      throws Exception {
    AuthAdmin query = new AuthAdmin();
    JoinLambdaWrapper<AuthAdmin> wrapper = new JoinLambdaWrapper<>(request);
    wrapper.orderByDesc(AuthAdmin::getCreatedTime);

    Page<AuthAdmin> page = joinPage(new Page<>(pageNum, pageSize), wrapper, AuthAdmin.class);
    return page;
  }

  /**
   * 用户详情
   *
   * @param request 用户实体
   * @return {@link AuthAdmin}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  @Override
  public AuthAdmin details(AuthAdmin request) throws Exception {
    AuthAdmin query = new AuthAdmin();
    JoinLambdaWrapper<AuthAdmin> wrapper = new JoinLambdaWrapper<>(request);
    return joinGetOne(wrapper, AuthAdmin.class);
  }

  /**
   * 删除用户表
   *
   * @param request 用户实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  @Override
  public boolean del(AuthAdmin request) throws Exception {
    return removeById(request);
  }

  /**
   * 批量删除用户表
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
   * 批量删除用户表(根据同一属性)
   *
   * @param request 角色_菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @Override
  public boolean dels(AuthAdmin request) throws Exception {
    JoinLambdaWrapper<AuthAdmin> wrapper = new JoinLambdaWrapper<>(request);
    return remove(wrapper);
  }

  /**
   * 编辑用户表
   *
   * @param request 用户实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  @Override
  public boolean edit(AuthAdmin request) throws Exception {
    request.setUpdatedTime(new Date());
    return updateById(request);
  }

  /**
   * 新增用户表
   *
   * @param request 用户实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  @Override
  public boolean add(AuthAdmin request) throws Exception {
    request.setCreatedTime(new Date());
    request.setUpdatedTime(new Date());
    return save(request);
  }

  /**
   * 分配角色
   *
   * @param request 分配角色请求实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  @Override
  public boolean assignRole(AssignRoleReq request) throws Exception {
    List<AuthAdminRole> addList = new ArrayList<>();
    List<String> rolesIdList = request.getRolesIdList();
    rolesIdList.forEach(
        (e) -> {
          AuthAdminRole item = new AuthAdminRole();
          item.setUserId(request.getUserId());
          item.setRoleId(e);
          addList.add(item);
        });

    boolean result =
        transactionTemplate.execute(
            status -> {
              try {
                // 先删除原来绑定的菜单id
                AuthAdminRole query = new AuthAdminRole();
                query.setRoleId(request.getUserId());
                authAdminRoleService.dels(query);
                // 在全量增加现在的
                authAdminRoleService.saveBatch(addList);
              } catch (Exception e) {
                e.printStackTrace();
                status.setRollbackOnly();
                throw new Error("分配角色异常");
              }
              return true;
            });

    return result;
  }
}
