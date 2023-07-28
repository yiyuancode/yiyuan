package net.yiyuan.core.sys.utils;


import net.yiyuan.core.sys.config.BaseJob;

public class JobUtil {
  /**
   * 根据全类名获取Job实例
   *
   * @param classname Job全类名
   * @return {@link BaseJob} 实例
   * @throws Exception 泛型获取异常
   */
  public static BaseJob getClass(String classname) throws Exception {
    Class<?> clazz = Class.forName(classname);
    return (BaseJob) clazz.newInstance();
  }
}
