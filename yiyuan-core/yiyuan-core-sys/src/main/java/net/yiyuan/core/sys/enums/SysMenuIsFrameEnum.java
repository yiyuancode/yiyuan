package net.yiyuan.core.sys.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;

/**
 * 菜单表-外链枚举类
 *
 * @author 一源团队--花和尚
 * @date 2023-07-13
 */
@JsonFormat(shape= JsonFormat.Shape.OBJECT)
@Getter
public enum SysMenuIsFrameEnum {
    
    /**
     * 外链#0=否|1=是
     *
     * @author 一源团队--花和尚
     * @date 2023-07-13
     * @see SysMenuIsFrameEnum
     */
    NO(0, "否" ),
    /**
     * 外链#0=否|1=是
     *
     * @author 一源团队--花和尚
     * @date 2023-07-13
     * @see SysMenuIsFrameEnum
     */
    IS(1, "是" );
    @EnumValue
    private final int code;
//    @JsonFormat(shape= JsonFormat.Shape.OBJECT)
    private final String desc;
    SysMenuIsFrameEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    
    // 若不配置@JsonCreator，jackson反序列化时则使用@JsonValue标记的字段做映射
//    @JsonCreator
//    public static SysMenuIsFrameEnum jacksonInstance(final JsonNode jsonNode) {
//        int code = jsonNode.asInt();
//        SysMenuIsFrameEnum[] values = SysMenuIsFrameEnum.values();
//        for (SysMenuIsFrameEnum sexEnum : values) {
//            if (sexEnum.getCode()==code) {
//                return sexEnum;
//            }
//        }
//        return null;
//    }

}