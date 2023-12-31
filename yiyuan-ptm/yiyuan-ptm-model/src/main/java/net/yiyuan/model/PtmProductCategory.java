package net.yiyuan.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.enums.PtmProductCategoryLevelEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品分类实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-10
 */
@Data
public class PtmProductCategory implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * 父级ID
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String pid;

  /**
   * 商户id
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String tenantId;

  /**
   * 名称
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String name;

  /**
   * icon
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String icon;

  /**
   * 分类级别#1=一级分类|2=二级分类|3=三级分类|4=重置为
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private PtmProductCategoryLevelEnum level;

  /**
   * 排序
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Integer sort;

  /**
   * 显示状态0=不显示|1=显示
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Boolean isShow;

  /**
   * 创建时间
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;

  /**
   * 修改时间
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;

  /**
   * 创建人
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @TableField(fill = FieldFill.INSERT)
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private String updateUser;
}
