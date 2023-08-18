package net.yiyuan.tenant.login.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.constatnt.ResultCode;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.enums.AuthAdminPlatformEnum;
import net.yiyuan.mapper.SysTenantMapper;
import net.yiyuan.model.*;
import net.yiyuan.service.AuthAdminRoleService;
import net.yiyuan.service.AuthAdminService;
import net.yiyuan.tenant.login.dto.AccountLoginDTO;
import net.yiyuan.tenant.login.service.AdminLoginService;
import net.yiyuan.tenant.login.vo.AccountLoginVo;
import net.yiyuan.tenant.login.vo.LoginGetUserInfoVo;
import net.yiyuan.tenant.redis.TenantRedisService;
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
  @Resource private TenantRedisService tenantRedisService;
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
    // 查询用户信息
    AuthAdmin query = new AuthAdmin();
    query.setUsername(request.getUsername());
    query.setPlatform(AuthAdminPlatformEnum.TENANT_END);
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
    voResult.setTenantId(adminQueryVO.getTenantId());

    // 查询所有权限放在缓存中
    List<String> permissionList = new ArrayList<>();
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
    tenantRedisService.SET_TENANT_USER_PERMISSION(adminQueryVO.getId(), permissionList);
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

    tenantRedisService.SET_TENANT_USER_ROLE(adminQueryVO.getId(), rolesCodeList);
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
