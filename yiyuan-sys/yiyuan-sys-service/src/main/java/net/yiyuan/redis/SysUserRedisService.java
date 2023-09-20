package net.yiyuan.redis;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.plugins.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SysUserRedisService {

  @Autowired private RedisService redisService;

  public static String KEY_SYS_USER_PERMISSION = "sys:user:permissions";
  public static Long EXPIRE_SYS_USER_PERMISSION = 0L;

  public static String KEY_SYS_USER_ROLE = "sys:user:roles";
  public static Long EXPIRE_SYS_USER_ROLE = 0L;

  public void set(String key, String keyId, Object data, Long ttl) {
    if (ttl == 0L) {
      redisService.set(key + keyId, data);
    } else {
      redisService.set(key + keyId, data, ttl);
    }
  }

  public Object get(String key, String keyId) {
    return redisService.get(key + keyId);
  }

  public void del(String key, String keyId) {
    redisService.del(key + keyId);
  }
}
