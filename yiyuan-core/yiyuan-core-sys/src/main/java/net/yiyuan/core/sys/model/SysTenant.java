package net.yiyuan.core.sys.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.core.sys.enums.SysTenantStatusEnum;
import net.yiyuan.plugins.mp.constant.CustomSqlCondition;

import java.io.Serializable;
import java.util.Date;

/**
 * 租户管理实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Data

public class SysTenant implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 租户id
     *
     * @date 2023-07-27
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)


    /**
     * 租户id
     * @see String
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private String id;


    /**
     * 租户名称
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see String
     */
    @TableField(condition = CustomSqlCondition.LIKE)
    private String name;


    /**
     * 租户编号
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see String
     */
    @TableField(condition = CustomSqlCondition.LIKE)
    private String code;


    /**
     * 开始时间
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Date
     */


    private Date startTime;
    /**
     * 开始时间(查询开始时间)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Date
     */
    @TableField(value = "start_time", condition = CustomSqlCondition.START_EQUAL, select = false)
    private Date startTimeStart;
    /**
     * 开始时间(查询结束时间)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Date
     */
    @TableField(value = "start_time", condition = CustomSqlCondition.END_EQUAL, select = false)
    private Date startTimeEnd;


    /**
     * 结束时间
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Date
     */


    private Date endTime;
    /**
     * 结束时间(查询开始时间)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Date
     */
    @TableField(value = "end_time", condition = CustomSqlCondition.START_EQUAL, select = false)
    private Date endTimeStart;
    /**
     * 结束时间(查询结束时间)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Date
     */
    @TableField(value = "end_time", condition = CustomSqlCondition.END_EQUAL, select = false)
    private Date endTimeEnd;


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
     * 状态#0=正常|1=冻结
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Integer
     */
    private SysTenantStatusEnum status;


    /**
     * 租户id
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see String
     */
    @TableField(condition = CustomSqlCondition.LIKE)
    private String tenantId;


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