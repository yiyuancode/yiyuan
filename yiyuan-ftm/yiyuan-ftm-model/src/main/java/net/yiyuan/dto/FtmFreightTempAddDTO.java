package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.FtmFreightTempChargeTypeEnum;
import net.yiyuan.enums.FtmFreightTempPackageTypeEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 物流模板新增接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-11-04
 */
@Data
public class FtmFreightTempAddDTO implements Serializable {

  /**
   * 商户id
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @NotBlank(message = "商户id不能为空")
  private String tenantId;

  /**
   * 模板名称
   *
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @NotBlank(message = "模板名称不能为空")
  private String name;

  /**
   * 包邮类型#0=全部包邮|1=部分包邮
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @NotNull(message = "包邮类型#0=全部包邮|1=部分包邮不能为空")
  private FtmFreightTempPackageTypeEnum packageType;

  /**
   * 计费类型#0=按个数|1=按重量|2=按体积
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @NotNull(message = "计费类型#0=按个数|1=按重量|2=按体积不能为空")
  private FtmFreightTempChargeTypeEnum chargeType;

  /**
   * 是否显示0=否|1=是
   *
   * @mock 1
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @NotNull(message = "是否显示0=否|1=是不能为空")
  private Boolean isShow;

  /**
   * 运费集合
   *
   * @mock 1
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private List<FtmFreightTempPriceAddDTO> priceList;
}
