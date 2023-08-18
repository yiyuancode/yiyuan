package net.yiyuan.tenant.redis;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.plugins.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TenantRedisService {

  @Autowired private RedisService redisService;

  private String REDIS_DATABASE_OMS = "1";
  private String REDIS_KEY_TENANT_USER_PERMISSION = "tenant:user:permission";
  private Long REDIS_EXPIRE_TENANT_USER_PERMISSION = 0L;

  private String REDIS_KEY_TENANT_USER_ROLE = "tenant:user:role";
  private Long REDIS_EXPIRE_TENANT_USER_ROLE = 0L;

  public List<String> GET_TENANT_USER_PERMISSION(String userId) {
    String key = REDIS_DATABASE_OMS + ":" + REDIS_KEY_TENANT_USER_PERMISSION + ":" + userId;
    log.info("key: {}", key);
    return (List<String>) redisService.get(key);
  }

  public void SET_TENANT_USER_PERMISSION(String userId, List<String> data) {
    String key = REDIS_DATABASE_OMS + ":" + REDIS_KEY_TENANT_USER_PERMISSION + ":" + userId;

    if (REDIS_EXPIRE_TENANT_USER_PERMISSION == 0) {
      redisService.set(key, data);
    } else {
      redisService.set(key, data, REDIS_EXPIRE_TENANT_USER_PERMISSION);
    }
  }

  public boolean DEL_TENANT_USER_PERMISSION(String userId) {
    String key = REDIS_DATABASE_OMS + ":" + REDIS_KEY_TENANT_USER_ROLE + ":" + userId;
    log.info("key: {}", key);
    Boolean del = redisService.del(key);
    return del;
  }

  public List<String> GET_TENANT_USER_ROLE(String userId) {
    String key = REDIS_DATABASE_OMS + ":" + REDIS_KEY_TENANT_USER_ROLE + ":" + userId;
    log.info("key: {}", key);
    return (List<String>) redisService.get(key);
  }

  public void SET_TENANT_USER_ROLE(String userId, List<String> data) {
    String key = REDIS_DATABASE_OMS + ":" + REDIS_KEY_TENANT_USER_ROLE + ":" + userId;

    if (REDIS_EXPIRE_TENANT_USER_ROLE == 0) {
      redisService.set(key, data);
    } else {
      redisService.set(key, data, REDIS_EXPIRE_TENANT_USER_ROLE);
    }
  }

  public boolean DEL_TENANT_USER_ROLE(String userId) {
    String key = REDIS_DATABASE_OMS + ":" + REDIS_KEY_TENANT_USER_ROLE + ":" + userId;
    log.info("key: {}", key);
    Boolean del = redisService.del(key);
    return del;
  }
}
