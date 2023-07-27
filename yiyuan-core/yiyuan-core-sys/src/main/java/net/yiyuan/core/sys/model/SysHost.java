package net.yiyuan.core.sys.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.core.sys.enums.SysHostIsMonitorEnabledEnum;
import net.yiyuan.plugins.mp.constant.CustomSqlCondition;

import java.io.Serializable;
import java.util.Date;

/**
 * 主机记录管理实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Data

public class SysHost implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     *
     * @date 2023-07-27
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)


    /**
     * 主键ID
     * @see String
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private String id;


    /**
     * 主机名
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see String
     */
    @TableField(condition = CustomSqlCondition.LIKE)
    private String hostName;


    /**
     * IP地址
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see String
     */
    @TableField(condition = CustomSqlCondition.LIKE)
    private String host;


    private Integer sshPort;


    /**
     * SSH登录用户名
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see String
     */
    @TableField(condition = CustomSqlCondition.LIKE)
    private String sshUsername;


    /**
     * SSH登录密码
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see String
     */
    @TableField(condition = CustomSqlCondition.LIKE)
    private String sshPassword;


    /**
     * 开启监控#0=开启|1=关闭|
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Integer
     */
    private SysHostIsMonitorEnabledEnum isMonitorEnabled;


    private Integer sortBy;


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


    /**
     * 创建人
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see String
     */
    @TableField(condition = CustomSqlCondition.LIKE)
    private String createUser;


    /**
     * 修改人
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see String
     */
    @TableField(condition = CustomSqlCondition.LIKE)
    private String updateUser;


}