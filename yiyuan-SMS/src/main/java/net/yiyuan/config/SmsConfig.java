package net.yiyuan.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class SmsConfig {

    @Value("${sms.config.aliyun.templateCode}")
    private String templateCode;
    @Value("${sms.config.aliyun.signName}")
    protected String signName;
    @Value("${sms.config.aliyun.appKey:#{null}}")
    private String appKey;
    @Value("${sms.config.aliyun.appSecret:#{null}}")
    private String appSecure;
}
