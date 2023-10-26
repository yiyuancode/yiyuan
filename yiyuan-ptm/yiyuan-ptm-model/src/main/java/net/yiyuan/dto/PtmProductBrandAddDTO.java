package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 品牌新增接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-10
 */
@Data
public class PtmProductBrandAddDTO implements Serializable {

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
   * 品牌名称
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotBlank(message = "品牌名称不能为空")
  private String name;

  /**
   * 品牌图标
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotBlank(message = "品牌图标不能为空")
  private String icon;

  /**
   * 分类id(多个以逗号隔开)
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotNull(message = "分类id")
  private String[] categoryIds;
}
