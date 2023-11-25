package net.yiyuan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 店铺类型查询请求响应参数实体
 *
 * @author 一源-花和尚
 * @date 2023-10-24
 */
@Data
public class SpmShopTypeQueryVO implements Serializable {

  /**
   * 店铺类型id
   *
   * @author 一源-花和尚
   * @date 2023-10-24
   */
  private String id;

  /**
   * 店铺类型名称
   *
   * @author 一源-花和尚
   * @date 2023-10-24
   */
  private String name;

  /**
   * 店铺类型描述
   *
   * @author 一源-花和尚
   * @date 2023-10-24
   */
  private String typeDesc;

  /**
   * 店铺类型合约
   *
   * @author 一源-花和尚
   * @date 2023-10-24
   */
  private String typeContract;

  /**
   * 排序
   *
   * @author 一源-花和尚
   * @date 2023-10-24
   */
  private Integer sort;

  /**
   * 显示状态0=不显示|1=显示
   *
   * @author 一源-花和尚
   * @date 2023-10-24
   */
  private Boolean isShow;

  /**
   * 创建时间
   *
   * @author 一源-花和尚
   * @date 2023-10-24
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  /**
   * 修改时间
   *
   * @author 一源-花和尚
   * @date 2023-10-24
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;
}
