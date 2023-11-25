package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 管理端角色修改接口请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Data
public class SysRoleEditDTO implements Serializable {

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
   * 角色中文名称(可以修改)
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String name;

  /**
   * 角色英文编码(例如Root等，无法修改,satoken会用)唯一性
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String code;

  /**
   * 角色备注
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String roleDesc;

  /**
   * 数据权限范围(部门id集合)
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String deptScope;
}
