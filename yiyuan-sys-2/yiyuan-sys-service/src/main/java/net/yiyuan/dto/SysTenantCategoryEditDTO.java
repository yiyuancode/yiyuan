package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 租户店铺分类修改接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
@Data
public class SysTenantCategoryEditDTO implements Serializable {

  /**
   * 店铺类型id
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @NotBlank(message = "店铺类型id不能为空")
  private String id;

  /**
   * 店铺分类名称
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String name;

  /**
   * 店铺分类描述
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String desc;

  /**
   * 删除标记
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private Byte idDel;
}
