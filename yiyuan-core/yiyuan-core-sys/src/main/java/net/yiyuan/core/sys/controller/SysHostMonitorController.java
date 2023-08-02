package net.yiyuan.core.sys.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.core.sys.dto.*;
import net.yiyuan.core.sys.service.SysHostMonitorService;
import net.yiyuan.core.sys.vo.SysHostMonitorQueryCountVO;
import net.yiyuan.core.sys.vo.SysHostMonitorQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 服务器监控采集管理
 *
 * @author 一源团队--花和尚
 * @date 2023-07-30
 * @module 系统管理
 * @folder 系统管理/服务器监控采集管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class SysHostMonitorController {
  @Autowired private SysHostMonitorService sysHostMonitorService;

  /**
   * 服务器监控采集列表(全部)
   *
   * @param request 服务器监控采集实体
   * @return {@link CommonResult<List<SysHostMonitorQueryVO>>}
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @Description("系统管理/服务器监控采集管理/查询服务器监控采集")
  @SaCheckPermission(
      value = {"sys:hostMonitor:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/hostMonitor/list")
  @ResponseBody
  public CommonResult<List<SysHostMonitorQueryVO>> list(SysHostMonitorListDTO request)
      throws Exception {
    return CommonResult.success(sysHostMonitorService.list(request), "查询服务器监控采集列表成功");
  }

  /**
   * 服务器监控采集列表(分页)
   *
   * @param request 服务器监控采集实体
   * @return {@link CommonResult<Page<SysHostMonitorQueryVO>>}
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @Description("系统管理/服务器监控采集管理/查询服务器监控采集")
  @SaCheckPermission(
      value = {"sys:hostMonitor:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/hostMonitor/page")
  @ResponseBody
  public CommonResult<Page<SysHostMonitorQueryVO>> page(SysHostMonitorPageDTO request)
      throws Exception {
    return CommonResult.success(sysHostMonitorService.page(request), "分页查询服务器监控采集成功");
  }

  /**
   * 服务器监控采集详情
   *
   * @param id 服务器监控采集id
   * @return {@link CommonResult<SysHostMonitorQueryVO>}
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @Description("系统管理/服务器监控采集管理/查询服务器监控采集")
  @SaCheckPermission(
      value = {"sys:hostMonitor:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/hostMonitor/details/{id}")
  @ResponseBody
  public CommonResult<SysHostMonitorQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(sysHostMonitorService.details(id), "查询服务器监控采集详情成功");
  }

  /**
   * 删除服务器监控采集(支持批量)
   *
   * @param ids 服务器监控采集id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @Description("系统管理/服务器监控采集管理/删除服务器监控采集")
  @SaCheckPermission(
      value = {"sys:hostMonitor:delete"},
      orRole = "admin")
  @PostMapping(value = "/sys/hostMonitor/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (sysHostMonitorService.delete(ids)) {
      return CommonResult.success(null, "删除服务器监控采集成功");
    } else {
      return CommonResult.failed("删除服务器监控采集失败");
    }
  }
  /**
   * 编辑服务器监控采集
   *
   * @param request 服务器监控采集实体
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @Description("系统管理/服务器监控采集管理/编辑服务器监控采集")
  @SaCheckPermission(
      value = {"sys:hostMonitor:edit"},
      orRole = "admin")
  @PostMapping(value = "/sys/hostMonitor/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated SysHostMonitorEditDTO request)
      throws Exception {
    if (sysHostMonitorService.edit(request)) {
      return CommonResult.success(null, "修改服务器监控采集成功");
    } else {
      return CommonResult.failed("修改服务器监控采集失败");
    }
  }

  /**
   * 新增服务器监控采集
   *
   * @param request 服务器监控采集实体
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @Description("系统管理/服务器监控采集管理/新增服务器监控采集")
  @SaCheckPermission(
      value = {"sys:hostMonitor:add"},
      orRole = "admin")
  @PostMapping(value = "/sys/hostMonitor/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated SysHostMonitorAddDTO request)
      throws Exception {
    if (sysHostMonitorService.add(request)) {
      return CommonResult.success(null, "新增服务器监控采集成功");
    } else {
      return CommonResult.failed("新增服务器监控采集失败");
    }
  }

  /**
   * 服务器监控统计查询
   *
   * @param request 服务器监控采集实体
   * @return {@link CommonResult<List<SysHostMonitorQueryVO>>}
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @Description("系统管理/服务器监控采集管理/服务器监控统计查询")
  @SaCheckPermission(
      value = {"sys:hostMonitor:queryCount"},
      orRole = "admin")
  @GetMapping(value = "/sys/hostMonitor/queryCount")
  @ResponseBody
  public CommonResult<List<SysHostMonitorQueryCountVO>> queryCount(
      @Validated SysHostMonitorQueryCountDTO request) throws Exception {

    return CommonResult.success(sysHostMonitorService.queryCount(request), "查询服务器监控采集列表成功");
  }
}
