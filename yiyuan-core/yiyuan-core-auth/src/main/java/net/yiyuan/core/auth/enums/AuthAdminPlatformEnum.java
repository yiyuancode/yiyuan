package net.yiyuan.core.auth.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 用户管理-平台类型枚举类
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Getter  // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT)  // 实现场景2，只需要加上这个注解
public enum AuthAdminPlatformEnum implements IEnum<Integer> {

    /**
     * 平台类型#0=平台端|1=租户端|2=移动端
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see AuthAdminPlatformEnum
     */
    PLATFORM_SIDE(0, "平台端" ),
    /**
     * 平台类型#0=平台端|1=租户端|2=移动端
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see AuthAdminPlatformEnum
     */
    TENANT_END(1, "租户端" ),
    /**
     * 平台类型#0=平台端|1=租户端|2=移动端
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see AuthAdminPlatformEnum
     */
    MOBILE_END(2, "移动端" );

    @EnumValue
    private final int value;
    private final String desc;

    AuthAdminPlatformEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
}