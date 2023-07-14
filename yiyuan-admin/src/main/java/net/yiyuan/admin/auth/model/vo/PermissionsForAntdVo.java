package net.yiyuan.admin.auth.model.vo;

import lombok.Data;

import java.util.List;

/**
 * 权限响应实体(ForAntd)
 *
 * @author 一源团队-花和尚
 * @date 2023/06/24
 */
@Data
public class PermissionsForAntdVo {
  /**
   * 目录或者页面权限表达式
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see String
   */
  private String id;
  /**
   * 操作表达式数组
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see String
   */
  private List<String> operation;
  /**
   * 操作表达式数组子集
   *
   * @author 一源团队--花和尚
   * @date 2023-06-24
   * @see String
   */
  private List<PermissionsForAntdVo> subMenuList;
  //  /**
  //   * 有参构造
  //   *
  //   * @see String
  //   * @author 一源团队--花和尚
  //   * @date 2023-06-24
  //   */
  //  public PermissionsForAntdVo(String id, List<String> operation) {
  //    this.id = id;
  //    this.operation = operation;
  //  }
}
