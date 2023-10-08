package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.PtmProductCategoryLevelEnum;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 商品分类修改接口请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-10-06
 */
@Data
public class PtmProductCategoryEditDTO implements Serializable {

  /**
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotBlank(message = "不能为空")
  private String id;

  /**
   * 父级ID
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String pid;

  /**
   * 商户id
   *
   * @mock 0
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String tenantId;

  /**
   * 名称
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String name;

  /**
   * icon
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String icon;

  /**
   * 分类级别#1=一级分类|2=二级分类|3=三级分类
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private PtmProductCategoryLevelEnum level;

  /**
   * 排序
   *
   * @mock 0
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private Integer sort;

  /**
   * 显示状态0=不显示|1=显示
   *
   * @mock 1
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private Boolean isShow;
}
