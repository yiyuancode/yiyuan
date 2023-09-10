package net.yiyuan.service;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.admin.redis.AdminRedisService;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.pojo.SmsCode;
import net.yiyuan.pojo.SmsCodeCache;
import net.yiyuan.utils.CheckUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
@Slf4j
public class AliyunSmsService {

    /**
     * 验证码有效时长
     */
    private static final int fix = 5;

    @Value("${sms.config.aliyun.templateCode}")
    private String templateCode;
    @Value("${sms.config.aliyun.signName}")
    protected String signName;
    @Value("${sms.config.aliyun.appKey:#{null}}")
    private String appKey;
    @Value("${sms.config.aliyun.appSecret:#{null}}")
    private String appSecure;

    @Resource
    private AdminRedisService adminRedisService;
    /**
     * 获取短信验证码
     *
     * @param phone 手机号码
     */
    public CommonResult<String> verifySms(String phone) {
        log.info("发送短信验证码，phone={}", phone);
        // 校验手机格式
        if (!CheckUtil.checkPhoneNumber(phone)) {
            return CommonResult.failed("手机号码格式不正确");
        }
        // 生成6位短信验证码
        SmsCode smsCode = buildSmsCode(phone);
        // 发送短信验证码
        CommonResult<?> sendResult = doSingleTplSms(smsCode);
        if (200 == sendResult.getCode()) {
            log.info("短信发送成功，phone={}", phone);
            return CommonResult.success(smsCode.getCodeId(), "短信发送成功");
        }
        log.error("短信发送失败，phone={}", phone);
        return CommonResult.failed("短信发送失败");
    }


    /**
     * 短信验证码校验
     *
     * @param codeId 验证码ID
     * @param code   6位随机数验证码
     * @return
     */
    public boolean checkSmsCode(String codeId, String code) {

        if (StringUtils.isBlank(codeId) || StringUtils.isBlank(code)) {
            return false;
        }
        String scode = adminRedisService.GET_SMS_PERMISSION(codeId);


        return code.equals(scode);
    }


    public CommonResult<?> doSingleTplSms(SmsCode smsCode) {
        log.info("阿里云短信发送接口：param -> {}", JSON.toJSONString(smsCode));
        DefaultProfile profile = DefaultProfile.getProfile("ap-northeast-1",appKey,appSecure);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("PhoneNumbers",smsCode.getPhone());
        request.putQueryParameter("SignName",signName);
        request.putQueryParameter("TemplateCode",templateCode);
        request.putQueryParameter("TemplateParam","{\"code\":\""+smsCode.getCode()+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            String string = response.getData().toString();
            Map map = JSON.parseObject(string, Map.class);

            if ("OK".equalsIgnoreCase((String) map.get("Code"))) {

                adminRedisService.SET_SMS_PERMISSION(smsCode.getCodeId(),smsCode.getCode());
                return CommonResult.success(smsCode.getCodeId(), "短信发送成功");
            }
            System.out.println(response.getData());
        } catch (ClientException e) {
            log.error("阿里云短信调用异常【发送调用】", e);
        }

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
        SmsCodeCache smsCodeCache = SmsCodeCache.getInstance();
        if (smsCodeCache.get(phone) != null) {
            smsCodeCache.remove(phone);
        }
        return new SmsCode(phone, fix);
    }

}
