package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 品牌修改接口请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-10-06
 */
@Data
public class PtmProductBrandEditDTO implements Serializable {

  /**
   * 品牌id
   *
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @NotBlank(message = "品牌id不能为空")
  private String id;

  /**
   * 商户id
   *
   * @mock 0
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String tenantId;

  /**
   * 品牌名称
   *
   * @mock 0
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String name;

  /**
   * 品牌图标
   *
   * @mock 0
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private String icon;

  /**
   * 排序
   *
   * @mock 0
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private Integer sort;

  /**
   * 状态0=不显示|1=显示
   *
   * @mock 1
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  private Integer isShow;
}
