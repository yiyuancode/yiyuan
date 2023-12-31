package net.yiyuan.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.common.constatnt.CustomSqlCondition;

import java.io.Serializable;
import java.util.Date;

/**
 * 浏览记录实体
 *
 * @author 小林同学
 * @date 2023-09-19
 */
@Data
public class UmBrowseRecord implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * @author 小林同学
   * @date 2023-09-19
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * 用户id
   *
   * @author 小林同学
   * @date 2023-09-19
   */
  private String uid;

  /**
   * 商品id
   *
   * @author 小林同学
   * @date 2023-09-19
   */
  private String productId;

  /**
   * 日期：年-月-日
   *
   * @author 小林同学
   * @date 2023-09-19
   */
  private String date;

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
