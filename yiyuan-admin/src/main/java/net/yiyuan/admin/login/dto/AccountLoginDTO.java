package net.yiyuan.admin.login.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 账号密码登录接口请求入参实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Data
public class AccountLoginDTO implements Serializable {


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


}
