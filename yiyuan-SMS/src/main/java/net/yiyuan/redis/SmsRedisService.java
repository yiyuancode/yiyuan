package net.yiyuan.redis;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.plugins.redis.service.RedisService;
import net.yiyuan.plugins.redis.service.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SmsRedisService extends RedisServiceImpl {

  public static String REDIS_KEY_SMS_PERMISSION = "sms:permission:";
  public static Long REDIS_EXPIRE_ADMIN_USER_PERMISSION = 60L;
  public static String REDIS_KEY_EMAIL_PERMISSION = "email:permission:";
  @Autowired private RedisService redisService;
}
