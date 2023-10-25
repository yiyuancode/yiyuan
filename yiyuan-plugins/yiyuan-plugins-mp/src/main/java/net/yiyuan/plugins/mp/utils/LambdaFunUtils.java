package net.yiyuan.plugins.mp.utils;

import com.baomidou.mybatisplus.core.toolkit.LambdaUtils;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import net.yiyuan.common.utils.StringUtilsPlus;

import java.util.Arrays;

public class LambdaFunUtils {

  public static <C, F> String getFieldName(SFunction<C, F> fieldFun) {
    // 获取字段得get方法名称
    String methodName = (String) LambdaUtils.extract(fieldFun).getImplMethodName();
    // 去掉 get
    String field = methodName.substring(3);
    // 下划线转驼峰首字母小写
    String fieldName =
        StringUtilsPlus.camelCaseToSnakeCase(
            Character.toLowerCase(field.charAt(0)) + field.substring(1));
    return fieldName;
  }

  public static <C, F> Class<C> getFieldOfClass(SFunction<C, F> fieldFun) {
    return (Class<C>) LambdaUtils.extract(fieldFun).getInstantiatedClass();
  }

  public static <C, F> Class<C> getFieldOfClass(SFunction<C, F>... sFunctions) {
    return (Class<C>) LambdaUtils.extract(Arrays.asList(sFunctions).get(0)).getInstantiatedClass();
  }
}
