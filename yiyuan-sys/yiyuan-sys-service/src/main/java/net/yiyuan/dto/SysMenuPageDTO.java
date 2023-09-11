package net.yiyuan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.enums.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 菜单分页接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
@Data
public class SysMenuPageDTO implements Serializable {
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
   * 菜单ID
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String id;

  /**
   * 菜单名称
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String name;

  /**
   * 权限表达式
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String permission;

  /**
   * 上级菜单
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String parentId;

  /**
   * 菜单图标
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String icon;

  /**
   * 选中路由名称
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String activeMenu;

  /**
   * 外链#0=否|1=是
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private SysMenuIsFrameEnum isFrame;

  /**
   * 外部链接地址
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String frameSrc;

  /**
   * 固定多页签#0=关闭|1=开启
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private SysMenuIsAffixEnum isAffix;

  /**
   * 菜单状态#0=停用|1=正常
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private SysMenuStatusEnum status;

  /**
   * 简化路由#0=关闭|1=开启
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private SysMenuIsAlwaysShowEnum isAlwaysShow;

  /**
   * 是否缓存#0=否|1=是
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private SysMenuIsCacheEnum isCache;

  /**
   * 类型#0=目录|1=菜单|2=按钮
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private SysMenuTypeEnum type;

  /**
   * 打开方式#0=当前窗口|1=新窗口
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private SysMenuOpenTypeEnum openType;

  /**
   * 显示排序
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private Integer sort;

  /**
   * 路由对应组件路径(相对于@也就是src下面,例如：@/pages/pms/RenewalConsume)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String routeComponent;

  /**
   * 路由访问路径(如果是antv-admin,一级路由是它官方定义的,所以咱们添加都不用加/，如果是element-admin，目录类型的path就属于1级.,x需要加、)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String routePath;

  /**
   * 路由名称(菜单表唯一,前端可用path和name两种方式跳转)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String routeName;

  /**
   * 路由默认重定向页面的一级二级所有级全path访问路径(例如)
   *
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  private String routeRedirect;

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
