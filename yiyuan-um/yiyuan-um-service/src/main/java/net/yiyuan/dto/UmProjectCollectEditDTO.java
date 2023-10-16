package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 浏览记录修改接口请求入参实体
 *
 * @author 小林同学
 * @date 2023-09-21
 */
@Data
public class UmProjectCollectEditDTO implements Serializable {

  /**
   * @author 小林同学
   * @date 2023-09-21
   */
  @NotBlank(message = "不能为空")
  private String id;

  /**
   * 用户id
   *
   * @mock 0
   * @author 小林同学
   * @date 2023-09-21
   */
  private String uid;

  /**
   * 商品id
   *
   * @mock 0
   * @author 小林同学
   * @date 2023-09-21
   */
  private String productId;

  /**
   * 日期：年-月-日
   *
   * @author 小林同学
   * @date 2023-09-21
   */
  private String date;
}
