package net.yiyuan.core.auth.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.core.auth.dto.*;
import net.yiyuan.core.auth.service.AuthRoleService;
import net.yiyuan.core.auth.vo.AuthRoleQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;


/**
 * 角色管理
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 * @module 权限管理
 * @folder 权限管理/角色管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class AuthRoleController {
    @Autowired
    private AuthRoleService authRoleService;
    
    
    /**
     * 角色列表(全部)
     *
     * @param request 角色实体
     * @return {@link CommonResult<List<AuthRoleQueryVO>>}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    @Description("权限管理/角色管理/查询角色" )
    @SaCheckPermission(value = {"auth:role:query"}, orRole = "admin" )
    @GetMapping(value = "/auth/role/list" )
    @ResponseBody
    public CommonResult<List<AuthRoleQueryVO>> list(AuthRoleListDTO request) throws Exception {
        return CommonResult.success(authRoleService.list(request), "查询角色列表成功" );
    }
    
    
    /**
     * 角色列表(分页)
     *
     * @param request 角色实体
     * @return {@link CommonResult<Page<AuthRoleQueryVO>>}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    @Description("权限管理/角色管理/查询角色" )
    @SaCheckPermission(value = {"auth:role:query"}, orRole = "admin" )
    @GetMapping(value = "/auth/role/page" )
    @ResponseBody
    public CommonResult<Page<AuthRoleQueryVO>> page(
            AuthRolePageDTO request
    ) throws Exception {
        return CommonResult.success(authRoleService.page(request), "分页查询角色成功" );
    }
    
    /**
     * 角色详情
     *
     * @param id 角色id
     * @return {@link CommonResult<AuthRoleQueryVO>}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    @Description("权限管理/角色管理/查询角色" )
    @SaCheckPermission(value = {"auth:role:query"}, orRole = "admin" )
    @GetMapping(value = "/auth/role/details/{id}" )
    @ResponseBody
    public CommonResult<AuthRoleQueryVO> details(@PathVariable("id" ) @Validated({NotBlank.class}) String id) throws Exception {
        return CommonResult.success(authRoleService.details(id), "查询角色详情成功" );
    }
    
    
    /**
     * 删除角色(支持批量)
     *
     * @param ids 角色id(多个逗号分割)
     * @return {@link CommonResult<String>}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    @Description("权限管理/角色管理/删除角色" )
    @SaCheckPermission(value = {"auth:role:delete"}, orRole = "admin" )
    @PostMapping(value = "/auth/role/delete" )
    @ResponseBody
    public CommonResult<String> delete(@RequestParam @Validated({NotBlank.class}) String ids) throws Exception {
        if (authRoleService.delete(ids)) {
            return CommonResult.success(null, "删除角色成功" );
        } else {
            return CommonResult.failed("删除角色失败" );
        }
    }
    
    /**
     * 编辑角色
     *
     * @param request 角色实体
     * @return {@link CommonResult<String>}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    @Description("权限管理/角色管理/编辑角色" )
    @SaCheckPermission(value = {"auth:role:edit"}, orRole = "admin" )
    @PostMapping(value = "/auth/role/edit" )
    @ResponseBody
    public CommonResult<String> edit(@RequestBody @Validated AuthRoleEditDTO request) throws Exception {
        if (authRoleService.edit(request)) {
            return CommonResult.success(null, "修改角色成功" );
        } else {
            return CommonResult.failed("修改角色失败" );
        }
    }
    
    
    /**
     * 新增角色
     *
     * @param request 角色实体
     * @return {@link CommonResult<String>}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    @Description("权限管理/角色管理/新增角色" )
    @SaCheckPermission(value = {"auth:role:add"}, orRole = "admin" )
    @PostMapping(value = "/auth/role/add" )
    @ResponseBody
    public CommonResult<String> add(@RequestBody @Validated AuthRoleAddDTO request) throws Exception {
        if (authRoleService.add(request)) {
            return CommonResult.success(null, "新增角色成功" );
        } else {
            return CommonResult.failed("新增角色失败" );
        }
    }
    
    
    /**
     * 分配菜单
     *
     * @param request 分配菜单请求实体
     * @return {@link CommonResult<String>}
     * @author 一源团队--花和尚
     * @date 2023-06-24
     */
    @Description("权限管理/角色管理/分配菜单" )
    @SaCheckPermission(
            value = {"auth:role:assignMenu"},
            orRole = "admin" )
    @RequestMapping(value = "/auth/role/assignMenu", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<String> assignMenu(@RequestBody @Validated AuthRoleAssignMenuDTO request)
            throws Exception {
        if (authRoleService.assignMenu(request)) {
            return CommonResult.success("分配菜单成功" );
        } else {
            return CommonResult.failed("分配菜单失败" );
        }
    }
}
