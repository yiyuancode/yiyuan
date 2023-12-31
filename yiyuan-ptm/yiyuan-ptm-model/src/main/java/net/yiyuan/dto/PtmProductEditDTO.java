package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 商品信息修改接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-10
 */
@Data
public class PtmProductEditDTO implements Serializable {

  /**
   * 商品id
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotBlank(message = "商品id不能为空")
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
   * 主类目id(商品分类2级id，逗号拼接)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String platCategoryIds;

  /**
   * 店铺内部分类id(商品分类3级,逗号拼接)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String shopCategoryIds;

  /**
   * 品牌id
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String brandId;

  /**
   * 保障服务ids(英文逗号拼接)
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String guaranteeIds;

  /**
   * 运费模板ID
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String tempId;

  /**
   * 商品橱窗图片
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String image;

  /**
   * 详情图(多个逗号分割)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String sliderImage;

  /**
   * 详情视频链接
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String videoLink;

  /**
   * 商品名称
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String name;

  /**
   * 商品简介
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String title;

  /**
   * 关键字,英文逗号拼接
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String keyword;

  /**
   * 商品详情(富文本)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String goodsDesc;

  /**
   * 库存(根据sku所有累计库存自动设置)
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Integer stock;

  /**
   * 售卖价格(根据sku最低售卖价格自动设置)
   *
   * @mock 0.00
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private BigDecimal salePrice;

  /**
   * 划线价格(根据sku最低划线价格自动设置)
   *
   * @mock 0.00
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private BigDecimal crossedPrice;

  /**
   * 成本价(根据sku最低成本价自动设置)
   *
   * @mock 0.00
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private BigDecimal costPrice;

  /**
   * 单位名
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String unitName;

  /**
   * 实际销量
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Integer sales;

  /**
   * 虚拟销量(如果为默认值前端展示实际销量,反之展示虚拟销量)
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Integer fictiSales;

  /**
   * 商品二维码地址(用户小程序海报)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String codePath;

  /**
   * 商户排序
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Integer tenantSort;

  /**
   * 是否单规格0=单|1=多
   *
   * @mock 1
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Boolean isSpecType;

  /**
   * 是否放入回收站0=否|1=是
   *
   * @mock 1
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Boolean isRecycle;

  /**
   * 是否单独分佣0=否|1=是
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Boolean isSub;

  /**
   * 平台排序
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Integer sort;

  /**
   * 是否上架0=否|1=是
   *
   * @mock 1
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Boolean isShow;


  /**
   * 商品sku集合
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private List<PtmProductSkuEditDTO> skuList;
}
