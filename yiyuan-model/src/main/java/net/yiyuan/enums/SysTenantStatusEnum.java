package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 商户管理-入驻状态枚举类
 *
 * @author 一源团队-花和尚
 * @date 2023-09-08
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum SysTenantStatusEnum implements IEnum<Integer> {

  /**
   * 入驻状态#0=待审核|1=通过|2=被驳回
   *
   * @see SysTenantStatusEnum
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  PENDING_REVIEW(0, "待审核"),
  /**
   * 入驻状态#0=待审核|1=通过|2=被驳回
   *
   * @see SysTenantStatusEnum
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  ADOPT(1, "通过"),
  /**
   * 入驻状态#0=待审核|1=通过|2=被驳回
   *
   * @see SysTenantStatusEnum
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  REJECTED(2, "被驳回");

  @EnumValue private final int value;
  private final String desc;

  SysTenantStatusEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
