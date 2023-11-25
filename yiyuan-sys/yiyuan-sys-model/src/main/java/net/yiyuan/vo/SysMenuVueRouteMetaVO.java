package net.yiyuan.vo;

import lombok.Data;
import net.yiyuan.enums.SysMenuTypeEnum;

import java.io.Serializable;

/**
 * 查询请求响应参数实体
 *
 * @author 一源-花和尚
 * @date 2023-09-26
 */
@Data
public class SysMenuVueRouteMetaVO implements Serializable {

  /**
   * meta部分:菜单名称(中文)
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  private String title;

  /**
   * meta部分:权限表达式
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  private String permission;

  /**
   * meta部分:是否缓存(0=否|1=是)
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  private Boolean isKeepAlive;

  /**
   * meta部分:菜单图标
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  private String icon;

  /**
   * meta部分:是否外链(0=否|1=是)
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  private Boolean isFrame;

  /**
   * meta部分：外链url地址
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  private String frameSrc;

  /**
   * meta部分:类型#0=目录|1=菜单|2=按钮
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  private SysMenuTypeEnum type;

  /**
   * meta部分:是否当前窗口(0=否|1=是)
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  private Boolean isCurWin;

  /**
   * 是否显示(0=否|1=是)
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  private Boolean isShow;

  /**
   * 显示排序
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  private Integer sort;
}
