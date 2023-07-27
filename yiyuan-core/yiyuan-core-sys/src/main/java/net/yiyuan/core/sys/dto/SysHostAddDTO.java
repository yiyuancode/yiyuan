package net.yiyuan.core.sys.dto;

import lombok.Data;
import net.yiyuan.core.sys.enums.SysHostIsMonitorEnabledEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 主机记录新增接口请求入参实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Data
public class SysHostAddDTO implements Serializable {
    
    
    /**
     * 主机名
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    @NotBlank(message = "主机名不能为空" )
    
    
    private String hostName;
    
    
    /**
     * IP地址
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    @NotBlank(message = "IP地址不能为空" )
    
    
    private String host;
    
    
    /**
     * SSH端口
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    @NotNull(message = "SSH端口不能为空" )
    
    
    private Integer sshPort;
    
    
    /**
     * SSH登录用户名
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    @NotBlank(message = "SSH登录用户名不能为空" )
    
    
    private String sshUsername;
    
    
    /**
     * SSH登录密码
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    @NotBlank(message = "SSH登录密码不能为空" )
    
    
    private String sshPassword;
    
    
    /**
     * 开启监控#0=开启|1=关闭|
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    @NotNull(message = "开启监控#0=开启|1=关闭|不能为空" )
    
    
    private SysHostIsMonitorEnabledEnum isMonitorEnabled;
    
    
    /**
     * 排序字段
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    
    private Integer sortBy;
    
    
}
