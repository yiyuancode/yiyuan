package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 店铺主营类目新增接口请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-09-22
 */
@Data
public class SpmShopMainCategoryAddDTO implements Serializable {

  /**
   * 主营类目名称
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @NotBlank(message = "主营类目名称不能为空")
  private String name;

  /**
   * 主营类目手续费
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @NotNull(message = "主营类目手续费不能为空")
  private BigDecimal fee;
}
