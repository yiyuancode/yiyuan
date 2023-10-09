package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.PtmProductAttrValueAddDTO;
import net.yiyuan.dto.PtmProductAttrValueEditDTO;
import net.yiyuan.dto.PtmProductAttrValueListDTO;
import net.yiyuan.dto.PtmProductAttrValuePageDTO;
import net.yiyuan.service.PtmProductAttrValueService;
import net.yiyuan.vo.PtmProductAttrValueQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;


/**
 * 商品属性value管理
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 * @folder 商品管理/商品属性value管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class PtmProductAttrValueController {
    @Autowired
    private PtmProductAttrValueService ptmProductAttrValueService;

    /**
     * 商品属性value列表(全部)
     *
     * @param request 商品属性value实体
     * @return {@link CommonResult<List<PtmProductAttrValueQueryVO>>}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Description("商品管理/商品属性value管理/查询商品属性value")
    @SaCheckPermission(
            value = {"ptm:productAttrValue:query"},
            orRole = "admin")
    @GetMapping(value = "/ptm/productAttrValue/list")
    @ResponseBody
    public CommonResult<List<PtmProductAttrValueQueryVO>> list(PtmProductAttrValueListDTO request) throws Exception {
        return CommonResult.success(ptmProductAttrValueService.list(request), "查询商品属性value列表成功");
    }

    /**
     * 商品属性value列表(分页)
     *
     * @param request 商品属性value实体
     * @return {@link CommonResult<Page<PtmProductAttrValueQueryVO>>}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Description("商品管理/商品属性value管理/查询商品属性value")
    @SaCheckPermission(
            value = {"ptm:productAttrValue:query"},
            orRole = "admin")
    @GetMapping(value = "/ptm/productAttrValue/page")
    @ResponseBody
    public CommonResult<Page<PtmProductAttrValueQueryVO>> page(PtmProductAttrValuePageDTO request) throws Exception {
        return CommonResult.success(ptmProductAttrValueService.page(request), "分页查询商品属性value成功");
    }

    /**
     * 商品属性value详情
     *
     * @param id 商品属性valueid
     * @return {@link CommonResult<PtmProductAttrValueQueryVO>}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Description("商品管理/商品属性value管理/查询商品属性value")
    @SaCheckPermission(
            value = {"ptm:productAttrValue:query"},
            orRole = "admin")
    @GetMapping(value = "/ptm/productAttrValue/details/{id}")
    @ResponseBody
    public CommonResult<PtmProductAttrValueQueryVO> details(@PathVariable("id") @NotBlank String id)
            throws Exception {
        return CommonResult.success(ptmProductAttrValueService.details(id), "查询商品属性value详情成功");
    }

    /**
     * 删除商品属性value(支持批量)
     *
     * @param ids 商品属性valueid(多个逗号分割)
     * @return {@link CommonResult<String>}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Description("商品管理/商品属性value管理/删除商品属性value")
    @SaCheckPermission(
            value = {"ptm:productAttrValue:delete"},
            orRole = "admin")
    @PostMapping(value = "/ptm/productAttrValue/delete")
    @ResponseBody
    public CommonResult<String> delete(
            @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
        if (ptmProductAttrValueService.delete(ids)) {
            return CommonResult.success(null, "删除商品属性value成功");
        } else {
            return CommonResult.failed("删除商品属性value失败");
        }
    }

    /**
     * 编辑商品属性value
     *
     * @param request 商品属性value实体
     * @return {@link CommonResult<String>}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Description("商品管理/商品属性value管理/编辑商品属性value")
    @SaCheckPermission(
            value = {"ptm:productAttrValue:edit"},
            orRole = "admin")
    @PostMapping(value = "/ptm/productAttrValue/edit")
    @ResponseBody
    public CommonResult<String> edit(@RequestBody @Validated PtmProductAttrValueEditDTO request)
            throws Exception {
        if (ptmProductAttrValueService.edit(request)) {
            return CommonResult.success(null, "修改商品属性value成功");
        } else {
            return CommonResult.failed("修改商品属性value失败");
        }
    }

    /**
     * 新增商品属性value
     *
     * @param request 商品属性value实体
     * @return {@link CommonResult<String>}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Description("商品管理/商品属性value管理/新增商品属性value")
    @SaCheckPermission(
            value = {"ptm:productAttrValue:add"},
            orRole = "admin")
    @PostMapping(value = "/ptm/productAttrValue/add")
    @ResponseBody
    public CommonResult<String> add(@RequestBody @Validated PtmProductAttrValueAddDTO request) throws Exception {
        if (ptmProductAttrValueService.add(request)) {
            return CommonResult.success(null, "新增商品属性value成功");
        } else {
            return CommonResult.failed("新增商品属性value失败");
        }
    }
}
