package net.yiyuan.core.sys.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.core.sys.dto.*;
import net.yiyuan.core.sys.service.SysRedisMonitorService;
import net.yiyuan.core.sys.vo.SysRedisMonitorQueryCountVO;
import net.yiyuan.core.sys.vo.SysRedisMonitorQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * Redis监控采集管理
 *
 * @author 一源团队--花和尚
 * @date 2023-08-02
 * @module 系统管理
 * @folder 系统管理/Redis监控采集管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class SysRedisMonitorController {
  @Autowired private SysRedisMonitorService sysRedisMonitorService;

  /**
   * Redis监控采集列表(全部)
   *
   * @param request Redis监控采集实体
   * @return {@link CommonResult<List<SysRedisMonitorQueryVO>>}
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  @Description("系统管理/Redis监控采集管理/查询Redis监控采集")
  @SaCheckPermission(
      value = {"sys:reidsMonitor:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/reidsMonitor/list")
  @ResponseBody
  public CommonResult<List<SysRedisMonitorQueryVO>> list(SysRedisMonitorListDTO request)
      throws Exception {
    return CommonResult.success(sysRedisMonitorService.list(request), "查询Redis监控采集列表成功");
  }

  /**
   * Redis监控采集列表(分页)
   *
   * @param request Redis监控采集实体
   * @return {@link CommonResult<Page<SysRedisMonitorQueryVO>>}
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  @Description("系统管理/Redis监控采集管理/查询Redis监控采集")
  @SaCheckPermission(
      value = {"sys:reidsMonitor:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/reidsMonitor/page")
  @ResponseBody
  public CommonResult<Page<SysRedisMonitorQueryVO>> page(SysRedisMonitorPageDTO request)
      throws Exception {
    return CommonResult.success(sysRedisMonitorService.page(request), "分页查询Redis监控采集成功");
  }

  /**
   * Redis监控采集详情
   *
   * @param id Redis监控采集id
   * @return {@link CommonResult<SysRedisMonitorQueryVO>}
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  @Description("系统管理/Redis监控采集管理/查询Redis监控采集")
  @SaCheckPermission(
      value = {"sys:reidsMonitor:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/reidsMonitor/details/{id}")
  @ResponseBody
  public CommonResult<SysRedisMonitorQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(sysRedisMonitorService.details(id), "查询Redis监控采集详情成功");
  }

  /**
   * 删除Redis监控采集(支持批量)
   *
   * @param ids Redis监控采集id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  @Description("系统管理/Redis监控采集管理/删除Redis监控采集")
  @SaCheckPermission(
      value = {"sys:reidsMonitor:delete"},
      orRole = "admin")
  @PostMapping(value = "/sys/reidsMonitor/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (sysRedisMonitorService.delete(ids)) {
      return CommonResult.success(null, "删除Redis监控采集成功");
    } else {
      return CommonResult.failed("删除Redis监控采集失败");
    }
  }
  /**
   * 编辑Redis监控采集
   *
   * @param request Redis监控采集实体
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  @Description("系统管理/Redis监控采集管理/编辑Redis监控采集")
  @SaCheckPermission(
      value = {"sys:reidsMonitor:edit"},
      orRole = "admin")
  @PostMapping(value = "/sys/reidsMonitor/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated SysRedisMonitorEditDTO request)
      throws Exception {
    if (sysRedisMonitorService.edit(request)) {
      return CommonResult.success(null, "修改Redis监控采集成功");
    } else {
      return CommonResult.failed("修改Redis监控采集失败");
    }
  }

  /**
   * 新增Redis监控采集
   *
   * @param request Redis监控采集实体
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  @Description("系统管理/Redis监控采集管理/新增Redis监控采集")
  @SaCheckPermission(
      value = {"sys:reidsMonitor:add"},
      orRole = "admin")
  @PostMapping(value = "/sys/reidsMonitor/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated SysRedisMonitorAddDTO request)
      throws Exception {
    if (sysRedisMonitorService.add(request)) {
      return CommonResult.success(null, "新增Redis监控采集成功");
    } else {
      return CommonResult.failed("新增Redis监控采集失败");
    }
  }

  /**
   * redis监控统计查询
   *
   * @param request redis监控采集实体
   * @return {@link CommonResult<List< SysRedisMonitorQueryCountVO >>}
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @Description("系统管理/Redis监控采集管理/redis监控统计查询")
  @SaCheckPermission(
      value = {"sys:hostMonitor:queryCount"},
      orRole = "admin")
  @GetMapping(value = "/sys/reidsMonitor/queryCount")
  @ResponseBody
  public CommonResult<List<SysRedisMonitorQueryCountVO>> queryCount(
      @Validated SysrRedisMonitorQueryCountDTO request) throws Exception {

    return CommonResult.success(sysRedisMonitorService.queryCount(request), "查询服务器监控采集列表成功");
  }
}
