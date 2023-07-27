package net.yiyuan.core.auth.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.plugins.mp.constant.CustomSqlCondition;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户管理实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Data

public class AuthAdmin implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     *
     * @date 2023-07-27
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)


    private String id;


    @TableField(condition = CustomSqlCondition.LIKE)
    private String username;


    @TableField(condition = CustomSqlCondition.LIKE)
    private String password;


    @TableField(condition = CustomSqlCondition.LIKE)
    private String salt;


    private Integer deptId;


    @TableField(condition = CustomSqlCondition.LIKE)
    private String miniOpenid;


    @TableField(condition = CustomSqlCondition.LIKE)
    private String giteeLogin;


    @TableField(condition = CustomSqlCondition.LIKE)
    private String oscId;


    @TableField(condition = CustomSqlCondition.LIKE)
    private String wxOpenid;


    @TableField(condition = CustomSqlCondition.LIKE)
    private String qqOpenid;


    @TableField(condition = CustomSqlCondition.LIKE)
    private String tenantId;


    /**
     * 创建时间
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Date
     */

    @TableField(fill = FieldFill.INSERT)

    private Date createTime;
    /**
     * 创建时间(查询开始时间)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Date
     */
    @TableField(value = "create_time", condition = CustomSqlCondition.START_EQUAL, select = false)
    private Date createTimeStart;
    /**
     * 创建时间(查询结束时间)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Date
     */
    @TableField(value = "create_time", condition = CustomSqlCondition.END_EQUAL, select = false)
    private Date createTimeEnd;


    /**
     * 修改时间
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Date
     */

    @TableField(fill = FieldFill.INSERT_UPDATE)

    private Date updateTime;
    /**
     * 修改时间(查询开始时间)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Date
     */
    @TableField(value = "update_time", condition = CustomSqlCondition.START_EQUAL, select = false)
    private Date updateTimeStart;
    /**
     * 修改时间(查询结束时间)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Date
     */
    @TableField(value = "update_time", condition = CustomSqlCondition.END_EQUAL, select = false)
    private Date updateTimeEnd;


    @TableField(condition = CustomSqlCondition.LIKE)
    private String createUser;


    @TableField(condition = CustomSqlCondition.LIKE)
    private String updateUser;


}