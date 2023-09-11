package net.yiyuan.pojo;





import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 短信验证码缓存
 */
@Slf4j
public final class SmsCodeCache {
  /**
   * 单例
   */
  private static SmsCodeCache smsCodeCache = new SmsCodeCache();
  /**
   * 所有有效的权限集合
   */
  private static Map<String, SmsCode> codeMap = new ConcurrentHashMap<>(16);

  private SmsCodeCache() {
  }

  /**
   * 获取实例
   *
   * @return AuthCache
   */
  public static SmsCodeCache getInstance() {
    return smsCodeCache;
  }

  /**
   * 向缓存中添加验证码
   *
   * @param key
   * @param code
   */
  public void add(String key, SmsCode code) {
    cleanExpireAndOld(code.getPhone());
    codeMap.put(key, code);
  }

  /**
   * 从缓存删除验证码
   *
   * @param key
   */
  public void remove(String key) {
    codeMap.remove(key);
  }

  /**
   * 从缓存中获取验证码
   *
   * @param key
   * @return
   */
  public SmsCode get(String key) {
    clean();
    SmsCode code = codeMap.get(key);
    return code;
  }

  /**
   * 清理过期验证码
   */
  public void clean() {
    if (codeMap.isEmpty()) {
      return;
    }

    long nowTime = System.currentTimeMillis();
    for (Map.Entry<String, SmsCode> entry : codeMap.entrySet()) {
      SmsCode smsCode = entry.getValue();
      // 清理过期验证码
      if (smsCode.getExpirationTime() < nowTime) {
        codeMap.remove(entry.getKey());
        log.warn("短信验证码超时处理：{}", smsCode);
      }
    }
  }

  /**
   * 清理过期验证码及旧验证码
   */
  public void cleanExpireAndOld(String phone) {
    if (codeMap.isEmpty()) {
      return;
    }

    long nowTime = System.currentTimeMillis();
    for (Map.Entry<String, SmsCode> entry : codeMap.entrySet()) {
      SmsCode smsCode = entry.getValue();
      // 清理过期验证码及旧验证码
      if (smsCode.getExpirationTime() < nowTime || smsCode.getPhone().equals(phone)) {
        codeMap.remove(entry.getKey());
        log.warn("过期短信验证码及旧验证码处理：{}", smsCode);
      }
    }
  }
}
