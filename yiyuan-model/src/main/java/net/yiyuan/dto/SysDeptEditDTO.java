package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 部门修改接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
@Data
public class SysDeptEditDTO implements Serializable {

  /**
   * 主键id
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @NotBlank(message = "主键id不能为空")
  private String id;

  /**
   * 部门名称
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String name;

  /**
   * 父菜单ID(0顶层部门)
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String parentId;

  /**
   * 所属租户
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String tenantId;
}
