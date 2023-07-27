package net.yiyuan.core.sys.dto;

import lombok.Data;
import net.yiyuan.core.sys.enums.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 菜单新增接口请求入参实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Data
public class SysMenuAddDTO implements Serializable {
    
    
    /**
     * 菜单名称
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    @NotBlank(message = "菜单名称不能为空" )
    
    
    private String name;
    
    
    /**
     * 权限表达式
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    @NotBlank(message = "权限表达式不能为空" )
    
    
    private String permission;
    
    
    /**
     * 上级菜单
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    @NotBlank(message = "上级菜单不能为空" )
    
    
    private String parentId;
    
    
    /**
     * 菜单图标
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    
    private String icon;
    
    
    /**
     * 选中路由名称
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    
    private String activeMenu;
    
    
    /**
     * 外链#0=否|1=是
     *
     * @mock 0
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    @NotNull(message = "外链#0=否|1=是不能为空" )
    
    
    private SysMenuIsFrameEnum isFrame;
    
    
    /**
     * 外部链接地址
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    
    private String frameSrc;
    
    
    /**
     * 固定多页签#0=关闭|1=开启
     *
     * @mock 0
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    @NotNull(message = "固定多页签#0=关闭|1=开启不能为空" )
    
    
    private SysMenuIsAffixEnum isAffix;
    
    
    /**
     * 菜单状态#0=停用|1=正常
     *
     * @mock 1
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    @NotNull(message = "菜单状态#0=停用|1=正常不能为空" )
    
    
    private SysMenuStatusEnum status;
    
    
    /**
     * 简化路由#0=关闭|1=开启
     *
     * @mock 0
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    @NotNull(message = "简化路由#0=关闭|1=开启不能为空" )
    
    
    private SysMenuIsAlwaysShowEnum isAlwaysShow;
    
    
    /**
     * 是否缓存#0=否|1=是
     *
     * @mock 0
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    @NotNull(message = "是否缓存#0=否|1=是不能为空" )
    
    
    private SysMenuIsCacheEnum isCache;
    
    
    /**
     * 类型#0=目录|1=菜单|2=按钮
     *
     * @mock 0
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    @NotNull(message = "类型#0=目录|1=菜单|2=按钮不能为空" )
    
    
    private SysMenuTypeEnum type;
    
    
    /**
     * 打开方式#0=当前窗口|1=新窗口
     *
     * @mock 0
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    @NotNull(message = "打开方式#0=当前窗口|1=新窗口不能为空" )
    
    
    private SysMenuOpenTypeEnum openType;
    
    
    /**
     * 显示排序
     *
     * @mock 0
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    @NotNull(message = "显示排序不能为空" )
    
    
    private Integer sort;
    
    
    /**
     * 路由对应组件路径(相对于@也就是src下面,例如：@/pages/pms/RenewalConsume)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    
    private String routeComponent;
    
    
    /**
     * 路由访问路径(如果是antv-admin,一级路由是它官方定义的,所以咱们添加都不用加/，如果是element-admin，目录类型的path就属于1级.,x需要加、)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    
    private String routePath;
    
    
    /**
     * 路由名称(菜单表唯一,前端可用path和name两种方式跳转)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    
    private String routeName;
    
    
    /**
     * 路由默认重定向页面的一级二级所有级全path访问路径(例如)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    
    private String routeRedirect;
    
    
    /**
     * 租户id
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    
    private String tenantId;
    
    
}
