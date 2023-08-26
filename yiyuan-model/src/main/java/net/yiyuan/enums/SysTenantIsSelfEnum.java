package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 租户管理-是否自营枚举类
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum SysTenantIsSelfEnum implements IEnum<Integer> {

  /**
   * 是否自营#0=非自营|1=自营
   *
   * @see SysTenantIsSelfEnum
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  NON_SELF_OPERATED(0, "非自营"),
  /**
   * 是否自营#0=非自营|1=自营
   *
   * @see SysTenantIsSelfEnum
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  SELF_OPERATED(1, "自营");

  @EnumValue private final int value;
  private final String desc;

  SysTenantIsSelfEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
