package net.yiyuan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.enums.SpmShopMainCategoryIsDelEnum;
import net.yiyuan.enums.SpmShopMainCategoryIsShowEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 店铺主营类目列表接口请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-09-22
 */
@Data
public class SpmShopMainCategoryListDTO implements Serializable {

  /**
   * 主营类目id
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String id;

  /**
   * 主营类目名称
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String name;

  /**
   * 主营类目手续费
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private BigDecimal fee;

  /**
   * 显示状态#0=不显示|1=显示
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private SpmShopMainCategoryIsShowEnum isShow;

  /**
   * 是否删除#0=未删除|1=已删除
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private SpmShopMainCategoryIsDelEnum isDel;

  /**
   * 创建时间(查询开始时间)
   *
   * @see Date
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @see Date
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeEnd;

  /**
   * 修改时间(查询开始时间)
   *
   * @see Date
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @see Date
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeEnd;

  /**
   * 创建人
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  private String updateUser;
}
