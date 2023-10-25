package net.yiyuan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品sku列表接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-10
 */
@Data
public class PtmProductSkuListDTO implements Serializable {

  /**
   * 商品sku主键
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String id;

  /**
   * 商户id
   *
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
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Integer stock;

  /**
   * 售卖价格
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private BigDecimal salePrice;

  /**
   * 划线价格
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private BigDecimal crossedPrice;

  /**
   * 成本价
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private BigDecimal costPrice;

  /**
   * 是否显示0=否|1=是
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Boolean isShow;

  /**
   * 创建时间(查询开始时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeEnd;

  /**
   * 修改时间(查询开始时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeEnd;




}
