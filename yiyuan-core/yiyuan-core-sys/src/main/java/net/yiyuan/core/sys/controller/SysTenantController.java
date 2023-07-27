package net.yiyuan.core.sys.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.core.sys.dto.SysTenantAddDTO;
import net.yiyuan.core.sys.dto.SysTenantEditDTO;
import net.yiyuan.core.sys.dto.SysTenantListDTO;
import net.yiyuan.core.sys.dto.SysTenantPageDTO;
import net.yiyuan.core.sys.service.SysTenantService;
import net.yiyuan.core.sys.vo.SysTenantQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;


/**
 * 租户管理
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 * @module 系统管理
 * @folder 系统管理/租户管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class SysTenantController {
    @Autowired
    private SysTenantService sysTenantService;


    /**
     * 租户列表(全部)
     *
     * @param request 租户实体
     * @return {@link CommonResult<List<SysTenantQueryVO>>}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    @Description("系统管理/租户管理/查询租户" )
    @SaCheckPermission(value = {"sys:tenant:query"}, orRole = "admin" )
    @GetMapping(value = "/sys/tenant/list" )
    @ResponseBody
    public CommonResult<List<SysTenantQueryVO>> list(SysTenantListDTO request) throws Exception {
        return CommonResult.success(sysTenantService.list(request), "查询租户列表成功" );
    }


    /**
     * 租户列表(分页)
     *
     * @param request 租户实体
     * @return {@link CommonResult<Page<SysTenantQueryVO>>}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    @Description("系统管理/租户管理/查询租户" )
    @SaCheckPermission(value = {"sys:tenant:query"}, orRole = "admin" )
    @GetMapping(value = "/sys/tenant/page" )
    @ResponseBody
    public CommonResult<Page<SysTenantQueryVO>> page(
            SysTenantPageDTO request
    ) throws Exception {
        return CommonResult.success(sysTenantService.page(request), "分页查询租户成功" );
    }

    /**
     * 租户详情
     *
     * @param id 租户id
     * @return {@link CommonResult<SysTenantQueryVO>}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    @Description("系统管理/租户管理/查询租户" )
    @SaCheckPermission(value = {"sys:tenant:query"}, orRole = "admin" )
    @GetMapping(value = "/sys/tenant/details/{id}" )
    @ResponseBody
    public CommonResult<SysTenantQueryVO> details(@PathVariable("id" ) @Validated({NotBlank.class}) String id) throws Exception {
        return CommonResult.success(sysTenantService.details(id), "查询租户详情成功" );
    }


    /**
     * 删除租户(支持批量)
     *
     * @param ids 租户id(多个逗号分割)
     * @return {@link CommonResult<String>}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    @Description("系统管理/租户管理/删除租户" )
    @SaCheckPermission(value = {"sys:tenant:delete"}, orRole = "admin" )
    @PostMapping(value = "/sys/tenant/delete" )
    @ResponseBody
    public CommonResult<String> delete(@RequestParam @Validated({NotBlank.class}) String ids) throws Exception {
        if (sysTenantService.delete(ids)) {
            return CommonResult.success(null, "删除租户成功" );
        } else {
            return CommonResult.failed("删除租户失败" );
        }
    }

    /**
     * 编辑租户
     *
     * @param request 租户实体
     * @return {@link CommonResult<String>}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    @Description("系统管理/租户管理/编辑租户" )
    @SaCheckPermission(value = {"sys:tenant:edit"}, orRole = "admin" )
    @PostMapping(value = "/sys/tenant/edit" )
    @ResponseBody
    public CommonResult<String> edit(@RequestBody @Validated SysTenantEditDTO request) throws Exception {
        if (sysTenantService.edit(request)) {
            return CommonResult.success(null, "修改租户成功" );
        } else {
            return CommonResult.failed("修改租户失败" );
        }
    }


    /**
     * 新增租户
     *
     * @param request 租户实体
     * @return {@link CommonResult<String>}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    @Description("系统管理/租户管理/新增租户" )
    @SaCheckPermission(value = {"sys:tenant:add"}, orRole = "admin" )
    @PostMapping(value = "/sys/tenant/add" )
    @ResponseBody
    public CommonResult<String> add(@RequestBody @Validated SysTenantAddDTO request) throws Exception {
        if (sysTenantService.add(request)) {
            return CommonResult.success(null, "新增租户成功" );
        } else {
            return CommonResult.failed("新增租户失败" );
        }
    }
}
