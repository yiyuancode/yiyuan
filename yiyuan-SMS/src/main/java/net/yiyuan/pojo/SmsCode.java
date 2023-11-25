package net.yiyuan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.UUID;

/** 短信验证码 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsCode {
  /** 验证码ID */
  private String codeId;
  /** 验证码 */
  private String code;
  /** 手机号 */
  private String phone;
  /** 创建时间 */
  private LocalDateTime createTime;
  /** 过期时间 */
  private long expirationTime;

  /**
   * 生成验证码
   *
   * @param phone
   * @param fix
   */
  public SmsCode(String phone, int fix) {
    this.codeId = UUID.randomUUID().toString();
    this.code = randomNumber();
    this.phone = phone;
    this.createTime = LocalDateTime.now();
    this.expirationTime = System.currentTimeMillis() + fix * 60 * 1000;
  }

  /**
   * 生成6位随机数
   *
   * @return
   */
  public final String randomNumber() {
    SecureRandom random = new SecureRandom();
    StringBuilder returnValue = new StringBuilder();
    int randomInt = 0;
    for (int i = 0; i < 6; i++) {
      randomInt = random.nextInt(10);
      returnValue.append(randomInt);
    }

    return returnValue.toString();
  }
}
