package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 商品sku新增接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-10
 */
@Data
public class PtmProductSkuMakeSkuTempListDTO implements Serializable {

  /**
   * 属性key集合
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotNull(message = "属性key集合不能为空")
  private List<String> attrKeyList;

  /**
   * 属性value集合
   *
   * @mock 0
   * @author 一源团队-花和尚
   * @date 2023-10-10
   */
  @NotNull(message = "属性value集合不能为空")
  private List<List<String>> attrValList;
}
