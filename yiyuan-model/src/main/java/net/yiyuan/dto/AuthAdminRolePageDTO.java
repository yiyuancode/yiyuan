package net.yiyuan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户_角色分页接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
@Data
public class AuthAdminRolePageDTO implements Serializable {
  /**
   * 分页条数
   *
   * @mock 10
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @NotNull(message = "分页条数不能为空")
  private Integer pageSize;
  /**
   * 分页页数
   *
   * @mock 1
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @NotNull(message = "分页页数不能为空")
  private Integer pageNum;

  /**
   * 主键
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String id;

  /**
   * 用户ID
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String userId;

  /**
   * 角色ID
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String roleId;

  /**
   * 修改时间(查询开始时间)
   *
   * @see Date
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @see Date
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeEnd;

  /**
   * 租户id
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String tenantId;

  /**
   * 创建时间(查询开始时间)
   *
   * @see Date
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @see Date
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeEnd;

  /**
   * 创建人
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String updateUser;
}
