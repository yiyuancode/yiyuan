package net.yiyuan.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.common.constatnt.CustomSqlCondition;
import net.yiyuan.enums.SysAreaIsDelEnum;
import net.yiyuan.enums.SysAreaIsShowEnum;
import net.yiyuan.enums.SysAreaLevelEnum;

import java.io.Serializable;
import java.util.Date;
/**
 * 区域实体
 *
 * @author 一源团队-花和尚
 * @date 2023-09-11
 */
@Data
public class SysArea implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 区域ID
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * 父级ID
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String pid;

  /**
   * 区域名称
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String name;

  /**
   * 排序
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private Integer sort;

  /**
   * 显示状态#0=不显示|1=显示
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private SysAreaIsShowEnum isShow;

  /**
   * 是否删除#0=未删除|1=已删除
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private SysAreaIsDelEnum isDel;

  /**
   * 分类级别#1=一级分类|2=二级分类|3=三级分类|4=四级分类|5=五级分类
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private SysAreaLevelEnum level;

  /**
   * 创建时间
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  /**
   * 创建时间(查询开始时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @TableField(value = "create_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @TableField(value = "create_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date createTimeEnd;

  /**
   * 修改时间
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
  /**
   * 修改时间(查询开始时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @TableField(value = "update_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @TableField(value = "update_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date updateTimeEnd;

  /**
   * 创建人
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @TableField(fill = FieldFill.INSERT)
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private String updateUser;
}
