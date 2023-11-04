package net.yiyuan.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 物流模板价格实体
 *
 * @author 一源团队-花和尚
 * @date 2023-11-04
 */
@Data
public class FtmFreightTempPrice implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 物流模板价格id
   *
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
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
   * 排序
   *
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private Integer sort;

  /**
   * 是否显示0=否|1=是
   *
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  private Boolean isShow;

  /**
   * 创建时间
   *
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;

  /**
   * 修改时间
   *
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;

  /**
   * 创建人
   *
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @TableField(fill = FieldFill.INSERT)
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private String updateUser;
}
