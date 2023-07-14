package net.yiyuan.admin.auth.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaIgnore;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.admin.auth.model.get_user_info.GetUserInfoVo;
import net.yiyuan.admin.auth.model.get_user_info.SysMenuTreeVo;
import net.yiyuan.admin.auth.model.login.LoginReq;
import net.yiyuan.admin.auth.model.login.LoginVo;
import net.yiyuan.admin.auth.model.register.RegisterReq;
import net.yiyuan.admin.auth.model.register.RegisterVo;
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
  @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<LoginVo> login(@RequestBody @Validated LoginReq request) throws Exception {
    return CommonResult.success(authService.login(request));
  }

  /**
   * 注册
   *
   * @param request 用户实体
   * @return {@link CommonResult<RegisterVo>}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @SaIgnore
  @RequestMapping(value = "/auth/register", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<RegisterVo> register(@RequestBody @Validated RegisterReq request)
      throws Exception {
    return null;
    // return CommonResult.success(authService.adminRegister(request));
  }

  /**
   * 退出登录
   *
   * @return {@link CommonResult<Boolean>}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @RequestMapping(value = "/auth/loginout", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<Boolean> loginout() throws Exception {
    return CommonResult.success(authService.loginout());
  }

  /**
   * 获取当前登录用户信息,包括角色以及权限菜单(ForAntd)
   *
   * @return {@link CommonResult<GetUserInfoVo>}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @SaCheckLogin
  @RequestMapping(value = "/auth/getUserInfo", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<GetUserInfoForAntdVo> getUserInfo() throws Exception {
    return CommonResult.success(authService.getUserInfoForAntd());
  }

  /**
   * 平台超管查询所有菜单(树结构)2
   *
   * @return {@link CommonResult<List<SysMenuTreeVo>>}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @SaCheckPermission(
      value = {"auth:adminGetMenuTree"},
      orRole = "admin")
  @RequestMapping(value = "/auth/adminGetMenuTree", method = RequestMethod.POST)
  public CommonResult<List<SysMenuTreeVo>> adminGetMenuTree() throws Exception {
    return CommonResult.success(authService.adminGetMenuTree());
  }

  /**
   * 租户管理员查询所有菜单(树结构)
   *
   * @return {@link CommonResult<List<SysMenuTreeVo>>}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @RequestMapping(value = "/auth/tenantGetMenuTree", method = RequestMethod.POST)
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
  @RequestMapping(value = "/auth/autoScanMenu", method = RequestMethod.POST)
  public CommonResult autoScanMenu() throws Exception {
    // 获取连接池的统计数据列表  该方法可以获取所有数据源的监控数据  https://blog.csdn.net/qq_34491508/article/details/103559872
    // 扫描指定包下的类，并获取带有 @SaCheckPermission 注解的方法
    // 定义权限标识的包名
    // 定义需要扫描的包名和注解类型
    // 定义需要扫描的包名和注解类型
    // 返回菜单列表
    return CommonResult.success(authService.autoScanMenu());
  }
}
