package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaIgnore;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.UmUserTokenDTO;
import net.yiyuan.service.UmUserAppService;
import net.yiyuan.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    /**
     * 用户登录接口
     *
     * @param umUserTokenDto
     * @return
     * @throws Exception
     */
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
    @GetMapping(value = "/login/getUserInfo/um")
    @ResponseBody
    public CommonResult<GetUmUserInfoVO> getUserInfo() throws Exception {
        return CommonResult.success(umUserAppService.getUmUserInfo(), "获取用户信息成功");
    }

    /**
     * 获取我的个人页面参数
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/login/finMyself")
    @SaIgnore
    @ResponseBody
    public CommonResult<MyselfIndexVO> findMySelfIndexVO() throws Exception {

        return CommonResult.success(umUserAppService.findMySelfIndexVO(), "我的详情查询成功");
    }

    /**
     * 用户商品收藏
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/collect/commodity")
    @SaIgnore
    @ResponseBody
    public CommonResult<Map<String,List<ProjectCollectReVO>>> collectCommodity() throws Exception {

        return CommonResult.success(umUserAppService.finProjectCollectListVO(), "我的收藏少商品查询成功");
    }

    /**
     * 用户商店收藏
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/collect/shop")
    @SaIgnore
    @ResponseBody
    public CommonResult<Map<String,List<ProjectCollectReShopVO>>> collectShop() throws Exception {

        return CommonResult.success(umUserAppService.findProjectCollectListShopVO(), "我的收藏商铺查询成功");
    }


}
