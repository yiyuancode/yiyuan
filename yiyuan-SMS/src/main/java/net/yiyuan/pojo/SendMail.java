package net.yiyuan.pojo;

import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

public class SendMail extends Mailreciever {

  public SendMail(String message, String emails) {
    super(
        message,
        () -> {
          // TODO Auto-generated method stub
          MimeBodyPart text = new MimeBodyPart();
          text.setContent(
              "欢迎使用【一源商城】，您的验证码为" + message + "。（验证码告知他人将可能导致帐号被盗，请勿泄露）",
              "text/html;charset=UTF-8");
          MimeMultipart mm = new MimeMultipart();
          mm.addBodyPart(text);
          return mm;
        },
        emails);
    //    欢迎使用 ${crmeb} 商城：

    //    您本次的验证码是 ${code}
  }
}
