package net.yiyuan.common.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;

import java.util.Collection;
import java.util.List;

public class BeanUtilsPlus {
  public static void copy(Object sourceObject, Object targetObject) {
    BeanUtil.copyProperties(
        sourceObject,
        targetObject,
        CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
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
}
