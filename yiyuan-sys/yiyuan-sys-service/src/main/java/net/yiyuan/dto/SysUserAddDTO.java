package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.SysUserPlatformEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 管理端用户新增接口请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Data
public class SysUserAddDTO implements Serializable {

  /**
   * 商户id
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String tenantId;

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
   * 平台类型#0=平台端|1=租户端|2=移动端
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @NotNull(message = "平台类型#0=平台端|1=租户端|2=移动端不能为空")
  private SysUserPlatformEnum platform;
}
