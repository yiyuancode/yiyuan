package net.yiyuan.core.file.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

/**
 * 华为OSS文件操作器配置
 */
@Getter
@Component
@ConditionalOnExpression("${file.server.huawei.enabled:false}")
public class HuaWeiConfigProperties implements FileOperatorConfigInter {
    //终端地址
    @Value("${file.server.huawei.endpoint:''}")
    private String endpoint;
    //accessKey
    @Value("${file.server.huawei.accessKey:''}")
    private String accessKey;
    //secretKey
    @Value("${file.server.huawei.secretKey:''}")
    private String secretKey;
}
