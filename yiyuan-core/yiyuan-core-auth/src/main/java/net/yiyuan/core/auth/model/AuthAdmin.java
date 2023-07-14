package net.yiyuan.core.auth.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户管理实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-11
 */
@Data
public class AuthAdmin implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 主键ID
   *
   * @date 2023-07-11
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * 用户名
   *
   * @author 一源团队--花和尚
   * @date 2023-07-11
   * @see String
   */
  private String username;

  /**
   * 密码
   *
   * @author 一源团队--花和尚
   * @date 2023-07-11
   * @see String
   */
  private String password;

  /**
   * 随机盐
   *
   * @author 一源团队--花和尚
   * @date 2023-07-11
   * @see String
   */
  private String salt;

  /**
   * 部门ID
   *
   * @author 一源团队--花和尚
   * @date 2023-07-11
   * @see Integer
   */
  private Integer deptId;

  private String miniOpenid;

  /**
   * 码云登录
   *
   * @author 一源团队--花和尚
   * @date 2023-07-11
   * @see String
   */
  private String giteeLogin;

  /**
   * 开源中国
   *
   * @author 一源团队--花和尚
   * @date 2023-07-11
   * @see String
   */
  private String oscId;

  private String wxOpenid;

  private String qqOpenid;

  /**
   * 用户类型（0：平台账号，1：租户账号，2：租户C端账号）
   *
   * @author 一源团队--花和尚
   * @date 2023-07-11
   * @see Integer
   */
  private Integer platform;

  /**
   * 所属租户
   *
   * @author 一源团队--花和尚
   * @date 2023-07-11
   * @see String
   */
  private String tenantId;

  /**
   * 修改时间 DateTimeFormat//请求非body json时候 JsonFormat//请求为body json时候
   *
   * @author 一源团队--花和尚
   * @date 2023-07-11
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updatedTime;

  /**
   * 创建时间 DateTimeFormat//请求非body json时候 JsonFormat//请求为body json时候
   *
   * @author 一源团队--花和尚
   * @date 2023-07-11
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createdTime;
}
