package net.yiyuan.admin.redis;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.plugins.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AdminRedisService {

  @Autowired private RedisService redisService;

  private String REDIS_DATABASE_OMS = "1";
  private String REDIS_KEY_ADMIN_USER_PERMISSION = "admin:user:permission";
  private Long REDIS_EXPIRE_ADMIN_USER_PERMISSION = 0L;

  private String REDIS_KEY_ADMIN_USER_ROLE = "admin:user:role";
  private Long REDIS_EXPIRE_ADMIN_USER_ROLE = 0L;

  private String REDIS_KEY_ADMIN_FONT_TTF = "admin:font:ttf";
  private Long REDIS_EXPIRE_ADMIN_FONT_TTF = 0L;

  public List<String> GET_ADMIN_USER_PERMISSION(String userId) {
    String key = REDIS_DATABASE_OMS + ":" + REDIS_KEY_ADMIN_USER_PERMISSION + ":" + userId;
    log.info("key: {}", key);
    return (List<String>) redisService.get(key);
  }

  public void SET_ADMIN_USER_PERMISSION(String userId, List<String> data) {
    String key = REDIS_DATABASE_OMS + ":" + REDIS_KEY_ADMIN_USER_PERMISSION + ":" + userId;

    if (REDIS_EXPIRE_ADMIN_USER_PERMISSION == 0) {
      redisService.set(key, data);
    } else {
      redisService.set(key, data, REDIS_EXPIRE_ADMIN_USER_PERMISSION);
    }
  }

  public boolean DEL_ADMIN_USER_PERMISSION(String userId) {
    String key = REDIS_DATABASE_OMS + ":" + REDIS_KEY_ADMIN_USER_ROLE + ":" + userId;
    log.info("key: {}", key);
    Boolean del = redisService.del(key);
    return del;
  }

  public List<String> GET_ADMIN_USER_ROLE(String userId) {
    String key = REDIS_DATABASE_OMS + ":" + REDIS_KEY_ADMIN_USER_ROLE + ":" + userId;
    log.info("key: {}", key);
    return (List<String>) redisService.get(key);
  }

  public void SET_ADMIN_USER_ROLE(String userId, List<String> data) {
    String key = REDIS_DATABASE_OMS + ":" + REDIS_KEY_ADMIN_USER_ROLE + ":" + userId;

    if (REDIS_EXPIRE_ADMIN_USER_ROLE == 0) {
      redisService.set(key, data);
    } else {
      redisService.set(key, data, REDIS_EXPIRE_ADMIN_USER_ROLE);
    }
  }

  public boolean DEL_ADMIN_USER_ROLE(String userId) {
    String key = REDIS_DATABASE_OMS + ":" + REDIS_KEY_ADMIN_USER_ROLE + ":" + userId;
    log.info("key: {}", key);
    Boolean del = redisService.del(key);
    return del;
  }

  public String GET_ADMIN_FONT_TTF(String ttfId) {
    String key = REDIS_DATABASE_OMS + ":" + REDIS_KEY_ADMIN_FONT_TTF + ":" + ttfId;
    log.info("key: {}", key);
    return (String) redisService.get(key);
  }

  public void SET_ADMIN_FONT_TTF(String ttfId, String data) {
    String key = REDIS_DATABASE_OMS + ":" + REDIS_KEY_ADMIN_FONT_TTF + ":" + ttfId;

    if (REDIS_EXPIRE_ADMIN_FONT_TTF == 0) {
      redisService.set(key, data);
    } else {
      redisService.set(key, data, REDIS_EXPIRE_ADMIN_FONT_TTF);
    }
  }

  public boolean DEL_ADMIN_FONT_TTF(String userId) {
    String key = REDIS_DATABASE_OMS + ":" + REDIS_KEY_ADMIN_FONT_TTF + ":" + userId;
    log.info("key: {}", key);
    Boolean del = redisService.del(key);
    return del;
  }
}
