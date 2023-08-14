package net.yiyuan.core.file.pojo.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 对象文件处理结果
 */
@Data
@Builder
public class ObjectResponse {

    /**
     * 文件名称（需具备唯一性）
     */
    private String key;
    /**
     * 完整存储路径
     * 各实现类返回规则可能存在差异
     */
    private String storePath;
}
