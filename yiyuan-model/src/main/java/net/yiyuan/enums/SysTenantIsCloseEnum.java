package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 租户管理-商户开关枚举类
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum SysTenantIsCloseEnum implements IEnum<Integer> {

  /**
   * 商户开关#0=未关闭|1=关闭
   *
   * @see SysTenantIsCloseEnum
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  NOT_CLOSED(0, "未关闭"),
  /**
   * 商户开关#0=未关闭|1=关闭
   *
   * @see SysTenantIsCloseEnum
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  CLOSE(1, "关闭");

  @EnumValue private final int value;
  private final String desc;
  SysTenantIsCloseEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
