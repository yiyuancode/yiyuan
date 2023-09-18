package net.yiyuan.vo;

import lombok.Data;

/**
 * 租户端-登录请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Data
public class SysUserTenantAccoutLoginVO {
  /**
   * token
   *
   * @author 一源-花和尚
   * @date 2023-07-27
   */
  private String token;

  /**
   * 商户id
   *
   * @author 一源-花和尚
   * @date 2023-07-27
   */
  private String tenantId;
}
