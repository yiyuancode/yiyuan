package net.yiyuan.plugins.mp.config;

import com.baomidou.mybatisplus.annotation.IEnum;
import net.yiyuan.common.constatnt.ResultCode;
import net.yiyuan.common.exception.BusinessException;
import org.springframework.core.convert.converter.Converter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 字符串枚举转换器 枚举编码 -> 枚举 转化器 实现org.springframework.core.convert.converter.Converter类
 *
 * @author 一源团队-花和尚
 * @date 2023/07/13
 */
public class StringToEnumConverter<T extends IEnum> implements Converter<String, T> {
  private Map<String, T> enumMap = new HashMap<>();

  public StringToEnumConverter(Class<T> enumType) {
    T[] enums = enumType.getEnumConstants();
    System.out.println("enums" + enums);
    for (T e : enums) {
      System.out.println("enums" + e.getValue());
      enumMap.put(e.getValue().toString(), e);
    }
  }

  @Override
  public T convert(String source) {

    T t = enumMap.get(source);
    System.out.println("enums" + t);
    if (Objects.isNull(t)) {
      throw new BusinessException(ResultCode.PARAMETER_TO_ENUM_ERROR);
    }
    return t;
  }
}
