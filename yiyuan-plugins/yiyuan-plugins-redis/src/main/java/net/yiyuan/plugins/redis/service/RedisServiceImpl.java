package net.yiyuan.plugins.redis.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/** redis操作实现类 Created by macro on 2020/3/3. */
public class RedisServiceImpl implements RedisService {
  @Autowired private RedisTemplate<String, Object> redisTemplate;

  /**
   * 存基本类型，string，string集合或者数组
   *
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public void set(String key, String keyId, Object data, Long ttl) {
    if (ttl == null) {
      this.set(key + keyId, data);
    } else {
      this.set(key + keyId, data, ttl);
    }
  }

  /**
   * 获取复杂类型，对象，可能会包含枚举值得一类，reids无法自动序列化得问题解决
   *
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public <T> T get(String key, String keyId, Class<T> cls) {
    return (T) this.get(key + keyId, cls);
  }

  /**
   * 获取复杂类型，对象，可能会包含枚举值得一类，reids无法自动序列化得问题解决
   *
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public <T> List<T> getList(String key, String keyId, Class<T> cls) {
    return (List<T>) this.getList(key + keyId, cls);
  }

  /**
   * 删除指定key数据
   *
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public void del(String key, String keyId) {
    this.del(key + keyId);
  }

  @Override
  public void set(String key, Object value, long time) {
    // 非基本类型或者非基本类型得集合
    boolean isOther = true;
    if (value instanceof List) {
      List<?> dataList = (List<?>) value;
      if ((!dataList.isEmpty() && dataList.get(0) instanceof String)
          || (dataList.get(0) instanceof Integer)
          || (dataList.get(0) instanceof Double)
          || (dataList.get(0) instanceof Boolean)) {
        isOther = false;
      }
    } else {
      if (value instanceof String
          || (value instanceof Integer)
          || (value instanceof Double)
          || (value instanceof Boolean)) {
        isOther = false;
      }
    }

    if (isOther) {
      redisTemplate.opsForValue().set(key, JSONObject.toJSONString(value), time, TimeUnit.SECONDS);
    } else {
      redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }
  }

  @Override
  public void set(String key, Object value) {

    // 非基本类型或者非基本类型得集合
    boolean isOther = true;
    if (value instanceof List) {
      List<?> dataList = (List<?>) value;
      if ((!dataList.isEmpty() && dataList.get(0) instanceof String)
          || (dataList.get(0) instanceof Integer)
          || (dataList.get(0) instanceof Double)
          || (dataList.get(0) instanceof Boolean)) {
        isOther = false;
      }
    } else {
      if (value instanceof String
          || (value instanceof Integer)
          || (value instanceof Double)
          || (value instanceof Boolean)) {
        isOther = false;
      }
    }

    if (isOther) {
      redisTemplate.opsForValue().set(key, JSONObject.toJSONString(value));
    } else {
      redisTemplate.opsForValue().set(key, value);
    }
  }

  @Override
  public <T> T get(String key, Class<T> cls) {
    if (cls.equals(String.class)
        || cls.equals(Integer.class)
        || cls.equals(Double.class)
        || cls.equals(Boolean.class)
        || cls.equals(Float.class)) {
      return (T) redisTemplate.opsForValue().get(key);
    } else {
      return (T) JSONObject.parseObject((String) redisTemplate.opsForValue().get(key), cls);
    }
  }

  @Override
  public <T> List<T> getList(String key, Class<T> cls) {
    if (cls.equals(String.class)
        || cls.equals(Integer.class)
        || cls.equals(Double.class)
        || cls.equals(Boolean.class)
        || cls.equals(Float.class)) {
      return (List<T>) redisTemplate.opsForValue().get(key);
    } else {
      return (List<T>) JSONObject.parseArray((String) redisTemplate.opsForValue().get(key), cls);
    }
  }

  @Override
  public Object get(String key) {
    return redisTemplate.opsForValue().get(key);
  }

  @Override
  public Boolean del(String key) {
    return redisTemplate.delete(key);
  }

  @Override
  public Long del(List<String> keys) {
    return redisTemplate.delete(keys);
  }

  @Override
  public Boolean expire(String key, long time) {
    return redisTemplate.expire(key, time, TimeUnit.SECONDS);
  }

  @Override
  public Long getExpire(String key) {
    return redisTemplate.getExpire(key, TimeUnit.SECONDS);
  }

  @Override
  public Boolean hasKey(String key) {
    return redisTemplate.hasKey(key);
  }

  @Override
  public Long incr(String key, long delta) {
    return redisTemplate.opsForValue().increment(key, delta);
  }

  @Override
  public Long decr(String key, long delta) {
    return redisTemplate.opsForValue().increment(key, -delta);
  }

  @Override
  public Object hGet(String key, String hashKey) {
    return redisTemplate.opsForHash().get(key, hashKey);
  }

  @Override
  public Boolean hSet(String key, String hashKey, Object value, long time) {
    redisTemplate.opsForHash().put(key, hashKey, value);
    return expire(key, time);
  }

  @Override
  public void hSet(String key, String hashKey, Object value) {
    redisTemplate.opsForHash().put(key, hashKey, value);
  }

  @Override
  public Map<Object, Object> hGetAll(String key) {
    return redisTemplate.opsForHash().entries(key);
  }

  @Override
  public Boolean hSetAll(String key, Map<String, Object> map, long time) {
    redisTemplate.opsForHash().putAll(key, map);
    return expire(key, time);
  }

  @Override
  public void hSetAll(String key, Map<String, ?> map) {
    redisTemplate.opsForHash().putAll(key, map);
  }

  @Override
  public void hDel(String key, Object... hashKey) {
    redisTemplate.opsForHash().delete(key, hashKey);
  }

  @Override
  public Boolean hHasKey(String key, String hashKey) {
    return redisTemplate.opsForHash().hasKey(key, hashKey);
  }

  @Override
  public Long hIncr(String key, String hashKey, Long delta) {
    return redisTemplate.opsForHash().increment(key, hashKey, delta);
  }

  @Override
  public Long hDecr(String key, String hashKey, Long delta) {
    return redisTemplate.opsForHash().increment(key, hashKey, -delta);
  }

  @Override
  public Set<Object> sMembers(String key) {
    return redisTemplate.opsForSet().members(key);
  }

  @Override
  public Long sAdd(String key, Object... values) {
    return redisTemplate.opsForSet().add(key, values);
  }

  @Override
  public Long sAdd(String key, long time, Object... values) {
    Long count = redisTemplate.opsForSet().add(key, values);
    expire(key, time);
    return count;
  }

  @Override
  public Boolean sIsMember(String key, Object value) {
    return redisTemplate.opsForSet().isMember(key, value);
  }

  @Override
  public Long sSize(String key) {
    return redisTemplate.opsForSet().size(key);
  }

  @Override
  public Long sRemove(String key, Object... values) {
    return redisTemplate.opsForSet().remove(key, values);
  }

  @Override
  public List<Object> lRange(String key, long start, long end) {
    return redisTemplate.opsForList().range(key, start, end);
  }

  @Override
  public Long lSize(String key) {
    return redisTemplate.opsForList().size(key);
  }

  @Override
  public Object lIndex(String key, long index) {
    return redisTemplate.opsForList().index(key, index);
  }

  @Override
  public Long lPush(String key, Object value) {
    return redisTemplate.opsForList().rightPush(key, value);
  }

  @Override
  public Long lPush(String key, Object value, long time) {
    Long index = redisTemplate.opsForList().rightPush(key, value);
    expire(key, time);
    return index;
  }

  @Override
  public Long lPushAll(String key, Object... values) {
    return redisTemplate.opsForList().rightPushAll(key, values);
  }

  @Override
  public Long lPushAll(String key, Long time, Object... values) {
    Long count = redisTemplate.opsForList().rightPushAll(key, values);
    expire(key, time);
    return count;
  }

  @Override
  public Long lRemove(String key, long count, Object value) {
    return redisTemplate.opsForList().remove(key, count, value);
  }
}
