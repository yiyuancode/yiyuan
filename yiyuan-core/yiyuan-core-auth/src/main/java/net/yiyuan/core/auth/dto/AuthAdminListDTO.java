package net.yiyuan.core.auth.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.core.auth.enums.AuthAdminPlatformEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户列表接口请求入参实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Data
public class AuthAdminListDTO implements Serializable {
    
    
    /**
     * 主键ID
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private String id;
    
    
    /**
     * 用户名
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private String username;
    
    
    /**
     * 密码
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private String password;
    
    
    /**
     * 随机盐
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private String salt;
    
    
    /**
     * 部门ID
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private Integer deptId;
    
    
    /**
     * 小程序openid
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private String miniOpenid;
    
    
    /**
     * 码云登录
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private String giteeLogin;
    
    
    /**
     * 开源中国
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private String oscId;
    
    
    /**
     * 微信openid
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private String wxOpenid;
    
    
    /**
     * QQ openid
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private String qqOpenid;
    
    
    /**
     * 平台类型#0=平台端|1=租户端|2=移动端
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private AuthAdminPlatformEnum platform;
    
    
    /**
     * 所属租户
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private String tenantId;
    
    
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
