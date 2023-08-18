package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 角色修改接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
@Data
public class AuthRoleEditDTO implements Serializable {

  /**
   * 主键ID
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @NotBlank(message = "主键ID不能为空")
  private String id;

  /**
   * 角色中文名称(可以修改)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String name;

  /**
   * 角色英文编码(例如Root等，无法修改,satoken会用)唯一性
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String code;

  /**
   * 角色备注
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String roleDesc;

  /**
   * 所属部门
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String deptId;

  /**
   * 数据权限范围(部门id集合)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String deptScope;

  /**
   * 所属租户
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String tenantId;
}
