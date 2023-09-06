package net.yiyuan.admin.login.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaIgnore;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.admin.login.dto.AccountLoginDTO;
import net.yiyuan.admin.login.service.AdminLoginService;
import net.yiyuan.admin.login.vo.AccountLoginVo;
import net.yiyuan.admin.login.vo.LoginGetUserInfoVo;
import net.yiyuan.admin.utils.TestFontUtils;
import net.yiyuan.common.model.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.Map;

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
  @Resource private TestFontUtils testFontUtils;

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
  @GetMapping(value = "/login/getUserInfo")
  @ResponseBody
  public CommonResult<LoginGetUserInfoVo> getUserInfo() throws Exception {
    return CommonResult.success(adminLoginService.getUserInfo(), "获取用户信息成功");
  }
  /**
   * 测试提取移动端艺术字体文件
   *
   * @param font 提取文字字符串
   * @return {@link CommonResult<Map<String, String>>}
   * @author ${author}
   * @date 2023-07-27
   */
  @PostMapping(value = "/login/testFontUtilsForYouShe")
  @ResponseBody
  public CommonResult<Map<String, String>> testFontUtilsForYouShe(
      @RequestParam(name = "font") @Validated({NotBlank.class}) String font) throws Exception {
    return CommonResult.success(testFontUtils.testFontUtilsForYouShe(font), "移动端艺术字体文件压缩提取成功");
  }

  /**
   * 测试提取移动端pingfang字体文件
   *
   * @param font 提取文字字符串
   * @return {@link CommonResult<Map<String, String>>}
   * @author ${author}
   * @date 2023-07-27
   */
  @PostMapping(value = "/login/testFontUtilsForPingfang")
  @ResponseBody
  public CommonResult<Map<String, String>> testFontUtilsForPingfang(
      @RequestParam(name = "font") @Validated({NotBlank.class}) String font) throws Exception {
    return CommonResult.success(
        testFontUtils.testFontUtilsForPingfang(font), "移动端pingfang字体文件压缩提取成功");
  }
}
