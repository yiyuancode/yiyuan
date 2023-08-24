package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.SysTenantInfoAddDTO;
import net.yiyuan.dto.SysTenantInfoEditDTO;
import net.yiyuan.dto.SysTenantInfoListDTO;
import net.yiyuan.dto.SysTenantInfoPageDTO;
import net.yiyuan.service.SysTenantInfoService;
import net.yiyuan.vo.SysTenantInfoQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 租户信息管理
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 * @folder 系统管理/租户信息管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class SysTenantInfoController {
  @Autowired private SysTenantInfoService sysTenantInfoService;

  /**
   * 租户信息列表(全部)
   *
   * @param request 租户信息实体
   * @return {@link CommonResult<List<SysTenantInfoQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Description("系统管理/租户信息管理/查询租户信息")
  @SaCheckPermission(
      value = {"sys:tenantInfo:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/tenantInfo/list")
  @ResponseBody
  public CommonResult<List<SysTenantInfoQueryVO>> list(SysTenantInfoListDTO request)
      throws Exception {
    return CommonResult.success(sysTenantInfoService.list(request), "查询租户信息列表成功");
  }

  /**
   * 租户信息列表(分页)
   *
   * @param request 租户信息实体
   * @return {@link CommonResult<Page<SysTenantInfoQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Description("系统管理/租户信息管理/查询租户信息")
  @SaCheckPermission(
      value = {"sys:tenantInfo:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/tenantInfo/page")
  @ResponseBody
  public CommonResult<Page<SysTenantInfoQueryVO>> page(SysTenantInfoPageDTO request)
      throws Exception {
    return CommonResult.success(sysTenantInfoService.page(request), "分页查询租户信息成功");
  }

  /**
   * 租户信息详情
   *
   * @param id 租户信息id
   * @return {@link CommonResult<SysTenantInfoQueryVO>}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Description("系统管理/租户信息管理/查询租户信息")
  @SaCheckPermission(
      value = {"sys:tenantInfo:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/tenantInfo/details/{id}")
  @ResponseBody
  public CommonResult<SysTenantInfoQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(sysTenantInfoService.details(id), "查询租户信息详情成功");
  }

  /**
   * 删除租户信息(支持批量)
   *
   * @param ids 租户信息id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Description("系统管理/租户信息管理/删除租户信息")
  @SaCheckPermission(
      value = {"sys:tenantInfo:delete"},
      orRole = "admin")
  @PostMapping(value = "/sys/tenantInfo/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (sysTenantInfoService.delete(ids)) {
      return CommonResult.success(null, "删除租户信息成功");
    } else {
      return CommonResult.failed("删除租户信息失败");
    }
  }

  /**
   * 编辑租户信息
   *
   * @param request 租户信息实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Description("系统管理/租户信息管理/编辑租户信息")
  @SaCheckPermission(
      value = {"sys:tenantInfo:edit"},
      orRole = "admin")
  @PostMapping(value = "/sys/tenantInfo/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated SysTenantInfoEditDTO request)
      throws Exception {
    if (sysTenantInfoService.edit(request)) {
      return CommonResult.success(null, "修改租户信息成功");
    } else {
      return CommonResult.failed("修改租户信息失败");
    }
  }

  /**
   * 新增租户信息
   *
   * @param request 租户信息实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Description("系统管理/租户信息管理/新增租户信息")
  @SaCheckPermission(
      value = {"sys:tenantInfo:add"},
      orRole = "admin")
  @PostMapping(value = "/sys/tenantInfo/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated SysTenantInfoAddDTO request)
      throws Exception {
    if (sysTenantInfoService.add(request)) {
      return CommonResult.success(null, "新增租户信息成功");
    } else {
      return CommonResult.failed("新增租户信息失败");
    }
  }
}
