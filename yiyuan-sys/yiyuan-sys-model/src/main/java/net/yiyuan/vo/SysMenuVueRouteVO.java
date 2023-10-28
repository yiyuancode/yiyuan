package net.yiyuan.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 查询请求响应参数实体
 *
 * @author 一源-花和尚
 * @date 2023-09-26
 */
@Data
public class SysMenuVueRouteVO implements Serializable {

  /**
   * 菜单ID
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  private String id;

  /**
   * 上级菜单
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  private String pid;

  /**
   * 菜单路径(顶级以/开头,子集不能以/开头)
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  private String path;

  /**
   * 菜单名称(英文,就是组件的path值，如果组件的path值是顶级,则去掉/开头)
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  private String name;

  /**
   * 组件路径(顶级统一为/components/layout/Layout/index.vue,子集对应/page,所有级别都以/开头，index.vue可忽略)
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  private String component;

  /**
   * 子集
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  private SysMenuVueRouteMetaVO meta;
}
