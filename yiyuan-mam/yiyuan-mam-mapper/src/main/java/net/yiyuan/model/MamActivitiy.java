package net.yiyuan.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.common.constatnt.CustomSqlCondition;

import java.io.Serializable;
import java.util.Date;

/**
 * 营销活动实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Data
public class MamActivitiy implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 活动id
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;


    /**
     * 商户id
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String tenantId;


    /**
     * 活动名称
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String name;


    /**
     * 开始时间
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    private Date startTime;
    /**
     * 开始时间(查询开始时间)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @TableField(value = "start_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
    private Date startTimeStart;
    /**
     * 开始时间(查询结束时间)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @TableField(value = "start_time", condition = CustomSqlCondition.END_EQUAL, select = false)
    private Date startTimeEnd;


    /**
     * 结束时间
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    private Date endTime;
    /**
     * 结束时间(查询开始时间)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @TableField(value = "end_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
    private Date endTimeStart;
    /**
     * 结束时间(查询结束时间)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @TableField(value = "end_time", condition = CustomSqlCondition.END_EQUAL, select = false)
    private Date endTimeEnd;


    /**
     * 是否显示0=否|1=是
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private Boolean isShow;


    /**
     * 创建时间
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @TableField(fill = FieldFill.INSERT)

    private Date createTime;
    /**
     * 创建时间(查询开始时间)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @TableField(value = "create_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
    private Date createTimeStart;
    /**
     * 创建时间(查询结束时间)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @TableField(value = "create_time", condition = CustomSqlCondition.END_EQUAL, select = false)
    private Date createTimeEnd;


    /**
     * 修改时间
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)

    private Date updateTime;
    /**
     * 修改时间(查询开始时间)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @TableField(value = "update_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
    private Date updateTimeStart;
    /**
     * 修改时间(查询结束时间)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @TableField(value = "update_time", condition = CustomSqlCondition.END_EQUAL, select = false)
    private Date updateTimeEnd;


    /**
     * 创建人
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @TableField(fill = FieldFill.INSERT)
    private String createUser;


    /**
     * 修改人
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateUser;


}
