package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 租户类型修改接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
@Data
public class SysTenantTypeEditDTO implements Serializable {

  /**
   * 租户分类id
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @NotBlank(message = "租户分类id不能为空")
  private String id;

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
