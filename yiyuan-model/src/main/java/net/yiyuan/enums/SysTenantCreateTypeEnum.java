package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 租户管理-创建类型枚举类
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum SysTenantCreateTypeEnum implements IEnum<Integer> {

  /**
   * 创建类型#0=平台创建|1=自主申请
   *
   * @see SysTenantCreateTypeEnum
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  PLATFORM_CREATION(0, "平台创建"),
  /**
   * 创建类型#0=平台创建|1=自主申请
   *
   * @see SysTenantCreateTypeEnum
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  AUTONOMOUS_APPLICATION(1, "自主申请");

  @EnumValue private final int value;
  private final String desc;
  SysTenantCreateTypeEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
