package net.yiyuan.core.sys.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.core.sys.model.SysHost;
import net.yiyuan.core.sys.service.SysHostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 主机记录管理
 *
 * @author 一源团队--花和尚
 * @date 2023-07-16
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
   * @return {@link CommonResult<List<SysHost>>}
   * @author 一源团队--花和尚
   * @date 2023-07-16
   */
  @Description("系统管理/主机记录管理/查询主机记录")
  @SaCheckPermission(
      value = {"sys:host:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/host/list")
  @ResponseBody
  public CommonResult<List<SysHost>> list(SysHost request) throws Exception {
    return CommonResult.success(sysHostService.list(request), "查询主机记录列表成功");
  }

  /**
   * 主机记录列表(分页)
   *
   * @param request 主机记录实体
   * @return {@link CommonResult<Page<SysHost>>}
   * @author 一源团队--花和尚
   * @date 2023-07-16
   */
  @Description("系统管理/主机记录管理/查询主机记录")
  @SaCheckPermission(
      value = {"sys:host:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/host/pages")
  @ResponseBody
  public CommonResult<Page<SysHost>> pages(
      SysHost request,
      @RequestParam(defaultValue = "10") Integer pageSize,
      @RequestParam(defaultValue = "1") Integer pageNum)
      throws Exception {
    return CommonResult.success(sysHostService.pages(request, pageSize, pageNum), "分页查询主机记录成功");
  }

  /**
   * 主机记录详情
   *
   * @param id 主机记录id
   * @return {@link CommonResult<SysHost>}
   * @author 一源团队--花和尚
   * @date 2023-07-16
   */
  @Description("系统管理/主机记录管理/查询主机记录")
  @SaCheckPermission(
      value = {"sys:host:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/host/details/{id}")
  @ResponseBody
  public CommonResult<SysHost> details(@PathVariable("id") @Validated({NotEmpty.class}) String id)
      throws Exception {
    return CommonResult.success(sysHostService.details(id), "查询主机记录详情成功");
  }

  /**
   * 删除主机记录(支持批量)
   *
   * @param ids 主机记录id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队--花和尚
   * @date 2023-07-16
   */
  @Description("系统管理/主机记录管理/删除主机记录")
  @SaCheckPermission(
      value = {"sys:host:delete"},
      orRole = "admin")
  @PostMapping(value = "/sys/host/delete")
  @ResponseBody
  public CommonResult<String> delete(@RequestParam @Validated({NotEmpty.class}) String ids)
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
   * @date 2023-07-16
   */
  @Description("系统管理/主机记录管理/编辑主机记录")
  @SaCheckPermission(
      value = {"sys:host:edit"},
      orRole = "admin")
  @PostMapping(value = "/sys/host/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated SysHost request) throws Exception {
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
   * @date 2023-07-16
   */
  @Description("系统管理/主机记录管理/新增主机记录")
  @SaCheckPermission(
      value = {"sys:host:add"},
      orRole = "admin")
  @PostMapping(value = "/sys/host/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated SysHost request) throws Exception {
    if (sysHostService.add(request)) {
      return CommonResult.success(null, "新增主机记录成功");
    } else {
      return CommonResult.failed("新增主机记录失败");
    }
  }
}
