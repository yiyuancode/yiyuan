package net.yiyuan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.dto.PtmProductSkuAddDTO;
import net.yiyuan.enums.PtmProductAuditStatusEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 商品信息查询请求响应参数实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-10
 */
@Data
public class PtmProductQueryVO implements Serializable {

  /**
   * 商品id
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
   * 主类目id(商品分类2级id，逗号拼接)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String platCategoryIds;

  /**
   * 店铺内部分类id(商品分类3级)
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
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Integer stock;

  /**
   * 售卖价格(根据sku最低售卖价格自动设置)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private BigDecimal salePrice;

  /**
   * 划线价格(根据sku最低划线价格自动设置)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private BigDecimal crossedPrice;

  /**
   * 成本价(根据sku最低成本价自动设置)
   *
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
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Integer sales;

  /**
   * 虚拟销量(如果为默认值前端展示实际销量,反之展示虚拟销量)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Integer fictiSales;

  /**
   * 浏览量
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Integer browse;

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
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Integer tenantSort;

  /**
   * 是否单规格0=单|1=多
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Boolean isSpecType;

  /**
   * 是否放入回收站0=否|1=是
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Boolean isRecycle;

  /**
   * 是否单独分佣0=否|1=是
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Boolean isSub;

  /**
   * 是否加入审核0=否|1=是
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Boolean isAudit;

  /**
   * 审核状态#0=无需审核|1=待审核|2=审核成功|3=审核拒绝
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private PtmProductAuditStatusEnum auditStatus;

  /**
   * 拒绝原因
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String reasonContent;

  /**
   * 排序
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Integer sort;

  /**
   * 是否上架0=否|1=是
   *
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
  private List<PtmProductSkuQueryVO> skuList;

  /**
   * 创建时间
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  /**
   * 修改时间
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;
}
