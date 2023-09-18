package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaIgnore;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.*;
import net.yiyuan.service.SysUserService;
import net.yiyuan.vo.SysUserQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 管理端用户管理
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 * @folder 系统管理/管理端用户管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class SysUserController {
  @Autowired private SysUserService sysUserService;

  /**
   * 管理端用户列表(全部)
   *
   * @param request 管理端用户实体
   * @return {@link CommonResult<List<SysUserQueryVO>>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Description("系统管理/管理端用户管理/查询管理端用户")
  @SaCheckPermission(
      value = {"sys:user:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/user/list")
  @ResponseBody
  public CommonResult<List<SysUserQueryVO>> list(SysUserListDTO request) throws Exception {
    return CommonResult.success(sysUserService.list(request), "查询管理端用户列表成功");
  }

  /**
   * 管理端用户列表(分页)
   *
   * @param request 管理端用户实体
   * @return {@link CommonResult<Page<SysUserQueryVO>>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Description("系统管理/管理端用户管理/查询管理端用户")
  @SaCheckPermission(
      value = {"sys:user:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/user/page")
  @ResponseBody
  public CommonResult<Page<SysUserQueryVO>> page(SysUserPageDTO request) throws Exception {
    return CommonResult.success(sysUserService.page(request), "分页查询管理端用户成功");
  }

  /**
   * 管理端用户详情
   *
   * @param id 管理端用户id
   * @return {@link CommonResult<SysUserQueryVO>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Description("系统管理/管理端用户管理/查询管理端用户")
  @SaCheckPermission(
      value = {"sys:user:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/user/details/{id}")
  @ResponseBody
  public CommonResult<SysUserQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(sysUserService.details(id), "查询管理端用户详情成功");
  }

  /**
   * 删除管理端用户(支持批量)
   *
   * @param ids 管理端用户id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Description("系统管理/管理端用户管理/删除管理端用户")
  @SaCheckPermission(
      value = {"sys:user:delete"},
      orRole = "admin")
  @PostMapping(value = "/sys/user/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (sysUserService.delete(ids)) {
      return CommonResult.success(null, "删除管理端用户成功");
    } else {
      return CommonResult.failed("删除管理端用户失败");
    }
  }

  /**
   * 编辑管理端用户
   *
   * @param request 管理端用户实体
   * @return {@link CommonResult<String>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Description("系统管理/管理端用户管理/编辑管理端用户")
  @SaCheckPermission(
      value = {"sys:user:edit"},
      orRole = "admin")
  @PostMapping(value = "/sys/user/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated SysUserEditDTO request)
      throws Exception {
    if (sysUserService.edit(request)) {
      return CommonResult.success(null, "修改管理端用户成功");
    } else {
      return CommonResult.failed("修改管理端用户失败");
    }
  }

  /**
   * 新增管理端用户
   *
   * @param request 管理端用户实体
   * @return {@link CommonResult<String>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Description("系统管理/管理端用户管理/新增管理端用户")
  @SaCheckPermission(
      value = {"sys:user:add"},
      orRole = "admin")
  @PostMapping(value = "/sys/user/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated SysUserAddDTO request) throws Exception {
    if (sysUserService.add(request)) {
      return CommonResult.success(null, "新增管理端用户成功");
    } else {
      return CommonResult.failed("新增管理端用户失败");
    }
  }

  /**
   * 平台端-登录
   *
   * @param request 平台端-登录实体
   * @return {@link CommonResult<String>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @SaIgnore
  @PostMapping(value = "/sys/user/admin/accout/login")
  @ResponseBody
  public CommonResult<String> adminAccoutLogin(
      @RequestBody @Validated SysUserAdminAccoutLoginDTO request) throws Exception {
    if (sysUserService.adminAccoutLogin(request)) {
      return CommonResult.success(null, "新增管理端用户成功");
    } else {
      return CommonResult.failed("新增管理端用户失败");
    }
  }

  /**
   * 租户端-登录
   *
   * @param request 租户端-登录实体
   * @return {@link CommonResult<String>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @SaIgnore
  @PostMapping(value = "/sys/user/tenant/accout/login")
  @ResponseBody
  public CommonResult<String> tenantAccoutLogin(
      @RequestBody @Validated SysUserTenantAccoutLoginDTO request) throws Exception {
    if (sysUserService.tenantAccoutLogin(request)) {
      return CommonResult.success(null, "新增管理端用户成功");
    } else {
      return CommonResult.failed("新增管理端用户失败");
    }
  }
}
