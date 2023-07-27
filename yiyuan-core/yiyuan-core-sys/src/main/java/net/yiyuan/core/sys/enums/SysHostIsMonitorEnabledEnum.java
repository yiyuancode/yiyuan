package net.yiyuan.core.sys.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 主机记录管理-开启监控枚举类
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Getter  // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT)  // 实现场景2，只需要加上这个注解
public enum SysHostIsMonitorEnabledEnum implements IEnum<Integer> {
    
    /**
     * 开启监控#0=开启|1=关闭|
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see SysHostIsMonitorEnabledEnum
     */
    OPEN(0, "开启" ),
    /**
     * 开启监控#0=开启|1=关闭|
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see SysHostIsMonitorEnabledEnum
     */
    CLOSE(1, "关闭" );
    
    @EnumValue
    private final int value;
    private final String desc;
    
    SysHostIsMonitorEnabledEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
    
    @Override
    public Integer getValue() {
        return this.value;
    }
}