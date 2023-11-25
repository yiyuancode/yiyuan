package net.yiyuan.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Mailreciever {

  /** 不能为空 接收者邮箱帐号 */
  protected String emails;

  protected String mailTitle;
  /** 非空 */
  protected BuildMailContent mailContent;

  /**
   * 构建接收者信息
   *
   * @param mailTitle 接收者将收到邮件的标题
   * @param mailContent 接收者将收到U件的内容 非空
   * @param emails 接收者的U箱 非空
   */
  public Mailreciever(String mailTitle, BuildMailContent mailContent, String emails) {

    this.mailTitle = mailTitle;
    this.mailContent = mailContent;
    if (emails != null) {
      this.emails = emails;
    }
  }
}
