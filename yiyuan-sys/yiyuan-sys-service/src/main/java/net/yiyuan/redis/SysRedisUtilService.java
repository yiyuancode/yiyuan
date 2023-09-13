package net.yiyuan.redis;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.plugins.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SysRedisUtilService {

  @Autowired private RedisService redisService;

  private String REDIS_DATABASE_OMS = "1";
  private String REDIS_KEY_SYS_AREA_GETAREATREE = "sys:area:getareatree2";
  private Long REDIS_EXPIRE_SYS_AREA_GETAREATREE = 0L;

  public Object GET_SYS_AREA_GETAREATREE() {
    String key = REDIS_DATABASE_OMS + ":" + REDIS_KEY_SYS_AREA_GETAREATREE;
    log.info("key: {}", key);
    return redisService.get(key);
  }

  public void SET_SYS_AREA_GETAREATREE(String data) {
    String key = REDIS_DATABASE_OMS + ":" + REDIS_KEY_SYS_AREA_GETAREATREE;

    if (REDIS_EXPIRE_SYS_AREA_GETAREATREE == 0) {
      redisService.set(key, data);
    } else {
      redisService.set(key, data, REDIS_EXPIRE_SYS_AREA_GETAREATREE);
    }
  }
}
