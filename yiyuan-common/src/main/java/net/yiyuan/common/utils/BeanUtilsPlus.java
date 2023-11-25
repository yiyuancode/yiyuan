package net.yiyuan.common.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class BeanUtilsPlus {
  public static void copy(Object sourceObject, Object targetObject) {
    //    BeanUtil.copyProperties(
    //        sourceObject,
    //        targetObject,
    //        CopyOptions.create().setIgnoreNullValue(true));

    copyPropertiesIgnoreEmpty(sourceObject, targetObject);
  }

  public static <T> T copyByClass(Object sourceObject, Class<T> targetType) {
    try {
      T target = targetType.getDeclaredConstructor().newInstance();
      BeanUtil.copyProperties(
          sourceObject, target, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
      return target;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public static List copyToList(Collection sourceObject, Class cl) {
    List list =
        BeanUtil.copyToList(
            sourceObject, cl, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
    return list;
    //    BeanUtil.copyProperties(
    //        sourceObject,
    //        targetObject,
    //        CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
  }

  public static void copyPropertiesIgnoreEmpty(Object source, Object target) {
    Field[] sourceFields = source.getClass().getDeclaredFields();
    Field[] targetFields = target.getClass().getDeclaredFields();

    for (Field sourceField : sourceFields) {
      String fieldName = sourceField.getName();
      Field targetField = getFieldByName(targetFields, fieldName);

      if (targetField != null) {
        sourceField.setAccessible(true);
        targetField.setAccessible(true);

        try {
          Object value = sourceField.get(source);
          if (isEmptyValue(value)) {
            targetField.set(target, null);
          } else {
            targetField.set(target, value);
          }
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    }
  }

  private static Field getFieldByName(Field[] fields, String fieldName) {
    for (Field field : fields) {
      if (field.getName().equals(fieldName)) {
        return field;
      }
    }
    return null;
  }

  private static boolean isEmptyValue(Object value) {
    if (value == null) {
      return true;
    }
    if (value instanceof String) {
      return ((String) value).isEmpty();
    }
    if (value instanceof Collection) {
      return ((Collection<?>) value).isEmpty();
    }
    if (value.getClass().isArray()) {
      return Array.getLength(value) == 0;
    }
    if (value instanceof Map) {
      return ((Map<?, ?>) value).isEmpty();
    }
    return false;
  }
}
