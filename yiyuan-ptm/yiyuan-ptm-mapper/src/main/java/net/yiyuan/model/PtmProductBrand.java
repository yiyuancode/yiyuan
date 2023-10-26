package net.yiyuan.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 品牌实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Data
public class PtmProductBrand implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 品牌id
   *
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * 商户id
   *
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  private String tenantId;

  /**
   * 品牌名称
   *
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  private String name;

  /**
   * 品牌图标
   *
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  private String icon;

  /**
   * 排序
   *
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  private Integer sort;

  /**
   * 状态0=不显示|1=显示
   *
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  private Integer isShow;

  /**
   * 创建时间
   *
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;

  /**
   * 修改时间
   *
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;

  /**
   * 创建人
   *
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @TableField(fill = FieldFill.INSERT)
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private String updateUser;
}
