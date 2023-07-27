package net.yiyuan.core.sys.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.core.sys.enums.*;
import net.yiyuan.plugins.mp.constant.CustomSqlCondition;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜单管理实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Data

public class SysMenu implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     *
     * @date 2023-07-27
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)


    /**
     * 菜单ID
     * @see String
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private String id;


    /**
     * 菜单名称
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see String
     */
    @TableField(condition = CustomSqlCondition.LIKE)
    private String name;


    /**
     * 权限表达式
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see String
     */
    @TableField(condition = CustomSqlCondition.LIKE)
    private String permission;


    /**
     * 上级菜单
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see String
     */
    private String parentId;


    /**
     * 菜单图标
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see String
     */
    @TableField(condition = CustomSqlCondition.LIKE)
    private String icon;


    /**
     * 选中路由名称
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see String
     */
    @TableField(condition = CustomSqlCondition.LIKE)
    private String activeMenu;


    /**
     * 外链#0=否|1=是
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Integer
     */
    private SysMenuIsFrameEnum isFrame;


    /**
     * 外部链接地址
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see String
     */
    @TableField(condition = CustomSqlCondition.LIKE)
    private String frameSrc;


    /**
     * 固定多页签#0=关闭|1=开启
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Integer
     */
    private SysMenuIsAffixEnum isAffix;


    /**
     * 菜单状态#0=停用|1=正常
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Integer
     */
    private SysMenuStatusEnum status;


    /**
     * 简化路由#0=关闭|1=开启
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Integer
     */
    private SysMenuIsAlwaysShowEnum isAlwaysShow;


    /**
     * 是否缓存#0=否|1=是
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Integer
     */
    private SysMenuIsCacheEnum isCache;


    /**
     * 类型#0=目录|1=菜单|2=按钮
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Integer
     */
    private SysMenuTypeEnum type;


    /**
     * 打开方式#0=当前窗口|1=新窗口
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Integer
     */
    private SysMenuOpenTypeEnum openType;


    private Integer sort;


    /**
     * 路由对应组件路径(相对于@也就是src下面,例如：@/pages/pms/RenewalConsume)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see String
     */
    @TableField(condition = CustomSqlCondition.LIKE)
    private String routeComponent;


    /**
     * 路由访问路径(如果是antv-admin,一级路由是它官方定义的,所以咱们添加都不用加/，如果是element-admin，目录类型的path就属于1级.,x需要加、)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see String
     */
    @TableField(condition = CustomSqlCondition.LIKE)
    private String routePath;


    /**
     * 路由名称(菜单表唯一,前端可用path和name两种方式跳转)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see String
     */
    @TableField(condition = CustomSqlCondition.LIKE)
    private String routeName;


    /**
     * 路由默认重定向页面的一级二级所有级全path访问路径(例如)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see String
     */
    @TableField(condition = CustomSqlCondition.LIKE)
    private String routeRedirect;


    /**
     * 创建时间
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Date
     */

    @TableField(fill = FieldFill.INSERT)

    private Date createTime;
    /**
     * 创建时间(查询开始时间)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Date
     */
    @TableField(value = "create_time", condition = CustomSqlCondition.START_EQUAL, select = false)
    private Date createTimeStart;
    /**
     * 创建时间(查询结束时间)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Date
     */
    @TableField(value = "create_time", condition = CustomSqlCondition.END_EQUAL, select = false)
    private Date createTimeEnd;


    /**
     * 修改时间
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Date
     */

    @TableField(fill = FieldFill.INSERT_UPDATE)

    private Date updateTime;
    /**
     * 修改时间(查询开始时间)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Date
     */
    @TableField(value = "update_time", condition = CustomSqlCondition.START_EQUAL, select = false)
    private Date updateTimeStart;
    /**
     * 修改时间(查询结束时间)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Date
     */
    @TableField(value = "update_time", condition = CustomSqlCondition.END_EQUAL, select = false)
    private Date updateTimeEnd;


    /**
     * 租户id
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see String
     */
    @TableField(condition = CustomSqlCondition.LIKE)
    private String tenantId;


    /**
     * 创建人
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see String
     */
    @TableField(condition = CustomSqlCondition.LIKE)
    private String createUser;


    /**
     * 修改人
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see String
     */
    @TableField(condition = CustomSqlCondition.LIKE)
    private String updateUser;


}