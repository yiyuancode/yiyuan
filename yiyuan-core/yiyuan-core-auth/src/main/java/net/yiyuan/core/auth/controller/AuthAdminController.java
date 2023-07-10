package net.yiyuan.core.auth.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.core.auth.model.AuthAdmin;
import net.yiyuan.core.auth.model.req.AssignRoleReq;
import net.yiyuan.core.auth.service.AuthAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 用户管理
 *
 * @author 一源团队--花和尚
 * @date 2023-07-09
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
   * @return {@link CommonResult<List<AuthAdmin>>}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  @Description("权限管理/用户管理/查询用户")
  @SaCheckPermission(
      value = {"auth:admin:query"},
      orRole = "admin")
  @RequestMapping(value = "/auth/admin/list", method = RequestMethod.GET)
  @ResponseBody
  public CommonResult<List<AuthAdmin>> list(AuthAdmin request) throws Exception {
    return CommonResult.success(authAdminService.list(request));
  }

  /**
   * 用户列表(分页)
   *
   * @param request 用户实体
   * @return {@link CommonResult<Page<AuthAdmin>>}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  @Description("权限管理/用户管理/查询用户")
  @SaCheckPermission(
      value = {"auth:admin:query"},
      orRole = "admin")
  @RequestMapping(value = "/auth/admin/pages", method = RequestMethod.GET)
  @ResponseBody
  public CommonResult<Page<AuthAdmin>> pages(
      AuthAdmin request,
      @RequestParam(defaultValue = "10") Integer pageSize,
      @RequestParam(defaultValue = "1") Integer pageNum)
      throws Exception {
    return CommonResult.success(authAdminService.pages(request, pageSize, pageNum));
  }

  /**
   * 用户详情
   *
   * @param request 用户实体
   * @return {@link CommonResult<AuthAdmin>}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  @Description("权限管理/用户管理/查询用户")
  @SaCheckPermission(
      value = {"auth:admin:query"},
      orRole = "admin")
  @RequestMapping(value = "/auth/admin/details", method = RequestMethod.GET)
  @ResponseBody
  public CommonResult<AuthAdmin> details(AuthAdmin request) throws Exception {
    return CommonResult.success(authAdminService.details(request));
  }

  /**
   * 删除用户
   *
   * @param request 用户实体
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  @Description("权限管理/用户管理/删除用户")
  @SaCheckPermission(
      value = {"auth:admin:del"},
      orRole = "admin")
  @RequestMapping(value = "/auth/admin/del", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<String> del(@RequestBody @Validated AuthAdmin request) throws Exception {
    if (authAdminService.del(request)) {
      return CommonResult.success("删除用户成功");
    } else {
      return CommonResult.failed("删除用户失败");
    }
  }

  /**
   * 批量删除用户
   *
   * @param ids 逗号分割id
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  @Description("权限管理/用户管理/批量删除用户")
  @SaCheckPermission(
      value = {"auth:admin:dels"},
      orRole = "admin")
  @RequestMapping(value = "/auth/admin/dels", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<String> dels(@RequestParam @Validated({NotEmpty.class}) String ids)
      throws Exception {
    if (authAdminService.dels(ids)) {
      return CommonResult.success("批量删除用户成功");
    } else {
      return CommonResult.failed("批量删除用户失败");
    }
  }
  /**
   * 编辑用户
   *
   * @param request 用户实体
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-07-09
   */
  @Description("权限管理/用户管理/编辑用户")
  @SaCheckPermission(
      value = {"auth:admin:edit"},
      orRole = "admin")
  @RequestMapping(value = "/auth/admin/edit", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated AuthAdmin request) throws Exception {
    if (authAdminService.edit(request)) {
      return CommonResult.success("修改用户成功");
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
   * @date 2023-07-09
   */
  @Description("权限管理/用户管理/新增用户")
  @SaCheckPermission(
      value = {"auth:admin:add"},
      orRole = "admin")
  @RequestMapping(value = "/auth/admin/add", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated AuthAdmin request) throws Exception {
    if (authAdminService.add(request)) {
      return CommonResult.success("新增用户成功");
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
  public CommonResult<String> assignRole(@RequestBody @Validated AssignRoleReq request)
      throws Exception {
    if (authAdminService.assignRole(request)) {
      return CommonResult.success("分配角色成功");
    } else {
      return CommonResult.failed("分配角色失败");
    }
  }
}
