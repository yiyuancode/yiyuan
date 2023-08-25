package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.SysMenuAddDTO;
import net.yiyuan.dto.SysMenuEditDTO;
import net.yiyuan.dto.SysMenuListDTO;
import net.yiyuan.dto.SysMenuPageDTO;
import net.yiyuan.service.SysMenuService;
import net.yiyuan.vo.SysMenuQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 菜单管理
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
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
   * @return {@link CommonResult<List<SysMenuQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Description("系统管理/菜单管理/查询菜单")
  @SaCheckPermission(
      value = {"sys:menu:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/menu/list")
  @ResponseBody
  public CommonResult<List<SysMenuQueryVO>> list(SysMenuListDTO request) throws Exception {
    return CommonResult.success(sysMenuService.list(request), "查询菜单列表成功");
  }

  /**
   * 菜单列表(分页)
   *
   * @param request 菜单实体
   * @return {@link CommonResult<Page<SysMenuQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Description("系统管理/菜单管理/查询菜单")
  @SaCheckPermission(
      value = {"sys:menu:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/menu/page")
  @ResponseBody
  public CommonResult<Page<SysMenuQueryVO>> page(SysMenuPageDTO request) throws Exception {
    return CommonResult.success(sysMenuService.page(request), "分页查询菜单成功");
  }

  /**
   * 菜单详情
   *
   * @param id 菜单id
   * @return {@link CommonResult<SysMenuQueryVO>}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Description("系统管理/菜单管理/查询菜单")
  @SaCheckPermission(
      value = {"sys:menu:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/menu/details/{id}")
  @ResponseBody
  public CommonResult<SysMenuQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(sysMenuService.details(id), "查询菜单详情成功");
  }

  /**
   * 删除菜单(支持批量)
   *
   * @param ids 菜单id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Description("系统管理/菜单管理/删除菜单")
  @SaCheckPermission(
      value = {"sys:menu:delete"},
      orRole = "admin")
  @PostMapping(value = "/sys/menu/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (sysMenuService.delete(ids)) {
      return CommonResult.success(null, "删除菜单成功");
    } else {
      return CommonResult.failed("删除菜单失败");
    }
  }

  /**
   * 编辑菜单
   *
   * @param request 菜单实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Description("系统管理/菜单管理/编辑菜单")
  @SaCheckPermission(
      value = {"sys:menu:edit"},
      orRole = "admin")
  @PostMapping(value = "/sys/menu/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated SysMenuEditDTO request)
      throws Exception {
    if (sysMenuService.edit(request)) {
      return CommonResult.success(null, "修改菜单成功");
    } else {
      return CommonResult.failed("修改菜单失败");
    }
  }

  /**
   * 新增菜单
   *
   * @param request 菜单实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Description("系统管理/菜单管理/新增菜单")
  @SaCheckPermission(
      value = {"sys:menu:add"},
      orRole = "admin")
  @PostMapping(value = "/sys/menu/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated SysMenuAddDTO request) throws Exception {
    if (sysMenuService.add(request)) {
      return CommonResult.success(null, "新增菜单成功");
    } else {
      return CommonResult.failed("新增菜单失败");
    }
  }

  /**
   * 自动生成菜单
   *
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @SaCheckPermission(
      value = {"sys:menu:autoScanMenu"},
      orRole = "admin")
  @PostMapping(value = "/sys/menu/autoScanMenu")
  @ResponseBody
  public CommonResult<String> autoScanMenu() throws Exception {
    if (sysMenuService.autoScanMenu()) {
      return CommonResult.success(null, "自动生成菜单成功");
    } else {
      return CommonResult.failed("自动生成菜单失败");
    }
  }
}
