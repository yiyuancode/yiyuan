package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 用户管理-国家，枚举类
 *
 * @author 小林同学
 * @date 2023-09-18
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum UmUserCountryEnum implements IEnum<Integer> {

  /**
   * 国家，#0=中国CN|1=OTHER
   *
   * @author 小林同学
   * @date 2023-09-18
   * @see UmUserCountryEnum
   */
  CHINA_CN(0, "中国CN"),
  /**
   * 国家，#0=中国CN|1=OTHER
   *
   * @author 小林同学
   * @date 2023-09-18
   * @see UmUserCountryEnum
   */
  其他(1, "OTHER");

  @EnumValue private final int value;
  private final String desc;

  UmUserCountryEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
