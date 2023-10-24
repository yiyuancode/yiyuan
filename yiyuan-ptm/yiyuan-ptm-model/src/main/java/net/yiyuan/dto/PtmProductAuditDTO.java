package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.PtmProductAuditStatusEnum;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 商品信息修改接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-10
 */
@Data
public class PtmProductAuditDTO implements Serializable {

  /**
   * 商品id
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotBlank(message = "商品id不能为空")
  private String id;

  /**
   * 审核状态#0=无需审核|1=待审核|2=审核成功|3=审核拒绝
   *
   * @mock 1
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private PtmProductAuditStatusEnum auditStatus;
}
