package net.yiyuan.admin.login.service;

import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.admin.login.dto.AccountLoginDTO;
import net.yiyuan.admin.login.vo.AccountLoginVo;
import net.yiyuan.admin.login.vo.LoginGetUserInfoVo;
import net.yiyuan.core.sys.model.SysTenant;

/**
 * 登录管理Service层接口
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
public interface AdminLoginService extends JoinIService<SysTenant> {

  /**
   * 账号密码登录
   *
   * @param request
   * @return {@link AccountLoginVo }
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  AccountLoginVo accountLogin(AccountLoginDTO request) throws Exception;

  /**
   * 账号密码登录
   *
   * @return {@link LoginGetUserInfoVo }
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  LoginGetUserInfoVo getUserInfo() throws Exception;
}
