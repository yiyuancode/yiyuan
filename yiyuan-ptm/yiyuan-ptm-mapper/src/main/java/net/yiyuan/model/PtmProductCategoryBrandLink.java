package net.yiyuan.model;

import lombok.Data;

import java.io.Serializable;
/**
 * 商品类型—品牌中间实体
 *
 * @author 一源-花和尚
 * @date 2023-10-06
 */
@Data
public class PtmProductCategoryBrandLink implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 品牌id
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String ptmProductBrandId;

  /**
   * 商品类型id
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String ptmProductCategoryId;
}
