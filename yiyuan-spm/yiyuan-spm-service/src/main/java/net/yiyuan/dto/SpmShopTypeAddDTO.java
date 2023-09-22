package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 店铺类型新增接口请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-09-22
 */
@Data
public class SpmShopTypeAddDTO implements Serializable {

  /**
   * 店铺类型名称
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @NotBlank(message = "店铺类型名称不能为空")
  private String name;

  /**
   * 店铺类型描述
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @NotBlank(message = "店铺类型描述不能为空")
  private String typeDesc;

  /**
   * 店铺类型合约
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @NotBlank(message = "店铺类型合约不能为空")
  private String typeContract;
}
