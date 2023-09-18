package net.yiyuan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.enums.SysAreaIsDelEnum;
import net.yiyuan.enums.SysAreaIsShowEnum;
import net.yiyuan.enums.SysAreaLevelEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 区域查询请求响应参数实体
 *
 * @author 一源团队-花和尚
 * @date 2023-09-11
 */
@Data
public class SysAreaQueryVO implements Serializable {

  /**
   * 区域ID
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  private String id;

  /**
   * 父级ID
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  private String pid;

  /**
   * 区域名称
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  private String name;

  /**
   * 排序
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  private Integer sort;

  /**
   * 显示状态#0=不显示|1=显示
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  private SysAreaIsShowEnum isShow;

  /**
   * 是否删除#0=未删除|1=已删除
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  private SysAreaIsDelEnum isDel;

  /**
   * 分类级别#1=一级分类|2=二级分类|3=三级分类|4=四级分类|5=五级分类
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  private SysAreaLevelEnum level;

  /**
   * 创建时间
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  /**
   * 修改时间
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;

  /**
   * 创建人
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  private String updateUser;

  /**
   * 修改人
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  private List<SysAreaQueryVO> child;

  /**
   * 修改人
   *
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  private Boolean isLeaf = false;
}
