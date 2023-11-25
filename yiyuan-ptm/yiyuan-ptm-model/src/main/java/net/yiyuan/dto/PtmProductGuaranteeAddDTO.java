package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 保障服务新增接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-11-09
 */
@Data
public class PtmProductGuaranteeAddDTO implements Serializable {

  /**
   * 商户id
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  @NotBlank(message = "商户id不能为空")
  private String tenantId;

  /**
   * 保障服务名称
   *
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  @NotBlank(message = "保障服务名称不能为空")
  private String name;

  /**
   * 是否显示0=否|1=是
   *
   * @mock 1
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  @NotNull(message = "是否显示0=否|1=是不能为空")
  private Boolean isShow;
}
