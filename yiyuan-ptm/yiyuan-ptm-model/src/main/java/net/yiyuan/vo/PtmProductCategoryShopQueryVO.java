package net.yiyuan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.enums.PtmProductCategoryShopLevelEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 店铺商品分类查询请求响应参数实体
 *
 * @author 一源团队-花和尚
 * @date 2023-11-19
 */
@Data
public class PtmProductCategoryShopQueryVO implements Serializable {

  /**
   * 店铺商品分类id
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  private String id;

  /**
   * 父id
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  private String pid;

  /**
   * 分类名称
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  private String name;

  /**
   * 图标
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  private String icon;

  /**
   * 分类级别#1=一级分类|2=二级分类
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  private PtmProductCategoryShopLevelEnum level;

  /**
   * 子集
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  private List<PtmProductCategoryShopQueryVO> children;

  /**
   * 排序
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  private Integer sort;

  /**
   * 是否显示0=否|1=是
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  private Boolean isShow;

  /**
   * 创建时间
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  /**
   * 修改时间
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;
}
