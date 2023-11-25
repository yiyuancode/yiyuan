package net.yiyuan.common.utils;

import com.baomidou.mybatisplus.annotation.IEnum;

import java.util.HashMap;
import java.util.Map;

public class EnumUtils {
  public static <T extends IEnum> T getEnumByValue(Integer value, Class<T> enumType)
      throws Exception {

    Map<Integer, T> enumMap = new HashMap<>();
    T[] enums = enumType.getEnumConstants();
    for (T e : enums) {
      System.out.println("enums" + e.getValue());
      enumMap.put((Integer) e.getValue(), e);
    }

    T result = enumMap.get(value);
    if (StringUtilsPlus.isNull(result)) {
      throw new Exception("非法枚举值");
    }
    ;
    return result;
  }
}
