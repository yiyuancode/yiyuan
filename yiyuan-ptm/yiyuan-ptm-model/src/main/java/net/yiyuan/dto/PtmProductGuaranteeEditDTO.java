package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 保障服务修改接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-11-09
 */
@Data
public class PtmProductGuaranteeEditDTO implements Serializable {

  /**
   * 保障服务id
   *
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  @NotBlank(message = "保障服务id不能为空")
  private String id;

  /**
   * 商户id
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  private String tenantId;

  /**
   * 保障服务名称
   *
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  private String name;

  /**
   * 排序
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  private Integer sort;

  /**
   * 是否显示0=否|1=是
   *
   * @mock 1
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  private Boolean isShow;
}
