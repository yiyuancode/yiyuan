package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.UmProjectCollectAddDTO;
import net.yiyuan.dto.UmProjectCollectEditDTO;
import net.yiyuan.dto.UmProjectCollectListDTO;
import net.yiyuan.dto.UmProjectCollectPageDTO;
import net.yiyuan.service.UmProjectCollectService;
import net.yiyuan.vo.UmProjectCollectQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;


/**
 * 浏览记录管理
 *
 * @author 小林同学
 * @date 2023-09-21
 * @folder 用户管理/浏览记录管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class UmProjectCollectController {
    @Autowired
    private UmProjectCollectService umProjectCollectService;

    /**
     * 浏览记录列表(全部)
     *
     * @param request 浏览记录实体
     * @return {@link CommonResult<List<UmProjectCollectQueryVO>>}
     * @author 小林同学
     * @date 2023-09-21
     */
    @Description("用户管理/浏览记录管理/查询浏览记录")
    @SaCheckPermission(
            value = {"um:projectCollect:query"},
            orRole = "admin")
    @GetMapping(value = "/um/projectCollect/list")
    @ResponseBody
    public CommonResult<List<UmProjectCollectQueryVO>> list(UmProjectCollectListDTO request) throws Exception {
        return CommonResult.success(umProjectCollectService.list(request), "查询浏览记录列表成功");
    }

    /**
     * 浏览记录列表(分页)
     *
     * @param request 浏览记录实体
     * @return {@link CommonResult<Page<UmProjectCollectQueryVO>>}
     * @author 小林同学
     * @date 2023-09-21
     */
    @Description("用户管理/浏览记录管理/查询浏览记录")
    @SaCheckPermission(
            value = {"um:projectCollect:query"},
            orRole = "admin")
    @GetMapping(value = "/um/projectCollect/page")
    @ResponseBody
    public CommonResult<Page<UmProjectCollectQueryVO>> page(UmProjectCollectPageDTO request) throws Exception {
        return CommonResult.success(umProjectCollectService.page(request), "分页查询浏览记录成功");
    }

    /**
     * 浏览记录详情
     *
     * @param id 浏览记录id
     * @return {@link CommonResult<UmProjectCollectQueryVO>}
     * @author 小林同学
     * @date 2023-09-21
     */
    @Description("用户管理/浏览记录管理/查询浏览记录")
    @SaCheckPermission(
            value = {"um:projectCollect:query"},
            orRole = "admin")
    @GetMapping(value = "/um/projectCollect/details/{id}")
    @ResponseBody
    public CommonResult<UmProjectCollectQueryVO> details(@PathVariable("id") @NotBlank String id)
            throws Exception {
        return CommonResult.success(umProjectCollectService.details(id), "查询浏览记录详情成功");
    }

    /**
     * 删除浏览记录(支持批量)
     *
     * @param ids 浏览记录id(多个逗号分割)
     * @return {@link CommonResult<String>}
     * @author 小林同学
     * @date 2023-09-21
     */
    @Description("用户管理/浏览记录管理/删除浏览记录")
    @SaCheckPermission(
            value = {"um:projectCollect:delete"},
            orRole = "admin")
    @PostMapping(value = "/um/projectCollect/delete")
    @ResponseBody
    public CommonResult<String> delete(
            @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
        if (umProjectCollectService.delete(ids)) {
            return CommonResult.success(null, "删除浏览记录成功");
        } else {
            return CommonResult.failed("删除浏览记录失败");
        }
    }

    /**
     * 编辑浏览记录
     *
     * @param request 浏览记录实体
     * @return {@link CommonResult<String>}
     * @author 小林同学
     * @date 2023-09-21
     */
    @Description("用户管理/浏览记录管理/编辑浏览记录")
    @SaCheckPermission(
            value = {"um:projectCollect:edit"},
            orRole = "admin")
    @PostMapping(value = "/um/projectCollect/edit")
    @ResponseBody
    public CommonResult<String> edit(@RequestBody @Validated UmProjectCollectEditDTO request)
            throws Exception {
        if (umProjectCollectService.edit(request)) {
            return CommonResult.success(null, "修改浏览记录成功");
        } else {
            return CommonResult.failed("修改浏览记录失败");
        }
    }

    /**
     * 新增浏览记录
     *
     * @param request 浏览记录实体
     * @return {@link CommonResult<String>}
     * @author 小林同学
     * @date 2023-09-21
     */
    @Description("用户管理/浏览记录管理/新增浏览记录")
    @SaCheckPermission(
            value = {"um:projectCollect:add"},
            orRole = "admin")
    @PostMapping(value = "/um/projectCollect/add")
    @ResponseBody
    public CommonResult<String> add(@RequestBody @Validated UmProjectCollectAddDTO request) throws Exception {
        if (umProjectCollectService.add(request)) {
            return CommonResult.success(null, "新增浏览记录成功");
        } else {
            return CommonResult.failed("新增浏览记录失败");
        }
    }
}
