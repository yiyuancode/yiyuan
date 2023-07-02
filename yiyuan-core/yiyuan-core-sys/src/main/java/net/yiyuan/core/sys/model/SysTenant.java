package net.yiyuan.core.sys.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
/**
 * 租户管理实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-02
 */
@Data
public class SysTenant implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 租户id
   *
   * @date 2023-07-02
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * 租户名称
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  private String name;

  /**
   * 租户编号
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  private String code;

  /**
   * 开始时间 DateTimeFormat//请求非body json时候 JsonFormat//请求为body json时候
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date startTime;

  /**
   * 结束时间 DateTimeFormat//请求非body json时候 JsonFormat//请求为body json时候
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date endTime;

  /**
   * 修改时间 DateTimeFormat//请求非body json时候 JsonFormat//请求为body json时候
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updatedTime;

  /**
   * 创建时间 DateTimeFormat//请求非body json时候 JsonFormat//请求为body json时候
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createdTime;

  /**
   * 0正常 9-冻结
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  private String status;

  /**
   * 租户id
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  private String tenantId;
}
