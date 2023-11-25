package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * -类型枚举类
 *
 * @author 一源团队--小林同学
 * @date 2023-07-15
 */
@Getter
public enum FileInfoStateEnum {

  /**
   * 类型#0=临时|2=储存成功
   *
   * @author 一源团队--小林同学
   * @date 2023-07-15
   * @see FileInfoStateEnum
   */
  TEMPORARY(0, "临时"),
  /**
   * 类型#0=临时|2=储存成功
   *
   * @author 一源团队--小林同学
   * @date 2023-07-15
   * @see FileInfoStateEnum
   */
  STORE_SUCCESSFUL(2, "储存成功");

  @JsonValue @EnumValue private final int code;
  @JsonValue private final String desc;

  FileInfoStateEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
