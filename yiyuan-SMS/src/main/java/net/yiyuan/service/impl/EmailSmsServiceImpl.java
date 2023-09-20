package net.yiyuan.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.config.MailConfig;
import net.yiyuan.pojo.MailInfo;
import net.yiyuan.pojo.Mailreciever;
import net.yiyuan.pojo.SendMail;
import net.yiyuan.redis.SmsRedisService;
import net.yiyuan.service.SmsAndEmailService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

@Slf4j
@Service
public class EmailSmsServiceImpl implements SmsAndEmailService {

    @Resource
    private SmsRedisService smsRedisService;

    @Resource
    private MailConfig mailConfig;




    @Override
    public CommonResult<String> verifySms(String phoneOrEmail) throws Exception {

        //构建验证码相关消息
        Boolean hasAlphabet = Boolean.TRUE;
        MailInfo mailInfo = MailInfo.builder().number(6).hasAlphabet(hasAlphabet).email(phoneOrEmail).time(300000L).build();
        String email = this.sendVerifyCode(mailInfo);

        return CommonResult.success(email, "短信发送成功");
    }

    @Override
    public boolean checkSmsCode(String phoneOrEmail, String code) {
        if (StringUtils.isBlank(phoneOrEmail) || StringUtils.isBlank(code)) {
            return false;
        }
        String scode = smsRedisService.GET_EMAIL_PERMISSION(phoneOrEmail);

        return code.equals(scode);
    }





    private Properties buildProperties() {
        // 参数配置
        Properties props = new Properties();
        // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.transport.protocol", "smtp");
        // 发件人的邮箱的SMTP服务器地址
        props.setProperty("mail.smtp.host", mailConfig.getEmailSmtphost());
        // 需要请求认证
        props.setProperty("mail.smtp.auth", "true");
        // 是否采用QQ邮箱
        String smtpqq = "smtp.qq.com";
        if ( mailConfig.getEmailSmtphost() != null &&  mailConfig.getEmailSmtphost().equals(smtpqq)) {
            //如果采用QQU箱服务器发送U件，那么必须设定SSL安全认证端口
            final String smtpPort = "465";
            props.setProperty("mail.smtp.port", smtpPort);
            props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.socketFactory.port", smtpPort);
        }
        return props;
    }

    private MimeMessage buildMail(Session session, Mailreciever mailreciever) throws Exception {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(mailConfig.getEmailAccount(), "", "UTF-8"));
        message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(mailreciever.getEmails()));
        message.setSubject(mailreciever.getMailTitle(), "UTF-8");
        message.setContent(mailreciever.getMailContent().doBuild());
        message.setSentDate(new Date());
        message.saveChanges();
        return message;
    }

    /**
     * 发送U件
     *
     * @param reciver U件接收方
     * @throws Exception 发送消息异常将其抛出
     */
    public void sendMail(Mailreciever reciver) throws Exception {
        //构建U件配置文件
        Properties props = this.buildProperties();
        //创建会话对象用于和U箱服务器进行交互
        Session session = Session.getDefaultInstance(props);
        //创建邮件
        MimeMessage message = this.buildMail(session, reciver);
        //传输、校验、关闭
        Transport transport = session.getTransport();
        transport.connect(mailConfig.getEmailAccount(), mailConfig.getEmailPassword());
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    /**
     * 发送邮箱验证码
     *
     * @param info 邮箱验证码ID
     */
    public String sendVerifyCode(MailInfo info) throws Exception {
        String code = this.getMailSendCode(info.getNumber(), info.getHasAlphabet());
        this.sendMail(new SendMail(code, info.getEmail()));
        String mailId = UUID.randomUUID().toString();
        //验证码存入缓存
        //用redis处理缓存
        smsRedisService.DEL_EMAIL_PERMISSION(info.getEmail());
        smsRedisService.SET_EMAIL_PERMISSION(info.getEmail(),code);
        return code;
    }

    public String getMailSendCode(int number, boolean hasAlphabet) {
        int i = 1234567890;
        String numbers = String.valueOf(i);
        String words = "";
        if (hasAlphabet) {
            //所有英文字母
            words = "qwertyuiopasdfghjklzxcvbnm";
        }
        char[] c1 = numbers.toCharArray();
        char[] c2 = words.toCharArray();
        Random rd = new SecureRandom();
        StringBuilder code = new StringBuilder();
        for (int k = 0; k < number; k++) {
            if (k % 2 == 0) {
                //随机获取数组长度作为索引
                int index = rd.nextInt(c1.length);
                //循环添加到字符串后面
                code.append(c1[index]);
            } else {
                int index = rd.nextInt(c2.length);
                code.append(c2[index]);
            }
        }
        return code.toString();
    }

}
