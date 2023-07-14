package net.yiyuan.admin.auth.model.get_user_info;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 菜单转树结构vo
 *
 * @author 一源团队-花和尚
 * @date 2023/06/24
 */
@Data
public class SysMenuTreeVo {
  private static final long serialVersionUID = 1L;

  /**
   * 菜单ID
   *
   * @date 2023-06-24
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * 菜单名称
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see String
   */
  private String name;

  /**
   * 权限表达式
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see String
   */
  private String permission;

  /**
   * 上级菜单
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see String
   */
  private String parentId;

  /**
   * 菜单图标
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see String
   */
  private String icon;

  /**
   * 选中路由名称
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see String
   */
  private String activeMenu;

  /**
   * 是否为外链(0-否|1-是)
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see Integer
   */
  private Integer isFrame;

  /**
   * 外部链接地址
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see String
   */
  private String frameSrc;

  /**
   * 是否固定多页签(0-关闭|1-开启)
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see Integer
   */
  private Integer isAffix;

  /**
   * 菜单状态(0-停用|1-正常)
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see Integer
   */
  private Integer status;

  /**
   * 是否简化路由(0-否,1-是-子菜单只有一个时候直接显示子菜单不显示上级)
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see Integer
   */
  private Integer isAlwaysShow;

  /**
   * 是否缓存(0-否|1-是)
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see Integer
   */
  private Integer isCache;

  /**
   * 菜单类型(0-目录|1-菜单|1-按钮)
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see Integer
   */
  private Integer type;

  /**
   * 菜单类型(0-当前窗口|1-新窗口)
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see Integer
   */
  private Integer openType;

  /**
   * 显示排序
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see Integer
   */
  private Integer sort;

  /**
   * 路由对应组件路径(相对于@也就是src下面,例如：@/pages/pms/RenewalConsume)
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see String
   */
  private String routeComponent;

  /**
   * 路由访问路径(如果是antv-admin,一级路由是它官方定义的,所以咱们添加都不用加/，如果是element-admin，目录类型的path就属于1级.,x需要加、)
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see String
   */
  private String routePath;

  /**
   * 路由名称(菜单表唯一,前端可用path和name两种方式跳转)
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see String
   */
  private String routeName;

  /**
   * 路由默认重定向页面的一级二级所有级全path访问路径(例如)
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see String
   */
  private String routeRedirect;

  /**
   * 创建时间 DateTimeFormat//请求非body json时候 JsonFormat//请求为body json时候
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createdTime;

  /**
   * 修改时间 DateTimeFormat//请求非body json时候 JsonFormat//请求为body json时候
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updatedTime;

  /**
   * 所属租户
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see String
   */
  private String tenantId;
  /**
   * 子菜单
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see String
   */
  private List<SysMenuTreeVo> children;
}
