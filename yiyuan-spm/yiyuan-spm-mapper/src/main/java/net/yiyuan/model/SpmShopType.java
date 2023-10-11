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
 * 店铺类型实体
 *
 * @author 一源-花和尚
 * @date 2023-10-06
 */
@Data
public class SpmShopType implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 店铺类型id
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * 店铺类型名称
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String name;

  /**
   * 店铺类型描述
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String typeDesc;

  /**
   * 店铺类型合约
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String typeContract;

  /**
   * 排序
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private Integer sort;

  /**
   * 显示状态0=不显示|1=显示
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private Boolean isShow;

  /**
   * 创建时间
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  /**
   * 创建时间(查询开始时间)
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @TableField(value = "create_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @TableField(value = "create_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date createTimeEnd;

  /**
   * 修改时间
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
  /**
   * 修改时间(查询开始时间)
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @TableField(value = "update_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @TableField(value = "update_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date updateTimeEnd;

  /**
   * 创建人
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @TableField(fill = FieldFill.INSERT)
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private String updateUser;
}
