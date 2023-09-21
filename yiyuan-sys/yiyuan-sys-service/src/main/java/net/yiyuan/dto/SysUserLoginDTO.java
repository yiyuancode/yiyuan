package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.SysUserPlatformEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 平台端-登录请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Data
public class SysUserLoginDTO {
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

  /**
   * 平台类型
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @NotNull(message = "平台类型")
  private SysUserPlatformEnum platform;
}
