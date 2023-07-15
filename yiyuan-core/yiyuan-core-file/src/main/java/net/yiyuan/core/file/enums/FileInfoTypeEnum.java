package net.yiyuan.core.file.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.yiyuan.core.file.exception.CustomUnifiedException;

/**
 * -类型枚举类
 *
 * @author 一
 * @date 2023-07-15
 */
@Getter
@AllArgsConstructor
public enum FileInfoTypeEnum {

    /**
     * 类型#0=本地服务器|1=MinIo对象服务|2=FastDFS文件服务|4=华为云存储
     *
     * @author 一
     * @date 2023-07-15
     * @see FileInfoTypeEnum
     */
    Local(0, "本地服务器"),
    /**
     * 类型#0=本地服务器|1=MinIo对象服务|2=FastDFS文件服务|4=华为云存储
     *
     * @author 一
     * @date 2023-07-15
     * @see FileInfoTypeEnum
     */
    MINIO(1, "MinIo对象服务"),
    /**
     * 类型#0=本地服务器|1=MinIo对象服务|2=FastDFS文件服务|4=华为云存储
     *
     * @author 一
     * @date 2023-07-15
     * @see FileInfoTypeEnum
     */
    EXTERNAL(2, "FastDFS文件服务"),
    /**
     * 类型#0=本地服务器|1=MinIo对象服务|2=FastDFS文件服务|4=华为云存储
     *
     * @author 一
     * @date 2023-07-15
     * @see FileInfoTypeEnum
     */
    HUAWEI(4, "华为云存储");

    @EnumValue
    private final int code;
    @JsonValue
    private final String desc;

    /**
     * 根据文件存储类型名获取枚举
     *
     * @param name 文件存储类型名
     * @return Type
     */
    public static FileInfoTypeEnum getTypeEnum(String name) {
        for (FileInfoTypeEnum type : FileInfoTypeEnum.values()) {
            if (type.name().equalsIgnoreCase(name)) {
                return type;
            }
        }
        throw CustomUnifiedException.aom("无效的文件存储类型名");
    }
}