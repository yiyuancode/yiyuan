package net.yiyuan.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.common.constatnt.CustomSqlCondition;
import net.yiyuan.enums.FileInfoStateEnum;
import net.yiyuan.enums.FileInfoTypeEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 *
 * @author 一源团队--小林同学
 * @date 2023-07-15
 */
@Data
public class FileInfo implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 唯一标识
   *
   * @date 2023-07-15
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  /**
   * 文件名称
   *
   * @author 一源团队--小林同学
   * @date 2023-07-15
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String fileName;

  /**
   * 存储名称
   *
   * @author 一源团队--小林同学
   * @date 2023-07-15
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String storename;

  /**
   * 文件后缀
   *
   * @author 一源团队--小林同学
   * @date 2023-07-15
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String suffix;

  /**
   * 文件存储地址
   *
   * @author 一源团队--小林同学
   * @date 2023-07-15
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String storeplace;

  /**
   * 入库时间
   *
   * @author 一源团队--小林同学
   * @date 2023-07-15
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date time;
  /**
   * 入库时间(查询开始时间)
   *
   * @author 一源团队--小林同学
   * @date 2023-07-15
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @TableField(value = "created_time", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date timeGte;
  /**
   * 入库时间(查询结束时间)
   *
   * @author 一源团队--小林同学
   * @date 2023-07-15
   * @see Date
   */
  @TableField(value = "created_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date timeLt;

  /**
   * 类型#0=临时|2=储存成功
   *
   * @author 一源团队--小林同学
   * @date 2023-07-15
   * @see String
   */
  private FileInfoStateEnum state;

  /**
   * 类型#0=本地服务器|1=fastdfs|2=华为云存储
   *
   * @author 一源团队--小林同学
   * @date 2023-07-15
   * @see String
   */
  private FileInfoTypeEnum type;

  /**
   * 创建时间
   *
   * @author 一源团队--小林同学
   * @date 2023-07-15
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  /**
   * 创建时间(查询开始时间)
   *
   * @author 一源团队--小林同学
   * @date 2023-07-15
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @TableField(value = "created_time", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date createTimeGte;
  /**
   * 创建时间(查询结束时间)
   *
   * @author 一源团队--小林同学
   * @date 2023-07-15
   * @see Date
   */
  @TableField(value = "created_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTimeLt;

  /**
   * 创建时间
   *
   * @author 一源团队--小林同学
   * @date 2023-07-15
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
  /**
   * 创建时间(查询开始时间)
   *
   * @author 一源团队--小林同学
   * @date 2023-07-15
   * @see Date
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @TableField(value = "created_time", condition = CustomSqlCondition.START_EQUAL, select = false)
  private Date updateTimeGte;
  /**
   * 创建时间(查询结束时间)
   *
   * @author 一源团队--小林同学
   * @date 2023-07-15
   * @see Date
   */
  @TableField(value = "created_time", condition = CustomSqlCondition.END_EQUAL, select = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTimeLt;

  /**
   * 创建人
   *
   * @author 一源团队--小林同学
   * @date 2023-07-15
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String createUser;

  /**
   * 修改人
   *
   * @author 一源团队--小林同学
   * @date 2023-07-15
   * @see String
   */
  @TableField(condition = CustomSqlCondition.LIKE)
  private String updateUser;
}
