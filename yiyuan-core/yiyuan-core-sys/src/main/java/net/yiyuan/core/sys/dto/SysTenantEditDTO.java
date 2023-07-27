package net.yiyuan.core.sys.dto;

import lombok.Data;
import net.yiyuan.core.sys.enums.SysTenantStatusEnum;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 租户修改接口请求入参实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Data
public class SysTenantEditDTO implements Serializable {

  /**
   * 租户id
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @NotBlank(message = "租户id不能为空")
  private String id;

  /**
   * 租户名称
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  private String name;

  /**
   * 租户编号
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  private String code;

  /**
   * 开始时间
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  private Date startTime;

  /**
   * 结束时间
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  private Date endTime;

  /**
   * 状态#0=正常|1=冻结
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  private SysTenantStatusEnum status;

  /**
   * 租户id
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  private String tenantId;
}
