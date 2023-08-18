package net.yiyuan.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * 主机监控--监控统计颗粒度枚举类
 *
 * @author ${author}
 * @date 2023-07-27
 */
@Getter // 没有引入lombok依赖包的，可以自己实现get方法
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 实现场景2，只需要加上这个注解
public enum SysRedisMonitorQueryCountParticleEnum implements IEnum<Integer> {
  /**
   * 按每分钟#0=每5分钟|1=每小时|2=每天|3=每周|4=每月
   *
   * @author ${author}
   * @date 2023-07-27
   * @see SysRedisMonitorQueryCountParticleEnum
   */
  BY_MINUTE_5(0, "每5分钟"),

  /**
   * 按每小时#0=每5分钟|1=每小时|2=每天|3=每周|4=每月
   *
   * @author ${author}
   * @date 2023-07-27
   * @see SysRedisMonitorQueryCountParticleEnum
   */
  BY_HOUR(1, "每小时"),

  /**
   * 按每天#0=每5分钟|1=每小时|2=每天|3=每周|4=每月
   *
   * @author ${author}
   * @date 2023-07-27
   * @see SysRedisMonitorQueryCountParticleEnum
   */
  BY_DAYS(2, "每天"),

  /**
   * 按每周#0=每5分钟|1=每小时|2=每天|3=每周|4=每月
   *
   * @author ${author}
   * @date 2023-07-27
   * @see SysRedisMonitorQueryCountParticleEnum
   */
  BY_WEEK(3, "每周"),

  /**
   * 按每月#0=每5分钟|1=每小时|2=每天|3=每周|4=每月
   *
   * @author ${author}
   * @date 2023-07-27
   * @see SysRedisMonitorQueryCountParticleEnum
   */
  BY_MONTH(4, "每月");

  @EnumValue private final int value;
  private final String desc;

  SysRedisMonitorQueryCountParticleEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public Integer getValue() {
    return this.value;
  }
}
