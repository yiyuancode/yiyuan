package net.yiyuan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.enums.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品列表接口请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-09-22
 */
@Data
public class PtmProductListDTO implements Serializable {

  /**
   * 商品id
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String id;

  /**
   * 商户id
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String tenantId;

  /**
   * 商品图片
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String image;

  /**
   * 展示图
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String flatPattern;

  /**
   * 轮播图
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String sliderImage;

  /**
   * 商品名称
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String name;

  /**
   * 商品简介
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String title;

  /**
   * 关键字,英文逗号拼接
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String keyword;

  /**
   * 租户分类id(逗号拼接)
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String cateId;

  /**
   * 品牌id
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String brandId;

  /**
   * 平台分类id
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String categoryId;

  /**
   * 保障服务ids(英文逗号拼接)
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String guaranteeIds;

  /**
   * 商品价格
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private BigDecimal price;

  /**
   * 会员价格
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private BigDecimal vipPrice;

  /**
   * 市场价
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private BigDecimal otPrice;

  /**
   * 单位名
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String unitName;

  /**
   * 销量
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private Integer sales;

  /**
   * 库存
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private Integer stock;

  /**
   * 成本价
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private BigDecimal cost;

  /**
   * 虚拟销量
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private Integer ficti;

  /**
   * 浏览量
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private Integer browse;

  /**
   * 商品二维码地址(用户小程序海报)
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String codePath;

  /**
   * 主图视频链接
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String videoLink;

  /**
   * 运费模板ID
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private Integer tempId;

  /**
   * 排序
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private Integer sort;

  /**
   * 总后台排序
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private Integer rank;

  /**
   * 规格#0=单|1=多
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private PtmProductSpecTypeEnum specType;

  /**
   * 是否回收站
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private Integer isRecycle;

  /**
   * 是否单独分佣
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private Integer isSub;

  /**
   * 状态#0=未上架|1=上架
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private PtmProductIsShowEnum isShow;

  /**
   * 审核状态#0=无需审核|1=待审核|2=审核成功|3=审核拒绝
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private PtmProductAuditStatusEnum auditStatus;

  /**
   * 是否加入审核#0=正常|1=审核流程中
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private PtmProductIsAuditEnum isAudit;

  /**
   * 拒绝原因
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String reasonContent;

  /**
   * 是否删除#0=否|1=是
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private PtmProductIsDelEnum isDel;

  /**
   * 创建时间(查询开始时间)
   *
   * @see Date
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @see Date
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeEnd;

  /**
   * 修改时间(查询开始时间)
   *
   * @see Date
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @see Date
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeEnd;

  /**
   * 创建人
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String updateUser;
}
