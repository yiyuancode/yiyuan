package net.yiyuan.core.sys.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 菜单表-简化路由枚举类
 *
 * @author 一源团队--花和尚
 * @date 2023-07-13
 */
public enum SysMenuIsAlwaysShowEnum {
    
    /**
     * 简化路由#0=关闭|1=开启#开启以后只有一个时候直接显示子菜单
     *
     * @author 一源团队--花和尚
     * @date 2023-07-13
     * @see SysMenuIsAlwaysShowEnum
     */
    SHUT_DOWN(0, "关闭" ),
    /**
     * 简化路由#0=关闭|1=开启#开启以后只有一个时候直接显示子菜单
     *
     * @author 一源团队--花和尚
     * @date 2023-07-13
     * @see SysMenuIsAlwaysShowEnum
     */
    OPEN(1, "开启" );
    
    @EnumValue
    private final int code;
    @JsonValue
    private final String desc;
    SysMenuIsAlwaysShowEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}