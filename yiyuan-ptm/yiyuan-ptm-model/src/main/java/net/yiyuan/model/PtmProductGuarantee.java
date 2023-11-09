package net.yiyuan.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * 保障服务实体
 *
 * @author 一源团队-花和尚
 * @date 2023-11-09
 */
@Data
public class PtmProductGuarantee implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 保障服务id
   *
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * 商户id
   *
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  private String tenantId;

  /**
   * 保障服务名称
   *
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  private String name;

  /**
   * 排序
   *
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  private Integer sort;

  /**
   * 是否显示0=否|1=是
   *
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  private Boolean isShow;

  /**
   * 创建时间
   *
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;

  /**
   * 修改时间
   *
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;

  /**
   * 创建人
   *
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  @TableField(fill = FieldFill.INSERT)
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private String updateUser;
}
