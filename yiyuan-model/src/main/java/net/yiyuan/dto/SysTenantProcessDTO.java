package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.SysTenantStatusEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 商户修改接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-09-08
 */
@Data
public class SysTenantProcessDTO implements Serializable {

  /**
   * 商户id
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @NotBlank(message = "商户id不能为空")
  private String id;

  /**
   * 申请备注
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  private String remark;

  /**
   * 入驻状态#0=待审核|1=通过|2=被驳回不能为空
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @NotNull(message = "入驻状态#0=待审核|1=通过|2=被驳回不能为空")
  private SysTenantStatusEnum status;
}
