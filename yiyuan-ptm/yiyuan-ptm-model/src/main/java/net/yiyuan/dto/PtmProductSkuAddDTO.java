package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品sku新增接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-10
 */
@Data
public class PtmProductSkuAddDTO implements Serializable {

  /**
   * 商户id
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotBlank(message = "商户id不能为空")
  private String tenantId;

  /**
   * 商品id
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotBlank(message = "商品id不能为空")
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
  @NotNull(message = "库存不能为空")
  private Integer stock;

  /**
   * 售卖价格
   *
   * @mock 0.00
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotNull(message = "售卖价格不能为空")
  private BigDecimal salePrice;

  /**
   * 划线价格
   *
   * @mock 0.00
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotNull(message = "划线价格不能为空")
  private BigDecimal crossedPrice;

  /**
   * 成本价
   *
   * @mock 0.00
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotNull(message = "成本价不能为空")
  private BigDecimal costPrice;
}
