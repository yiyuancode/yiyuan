package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户修改接口请求入参实体
 *
 * @author 小林同学
 * @date 2023-09-18
 */
@Data
public class UmUserEditDTO implements Serializable {

  /**
   * 用户id
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  @NotBlank(message = "用户id不能为空")
  private String id;

  /**
   * 账号
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private String account;

  /**
   * 密码
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private String pwd;

  /**
   * 姓名
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private String name;

  /**
   * 生日
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private String birthday;

  /**
   * 身份证号码
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private String identityCardNo;

  /**
   * 标签id,英文逗号分隔
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private String tagId;

  /**
   * 昵称
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private String nickname;

  /**
   * 头像
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private String avatar;

  /**
   * 手机号码
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private String phone;

  /**
   * 国家，#0=中国CN|1=OTHER
   *
   * @mock CN
   * @author 小林同学
   * @date 2023-09-18
   */
  private UmUserCountryEnum country;

  /**
   * 省份
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private String province;

  /**
   * 城市
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private String city;

  /**
   * 区
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private String district;

  /**
   * 详细地址信息
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private String address;

  /**
   * 性别#0=未知|1=男|2=女|3=保密
   *
   * @mock 1
   * @author 小林同学
   * @date 2023-09-18
   */
  private UmUserSexEnum sex;

  /**
   * 积分
   *
   * @mock 0
   * @author 小林同学
   * @date 2023-09-18
   */
  private Integer integral;

  /**
   * 经验
   *
   * @mock 0
   * @author 小林同学
   * @date 2023-09-18
   */
  private Integer experience;

  /**
   * 余额
   *
   * @mock 0.00
   * @author 小林同学
   * @date 2023-09-18
   */
  private BigDecimal nowMoney;

  /**
   * 佣金
   *
   * @mock 0.00
   * @author 小林同学
   * @date 2023-09-18
   */
  private BigDecimal brokeragePrice;

  /**
   * 等级
   *
   * @mock 0
   * @author 小林同学
   * @date 2023-09-18
   */
  private Byte level;

  /**
   * 签到天数
   *
   * @mock 0
   * @author 小林同学
   * @date 2023-09-18
   */
  private Integer signNum;

  /**
   * 是否关联公众号#0=否|1=是
   *
   * @mock 0
   * @author 小林同学
   * @date 2023-09-18
   */
  private UmUserIsWechatPublicEnum isWechatPublic;

  /**
   * 是否关联小程序#0=否|1=是
   *
   * @mock 0
   * @author 小林同学
   * @date 2023-09-18
   */
  private UmUserIsWechatRoutineEnum isWechatRoutine;

  /**
   * 用户购买次数
   *
   * @mock 0
   * @author 小林同学
   * @date 2023-09-18
   */
  private Integer transactionCount;

  /**
   * 是否为推广员#0=否|1=是
   *
   * @mock 0
   * @author 小林同学
   * @date 2023-09-18
   */
  private UmUserIsPromoterEnum isPromoter;

  /**
   * 分销员加入时间
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private Date promoterTime;

  /**
   * 上级推广员id
   *
   * @mock 0
   * @author 小林同学
   * @date 2023-09-18
   */
  private Integer promoteUid;

  /**
   * 绑定上级推广员时间
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private Date promoteTime;

  /**
   * 下级人数
   *
   * @mock 0
   * @author 小林同学
   * @date 2023-09-18
   */
  private Integer promoteCount;

  /**
   * 用户注册类型#0=公众号|1=小程序|2=H5|3=微信ios|4=微信安卓|5=ios
   *
   * @mock 0
   * @author 小林同学
   * @date 2023-09-18
   */
  private UmUserRegisterTypeEnum registerType;

  /**
   * 最后一次登录ip
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private String lastLoginIp;

  /**
   * 最后一次登录时间
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private Date lastLoginTime;

  /**
   * 状态#1=正常|0=禁止
   *
   * @mock 1
   * @author 小林同学
   * @date 2023-09-18
   */
  private UmUserStatusEnum status;

  /**
   * 备注
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private String note;

  /**
   * 是否注销#0=未注销|1=已注销
   *
   * @mock 0
   * @author 小林同学
   * @date 2023-09-18
   */
  private UmUserIsDeactivateEnum isDeactivate;

  /**
   * 注销时间
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private Date deactivateTime;

  /**
   * 是否关联微信ios#0=否|1=是
   *
   * @mock 0
   * @author 小林同学
   * @date 2023-09-18
   */
  private UmUserIsWechatIosEnum isWechatIos;

  /**
   * 是否关联微信android#0=否|1=是
   *
   * @mock 0
   * @author 小林同学
   * @date 2023-09-18
   */
  private UmUserIsWechatAndroidEnum isWechatAndroid;

  /**
   * 是否关联ios #0=否|1=是
   *
   * @mock 0
   * @author 小林同学
   * @date 2023-09-18
   */
  private UmUserIsBindingIosEnum isBindingIos;

  /**
   * 用户签名
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private String personalSignature;
}
