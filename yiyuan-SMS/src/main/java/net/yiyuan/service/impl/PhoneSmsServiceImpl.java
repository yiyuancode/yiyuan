package net.yiyuan.service.impl;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.config.SmsConfig;
import net.yiyuan.pojo.SmsCode;
import net.yiyuan.redis.SmsRedisService;
import net.yiyuan.service.SmsAndEmailService;
import net.yiyuan.utils.CheckUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Slf4j
@Service
public class PhoneSmsServiceImpl implements SmsAndEmailService {
    /**
     * 验证码有效时长
     */
    private static final int fix = 5;


    @Resource
    private SmsConfig smsConfig;

    @Resource
    private SmsRedisService smsRedisService;

    @Override
    public CommonResult<String> verifySms(String phoneOrEmail) throws ClientException {
        log.info("发送短信验证码，phone={}", phoneOrEmail);
        // 校验手机格式
        if (!CheckUtil.checkPhoneNumber(phoneOrEmail)) {
            return CommonResult.failed("手机号码格式不正确");
        }
        // 生成6位短信验证码
        SmsCode smsCode = buildSmsCode(phoneOrEmail);
        // 发送短信验证码
        CommonResult<?> sendResult = doSingleTplSms(smsCode);
        if (200 == sendResult.getCode()) {
            log.info("短信发送成功，phone={}", phoneOrEmail);
            return CommonResult.success(smsCode.getPhone(), "短信发送成功");
        }
        log.error("短信发送失败，phone={}", phoneOrEmail);
        return CommonResult.failed("短信发送失败");
    }

    @Override
    public boolean checkSmsCode(String phoneOrEmail, String code) {

        if (StringUtils.isBlank(phoneOrEmail) || StringUtils.isBlank(code)) {
            return false;
        }
        String scode = smsRedisService.GET_SMS_PERMISSION(phoneOrEmail);

        return code.equals(scode);
    }


    public CommonResult<?> doSingleTplSms(SmsCode smsCode) throws ClientException {

        log.info("阿里云短信发送接口：param -> {}", JSON.toJSONString(smsCode));
        DefaultProfile profile = DefaultProfile.getProfile("ap-northeast-1",smsConfig.getAppKey(),smsConfig.getAppSecure());
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("PhoneNumbers",smsCode.getPhone());
        request.putQueryParameter("SignName",smsConfig.getSignName());
        request.putQueryParameter("TemplateCode",smsConfig.getTemplateCode());
        request.putQueryParameter("TemplateParam","{\"code\":\""+smsCode.getCode()+"\"}");

        CommonResponse response = client.getCommonResponse(request);
        String string = response.getData().toString();
        Map map = JSON.parseObject(string, Map.class);

        if ("OK".equalsIgnoreCase((String) map.get("Code"))) {

            smsRedisService.SET_SMS_PERMISSION(smsCode.getPhone(),smsCode.getCode());
            return CommonResult.success(smsCode.getPhone(), "短信发送成功");
        }
        System.out.println(response.getData());


        log.warn("阿里云短信发送失败");
        return CommonResult.failed("短信发送失败");
    }

    /**
     * 新建6位验证码
     *
     * @param phone 手机号
     * @return 验证码
     */
    public SmsCode buildSmsCode(String phone) {

        if (smsRedisService.GET_SMS_PERMISSION(phone) != null) {
            throw new BusinessException("请勿重复发送短信");
        }
        return new SmsCode(phone, fix);
    }
}
