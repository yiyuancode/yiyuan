package net.yiyuan.core.auth.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色管理实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-11
 */
@Data
public class AuthRole implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 主键ID
   *
   * @date 2023-07-11
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * 角色中文名称(可以修改)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-11
   * @see String
   */
  private String name;

  /**
   * 角色英文编码(例如Root等，无法修改,satoken会用)唯一性
   *
   * @author 一源团队--花和尚
   * @date 2023-07-11
   * @see String
   */
  private String code;

  /**
   * 角色备注
   *
   * @author 一源团队--花和尚
   * @date 2023-07-11
   * @see String
   */
  private String roleDesc;

  /**
   * 所属部门
   *
   * @author 一源团队--花和尚
   * @date 2023-07-11
   * @see String
   */
  private String deptId;

  /**
   * 数据权限范围(部门id集合)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-11
   * @see String
   */
  private String deptScope;

  /**
   * 所属租户
   *
   * @author 一源团队--花和尚
   * @date 2023-07-11
   * @see String
   */
  private String tenantId;

  /**
   * 修改时间 DateTimeFormat//请求非body json时候 JsonFormat//请求为body json时候
   *
   * @author 一源团队--花和尚
   * @date 2023-07-11
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updatedTime;

  /**
   * 创建时间 DateTimeFormat//请求非body json时候 JsonFormat//请求为body json时候
   *
   * @author 一源团队--花和尚
   * @date 2023-07-11
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createdTime;
}
