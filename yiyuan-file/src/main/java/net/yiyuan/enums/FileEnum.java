package net.yiyuan.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.yiyuan.exception.CustomUnifiedException;

/**
 * 文件相关枚举
 *
 * @author zj
 */
public class FileEnum {

    @Getter
    @AllArgsConstructor
    public enum State {
        //文件状态
        TEMPORARY("0", "临时"),
        SUCCESS("2", "存储成功");
        private String value;
        private String desc;
    }

    @Getter
    @AllArgsConstructor
    public enum Type {
        //存储方式
        Local("0", "本地服务器"),
        MinIo("1", "MinIo对象服务"),
        FastDFS("2", "FastDFS文件服务"),
        HuaWei("4", "华为云存储");
        private final String value;
        private final String desc;

        /**
         * 根据文件存储类型名获取枚举
         *
         * @param name 文件存储类型名
         * @return Type
         */
        public static Type getTypeEnum(String name) {
            for (Type type : Type.values()) {
                if (type.name().equalsIgnoreCase(name)) {
                    return type;
                }
            }
            throw CustomUnifiedException.aom("无效的文件存储类型名");
        }
    }
}
