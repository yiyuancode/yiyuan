package net.yiyuan.plugins.mp.utils;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.mapper.JoinBaseMapper;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import icu.mhb.mybatisplus.plugln.extend.Joins;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.common.utils.StringUtilsPlus;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

@Slf4j
public class QueryWrapperUtils {
  public static ConfigurableApplicationContext context;

  public static JoinBaseMapper getMapper(Class<?> cl) throws Exception {
    return (JoinBaseMapper)
        context.getBean(Class.forName("net.yiyuan.mapper." + cl.getSimpleName() + "Mapper"));
  }
  /**
   * 重置为右eq查询
   *
   * @param wrapper 数据库实体类对象
   * @param sFunctions 实际的数据库实体类类型
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
   * 为了page分页结果关联查询--省区发送多条sql的烦恼
   *
   * @param page 分页page对象
   * @param lSetRlistBiConsumer page每条数据的set函数
   * @param lIdSFunction page种每条数据id字段
   * @param cIdSFunction page每条数据的id字段在中间表的对应字段
   * @param cSFunction 中间表对应关联查询的表的字段
   * @param rSFunction 关联表id字段
   * @param selectFiledSFunction 需要查询的关联表的字段
   */
  public static <L, C, R> void linksForPage(
      Page<L> page,
      BiConsumer<L, List<R>> lSetRlistBiConsumer,
      SFunction<L, Object> lIdSFunction,
      SFunction<C, Object> cIdSFunction,
      SFunction<C, Object> cSFunction,
      SFunction<R, Object> rSFunction,
      SFunction<R, Object>... selectFiledSFunction)
      throws Exception {
    Class<L> lClass = LambdaFunUtils.getFieldOfClass(lIdSFunction);
    List<String> cIds =
        page.getRecords().stream()
            .map(
                e -> {
                  try {
                    Method getIdMethod = lClass.getMethod("getId");
                    String invoke = (String) getIdMethod.invoke(e);
                    return invoke;
                  } catch (Exception e1) {
                    e1.printStackTrace();
                    return null;
                  }
                })
            .collect(Collectors.toList());
    Class<C> cClass = LambdaFunUtils.getFieldOfClass(cSFunction);
    JoinLambdaWrapper<C> cWrapper = Joins.of(cClass);
    cWrapper.in(cIdSFunction, cIds);
    Class<R> rClass = LambdaFunUtils.getFieldOfClass(rSFunction);
    cWrapper.leftJoin(rClass, rSFunction, cSFunction).select(selectFiledSFunction).end();

    JoinBaseMapper mapper = getMapper(cClass);
    List<Map> maplist = mapper.joinSelectList(cWrapper, Map.class);

    Map<String, List<Map>> groupedMap =
        maplist.stream()
            .collect(
                Collectors.groupingBy(
                    link -> (String) link.get(LambdaFunUtils.getFieldName(cIdSFunction))));

    // 转成json字符串把所有字段下划线转成map
    String groupedMapStr =
        StringUtilsPlus.convertToCamelCaseAndUncapitalize(JSONObject.toJSONString(groupedMap));
    Map<String, List<Map>> finalGroupedMap = JSONObject.parseObject(groupedMapStr, Map.class);
    if (StringUtilsPlus.isNotEmpty(page.getRecords())) {
      page.getRecords()
          .forEach(
              (item) -> {
                Method getIdMethod = null;
                try {
                  getIdMethod = lClass.getMethod("getId");
                  String idVal = (String) getIdMethod.invoke(item);
                  if (StringUtilsPlus.isNotEmpty(idVal)) {
                    lSetRlistBiConsumer.accept(
                        item, BeanUtilsPlus.copyToList(finalGroupedMap.get(idVal), lClass));
                  }
                } catch (Exception e) {
                  e.printStackTrace();
                }
              });
    }
  }

  public static <L, C, R> void linksForDeatil(
      L obj,
      BiConsumer<L, List<R>> lSetRlistBiConsumer,
      SFunction<L, Object> lIdSFunction,
      SFunction<C, Object> cIdSFunction,
      SFunction<C, Object> cSFunction,
      SFunction<R, Object> rSFunction,
      SFunction<R, Object>... selectFiledSFunction)
      throws Exception {
    Class<L> lClass = LambdaFunUtils.getFieldOfClass(lIdSFunction);
    String idVal = (String) lClass.getMethod("getId").invoke(obj);
    List<String> cIds = Arrays.asList(idVal);
    Class<C> cClass = LambdaFunUtils.getFieldOfClass(cSFunction);
    JoinLambdaWrapper<C> cWrapper = Joins.of(cClass);
    cWrapper.in(cIdSFunction, cIds);
    Class<R> rClass = LambdaFunUtils.getFieldOfClass(rSFunction);
    cWrapper.leftJoin(rClass, rSFunction, cSFunction).select(selectFiledSFunction).end();
    JoinBaseMapper mapper = getMapper(cClass);
    List<Map> maplist = mapper.joinSelectList(cWrapper, Map.class);

    Map<String, List<Map>> groupedMap =
        maplist.stream()
            .collect(
                Collectors.groupingBy(
                    link -> (String) link.get(LambdaFunUtils.getFieldName(cIdSFunction))));

    // 转成json字符串把所有字段下划线转成map
    String groupedMapStr =
        StringUtilsPlus.convertToCamelCaseAndUncapitalize(JSONObject.toJSONString(groupedMap));
    Map<String, List<Map>> finalGroupedMap = JSONObject.parseObject(groupedMapStr, Map.class);
    if (StringUtilsPlus.isNotNUll(obj)) {
      lSetRlistBiConsumer.accept(obj, BeanUtilsPlus.copyToList(finalGroupedMap.get(idVal), lClass));
    }
  }

//  /**
//   * 为了page分页结果关联查询--省区发送多条sql的烦恼
//   *
//   * @param page 分页page对象
//   * @param lSetRlistBiConsumer page每条数据的set函数
//   * @param lIdSFunction page种每条数据id字段
//   * @param cIdSFunction page每条数据的id字段在中间表的对应字段
//   * @param cSFunction 中间表对应关联查询的表的字段
//   * @param rSFunction 关联表id字段
//   * @param selectFiledSFunction 需要查询的关联表的字段
//   */
//  public static <L, C, R> List<String> linksIdsForQueryFilter(
//      SFunction<C, Object> cIdSFunction,
//      SFunction<C, Object> cSFunction,
//      SFunction<R, Object> rSFunction,
//      SFunction<R, Object>... selectFiledSFunction)
//      throws Exception {
//    Class<L> lClass = LambdaFunUtils.getFieldOfClass(lIdSFunction);
//    List<String> cIds =
//        page.getRecords().stream()
//            .map(
//                e -> {
//                  try {
//                    Method getIdMethod = lClass.getMethod("getId");
//                    String invoke = (String) getIdMethod.invoke(e);
//                    return invoke;
//                  } catch (Exception e1) {
//                    e1.printStackTrace();
//                    return null;
//                  }
//                })
//            .collect(Collectors.toList());
//    Class<C> cClass = LambdaFunUtils.getFieldOfClass(cSFunction);
//    JoinLambdaWrapper<C> cWrapper = Joins.of(cClass);
//    cWrapper.in(cIdSFunction, cIds);
//    Class<R> rClass = LambdaFunUtils.getFieldOfClass(rSFunction);
//    cWrapper.leftJoin(rClass, rSFunction, cSFunction).select(selectFiledSFunction).end();
//
//    JoinBaseMapper mapper = getMapper(cClass);
//    List<Map> maplist = mapper.joinSelectList(cWrapper, Map.class);
//
//    Map<String, List<Map>> groupedMap =
//        maplist.stream()
//            .collect(
//                Collectors.groupingBy(
//                    link -> (String) link.get(LambdaFunUtils.getFieldName(cIdSFunction))));
//
//    // 转成json字符串把所有字段下划线转成map
//    String groupedMapStr =
//        StringUtilsPlus.convertToCamelCaseAndUncapitalize(JSONObject.toJSONString(groupedMap));
//    Map<String, List<Map>> finalGroupedMap = JSONObject.parseObject(groupedMapStr, Map.class);
//    if (StringUtilsPlus.isNotEmpty(page.getRecords())) {
//      page.getRecords()
//          .forEach(
//              (item) -> {
//                Method getIdMethod = null;
//                try {
//                  getIdMethod = lClass.getMethod("getId");
//                  String idVal = (String) getIdMethod.invoke(item);
//                  if (StringUtilsPlus.isNotEmpty(idVal)) {
//                    lSetRlistBiConsumer.accept(
//                        item, BeanUtilsPlus.copyToList(finalGroupedMap.get(idVal), lClass));
//                  }
//                } catch (Exception e) {
//                  e.printStackTrace();
//                }
//              });
//    }
//  }

  /**
   * 重置为右模糊查询
   *
   * @param wrapper 数据库实体类对象
   * @param sFunctions 实际的数据库实体类类型
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
   * 重置为模糊查询
   *
   * @param wrapper 数据库实体类对象
   * @param sFunctions 实际的数据库实体类类型
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
   * 重置为区间查询
   *
   * @param wrapper 数据库实体类对象
   * @param sFunctions 实际的数据库实体类类型
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

  /**
   * 重置为小于
   *
   * @param wrapper 数据库实体类对象
   * @param sFunctions 实际的数据库实体类类型
   */
  public static <T, E> void resetLt(
      JoinLambdaWrapper wrapper, T obj, SFunction<T, Object>... sFunctions) throws Exception {
    QueryWrapper<?> queryWrapper = new QueryWrapper<>();
    Arrays.stream(sFunctions)
        .forEach(
            sFunction -> {
              String column = LambdaFunUtils.getFieldName(sFunction);
              Object apply = sFunction.apply(obj);
              queryWrapper.lt(
                  apply instanceof String
                      ? StringUtilsPlus.isNotEmpty((String) apply)
                      : StringUtilsPlus.isNotNUll(apply),
                  column,
                  apply instanceof IEnum ? (Integer) ((IEnum) apply).getValue() : apply);
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
    wrapper.changeQueryWrapper(queryWrapper);
  }

  /**
   * 重置为小于等于
   *
   * @param wrapper 数据库实体类对象
   * @param sFunctions 实际的数据库实体类类型
   */
  public static <T, E> void resetLe(
      JoinLambdaWrapper wrapper, T obj, SFunction<T, Object>... sFunctions) throws Exception {
    Arrays.stream(sFunctions)
        .forEach(
            sFunction -> {
              Object apply = sFunction.apply(obj);
              wrapper.le(
                  apply instanceof String
                      ? StringUtilsPlus.isNotEmpty((String) apply)
                      : StringUtilsPlus.isNotNUll(apply),
                  sFunction,
                  apply instanceof IEnum ? (Integer) ((IEnum) apply).getValue() : apply);
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
   * 重置为大于
   *
   * @param wrapper 数据库实体类对象
   * @param sFunctions 实际的数据库实体类类型
   */
  public static <T, E> void resetGt(
      JoinLambdaWrapper wrapper, T obj, SFunction<T, Object>... sFunctions) throws Exception {
    QueryWrapper<?> queryWrapper = new QueryWrapper<>();
    Arrays.stream(sFunctions)
        .forEach(
            sFunction -> {
              String column = LambdaFunUtils.getFieldName(sFunction);
              Object apply = sFunction.apply(obj);
              queryWrapper.gt(
                  apply instanceof String
                      ? StringUtilsPlus.isNotEmpty((String) apply)
                      : StringUtilsPlus.isNotNUll(apply),
                  column,
                  apply instanceof IEnum ? (Integer) ((IEnum) apply).getValue() : apply);
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
    wrapper.changeQueryWrapper(queryWrapper);
  }
}
