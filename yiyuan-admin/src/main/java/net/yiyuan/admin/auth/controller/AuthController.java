package net.yiyuan.admin.auth.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaIgnore;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.admin.auth.model.get_user_info.GetUserInfoVo;
import net.yiyuan.admin.auth.model.get_user_info.SysMenuTreeVo;
import net.yiyuan.admin.auth.model.login.LoginReq;
import net.yiyuan.admin.auth.model.login.LoginVo;
import net.yiyuan.admin.auth.model.vo.GetUserInfoForAntdVo;
import net.yiyuan.admin.auth.service.AuthService;
import net.yiyuan.common.model.vo.CommonResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
   * @return {@link CommonResult<LoginVo>}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @SaIgnore
  @PostMapping(value = "/auth/login")
  @ResponseBody
  public CommonResult<LoginVo> login(@RequestBody @Validated LoginReq request) throws Exception {
    return CommonResult.success(authService.login(request), "登录成功");
  }

  /**
   * 退出登录
   *
   * @return {@link CommonResult<Boolean>}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @PostMapping(value = "/auth/loginout")
  @ResponseBody
  public CommonResult<Boolean> loginout() throws Exception {
    return CommonResult.success(authService.loginout(), "退出登录成功");
  }

  /**
   * 获取当前登录用户信息,包括角色以及权限菜单(ForAntd)
   *
   * @return {@link CommonResult<GetUserInfoVo>}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @SaCheckLogin
  @PostMapping(value = "/auth/getUserInfo")
  @ResponseBody
  public CommonResult<GetUserInfoForAntdVo> getUserInfo() throws Exception {
    return CommonResult.success(authService.getUserInfoForAntd(), null);
  }

  /**
   * 平台超管查询所有菜单(树结构)
   *
   * @return {@link CommonResult<List<SysMenuTreeVo>>}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @SaCheckPermission(
      value = {"auth:adminGetMenuTree"},
      orRole = "admin")
  @GetMapping(value = "/auth/adminGetMenuTree")
  @ResponseBody
  public CommonResult<List<SysMenuTreeVo>> adminGetMenuTree() throws Exception {
    return CommonResult.success(authService.adminGetMenuTree(), null);
  }

  /**
   * 租户管理员查询所有菜单(树结构)
   *
   * @return {@link CommonResult<List<SysMenuTreeVo>>}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @GetMapping(value = "/auth/tenantGetMenuTree")
  @ResponseBody
  public CommonResult<List<SysMenuTreeVo>> tenantGetMenuTree() throws Exception {
    return CommonResult.success(authService.tenantGetMenuTree());
  }

  /**
   * 自动生成菜单数据
   *
   * @return {@link CommonResult}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @SaIgnore
  @PostMapping(value = "/auth/autoScanMenu")
  @ResponseBody
  public CommonResult autoScanMenu() throws Exception {
    // 返回菜单列表
    return CommonResult.success(authService.autoScanMenu(), null);
  }
}
