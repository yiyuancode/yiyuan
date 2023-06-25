package net.yiyuan.admin.auth.service;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.context.model.SaRequest;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.admin.auth.model.get_user_info.GetUserInfoVo;
import net.yiyuan.admin.auth.model.get_user_info.SysMenuTreeVo;
import net.yiyuan.admin.auth.model.login.LoginReq;
import net.yiyuan.admin.auth.model.login.LoginVo;
import net.yiyuan.common.constatnt.ResultCode;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.core.auth.model.AuthAdmin;
import net.yiyuan.core.auth.model.AuthAdminRole;
import net.yiyuan.core.auth.model.AuthRole;
import net.yiyuan.core.auth.model.AuthRoleMenu;
import net.yiyuan.core.auth.service.AuthAdminRoleService;
import net.yiyuan.core.auth.service.AuthAdminService;
import net.yiyuan.core.auth.service.AuthRoleMenuService;
import net.yiyuan.core.sys.model.SysMenu;
import net.yiyuan.core.sys.service.SysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AuthService {
  @Resource AuthAdminService authAdminService;
  @Resource AuthAdminRoleService authAdminRoleService;
  @Resource AuthRoleMenuService authRoleMenuService;
  @Resource SysMenuService sysMenuService;

  /**
   * 用户_角色列表(全部)
   *
   * @param request 用户_角色实体
   * @return {@link List}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  public LoginVo login(LoginReq request) throws Exception {
    SaRequest httpRequest = SaHolder.getRequest();
    // platform 平台区分 0 平台  1 租户 2 c端
    String platform = httpRequest.getHeader("platform");
    //    String tenantId = httpRequest.getHeader("tenantId");
    // 查询用户信息
    AuthAdmin query = new AuthAdmin();
    query.setUsername(request.getUsername());
    query.setPlatform(new Integer(platform));
    AuthAdmin details = authAdminService.details(query);
    // 用户不存在
    if (ObjectUtil.isNull(details)) {
      throw new BusinessException(ResultCode.USER_NOT_FIND);
    }
    // 密码错误
    if (!details.getPassword().equals(request.getPassword())) {
      throw new BusinessException(ResultCode.USER_ERROR);
    }
    // satoken登录
    StpUtil.login(details.getId());
    String tokenValue = StpUtil.getTokenValue();
    LoginVo result = new LoginVo();
    result.setToken(tokenValue);
    //    try {
    //
    //    } catch (Exception e) {
    //      // 当上面的方法发生异常时
    //      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    //      e.printStackTrace();
    //    }
    //    return CommonResult.success(authAdminService.list(request));
    return result;
  }

  /**
   * 用户_角色列表(全部)
   *
   * @param 用户_角色实体
   * @return {@link List}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  public void register() throws Exception {
    //    return CommonResult.success(authAdminService.list(request));
  }

  /**
   * 退出登录
   *
   * @return {@link CommonResult}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  public boolean loginout() throws Exception {
    StpUtil.logout();
    return true;
    //    return CommonResult.success(authAdminService.list(request));
  }

  /**
   * 获取当前登录用户信息,包括角色以及权限菜单
   *
   * @return {@link CommonResult}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  public GetUserInfoVo getUserInfo() throws Exception {
    String loginId = StpUtil.getLoginIdAsString();
    AuthAdmin adminQuery = new AuthAdmin();
    adminQuery.setId(loginId);
    AuthAdmin details = authAdminService.details(adminQuery);
    // 查询角色
    JoinLambdaWrapper<AuthAdminRole> wrapper = new JoinLambdaWrapper<>(AuthAdminRole.class);
    wrapper.eq(AuthAdminRole::getUserId, loginId);
    wrapper.select(AuthAdminRole::getRoleId);
    wrapper
        .leftJoin(AuthRole.class, AuthRole::getId, AuthAdminRole::getRoleId)
        .select(AuthRole::getId, AuthRole::getCode, AuthRole::getName)
        .end();

    List<AuthRole> authRoles = authAdminRoleService.joinList(wrapper, AuthRole.class);

    // 查询菜单
    List<String> authRolesIdsList =
        authRoles.stream().map(p -> p.getId()).collect(Collectors.toList());
    JoinLambdaWrapper<AuthRoleMenu> wrapper2 = new JoinLambdaWrapper<>(AuthRoleMenu.class);
    wrapper2.in(AuthRoleMenu::getRoleId, authRolesIdsList);
    wrapper2.leftJoin(SysMenu.class, SysMenu::getId, AuthRoleMenu::getMenuId).selectAll().end();
    List<SysMenu> sysMenus = authRoleMenuService.joinList(wrapper2, SysMenu.class);

    // 转成权限表达式数组
    List<String> permissionList =
        sysMenus.stream().map(p -> p.getPermission()).collect(Collectors.toList());

    // 菜单list获取树结构
    List<SysMenuTreeVo> voList = selectOrganizationTree(sysMenus);

    GetUserInfoVo result = new GetUserInfoVo();
    result.setUsername(details.getUsername());
    result.setMenuTreeVoList(voList);
    result.setPermList(permissionList);
    result.setRoleList(authRoles);
    return result;
  }

  /**
   * 平台超管查询所有菜单(树结构)
   *
   * @return {@link List<SysMenuTreeVo>}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  public List<SysMenuTreeVo> adminGetMenuTree() throws Exception {
    List<SysMenu> list = sysMenuService.list(new SysMenu());
    // 菜单list获取树结构
    return selectOrganizationTree(list);
    //    return CommonResult.success(authAdminService.list(request));
  }

  /**
   * 平台超管查询所有菜单(树结构)
   *
   * @return {@link List<SysMenuTreeVo>}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  public List<SysMenuTreeVo> tenantGetMenuTree() throws Exception {
    GetUserInfoVo userInfo = getUserInfo();
    return userInfo.getMenuTreeVoList();
    //    return CommonResult.success(authAdminService.list(request));
  }

  public List<SysMenuTreeVo> selectOrganizationTree(List<SysMenu> list) {
    //    List<SysMenuTreeVo> voList = new ArrayList<>();
    //    List list1 = BeanUtilsPlus.copyToList(list, SysMenuTreeVo.class);
    List<SysMenuTreeVo> voList = BeanUtil.copyToList(list, SysMenuTreeVo.class);
    log.info("voList:{}", voList);
    // 操作所有组织机构数据
    Map<String, List<SysMenuTreeVo>> groupMap =
        voList.stream().collect(Collectors.groupingBy(SysMenuTreeVo::getParentId));

    log.info("groupMap:{}", groupMap);
    voList.forEach(
        organization -> {
          organization.setChildren(groupMap.get(organization.getId()));
        });
    log.info("groupMap:{}", groupMap);
    List<SysMenuTreeVo> collect =
        voList.stream()
            .filter(organization -> organization.getParentId().equals("0"))
            .collect(Collectors.toList());
    return collect;
  }
}
