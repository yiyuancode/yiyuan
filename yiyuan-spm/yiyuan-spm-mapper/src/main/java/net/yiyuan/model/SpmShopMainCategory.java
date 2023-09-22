package net.yiyuan.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.common.constatnt.CustomSqlCondition;
import net.yiyuan.enums.SpmShopMainCategoryIsDelEnum;
import net.yiyuan.enums.SpmShopMainCategoryIsShowEnum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 店铺主营类目实体
 *
 * @author 一源-花和尚
 * @date 2023-09-22
 */
@Data
public class SpmShopMainCategory implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 主营类目id
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * 主营类目名称
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String name;

  /**
   * 主营类目手续费
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private BigDecimal fee;

  /**
   * 排序
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private Integer sort;

  /**
   * 显示状态#0=不显示|1=显示
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private SpmShopMainCategoryIsShowEnum isShow;

  /**
   * 是否删除#0=未删除|1=已删除
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private SpmShopMainCategoryIsDelEnum isDel;

  /**
   * 创建时间
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  /**
   * 创建时间(查询开始时间)
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @TableField(value = "create_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @TableField(value = "create_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date createTimeEnd;

  /**
   * 修改时间
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
  /**
   * 修改时间(查询开始时间)
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @TableField(value = "update_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @TableField(value = "update_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date updateTimeEnd;

  /**
   * 创建人
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @TableField(fill = FieldFill.INSERT)
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private String updateUser;
}
