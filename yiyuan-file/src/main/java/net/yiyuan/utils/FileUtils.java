package net.yiyuan.utils;

import org.apache.tika.Tika;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FileUtils {

  private static final Tika TIKA = new Tika();

  public FileUtils() {}

  public static String detectMimeType(File file) throws IOException {
    return TIKA.detect(file);
  }

  public static String detectMimeType(InputStream inputStream, String name) throws IOException {
    return TIKA.detect(inputStream, name);
  }

  public static String detectMimeType(InputStream inputStream) throws IOException {
    return TIKA.detect(inputStream);
  }

  /**
   * 检查允许的文件MimeType
   *
   * @param mimeType 媒体格式
   * @return 是否允许
   */
  public static boolean checkMimeType(String mimeType) {

    Objects.requireNonNull(mimeType);
    // 允许的文件格式
    List<String> allowedDoc =
        Arrays.asList(
            // pdf
            "application/pdf",
            // word
            "application/msword",
            "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
            // excel
            "application/vnd.ms-excel",
            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
            // 压缩文件  rar格式：application/x-rar-compressed; version=5
            "application/zip",
            "application/x-7z-compressed",
            "application/x-rar-compressed",
            "application/x-zip-compressed",
            // 图片
            "image/",
            // 视频
            "video/",
            // 投标的签名格式
            "application/pkcs7-signature");
    for (String doc : allowedDoc) {
      if (mimeType.startsWith(doc)) {
        return true;
      }
    }
    return false;
  }
}
