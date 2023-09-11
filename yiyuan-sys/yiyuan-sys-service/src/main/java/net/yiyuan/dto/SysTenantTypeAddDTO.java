package net.yiyuan.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 租户类型新增接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
@Data
public class SysTenantTypeAddDTO implements Serializable {

  /**
   * 租户分类名称
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String name;

  /**
   * 租户初始化手续费%
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private Integer transFee;

  /**
   * 租户分类删除标记
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private Byte isDel;
}
