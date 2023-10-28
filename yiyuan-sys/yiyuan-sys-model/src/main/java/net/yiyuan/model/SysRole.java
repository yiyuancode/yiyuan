package net.yiyuan.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.common.constatnt.CustomSqlCondition;

import java.io.Serializable;
import java.util.Date;
/**
 * 管理端角色实体
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Data
public class SysRole implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 主键ID
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
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

  /**
   * 创建时间
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  /**
   * 创建时间(查询开始时间)
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */

  /**
   * 创建时间(查询结束时间)
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */


  /**
   * 修改时间
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
  /**
   * 修改时间(查询开始时间)
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */

  /**
   * 修改时间(查询结束时间)
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */


  /**
   * 创建人
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @TableField(fill = FieldFill.INSERT)
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private String updateUser;
}
