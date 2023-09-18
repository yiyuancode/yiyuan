package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.SysRoleAddDTO;
import net.yiyuan.dto.SysRoleEditDTO;
import net.yiyuan.dto.SysRoleListDTO;
import net.yiyuan.dto.SysRolePageDTO;
import net.yiyuan.service.SysRoleService;
import net.yiyuan.vo.SysRoleQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 管理端角色管理
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 * @folder 系统管理/管理端角色管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class SysRoleController {
  @Autowired private SysRoleService sysRoleService;

  /**
   * 管理端角色列表(全部)
   *
   * @param request 管理端角色实体
   * @return {@link CommonResult<List<SysRoleQueryVO>>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Description("系统管理/管理端角色管理/查询管理端角色")
  @SaCheckPermission(
      value = {"sys:role:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/role/list")
  @ResponseBody
  public CommonResult<List<SysRoleQueryVO>> list(SysRoleListDTO request) throws Exception {
    return CommonResult.success(sysRoleService.list(request), "查询管理端角色列表成功");
  }

  /**
   * 管理端角色列表(分页)
   *
   * @param request 管理端角色实体
   * @return {@link CommonResult<Page<SysRoleQueryVO>>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Description("系统管理/管理端角色管理/查询管理端角色")
  @SaCheckPermission(
      value = {"sys:role:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/role/page")
  @ResponseBody
  public CommonResult<Page<SysRoleQueryVO>> page(SysRolePageDTO request) throws Exception {
    return CommonResult.success(sysRoleService.page(request), "分页查询管理端角色成功");
  }

  /**
   * 管理端角色详情
   *
   * @param id 管理端角色id
   * @return {@link CommonResult<SysRoleQueryVO>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Description("系统管理/管理端角色管理/查询管理端角色")
  @SaCheckPermission(
      value = {"sys:role:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/role/details/{id}")
  @ResponseBody
  public CommonResult<SysRoleQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(sysRoleService.details(id), "查询管理端角色详情成功");
  }

  /**
   * 删除管理端角色(支持批量)
   *
   * @param ids 管理端角色id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Description("系统管理/管理端角色管理/删除管理端角色")
  @SaCheckPermission(
      value = {"sys:role:delete"},
      orRole = "admin")
  @PostMapping(value = "/sys/role/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (sysRoleService.delete(ids)) {
      return CommonResult.success(null, "删除管理端角色成功");
    } else {
      return CommonResult.failed("删除管理端角色失败");
    }
  }

  /**
   * 编辑管理端角色
   *
   * @param request 管理端角色实体
   * @return {@link CommonResult<String>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Description("系统管理/管理端角色管理/编辑管理端角色")
  @SaCheckPermission(
      value = {"sys:role:edit"},
      orRole = "admin")
  @PostMapping(value = "/sys/role/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated SysRoleEditDTO request)
      throws Exception {
    if (sysRoleService.edit(request)) {
      return CommonResult.success(null, "修改管理端角色成功");
    } else {
      return CommonResult.failed("修改管理端角色失败");
    }
  }

  /**
   * 新增管理端角色
   *
   * @param request 管理端角色实体
   * @return {@link CommonResult<String>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Description("系统管理/管理端角色管理/新增管理端角色")
  @SaCheckPermission(
      value = {"sys:role:add"},
      orRole = "admin")
  @PostMapping(value = "/sys/role/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated SysRoleAddDTO request) throws Exception {
    if (sysRoleService.add(request)) {
      return CommonResult.success(null, "新增管理端角色成功");
    } else {
      return CommonResult.failed("新增管理端角色失败");
    }
  }
}
