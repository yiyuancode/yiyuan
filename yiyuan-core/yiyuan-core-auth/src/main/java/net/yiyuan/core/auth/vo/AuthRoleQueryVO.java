package net.yiyuan.core.auth.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色查询请求响应参数实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Data
public class AuthRoleQueryVO implements Serializable {

  /**
   * 主键ID
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  private String id;

  /**
   * 角色中文名称(可以修改)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  private String name;

  /**
   * 角色英文编码(例如Root等，无法修改,satoken会用)唯一性
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  private String code;

  /**
   * 角色备注
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  private String roleDesc;

  /**
   * 所属部门
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  private String deptId;

  /**
   * 数据权限范围(部门id集合)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  private String deptScope;

  /**
   * 所属租户
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  private String tenantId;

  /**
   * 创建时间
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  /**
   * 修改时间
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;

  /**
   * 创建人
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  private String updateUser;
}
