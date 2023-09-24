package net.yiyuan.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import net.yiyuan.enums.SysUserPlatformEnum;

import java.io.Serializable;

/**
 * 管理端用户查询请求响应参数实体
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Data
public class SysUserExcelVO implements Serializable {

  /**
   * 主键ID
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Excel(name = "主键ID")
  private String id;

  /**
   * 商户id
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Excel(name = "商户id")
  private String tenantId;

  /**
   * 用户名
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Excel(name = "用户名")
  private String username;

  /**
   * 密码
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private String password;

  /**
   * 平台类型#0=平台端|1=租户端|2=移动端
   *
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  private SysUserPlatformEnum platform;

  //  /**
  //   * 创建时间
  //   *
  //   * @author 一源-花和尚
  //   * @date 2023-09-18
  //   */
  //  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  //  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  //  private Date createTime;
  //
  //  /**
  //   * 修改时间
  //   *
  //   * @author 一源-花和尚
  //   * @date 2023-09-18
  //   */
  //  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  //  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  //  private Date updateTime;
  //
  //  /**
  //   * 创建人
  //   *
  //   * @author 一源-花和尚
  //   * @date 2023-09-18
  //   */
  //  private String createUser;
  //
  //  /**
  //   * 修改人
  //   *
  //   * @author 一源-花和尚
  //   * @date 2023-09-18
  //   */
  //  private String updateUser;
  //
  //  /**
  //   * 关联角色
  //   *
  //   * @author 一源-花和尚
  //   * @date 2023-09-18
  //   */
  //  private List<SysRole> rolesList;
}
