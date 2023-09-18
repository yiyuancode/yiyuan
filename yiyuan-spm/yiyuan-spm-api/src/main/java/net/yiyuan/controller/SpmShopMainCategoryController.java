package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.SpmShopMainCategoryAddDTO;
import net.yiyuan.dto.SpmShopMainCategoryEditDTO;
import net.yiyuan.dto.SpmShopMainCategoryListDTO;
import net.yiyuan.dto.SpmShopMainCategoryPageDTO;
import net.yiyuan.model.SpmShopMainCategory;
import net.yiyuan.vo.SpmShopMainCategoryQueryVO;

import net.yiyuan.service.SpmShopMainCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;


/**
 * 店铺主营类目管理
 *
 * @author  一源-花和尚
 * @date 2023-09-18
 * @folder 店铺管理/店铺主营类目管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class SpmShopMainCategoryController {
    @Autowired
    private SpmShopMainCategoryService  spmShopMainCategoryService;

    /**
     * 店铺主营类目列表(全部)
     *
     * @param request 店铺主营类目实体
     * @return {@link CommonResult<List<SpmShopMainCategoryQueryVO>>}
     * @author  一源-花和尚
     * @date 2023-09-18
     */
    @Description("店铺管理/店铺主营类目管理/查询店铺主营类目")
    @SaCheckPermission(
            value = {"spm:shopMainCategory:query" },
            orRole = "admin")
    @GetMapping(value = "/spm/shopMainCategory/list")
    @ResponseBody
    public CommonResult<List<SpmShopMainCategoryQueryVO>> list(SpmShopMainCategoryListDTO request) throws Exception {
        return CommonResult.success(spmShopMainCategoryService.list(request), "查询店铺主营类目列表成功");
    }

    /**
     * 店铺主营类目列表(分页)
     *
     * @param request 店铺主营类目实体
     * @return {@link CommonResult<Page<SpmShopMainCategoryQueryVO>>}
     * @author  一源-花和尚
     * @date 2023-09-18
     */
    @Description("店铺管理/店铺主营类目管理/查询店铺主营类目")
    @SaCheckPermission(
            value = {"spm:shopMainCategory:query" },
            orRole = "admin")
    @GetMapping(value = "/spm/shopMainCategory/page")
    @ResponseBody
    public CommonResult<Page<SpmShopMainCategoryQueryVO>> page(SpmShopMainCategoryPageDTO request) throws Exception {
        return CommonResult.success(spmShopMainCategoryService.page(request), "分页查询店铺主营类目成功");
    }

    /**
     * 店铺主营类目详情
     *
     * @param id 店铺主营类目id
     * @return {@link CommonResult<SpmShopMainCategoryQueryVO>}
     * @author  一源-花和尚
     * @date 2023-09-18
     */
    @Description("店铺管理/店铺主营类目管理/查询店铺主营类目")
    @SaCheckPermission(
            value = {"spm:shopMainCategory:query" },
            orRole = "admin")
    @GetMapping(value = "/spm/shopMainCategory/details/{id}")
    @ResponseBody
    public CommonResult<SpmShopMainCategoryQueryVO> details(@PathVariable("id") @NotBlank String id)
            throws Exception {
        return CommonResult.success(spmShopMainCategoryService.details(id), "查询店铺主营类目详情成功");
    }

    /**
     * 删除店铺主营类目(支持批量)
     *
     * @param ids 店铺主营类目id(多个逗号分割)
     * @return {@link CommonResult<String>}
     * @author  一源-花和尚
     * @date 2023-09-18
     */
    @Description("店铺管理/店铺主营类目管理/删除店铺主营类目")
    @SaCheckPermission(
            value = {"spm:shopMainCategory:delete" },
            orRole = "admin")
    @PostMapping(value = "/spm/shopMainCategory/delete")
    @ResponseBody
    public CommonResult<String> delete(
            @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
        if (spmShopMainCategoryService.delete(ids)) {
            return CommonResult.success(null, "删除店铺主营类目成功");
        } else {
            return CommonResult.failed("删除店铺主营类目失败");
        }
    }

    /**
     * 编辑店铺主营类目
     *
     * @param request 店铺主营类目实体
     * @return {@link CommonResult<String>}
     * @author  一源-花和尚
     * @date 2023-09-18
     */
    @Description("店铺管理/店铺主营类目管理/编辑店铺主营类目")
    @SaCheckPermission(
            value = {"spm:shopMainCategory:edit" },
            orRole = "admin")
    @PostMapping(value = "/spm/shopMainCategory/edit")
    @ResponseBody
    public CommonResult<String> edit(@RequestBody @Validated SpmShopMainCategoryEditDTO request)
            throws Exception {
        if (spmShopMainCategoryService.edit(request)) {
            return CommonResult.success(null, "修改店铺主营类目成功");
        } else {
            return CommonResult.failed("修改店铺主营类目失败");
        }
    }

    /**
     * 新增店铺主营类目
     *
     * @param request 店铺主营类目实体
     * @return {@link CommonResult<String>}
     * @author  一源-花和尚
     * @date 2023-09-18
     */
    @Description("店铺管理/店铺主营类目管理/新增店铺主营类目")
    @SaCheckPermission(
            value = {"spm:shopMainCategory:add" },
            orRole = "admin")
    @PostMapping(value = "/spm/shopMainCategory/add")
    @ResponseBody
    public CommonResult<String> add(@RequestBody @Validated SpmShopMainCategoryAddDTO request) throws Exception {
        if (spmShopMainCategoryService.add(request)) {
            return CommonResult.success(null, "新增店铺主营类目成功");
        } else {
            return CommonResult.failed("新增店铺主营类目失败");
        }
    }
}
