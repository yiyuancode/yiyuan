package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.PtmProductAttrKeyAddDTO;
import net.yiyuan.dto.PtmProductAttrKeyEditDTO;
import net.yiyuan.dto.PtmProductAttrKeyListDTO;
import net.yiyuan.dto.PtmProductAttrKeyPageDTO;
import net.yiyuan.service.PtmProductAttrKeyService;
import net.yiyuan.vo.PtmProductAttrKeyQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;


/**
 * 商品属性key管理
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 * @folder 商品管理/商品属性key管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class PtmProductAttrKeyController {
    @Autowired
    private PtmProductAttrKeyService ptmProductAttrKeyService;

    /**
     * 商品属性key列表(全部)
     *
     * @param request 商品属性key实体
     * @return {@link CommonResult<List<PtmProductAttrKeyQueryVO>>}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Description("商品管理/商品属性key管理/查询商品属性key")
    @SaCheckPermission(
            value = {"ptm:productAttrKey:query"},
            orRole = "admin")
    @GetMapping(value = "/ptm/productAttrKey/list")
    @ResponseBody
    public CommonResult<List<PtmProductAttrKeyQueryVO>> list(PtmProductAttrKeyListDTO request) throws Exception {
        return CommonResult.success(ptmProductAttrKeyService.list(request), "查询商品属性key列表成功");
    }

    /**
     * 商品属性key列表(分页)
     *
     * @param request 商品属性key实体
     * @return {@link CommonResult<Page<PtmProductAttrKeyQueryVO>>}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Description("商品管理/商品属性key管理/查询商品属性key")
    @SaCheckPermission(
            value = {"ptm:productAttrKey:query"},
            orRole = "admin")
    @GetMapping(value = "/ptm/productAttrKey/page")
    @ResponseBody
    public CommonResult<Page<PtmProductAttrKeyQueryVO>> page(PtmProductAttrKeyPageDTO request) throws Exception {
        return CommonResult.success(ptmProductAttrKeyService.page(request), "分页查询商品属性key成功");
    }

    /**
     * 商品属性key详情
     *
     * @param id 商品属性keyid
     * @return {@link CommonResult<PtmProductAttrKeyQueryVO>}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Description("商品管理/商品属性key管理/查询商品属性key")
    @SaCheckPermission(
            value = {"ptm:productAttrKey:query"},
            orRole = "admin")
    @GetMapping(value = "/ptm/productAttrKey/details/{id}")
    @ResponseBody
    public CommonResult<PtmProductAttrKeyQueryVO> details(@PathVariable("id") @NotBlank String id)
            throws Exception {
        return CommonResult.success(ptmProductAttrKeyService.details(id), "查询商品属性key详情成功");
    }

    /**
     * 删除商品属性key(支持批量)
     *
     * @param ids 商品属性keyid(多个逗号分割)
     * @return {@link CommonResult<String>}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Description("商品管理/商品属性key管理/删除商品属性key")
    @SaCheckPermission(
            value = {"ptm:productAttrKey:delete"},
            orRole = "admin")
    @PostMapping(value = "/ptm/productAttrKey/delete")
    @ResponseBody
    public CommonResult<String> delete(
            @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
        if (ptmProductAttrKeyService.delete(ids)) {
            return CommonResult.success(null, "删除商品属性key成功");
        } else {
            return CommonResult.failed("删除商品属性key失败");
        }
    }

    /**
     * 编辑商品属性key
     *
     * @param request 商品属性key实体
     * @return {@link CommonResult<String>}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Description("商品管理/商品属性key管理/编辑商品属性key")
    @SaCheckPermission(
            value = {"ptm:productAttrKey:edit"},
            orRole = "admin")
    @PostMapping(value = "/ptm/productAttrKey/edit")
    @ResponseBody
    public CommonResult<String> edit(@RequestBody @Validated PtmProductAttrKeyEditDTO request)
            throws Exception {
        if (ptmProductAttrKeyService.edit(request)) {
            return CommonResult.success(null, "修改商品属性key成功");
        } else {
            return CommonResult.failed("修改商品属性key失败");
        }
    }

    /**
     * 新增商品属性key
     *
     * @param request 商品属性key实体
     * @return {@link CommonResult<String>}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Description("商品管理/商品属性key管理/新增商品属性key")
    @SaCheckPermission(
            value = {"ptm:productAttrKey:add"},
            orRole = "admin")
    @PostMapping(value = "/ptm/productAttrKey/add")
    @ResponseBody
    public CommonResult<String> add(@RequestBody @Validated PtmProductAttrKeyAddDTO request) throws Exception {
        if (ptmProductAttrKeyService.add(request)) {
            return CommonResult.success(null, "新增商品属性key成功");
        } else {
            return CommonResult.failed("新增商品属性key失败");
        }
    }
}
