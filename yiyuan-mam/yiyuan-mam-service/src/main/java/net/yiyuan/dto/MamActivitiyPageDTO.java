package net.yiyuan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 营销活动分页接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Data
public class MamActivitiyPageDTO implements Serializable {
    /**
     * 分页条数
     *
     * @mock 10
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @NotNull(message = "分页条数不能为空")
    private Integer pageSize = 10;
    /**
     * 分页页数
     *
     * @mock 1
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @NotNull(message = "分页页数不能为空")
    private Integer pageNum= 1;


    /**
     * 活动id
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
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
     * 开始时间(查询开始时间)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTimeStart;
    /**
     * 开始时间(查询结束时间)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTimeEnd;


    /**
     * 结束时间(查询开始时间)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTimeStart;
    /**
     * 结束时间(查询结束时间)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTimeEnd;


    /**
     * 是否显示0=否|1=是
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private Boolean isShow;


    /**
     * 创建时间(查询开始时间)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTimeStart;
    /**
     * 创建时间(查询结束时间)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTimeEnd;


    /**
     * 修改时间(查询开始时间)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTimeStart;
    /**
     * 修改时间(查询结束时间)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTimeEnd;


    /**
     * 创建人
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String createUser;


    /**
     * 修改人
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String updateUser;


}
