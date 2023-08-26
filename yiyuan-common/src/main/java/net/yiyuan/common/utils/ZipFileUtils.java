package net.yiyuan.common.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ZipFileUtils {

  /**
   * web下载打成压缩包的文件--流方式
   *
   * @param response 响应
   */
  public static void downloadZipFiles(HttpServletResponse response, File file) {

    try {
      // 必须声明一下,不然浏览器控制台能看到响应头这个字段,,但是axios去获取不到
      response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
      // 设置响应头
      response.setContentType("application/octet-stream");
      //      response.setContentType("application/force-download");
      response.setCharacterEncoding("utf-8");

      // 设置文件名称
      // response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
      // 设置响应头
      response.setHeader("Content-Disposition", "attachment; filename=" + file.getName() + "");
      //      response.addHeader("Access-Control-Allow-Origin", "*");
      //      response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
      // 读取文件并写入响应流
      try (InputStream inputStream = new FileInputStream(file);
          OutputStream outputStream = response.getOutputStream()) {
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
          outputStream.write(buffer, 0, bytesRead);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    } finally {

    }
  }
}
