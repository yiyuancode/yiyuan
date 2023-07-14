package net.yiyuan.admin.auth.model.login;

import lombok.Data;

/**
 * 登录请求响应实体
 *
 * @author 一源团队-花和尚
 * @date 2023/06/24
 */
@Data
public class LoginVo {
  /**
   * 令牌
   *
   * @author 一源团队-花和尚
   * @date 2023/06/24
   * @see String
   */
  private String token;
}
