package net.yiyuan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品属性key查询请求响应参数实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-10
 */
@Data
public class PtmProductAttrKeyQueryVO implements Serializable {

  /**
   * 商品属性key主键
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String id;

  /**
   * 商户id
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String tenantId;

  /**
   * 商品分类id
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String ptmProductCategoryId;

  /**
   * 商品属性key
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private String attrKey;

  /**
   * 是否显示0=否|1=是
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  private Boolean isShow;

  /**
   * 创建时间
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  /**
   * 修改时间
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;




}
