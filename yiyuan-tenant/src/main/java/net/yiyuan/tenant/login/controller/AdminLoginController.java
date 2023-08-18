package net.yiyuan.tenant.login.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaIgnore;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.tenant.login.dto.AccountLoginDTO;
import net.yiyuan.tenant.login.service.AdminLoginService;
import net.yiyuan.tenant.login.vo.AccountLoginVo;
import net.yiyuan.tenant.login.vo.LoginGetUserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 登录管理
 *
 * @author ${author}
 * @date 2023-07-27
 * @module 登录管理
 * @folder 登录管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class AdminLoginController {
  @Autowired private AdminLoginService adminLoginService;

  /**
   * 账号密码登录
   *
   * @param request
   * @return {@link CommonResult<String>}
   * @author ${author}
   * @date 2023-07-27
   */
  @SaIgnore
  @PostMapping(value = "/login/accountLogin")
  @ResponseBody
  public CommonResult<AccountLoginVo> accountLogin(@RequestBody @Validated AccountLoginDTO request)
      throws Exception {
    return CommonResult.success(adminLoginService.accountLogin(request), "登录成功");
  }

  /**
   * 获取用户信息
   *
   * @return {@link CommonResult<LoginGetUserInfoVo>}
   * @author ${author}
   * @date 2023-07-27
   */
  @Description("登录管理/获取用户信息")
  @GetMapping(value = "/login/getUserInfo")
  @ResponseBody
  public CommonResult<LoginGetUserInfoVo> getUserInfo() throws Exception {
    return CommonResult.success(adminLoginService.getUserInfo(), "获取用户信息成功");
  }
}
