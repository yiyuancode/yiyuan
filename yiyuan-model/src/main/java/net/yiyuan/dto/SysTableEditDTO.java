package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 数据库修改接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-25
 */
@Data
public class SysTableEditDTO implements Serializable {

  /**
   * 主键id
   *
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  @NotBlank(message = "主键id不能为空")
  private String id;

  /**
   * 表名
   *
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  private String name;

  /**
   * 表注释
   *
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  private String remark;
}
