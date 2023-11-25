package net.yiyuan.plugins.mp.config;

import com.baomidou.mybatisplus.annotation.IEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串枚举代码转换器工厂 编码 -> 枚举 转化器工厂类 解决get请求参数的映射
 *
 * @author 一源团队-花和尚
 * @date 2023/07/13
 */
public class StringCodeToEnumConverterFactory implements ConverterFactory<String, IEnum> {
  private static final Map<Class, Converter> CONVERTERS = new HashMap<>();

  public static <T extends IEnum<?>> T getEnum(Class<T> targetType, String source) {
    for (T constant : targetType.getEnumConstants()) {
      if (source.equals(String.valueOf(constant.getValue()))) {
        return constant;
      }
    }
    return null;
  }

  /**
   * 获取一个从 String 转化为 T 的转换器，T 是一个泛型，有多个实现
   *
   * @param targetType 转换后的类型
   * @return 返回一个转化器
   */
  @Override
  public <T extends IEnum> Converter<String, T> getConverter(Class<T> targetType) {
    Converter<String, T> converter = CONVERTERS.get(targetType);
    if (converter == null) {
      converter = new StringToEnumConverter<>(targetType);
      CONVERTERS.put(targetType, converter);
    }
    return converter;
  }

  public static class StringToEnum<T extends IEnum<?>> implements Converter<String, T> {

    private final Class<T> targetType;

    public StringToEnum(Class<T> targetType) {
      this.targetType = targetType;
    }

    @Override
    public T convert(String source) {
      if (!StringUtils.hasText(source)) {
        return null;
      }
      return (T) StringCodeToEnumConverterFactory.getEnum(this.targetType, source);
    }
  }
}
