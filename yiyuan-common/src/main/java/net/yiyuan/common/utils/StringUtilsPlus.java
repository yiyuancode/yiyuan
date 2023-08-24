package net.yiyuan.common.utils;

import org.apache.commons.lang3.text.StrBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Map;

/** 字符串工具类 */
public class StringUtilsPlus {

  /** 空字符串 */
  private static final String NULLSTR = "";

  /**
   * 获取参数不为空
   *
   * @param value
   * @param defaultValue
   * @param <T>
   * @return
   */
  public static <T> T nvl(T value, T defaultValue) {
    return value != null ? value : defaultValue;
  }

  /**
   * 判断一个对象是否为空
   *
   * @param object
   * @return true为空 false为非空
   */
  public static boolean isNull(Object object) {
    return object == null;
  }

  /**
   * 判断一个对象为非空
   *
   * @param object
   * @return true:空 false：非空
   */
  public static boolean isNotNUll(Object object) {
    return !isNull(object);
  }

  /**
   * 判断一个Collection是否为空，包含List,Set,Queue
   *
   * @param coll
   * @return true:为空,false：非空
   */
  public static boolean isEmpty(Collection<?> coll) {
    return isNull(coll) || coll.isEmpty();
  }

  /**
   * 判断一个Collection是否非空
   *
   * @param coll
   * @return true:非空 false：空
   */
  public static boolean isNotEmpty(Collection<?> coll) {
    return !isEmpty(coll);
  }

  /**
   * 判断一个对象数组是否为空
   *
   * @param objects
   * @return true:为空,false：非空
   */
  public static boolean isEmpty(Object[] objects) {
    return isNull(objects) || objects.length == 0;
  }

  /**
   * 判断一个对象数组为非空
   *
   * @param objects
   * @return true:非空 false：空
   */
  public static boolean isNotEmpty(Object[] objects) {
    return !isEmpty(objects);
  }

  /**
   * 判断一个Map 是否为空
   *
   * @param map
   * @return rue:为空,false：非空
   */
  public static boolean isEmpty(Map<?, ?> map) {
    return isNull(map) || map.isEmpty();
  }

  /**
   * 判断一个Map是否非空
   *
   * @param map
   * @return true:非空 false：空
   */
  public static boolean isNotEmpty(Map<?, ?> map) {
    return !isEmpty(map);
  }

  /**
   * 判断一个字符串是否为空
   *
   * @param str
   * @return true:非空 false：空
   */
  public static boolean isEmpty(String str) {
    return isNull(str) || NULLSTR.equals(str.trim());
  }

  /**
   * 判断一个字符串为非空
   *
   * @param str
   * @return true：非空 false：空
   */
  public static boolean isNotEmpty(String str) {
    return !isEmpty(str);
  }

  /**
   * 判断一个对象是否是数组类型
   *
   * @param object
   * @return true：是数组 false：不是数组
   */
  public static boolean isArray(Object object) {
    return isNotNUll(object) && object.getClass().isArray();
  }

  /**
   * 去字符串头尾空格
   *
   * @param str
   * @return
   */
  public static String trim(String str) {
    return str == null ? "" : str.trim();
  }

  /**
   * 截取字符串
   *
   * @param str
   * @param start
   * @param end
   * @return
   */
  public static String substring(final String str, int start, int end) {
    if (str == null) {
      return NULLSTR;
    }
    if (end < 0) {
      end = str.length() + end;
    }
    if (start < 0) {
      start = str.length() + start;
    }
    if (end > str.length()) {
      end = str.length();
    }
    if (start > end) {
      return NULLSTR;
    }
    if (start < 0) {
      start = 0;
    }
    if (end < 0) {
      end = 0;
    }
    return str.substring(start, end);
  }

  /**
   * 字符串首字母小写
   *
   * @param str
   * @return
   */
  public static String uncapitalize(String str) {
    int strLen;
    if (str == null || (strLen = str.length()) == 0) {
      return str;
    }
    return new StrBuilder(strLen)
        .append(Character.toLowerCase(str.charAt(0)))
        .append(str.substring(1))
        .toString();
  }

  /**
   * 判断是否包含字符串
   *
   * @param str
   * @param strs
   * @return
   */
  public static boolean inStringIgnoreCase(String str, String... strs) {
    if (str != null && strs != null) {
      for (String s : strs) {
        if (str.equalsIgnoreCase(trim(s))) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * 将驼峰字符串转换为 Java 小写下划线的形式
   *
   * @param camelCaseString 驼峰字符串
   * @return Java 小写下划线形式的字符串
   */
  public static String camelCaseToSnakeCase(String camelCaseString) {
    if (camelCaseString == null || camelCaseString.isEmpty()) {
      return camelCaseString;
    }
    StringBuilder result = new StringBuilder();
    result.append(Character.toLowerCase(camelCaseString.charAt(0)));
    for (int i = 1; i < camelCaseString.length(); i++) {
      char ch = camelCaseString.charAt(i);
      if (Character.isUpperCase(ch)) {
        if (i > 1 && Character.isLowerCase(camelCaseString.charAt(i - 1))) {
          result.append("_");
        }
        result.append(Character.toLowerCase(ch));
      } else {
        result.append(ch);
      }
    }
    return result.toString();
  }

  /**
   * 将带下划线的字符串转换为驼峰形式 如 hello_world -> HelloWorld,HELLO_WORLD -> HelloWorld
   *
   * @param name
   * @return
   */
  public static String convertToCamelCase(String name) {
    StringBuilder result = new StringBuilder();
    // 如果字符串为空，没必要转换
    if (name == null || isEmpty(name)) {
      return "";
      // 如果字符串不包含下划线，仅首字母大写
    } else if (!name.contains("_")) {
      return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    // 使用“_”分割字符串
    String[] camels = name.split("_");
    for (String camel : camels) {
      // 跳过字符串开头中间结尾的下划线，以及双下划线
      if (camel.isEmpty()) {
        continue;
      }
      // 首字母大写
      result.append(camel.substring(0, 1).toUpperCase());
      result.append(camel.substring(1).toLowerCase());
    }
    return result.toString();
  }

  /**
   * 将带下划线的字符串转换为驼峰形式 如 hello_world -> HelloWorld,HELLO_WORLD -> HelloWorld,并且将首字母小写
   *
   * @param name
   * @return
   */
  public static String convertToCamelCaseAndUncapitalize(String name) {
    return uncapitalize(convertToCamelCase(name));
  }

  /**
   * 字符串数据处理
   *
   * @param value
   * @return
   */
  public static String valueAsStr(Object value) {
    if (value instanceof String) {
      return (String) value;
    }
    if (value != null) {
      return value.toString();
    } else {
      return null;
    }
  }

  /** 整型数据处理 */
  public static Integer valueAsInt(Object value) {
    if (value instanceof Integer) {
      return (Integer) value;
    } else if (value instanceof Number) {
      return ((Number) value).intValue();
    } else if (value instanceof String) {
      if ("NaN".equals(value)) {
        return null;
      }
      return Integer.valueOf((String) value);
    } else if (value instanceof Boolean) {
      return ((Boolean) value) ? 1 : 0;
    } else {
      return null;
    }
  }

  /**
   * 将输入字符串去掉头尾空格，将中间空格用下划线分割，并转换为小写
   *
   * @param input 待处理的字符串
   * @return 处理后的字符串
   */
  public static String trimAndFormatString(String input) {
    // 去掉头尾空格
    String trimmed = input.trim();
    // 将中间的空格用下划线分割
    String replaced = trimmed.replaceAll(" ", "_");
    // 转换为小写
    String lowercased = replaced.toLowerCase();
    return lowercased;
  }

  /**
   * 将Java包名转换为文件系统路径格式
   *
   * @param packageName 待转换的Java包名
   * @return 转换后的文件系统路径
   */
  public static String convertPackageNameToPath(String packageName) {
    String path = packageName.replace(".", "/");
    return path;
  }

  /**
   * 格式化日期时间为指定格式的字符串
   *
   * @param dateTime 要格式化的日期时间
   * @param pattern 日期时间的格式，例如 "yyyy-MM-dd HH:mm:ss"
   * @return 格式化后的字符串
   */
  public static String formatDateTime(LocalDateTime dateTime, String pattern) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    return dateTime.format(formatter);
  }

  /**
   * 将输入字符串转换为大写形式并返回结果字符串。 如果输入字符串为null，则返回null。
   *
   * @param str 输入字符串
   * @return 转换为大写的字符串
   */
  public static String toUpperCase(String str) {
    if (str == null) {
      return null;
    }
    return str.toUpperCase();
  }
  /**
   * 将输入字符串转换为小写形式并返回结果字符串。 如果输入字符串为null，则返回null。
   *
   * @param str 输入字符串
   * @return 转换为大写的字符串
   */
  public static String toLowerCase(String str) {
    if (str == null) {
      return null;
    }
    return str.toLowerCase();
  }
}
