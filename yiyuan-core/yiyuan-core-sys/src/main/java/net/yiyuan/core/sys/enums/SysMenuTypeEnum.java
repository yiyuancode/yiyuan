package net.yiyuan.core.sys.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 菜单管理-类型枚举类
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Getter  // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT)  // 实现场景2，只需要加上这个注解
public enum SysMenuTypeEnum implements IEnum<Integer> {

    /**
     * 类型#0=目录|1=菜单|2=按钮
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see SysMenuTypeEnum
     */
    CATALOGUE(0, "目录" ),
    /**
     * 类型#0=目录|1=菜单|2=按钮
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see SysMenuTypeEnum
     */
    MENU(1, "菜单" ),
    /**
     * 类型#0=目录|1=菜单|2=按钮
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see SysMenuTypeEnum
     */
    BUTTON(2, "按钮" );

    @EnumValue
    private final int value;
    private final String desc;
    SysMenuTypeEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
}