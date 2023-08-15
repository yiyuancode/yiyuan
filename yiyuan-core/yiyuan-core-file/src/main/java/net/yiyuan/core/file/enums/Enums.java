package net.yiyuan.core.file.enums;

import lombok.SneakyThrows;
import net.yiyuan.core.file.exception.CustomUnifiedException;
import net.yiyuan.core.file.utils.KeyValue;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

/**
 * 枚举操作类（处于基准目录下的Enum）
 *
 * @author CPYF-Yi Mao
 * @date 2019-04-26
 */
public class Enums {

  /**
   * Value键获取Enum
   *
   * @param cls Enum类
   * @param value value键值
   * @param <T> Enum
   * @return Enum类实例
   * @throws CustomUnifiedException 不存在将抛出异常
   */
  public static <T extends Enum<T>> T getByValue(Class<T> cls, Object value) {
    return getByKeyValue(cls, KeyValue.of("value", value));
  }

  /**
   * 键值获取Enum
   *
   * @param cls Enum类
   * @param kv 键值
   * @param <T> Enum
   * @return Enum类实例
   * @throws CustomUnifiedException 不存在将抛出异常
   */
  @SneakyThrows
  public static <T extends Enum<T>> T getByKeyValue(Class<T> cls, KeyValue<String, ?> kv) {
    PropertyDescriptor propertyDescriptor = BeanUtils.getPropertyDescriptor(cls, kv.getKey());
    if (propertyDescriptor != null) {
      for (T one : EnumUtils.getEnumList(cls)) {
        Method readMethod = propertyDescriptor.getReadMethod();
        Object value = readMethod.invoke(one);
        if (kv.getValue().equals(value)) {
          return one;
        }
      }
    }
    throw CustomUnifiedException.aom(
        String.format("Enum类：%s 不存在指定键值 | %s", cls.getSimpleName(), kv));
  }

  /**
   * Value键获取Enum，可以获取为空的结果
   *
   * @param cls Enum类
   * @param value value键值
   * @param <T> Enum
   * @return Optional<T>
   */
  public static <T extends Enum<T>> Optional<T> getOptionalByValue(Class<T> cls, Object value) {
    return getOptionalByKeyValue(cls, KeyValue.of("value", value));
  }

  /**
   * 键值获取Enum，可以获取为空的结果
   *
   * @param cls Enum类
   * @param kv 键值
   * @param <T> Enum
   * @return Optional<T>
   */
  @SneakyThrows
  public static <T extends Enum<T>> Optional<T> getOptionalByKeyValue(
      Class<T> cls, KeyValue<String, ?> kv) {
    PropertyDescriptor propertyDescriptor = BeanUtils.getPropertyDescriptor(cls, kv.getKey());
    if (propertyDescriptor != null) {
      for (T one : EnumUtils.getEnumList(cls)) {
        Method readMethod = propertyDescriptor.getReadMethod();
        Object value = readMethod.invoke(one);
        if (kv.getValue().equals(value)) {
          return Optional.ofNullable(one);
        }
      }
    }
    return Optional.empty();
  }

  /**
   * 获取Enum集合
   *
   * @param cls Enum类
   * @param <T> Enum
   * @return Enum集合
   */
  public static <T extends Enum<T>> List<T> getEnums(Class<T> cls) {
    return EnumUtils.getEnumList(cls);
  }
}
