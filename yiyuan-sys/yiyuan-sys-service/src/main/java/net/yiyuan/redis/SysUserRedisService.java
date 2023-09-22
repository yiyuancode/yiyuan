package net.yiyuan.redis;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.plugins.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class SysUserRedisService {

  public static String KEY_SYS_USER = "sys:user";
  // 单位秒
  public static Long EXPIRE_SYS_USER = 0L;

  public static String KEY_SYS_USER_MENU = "sys:user:menu";
  public static Long EXPIRE_SYS_USER_MENU = 0L;

  public static String KEY_SYS_USER_ROLE = "sys:user:role";
  public static Long EXPIRE_SYS_USER_ROLE = 0L;

  public static String KEY_SYS_USER_MENU_PERMISSION = "sys:user:menu:permission";
  public static Long EXPIRE_SYS_USER_MENU_PERMISSION = 0L;

  public static String KEY_SYS_USER_ROLE_CODE = "sys:user:role:code";
  public static Long EXPIRE_SYS_USER_ROLE_CODE = 0L;

  @Autowired private RedisService redisService;

  /**
   * 存基本类型，string，string集合或者数组
   *
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  public void set(String key, String keyId, Object data, Long ttl) {
    if (ttl == null) {
      redisService.set(key + keyId, data);
    } else {
      redisService.set(key + keyId, data, ttl);
    }
  }

  /**
   * 获取复杂类型，对象，可能会包含枚举值得一类，reids无法自动序列化得问题解决
   *
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  public <T> T get(String key, String keyId, Class<T> cls) {
    return (T) redisService.get(key + keyId, cls);
  }

  /**
   * 获取复杂类型，对象，可能会包含枚举值得一类，reids无法自动序列化得问题解决
   *
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  public <T> List<T> getList(String key, String keyId, Class<T> cls) {
    return (List<T>) redisService.getList(key + keyId, cls);
  }

  /**
   * 删除指定key数据
   *
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  public void del(String key, String keyId) {
    redisService.del(key + keyId);
  }
}
