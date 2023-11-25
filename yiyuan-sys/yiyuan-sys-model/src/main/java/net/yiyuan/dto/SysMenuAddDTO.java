package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.SysMenuTypeEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 新增接口请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-09-26
 */
@Data
public class SysMenuAddDTO implements Serializable {

  /**
   * 上级菜单
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @NotBlank(message = "上级菜单不能为空")
  private String pid;

  /**
   * 商户id
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  private String tenantId;

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
  @NotBlank(message = "菜单名称(英文,就是组件的path值，如果组件的path值是顶级,则去掉/开头)不能为空")
  private String name;

  /**
   * 组件路径(顶级统一为/components/layout/Layout/index.vue,子集对应/page,所有级别都以/开头，index.vue可忽略)
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  private String component;

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
  @NotBlank(message = "meta部分:权限表达式不能为空")
  private String permission;

  /**
   * meta部分:是否缓存(0=否|1=是)
   *
   * @mock 1
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @NotNull(message = "meta部分:是否缓存(0=否|1=是)不能为空")
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
   * @mock 1
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @NotNull(message = "meta部分:是否外链(0=否|1=是)不能为空")
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
   * @mock 0
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @NotNull(message = "meta部分:类型#0=目录|1=菜单|2=按钮不能为空")
  private SysMenuTypeEnum type;

  /**
   * meta部分:是否当前窗口(0=否|1=是)
   *
   * @mock 1
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @NotNull(message = "meta部分:是否当前窗口(0=否|1=是)不能为空")
  private Boolean isCurWin;
}
