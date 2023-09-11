package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.SysDeptAddDTO;
import net.yiyuan.dto.SysDeptEditDTO;
import net.yiyuan.dto.SysDeptListDTO;
import net.yiyuan.dto.SysDeptPageDTO;
import net.yiyuan.service.SysDeptService;
import net.yiyuan.vo.SysDeptQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 部门管理
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 * @folder 系统管理/部门管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class SysDeptController {
  @Autowired private SysDeptService sysDeptService;

  /**
   * 部门列表(全部)
   *
   * @param request 部门实体
   * @return {@link CommonResult<List<SysDeptQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Description("系统管理/部门管理/查询部门")
  @SaCheckPermission(
      value = {"sys:dept:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/dept/list")
  @ResponseBody
  public CommonResult<List<SysDeptQueryVO>> list(SysDeptListDTO request) throws Exception {
    return CommonResult.success(sysDeptService.list(request), "查询部门列表成功");
  }

  /**
   * 部门列表(分页)
   *
   * @param request 部门实体
   * @return {@link CommonResult<Page<SysDeptQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Description("系统管理/部门管理/查询部门")
  @SaCheckPermission(
      value = {"sys:dept:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/dept/page")
  @ResponseBody
  public CommonResult<Page<SysDeptQueryVO>> page(SysDeptPageDTO request) throws Exception {
    return CommonResult.success(sysDeptService.page(request), "分页查询部门成功");
  }

  /**
   * 部门详情
   *
   * @param id 部门id
   * @return {@link CommonResult<SysDeptQueryVO>}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Description("系统管理/部门管理/查询部门")
  @SaCheckPermission(
      value = {"sys:dept:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/dept/details/{id}")
  @ResponseBody
  public CommonResult<SysDeptQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(sysDeptService.details(id), "查询部门详情成功");
  }

  /**
   * 删除部门(支持批量)
   *
   * @param ids 部门id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Description("系统管理/部门管理/删除部门")
  @SaCheckPermission(
      value = {"sys:dept:delete"},
      orRole = "admin")
  @PostMapping(value = "/sys/dept/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (sysDeptService.delete(ids)) {
      return CommonResult.success(null, "删除部门成功");
    } else {
      return CommonResult.failed("删除部门失败");
    }
  }

  /**
   * 编辑部门
   *
   * @param request 部门实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Description("系统管理/部门管理/编辑部门")
  @SaCheckPermission(
      value = {"sys:dept:edit"},
      orRole = "admin")
  @PostMapping(value = "/sys/dept/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated SysDeptEditDTO request)
      throws Exception {
    if (sysDeptService.edit(request)) {
      return CommonResult.success(null, "修改部门成功");
    } else {
      return CommonResult.failed("修改部门失败");
    }
  }

  /**
   * 新增部门
   *
   * @param request 部门实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Description("系统管理/部门管理/新增部门")
  @SaCheckPermission(
      value = {"sys:dept:add"},
      orRole = "admin")
  @PostMapping(value = "/sys/dept/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated SysDeptAddDTO request) throws Exception {
    if (sysDeptService.add(request)) {
      return CommonResult.success(null, "新增部门成功");
    } else {
      return CommonResult.failed("新增部门失败");
    }
  }
}
