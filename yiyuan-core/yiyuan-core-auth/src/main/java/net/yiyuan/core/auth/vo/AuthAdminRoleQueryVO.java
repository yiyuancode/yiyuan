package net.yiyuan.core.auth.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户_角色查询请求响应参数实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Data
public class AuthAdminRoleQueryVO implements Serializable {


    /**
     * 主键
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private String id;


    /**
     * 用户ID
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private String userId;


    /**
     * 角色ID
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private String roleId;


    /**
     * 修改时间
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8" )
    private Date updateTime;


    /**
     * 租户id
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private String tenantId;


    /**
     * 创建时间
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8" )
    private Date createTime;


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