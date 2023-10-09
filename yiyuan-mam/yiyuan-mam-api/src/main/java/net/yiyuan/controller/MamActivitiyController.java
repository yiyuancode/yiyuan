package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.MamActivitiyAddDTO;
import net.yiyuan.dto.MamActivitiyEditDTO;
import net.yiyuan.dto.MamActivitiyListDTO;
import net.yiyuan.dto.MamActivitiyPageDTO;
import net.yiyuan.service.MamActivitiyService;
import net.yiyuan.vo.MamActivitiyQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;


/**
 * 营销活动管理
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 * @folder 营销管理/营销活动管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class MamActivitiyController {
    @Autowired
    private MamActivitiyService mamActivitiyService;

    /**
     * 营销活动列表(全部)
     *
     * @param request 营销活动实体
     * @return {@link CommonResult<List<MamActivitiyQueryVO>>}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Description("营销管理/营销活动管理/查询营销活动")
    @SaCheckPermission(
            value = {"mam:activitiy:query"},
            orRole = "admin")
    @GetMapping(value = "/mam/activitiy/list")
    @ResponseBody
    public CommonResult<List<MamActivitiyQueryVO>> list(MamActivitiyListDTO request) throws Exception {
        return CommonResult.success(mamActivitiyService.list(request), "查询营销活动列表成功");
    }

    /**
     * 营销活动列表(分页)
     *
     * @param request 营销活动实体
     * @return {@link CommonResult<Page<MamActivitiyQueryVO>>}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Description("营销管理/营销活动管理/查询营销活动")
    @SaCheckPermission(
            value = {"mam:activitiy:query"},
            orRole = "admin")
    @GetMapping(value = "/mam/activitiy/page")
    @ResponseBody
    public CommonResult<Page<MamActivitiyQueryVO>> page(MamActivitiyPageDTO request) throws Exception {
        return CommonResult.success(mamActivitiyService.page(request), "分页查询营销活动成功");
    }

    /**
     * 营销活动详情
     *
     * @param id 营销活动id
     * @return {@link CommonResult<MamActivitiyQueryVO>}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Description("营销管理/营销活动管理/查询营销活动")
    @SaCheckPermission(
            value = {"mam:activitiy:query"},
            orRole = "admin")
    @GetMapping(value = "/mam/activitiy/details/{id}")
    @ResponseBody
    public CommonResult<MamActivitiyQueryVO> details(@PathVariable("id") @NotBlank String id)
            throws Exception {
        return CommonResult.success(mamActivitiyService.details(id), "查询营销活动详情成功");
    }

    /**
     * 删除营销活动(支持批量)
     *
     * @param ids 营销活动id(多个逗号分割)
     * @return {@link CommonResult<String>}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Description("营销管理/营销活动管理/删除营销活动")
    @SaCheckPermission(
            value = {"mam:activitiy:delete"},
            orRole = "admin")
    @PostMapping(value = "/mam/activitiy/delete")
    @ResponseBody
    public CommonResult<String> delete(
            @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
        if (mamActivitiyService.delete(ids)) {
            return CommonResult.success(null, "删除营销活动成功");
        } else {
            return CommonResult.failed("删除营销活动失败");
        }
    }

    /**
     * 编辑营销活动
     *
     * @param request 营销活动实体
     * @return {@link CommonResult<String>}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Description("营销管理/营销活动管理/编辑营销活动")
    @SaCheckPermission(
            value = {"mam:activitiy:edit"},
            orRole = "admin")
    @PostMapping(value = "/mam/activitiy/edit")
    @ResponseBody
    public CommonResult<String> edit(@RequestBody @Validated MamActivitiyEditDTO request)
            throws Exception {
        if (mamActivitiyService.edit(request)) {
            return CommonResult.success(null, "修改营销活动成功");
        } else {
            return CommonResult.failed("修改营销活动失败");
        }
    }

    /**
     * 新增营销活动
     *
     * @param request 营销活动实体
     * @return {@link CommonResult<String>}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Description("营销管理/营销活动管理/新增营销活动")
    @SaCheckPermission(
            value = {"mam:activitiy:add"},
            orRole = "admin")
    @PostMapping(value = "/mam/activitiy/add")
    @ResponseBody
    public CommonResult<String> add(@RequestBody @Validated MamActivitiyAddDTO request) throws Exception {
        if (mamActivitiyService.add(request)) {
            return CommonResult.success(null, "新增营销活动成功");
        } else {
            return CommonResult.failed("新增营销活动失败");
        }
    }
}
