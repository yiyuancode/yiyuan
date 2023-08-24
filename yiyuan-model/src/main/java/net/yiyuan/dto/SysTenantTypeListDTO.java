package net.yiyuan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 租户类型列表接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
@Data
public class SysTenantTypeListDTO implements Serializable {

  /**
   * 租户分类id
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
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

  /**
   * 创建时间(查询开始时间)
   *
   * @see Date
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @see Date
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeEnd;

  /**
   * 更新时间(查询开始时间)
   *
   * @see Date
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeStart;
  /**
   * 更新时间(查询结束时间)
   *
   * @see Date
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeEnd;

  /**
   * 创建人
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String updateUser;
}
