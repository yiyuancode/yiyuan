package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.PtmProductCategoryLevelEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 商品分类新增接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-10
 */
@Data
public class PtmProductCategoryAddDTO implements Serializable {

  /**
   * 父级ID
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotBlank(message = "父级ID不能为空")
  private String pid;

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
   * 名称
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotBlank(message = "名称不能为空")
  private String name;

  /**
   * icon
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String icon;

  /**
   * 分类级别#1=一级分类|2=二级分类|3=三级分类|4=店铺分类
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotNull(message = "分类级别#1=一级分类|2=二级分类|3=三级分类|4=店铺分类不能为空")
  private PtmProductCategoryLevelEnum level;

  /**
   * 排序
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Integer sort;

  /**
   * 显示状态0=不显示|1=显示
   *
   * @mock 1
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Boolean isShow;
}
