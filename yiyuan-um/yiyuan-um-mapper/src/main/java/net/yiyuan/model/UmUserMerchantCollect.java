package net.yiyuan.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import net.yiyuan.common.constatnt.CustomSqlCondition;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户租户收藏实体
 *
 * @author 小林同学
 * @date 2023-09-19
 */
@Data
public class UmUserMerchantCollect implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 用户ID
   *
   * @author 小林同学
   * @date 2023-09-19
   */
  private String uid;

  /**
   * 租户ID
   *
   * @author 小林同学
   * @date 2023-09-19
   */
  private String tenantId;

  /**
   * 创建时间
   *
   * @author 小林同学
   * @date 2023-09-19
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  /**
   * 创建时间(查询开始时间)
   *
   * @author 小林同学
   * @date 2023-09-19
   */

  /**
   * 创建时间(查询结束时间)
   *
   * @author 小林同学
   * @date 2023-09-19
   */

}
