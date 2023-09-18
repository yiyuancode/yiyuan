package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.UmUserAddDTO;
import net.yiyuan.dto.UmUserEditDTO;
import net.yiyuan.dto.UmUserListDTO;
import net.yiyuan.dto.UmUserPageDTO;
import net.yiyuan.service.UmUserService;
import net.yiyuan.vo.UmUserQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 用户管理
 *
 * @author 小林同学
 * @date 2023-09-18
 * @folder 用户管理/用户管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class UmUserController {
    @Autowired
    private UmUserService umUserService;

    /**
     * 用户列表(全部)
     *
     * @param request 用户实体
     * @return {@link CommonResult<List<UmUserQueryVO>>}
     * @author 小林同学
     * @date 2023-09-18
     */
    @Description("用户管理/用户管理/查询用户")
    @SaCheckPermission(
            value = {"um:user:query"},
            orRole = "admin")
    @GetMapping(value = "/um/user/list")
    @ResponseBody
    public CommonResult<List<UmUserQueryVO>> list(UmUserListDTO request) throws Exception {
        return CommonResult.success(umUserService.list(request), "查询用户列表成功");
    }

    /**
     * 用户列表(分页)
     *
     * @param request 用户实体
     * @return {@link CommonResult<Page<UmUserQueryVO>>}
     * @author 小林同学
     * @date 2023-09-18
     */
    @Description("用户管理/用户管理/查询用户")
    @SaCheckPermission(
            value = {"um:user:query"},
            orRole = "admin")
    @GetMapping(value = "/um/user/page")
    @ResponseBody
    public CommonResult<Page<UmUserQueryVO>> page(UmUserPageDTO request) throws Exception {
        return CommonResult.success(umUserService.page(request), "分页查询用户成功");
    }

    /**
     * 用户详情
     *
     * @param id 用户id
     * @return {@link CommonResult<UmUserQueryVO>}
     * @author 小林同学
     * @date 2023-09-18
     */
    @Description("用户管理/用户管理/查询用户")
    @SaCheckPermission(
            value = {"um:user:query"},
            orRole = "admin")
    @GetMapping(value = "/um/user/details/{id}")
    @ResponseBody
    public CommonResult<UmUserQueryVO> details(@PathVariable("id") @NotBlank String id)
            throws Exception {
        return CommonResult.success(umUserService.details(id), "查询用户详情成功");
    }

    /**
     * 删除用户(支持批量)
     *
     * @param ids 用户id(多个逗号分割)
     * @return {@link CommonResult<String>}
     * @author 小林同学
     * @date 2023-09-18
     */
    @Description("用户管理/用户管理/删除用户")
    @SaCheckPermission(
            value = {"um:user:delete"},
            orRole = "admin")
    @PostMapping(value = "/um/user/delete")
    @ResponseBody
    public CommonResult<String> delete(
            @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
        if (umUserService.delete(ids)) {
            return CommonResult.success(null, "删除用户成功");
        } else {
            return CommonResult.failed("删除用户失败");
        }
    }

    /**
     * 编辑用户
     *
     * @param request 用户实体
     * @return {@link CommonResult<String>}
     * @author 小林同学
     * @date 2023-09-18
     */
    @Description("用户管理/用户管理/编辑用户")
    @SaCheckPermission(
            value = {"um:user:edit"},
            orRole = "admin")
    @PostMapping(value = "/um/user/edit")
    @ResponseBody
    public CommonResult<String> edit(@RequestBody @Validated UmUserEditDTO request) throws Exception {
        if (umUserService.edit(request)) {
            return CommonResult.success(null, "修改用户成功");
        } else {
            return CommonResult.failed("修改用户失败");
        }
    }

    /**
     * 新增用户
     *
     * @param request 用户实体
     * @return {@link CommonResult<String>}
     * @author 小林同学
     * @date 2023-09-18
     */
    @Description("用户管理/用户管理/新增用户")
    @SaCheckPermission(
            value = {"um:user:add"},
            orRole = "admin")
    @PostMapping(value = "/um/user/add")
    @ResponseBody
    public CommonResult<String> add(@RequestBody @Validated UmUserAddDTO request) throws Exception {
        if (umUserService.add(request)) {
            return CommonResult.success(null, "新增用户成功");
        } else {
            return CommonResult.failed("新增用户失败");
        }
    }
}
