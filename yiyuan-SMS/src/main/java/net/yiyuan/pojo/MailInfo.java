package net.yiyuan.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
public class MailInfo {
  /** 验证码位数 */
  private int number;
  /** 是否包含大小写 */
  private Boolean hasAlphabet;
  /** 邮箱地址 */
  private String email;
  /** 过期时间 */
  private Long time;

  @Tolerate
  public MailInfo() {}
}
