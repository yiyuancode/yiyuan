package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 商品分类管理-分类级别枚举类
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum PtmProductCategoryLevelEnum implements IEnum<Integer> {

  /**
   * 分类级别#1=一级分类|2=二级分类|3=三级分类|4=店铺分类
   *
   * @author 一源团队-花和尚
   * @date 2023-10-09
   * @see PtmProductCategoryLevelEnum
   */
  FIRST_LEVEL_CLASSIFICATION(1, "一级分类"),
  /**
   * 分类级别#1=一级分类|2=二级分类|3=三级分类|4=店铺分类
   *
   * @author 一源团队-花和尚
   * @date 2023-10-09
   * @see PtmProductCategoryLevelEnum
   */
  SECONDARY_CLASSIFICATION(2, "二级分类"),
  /**
   * 分类级别#1=一级分类|2=二级分类|3=三级分类|4=店铺分类
   *
   * @author 一源团队-花和尚
   * @date 2023-10-09
   * @see PtmProductCategoryLevelEnum
   */
  THIRD_LEVEL_CLASSIFICATION(3, "三级分类"),

  /**
   * 分类级别#1=一级分类|2=二级分类|3=三级分类|4=店铺分类
   *
   * @author 一源团队-花和尚
   * @date 2023-10-09
   * @see PtmProductCategoryLevelEnum
   */
  FOUR_LEVEL_CLASSIFICATION(4, "店铺分类");

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
