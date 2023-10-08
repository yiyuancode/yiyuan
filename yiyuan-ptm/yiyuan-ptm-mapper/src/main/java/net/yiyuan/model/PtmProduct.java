package net.yiyuan.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.common.constatnt.CustomSqlCondition;
import net.yiyuan.enums.PtmProductAuditStatusEnum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 商品信息实体
 *
 * @author 一源-花和尚
 * @date 2023-10-06
 */
@Data
public class PtmProduct implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 商品id
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * 商户id
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String tenantId;

  /**
   * 主类目id(商品分类2级id，逗号拼接)
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String mainCategoryId;

  /**
   * 店铺内部分类id(商品分类3级)
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String categoryId;

  /**
   * 品牌id
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String brandId;

  /**
   * 保障服务ids(英文逗号拼接)
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String guaranteeIds;

  /**
   * 运费模板ID
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String tempId;

  /**
   * 商品图片
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String image;

  /**
   * 展示图
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String flatPattern;

  /**
   * 轮播图
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String sliderImage;

  /**
   * 商品名称
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String name;

  /**
   * 商品简介
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String title;

  /**
   * 关键字,英文逗号拼接
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String keyword;

  /**
   * 商品价格
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private BigDecimal price;

  /**
   * 会员价格
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private BigDecimal vipPrice;

  /**
   * 市场价
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private BigDecimal otPrice;

  /**
   * 单位名
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String unitName;

  /**
   * 销量
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private Integer sales;

  /**
   * 库存
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private Integer stock;

  /**
   * 成本价
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private BigDecimal cost;

  /**
   * 虚拟销量
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private Integer ficti;

  /**
   * 浏览量
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
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
   * 排序
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private Integer sort;

  /**
   * 总后台排序
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private Integer rank;

  /**
   * 是否单规格0=单|1=多
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private Boolean isSpecType;

  /**
   * 是否放入回收站0=否|1=是
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private Boolean isRecycle;

  /**
   * 是否单独分佣0=否|1=是
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private Boolean isSub;

  /**
   * 是否加入审核0=否|1=是
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private Boolean isAudit;

  /**
   * 审核状态#0=无需审核|1=待审核|2=审核成功|3=审核拒绝
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private PtmProductAuditStatusEnum auditStatus;

  /**
   * 拒绝原因
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String reasonContent;

  /**
   * 是否上架0=否|1=是
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private Boolean isShow;

  /**
   * 创建时间
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  /**
   * 创建时间(查询开始时间)
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @TableField(value = "create_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @TableField(value = "create_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date createTimeEnd;

  /**
   * 修改时间
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
  /**
   * 修改时间(查询开始时间)
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @TableField(value = "update_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @TableField(value = "update_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date updateTimeEnd;

  /**
   * 创建人
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @TableField(fill = FieldFill.INSERT)
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private String updateUser;
}
