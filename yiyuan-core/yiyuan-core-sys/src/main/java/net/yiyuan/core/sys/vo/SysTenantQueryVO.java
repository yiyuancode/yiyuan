package net.yiyuan.core.sys.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.core.sys.enums.SysTenantStatusEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 租户查询请求响应参数实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Data
public class SysTenantQueryVO implements Serializable {

  /**
   * 租户id
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
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
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date startTime;

  /**
   * 结束时间
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date endTime;

  /**
   * 修改时间
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;

  /**
   * 创建时间
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

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

  /**
   * 创建人
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  private String updateUser;
}
