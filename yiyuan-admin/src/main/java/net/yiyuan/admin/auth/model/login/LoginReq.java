package net.yiyuan.admin.auth.model.login;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 登录请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023/06/24
 */
@Data
public class LoginReq {
  /**
   * 用户名
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @NotEmpty(message = "用户名不能为空")
  private String username;

  /**
   * 密码
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @NotEmpty(message = "密码不能为空")
  private String password;
}
