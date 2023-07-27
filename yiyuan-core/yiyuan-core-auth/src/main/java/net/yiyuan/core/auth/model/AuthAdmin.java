package net.yiyuan.core.auth.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.core.auth.enums.AuthAdminPlatformEnum;
import net.yiyuan.plugins.mp.constant.CustomSqlCondition;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户管理实体
 *
 * @author 一源团队-花和尚
 * @date 2023-07-27
 */
@Data
public class AuthAdmin implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 主键ID
   *
   * @date 2023-07-27
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)

  /**
   * 主键ID
   *
   * @see String
   * @author 一源团队-花和尚
   * @date 2023-07-27
   */
  private String id;

  /**
   * 用户名
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String username;

  /**
   * 密码
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String password;

  /**
   * 随机盐
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String salt;

  private Integer deptId;

  /**
   * 小程序openid
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String miniOpenid;

  /**
   * 码云登录
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String giteeLogin;

  /**
   * 开源中国
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String oscId;

  /**
   * 微信openid
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String wxOpenid;

  /**
   * QQ openid
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String qqOpenid;

  /**
   * 平台类型#0=平台端|1=租户端|2=移动端
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see Integer
   */
  private AuthAdminPlatformEnum platform;

  /**
   * 所属租户
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String tenantId;

  /**
   * 创建时间
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see Date
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  /**
   * 创建时间(查询开始时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see Date
   */
  @TableField(value = "create_time", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see Date
   */
  @TableField(value = "create_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date createTimeEnd;

  /**
   * 修改时间
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see Date
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
  /**
   * 修改时间(查询开始时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see Date
   */
  @TableField(value = "update_time", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see Date
   */
  @TableField(value = "update_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date updateTimeEnd;

  /**
   * 创建人
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源团队-花和尚
   * @date 2023-07-27
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String updateUser;
}
