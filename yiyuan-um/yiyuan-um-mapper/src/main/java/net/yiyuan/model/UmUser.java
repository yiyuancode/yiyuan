package net.yiyuan.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.common.constatnt.CustomSqlCondition;
import net.yiyuan.enums.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户实体
 *
 * @author 小林同学
 * @date 2023-09-18
 */
@Data
public class UmUser implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 用户id
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
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
   * @author 小林同学
   * @date 2023-09-18
   */
  private UmUserSexEnum sex;

  /**
   * 积分
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private Integer integral;

  /**
   * 经验
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private Integer experience;

  /**
   * 余额
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private BigDecimal nowMoney;

  /**
   * 佣金
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private BigDecimal brokeragePrice;

  /**
   * 等级
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private Byte level;

  /**
   * 签到天数
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private Integer signNum;

  /**
   * 是否关联公众号#0=否|1=是
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private UmUserIsWechatPublicEnum isWechatPublic;

  /**
   * 是否关联小程序#0=否|1=是
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private UmUserIsWechatRoutineEnum isWechatRoutine;

  /**
   * 用户购买次数
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private Integer transactionCount;

  /**
   * 是否为推广员#0=否|1=是
   *
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
   * 分销员加入时间(查询开始时间)
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  @TableField(value = "promoter_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date promoterTimeStart;
  /**
   * 分销员加入时间(查询结束时间)
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  @TableField(value = "promoter_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date promoterTimeEnd;

  /**
   * 上级推广员id
   *
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
   * 绑定上级推广员时间(查询开始时间)
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  @TableField(value = "promote_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date promoteTimeStart;
  /**
   * 绑定上级推广员时间(查询结束时间)
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  @TableField(value = "promote_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date promoteTimeEnd;

  /**
   * 下级人数
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private Integer promoteCount;

  /**
   * 用户注册类型#0=公众号|1=小程序|2=H5|3=微信ios|4=微信安卓|5=ios
   *
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
   * 最后一次登录时间(查询开始时间)
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  @TableField(
      value = "last_login_time ",
      condition = CustomSqlCondition.START_EQUAL,
      select = false)
  private Date lastLoginTimeStart;
  /**
   * 最后一次登录时间(查询结束时间)
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  @TableField(value = "last_login_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date lastLoginTimeEnd;

  /**
   * 状态#1=正常|0=禁止
   *
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
   * 添加时间
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  /**
   * 添加时间(查询开始时间)
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  @TableField(value = "create_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date createTimeStart;
  /**
   * 添加时间(查询结束时间)
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  @TableField(value = "create_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date createTimeEnd;

  /**
   * 更新时间
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
  /**
   * 更新时间(查询开始时间)
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  @TableField(value = "update_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date updateTimeStart;
  /**
   * 更新时间(查询结束时间)
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  @TableField(value = "update_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date updateTimeEnd;

  /**
   * 是否注销#0=未注销|1=已注销
   *
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
   * 注销时间(查询开始时间)
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  @TableField(
      value = "deactivate_time ",
      condition = CustomSqlCondition.START_EQUAL,
      select = false)
  private Date deactivateTimeStart;
  /**
   * 注销时间(查询结束时间)
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  @TableField(value = "deactivate_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date deactivateTimeEnd;

  /**
   * 是否关联微信ios#0=否|1=是
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private UmUserIsWechatIosEnum isWechatIos;

  /**
   * 是否关联微信android#0=否|1=是
   *
   * @author 小林同学
   * @date 2023-09-18
   */
  private UmUserIsWechatAndroidEnum isWechatAndroid;

  /**
   * 是否关联ios #0=否|1=是
   *
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
