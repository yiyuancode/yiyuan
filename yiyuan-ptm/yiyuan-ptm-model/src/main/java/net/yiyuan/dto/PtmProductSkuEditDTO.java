package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品sku修改接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-10
 */
@Data
public class PtmProductSkuEditDTO implements Serializable {

  /**
   * 商品sku主键
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotBlank(message = "商品sku主键不能为空")
  private String id;

  /**
   * 商户id
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String tenantId;

  /**
   * 商品id
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String ptmProductId;

  /**
   * 商品sku
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String sku;

  /**
   * 库存
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Integer stock;

  /**
   * 售卖价格
   *
   * @mock 0.00
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private BigDecimal salePrice;

  /**
   * 划线价格
   *
   * @mock 0.00
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private BigDecimal crossedPrice;

  /**
   * 成本价
   *
   * @mock 0.00
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private BigDecimal costPrice;

  /**
   * 是否显示0=否|1=是
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Boolean isShow;
}
