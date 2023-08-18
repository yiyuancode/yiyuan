package net.yiyuan.tenant.login.service;

import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.model.SysTenant;
import net.yiyuan.tenant.login.dto.AccountLoginDTO;
import net.yiyuan.tenant.login.vo.AccountLoginVo;
import net.yiyuan.tenant.login.vo.LoginGetUserInfoVo;

/**
 * 登录管理Service层接口
 *
 * @author ${author}
 * @date 2023-07-27
 */
public interface AdminLoginService extends JoinIService<SysTenant> {

  /**
   * 账号密码登录
   *
   * @param request
   * @return {@link AccountLoginVo }
   * @author ${author}
   * @date 2023-07-27
   */
  AccountLoginVo accountLogin(AccountLoginDTO request) throws Exception;

  /**
   * 账号密码登录
   *
   * @return {@link LoginGetUserInfoVo }
   * @author ${author}
   * @date 2023-07-27
   */
  LoginGetUserInfoVo getUserInfo() throws Exception;
}
