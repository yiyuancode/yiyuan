package net.yiyuan.core.file.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

/**
 * FastDFS文件操作器配置
 */
@Getter
@Component
@ConditionalOnExpression("${file.server.fastdfs.enabled:false}")
public class FastDfsConfigProperties implements FileOperatorConfigInter {

    /**
     * 多tracker逗号分隔
     */
    @Value("${file.server.fastdfs.trackerList:''}")
    private String trackerList;
    /**
     * 连接池连接的数据读取超时时间（s）
     */
    @Value("${file.server.fastdfs.soTimeout:30}")
    private String soTimeout;
    /**
     * 连接池创建连接的等待超时时间（s）
     */
    @Value("${file.server.fastdfs.connectTimeout:5}")
    private String connectTimeout;
}
