package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.SysUserPlatformEnum;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 管理端用户修改接口请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Data
public class SysUserEditDTO implements Serializable {

  /**
   * 主键ID
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @NotBlank(message = "主键ID不能为空")
  private String id;

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
  private String username;

  /**
   * 密码
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String password;

  /**
   * 平台类型#0=平台端|1=租户端|2=移动端
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private SysUserPlatformEnum platform;
}
