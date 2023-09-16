package net.yiyuan.pojo;

import javax.mail.internet.MimeMultipart;

public interface BuildMailContent {
  MimeMultipart doBuild() throws Exception;
}
