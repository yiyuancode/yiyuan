package net.yiyuan.core.auth.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 角色_菜单分页接口请求入参实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Data
public class AuthRoleMenuPageDTO implements Serializable {
    /**
     * 分页条数
     *
     * @mock 10
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    @NotNull(message = "分页条数不能为空" )
    private Integer pageSize;
    /**
     * 分页页数
     *
     * @mock 1
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    @NotNull(message = "分页页数不能为空" )
    private Integer pageNum;


    /**
     * 主键
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private String id;


    /**
     * 角色ID
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private String roleId;


    /**
     * 菜单ID
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private String menuId;


    /**
     * 修改时间(查询开始时间)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8" )
    private Date updateTimeStart;
    /**
     * 修改时间(查询结束时间)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8" )
    private Date updateTimeEnd;


    /**
     * 创建时间(查询开始时间)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8" )
    private Date createTimeStart;
    /**
     * 创建时间(查询结束时间)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8" )
    private Date createTimeEnd;


    /**
     * 创建人
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private String createUser;


    /**
     * 修改人
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private String updateUser;


}
