package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.UmIntegralAddDTO;
import net.yiyuan.dto.UmIntegralEditDTO;
import net.yiyuan.dto.UmIntegralListDTO;
import net.yiyuan.dto.UmIntegralPageDTO;
import net.yiyuan.model.UmIntegral;
import net.yiyuan.vo.UmIntegralQueryVO;

import net.yiyuan.service.UmIntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;


/**
 * 积分管理
 *
 * @author  spring
 * @date 2023-12-19
 * @folder 积分管理/积分管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class UmIntegralController {
    @Autowired
    private UmIntegralService  umIntegralService;

    /**
     * 积分列表(全部)
     *
     * @param request 积分实体
     * @return {@link CommonResult<List<UmIntegralQueryVO>>}
     * @author  spring
     * @date 2023-12-19
     */
    @Description("积分管理/积分管理/查询积分")
    @SaCheckPermission(
            value = {"um:integral:query" },
            orRole = "admin")
    @GetMapping(value = "/um/integral/list")
    @ResponseBody
    public CommonResult<List<UmIntegralQueryVO>> list(UmIntegralListDTO request) throws Exception {
        return CommonResult.success(umIntegralService.list(request), "查询积分列表成功");
    }

    /**
     * 积分列表(分页)
     *
     * @param request 积分实体
     * @return {@link CommonResult<Page<UmIntegralQueryVO>>}
     * @author  spring
     * @date 2023-12-19
     */
    @Description("积分管理/积分管理/查询积分")
    @SaCheckPermission(
            value = {"um:integral:query" },
            orRole = "admin")
    @GetMapping(value = "/um/integral/page")
    @ResponseBody
    public CommonResult<Page<UmIntegralQueryVO>> page(UmIntegralPageDTO request) throws Exception {
        return CommonResult.success(umIntegralService.page(request), "分页查询积分成功");
    }

    /**
     * 积分详情
     *
     * @param id 积分id
     * @return {@link CommonResult<UmIntegralQueryVO>}
     * @author  spring
     * @date 2023-12-19
     */
    @Description("积分管理/积分管理/查询积分")
    @SaCheckPermission(
            value = {"um:integral:query" },
            orRole = "admin")
    @GetMapping(value = "/um/integral/details/{id}")
    @ResponseBody
    public CommonResult<UmIntegralQueryVO> details(@PathVariable("id") @NotBlank String id)
            throws Exception {
        return CommonResult.success(umIntegralService.details(id), "查询积分详情成功");
    }

    /**
     * 删除积分(支持批量)
     *
     * @param ids 积分id(多个逗号分割)
     * @return {@link CommonResult<String>}
     * @author  spring
     * @date 2023-12-19
     */
    @Description("积分管理/积分管理/删除积分")
    @SaCheckPermission(
            value = {"um:integral:delete" },
            orRole = "admin")
    @PostMapping(value = "/um/integral/delete")
    @ResponseBody
    public CommonResult<String> delete(
            @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
        if (umIntegralService.delete(ids)) {
            return CommonResult.success(null, "删除积分成功");
        } else {
            return CommonResult.failed("删除积分失败");
        }
    }

    /**
     * 编辑积分
     *
     * @param request 积分实体
     * @return {@link CommonResult<String>}
     * @author  spring
     * @date 2023-12-19
     */
    @Description("积分管理/积分管理/编辑积分")
    @SaCheckPermission(
            value = {"um:integral:edit" },
            orRole = "admin")
    @PostMapping(value = "/um/integral/edit")
    @ResponseBody
    public CommonResult<String> edit(@RequestBody @Validated UmIntegralEditDTO request)
            throws Exception {
        if (umIntegralService.edit(request)) {
            return CommonResult.success(null, "修改积分成功");
        } else {
            return CommonResult.failed("修改积分失败");
        }
    }

    /**
     * 新增积分
     *
     * @param request 积分实体
     * @return {@link CommonResult<String>}
     * @author  spring
     * @date 2023-12-19
     */
    @Description("积分管理/积分管理/新增积分")
    @SaCheckPermission(
            value = {"um:integral:add" },
            orRole = "admin")
    @PostMapping(value = "/um/integral/add")
    @ResponseBody
    public CommonResult<String> add(@RequestBody @Validated UmIntegralAddDTO request) throws Exception {
        if (umIntegralService.add(request)) {
            return CommonResult.success(null, "新增积分成功");
        } else {
            return CommonResult.failed("新增积分失败");
        }
    }
}
