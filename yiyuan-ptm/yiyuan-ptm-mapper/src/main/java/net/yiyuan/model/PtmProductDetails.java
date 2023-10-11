package net.yiyuan.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 商品详情实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Data
public class PtmProductDetails implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 商品id
   *
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * 商户id
   *
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  private String tenantId;

  /**
   * 商品id
   *
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  private String ptmProductId;

  /**
   * 商品详情(富文本)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  private String details;
}
