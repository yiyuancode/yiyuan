package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 店铺-主营类目关联管理-显示状态枚举类
 *
 * @author 一源-花和尚
 * @date 2023-09-22
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum SpmShopMainCategoryAssocIsShowEnum implements IEnum<Integer> {

  /**
   * 显示状态#0=不显示|1=显示
   *
   * @see SpmShopMainCategoryAssocIsShowEnum
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  DO_NOT_DISPLAY(0, "不显示"),
  /**
   * 显示状态#0=不显示|1=显示
   *
   * @see SpmShopMainCategoryAssocIsShowEnum
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  DISPLAY(1, "显示");

  @EnumValue private final int value;
  private final String desc;

  SpmShopMainCategoryAssocIsShowEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
