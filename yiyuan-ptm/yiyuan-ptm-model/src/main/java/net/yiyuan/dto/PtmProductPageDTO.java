package net.yiyuan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.enums.PtmProductAuditStatusEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 商品信息分页接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-10
 */
@Data
public class PtmProductPageDTO implements Serializable {
  /**
   * 分页条数
   *
   * @mock 10
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotNull(message = "分页条数不能为空")
  private Integer pageSize = 10;
  /**
   * 分页页数
   *
   * @mock 1
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotNull(message = "分页页数不能为空")
  private Integer pageNum = 1;

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
  private String platCategoryId;

  /**
   * 店铺内部分类id(商品分类3级)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String shopCategoryId;

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
   * 库存(根据sku所有累计库存自动设置)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Integer stockStart;

  /**
   * 库存(根据sku所有累计库存自动设置)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Integer stockEnd;

  /**
   * 实际销量(开区间)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Integer salesStart;

  /**
   * 实际销量(闭区间)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Integer salesEnd;

  /**
   * 浏览量(开区间)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Integer browseStart;

  /**
   * 浏览量(闭区间)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Integer browseEnd;
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
   * 是否上架0=否|1=是
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
