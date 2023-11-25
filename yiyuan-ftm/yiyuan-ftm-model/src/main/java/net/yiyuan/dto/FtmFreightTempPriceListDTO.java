package net.yiyuan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 物流模板价格列表接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-11-04
 */
@Data
public class FtmFreightTempPriceListDTO implements Serializable {

  /**
   * 物流模板价格id
   *
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private String id;

  /**
   * 商户id
   *
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private String tenantId;

  /**
   * 运费模板id
   *
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private String ftmFreightTempId;

  /**
   * 城市区域ids(区域最后一级,多个逗号分割)
   *
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private String sysAreaIds;

  /**
   * 首-数量
   *
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private Integer firstNum;

  /**
   * 首-价格
   *
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private BigDecimal firstPrice;

  /**
   * 续-数量
   *
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private Integer nextNum;

  /**
   * 续-价格
   *
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private BigDecimal nextPrice;

  /**
   * 满数量减包邮
   *
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private Integer fullPackageNum;

  /**
   * 满价格减包邮
   *
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private BigDecimal fullPackagePrice;

  /**
   * 是否包邮0=否|1=是
   *
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private Boolean isPackage;

  /**
   * 是否显示0=否|1=是
   *
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private Boolean isShow;

  /**
   * 创建时间(查询开始时间)
   *
   * @see Date
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @see Date
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeEnd;

  /**
   * 修改时间(查询开始时间)
   *
   * @see Date
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @see Date
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeEnd;
}
