package net.yiyuan.tenant.login.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 账号密码登录接口响应参数实体
 *
 * @author ${author}
 * @date 2023-07-27
 */
@Data
public class AccountLoginVo implements Serializable {

  /**
   * token
   *
   * @author ${author}
   * @date 2023-07-27
   */
  private String token;

  /**
   * 租户ID
   *
   * @author ${author}
   * @date 2023-07-27
   */
  private String tenantId;
}
