package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 商品属性value修改接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-10
 */
@Data
public class PtmProductAttrValueEditDTO implements Serializable {

  /**
   * 商品属性value主键
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotBlank(message = "商品属性value主键不能为空")
  private String id;

  /**
   * 商户id
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String tenantId;

  /**
   * 商品属性key表id
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String ptmProductAttrKeyId;

  /**
   * 商品属性value值
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String attrValue;

  /**
   * 是否上架0=否|1=是
   *
   * @mock 1
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Boolean isShow;
}
