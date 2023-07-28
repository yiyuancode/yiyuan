package net.yiyuan.core.qrtz.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 定时任务管理管理-任务状态枚举类
 *
 * @author 一源团队--花和尚
 * @date 2023-07-28
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum QrtzJobJobStatusEnum implements IEnum<Integer> {

  /**
   * 任务状态#0=暂停|1=执行中|2=已结束
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see QrtzJobJobStatusEnum
   */
  SUSPEND(0, "暂停"),
  /**
   * 任务状态#0=暂停|1=执行中|2=已结束
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see QrtzJobJobStatusEnum
   */
  UNDER_EXECUTION(1, "执行中"),
  /**
   * 任务状态#0=暂停|1=执行中|2=已结束
   *
   * @author 一源团队--花和尚
   * @date 2023-07-28
   * @see QrtzJobJobStatusEnum
   */
  ENDED(2, "已结束");

  @EnumValue private final int value;
  private final String desc;

  QrtzJobJobStatusEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
