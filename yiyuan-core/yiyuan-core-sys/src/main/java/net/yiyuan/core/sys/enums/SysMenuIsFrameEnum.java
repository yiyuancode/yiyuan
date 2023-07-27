package net.yiyuan.core.sys.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 菜单管理-外链枚举类
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Getter  // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT)  // 实现场景2，只需要加上这个注解
public enum SysMenuIsFrameEnum implements IEnum<Integer> {
    
    /**
     * 外链#0=否|1=是
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see SysMenuIsFrameEnum
     */
    NO(0, "否" ),
    /**
     * 外链#0=否|1=是
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see SysMenuIsFrameEnum
     */
    YES(1, "是" );
    
    @EnumValue
    private final int value;
    private final String desc;
    
    SysMenuIsFrameEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
    
    @Override
    public Integer getValue() {
        return this.value;
    }
}