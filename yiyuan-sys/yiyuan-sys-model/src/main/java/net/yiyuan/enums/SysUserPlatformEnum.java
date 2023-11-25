package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 管理端用户管理-平台类型枚举类
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
//@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum SysUserPlatformEnum implements IEnum<Integer> {

  /**
   * 平台类型#0=平台端|1=租户端|2=移动端
   *
   * @see SysUserPlatformEnum
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  PLATFORM_SIDE(0, "平台端"),
  /**
   * 平台类型#0=平台端|1=租户端|2=移动端
   *
   * @see SysUserPlatformEnum
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  TENANT_END(1, "租户端"),
  /**
   * 平台类型#0=平台端|1=租户端|2=移动端
   *
   * @see SysUserPlatformEnum
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  MOBILE_END(2, "移动端");

  @JsonValue @EnumValue private final int value;
  private final String desc;

  SysUserPlatformEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
