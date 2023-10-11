package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 商品信息新增接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-10
 */
@Data
public class PtmProductGetPageListDTO implements Serializable {

  /**
   * 分页条数
   *
   * @mock 10
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @NotNull(message = "分页条数不能为空")
  private Integer pageSize;
  /**
   * 分页页数
   *
   * @mock 1
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @NotNull(message = "分页页数不能为空")
  private Integer pageNum;

  /**
   * 主类目id(商品分类2级id，逗号拼接)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotBlank(message = "主类目id(商品分类2级id，逗号拼接)不能为空")
  private String tenantCategoryId;
}
