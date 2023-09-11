package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 租户信息管理-客服类型枚举类
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum SysTenantInfoServiceTypeEnum implements IEnum<Integer> {

  /**
   * 客服类型#0=H5链接|1=电话
   *
   * @see SysTenantInfoServiceTypeEnum
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  H5链接(0, "H5链接"),
  /**
   * 客服类型#0=H5链接|1=电话
   *
   * @see SysTenantInfoServiceTypeEnum
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  TELEPHONE(1, "电话");

  @EnumValue private final int value;
  private final String desc;

  SysTenantInfoServiceTypeEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
