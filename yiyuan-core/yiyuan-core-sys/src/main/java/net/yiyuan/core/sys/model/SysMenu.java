package net.yiyuan.core.sys.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.core.sys.enums.*;
import net.yiyuan.plugins.mp.constant.CustomSqlCondition;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
/**
 * 菜单管理实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-14
 */
@Data
public class SysMenu implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 菜单ID
   *
   * @date 2023-07-14
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * 菜单名称
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  @TableField(condition = CustomSqlCondition.LIKE_RIGHT)
  private String name;

  /**
   * 权限表达式
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  @TableField(condition = CustomSqlCondition.LIKE_RIGHT)
  private String permission;

  /**
   * 上级菜单
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  private String parentId;

  /**
   * 菜单图标
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  @TableField(condition = CustomSqlCondition.LIKE_RIGHT)
  private String icon;

  /**
   * 选中路由名称
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  @TableField(condition = CustomSqlCondition.LIKE_RIGHT)
  private String activeMenu;

  /**
   * 外链#0=否|1=是
   *
   * @see Integer
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  private SysMenuIsFrameEnum isFrame;

  /**
   * 外部链接地址
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  @TableField(condition = CustomSqlCondition.LIKE_RIGHT)
  private String frameSrc;

  /**
   * 固定多页签#0=关闭|1=开启
   *
   * @see Integer
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  private SysMenuIsAffixEnum isAffix;

  /**
   * 菜单状态#0=停用|1=正常
   *
   * @see Integer
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  private SysMenuStatusEnum status;

  /**
   * 简化路由#0=关闭|1=开启#开启以后只有一个时候直接显示子菜单
   *
   * @see Integer
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  private SysMenuIsAlwaysShowEnum isAlwaysShow;

  /**
   * 是否缓存(0-否|1-是)
   *
   * @see Integer
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */

  /**
   * 类型#0=目录|1=菜单|2=按钮
   *
   * @see Integer
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  private SysMenuTypeEnum type;

  /**
   * 打开方式#0=当前窗口|1=新窗口
   *
   * @see Integer
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  private SysMenuOpenTypeEnum openType;

  /**
   * 显示排序
   *
   * @see Integer
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  private Integer sort;

  /**
   * 路由对应组件路径(相对于@也就是src下面,例如：@/pages/pms/RenewalConsume)
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  @TableField(condition = CustomSqlCondition.LIKE_RIGHT)
  private String routeComponent;

  /**
   * 路由访问路径(如果是antv-admin,一级路由是它官方定义的,所以咱们添加都不用加/，如果是element-admin，目录类型的path就属于1级.,x需要加、)
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  @TableField(condition = CustomSqlCondition.LIKE_RIGHT)
  private String routePath;

  /**
   * 路由名称(菜单表唯一,前端可用path和name两种方式跳转)
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  @TableField(condition = CustomSqlCondition.LIKE_RIGHT)
  private String routeName;

  /**
   * 路由默认重定向页面的一级二级所有级全path访问路径(例如)
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  @TableField(condition = CustomSqlCondition.LIKE_RIGHT)
  private String routeRedirect;

  /**
   * 创建时间
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createdTime;
  /**
   * 创建时间(查询开始时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @TableField(value = "created_time", condition = CustomSqlCondition.GET_EQUAL, select = false)
  private Date createdTimeGte;
  /**
   * 创建时间(查询结束时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  @TableField(value = "created_time", condition = CustomSqlCondition.LT_EQUAL, select = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createdTimeLt;

  /**
   * 修改时间
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updatedTime;
  /**
   * 修改时间(查询开始时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @TableField(value = "created_time", condition = CustomSqlCondition.GET_EQUAL, select = false)
  private Date updatedTimeGte;
  /**
   * 修改时间(查询结束时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  @TableField(value = "created_time", condition = CustomSqlCondition.LT_EQUAL, select = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updatedTimeLt;

  /**
   * 租户id
   *
   * @see String
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  @TableField(condition = CustomSqlCondition.LIKE_RIGHT)
  private String tenantId;
}
