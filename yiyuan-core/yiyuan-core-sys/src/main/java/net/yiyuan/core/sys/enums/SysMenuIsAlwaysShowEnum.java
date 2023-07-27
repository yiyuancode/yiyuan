package net.yiyuan.core.sys.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 菜单管理-简化路由枚举类
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Getter  // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT)  // 实现场景2，只需要加上这个注解
public enum SysMenuIsAlwaysShowEnum implements IEnum<Integer> {
    
    /**
     * 简化路由#0=关闭|1=开启
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see SysMenuIsAlwaysShowEnum
     */
    CLOSE(0, "关闭" ),
    /**
     * 简化路由#0=关闭|1=开启
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see SysMenuIsAlwaysShowEnum
     */
    OPEN(1, "开启" );
    
    @EnumValue
    private final int value;
    private final String desc;
    
    SysMenuIsAlwaysShowEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
    
    @Override
    public Integer getValue() {
        return this.value;
    }
}