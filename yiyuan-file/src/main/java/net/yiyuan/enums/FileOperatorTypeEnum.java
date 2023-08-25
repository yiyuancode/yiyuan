package net.yiyuan.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.yiyuan.config.*;
import net.yiyuan.core.file.config.*;
import net.yiyuan.exception.CustomUnifiedException;
import net.yiyuan.core.file.operator.*;
import net.yiyuan.operator.*;

/**
 * 文件操作器类型枚举
 */
@Getter
@AllArgsConstructor
public enum FileOperatorTypeEnum {

    /**
     * 本地文件操作器
     */
    Local(LocalFileOperator.class, LocalConfigProperties.class),
    /**
     * MinIo对象服务操作器
     */
    MinIo(MinIoFileOperator.class, MinIoConfigProperties.class),

    /**
     * FastDFS文件服务操作器
     */
    HuaWei(HuaWeiFileOperator.class, HuaWeiConfigProperties.class),
    /**
     * 外部文件
     */
    EXTERNAL(ExternalFileOperator.class, ExternalConfigProperties.class),
    ;

    /**
     * 文件操作器类型
     */
    private final Class<? extends FileOperatorInter> operatorCls;
    /**
     * 文件操作器配置信息类型
     */
    private final Class<? extends FileOperatorConfigInter> configCls;

    /**
     * 根据名称（忽略大小）获取对象
     *
     * @param name 忽略大小写的名称
     * @return FileOperatorTypeEnum
     */
    public static FileOperatorTypeEnum getIgnoreCaseByName(String name) {
        for (FileOperatorTypeEnum typeEnum : FileOperatorTypeEnum.values()) {
            if (typeEnum.name().equalsIgnoreCase(name)) {
                return typeEnum;
            }
        }
        if (name.contains("EXTERNAL")) {
            return EXTERNAL;
        }
        throw CustomUnifiedException.aom("无指定名称的文件操作器");
    }

    /**
     * 根据操作器类获取对象
     *
     * @param operatorCls 操作器类
     * @return FileOperatorTypeEnum
     */
    public static FileOperatorTypeEnum getIgnoreCaseByName(Class<? extends FileOperatorInter> operatorCls) {
        for (FileOperatorTypeEnum typeEnum : FileOperatorTypeEnum.values()) {
            if (typeEnum.getOperatorCls().isAssignableFrom(operatorCls)) {
                return typeEnum;
            }
        }
        throw CustomUnifiedException.aom("无指定类型的文件操作器");
    }
}
