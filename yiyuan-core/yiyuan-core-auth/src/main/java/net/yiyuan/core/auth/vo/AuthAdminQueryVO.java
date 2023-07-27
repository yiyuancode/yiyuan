package net.yiyuan.core.auth.vo;

import cn.hutool.core.lang.tree.Tree;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.core.auth.enums.AuthAdminPlatformEnum;
import net.yiyuan.core.auth.model.AuthRole;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户查询请求响应参数实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Data
public class AuthAdminQueryVO implements Serializable {
    
    
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
     * 创建时间
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8" )
    private Date createTime;
    
    
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
    
    
    /**
     * 对应角色信息
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private List<AuthRole> roleList;
    
    /**
     * 对应菜单权限信息
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    private List<Tree<String>> menuList;
    
    
}