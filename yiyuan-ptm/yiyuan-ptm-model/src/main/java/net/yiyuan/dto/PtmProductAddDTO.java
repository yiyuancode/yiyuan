package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.PtmProductAuditStatusEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 商品信息新增接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-10
 */
@Data
public class PtmProductAddDTO implements Serializable {

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
   * 主类目id(商品分类2级id，逗号拼接)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotBlank(message = "主类目id(商品分类2级id，逗号拼接)不能为空")
  private String platCategoryId;

  /**
   * 店铺内部分类id(商品分类3级)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotBlank(message = "店铺内部分类id(商品分类3级)不能为空")
  private String shopCategoryId;

  /**
   * 品牌id
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotBlank(message = "品牌id不能为空")
  private String brandId;

  /**
   * 保障服务ids(英文逗号拼接)
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotBlank(message = "保障服务ids(英文逗号拼接)不能为空")
  private String guaranteeIds;

  /**
   * 运费模板ID
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotBlank(message = "运费模板ID不能为空")
  private String tempId;

  /**
   * 商品橱窗图片
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotBlank(message = "商品橱窗图片不能为空")
  private String image;

  /**
   * 详情图(多个逗号分割)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotBlank(message = "详情图(多个逗号分割)不能为空")
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
  @NotBlank(message = "商品名称不能为空")
  private String name;

  /**
   * 商品简介
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotBlank(message = "商品简介不能为空")
  private String title;

  /**
   * 关键字,英文逗号拼接
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotBlank(message = "关键字,英文逗号拼接不能为空")
  private String keyword;

  /**
   * 商品详情(富文本)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String goodsDesc;

  /**
   * 单位名
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotBlank(message = "单位名不能为空")
  private String unitName;

  /**
   * 实际销量
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotNull(message = "实际销量不能为空")
  private Integer sales;

  /**
   * 虚拟销量(如果为默认值前端展示实际销量,反之展示虚拟销量)
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotNull(message = "虚拟销量(如果为默认值前端展示实际销量,反之展示虚拟销量)不能为空")
  private Integer fictiSales;

  /**
   * 浏览量
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotNull(message = "浏览量不能为空")
  private Integer browse;

  /**
   * 商品二维码地址(用户小程序海报)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String codePath;

  /**
   * 总后台排序
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotNull(message = "总后台排序不能为空")
  private Integer tenantSort;

  /**
   * 是否单独分佣0=否|1=是
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotNull(message = "是否单独分佣0=否|1=是不能为空")
  private Boolean isSub;

  /**
   * 是否加入审核0=否|1=是
   *
   * @mock 1
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotNull(message = "是否加入审核0=否|1=是不能为空")
  private Boolean isAudit;

  /**
   * 审核状态#0=无需审核|1=待审核|2=审核成功|3=审核拒绝
   *
   * @mock 1
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotNull(message = "审核状态#0=无需审核|1=待审核|2=审核成功|3=审核拒绝不能为空")
  private PtmProductAuditStatusEnum auditStatus;

  /**
   * 商品sku集合
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotNull(message = "商品sku集合不能为空")
  private List<PtmProductSkuAddDTO> skuList;
}
