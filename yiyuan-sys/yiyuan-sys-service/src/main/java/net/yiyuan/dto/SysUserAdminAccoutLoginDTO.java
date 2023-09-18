package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
/**
 * 平台端-登录请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Data
public class SysUserAdminAccoutLoginDTO {
  /**
   * 用户名
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @NotBlank(message = "用户名不能为空")
  private String username;

  /**
   * 密码
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @NotBlank(message = "密码不能为空")
  private String password;
}
