package net.yiyuan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.enums.SpmShopTypeIsDelEnum;
import net.yiyuan.enums.SpmShopTypeIsShowEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 店铺类型列表接口请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-09-22
 */
@Data
public class SpmShopTypeListDTO implements Serializable {

  /**
   * 店铺类型id
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String id;

  /**
   * 店铺类型名称
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String name;

  /**
   * 店铺类型描述
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String typeDesc;

  /**
   * 店铺类型合约
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String typeContract;

  /**
   * 显示状态#0=不显示|1=显示
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private SpmShopTypeIsShowEnum isShow;

  /**
   * 是否删除#0=未删除|1=已删除
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private SpmShopTypeIsDelEnum isDel;

  /**
   * 创建时间(查询开始时间)
   *
   * @see Date
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @see Date
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeEnd;

  /**
   * 修改时间(查询开始时间)
   *
   * @see Date
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @see Date
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeEnd;

  /**
   * 创建人
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String updateUser;
}
