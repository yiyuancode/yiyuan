package net.yiyuan.core.auth.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.core.auth.dto.*;
import net.yiyuan.core.auth.service.AuthAdminService;
import net.yiyuan.core.auth.vo.AuthAdminQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 用户管理
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 * @module 权限管理
 * @folder 权限管理/用户管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class AuthAdminController {
  @Autowired private AuthAdminService authAdminService;

  /**
   * 用户列表(全部)
   *
   * @param request 用户实体
   * @return {@link CommonResult<List<AuthAdminQueryVO>>}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Description("权限管理/用户管理/查询用户")
  @SaCheckPermission(
      value = {"auth:admin:query"},
      orRole = "admin")
  @GetMapping(value = "/auth/admin/list")
  @ResponseBody
  public CommonResult<List<AuthAdminQueryVO>> list(AuthAdminListDTO request) throws Exception {
    return CommonResult.success(authAdminService.list(request), "查询用户列表成功");
  }

  /**
   * 用户列表(分页)
   *
   * @param request 用户实体
   * @return {@link CommonResult<Page<AuthAdminQueryVO>>}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Description("权限管理/用户管理/查询用户")
  @SaCheckPermission(
      value = {"auth:admin:query"},
      orRole = "admin")
  @GetMapping(value = "/auth/admin/page")
  @ResponseBody
  public CommonResult<Page<AuthAdminQueryVO>> page(AuthAdminPageDTO request) throws Exception {
    return CommonResult.success(authAdminService.page(request), "分页查询用户成功");
  }

  /**
   * 用户详情
   *
   * @param id 用户id
   * @return {@link CommonResult<AuthAdminQueryVO>}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Description("权限管理/用户管理/查询用户")
  @SaCheckPermission(
      value = {"auth:admin:query"},
      orRole = "admin")
  @GetMapping(value = "/auth/admin/details/{id}")
  @ResponseBody
  public CommonResult<AuthAdminQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(authAdminService.details(id), "查询用户详情成功");
  }

  /**
   * 删除用户(支持批量)
   *
   * @param ids 用户id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Description("权限管理/用户管理/删除用户")
  @SaCheckPermission(
      value = {"auth:admin:delete"},
      orRole = "admin")
  @PostMapping(value = "/auth/admin/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (authAdminService.delete(ids)) {
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
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Description("权限管理/用户管理/编辑用户")
  @SaCheckPermission(
      value = {"auth:admin:edit"},
      orRole = "admin")
  @PostMapping(value = "/auth/admin/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated AuthAdminEditDTO request)
      throws Exception {
    if (authAdminService.edit(request)) {
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
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Description("权限管理/用户管理/新增用户")
  @SaCheckPermission(
      value = {"auth:admin:add"},
      orRole = "admin")
  @PostMapping(value = "/auth/admin/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated AuthAdminAddDTO request)
      throws Exception {
    if (authAdminService.add(request)) {
      return CommonResult.success(null, "新增用户成功");
    } else {
      return CommonResult.failed("新增用户失败");
    }
  }

  /**
   * 分配角色
   *
   * @param request 分配角色请求实体
   * @return {@link CommonResult}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  @Description("权限管理/用户管理/分配角色")
  @SaCheckPermission(
      value = {"auth:admin:assignRole"},
      orRole = "admin")
  @RequestMapping(value = "/auth/admin/assignRole", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<String> assignRole(@RequestBody @Validated AuthAdminAssignRoleDTO request)
      throws Exception {
    if (authAdminService.assignRole(request)) {
      return CommonResult.success("分配角色成功");
    } else {
      return CommonResult.failed("分配角色失败");
    }
  }

  /**
   * 在线用户
   *
   * @param request 分配角色请求实体
   * @return {@link CommonResult}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  @Description("权限管理/用户管理/在线用户")
  @SaCheckPermission(
      value = {"auth:admin:online"},
      orRole = "admin")
  @GetMapping(value = "/auth/admin/online")
  @ResponseBody
  public CommonResult<Page<AuthAdminQueryVO>> online(@Validated AuthAdminPageDTO request)
      throws Exception {
    return CommonResult.success(authAdminService.online(request), "分页查询用户成功");
  }
}
