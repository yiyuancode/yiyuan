package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 发起商户入驻申请请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-09-08
 */
@Data
public class SysTenantApplyDTO implements Serializable {

  /**
   * 归属区域
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @NotBlank(message = "归属区域不能为空")
  private String spmShopCityId;

  /**
   * 商户名称
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @NotBlank(message = "商户名称不能为空")
  private String name;

  /**
   * 法人名称
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @NotBlank(message = "法人名称不能为空")
  private String legalPersonName;

  /**
   * 联系邮箱
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @NotBlank(message = "联系邮箱不能为空")
  private String email;

  /**
   * 联系手机
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @NotNull(message = "联系手机不能为空")
  private String phone;

  /**
   * 详细地址
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @NotBlank(message = "详细地址不能为空")
  private String detailedAddress;

  /**
   * 统一社会信用代码
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @NotBlank(message = "统一社会信用代码不能为空")
  private String socialCreditCode;

  /**
   * 营业执照电子版
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @NotBlank(message = "营业执照电子版不能为空")
  private String businessLicenseImage;

  /**
   * 法人身份证正面
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @NotBlank(message = "法人身份证正面不能为空")
  private String legalPersonIdFrontImage;

  /**
   * 法人身份证反面
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @NotBlank(message = "法人身份证反面不能为空")
  private String legalPersonIdBackImage;

  /**
   * 申请备注
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @NotBlank(message = "申请备注不能为空")
  private String remark;
}
