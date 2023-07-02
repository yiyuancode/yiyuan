package net.yiyuan.core.sys.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.core.sys.model.SysMenu;
import net.yiyuan.core.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 菜单管理
 *
 * @author 一源团队--花和尚
 * @date 2023-07-02
 * @module 系统管理
 * @folder 系统管理/菜单管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class SysMenuController {
  @Autowired private SysMenuService sysMenuService;

  /**
   * 菜单列表(全部)
   *
   * @param request 菜单实体
   * @return {@link CommonResult<List<SysMenu>>}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @SaCheckPermission(
      value = {"sys:sys_menu:list"},
      orRole = "admin")
  @RequestMapping(value = "/sys/sys_menu/list", method = RequestMethod.GET)
  @ResponseBody
  public CommonResult<List<SysMenu>> list(SysMenu request) throws Exception {
    return CommonResult.success(sysMenuService.list(request));
  }

  /**
   * 菜单列表(分页)
   *
   * @param request 菜单实体
   * @return {@link CommonResult<Page<SysMenu>>}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @SaCheckPermission(
      value = {"sys:sys_menu:pages"},
      orRole = "admin")
  @RequestMapping(value = "/sys/sys_menu/pages", method = RequestMethod.GET)
  @ResponseBody
  public CommonResult<Page<SysMenu>> pages(
      SysMenu request,
      @RequestParam(defaultValue = "10") Integer pageSize,
      @RequestParam(defaultValue = "1") Integer pageNum)
      throws Exception {
    return CommonResult.success(sysMenuService.pages(request, pageSize, pageNum));
  }

  /**
   * 菜单详情
   *
   * @param request 菜单实体
   * @return {@link CommonResult<SysMenu>}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @SaCheckPermission(
      value = {"sys:sys_menu:details"},
      orRole = "admin")
  @RequestMapping(value = "/sys/sys_menu/details", method = RequestMethod.GET)
  @ResponseBody
  public CommonResult<SysMenu> details(SysMenu request) throws Exception {
    return CommonResult.success(sysMenuService.details(request));
  }

  /**
   * 删除菜单
   *
   * @param request 菜单实体
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @SaCheckPermission(
      value = {"sys:sys_menu:del"},
      orRole = "admin")
  @RequestMapping(value = "/sys/sys_menu/del", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<String> del(@RequestBody @Validated SysMenu request) throws Exception {
    if (sysMenuService.del(request)) {
      return CommonResult.success("删除菜单成功");
    } else {
      return CommonResult.failed("删除菜单失败");
    }
  }

  /**
   * 批量删除菜单
   *
   * @param ids 逗号分割id
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @SaCheckPermission(
      value = {"sys:sys_menu:dels"},
      orRole = "admin")
  @RequestMapping(value = "/sys/sys_menu/dels", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<String> dels(@RequestParam @Validated({NotEmpty.class}) String ids)
      throws Exception {
    if (sysMenuService.dels(ids)) {
      return CommonResult.success("批量删除菜单成功");
    } else {
      return CommonResult.failed("批量删除菜单失败");
    }
  }
  /**
   * 编辑菜单
   *
   * @param request 菜单实体
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @SaCheckPermission(
      value = {"sys:sys_menu:edit"},
      orRole = "admin")
  @RequestMapping(value = "/sys/sys_menu/edit", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated SysMenu request) throws Exception {
    if (sysMenuService.edit(request)) {
      return CommonResult.success("修改菜单成功");
    } else {
      return CommonResult.failed("修改菜单失败");
    }
  }

  /**
   * 新增菜单
   *
   * @param request 菜单实体
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  @SaCheckPermission(
      value = {"sys:sys_menu:add"},
      orRole = "admin")
  @RequestMapping(value = "/sys/sys_menu/add", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated SysMenu request) throws Exception {
    if (sysMenuService.add(request)) {
      return CommonResult.success("新增菜单成功");
    } else {
      return CommonResult.failed("新增菜单失败");
    }
  }
}
