package net.yiyuan.core.sys.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.core.sys.enums.SysTenantStatusEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 租户列表接口请求入参实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Data
public class SysTenantListDTO implements Serializable {

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
   * 开始时间(查询开始时间)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date startTimeStart;
  /**
   * 开始时间(查询结束时间)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date startTimeEnd;

  /**
   * 结束时间(查询开始时间)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date endTimeStart;
  /**
   * 结束时间(查询结束时间)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date endTimeEnd;

  /**
   * 修改时间(查询开始时间)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeEnd;

  /**
   * 创建时间(查询开始时间)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @author 一源团队--花和尚
   * @date 2023-07-27
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeEnd;

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
