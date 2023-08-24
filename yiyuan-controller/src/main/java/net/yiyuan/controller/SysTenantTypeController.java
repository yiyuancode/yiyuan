package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.SysTenantTypeAddDTO;
import net.yiyuan.dto.SysTenantTypeEditDTO;
import net.yiyuan.dto.SysTenantTypeListDTO;
import net.yiyuan.dto.SysTenantTypePageDTO;
import net.yiyuan.service.SysTenantTypeService;
import net.yiyuan.vo.SysTenantTypeQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 租户类型管理
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 * @folder 系统管理/租户类型管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class SysTenantTypeController {
  @Autowired private SysTenantTypeService sysTenantTypeService;

  /**
   * 租户类型列表(全部)
   *
   * @param request 租户类型实体
   * @return {@link CommonResult<List<SysTenantTypeQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Description("系统管理/租户类型管理/查询租户类型")
  @SaCheckPermission(
      value = {"sys:tenantType:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/tenantType/list")
  @ResponseBody
  public CommonResult<List<SysTenantTypeQueryVO>> list(SysTenantTypeListDTO request)
      throws Exception {
    return CommonResult.success(sysTenantTypeService.list(request), "查询租户类型列表成功");
  }

  /**
   * 租户类型列表(分页)
   *
   * @param request 租户类型实体
   * @return {@link CommonResult<Page<SysTenantTypeQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Description("系统管理/租户类型管理/查询租户类型")
  @SaCheckPermission(
      value = {"sys:tenantType:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/tenantType/page")
  @ResponseBody
  public CommonResult<Page<SysTenantTypeQueryVO>> page(SysTenantTypePageDTO request)
      throws Exception {
    return CommonResult.success(sysTenantTypeService.page(request), "分页查询租户类型成功");
  }

  /**
   * 租户类型详情
   *
   * @param id 租户类型id
   * @return {@link CommonResult<SysTenantTypeQueryVO>}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Description("系统管理/租户类型管理/查询租户类型")
  @SaCheckPermission(
      value = {"sys:tenantType:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/tenantType/details/{id}")
  @ResponseBody
  public CommonResult<SysTenantTypeQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(sysTenantTypeService.details(id), "查询租户类型详情成功");
  }

  /**
   * 删除租户类型(支持批量)
   *
   * @param ids 租户类型id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Description("系统管理/租户类型管理/删除租户类型")
  @SaCheckPermission(
      value = {"sys:tenantType:delete"},
      orRole = "admin")
  @PostMapping(value = "/sys/tenantType/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (sysTenantTypeService.delete(ids)) {
      return CommonResult.success(null, "删除租户类型成功");
    } else {
      return CommonResult.failed("删除租户类型失败");
    }
  }

  /**
   * 编辑租户类型
   *
   * @param request 租户类型实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Description("系统管理/租户类型管理/编辑租户类型")
  @SaCheckPermission(
      value = {"sys:tenantType:edit"},
      orRole = "admin")
  @PostMapping(value = "/sys/tenantType/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated SysTenantTypeEditDTO request)
      throws Exception {
    if (sysTenantTypeService.edit(request)) {
      return CommonResult.success(null, "修改租户类型成功");
    } else {
      return CommonResult.failed("修改租户类型失败");
    }
  }

  /**
   * 新增租户类型
   *
   * @param request 租户类型实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Description("系统管理/租户类型管理/新增租户类型")
  @SaCheckPermission(
      value = {"sys:tenantType:add"},
      orRole = "admin")
  @PostMapping(value = "/sys/tenantType/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated SysTenantTypeAddDTO request)
      throws Exception {
    if (sysTenantTypeService.add(request)) {
      return CommonResult.success(null, "新增租户类型成功");
    } else {
      return CommonResult.failed("新增租户类型失败");
    }
  }
}
