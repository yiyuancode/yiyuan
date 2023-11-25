package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.SysAreaIsDelEnum;
import net.yiyuan.enums.SysAreaIsShowEnum;
import net.yiyuan.enums.SysAreaLevelEnum;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 行政区域修改接口请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Data
public class SysAreaEditDTO implements Serializable {

  /**
   * 区域ID
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @NotBlank(message = "区域ID不能为空")
  private String id;

  /**
   * 父级ID
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String pid;

  /**
   * 区域名称
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String name;

  /**
   * 排序
   *
   * @mock 0
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private Integer sort;

  /**
   * 显示状态#0=不显示|1=显示
   *
   * @mock 1
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private SysAreaIsShowEnum isShow;

  /**
   * 是否删除#0=未删除|1=已删除
   *
   * @mock 0
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private SysAreaIsDelEnum isDel;

  /**
   * 分类级别#1=一级分类|2=二级分类|3=三级分类|4=四级分类|5=五级分类
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private SysAreaLevelEnum level;
}
