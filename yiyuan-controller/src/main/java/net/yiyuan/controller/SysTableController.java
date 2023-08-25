package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.SysTableAddDTO;
import net.yiyuan.dto.SysTableEditDTO;
import net.yiyuan.dto.SysTableListDTO;
import net.yiyuan.dto.SysTablePageDTO;
import net.yiyuan.service.SysTableService;
import net.yiyuan.vo.SysTableQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 数据库管理
 *
 * @author 一源团队-花和尚
 * @date 2023-08-25
 * @folder 系统管理/数据库管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class SysTableController {
  @Autowired private SysTableService sysTableService;

  /**
   * 数据库列表(全部)
   *
   * @param request 数据库实体
   * @return {@link CommonResult<List<SysTableQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  @Description("系统管理/数据库管理/查询数据库")
  @SaCheckPermission(
      value = {"sys:table:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/table/list")
  @ResponseBody
  public CommonResult<List<SysTableQueryVO>> list(SysTableListDTO request) throws Exception {
    return CommonResult.success(sysTableService.list(request), "查询数据库列表成功");
  }

  /**
   * 数据库列表(分页)
   *
   * @param request 数据库实体
   * @return {@link CommonResult<Page<SysTableQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  @Description("系统管理/数据库管理/查询数据库")
  @SaCheckPermission(
      value = {"sys:table:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/table/page")
  @ResponseBody
  public CommonResult<Page<SysTableQueryVO>> page(SysTablePageDTO request) throws Exception {
    return CommonResult.success(sysTableService.page(request), "分页查询数据库成功");
  }

  /**
   * 数据库详情
   *
   * @param id 数据库id
   * @return {@link CommonResult<SysTableQueryVO>}
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  @Description("系统管理/数据库管理/查询数据库")
  @SaCheckPermission(
      value = {"sys:table:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/table/details/{id}")
  @ResponseBody
  public CommonResult<SysTableQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(sysTableService.details(id), "查询数据库详情成功");
  }

  /**
   * 删除数据库(支持批量)
   *
   * @param ids 数据库id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  @Description("系统管理/数据库管理/删除数据库")
  @SaCheckPermission(
      value = {"sys:table:delete"},
      orRole = "admin")
  @PostMapping(value = "/sys/table/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (sysTableService.delete(ids)) {
      return CommonResult.success(null, "删除数据库成功");
    } else {
      return CommonResult.failed("删除数据库失败");
    }
  }

  /**
   * 编辑数据库
   *
   * @param request 数据库实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  @Description("系统管理/数据库管理/编辑数据库")
  @SaCheckPermission(
      value = {"sys:table:edit"},
      orRole = "admin")
  @PostMapping(value = "/sys/table/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated SysTableEditDTO request)
      throws Exception {
    if (sysTableService.edit(request)) {
      return CommonResult.success(null, "修改数据库成功");
    } else {
      return CommonResult.failed("修改数据库失败");
    }
  }

  /**
   * 新增数据库
   *
   * @param request 数据库实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  @Description("系统管理/数据库管理/新增数据库")
  @SaCheckPermission(
      value = {"sys:table:add"},
      orRole = "admin")
  @PostMapping(value = "/sys/table/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated SysTableAddDTO request) throws Exception {
    if (sysTableService.add(request)) {
      return CommonResult.success(null, "新增数据库成功");
    } else {
      return CommonResult.failed("新增数据库失败");
    }
  }
}
