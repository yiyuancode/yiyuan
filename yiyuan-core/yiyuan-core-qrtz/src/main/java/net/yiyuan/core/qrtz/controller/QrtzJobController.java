package net.yiyuan.core.qrtz.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.core.qrtz.dto.QrtzJobAddDTO;
import net.yiyuan.core.qrtz.dto.QrtzJobEditDTO;
import net.yiyuan.core.qrtz.dto.QrtzJobListDTO;
import net.yiyuan.core.qrtz.dto.QrtzJobPageDTO;
import net.yiyuan.core.qrtz.service.QrtzJobService;
import net.yiyuan.core.qrtz.vo.QrtzJobQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 定时任务管理管理
 *
 * @author 一源团队--花和尚
 * @date 2023-07-28
 * @module 定时任务管理
 * @folder 定时任务管理/定时任务管理管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class QrtzJobController {
  @Autowired private QrtzJobService qrtzJobService;

  /**
   * 定时任务管理列表(全部)
   *
   * @param request 定时任务管理实体
   * @return {@link CommonResult<List<QrtzJobQueryVO>>}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Description("定时任务管理/定时任务管理管理/查询定时任务管理")
  @SaCheckPermission(
      value = {"qrtz:job:query"},
      orRole = "admin")
  @GetMapping(value = "/qrtz/job/list")
  @ResponseBody
  public CommonResult<List<QrtzJobQueryVO>> list(QrtzJobListDTO request) throws Exception {
    return CommonResult.success(qrtzJobService.list(request), "查询定时任务管理列表成功");
  }

  /**
   * 定时任务管理列表(分页)
   *
   * @param request 定时任务管理实体
   * @return {@link CommonResult<Page<QrtzJobQueryVO>>}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Description("定时任务管理/定时任务管理管理/查询定时任务管理")
  @SaCheckPermission(
      value = {"qrtz:job:query"},
      orRole = "admin")
  @GetMapping(value = "/qrtz/job/page")
  @ResponseBody
  public CommonResult<Page<QrtzJobQueryVO>> page(QrtzJobPageDTO request) throws Exception {
    return CommonResult.success(qrtzJobService.page(request), "分页查询定时任务管理成功");
  }

  /**
   * 定时任务管理详情
   *
   * @param id 定时任务管理id
   * @return {@link CommonResult<QrtzJobQueryVO>}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Description("定时任务管理/定时任务管理管理/查询定时任务管理")
  @SaCheckPermission(
      value = {"qrtz:job:query"},
      orRole = "admin")
  @GetMapping(value = "/qrtz/job/details/{id}")
  @ResponseBody
  public CommonResult<QrtzJobQueryVO> details(
      @PathVariable("id") @Validated({NotBlank.class}) String id) throws Exception {
    return CommonResult.success(qrtzJobService.details(id), "查询定时任务管理详情成功");
  }

  /**
   * 删除定时任务管理(支持批量)
   *
   * @param ids 定时任务管理id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Description("定时任务管理/定时任务管理管理/删除定时任务管理")
  @SaCheckPermission(
      value = {"qrtz:job:delete"},
      orRole = "admin")
  @PostMapping(value = "/qrtz/job/delete")
  @ResponseBody
  public CommonResult<String> delete(@RequestParam @Validated({NotBlank.class}) String ids)
      throws Exception {
    if (qrtzJobService.delete(ids)) {
      return CommonResult.success(null, "删除定时任务管理成功");
    } else {
      return CommonResult.failed("删除定时任务管理失败");
    }
  }

  /**
   * 编辑定时任务管理
   *
   * @param request 定时任务管理实体
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Description("定时任务管理/定时任务管理管理/编辑定时任务管理")
  @SaCheckPermission(
      value = {"qrtz:job:edit"},
      orRole = "admin")
  @PostMapping(value = "/qrtz/job/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated QrtzJobEditDTO request)
      throws Exception {
    if (qrtzJobService.edit(request)) {
      return CommonResult.success(null, "修改定时任务管理成功");
    } else {
      return CommonResult.failed("修改定时任务管理失败");
    }
  }

  /**
   * 新增定时任务管理
   *
   * @param request 定时任务管理实体
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Description("定时任务管理/定时任务管理管理/新增定时任务管理")
  @SaCheckPermission(
      value = {"qrtz:job:add"},
      orRole = "admin")
  @PostMapping(value = "/qrtz/job/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated QrtzJobAddDTO request) throws Exception {
    if (qrtzJobService.add(request)) {
      return CommonResult.success(null, "新增定时任务管理成功");
    } else {
      return CommonResult.failed("新增定时任务管理失败");
    }
  }
}
