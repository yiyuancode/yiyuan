package net.yiyuan.redis;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.plugins.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class SysUserRedisService {

  @Autowired private RedisService redisService;

  public static String KEY_SYS_USER_PERMISSION = "sys:user:permissions";
  public static Long EXPIRE_SYS_USER_PERMISSION = 0L;

  public static String KEY_SYS_USER_ROLE = "sys:user:roles";
  public static Long EXPIRE_SYS_USER_ROLE = 0L;

  public static String KEY_SYS_USER_PERMISSION_OBJ_LIST = "sys:user:permissions:obj:list";
  public static Long EXPIRE_SYS_USER_PERMISSION_OBJ_LIST = 0L;

  public static String KEY_SYS_USER_ROLE_OBJ_LIST = "sys:user:role:obj:list";
  public static Long EXPIRE_SYS_USER_ROLE_OBJ_LIST = 0L;

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

  public <T> T get(String key, String keyId, Class<T> cls) {
    String s = (String) redisService.get(key + keyId);
    return (T) JSONObject.parseObject(s, cls);
  }

  public void setList(String key, String keyId, Object data, Long ttl) {
    String s = JSONObject.toJSONString(data);
    if (ttl == 0L) {
      redisService.set(key + keyId, s);
    } else {
      redisService.set(key + keyId, s, ttl);
    }
  }

  public <T> List<T> getList(String key, String keyId, Class<T> cls) {
    String s = (String) redisService.get(key + keyId);
    //    ObjectMapper ob = new ObjectMapper();
    //    ob.convertValue(, )
    //            ob.readValue()
    //    ob.readerForListOf().
    //    FastJsonConfig config = new FastJsonConfig();
    //    config.setSerializerFeatures(SerializerFeature.WriteEnumUsingToString);
    //    builder -> builder.featuresToEnable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
    //    CollectionType listType = ob.getTypeFactory().constructCollectionType(ArrayList.class,
    // cls);

    List<T> list = new ArrayList<>();
    list = JSONObject.parseArray(s, cls);
    //    try {
    //
    //      //      list = ob.readValue(s, listType);
    //    } catch (JsonProcessingException e) {
    //      e.printStackTrace();
    //    }
    //    ob.readValue(s, new TypeReference<List<T>>() {});
    //    ob.readValue();
    return list;
  }

  public void del(String key, String keyId) {
    redisService.del(key + keyId);
  }
}
