package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 商品分类管理-分类级别枚举类
 *
 * @author 一源-花和尚
 * @date 2023-10-06
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum PtmProductCategoryLevelEnum implements IEnum<Integer> {

  /**
   * 分类级别#1=一级分类|2=二级分类|3=三级分类
   *
   * @see PtmProductCategoryLevelEnum
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  FIRST_LEVEL_CLASSIFICATION(1, "一级分类"),
  /**
   * 分类级别#1=一级分类|2=二级分类|3=三级分类
   *
   * @see PtmProductCategoryLevelEnum
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  SECONDARY_CLASSIFICATION(2, "二级分类"),
  /**
   * 分类级别#1=一级分类|2=二级分类|3=三级分类
   *
   * @see PtmProductCategoryLevelEnum
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  THIRD_LEVEL_CLASSIFICATION(3, "三级分类");

  @EnumValue private final int value;
  private final String desc;
  PtmProductCategoryLevelEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
