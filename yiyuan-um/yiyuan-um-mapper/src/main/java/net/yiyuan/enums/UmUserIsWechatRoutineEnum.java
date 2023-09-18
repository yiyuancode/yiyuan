package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 用户管理-是否关联小程序枚举类
 *
 * @author 小林同学
 * @date 2023-09-18
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum UmUserIsWechatRoutineEnum implements IEnum<Integer> {

    /**
     * 是否关联小程序#0=否|1=是
     *
     * @author 小林同学
     * @date 2023-09-18
     * @see UmUserIsWechatRoutineEnum
     */
    NO(0, "否"),
    /**
     * 是否关联小程序#0=否|1=是
     *
     * @author 小林同学
     * @date 2023-09-18
     * @see UmUserIsWechatRoutineEnum
     */
    YES(1, "是");

    @EnumValue
    private final int value;
    private final String desc;

    UmUserIsWechatRoutineEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
}
