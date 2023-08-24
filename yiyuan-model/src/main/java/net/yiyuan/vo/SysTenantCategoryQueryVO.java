package net.yiyuan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 租户店铺分类查询请求响应参数实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
@Data
public class SysTenantCategoryQueryVO implements Serializable {

  /**
   * 店铺类型id
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String id;

  /**
   * 店铺分类名称
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String name;

  /**
   * 店铺分类描述
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String desc;

  /**
   * 删除标记
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private Byte idDel;

  /**
   * 创建时间
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  /**
   * 更新时间
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;

  /**
   * 创建人
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  private String updateUser;
}
