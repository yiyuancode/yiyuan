package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 数据库新增接口请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Data
public class SysTableAddDTO implements Serializable {

  /**
   * 表名
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @NotBlank(message = "表名不能为空")
  private String name;

  /**
   * 表注释
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @NotBlank(message = "表注释不能为空")
  private String remark;
}
