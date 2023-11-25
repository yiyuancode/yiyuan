package net.yiyuan.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.enums.PtmProductCategoryPlatLevelEnum;

import java.io.Serializable;
import java.util.Date;
/**
 * 平台商品分类实体
 *
 * @author 一源团队-花和尚
 * @date 2023-11-19
 */
@Data
public class PtmProductCategoryPlat implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 平台商品分类id
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * 父id
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  private String pid;

  /**
   * 分类名称
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  private String name;

  /**
   * 图标
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  private String icon;

  /**
   * 分类级别#1=一级分类|2=二级分类|3=三级分类
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  private PtmProductCategoryPlatLevelEnum level;

  /**
   * 排序
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  private Integer sort;

  /**
   * 是否显示0=否|1=是
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  private Boolean isShow;

  /**
   * 创建时间
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;

  /**
   * 修改时间
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;

  /**
   * 创建用户
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @TableField(fill = FieldFill.INSERT)
  private String createUser;

  /**
   * 修改用户
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private String updateUser;
}
