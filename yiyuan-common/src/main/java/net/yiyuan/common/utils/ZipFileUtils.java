package net.yiyuan.common.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileUtils {

  /**
   * web下载打成压缩包的文件--流方式
   *
   * @param response 响应
   * @param fileList 文件列表
   * @param zipName 压缩包名
   */
  public static void downloadZipFiles(
      HttpServletResponse response, List<String> fileList, String zipName) {
    ZipOutputStream zipOutputStream = null;
    try {
      // 设置响应头
      response.reset();
      response.setContentType("application/octet-stream");
      response.setCharacterEncoding("utf-8");
      // 设置文件名称
      response.setHeader("Content-Disposition", "attachment;filename=" + zipName);
      zipOutputStream = new ZipOutputStream(response.getOutputStream());
      for (String file : fileList) {
        toZip(zipOutputStream, new File(file));
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    } finally {
      // 关闭资源
      if (null != zipOutputStream) {
        try {
          zipOutputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  /**
   * 压缩文件
   *
   * @param zipOutputStream 压缩文件流
   * @param file 待压缩文件
   */
  private static void toZip(ZipOutputStream zipOutputStream, File file) {
    String filename = file.getName();
    BufferedInputStream bis = null;
    try {
      bis = new BufferedInputStream(Files.newInputStream(file.toPath()));
      // 设置压缩包内文件的名称
      zipOutputStream.putNextEntry(new ZipEntry(filename));
      int size;
      byte[] buffer = new byte[4096];
      while ((size = bis.read(buffer)) > 0) {
        zipOutputStream.write(buffer, 0, size);
      }
      zipOutputStream.closeEntry();
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    } finally {
      // 关闭资源
      if (null != bis) {
        try {
          bis.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
