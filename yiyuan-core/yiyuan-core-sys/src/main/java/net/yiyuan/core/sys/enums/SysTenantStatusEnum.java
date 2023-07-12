package net.yiyuan.core.sys.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SysTenantStatusEnum {
  NORMAL(0, "正常"),
  FREEZE(1, "冻结");

  @EnumValue // 使用注解的形式直接数据存放的值,这样类型更灵活，可以随意更换字段
  private final int code;
  @JsonValue // 标记响应json值
  private final String desc;

  SysTenantStatusEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
