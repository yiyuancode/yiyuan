package net.yiyuan.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.enums.FtmFreightTempChargeTypeEnum;
import net.yiyuan.enums.FtmFreightTempPackageTypeEnum;

import java.io.Serializable;
import java.util.Date;
/**
 * 物流模板实体
 *
 * @author 一源团队-花和尚
 * @date 2023-11-04
 */
@Data
public class FtmFreightTemp implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 模板id
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
