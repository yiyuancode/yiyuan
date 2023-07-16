package net.yiyuan.core.auth.model.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.core.auth.enums.AuthAdminPlatformEnum;
import net.yiyuan.core.auth.model.AuthRole;
import net.yiyuan.plugins.mp.constant.CustomSqlCondition;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户管理实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-15
 */
@Data
public class AuthAdminQueryVo implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 主键ID
   *
   * @date 2023-07-15
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * 用户名
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String username;

  /**
   * 密码
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String password;

  /**
   * 随机盐
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String salt;

  /**
   * 部门ID
   *
   * @see Integer
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  private Integer deptId;

  @TableField(condition = CustomSqlCondition.LIKE)
  private String miniOpenid;

  /**
   * 码云登录
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String giteeLogin;

  /**
   * 开源中国
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String oscId;

  @TableField(condition = CustomSqlCondition.LIKE)
  private String wxOpenid;

  @TableField(condition = CustomSqlCondition.LIKE)
  private String qqOpenid;

  /**
   * 平台类型#0=平台端|1=租户端|2=移动端
   *
   * @see Integer
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  private AuthAdminPlatformEnum platform;

  /**
   * 所属租户
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String tenantId;


  /**
   * 创建时间
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  /**
   * 创建时间(查询开始时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @TableField(value = "created_time", condition = CustomSqlCondition.GET_EQUAL, select = false)
  private Date createTimeGte;
  /**
   * 创建时间(查询结束时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @TableField(value = "created_time", condition = CustomSqlCondition.LT_EQUAL, select = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeLt;

  /**
   * 修改时间
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
  /**
   * 修改时间(查询开始时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @TableField(value = "created_time", condition = CustomSqlCondition.GET_EQUAL, select = false)
  private Date updateTimeGte;
  /**
   * 修改时间(查询结束时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @TableField(value = "created_time", condition = CustomSqlCondition.LT_EQUAL, select = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeLt;

  /**
   * 创建人
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String createUser;

  /**
   * 修改人
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String updateUser;



  /**
   * 账号角色信息
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  private List<AuthRole>  roleList;
}
