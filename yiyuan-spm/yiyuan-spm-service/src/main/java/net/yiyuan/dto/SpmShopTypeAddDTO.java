package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.SpmShopTypeIsDelEnum;
import net.yiyuan.enums.SpmShopTypeIsShowEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 店铺类型新增接口请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Data
public class SpmShopTypeAddDTO implements Serializable {

  /**
   * 店铺类型名称
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @NotBlank(message = "店铺类型名称不能为空")
  private String name;

  /**
   * 店铺类型描述
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @NotBlank(message = "店铺类型描述不能为空")
  private String typeDesc;

  /**
   * 店铺类型合约
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @NotBlank(message = "店铺类型合约不能为空")
  private String typeContract;

  /**
   * 排序
   *
   * @mock 0
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @NotNull(message = "排序不能为空")
  private Integer sort;

  /**
   * 显示状态#0=不显示|1=显示
   *
   * @mock 1
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @NotNull(message = "显示状态#0=不显示|1=显示不能为空")
  private SpmShopTypeIsShowEnum isShow;

  /**
   * 是否删除#0=未删除|1=已删除
   *
   * @mock 0
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @NotNull(message = "是否删除#0=未删除|1=已删除不能为空")
  private SpmShopTypeIsDelEnum isDel;
}