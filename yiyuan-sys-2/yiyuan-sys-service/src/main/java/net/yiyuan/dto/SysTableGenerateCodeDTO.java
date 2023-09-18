package net.yiyuan.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 数据库列表接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-08-25
 */
@Data
public class SysTableGenerateCodeDTO implements Serializable {

  /**
   * 数据库表id
   *
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  private String ids;

  /**
   * 根包名,例如:net.yiyuan
   *
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  private String parentPackageName;

  /**
   * 一级目录名称,例如：系统管理：
   *
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  private String firstLevelMenuZh;

  /**
   * 作者
   *
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  private String author;
}
