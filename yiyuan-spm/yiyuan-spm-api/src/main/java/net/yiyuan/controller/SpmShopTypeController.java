package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.SpmShopTypeAddDTO;
import net.yiyuan.dto.SpmShopTypeEditDTO;
import net.yiyuan.dto.SpmShopTypeListDTO;
import net.yiyuan.dto.SpmShopTypePageDTO;
import net.yiyuan.model.SpmShopType;
import net.yiyuan.vo.SpmShopTypeQueryVO;

import net.yiyuan.service.SpmShopTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;


/**
 * 店铺类型管理
 *
 * @author  一源-花和尚
 * @date 2023-09-18
 * @folder 店铺管理/店铺类型管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class SpmShopTypeController {
    @Autowired
    private SpmShopTypeService  spmShopTypeService;

    /**
     * 店铺类型列表(全部)
     *
     * @param request 店铺类型实体
     * @return {@link CommonResult<List<SpmShopTypeQueryVO>>}
     * @author  一源-花和尚
     * @date 2023-09-18
     */
    @Description("店铺管理/店铺类型管理/查询店铺类型")
    @SaCheckPermission(
            value = {"spm:shopType:query" },
            orRole = "admin")
    @GetMapping(value = "/spm/shopType/list")
    @ResponseBody
    public CommonResult<List<SpmShopTypeQueryVO>> list(SpmShopTypeListDTO request) throws Exception {
        return CommonResult.success(spmShopTypeService.list(request), "查询店铺类型列表成功");
    }

    /**
     * 店铺类型列表(分页)
     *
     * @param request 店铺类型实体
     * @return {@link CommonResult<Page<SpmShopTypeQueryVO>>}
     * @author  一源-花和尚
     * @date 2023-09-18
     */
    @Description("店铺管理/店铺类型管理/查询店铺类型")
    @SaCheckPermission(
            value = {"spm:shopType:query" },
            orRole = "admin")
    @GetMapping(value = "/spm/shopType/page")
    @ResponseBody
    public CommonResult<Page<SpmShopTypeQueryVO>> page(SpmShopTypePageDTO request) throws Exception {
        return CommonResult.success(spmShopTypeService.page(request), "分页查询店铺类型成功");
    }

    /**
     * 店铺类型详情
     *
     * @param id 店铺类型id
     * @return {@link CommonResult<SpmShopTypeQueryVO>}
     * @author  一源-花和尚
     * @date 2023-09-18
     */
    @Description("店铺管理/店铺类型管理/查询店铺类型")
    @SaCheckPermission(
            value = {"spm:shopType:query" },
            orRole = "admin")
    @GetMapping(value = "/spm/shopType/details/{id}")
    @ResponseBody
    public CommonResult<SpmShopTypeQueryVO> details(@PathVariable("id") @NotBlank String id)
            throws Exception {
        return CommonResult.success(spmShopTypeService.details(id), "查询店铺类型详情成功");
    }

    /**
     * 删除店铺类型(支持批量)
     *
     * @param ids 店铺类型id(多个逗号分割)
     * @return {@link CommonResult<String>}
     * @author  一源-花和尚
     * @date 2023-09-18
     */
    @Description("店铺管理/店铺类型管理/删除店铺类型")
    @SaCheckPermission(
            value = {"spm:shopType:delete" },
            orRole = "admin")
    @PostMapping(value = "/spm/shopType/delete")
    @ResponseBody
    public CommonResult<String> delete(
            @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
        if (spmShopTypeService.delete(ids)) {
            return CommonResult.success(null, "删除店铺类型成功");
        } else {
            return CommonResult.failed("删除店铺类型失败");
        }
    }

    /**
     * 编辑店铺类型
     *
     * @param request 店铺类型实体
     * @return {@link CommonResult<String>}
     * @author  一源-花和尚
     * @date 2023-09-18
     */
    @Description("店铺管理/店铺类型管理/编辑店铺类型")
    @SaCheckPermission(
            value = {"spm:shopType:edit" },
            orRole = "admin")
    @PostMapping(value = "/spm/shopType/edit")
    @ResponseBody
    public CommonResult<String> edit(@RequestBody @Validated SpmShopTypeEditDTO request)
            throws Exception {
        if (spmShopTypeService.edit(request)) {
            return CommonResult.success(null, "修改店铺类型成功");
        } else {
            return CommonResult.failed("修改店铺类型失败");
        }
    }

    /**
     * 新增店铺类型
     *
     * @param request 店铺类型实体
     * @return {@link CommonResult<String>}
     * @author  一源-花和尚
     * @date 2023-09-18
     */
    @Description("店铺管理/店铺类型管理/新增店铺类型")
    @SaCheckPermission(
            value = {"spm:shopType:add" },
            orRole = "admin")
    @PostMapping(value = "/spm/shopType/add")
    @ResponseBody
    public CommonResult<String> add(@RequestBody @Validated SpmShopTypeAddDTO request) throws Exception {
        if (spmShopTypeService.add(request)) {
            return CommonResult.success(null, "新增店铺类型成功");
        } else {
            return CommonResult.failed("新增店铺类型失败");
        }
    }
}
