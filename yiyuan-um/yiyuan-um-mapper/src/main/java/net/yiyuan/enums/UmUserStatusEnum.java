package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 用户管理-状态枚举类
 *
 * @author 小林同学
 * @date 2023-09-18
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum UmUserStatusEnum implements IEnum<Integer> {

    /**
     * 状态#1=正常|0=禁止
     *
     * @author 小林同学
     * @date 2023-09-18
     * @see UmUserStatusEnum
     */
    NORMAL(1, "正常"),
    /**
     * 状态#1=正常|0=禁止
     *
     * @author 小林同学
     * @date 2023-09-18
     * @see UmUserStatusEnum
     */
    PROHIBIT(0, "禁止");

    @EnumValue
    private final int value;
    private final String desc;

    UmUserStatusEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
}
