package net.yiyuan.core.auth.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 角色新增接口请求入参实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Data
public class AuthRoleAddDTO implements Serializable {


    /**
     * 角色中文名称(可以修改)
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */

    @NotBlank(message = "角色中文名称(可以修改)不能为空" )


    private String name;


    /**
     * 角色英文编码(例如Root等，无法修改,satoken会用)唯一性
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */

    @NotBlank(message = "角色英文编码(例如Root等，无法修改,satoken会用)唯一性不能为空" )


    private String code;

    /**
     * 角色备注
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */


    private String roleDesc;



    /**
     * 所属租户
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */


    private String tenantId;


}
