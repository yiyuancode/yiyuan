package net.yiyuan.redis;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.plugins.redis.service.RedisServiceImpl;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SysUserRedisService extends RedisServiceImpl {

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
}
