package net.yiyuan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.enums.SysMenuTypeEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 列表接口请求入参实体
 *
 * @author 一源-花和尚
 * @date 2023-09-26
 */
@Data
public class SysMenuListDTO implements Serializable {

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
   * 创建时间(查询开始时间)
   *
   * @see Date
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @see Date
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeEnd;

  /**
   * 修改时间(查询开始时间)
   *
   * @see Date
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @see Date
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeEnd;

  /**
   * 创建人
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  private String updateUser;
}
