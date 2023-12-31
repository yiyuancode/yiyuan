package net.yiyuan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 商品属性key分页接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-10
 */
@Data
public class PtmProductAttrKeyPageDTO implements Serializable {
  /**
   * 分页条数
   *
   * @mock 10
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotNull(message = "分页条数不能为空")
  private Integer pageSize = 10;
  /**
   * 分页页数
   *
   * @mock 1
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotNull(message = "分页页数不能为空")
  private Integer pageNum = 1;

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
   * 创建时间(查询开始时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeEnd;

  /**
   * 修改时间(查询开始时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeEnd;
}
