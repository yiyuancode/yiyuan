package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 店铺类型修改接口请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-10-24
 */
@Data
public class SpmShopTypeEditDTO implements Serializable {

  /**
   * 店铺类型id
   *
   * @author 一源-花和尚
   * @date 2023-10-24
   */
  @NotBlank(message = "店铺类型id不能为空")
  private String id;

  /**
   * 店铺类型名称
   *
   * @author 一源-花和尚
   * @date 2023-10-24
   */
  private String name;

  /**
   * 店铺类型描述
   *
   * @author 一源-花和尚
   * @date 2023-10-24
   */
  private String typeDesc;

  /**
   * 店铺类型合约
   *
   * @author 一源-花和尚
   * @date 2023-10-24
   */
  private String typeContract;

  /**
   * 排序
   *
   * @mock 0
   * @author 一源-花和尚
   * @date 2023-10-24
   */
  private Integer sort;

  /**
   * 显示状态0=不显示|1=显示
   *
   * @mock 1
   * @author 一源-花和尚
   * @date 2023-10-24
   */
  private Boolean isShow;
}
