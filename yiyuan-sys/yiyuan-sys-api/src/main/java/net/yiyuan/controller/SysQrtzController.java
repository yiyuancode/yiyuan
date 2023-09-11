package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.SysQrtzAddDTO;
import net.yiyuan.dto.SysQrtzEditDTO;
import net.yiyuan.dto.SysQrtzListDTO;
import net.yiyuan.dto.SysQrtzPageDTO;
import net.yiyuan.service.SysQrtzService;
import net.yiyuan.vo.SysQrtzQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 定时任务管理
 *
 * @author 一源团队-花和尚
 * @date 2023-09-11
 * @folder 系统管理/定时任务管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class SysQrtzController {
  @Autowired private SysQrtzService sysQrtzService;

  /**
   * 定时任务列表(全部)
   *
   * @param request 定时任务实体
   * @return {@link CommonResult<List<SysQrtzQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @Description("系统管理/定时任务管理/查询定时任务")
  @SaCheckPermission(
      value = {"sys:qrtz:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/qrtz/list")
  @ResponseBody
  public CommonResult<List<SysQrtzQueryVO>> list(SysQrtzListDTO request) throws Exception {
    return CommonResult.success(sysQrtzService.list(request), "查询定时任务列表成功");
  }

  /**
   * 定时任务列表(分页)
   *
   * @param request 定时任务实体
   * @return {@link CommonResult<Page<SysQrtzQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @Description("系统管理/定时任务管理/查询定时任务")
  @SaCheckPermission(
      value = {"sys:qrtz:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/qrtz/page")
  @ResponseBody
  public CommonResult<Page<SysQrtzQueryVO>> page(SysQrtzPageDTO request) throws Exception {
    return CommonResult.success(sysQrtzService.page(request), "分页查询定时任务成功");
  }

  /**
   * 定时任务详情
   *
   * @param id 定时任务id
   * @return {@link CommonResult<SysQrtzQueryVO>}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @Description("系统管理/定时任务管理/查询定时任务")
  @SaCheckPermission(
      value = {"sys:qrtz:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/qrtz/details/{id}")
  @ResponseBody
  public CommonResult<SysQrtzQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(sysQrtzService.details(id), "查询定时任务详情成功");
  }

  /**
   * 删除定时任务(支持批量)
   *
   * @param ids 定时任务id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @Description("系统管理/定时任务管理/删除定时任务")
  @SaCheckPermission(
      value = {"sys:qrtz:delete"},
      orRole = "admin")
  @PostMapping(value = "/sys/qrtz/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (sysQrtzService.delete(ids)) {
      return CommonResult.success(null, "删除定时任务成功");
    } else {
      return CommonResult.failed("删除定时任务失败");
    }
  }

  /**
   * 编辑定时任务
   *
   * @param request 定时任务实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @Description("系统管理/定时任务管理/编辑定时任务")
  @SaCheckPermission(
      value = {"sys:qrtz:edit"},
      orRole = "admin")
  @PostMapping(value = "/sys/qrtz/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated SysQrtzEditDTO request)
      throws Exception {
    if (sysQrtzService.edit(request)) {
      return CommonResult.success(null, "修改定时任务成功");
    } else {
      return CommonResult.failed("修改定时任务失败");
    }
  }

  /**
   * 新增定时任务
   *
   * @param request 定时任务实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @Description("系统管理/定时任务管理/新增定时任务")
  @SaCheckPermission(
      value = {"sys:qrtz:add"},
      orRole = "admin")
  @PostMapping(value = "/sys/qrtz/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated SysQrtzAddDTO request) throws Exception {
    if (sysQrtzService.add(request)) {
      return CommonResult.success(null, "新增定时任务成功");
    } else {
      return CommonResult.failed("新增定时任务失败");
    }
  }
}
