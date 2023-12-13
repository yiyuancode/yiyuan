package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.UmIntegralPageDTO;
import net.yiyuan.model.UmIntegral;
import net.yiyuan.service.UmIntegralAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

@Slf4j
@SaCheckLogin
@RestController
@RequestMapping("/integral")
public class UmIntegralAppController {

    @Autowired
    private UmIntegralAppService umIntegralAppService;

    /**
     * 积分签到
     *
     * @return
     */
    @SaCheckLogin
    @Description("用户管理/积分/签到")
    @GetMapping("/sign")
    public CommonResult dailySign(UmIntegral umIntegral) throws Exception {
        if (umIntegralAppService.add(umIntegral)) {
            return CommonResult.success(null, "积分签到成功");

        } else {
            return CommonResult.failed("今天已经签到，请明天再来！");

        }
    }

    /**
     * 当前用户积分记录
     * @return
     */
    @SaCheckLogin
    @Description("用户管理/积分/积分记录")
    @ResponseBody
    @GetMapping("/list")
    public CommonResult<Page<UmIntegral>> page(UmIntegralPageDTO request)
            throws Exception {
        return CommonResult.success(umIntegralAppService.page(request), "分页查询积分成功");
    }
}
