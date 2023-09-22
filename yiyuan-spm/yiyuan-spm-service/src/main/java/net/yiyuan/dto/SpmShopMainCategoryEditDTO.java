package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.SpmShopMainCategoryIsDelEnum;
import net.yiyuan.enums.SpmShopMainCategoryIsShowEnum;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 店铺主营类目修改接口请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-09-22
 */
@Data
public class SpmShopMainCategoryEditDTO implements Serializable {

  /**
   * 主营类目id
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @NotBlank(message = "主营类目id不能为空")
  private String id;

  /**
   * 主营类目名称
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String name;

  /**
   * 主营类目手续费
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private BigDecimal fee;

  /**
   * 排序
   *
   * @mock 0
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private Integer sort;

  /**
   * 显示状态#0=不显示|1=显示
   *
   * @mock 1
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private SpmShopMainCategoryIsShowEnum isShow;

  /**
   * 是否删除#0=未删除|1=已删除
   *
   * @mock 0
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private SpmShopMainCategoryIsDelEnum isDel;
}
