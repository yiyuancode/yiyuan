package net.yiyuan.plugins.mp.utils;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import icu.mhb.mybatisplus.plugln.base.mapper.JoinBaseMapper;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import icu.mhb.mybatisplus.plugln.extend.Joins;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.common.utils.StringUtilsPlus;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

@Slf4j
public class CenterJoinUtils<L, C, R, LV> {
  public static ConfigurableApplicationContext context;
  private List<LV> voList;
  private SFunction<L, Object> leftPrimaryKeyField;
  private SFunction<C, Object> centerOfLeftForeignKeyField;
  private SFunction<C, Object> centerOfRightForeignKeyField;
  private SFunction<R, Object> rightPrimaryKeyField;
  private SFunction<LV, Object> lvIdField;
  private BiConsumer<LV, List<R>> leftVoOfRightSetField;
  private Class<L> lClass;
  private Class<C> cClass;
  private Class<R> rClass;
  private Class<LV> lvClass;
  private List<String> poIdList;
  private List<Map> selectMapList;
  private Map<Object, List<Map>> groupedMap;

  public CenterJoinUtils() {}

  public CenterJoinUtils(
      SFunction<L, Object> leftPrimaryKeyField,
      SFunction<C, Object> centerOfLeftForeignKeyField,
      SFunction<C, Object> centerOfRightForeignKeyField,
      SFunction<R, Object> rightPrimaryKeyField,
      List<String> idList) {

    this.poIdList = idList;
    this.setLeftTable(leftPrimaryKeyField);
    this.setCenterTable(centerOfLeftForeignKeyField, centerOfRightForeignKeyField);
    this.setRightTable(rightPrimaryKeyField);
    this.select();
  }

  public CenterJoinUtils(
      SFunction<L, Object> leftPrimaryKeyField,
      SFunction<C, Object> centerOfLeftForeignKeyField,
      SFunction<C, Object> centerOfRightForeignKeyField,
      SFunction<R, Object> rightPrimaryKeyField,
      List<LV> voList,
      SFunction<LV, Object> lvIdField,
      BiConsumer<LV, List<R>> leftVoOfRightSetField) {
    this.setLeftTable(leftPrimaryKeyField);
    this.setCenterTable(centerOfLeftForeignKeyField, centerOfRightForeignKeyField);
    this.setRightTable(rightPrimaryKeyField);
    this.lvIdField = lvIdField;
    this.voList = voList;
    this.leftVoOfRightSetField = leftVoOfRightSetField;

    this.select();
    this.map();
  }

  public CenterJoinUtils(
      SFunction<L, Object> leftPrimaryKeyField,
      SFunction<C, Object> centerOfLeftForeignKeyField,
      SFunction<C, Object> centerOfRightForeignKeyField,
      SFunction<R, Object> rightPrimaryKeyField,
      LV vo,
      SFunction<LV, Object> lvIdField,
      BiConsumer<LV, List<R>> leftVoOfRightSetField) {
    this.setLeftTable(leftPrimaryKeyField);
    this.setCenterTable(centerOfLeftForeignKeyField, centerOfRightForeignKeyField);
    this.setRightTable(rightPrimaryKeyField);
    this.lvIdField = lvIdField;
    this.voList = new ArrayList<>();
    voList.add(vo);
    this.leftVoOfRightSetField = leftVoOfRightSetField;

    this.select();
    this.map();
  }

  /**
   * 链式调用-1-实例化
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  public static <L, C, R, LV> CenterJoinUtils<L, C, R, LV> of() {
    return new CenterJoinUtils<>();
  }

  public JoinBaseMapper getMapper(Class<?> cl) throws Exception {
    return (JoinBaseMapper)
        context.getBean(Class.forName("net.yiyuan.mapper." + cl.getSimpleName() + "Mapper"));
  }

  /**
   * 链式调用-2-设置vo相关存取值
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  public CenterJoinUtils<L, C, R, LV> setVoList(
      List<LV> voList,
      SFunction<LV, Object> lvIdField,
      BiConsumer<LV, List<R>> leftVoOfRightSetField) {
    this.voList = voList;
    this.lvIdField = lvIdField;
    this.leftVoOfRightSetField = leftVoOfRightSetField;
    this.poIdList =
        this.voList.stream().map(this.lvIdField).map(Object::toString).collect(Collectors.toList());
    //    this.lvClass = (Class<LV>) LambdaUtils.extract(lvIdField).getInstantiatedClass();
    this.lvClass = LambdaFunUtils.getFieldOfClass(lvIdField);

    return this;
  }

  /**
   * 链式调用-3-设置相关左-中-右相关表，顺序可以对调
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  public CenterJoinUtils<L, C, R, LV> setLeftTable(SFunction<L, Object> leftPrimaryKeyField) {
    this.leftPrimaryKeyField = leftPrimaryKeyField;
    //    this.lClass = (Class<L>)
    // LambdaUtils.extract(this.leftPrimaryKeyField).getInstantiatedClass();
    this.lClass = LambdaFunUtils.getFieldOfClass(this.leftPrimaryKeyField);
    return this;
  }

  public CenterJoinUtils<L, C, R, LV> setCenterTable(
      SFunction<C, Object> centerOfLeftForeignKeyField,
      SFunction<C, Object> centerOfRightForeignKeyField) {
    this.centerOfLeftForeignKeyField = centerOfLeftForeignKeyField;
    this.centerOfRightForeignKeyField = centerOfRightForeignKeyField;
    //    this.cClass =
    //        (Class<C>)
    // LambdaUtils.extract(this.centerOfLeftForeignKeyField).getInstantiatedClass();

    this.cClass = LambdaFunUtils.getFieldOfClass(this.centerOfLeftForeignKeyField);
    return this;
  }

  public CenterJoinUtils<L, C, R, LV> setRightTable(SFunction<R, Object> rightPrimaryKeyField) {
    this.rightPrimaryKeyField = rightPrimaryKeyField;
    //    this.rClass = (Class<R>)
    // LambdaUtils.extract(this.rightPrimaryKeyField).getInstantiatedClass();

    this.rClass = LambdaFunUtils.getFieldOfClass(this.rightPrimaryKeyField);
    return this;
  }

  /**
   * 链式调用-4-连表查询结果缓存
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  public CenterJoinUtils<L, C, R, LV> select() {
    try {
      JoinLambdaWrapper<C> cWrapper = Joins.of(this.cClass);
      if (StringUtilsPlus.isNotEmpty(this.poIdList)) {
        cWrapper.in(this.centerOfLeftForeignKeyField, this.poIdList);
      }
      // 关联查询
      //      cWrapper
      //          .leftJoin(this.lClass, this.leftPrimaryKeyField, this.centerOfLeftForeignKeyField)
      //          .selectAll()
      //          .end();
      cWrapper
          .innerJoin(this.rClass, this.rightPrimaryKeyField, this.centerOfRightForeignKeyField)
          .selectAll()
          .end();
      JoinBaseMapper mapper = getMapper(this.cClass);
      this.selectMapList = mapper.joinSelectList(cWrapper, Map.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return this;
  }

  public CenterJoinUtils<L, C, R, LV> selectForId() {
    try {
      JoinLambdaWrapper<C> cWrapper = Joins.of(this.cClass);
      if (StringUtilsPlus.isNotEmpty(this.poIdList)) {
        cWrapper.in(this.centerOfLeftForeignKeyField, this.poIdList);
      }
      // 关联查询
      //      cWrapper
      //          .leftJoin(this.lClass, this.leftPrimaryKeyField, this.centerOfLeftForeignKeyField)
      //          .selectAll()
      //          .end();
      cWrapper
          .innerJoin(this.rClass, this.rightPrimaryKeyField, this.centerOfRightForeignKeyField)
          .selectAll()
          .end();
      JoinBaseMapper mapper = getMapper(this.cClass);
      this.selectMapList = mapper.joinSelectList(cWrapper, Map.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return this;
  }

  /**
   * 链式调用-5-查询结果根据主表的id进行分组缓存
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  public CenterJoinUtils<L, C, R, LV> map() {
    // 获取左表的id字段
    //    String methodName =
    // LambdaUtils.extract(this.centerOfLeftForeignKeyField).getImplMethodName();
    //    // 去掉 get
    //    String field = methodName.substring(3);
    //    // 下划线转驼峰首字母小写
    //    String fieldName =
    //        StringUtilsPlus.camelCaseToSnakeCase(
    //            Character.toLowerCase(field.charAt(0)) + field.substring(1));
    //    log.info("mapResult.fieldName{}", fieldName);
    //    log.info("mapResult.selectMapList{}", selectMapList);

    String fieldName = LambdaFunUtils.getFieldName(this.centerOfLeftForeignKeyField);
    // 使用中间表的左表id分组来分组
    Map<Object, List<Map>> groupedMap =
        this.selectMapList.stream().collect(Collectors.groupingBy(map -> map.get(fieldName)));
    // 转成json字符串把所有字段下划线转成map
    String groupedMapStr =
        StringUtilsPlus.convertToCamelCaseAndUncapitalize(JSONObject.toJSONString(groupedMap));
    this.groupedMap = JSONObject.parseObject(groupedMapStr, Map.class);
    return this;
  }

  /**
   * 链式调用-6-获取结果,不论初始化传的是对象还是集合，都是浅拷贝，改变源对象，不用返回值
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  public void mapResult() {
    this.voList.stream()
        .forEach(
            master -> {
              this.leftVoOfRightSetField.accept(
                  master,
                  BeanUtilsPlus.copyToList(
                      this.groupedMap.get(this.lvIdField.apply(master)), this.rClass));
            });
  }

  /**
   * 获取voList的任意字段值集合
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  public <F> List<F> getLeftAnyFieldList(SFunction<LV, F> anyField) throws Exception {
    List<F> leftTableGetFieldList =
        (List<F>) this.voList.stream().map(anyField).distinct().collect(Collectors.toList());
    return leftTableGetFieldList;
  }

  /**
   * 获取vo关联的表任意字段值集合
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  public <F> List<F> getRightAnyFieldList(SFunction<R, F> anyField) throws Exception {
    //    // 获取左表的id字段
    //    String methodName = LambdaUtils.extract(anyField).getImplMethodName();
    //    // 去掉 get
    //    String field = methodName.substring(3);
    //    // 下划线转驼峰首字母小写
    //    String fieldName =
    //        StringUtilsPlus.camelCaseToSnakeCase(
    //            Character.toLowerCase(field.charAt(0)) + field.substring(1));

    String fieldName = LambdaFunUtils.getFieldName(anyField);

    List<F> leftTableGetFieldList =
        (List<F>)
            this.selectMapList.stream()
                .map((map) -> map.get(fieldName))
                .distinct()
                .collect(Collectors.toList());
    return leftTableGetFieldList;
  }

  /**
   * 获取vo关联的表任意字段值集合
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  public List<R> getRighList() throws Exception {
    List<R> list = BeanUtilsPlus.copyToList(this.selectMapList, this.rClass);
    return list;
  }
}
