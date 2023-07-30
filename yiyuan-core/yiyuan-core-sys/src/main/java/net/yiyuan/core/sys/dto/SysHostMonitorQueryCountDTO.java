package net.yiyuan.core.sys.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.core.sys.enums.SysHostIsMonitorQueryCountParticleEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 服务器监控采集新增接口请求入参实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-30
 */
@Data
public class SysHostMonitorQueryCountDTO implements Serializable {

  /**
   * 主机表id
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @NotBlank(message = "主机id不能为空")
  private String hostId;

  /**
   * 统计维度
   *
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @NotNull(message = "统计维度不能为空")
  private SysHostIsMonitorQueryCountParticleEnum particle;

  /**
   * 创建时间(查询开始时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @NotNull(message = "统计开始时间不能为空")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @see Date
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @NotNull(message = "统计开始时间不能为空")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeEnd;
}
