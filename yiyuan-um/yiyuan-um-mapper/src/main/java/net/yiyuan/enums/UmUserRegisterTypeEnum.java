package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 用户管理-用户注册类型枚举类
 *
 * @author 小林同学
 * @date 2023-09-18
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum UmUserRegisterTypeEnum implements IEnum<Integer> {

  /**
   * 用户注册类型#0=公众号|1=小程序|2=H5|3=微信ios|4=微信安卓|5=ios
   *
   * @author 小林同学
   * @date 2023-09-18
   * @see UmUserRegisterTypeEnum
   */
  OFFICIAL_ACCOUNT(0, "公众号"),
  /**
   * 用户注册类型#0=公众号|1=小程序|2=H5|3=微信ios|4=微信安卓|5=ios
   *
   * @author 小林同学
   * @date 2023-09-18
   * @see UmUserRegisterTypeEnum
   */
  MINI_PROGRAM(1, "小程序"),
  /**
   * 用户注册类型#0=公众号|1=小程序|2=H5|3=微信ios|4=微信安卓|5=ios
   *
   * @author 小林同学
   * @date 2023-09-18
   * @see UmUserRegisterTypeEnum
   */
  H5(2, "H5"),
  /**
   * 用户注册类型#0=公众号|1=小程序|2=H5|3=微信ios|4=微信安卓|5=ios
   *
   * @author 小林同学
   * @date 2023-09-18
   * @see UmUserRegisterTypeEnum
   */
  WECHAT_IOS(3, "微信ios"),
  /**
   * 用户注册类型#0=公众号|1=小程序|2=H5|3=微信ios|4=微信安卓|5=ios
   *
   * @author 小林同学
   * @date 2023-09-18
   * @see UmUserRegisterTypeEnum
   */
  WECHAT_ANDROID(4, "微信安卓"),
  /**
   * 用户注册类型#0=公众号|1=小程序|2=H5|3=微信ios|4=微信安卓|5=ios
   *
   * @author 小林同学
   * @date 2023-09-18
   * @see UmUserRegisterTypeEnum
   */
  IOS(5, "ios");

  @EnumValue private final int value;
  private final String desc;

  UmUserRegisterTypeEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  public static UmUserRegisterTypeEnum fromValue(Integer value) {
    for (UmUserRegisterTypeEnum enumValue : UmUserRegisterTypeEnum.values()) {
      if (enumValue.getValue() == value) {
        return enumValue;
      }
    }
    throw new IllegalArgumentException("Invalid value: " + value);
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
