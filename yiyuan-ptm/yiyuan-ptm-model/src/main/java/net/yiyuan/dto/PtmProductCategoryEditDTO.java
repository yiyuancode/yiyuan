package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 商品分类修改接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-10
 */
@Data
public class PtmProductCategoryEditDTO implements Serializable {

  /**
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotBlank(message = "不能为空")
  private String id;

  /**
   * 父级ID
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String pid = "0";

  /**
   * 商户id
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String tenantId;

  /**
   * 名称
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String name;

  /**
   * icon
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String icon;

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
