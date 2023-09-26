package net.yiyuan;

import cn.hutool.core.lang.Assert;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerHelper {

  /** DozerMapper */
  private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

  //  @Autowired(required = false)
  //  public void injectMapper(Mapper mapper) {
  //    setMapper(mapper);
  //  }

  /**
   * 获取Mapper
   *
   * @return the mapper
   */
  public static Mapper getMapper() {
    if (mapper == null) {
      mapper = DozerBeanMapperBuilder.buildDefault();
    }
    Assert.notNull(mapper, "DozerMapper isn't inited, DozerHelper is not available");
    return mapper;
  }

  /**
   * 使用source映射给target，复制属性
   *
   * @param source
   * @param target
   * @return
   */
  public static void map(Object source, Object target) {
    getMapper().map(source, target);
  }

  /**
   * 使用source映射给target，复制属性
   *
   * @param source
   * @param target
   * @return
   */
  public static void map(Object source, Object target, String mapId) {
    getMapper().map(source, target, mapId);
  }

  /**
   * 使用source映射给targetClass，自动生成对象并复制属性
   *
   * @param source
   * @param targetClass
   * @return
   */
  public static <T> T map(Object source, Class<T> targetClass) {
    return getMapper().map(source, targetClass);
  }

  /**
   * 把sourceLst映射成targetClass类型的ArrayList返回
   *
   * @param sourceLst
   * @param targetClass
   * @return
   */
  public static <T> List<T> mapList(List sourceLst, Class<T> targetClass) {
    if (sourceLst == null) return null;
    List<T> returnLst = new ArrayList<T>();
    for (Object source : sourceLst) {
      returnLst.add(getMapper().map(source, targetClass));
    }
    return returnLst;
  }

  /**
   * 使用source映射给targetClass，自动生成对象并复制属性
   *
   * @param source
   * @param targetClass
   * @param mapId
   * @return
   */
  public static <T> T map(Object source, Class<T> targetClass, String mapId) {
    return getMapper().map(source, targetClass, mapId);
  }

  /** @param mpr */
  public static void setMapper(Mapper mpr) {
    mapper = mpr;
  }

  /*
   * (non-Javadoc)
   *
   * @see org.springframework.beans.factory.DisposableBean#destroy()
   */
  public void destroy() throws Exception {
    setMapper(null);
  }
}
