package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 定时任务管理-任务状态枚举类
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
//@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum SysQrtzJobStatusEnum implements IEnum<Integer> {

  /**
   * 任务状态#0=暂停|1=执行中|2=已结束
   *
   * @see SysQrtzJobStatusEnum
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  SUSPEND(0, "暂停"),
  /**
   * 任务状态#0=暂停|1=执行中|2=已结束
   *
   * @see SysQrtzJobStatusEnum
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  UNDER_EXECUTION(1, "执行中"),
  /**
   * 任务状态#0=暂停|1=执行中|2=已结束
   *
   * @see SysQrtzJobStatusEnum
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  ENDED(2, "已结束");

  @JsonValue @EnumValue private final int value;
  private final String desc;

  SysQrtzJobStatusEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
