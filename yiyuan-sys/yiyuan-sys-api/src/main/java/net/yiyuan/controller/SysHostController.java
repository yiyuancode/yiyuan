package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.SysHostAddDTO;
import net.yiyuan.dto.SysHostEditDTO;
import net.yiyuan.dto.SysHostListDTO;
import net.yiyuan.dto.SysHostPageDTO;
import net.yiyuan.service.SysHostService;
import net.yiyuan.vo.SysHostQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 服务器管理
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 * @folder 系统管理/服务器管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class SysHostController {
  @Autowired private SysHostService sysHostService;

  /**
   * 服务器列表(全部)
   *
   * @param request 服务器实体
   * @return {@link CommonResult<List<SysHostQueryVO>>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Description("系统管理/服务器管理/查询服务器")
  @SaCheckPermission(
      value = {"sys:host:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/host/list")
  @ResponseBody
  public CommonResult<List<SysHostQueryVO>> list(SysHostListDTO request) throws Exception {
    return CommonResult.success(sysHostService.list(request), "查询服务器列表成功");
  }

  /**
   * 服务器列表(分页)
   *
   * @param request 服务器实体
   * @return {@link CommonResult<Page<SysHostQueryVO>>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Description("系统管理/服务器管理/查询服务器")
  @SaCheckPermission(
      value = {"sys:host:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/host/page")
  @ResponseBody
  public CommonResult<Page<SysHostQueryVO>> page(SysHostPageDTO request) throws Exception {
    return CommonResult.success(sysHostService.page(request), "分页查询服务器成功");
  }

  /**
   * 服务器详情
   *
   * @param id 服务器id
   * @return {@link CommonResult<SysHostQueryVO>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Description("系统管理/服务器管理/查询服务器")
  @SaCheckPermission(
      value = {"sys:host:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/host/details/{id}")
  @ResponseBody
  public CommonResult<SysHostQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(sysHostService.details(id), "查询服务器详情成功");
  }

  /**
   * 删除服务器(支持批量)
   *
   * @param ids 服务器id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Description("系统管理/服务器管理/删除服务器")
  @SaCheckPermission(
      value = {"sys:host:delete"},
      orRole = "admin")
  @PostMapping(value = "/sys/host/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (sysHostService.delete(ids)) {
      return CommonResult.success(null, "删除服务器成功");
    } else {
      return CommonResult.failed("删除服务器失败");
    }
  }

  /**
   * 编辑服务器
   *
   * @param request 服务器实体
   * @return {@link CommonResult<String>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Description("系统管理/服务器管理/编辑服务器")
  @SaCheckPermission(
      value = {"sys:host:edit"},
      orRole = "admin")
  @PostMapping(value = "/sys/host/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated SysHostEditDTO request)
      throws Exception {
    if (sysHostService.edit(request)) {
      return CommonResult.success(null, "修改服务器成功");
    } else {
      return CommonResult.failed("修改服务器失败");
    }
  }

  /**
   * 新增服务器
   *
   * @param request 服务器实体
   * @return {@link CommonResult<String>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Description("系统管理/服务器管理/新增服务器")
  @SaCheckPermission(
      value = {"sys:host:add"},
      orRole = "admin")
  @PostMapping(value = "/sys/host/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated SysHostAddDTO request) throws Exception {
    if (sysHostService.add(request)) {
      return CommonResult.success(null, "新增服务器成功");
    } else {
      return CommonResult.failed("新增服务器失败");
    }
  }
}
