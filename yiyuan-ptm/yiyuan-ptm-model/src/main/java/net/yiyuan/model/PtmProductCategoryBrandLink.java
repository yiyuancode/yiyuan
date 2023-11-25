package net.yiyuan.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品类型—品牌中间实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-10
 */
@Data
public class PtmProductCategoryBrandLink implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 品牌id
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String ptmProductBrandId;

  /**
   * 商品类型id
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String ptmProductCategoryId;
}
