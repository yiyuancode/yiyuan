package net.yiyuan.plugins.mp.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.yiyuan.common.utils.StringUtilsPlus;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

public class QueryWrapperUtils {

  /**
   * 根据前端传递的参数构建 QueryWrapper 条件
   *
   * @param request 数据库实体类对象
   * @param entityClass 实际的数据库实体类类型
   * @param <T> 抽象的DTO类泛型
   * @param <E> 实际的数据库实体类泛型
   * @return QueryWrapper 条件
   */
  public static <T, E> QueryWrapper<E> buildQueryWrapper(T request, E entityClass) {
    QueryWrapper<E> queryWrapper = new QueryWrapper<>();
    queryWrapper.setEntity(entityClass);
    Field[] fields = request.getClass().getDeclaredFields();
    for (Field field : fields) {
      String fieldName = field.getName();
      if (StringUtils.equalsAnyIgnoreCase(fieldName, "serialVersionUID")) {
        continue;
      }
      try {
        field.setAccessible(true);
        Object value = field.get(request);
        if (value == null) {
          continue;
        }
        //                if (field.isAnnotationPresent(TableField.class) &&
        // field.getAnnotation(TableField.class).exist()) {
        //                    continue;
        //                }
        fieldName = StringUtilsPlus.camelCaseToSnakeCase(fieldName);
        // 根据属性名称后缀自动判断查询方式
        if (fieldName.endsWith("_like")) {
          queryWrapper.like(fieldName.replace("_like", ""), value);
        } else if (fieldName.endsWith("_eq")) {
          queryWrapper.eq(fieldName.replace("_eq", ""), value);
        } else if (fieldName.endsWith("_gte")) {
          queryWrapper.ge(fieldName.replace("_gte", ""), value);
        } else if (fieldName.endsWith("_gt")) {
          queryWrapper.gt(fieldName.replace("_gt", ""), value);
        } else if (fieldName.endsWith("_lte")) {
          queryWrapper.le(fieldName.replace("_lte", ""), value);
        } else if (fieldName.endsWith("_lt")) {
          queryWrapper.lt(fieldName.replace("_lt", ""), value);
        } else {
          queryWrapper.eq(StringUtilsPlus.camelCaseToSnakeCase(fieldName), value);
        }
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }

    return queryWrapper;
  }
}
