package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.PtmProductCategoryPlatLevelEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 平台商品分类新增接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-11-19
 */
@Data
public class PtmProductCategoryPlatAddDTO implements Serializable {

  /**
   * 父id
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  private String pid;

  /**
   * 分类名称
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @NotBlank(message = "分类名称不能为空")
  private String name;

  /**
   * 图标
   *
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  private String icon;

  /**
   * 是否显示0=否|1=是
   *
   * @mock 1
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @NotNull(message = "是否显示0=否|1=是不能为空")
  private Boolean isShow;
}
