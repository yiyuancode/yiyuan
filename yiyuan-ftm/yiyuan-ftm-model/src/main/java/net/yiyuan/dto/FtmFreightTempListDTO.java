package net.yiyuan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.enums.FtmFreightTempChargeTypeEnum;
import net.yiyuan.enums.FtmFreightTempPackageTypeEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 物流模板列表接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-11-04
 */
@Data
public class FtmFreightTempListDTO implements Serializable {

  /**
   * 模板id
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
   * 模板名称
   *
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private String name;

  /**
   * 包邮类型#0=全部包邮|1=部分包邮
   *
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private FtmFreightTempPackageTypeEnum packageType;

  /**
   * 计费类型#0=按个数|1=按重量|2=按体积
   *
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private FtmFreightTempChargeTypeEnum chargeType;

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
