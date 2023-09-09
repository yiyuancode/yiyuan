package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.SysTenantIsDelEnum;
import net.yiyuan.enums.SysTenantStatusEnum;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 商户修改接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-09-08
 */
@Data
public class SysTenantEditDTO implements Serializable {

  /**
   * 商户id
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @NotBlank(message = "商户id不能为空")
  private String id;

  /**
   * 归属区域
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  private String spmShopCityId;

  /**
   * 商户名称
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  private String name;

  /**
   * 法人名称
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  private String legalPersonName;

  /**
   * 联系邮箱
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  private String email;

  /**
   * 联系手机
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  private String phone;

  /**
   * 详细地址
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  private String detailedAddress;

  /**
   * 统一社会信用代码
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  private String socialCreditCode;

  /**
   * 营业执照电子版
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  private String businessLicenseImage;

  /**
   * 法人身份证正面
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  private String legalPersonIdFrontImage;

  /**
   * 法人身份证反面
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  private String legalPersonIdBackImage;

  /**
   * 申请备注
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  private String remark;

  /**
   * 入驻状态#0=待审核|1=通过|2=被驳回
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  private SysTenantStatusEnum status;

  /**
   * 排序
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  private Integer sort;

  /**
   * 逻辑删除标记#0=未删除|1=已删除
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  private SysTenantIsDelEnum isDel;
}
