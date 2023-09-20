package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.UmUserRegisterTypeEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UmUserTokenDTO {
    /**
     * 电话或者邮箱
     */
    @NotBlank(message = "电话或者邮箱不能为空")
    private String phoneOrEmail;
    /**
     * 验证码
     */
    @NotBlank(message = "验证码不能为空")
    private String code;
    /**
     * 登录类型，0 手机号 1 邮箱
     */
    @NotBlank(message = "登录类型不能为空")
    private String type;
    /**
     * 用户注册类型#0=公众号|1=小程序|2=H5|3=微信ios|4=微信安卓|5=ios
     */
    @NotNull(message = "注册类型不能为空")
    private UmUserRegisterTypeEnum registryType;

}
