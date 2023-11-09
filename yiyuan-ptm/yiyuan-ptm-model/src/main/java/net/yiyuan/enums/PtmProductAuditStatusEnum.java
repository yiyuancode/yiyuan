package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * 商品信息管理-审核状态枚举类
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
// @JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum PtmProductAuditStatusEnum implements IEnum<Integer> {

  /**
   * 审核状态#0=无需审核|1=待审核|2=审核成功|3=审核拒绝
   *
   * @author 一源团队-花和尚
   * @date 2023-10-09
   * @see PtmProductAuditStatusEnum
   */
  NO_NEED_FOR_REVIEW(0, "无需审核"),
  /**
   * 审核状态#0=无需审核|1=待审核|2=审核成功|3=审核拒绝
   *
   * @author 一源团队-花和尚
   * @date 2023-10-09
   * @see PtmProductAuditStatusEnum
   */
  PENDING_REVIEW(1, "待审核"),
  /**
   * 审核状态#0=无需审核|1=待审核|2=审核成功|3=审核拒绝
   *
   * @author 一源团队-花和尚
   * @date 2023-10-09
   * @see PtmProductAuditStatusEnum
   */
  AUDIT_SUCCESSFUL(2, "审核成功"),
  /**
   * 审核状态#0=无需审核|1=待审核|2=审核成功|3=审核拒绝
   *
   * @author 一源团队-花和尚
   * @date 2023-10-09
   * @see PtmProductAuditStatusEnum
   */
  AUDIT_REJECT(3, "审核拒绝");

  @JsonValue @EnumValue private final int value;
  private final String desc;

  PtmProductAuditStatusEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
