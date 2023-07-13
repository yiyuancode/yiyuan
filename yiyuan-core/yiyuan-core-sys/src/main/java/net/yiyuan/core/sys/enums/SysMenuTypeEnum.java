package net.yiyuan.core.sys.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 菜单表-类型枚举类
 *
 * @author 一源团队--花和尚
 * @date 2023-07-13
 */
public enum SysMenuTypeEnum {
    
    /**
     * 类型#0=目录|1=菜单|2=按钮
     *
     * @author 一源团队--花和尚
     * @date 2023-07-13
     * @see SysMenuTypeEnum
     */
    DIRECTORY(0, "目录" ),
    /**
     * 类型#0=目录|1=菜单|2=按钮
     *
     * @author 一源团队--花和尚
     * @date 2023-07-13
     * @see SysMenuTypeEnum
     */
    THE_MENU(1, "菜单" ),
    /**
     * 类型#0=目录|1=菜单|2=按钮
     *
     * @author 一源团队--花和尚
     * @date 2023-07-13
     * @see SysMenuTypeEnum
     */
    BUTTON(2, "按钮" );
    
    @EnumValue
    private final int code;
    @JsonValue
    private final String desc;
    SysMenuTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}