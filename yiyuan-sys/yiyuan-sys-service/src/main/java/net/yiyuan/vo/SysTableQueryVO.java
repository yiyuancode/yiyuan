package net.yiyuan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据库查询请求响应参数实体
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Data
public class SysTableQueryVO implements Serializable {

  /**
   * 主键id
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String id;

  /**
   * 表名
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String name;

  /**
   * 表注释
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String remark;

  /**
   * 创建时间
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  /**
   * 修改时间
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;

  /**
   * 创建人
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String updateUser;
}
