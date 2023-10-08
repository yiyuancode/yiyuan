package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.PtmProductAuditStatusEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品信息新增接口请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-10-06
 */
@Data
public class PtmProductAddDTO implements Serializable {

  /**
   * 商户id
   *
   * @mock 0
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotBlank(message = "商户id不能为空")
  private String tenantId;

  /**
   * 主类目id(商品分类2级id，逗号拼接)
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotBlank(message = "主类目id(商品分类2级id，逗号拼接)不能为空")
  private String mainCategoryId;

  /**
   * 店铺内部分类id(商品分类3级)
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotBlank(message = "店铺内部分类id(商品分类3级)不能为空")
  private String categoryId;

  /**
   * 品牌id
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotBlank(message = "品牌id不能为空")
  private String brandId;

  /**
   * 保障服务ids(英文逗号拼接)
   *
   * @mock 0
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotBlank(message = "保障服务ids(英文逗号拼接)不能为空")
  private String guaranteeIds;

  /**
   * 运费模板ID
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotBlank(message = "运费模板ID不能为空")
  private String tempId;

  /**
   * 商品图片
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotBlank(message = "商品图片不能为空")
  private String image;

  /**
   * 展示图
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotBlank(message = "展示图不能为空")
  private String flatPattern;

  /**
   * 轮播图
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotBlank(message = "轮播图不能为空")
  private String sliderImage;

  /**
   * 商品名称
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotBlank(message = "商品名称不能为空")
  private String name;

  /**
   * 商品简介
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotBlank(message = "商品简介不能为空")
  private String title;

  /**
   * 关键字,英文逗号拼接
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotBlank(message = "关键字,英文逗号拼接不能为空")
  private String keyword;

  /**
   * 商品价格
   *
   * @mock 0.00
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotNull(message = "商品价格不能为空")
  private BigDecimal price;

  /**
   * 会员价格
   *
   * @mock 0.00
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotNull(message = "会员价格不能为空")
  private BigDecimal vipPrice;

  /**
   * 市场价
   *
   * @mock 0.00
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotNull(message = "市场价不能为空")
  private BigDecimal otPrice;

  /**
   * 单位名
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotBlank(message = "单位名不能为空")
  private String unitName;

  /**
   * 销量
   *
   * @mock 0
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotNull(message = "销量不能为空")
  private Integer sales;

  /**
   * 库存
   *
   * @mock 0
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotNull(message = "库存不能为空")
  private Integer stock;

  /**
   * 成本价
   *
   * @mock 0.00
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotNull(message = "成本价不能为空")
  private BigDecimal cost;

  /**
   * 虚拟销量
   *
   * @mock 0
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotNull(message = "虚拟销量不能为空")
  private Integer ficti;

  /**
   * 浏览量
   *
   * @mock 0
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotNull(message = "浏览量不能为空")
  private Integer browse;

  /**
   * 商品二维码地址(用户小程序海报)
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String codePath;

  /**
   * 主图视频链接
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String videoLink;

  /**
   * 总后台排序
   *
   * @mock 0
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotNull(message = "总后台排序不能为空")
  private Integer rank;

  /**
   * 是否单规格0=单|1=多
   *
   * @mock 1
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotNull(message = "是否单规格0=单|1=多不能为空")
  private Boolean isSpecType;

  /**
   * 是否放入回收站0=否|1=是
   *
   * @mock 1
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotNull(message = "是否放入回收站0=否|1=是不能为空")
  private Boolean isRecycle;

  /**
   * 是否单独分佣0=否|1=是
   *
   * @mock 0
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotNull(message = "是否单独分佣0=否|1=是不能为空")
  private Boolean isSub;

  /**
   * 是否加入审核0=否|1=是
   *
   * @mock 1
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotNull(message = "是否加入审核0=否|1=是不能为空")
  private Boolean isAudit;

  /**
   * 审核状态#0=无需审核|1=待审核|2=审核成功|3=审核拒绝
   *
   * @mock 1
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotNull(message = "审核状态#0=无需审核|1=待审核|2=审核成功|3=审核拒绝不能为空")
  private PtmProductAuditStatusEnum auditStatus;

  /**
   * 拒绝原因
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotBlank(message = "拒绝原因不能为空")
  private String reasonContent;
}
