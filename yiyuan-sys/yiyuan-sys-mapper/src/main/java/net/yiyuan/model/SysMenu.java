package net.yiyuan.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.common.constatnt.CustomSqlCondition;
import net.yiyuan.enums.SysMenuTypeEnum;

import java.io.Serializable;
import java.util.Date;
/**
 * 实体
 *
 * @author 一源-花和尚
 * @date 2023-09-26
 */
@Data
public class SysMenu implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 菜单ID
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
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
   * 显示排序
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  private Integer sort;

  /**
   * 创建时间
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  /**
   * 创建时间(查询开始时间)
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @TableField(value = "create_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date createTimeStart;
  /**
   * 创建时间(查询结束时间)
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @TableField(value = "create_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date createTimeEnd;

  /**
   * 修改时间
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
  /**
   * 修改时间(查询开始时间)
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @TableField(value = "update_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date updateTimeStart;
  /**
   * 修改时间(查询结束时间)
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @TableField(value = "update_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  private Date updateTimeEnd;

  /**
   * 创建人
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @TableField(fill = FieldFill.INSERT)
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private String updateUser;
}
