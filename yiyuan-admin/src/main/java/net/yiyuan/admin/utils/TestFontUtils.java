package net.yiyuan.admin.utils;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.admin.redis.AdminRedisService;
import net.yiyuan.common.config.MinIoConfigProperties;
import net.yiyuan.service.FileInfoService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Component
public class TestFontUtils {
  @Resource private FileInfoService fileInfoService;
  @Resource private AdminRedisService adminRedisService;
  @Resource private MinIoConfigProperties minIoConfigProperties;

  public Map<String, String> testFontUtilsForYouShe(String content) throws Exception {
    //    String content = "猜你喜欢 主编力荐 限时 精选 品质 热门推荐 新书 包括完本 全部 连载";
    String contentRedisStr = adminRedisService.GET_ADMIN_FONT_TTF("ttf");
    contentRedisStr = content + contentRedisStr;
    content = getZHAndRemoveDuplicates(contentRedisStr);
    adminRedisService.SET_ADMIN_FONT_TTF("ttf", content);
    content = content.replaceAll("\\s*", "");
    log.info("所有结果去重以后的追加结果{}", content.length());
    log.info("redis老文字结果{}", contentRedisStr.length());
    File toolFile = ResourceUtils.getFile("classpath:lib/sfnttool.jar");
    File fontFile = ResourceUtils.getFile("classpath:font/YouShe.ttf");
    // jar文件的绝对路径
    String jarAbsolutePath = toolFile.getAbsolutePath();
    // 字体库文件的绝对路径
    String fontAbsolutePath = fontFile.getAbsolutePath();
    // 目标目录
    String target = fontAbsolutePath.replace("YouShe.ttf", "YouShe2.ttf");
    // java -jar sfnttool.jar -s '这是一段测试文字' msyh.ttf msyh_simplify.ttf
    String params = " java -jar %s -s '%s' %s %s ";
    String command = String.format(params, jarAbsolutePath, content, fontAbsolutePath, target);
    log.info("执行命令 command = {} ", command);
    Process exec;
    try {
      exec = Runtime.getRuntime().exec(command);
      // 当前线程等待 0表示正常终止
      int i = exec.waitFor();
      // 如果为0 可以直接后端上传miniIO
      MultipartFile multipartFile = getMultipartFile(new File(target));
      String uploadAsTempPath = fileInfoService.uploadAsTemp(multipartFile);
      Map<String, String> resultMap = new HashMap<>();
      resultMap.put(
          "url", minIoConfigProperties.getEndpoint() + "/default-bucket" + "/" + uploadAsTempPath);
      resultMap.put("fileName", uploadAsTempPath);
      return resultMap;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    } catch (InterruptedException e) {
      e.printStackTrace();
      return null;
    }
  }

  public Map<String, String> testFontUtilsForPingfang(String content) throws Exception {
    //    String content = "猜你喜欢 主编力荐 限时 精选 品质 热门推荐 新书 包括完本 全部 连载";
    String contentRedisStr = adminRedisService.GET_ADMIN_FONT_TTF("ttf");
    contentRedisStr = content + contentRedisStr;
    content = getZHAndRemoveDuplicates(contentRedisStr);
    adminRedisService.SET_ADMIN_FONT_TTF("ttf", content);
    content = content.replaceAll("\\s*", "");
    log.info("所有结果去重以后的追加结果{}", content.length());
    log.info("redis老文字结果{}", contentRedisStr.length());
    File toolFile = ResourceUtils.getFile("classpath:lib/sfnttool.jar");
    File fontFile = ResourceUtils.getFile("classpath:font/AlibabaExtraBold95.ttf");
    // jar文件的绝对路径
    String jarAbsolutePath = toolFile.getAbsolutePath();
    // 字体库文件的绝对路径
    String fontAbsolutePath = fontFile.getAbsolutePath();
    // 目标目录
    String target = fontAbsolutePath.replace("AlibabaExtraBold95.ttf", "AlibabaExtraBold95.ttf");
    // java -jar sfnttool.jar -s '这是一段测试文字' msyh.ttf msyh_simplify.ttf
    String params = " java -jar %s -s '%s' %s %s ";
    String command = String.format(params, jarAbsolutePath, content, fontAbsolutePath, target);
    log.info("执行命令 command = {} ", command);
    Process exec;
    try {
      exec = Runtime.getRuntime().exec(command);
      // 当前线程等待 0表示正常终止
      int i = exec.waitFor();
      // 如果为0 可以直接后端上传miniIO
      MultipartFile multipartFile = getMultipartFile(new File(target));
      String uploadAsTempPath = fileInfoService.uploadAsTemp(multipartFile);
      Map<String, String> resultMap = new HashMap<>();
      resultMap.put(
          "url", minIoConfigProperties.getEndpoint() + "/default-bucket" + "/" + uploadAsTempPath);
      resultMap.put("fileName", uploadAsTempPath);
      return resultMap;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    } catch (InterruptedException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static String test2(String content) throws Exception {
    //    String content = "猜你喜欢 主编力荐 限时 精选 品质 热门推荐 新书 包括完本 全部 连载";
    content = content.replaceAll("\\s*", "");

    File toolFile = ResourceUtils.getFile("classpath:lib/sfnttool.jar");
    File fontFile = ResourceUtils.getFile("classpath:font/PingFangRegular.ttf");
    // jar文件的绝对路径
    String jarAbsolutePath = toolFile.getAbsolutePath();
    // 字体库文件的绝对路径
    String fontAbsolutePath = fontFile.getAbsolutePath();
    // 目标目录
    String target = fontAbsolutePath.replace("PingFangRegular.ttf", "PingFangRegular2.ttf");

    // java -jar sfnttool.jar -s '这是一段测试文字' msyh.ttf msyh_simplify.ttf
    String params = " java -jar %s -s '%s' %s %s ";
    String command = String.format(params, jarAbsolutePath, content, fontAbsolutePath, target);
    log.info("执行命令 command = {} ", command);
    Process exec;
    try {
      exec = Runtime.getRuntime().exec(command);
      // 当前线程等待 0表示正常终止
      int i = exec.waitFor();
      // 如果为0 可以直接后端上传miniIO
      return target;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    } catch (InterruptedException e) {
      e.printStackTrace();
      return null;
    }
  }

  public MultipartFile getMultipartFile(File file) {
    FileItem item =
        new DiskFileItemFactory()
            .createItem("file", MediaType.MULTIPART_FORM_DATA_VALUE, true, file.getName());
    try (InputStream input = new FileInputStream(file);
        OutputStream os = item.getOutputStream()) {
      // 流转移
      IOUtils.copy(input, os);
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid file: " + e, e);
    }

    return new CommonsMultipartFile(item);
  }

  public static void main(String[] args) throws Exception {
    String input = "AAA你023456好你好哈哈呵呵哈哈你好你你好呵呵呵BBB123111456yYaEYYy26";
    String result = removeDuplicates(input);
    String zhAndRemoveDuplicates = getZHAndRemoveDuplicates(input);
    test2(zhAndRemoveDuplicates);
    System.out.println(zhAndRemoveDuplicates);
  }

  public static String removeDuplicates(String input) {
    String regex = "(.)(?=.*\\1)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(input);
    return matcher.replaceAll("");
  }

  public static String getZHAndRemoveDuplicates(String input) {
    // 使用正则表达式匹配中文字符、阿拉伯数字和英文字母大小写的字符
    Pattern pattern = Pattern.compile("[\u4e00-\u9fa5\\p{N}\\p{L}]");
    Matcher matcher = pattern.matcher(input);

    // 使用LinkedHashSet去除重复字符，保留顺序
    Set<String> uniqueCharacters = new LinkedHashSet<>();
    while (matcher.find()) {
      String character = matcher.group();
      uniqueCharacters.add(character);
    }

    // 组合拼接字符为一个字符串
    StringBuilder resultBuilder = new StringBuilder();
    for (String character : uniqueCharacters) {
      resultBuilder.append(character);
    }

    // 打印输出结果
    log.info("取并拼接的中文字符： {} ", resultBuilder.toString());
    return resultBuilder.toString();
  }
}
