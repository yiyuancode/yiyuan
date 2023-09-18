package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaIgnore;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.UmUserTokenDTO;
import net.yiyuan.service.UmUserAppService;
import net.yiyuan.vo.GetUmUserInfoVO;
import net.yiyuan.vo.UmUserTokenVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户移动端接口
 *
 * @author 小林同学
 * @date 2023-09-18
 * @folder 用户管理/用户移动端接口
 */
@Slf4j
@SaCheckLogin
@RestController
public class UmUserAppController {
    @Autowired
    private UmUserAppService umUserAppService;


    @SaIgnore
    @PostMapping(value = "/login/umUser")
    @ResponseBody
    public CommonResult<UmUserTokenVO> accountLogin(@RequestBody @Validated UmUserTokenDTO umUserTokenDto)
            throws Exception {
        return CommonResult.success(umUserAppService.getUmUserToken(umUserTokenDto), "用户登录成功");
    }

    /**
     * 获取用户信息
     *
     * @return {@link CommonResult<GetUmUserInfoVO>}
     * @author ${author}
     * @date 2023-07-27
     */
    @GetMapping(value = "/login/getUserInfo")
    @ResponseBody
    public CommonResult<GetUmUserInfoVO> getUserInfo() throws Exception {
        return CommonResult.success(umUserAppService.getUmUserInfo(), "获取用户信息成功");
    }

}
