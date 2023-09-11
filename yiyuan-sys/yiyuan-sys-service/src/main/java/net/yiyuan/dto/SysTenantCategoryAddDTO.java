package net.yiyuan.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 租户店铺分类新增接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
@Data
public class SysTenantCategoryAddDTO implements Serializable {

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
