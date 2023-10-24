package net.yiyuan.model;

import lombok.Data;

import java.io.Serializable;
/**
 * 店铺-主营类目关联实体
 *
 * @author 一源-花和尚
 * @date 2023-10-24
 */
@Data
public class SpmShopCategoryLink implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 店铺id
   *
   * @author 一源-花和尚
   * @date 2023-10-24
   */
  private String spmShopId;

  /**
   * 主营类目id(商品分类的一级)
   *
   * @author 一源-花和尚
   * @date 2023-10-24
   */
  private String ptmProductCategoryId;
}
