package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 租户管理-商品是否审核枚举类
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum SysTenantIsProductAuditEnum implements IEnum<Integer> {

  /**
   * 商品是否审核#0=不审核|1=审核
   *
   * @see SysTenantIsProductAuditEnum
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  NOT_REVIEWED(0, "不审核"),
  /**
   * 商品是否审核#0=不审核|1=审核
   *
   * @see SysTenantIsProductAuditEnum
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  AUDITING(1, "审核");

  @EnumValue private final int value;
  private final String desc;
  SysTenantIsProductAuditEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
