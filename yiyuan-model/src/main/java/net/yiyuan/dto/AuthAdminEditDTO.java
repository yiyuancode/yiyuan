package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.AuthAdminPlatformEnum;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 用户修改接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
@Data
public class AuthAdminEditDTO implements Serializable {

  /**
   * 主键ID
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @NotBlank(message = "主键ID不能为空")
  private String id;

  /**
   * 用户名
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String username;

  /**
   * 密码
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String password;

  /**
   * 随机盐
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String salt;

  /**
   * 部门ID
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Integer deptId;

  /**
   * 小程序openid
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String miniOpenid;

  /**
   * 码云登录
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String giteeLogin;

  /**
   * 开源中国
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String oscId;

  /**
   * 微信openid
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String wxOpenid;

  /**
   * QQ openid
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String qqOpenid;

  /**
   * 平台类型#0=平台端|1=租户端|2=移动端
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private AuthAdminPlatformEnum platform;

  /**
   * 所属租户
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String tenantId;
}
