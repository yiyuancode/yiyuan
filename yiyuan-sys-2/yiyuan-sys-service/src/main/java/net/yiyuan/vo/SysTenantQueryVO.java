package net.yiyuan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.enums.SysTenantIsDelEnum;
import net.yiyuan.enums.SysTenantStatusEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 商户查询请求响应参数实体
 *
 * @author 一源团队-花和尚
 * @date 2023-09-08
 */
@Data
public class SysTenantQueryVO implements Serializable {

  /**
   * 商户id
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
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
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  private SysTenantIsDelEnum isDel;

  /**
   * 创建时间
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  /**
   * 更新时间
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;

  /**
   * 创建人
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  private String updateUser;

  /**
   * 归属区域中文
   *
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  private String spmShopCityIdZh;
}
