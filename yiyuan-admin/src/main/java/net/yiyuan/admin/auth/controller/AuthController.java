package net.yiyuan.admin.auth.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaIgnore;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.admin.auth.model.login.LoginReq;
import net.yiyuan.admin.auth.model.register.RegisterReq;
import net.yiyuan.admin.auth.service.AuthService;
import net.yiyuan.common.model.vo.CommonResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登录管理
 *
 * @author 一源团队--花和尚
 * @date 2023-06-23
 * @module 登录模块
 * @folder 登录模块
 */
@Slf4j
@RestController
public class AuthController {
  @Resource private AuthService authService;
  /**
   * 登录
   *
   * @param request 用户实体
   * @return {@link CommonResult}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @SaIgnore
  @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
  public CommonResult login(@RequestBody @Validated LoginReq request) throws Exception {
    return CommonResult.success(authService.login(request));
  }
  /**
   * 注册
   *
   * @param request 用户实体
   * @return {@link CommonResult}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @SaIgnore
  @RequestMapping(value = "/auth/register", method = RequestMethod.POST)
  public CommonResult register(@RequestBody @Validated RegisterReq request) throws Exception {
    return null;
    // return CommonResult.success(authService.adminRegister(request));
  }

  /**
   * 退出登录
   *
   * @return {@link CommonResult}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @RequestMapping(value = "/auth/loginout", method = RequestMethod.POST)
  public CommonResult loginout() throws Exception {
    return CommonResult.success(authService.loginout());
  }

  /**
   * 获取当前登录用户信息,包括角色以及权限菜单
   *
   * @return {@link CommonResult}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @RequestMapping(value = "/auth/getUserInfo", method = RequestMethod.POST)
  public CommonResult getUserInfo() throws Exception {
    return CommonResult.success(authService.getUserInfo());
  }
  /**
   * 平台超管查询所有菜单(树结构)2
   *
   * @return {@link CommonResult}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @SaCheckPermission(
      value = {"auth:adminGetMenuTree"},
      orRole = "admin")
  @RequestMapping(value = "/auth/adminGetMenuTree", method = RequestMethod.POST)
  public CommonResult adminGetMenuTree() throws Exception {
    return CommonResult.success(authService.adminGetMenuTree());
  }

  /**
   * 租户管理员查询所有菜单(树结构)
   *
   * @return {@link CommonResult}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @RequestMapping(value = "/auth/tenantGetMenuTree", method = RequestMethod.POST)
  public CommonResult tenantGetMenuTree() throws Exception {
    return CommonResult.success(authService.tenantGetMenuTree());
  }
}
