package net.yiyuan.admin.login.service.impl;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.context.model.SaRequest;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.admin.login.dto.AccountLoginDTO;
import net.yiyuan.admin.login.service.AdminLoginService;
import net.yiyuan.admin.login.vo.AccountLoginVo;
import net.yiyuan.admin.login.vo.LoginGetUserInfoVo;
import net.yiyuan.admin.redis.AdminRedisService;
import net.yiyuan.common.constatnt.ResultCode;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.enums.AuthAdminPlatformEnum;
import net.yiyuan.mapper.SysTenantMapper;
import net.yiyuan.model.*;
import net.yiyuan.service.AuthAdminRoleService;
import net.yiyuan.service.AuthAdminService;
import net.yiyuan.vo.AuthAdminQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 登录管理Service层接口实现
 *
 * @author ${author}
 * @date 2023-07-27
 */
@Slf4j
@Service
public class AdminLoginServiceImpl extends JoinServiceImpl<SysTenantMapper, SysTenant>
    implements AdminLoginService {

  @Resource private AuthAdminService authAdminService;
  @Resource private AdminRedisService adminRedisService;
  @Resource private AuthAdminRoleService authAdminRoleService;
  /**
   * 账号密码登录
   *
   * @param request
   * @return {@link AccountLoginVo }
   * @author ${author}
   * @date 2023-07-27
   */
  @Override
  public AccountLoginVo accountLogin(AccountLoginDTO request) throws Exception {
    StpUtil.login(request.getUsername());
    AccountLoginVo voBean = new AccountLoginVo();
    voBean.setToken(StpUtil.getTokenValue());

    SaRequest httpRequest = SaHolder.getRequest();
    // platform 平台区分 0 平台  1 租户 2 c端
    String platform = httpRequest.getHeader("platform");
    //    String tenantId = httpRequest.getHeader("tenantId");
    // 查询用户信息
    AuthAdmin query = new AuthAdmin();
    query.setUsername(request.getUsername());
    query.setPlatform(AuthAdminPlatformEnum.PLATFORM_SIDE);
    AuthAdminQueryVO adminQueryVO = authAdminService.details(query);
    // 用户不存在
    if (ObjectUtil.isNull(adminQueryVO)) {
      throw new BusinessException(ResultCode.USER_NOT_FIND);
    }
    // 密码错误
    if (!adminQueryVO.getPassword().equals(request.getPassword())) {
      throw new BusinessException(ResultCode.USER_ERROR);
    }
    // satoken登录
    StpUtil.login(adminQueryVO.getId());
    String tokenValue = StpUtil.getTokenValue();
    AccountLoginVo voResult = new AccountLoginVo();
    voResult.setToken(tokenValue);

    // 查询所有角色
    JoinLambdaWrapper<AuthAdminRole> wrapperRole = new JoinLambdaWrapper<>(AuthAdminRole.class);
    wrapperRole.eq(AuthAdminRole::getUserId, adminQueryVO.getId());
    wrapperRole
        .leftJoin(AuthRole.class, AuthRole::getId, AuthAdminRole::getRoleId)
        .select(AuthRole::getId, AuthRole::getCode)
        .end();
    List<AuthRole> authRoles = authAdminRoleService.joinList(wrapperRole, AuthRole.class);
    List<String> rolesCodeList =
        authRoles.stream().map(p -> p.getCode()).collect(Collectors.toList());
    adminRedisService.SET_ADMIN_USER_ROLE(adminQueryVO.getId(), rolesCodeList);

    // 查询所有权限放在缓存中
    List<String> permissionList = new ArrayList<>();
    // 包含平台管理员角色 不用查询权限表达式了
    if (rolesCodeList.contains("admin")) {
      adminRedisService.SET_ADMIN_USER_PERMISSION(adminQueryVO.getId(), permissionList);
    } else {
      // List<String> roleList = getRoleList(loginId, loginType);
      // 从数据库查询这个角色所拥有的权限列表
      JoinLambdaWrapper<AuthAdminRole> wrapper = new JoinLambdaWrapper<>(AuthAdminRole.class);
      wrapper.eq(AuthAdminRole::getUserId, adminQueryVO.getId());
      wrapper.select(AuthAdminRole::getRoleId);
      wrapper
          .leftJoin(AuthRole.class, AuthRole::getId, AuthAdminRole::getRoleId)
          .select(AuthRole::getId, AuthRole::getCode)
          .end();
      wrapper
          .leftJoin(AuthRoleMenu.class, AuthRoleMenu::getRoleId, AuthRole::getId)
          .select(AuthRoleMenu::getMenuId)
          .end();
      wrapper
          .leftJoin(SysMenu.class, SysMenu::getId, AuthRoleMenu::getMenuId)
          .select(SysMenu::getPermission)
          .end();
      List<SysMenu> roleMenuList = authAdminRoleService.joinList(wrapper, SysMenu.class);
      List<String> rolePermissionList =
          roleMenuList.stream().map(p -> p.getPermission()).collect(Collectors.toList());
      permissionList.addAll(rolePermissionList);
      adminRedisService.SET_ADMIN_USER_PERMISSION(adminQueryVO.getId(), permissionList);
    }

    return voResult;
  }

  @Override
  public LoginGetUserInfoVo getUserInfo() throws Exception {
    LoginGetUserInfoVo voResult = new LoginGetUserInfoVo();
    String loginId = StpUtil.getLoginIdAsString();
    // 获取用户信息的菜单树结构
    AuthAdminQueryVO authAdminQueryVO = authAdminService.detailsJoinRoleAndPermission(loginId);
    BeanUtilsPlus.copy(authAdminQueryVO, voResult);
    return voResult;
  }
}
