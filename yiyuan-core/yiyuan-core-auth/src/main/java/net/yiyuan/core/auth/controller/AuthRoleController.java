package net.yiyuan.core.auth.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.core.auth.model.AuthRole;
import net.yiyuan.core.auth.model.assign_menu.AssignMenuReq;
import net.yiyuan.core.auth.service.AuthRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 角色管理
 *
 * @author 一源团队--花和尚
 * @date 2023-07-02
 * @module 权限管理
 * @folder 权限管理/角色管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class AuthRoleController {
  @Autowired private AuthRoleService authRoleService;

  /**
   * 角色列表(全部)
   *
   * @param request 角色实体
   * @return {@link CommonResult<List<AuthRole>>}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @SaCheckPermission(
      value = {"auth:auth_role:list"},
      orRole = "admin")
  @RequestMapping(value = "/auth/auth_role/list", method = RequestMethod.GET)
  @ResponseBody
  public CommonResult<List<AuthRole>> list(AuthRole request) throws Exception {
    return CommonResult.success(authRoleService.list(request));
  }

  /**
   * 角色列表(分页)
   *
   * @param request 角色实体
   * @return {@link CommonResult<Page<AuthRole>>}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @SaCheckPermission(
      value = {"auth:auth_role:pages"},
      orRole = "admin")
  @RequestMapping(value = "/auth/auth_role/pages", method = RequestMethod.GET)
  @ResponseBody
  public CommonResult<Page<AuthRole>> pages(
      AuthRole request,
      @RequestParam(defaultValue = "10") Integer pageSize,
      @RequestParam(defaultValue = "1") Integer pageNum)
      throws Exception {
    return CommonResult.success(authRoleService.pages(request, pageSize, pageNum));
  }

  /**
   * 角色详情
   *
   * @param request 角色实体
   * @return {@link CommonResult<AuthRole>}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @SaCheckPermission(
      value = {"auth:auth_role:details"},
      orRole = "admin")
  @RequestMapping(value = "/auth/auth_role/details", method = RequestMethod.GET)
  @ResponseBody
  public CommonResult<AuthRole> details(AuthRole request) throws Exception {
    return CommonResult.success(authRoleService.details(request));
  }

  /**
   * 删除角色
   *
   * @param request 角色实体
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @SaCheckPermission(
      value = {"auth:auth_role:del"},
      orRole = "admin")
  @RequestMapping(value = "/auth/auth_role/del", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<String> del(@RequestBody @Validated AuthRole request) throws Exception {
    if (authRoleService.del(request)) {
      return CommonResult.success("删除角色成功");
    } else {
      return CommonResult.failed("删除角色失败");
    }
  }

  /**
   * 批量删除角色
   *
   * @param ids 逗号分割id
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @SaCheckPermission(
      value = {"auth:auth_role:dels"},
      orRole = "admin")
  @RequestMapping(value = "/auth/auth_role/dels", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<String> dels(@RequestParam @Validated({NotEmpty.class}) String ids)
      throws Exception {
    if (authRoleService.dels(ids)) {
      return CommonResult.success("批量删除角色成功");
    } else {
      return CommonResult.failed("批量删除角色失败");
    }
  }
  /**
   * 编辑角色
   *
   * @param request 角色实体
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @SaCheckPermission(
      value = {"auth:auth_role:edit"},
      orRole = "admin")
  @RequestMapping(value = "/auth/auth_role/edit", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated AuthRole request) throws Exception {
    if (authRoleService.edit(request)) {
      return CommonResult.success("修改角色成功");
    } else {
      return CommonResult.failed("修改角色失败");
    }
  }

  /**
   * 新增角色
   *
   * @param request 角色实体
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @SaCheckPermission(
      value = {"auth:auth_role:add"},
      orRole = "admin")
  @RequestMapping(value = "/auth/auth_role/add", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated AuthRole request) throws Exception {
    if (authRoleService.add(request)) {
      return CommonResult.success("新增角色成功");
    } else {
      return CommonResult.failed("新增角色失败");
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
  @SaCheckPermission(
      value = {"auth:auth_admin:assignMenu"},
      orRole = "admin")
  @RequestMapping(value = "/auth/auth_admin/assignMenu", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<String> assignMenu(@RequestBody @Validated AssignMenuReq request)
      throws Exception {
    if (authRoleService.assignMenu(request)) {
      return CommonResult.success("分配菜单成功");
    } else {
      return CommonResult.failed("分配菜单失败");
    }
  }
}
