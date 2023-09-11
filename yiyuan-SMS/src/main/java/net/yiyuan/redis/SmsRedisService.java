package net.yiyuan.redis;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.plugins.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SmsRedisService {

    @Autowired
    private RedisService redisService;
    private String REDIS_DATABASE_OMS = "1";

    private String REDIS_KEY_SMS_PERMISSION = "sms:permission";

    private Long REDIS_EXPIRE_ADMIN_USER_PERMISSION = 60L;
    /**
     *
     * 获取短信验证码对比
     * @param phone
     * @return
     */
    public String GET_SMS_PERMISSION(String phone){
        String key = REDIS_DATABASE_OMS + ":" + REDIS_KEY_SMS_PERMISSION + ":" + phone;
        log.info("key: {}", key);
        return (String) redisService.get(key);
    }

    /**
     * 将验证码设置到redis中
     * @param phone
     * @param code
     */
    public void SET_SMS_PERMISSION(String phone, String code) {
        String key = REDIS_DATABASE_OMS + ":" + REDIS_KEY_SMS_PERMISSION + ":" + phone;

        if (REDIS_EXPIRE_ADMIN_USER_PERMISSION == 0) {
            redisService.set(key, code);
        } else {
            redisService.set(key, code, REDIS_EXPIRE_ADMIN_USER_PERMISSION);
        }
    }

    /**
     * 再次请求，删除redis当中的key
     * @param phone
     */
    public boolean DEL_SMS_PERMISSION(String phone) {
        String key = REDIS_DATABASE_OMS + ":" + REDIS_KEY_SMS_PERMISSION + ":" + phone;

       return redisService.del(key);

    }

}
