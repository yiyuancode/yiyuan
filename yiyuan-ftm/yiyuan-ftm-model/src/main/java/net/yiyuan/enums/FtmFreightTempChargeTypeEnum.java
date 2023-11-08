package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 物流模板管理-计费类型枚举类
 *
 * @author 一源团队-花和尚
 * @date 2023-11-04
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
//@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum FtmFreightTempChargeTypeEnum implements IEnum<Integer> {

  /**
   * 计费类型#0=按个数|1=按重量|2=按体积
   *
   * @see FtmFreightTempChargeTypeEnum
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  BY_NUMBER(0, "按个数"),
  /**
   * 计费类型#0=按个数|1=按重量|2=按体积
   *
   * @see FtmFreightTempChargeTypeEnum
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  BY_WEIGHT(1, "按重量"),
  /**
   * 计费类型#0=按个数|1=按重量|2=按体积
   *
   * @see FtmFreightTempChargeTypeEnum
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  BY_VOLUME(2, "按体积");

  @JsonValue @EnumValue private final int value;
  private final String desc;
  FtmFreightTempChargeTypeEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
