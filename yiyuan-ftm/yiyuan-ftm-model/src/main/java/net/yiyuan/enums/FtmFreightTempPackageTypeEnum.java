package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 物流模板管理-包邮类型枚举类
 *
 * @author 一源团队-花和尚
 * @date 2023-11-04
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
//@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum FtmFreightTempPackageTypeEnum implements IEnum<Integer> {

  /**
   * 包邮类型#0=全部包邮|1=部分包邮
   *
   * @see FtmFreightTempPackageTypeEnum
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  ALL_INCLUSIVE_SHIPPING(0, "全部包邮"),
  /**
   * 包邮类型#0=全部包邮|1=部分包邮
   *
   * @see FtmFreightTempPackageTypeEnum
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  PARTIAL_PACKAGE_SHIPPING(1, "部分包邮");

  @JsonValue @EnumValue private final int value;
  private final String desc;
  FtmFreightTempPackageTypeEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
