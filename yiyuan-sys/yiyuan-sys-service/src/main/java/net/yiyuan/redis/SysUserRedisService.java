package net.yiyuan.redis;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.plugins.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class SysUserRedisService {

  public static String KEY_SYS_USER = "sys:user";
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
    if (data instanceof List) {
      List<?> dataList = (List<?>) data;
      if ((!dataList.isEmpty() && dataList.get(0) instanceof String)
          || (data instanceof Integer)
          || (data instanceof Double)
          || (data instanceof Boolean)) {
        if (ttl == null) {
          redisService.set(key + keyId, data);
        } else {
          redisService.set(key + keyId, data, ttl);
        }
      } else {
        if (ttl == null) {
          redisService.set(key + keyId, JSONObject.toJSONString(data));
        } else {
          redisService.set(key + keyId, JSONObject.toJSONString(data), ttl);
        }
      }
    } else {
      if (data instanceof String
          || (data instanceof Integer)
          || (data instanceof Double)
          || (data instanceof Boolean)) {
        if (ttl == null) {
          redisService.set(key + keyId, data);
        } else {
          redisService.set(key + keyId, data, ttl);
        }
      } else {
        if (ttl == null) {
          redisService.set(key + keyId, JSONObject.toJSONString(data));
        } else {
          redisService.set(key + keyId, JSONObject.toJSONString(data), ttl);
        }
      }
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
    if (cls.equals(String.class)
        || cls.equals(Integer.class)
        || cls.equals(Double.class)
        || cls.equals(Boolean.class)
        || cls.equals(Float.class)) {
      return (T) redisService.get(key + keyId);
    } else {
      return (T) JSONObject.parseObject((String) redisService.get(key + keyId), cls);
    }
  }

  /**
   * 获取复杂类型，对象，可能会包含枚举值得一类，reids无法自动序列化得问题解决
   *
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  public <T> List<T> getList(String key, String keyId, Class<T> cls) {
    if (cls.equals(String.class)
        || cls.equals(Integer.class)
        || cls.equals(Double.class)
        || cls.equals(Boolean.class)
        || cls.equals(Float.class)) {
      return (List<T>) redisService.get(key + keyId);
    } else {
      return (List<T>) JSONObject.parseArray((String) redisService.get(key + keyId), cls);
    }
  }

  //  /**
  //   * 存基本类型，string，string集合或者数组
  //   *
  //   * @return {@link boolean}
  //   * @author 一源-花和尚
  //   * @date 2023-09-18
  //   */
  //  public Object getStr(String key, String keyId) {
  //    return redisService.get(key + keyId);
  //  }
  //
  //  /**
  //   * 存储复杂类型，对象或者对象集合，可能会包含枚举值得一类，reids无法自动序列化得问题解决
  //   *
  //   * @return {@link boolean}
  //   * @author 一源-花和尚
  //   * @date 2023-09-18
  //   */
  //  public void setJson(String key, String keyId, Object data, Long ttl) {
  //    String s = JSONObject.toJSONString(data);
  //    if (ttl == null) {
  //      redisService.set(key + keyId, s);
  //    } else {
  //      redisService.set(key + keyId, s, ttl);
  //    }
  //  }
  //
  //  /**
  //   * 获取复杂类型，对象，可能会包含枚举值得一类，reids无法自动序列化得问题解决
  //   *
  //   * @return {@link boolean}
  //   * @author 一源-花和尚
  //   * @date 2023-09-18
  //   */
  //  public <T> T getJsonObj(String key, String keyId, Class<T> cls) {
  //    String s = (String) redisService.get(key + keyId);
  //    return (T) JSONObject.parseObject(s, cls);
  //  }
  //
  //  /**
  //   * 获取复杂类型，对象集合，可能会包含枚举值得一类，reids无法自动序列化得问题解决
  //   *
  //   * @return {@link boolean}
  //   * @author 一源-花和尚
  //   * @date 2023-09-18
  //   */
  //  public <T> List<T> getJsonList(String key, String keyId, Class<T> cls) {
  //    if (cls == String.class) {}
  //
  //    String s = (String) redisService.get(key + keyId);
  //    List<T> list = new ArrayList<>();
  //    list = JSONObject.parseArray(s, cls);
  //    return list;
  //  }

  public void del(String key, String keyId) {
    redisService.del(key + keyId);
  }
}
