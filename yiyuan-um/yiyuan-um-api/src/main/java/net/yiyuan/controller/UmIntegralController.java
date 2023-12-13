package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.UmIntegralPageDTO;
import net.yiyuan.model.UmIntegral;
import net.yiyuan.service.UmIntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 积分
 */
@RequestMapping("/integral")
@Slf4j
@RestController
public class UmIntegralController {

    @Autowired
    private UmIntegralService umIntegralService;

    //积分列表
    @GetMapping("/list")
    @SaCheckPermission(
            value = {"um:UmIntegral:query"},
            orRole = "admin")
    @ResponseBody
    public CommonResult<Page<UmIntegral>> list(UmIntegralPageDTO request)
            throws Exception {
        return CommonResult.success(umIntegralService.list(request), "查询积分列表成功");
    }
//    public CommonResult<List<UmIntegral>> list(UmIntegralPageDTO request)
//            throws Exception {
//        return CommonResult.success(umIntegralService.list(request), "查询积分列表成功");
//    }
}
