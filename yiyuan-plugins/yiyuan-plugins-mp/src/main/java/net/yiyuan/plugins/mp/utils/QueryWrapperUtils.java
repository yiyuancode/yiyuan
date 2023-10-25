package net.yiyuan.plugins.mp.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.StringUtilsPlus;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Slf4j
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

  /**
   * 根据前端传递的参数构建 QueryWrapper 条件
   *
   * @param wrapper 数据库实体类对象
   * @param sFunctions 实际的数据库实体类类型
   * @param <T> 抽象的DTO类泛型
   * @param <E> 实际的数据库实体类泛型
   * @return QueryWrapper 条件
   */
  public static <T, E> void eq(
      JoinLambdaWrapper wrapper, T obj, SFunction<T, Object>... sFunctions) {
    Arrays.stream(sFunctions)
        .forEach(
            sFunction -> {
              Object apply = sFunction.apply(obj);
              wrapper.eq(
                  apply instanceof String
                      ? StringUtilsPlus.isNotEmpty((String) apply)
                      : StringUtilsPlus.isNotNUll(apply),
                  sFunction,
                  apply);
            });
  }

  /**
   * 根据前端传递的参数构建 QueryWrapper 条件
   *
   * @param wrapper 数据库实体类对象
   * @param sFunctions 实际的数据库实体类类型
   * @param <T> 抽象的DTO类泛型
   * @param <E> 实际的数据库实体类泛型
   * @return QueryWrapper 条件
   */
  public static <T, D, E> void resetLikeRight(
      JoinLambdaWrapper wrapper, D obj, SFunction<D, Object>... sFunctions) throws Exception {
    QueryWrapper<?> queryWrapper = new QueryWrapper<>();
    Arrays.stream(sFunctions)
        .forEach(
            sFunction -> {
              Object apply = sFunction.apply(obj);
              queryWrapper.likeRight(
                  apply instanceof String
                      ? StringUtilsPlus.isNotEmpty((String) apply)
                      : StringUtilsPlus.isNotNUll(apply),
                  LambdaFunUtils.getFieldName(sFunction),
                  apply);
              if (apply instanceof String
                  ? StringUtilsPlus.isNotEmpty((String) apply)
                  : StringUtilsPlus.isNotNUll(apply)) {
                // 获取 set 方法的名称
                String methodName =
                    "set" + StringUtilsPlus.upCapitalize(LambdaFunUtils.getFieldName(sFunction));
                log.info("methodName{}", methodName);
                // 获取 sFunction 的 Class 对象
                //              Class<?> sFunctionClass = sFunction.getClass();
                Class<D> fieldOfClass = LambdaFunUtils.getFieldOfClass(sFunction);
                log.info("fieldOfClass{}", fieldOfClass);
                Class<?> aClass = apply.getClass();
                // 获取 set 方法对象
                try {
                  Method setMethod = fieldOfClass.getMethod(methodName, aClass);

                  Object defaultValue = null;
                  // 反射不能直接传null，要用临时变量分封装
                  //                  setMethod.invoke(obj, null);
                  setMethod.invoke(obj, defaultValue);
                } catch (Exception e) {
                  e.printStackTrace();
                }
                // 调用 set 方法，传递 obj 作为参数
                //              setMethod.invoke(sFunction, obj);
              }
            });
    wrapper.changeQueryWrapper(queryWrapper);
  }

  /**
   * 根据前端传递的参数构建 QueryWrapper 条件
   *
   * @param wrapper 数据库实体类对象
   * @param sFunctions 实际的数据库实体类类型
   * @param <T> 抽象的DTO类泛型
   * @param <E> 实际的数据库实体类泛型
   * @return QueryWrapper 条件
   */
  public static <T, E> void resetLike(
      JoinLambdaWrapper wrapper, T obj, SFunction<T, Object>... sFunctions) throws Exception {
    Arrays.stream(sFunctions)
        .forEach(
            sFunction -> {
              Object apply = sFunction.apply(obj);
              wrapper.like(
                  apply instanceof String
                      ? StringUtilsPlus.isNotEmpty((String) apply)
                      : StringUtilsPlus.isNotNUll(apply),
                  sFunction,
                  apply);
              if (apply instanceof String
                  ? StringUtilsPlus.isNotEmpty((String) apply)
                  : StringUtilsPlus.isNotNUll(apply)) {
                // 获取 set 方法的名称
                String methodName =
                    "set" + StringUtilsPlus.upCapitalize(LambdaFunUtils.getFieldName(sFunction));
                // 获取 sFunction 的 Class 对象
                Class<T> fieldOfClass = LambdaFunUtils.getFieldOfClass(sFunction);
                Class<?> aClass = apply.getClass();
                // 获取 set 方法对象
                try {
                  Method setMethod = fieldOfClass.getMethod(methodName, aClass);
                  Object defaultValue = null;
                  // 反射不能直接传null，要用临时变量分封装
                  //                  setMethod.invoke(obj, null);
                  setMethod.invoke(obj, defaultValue);
                } catch (Exception e) {
                  e.printStackTrace();
                }
                // 调用 set 方法，传递 obj 作为参数
                //              setMethod.invoke(sFunction, obj);
              }
            });
  }

  /**
   * 根据前端传递的参数构建 QueryWrapper 条件
   *
   * @param wrapper 数据库实体类对象
   * @param sFunctions 实际的数据库实体类类型
   * @param <T> 抽象的DTO类泛型
   * @param <E> 实际的数据库实体类泛型
   * @return QueryWrapper 条件
   */
  public static <T, D, E> void resetBetween(
      JoinLambdaWrapper wrapper, D obj, List<SFunction<D, Object>>... sFunctions) throws Exception {
    QueryWrapper<?> queryWrapper = new QueryWrapper<>();
    Arrays.stream(sFunctions)
        .forEach(
            sFunction -> {
              SFunction<D, Object> sFunctionStart = sFunction.get(0);
              SFunction<D, Object> sFunctionEnd = sFunction.get(1);
              Object applyStart = sFunctionStart.apply(obj);
              Object applyEnd = sFunctionEnd.apply(obj);
              String column = LambdaFunUtils.getFieldName(sFunctionStart).replace("_start", "");
              if (applyStart instanceof String
                  ? StringUtilsPlus.isNotEmpty((String) applyStart)
                  : StringUtilsPlus.isNotNUll(applyStart) && applyEnd instanceof String
                      ? StringUtilsPlus.isNotEmpty((String) applyEnd)
                      : StringUtilsPlus.isNotNUll(applyEnd)) {
                queryWrapper.between(column, applyStart, applyEnd);

                // 获取 set 方法的名称
                String methodNameStart =
                    "set"
                        + StringUtilsPlus.upCapitalize(LambdaFunUtils.getFieldName(sFunctionStart));
                String methodNameEnd =
                    "set" + StringUtilsPlus.upCapitalize(LambdaFunUtils.getFieldName(sFunctionEnd));
                // 获取 sFunction 的 Class 对象
                Class<D> fieldOfClass = LambdaFunUtils.getFieldOfClass(sFunctionStart);
                Class<?> aClass = applyStart.getClass();
                // 获取 set 方法对象
                try {
                  Method setMethodStart = fieldOfClass.getMethod(methodNameStart, aClass);
                  Object defaultValue = null;
                  // 反射不能直接传null，要用临时变量分封装
                  //                  setMethod.invoke(obj, null);
                  setMethodStart.invoke(obj, defaultValue);
                  Method setMethodEnd = fieldOfClass.getMethod(methodNameEnd, aClass);
                  setMethodEnd.invoke(obj, defaultValue);
                } catch (Exception e) {
                  e.printStackTrace();
                }
              }
            });
    wrapper.changeQueryWrapper(queryWrapper);
  }
}
