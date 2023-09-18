package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 店铺-主营类目关联管理-是否删除枚举类
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum SpmShopMainCategoryAssocIsDelEnum implements IEnum<Integer> {

  /**
   * 是否删除#0=未删除|1=已删除
   *
   * @see SpmShopMainCategoryAssocIsDelEnum
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  NOT_DELETED(0, "未删除"),
  /**
   * 是否删除#0=未删除|1=已删除
   *
   * @see SpmShopMainCategoryAssocIsDelEnum
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  DELETED(1, "已删除");

  @EnumValue private final int value;
  private final String desc;
  SpmShopMainCategoryAssocIsDelEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
