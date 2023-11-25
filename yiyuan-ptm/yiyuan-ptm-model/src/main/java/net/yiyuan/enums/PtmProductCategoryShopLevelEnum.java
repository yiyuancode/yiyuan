package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Getter;

/**
 * 店铺商品分类-分类级别枚举类
 *
 * @author 一源团队-花和尚
 * @date 2023-11-19
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
// @JsonFormat(shape = JsonFormat.Shape.OBJECT)  // 实现场景2，只需要加上这个注解
public enum PtmProductCategoryShopLevelEnum implements IEnum<Integer> {

  /**
   * 分类级别#1=一级分类|2=二级分类
   *
   * @see PtmProductCategoryShopLevelEnum
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  FIRST_LEVEL_CLASSIFICATION(1, "一级分类"),
  /**
   * 分类级别#1=一级分类|2=二级分类
   *
   * @see PtmProductCategoryShopLevelEnum
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  访问频率受限(2, "二级分类");

  @EnumValue private final int value;
  private final String desc;
  PtmProductCategoryShopLevelEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
