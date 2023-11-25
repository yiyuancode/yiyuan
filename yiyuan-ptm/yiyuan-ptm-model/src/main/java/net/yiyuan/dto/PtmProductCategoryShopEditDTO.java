package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.PtmProductCategoryShopLevelEnum;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 店铺商品分类修改接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-11-19
 */
@Data
public class PtmProductCategoryShopEditDTO implements Serializable {

  /**
   * 店铺商品分类id
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @NotBlank(message = "店铺商品分类id不能为空")
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
   * 排序
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  private Integer sort;

  /**
   * 是否显示0=否|1=是
   *
   * @mock 1
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  private Boolean isShow;
}
