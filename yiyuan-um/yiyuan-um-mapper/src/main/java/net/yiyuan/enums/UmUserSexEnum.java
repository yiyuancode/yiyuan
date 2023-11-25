package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 用户管理-性别枚举类
 *
 * @author 小林同学
 * @date 2023-09-18
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
//@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum UmUserSexEnum implements IEnum<Integer> {

  /**
   * 性别#0=未知|1=男|2=女|3=保密
   *
   * @author 小林同学
   * @date 2023-09-18
   * @see UmUserSexEnum
   */
  UNKNOWN(0, "未知"),
  /**
   * 性别#0=未知|1=男|2=女|3=保密
   *
   * @author 小林同学
   * @date 2023-09-18
   * @see UmUserSexEnum
   */
  MALE(1, "男"),
  /**
   * 性别#0=未知|1=男|2=女|3=保密
   *
   * @author 小林同学
   * @date 2023-09-18
   * @see UmUserSexEnum
   */
  FEMALE(2, "女"),
  /**
   * 性别#0=未知|1=男|2=女|3=保密
   *
   * @author 小林同学
   * @date 2023-09-18
   * @see UmUserSexEnum
   */
  SECRECY(3, "保密");

  @JsonValue @EnumValue private final int value;
  private final String desc;

  UmUserSexEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
