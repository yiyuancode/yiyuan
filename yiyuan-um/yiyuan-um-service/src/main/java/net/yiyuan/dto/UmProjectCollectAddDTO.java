package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 浏览记录新增接口请求入参实体
 *
 * @author 小林同学
 * @date 2023-09-21
 */
@Data
public class UmProjectCollectAddDTO implements Serializable {

  /**
   * 用户id
   *
   * @mock 0
   * @author 小林同学
   * @date 2023-09-21
   */
  @NotBlank(message = "用户id不能为空")
  private String uid;

  /**
   * 商品id
   *
   * @mock 0
   * @author 小林同学
   * @date 2023-09-21
   */
  @NotBlank(message = "商品id不能为空")
  private String productId;

  /**
   * 日期：年-月-日
   *
   * @author 小林同学
   * @date 2023-09-21
   */
  @NotBlank(message = "日期：年-月-日不能为空")
  private String date;
}
