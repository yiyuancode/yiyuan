package net.yiyuan.admin.auth.model.vo;

import lombok.Data;

import java.util.List;

/**
 * 菜单转树结构vo
 *
 * @author 一源团队-花和尚
 * @date 2023/06/24
 */
@Data
public class SysMenuTreeForAntdVo {
  private static final long serialVersionUID = 1L;

  /**
   * 菜单ID
   *
   * @date 2023-06-24
   */
  private String id;
  /**
   * 上级菜单
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see String
   */
  private String parentId;
  /**
   * 菜单名称
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see String
   */
  private String router;

  //  /**
  //   * 菜单图标
  //   *
  //   * @see String
  //   * @author 一源团队--花和尚
  //   * @date 2023-06-24
  //   */
  //  private String icon;
  /**
   * 子菜单
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see String
   */
  private List<SysMenuTreeForAntdVo> children;
}
