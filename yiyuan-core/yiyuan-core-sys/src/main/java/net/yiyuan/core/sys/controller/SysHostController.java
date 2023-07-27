package net.yiyuan.core.sys.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.core.sys.dto.SysHostAddDTO;
import net.yiyuan.core.sys.dto.SysHostEditDTO;
import net.yiyuan.core.sys.dto.SysHostListDTO;
import net.yiyuan.core.sys.dto.SysHostPageDTO;
import net.yiyuan.core.sys.service.SysHostService;
import net.yiyuan.core.sys.vo.SysHostQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 主机记录管理
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 * @module 系统管理
 * @folder 系统管理/主机记录管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class SysHostController {
  @Autowired private SysHostService sysHostService;

  /**
   * 主机记录列表(全部)
   *
   * @param request 主机记录实体
   * @return {@link CommonResult<List<SysHostQueryVO>>}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Description("系统管理/主机记录管理/查询主机记录")
  @SaCheckPermission(
      value = {"sys:host:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/host/list")
  @ResponseBody
  public CommonResult<List<SysHostQueryVO>> list(SysHostListDTO request) throws Exception {
    return CommonResult.success(sysHostService.list(request), "查询主机记录列表成功");
  }

  /**
   * 主机记录列表(分页)
   *
   * @param request 主机记录实体
   * @return {@link CommonResult<Page<SysHostQueryVO>>}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Description("系统管理/主机记录管理/查询主机记录")
  @SaCheckPermission(
      value = {"sys:host:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/host/page")
  @ResponseBody
  public CommonResult<Page<SysHostQueryVO>> page(SysHostPageDTO request) throws Exception {
    return CommonResult.success(sysHostService.page(request), "分页查询主机记录成功");
  }

  /**
   * 主机记录详情
   *
   * @param id 主机记录id
   * @return {@link CommonResult<SysHostQueryVO>}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Description("系统管理/主机记录管理/查询主机记录")
  @SaCheckPermission(
      value = {"sys:host:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/host/details/{id}")
  @ResponseBody
  public CommonResult<SysHostQueryVO> details(
      @PathVariable("id") @Validated({NotBlank.class}) String id) throws Exception {
    return CommonResult.success(sysHostService.details(id), "查询主机记录详情成功");
  }

  /**
   * 删除主机记录(支持批量)
   *
   * @param ids 主机记录id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Description("系统管理/主机记录管理/删除主机记录")
  @SaCheckPermission(
      value = {"sys:host:delete"},
      orRole = "admin")
  @PostMapping(value = "/sys/host/delete")
  @ResponseBody
  public CommonResult<String> delete(@RequestParam @Validated({NotBlank.class}) String ids)
      throws Exception {
    if (sysHostService.delete(ids)) {
      return CommonResult.success(null, "删除主机记录成功");
    } else {
      return CommonResult.failed("删除主机记录失败");
    }
  }

  /**
   * 编辑主机记录
   *
   * @param request 主机记录实体
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Description("系统管理/主机记录管理/编辑主机记录")
  @SaCheckPermission(
      value = {"sys:host:edit"},
      orRole = "admin")
  @PostMapping(value = "/sys/host/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated SysHostEditDTO request)
      throws Exception {
    if (sysHostService.edit(request)) {
      return CommonResult.success(null, "修改主机记录成功");
    } else {
      return CommonResult.failed("修改主机记录失败");
    }
  }

  /**
   * 新增主机记录
   *
   * @param request 主机记录实体
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Description("系统管理/主机记录管理/新增主机记录")
  @SaCheckPermission(
      value = {"sys:host:add"},
      orRole = "admin")
  @PostMapping(value = "/sys/host/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated SysHostAddDTO request) throws Exception {
    if (sysHostService.add(request)) {
      return CommonResult.success(null, "新增主机记录成功");
    } else {
      return CommonResult.failed("新增主机记录失败");
    }
  }
}
