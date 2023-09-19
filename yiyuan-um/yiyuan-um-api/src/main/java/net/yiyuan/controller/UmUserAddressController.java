package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.UmUserAddressAddDTO;
import net.yiyuan.dto.UmUserAddressEditDTO;
import net.yiyuan.dto.UmUserAddressListDTO;
import net.yiyuan.dto.UmUserAddressPageDTO;
import net.yiyuan.service.UmUserAddressService;
import net.yiyuan.vo.UmUserAddressQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;


/**
 * 用户地址管理
 *
 * @author 小林同学
 * @date 2023-09-19
 * @folder 用户管理/用户地址管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class UmUserAddressController {
    @Autowired
    private UmUserAddressService umUserAddressService;

    /**
     * 用户地址列表(全部)
     *
     * @param request 用户地址实体
     * @return {@link CommonResult<List<UmUserAddressQueryVO>>}
     * @author 小林同学
     * @date 2023-09-19
     */
    @Description("用户管理/用户地址管理/查询用户地址")
    @SaCheckPermission(
            value = {"um:userAddress:query"},
            orRole = "admin")
    @GetMapping(value = "/um/userAddress/list")
    @ResponseBody
    public CommonResult<List<UmUserAddressQueryVO>> list(UmUserAddressListDTO request) throws Exception {
        return CommonResult.success(umUserAddressService.list(request), "查询用户地址列表成功");
    }

    /**
     * 用户地址列表(分页)
     *
     * @param request 用户地址实体
     * @return {@link CommonResult<Page<UmUserAddressQueryVO>>}
     * @author 小林同学
     * @date 2023-09-19
     */
    @Description("用户管理/用户地址管理/查询用户地址")
    @SaCheckPermission(
            value = {"um:userAddress:query"},
            orRole = "admin")
    @GetMapping(value = "/um/userAddress/page")
    @ResponseBody
    public CommonResult<Page<UmUserAddressQueryVO>> page(UmUserAddressPageDTO request) throws Exception {
        return CommonResult.success(umUserAddressService.page(request), "分页查询用户地址成功");
    }

    /**
     * 用户地址详情
     *
     * @param id 用户地址id
     * @return {@link CommonResult<UmUserAddressQueryVO>}
     * @author 小林同学
     * @date 2023-09-19
     */
    @Description("用户管理/用户地址管理/查询用户地址")
    @SaCheckPermission(
            value = {"um:userAddress:query"},
            orRole = "admin")
    @GetMapping(value = "/um/userAddress/details/{id}")
    @ResponseBody
    public CommonResult<UmUserAddressQueryVO> details(@PathVariable("id") @NotBlank String id)
            throws Exception {
        return CommonResult.success(umUserAddressService.details(id), "查询用户地址详情成功");
    }

    /**
     * 删除用户地址(支持批量)
     *
     * @param ids 用户地址id(多个逗号分割)
     * @return {@link CommonResult<String>}
     * @author 小林同学
     * @date 2023-09-19
     */
    @Description("用户管理/用户地址管理/删除用户地址")
    @SaCheckPermission(
            value = {"um:userAddress:delete"},
            orRole = "admin")
    @PostMapping(value = "/um/userAddress/delete")
    @ResponseBody
    public CommonResult<String> delete(
            @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
        if (umUserAddressService.delete(ids)) {
            return CommonResult.success(null, "删除用户地址成功");
        } else {
            return CommonResult.failed("删除用户地址失败");
        }
    }

    /**
     * 编辑用户地址
     *
     * @param request 用户地址实体
     * @return {@link CommonResult<String>}
     * @author 小林同学
     * @date 2023-09-19
     */
    @Description("用户管理/用户地址管理/编辑用户地址")
    @SaCheckPermission(
            value = {"um:userAddress:edit"},
            orRole = "admin")
    @PostMapping(value = "/um/userAddress/edit")
    @ResponseBody
    public CommonResult<String> edit(@RequestBody @Validated UmUserAddressEditDTO request)
            throws Exception {
        if (umUserAddressService.edit(request)) {
            return CommonResult.success(null, "修改用户地址成功");
        } else {
            return CommonResult.failed("修改用户地址失败");
        }
    }

    /**
     * 新增用户地址
     *
     * @param request 用户地址实体
     * @return {@link CommonResult<String>}
     * @author 小林同学
     * @date 2023-09-19
     */
    @Description("用户管理/用户地址管理/新增用户地址")
    @SaCheckPermission(
            value = {"um:userAddress:add"},
            orRole = "admin")
    @PostMapping(value = "/um/userAddress/add")
    @ResponseBody
    public CommonResult<String> add(@RequestBody @Validated UmUserAddressAddDTO request) throws Exception {
        if (umUserAddressService.add(request)) {
            return CommonResult.success(null, "新增用户地址成功");
        } else {
            return CommonResult.failed("新增用户地址失败");
        }
    }
}
