package net.yiyuan.core.file.pojo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * 上传请求参数
 */
@Data
@Builder
public class UploadRequestParam {

    /**
     * 上传桶名称（本地为：相对路径）
     */
    private String bucketName;
    /**
     * 文件名称（需具备唯一性）
     */
    private String key;
    /**
     * 文件大小
     */
    private Long size;
    /**
     * 文件扩展名
     */
    private String extName;
    /**
     * 分区上传大小
     */
    private Long partSize;
    /**
     * 文件的contentType类型
     */
    private String contentType;
    /**
     * 文件的其他元数据信息
     */
    private Map<String, String> metadata;
}
