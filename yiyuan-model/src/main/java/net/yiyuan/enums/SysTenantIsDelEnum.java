package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 商户管理-逻辑删除标记枚举类
 *
 * @author 一源团队-花和尚
 * @date 2023-09-08
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum SysTenantIsDelEnum implements IEnum<Integer> {

  /**
   * 逻辑删除标记#0=未删除|1=已删除
   *
   * @see SysTenantIsDelEnum
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  NOT_DELETED(0, "未删除"),
  /**
   * 逻辑删除标记#0=未删除|1=已删除
   *
   * @see SysTenantIsDelEnum
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  DELETED(1, "已删除");

  @EnumValue private final int value;
  private final String desc;

  SysTenantIsDelEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
