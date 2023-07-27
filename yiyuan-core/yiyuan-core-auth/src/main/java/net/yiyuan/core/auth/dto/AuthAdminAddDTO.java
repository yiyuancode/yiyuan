package net.yiyuan.core.auth.dto;

import lombok.Data;
import net.yiyuan.core.auth.enums.AuthAdminPlatformEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户新增接口请求入参实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Data
public class AuthAdminAddDTO implements Serializable {
    
    
    /**
     * 用户名
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    @NotBlank(message = "用户名不能为空" )
    
    
    private String username;
    
    
    /**
     * 密码
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    @NotBlank(message = "密码不能为空" )
    
    
    private String password;
    
    
    
    /**
     * 平台类型#0=平台端|1=租户端|2=移动端
     *
     * @mock 0
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    @NotNull(message = "平台类型#0=平台端|1=租户端|2=移动端不能为空" )
    
    
    private AuthAdminPlatformEnum platform;
    
    
    /**
     * 所属租户
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    
    private String tenantId;
    
    
}
