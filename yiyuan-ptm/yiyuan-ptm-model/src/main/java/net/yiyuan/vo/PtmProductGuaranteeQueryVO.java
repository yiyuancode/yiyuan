package net.yiyuan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 保障服务查询请求响应参数实体
 *
 * @author 一源团队-花和尚
 * @date 2023-11-09
 */
@Data
public class PtmProductGuaranteeQueryVO implements Serializable {

  /**
   * 保障服务id
   *
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  private String id;

  /**
   * 商户id
   *
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  private String tenantId;

  /**
   * 保障服务名称
   *
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  private String name;

  /**
   * 排序
   *
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  private Integer sort;

  /**
   * 是否显示0=否|1=是
   *
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  private Boolean isShow;

  /**
   * 创建时间
   *
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  /**
   * 修改时间
   *
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;
}
