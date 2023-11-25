package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 物流模板价格修改接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-11-04
 */
@Data
public class FtmFreightTempPriceEditDTO implements Serializable {

  /**
   * 物流模板价格id
   *
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @NotBlank(message = "物流模板价格id不能为空")
  private String id;

  /**
   * 商户id
   *
   * @mock 0
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
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private Integer firstNum;

  /**
   * 首-价格
   *
   * @mock 0.00
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private BigDecimal firstPrice;

  /**
   * 续-数量
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private Integer nextNum;

  /**
   * 续-价格
   *
   * @mock 0.00
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private BigDecimal nextPrice;

  /**
   * 满数量减包邮
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private Integer fullPackageNum;

  /**
   * 满价格减包邮
   *
   * @mock 0.00
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private BigDecimal fullPackagePrice;

  /**
   * 是否包邮0=否|1=是
   *
   * @mock 1
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private Boolean isPackage;

  /**
   * 排序
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private Integer sort;

  /**
   * 是否显示0=否|1=是
   *
   * @mock 1
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private Boolean isShow;
}
