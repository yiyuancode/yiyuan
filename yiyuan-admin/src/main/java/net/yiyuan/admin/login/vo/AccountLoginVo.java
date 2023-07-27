package net.yiyuan.admin.login.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 账号密码登录接口响应参数实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Data
public class AccountLoginVo implements Serializable {

  /**
   * token
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  private String token;
}
