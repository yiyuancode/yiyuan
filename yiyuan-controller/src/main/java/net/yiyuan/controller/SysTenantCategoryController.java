package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.SysTenantCategoryAddDTO;
import net.yiyuan.dto.SysTenantCategoryEditDTO;
import net.yiyuan.dto.SysTenantCategoryListDTO;
import net.yiyuan.dto.SysTenantCategoryPageDTO;
import net.yiyuan.service.SysTenantCategoryService;
import net.yiyuan.vo.SysTenantCategoryQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 租户店铺分类
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 * @folder 系统管理/租户店铺分类
 */
@SaCheckLogin
@Slf4j
@RestController
public class SysTenantCategoryController {
  @Autowired private SysTenantCategoryService sysTenantCategoryService;

  /**
   * 租户店铺分类列表(全部)
   *
   * @param request 租户店铺分类实体
   * @return {@link CommonResult<List<SysTenantCategoryQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Description("系统管理/租户店铺分类/查询租户店铺分类")
  @SaCheckPermission(
      value = {"sys:tenantCategory:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/tenantCategory/list")
  @ResponseBody
  public CommonResult<List<SysTenantCategoryQueryVO>> list(SysTenantCategoryListDTO request)
      throws Exception {
    return CommonResult.success(sysTenantCategoryService.list(request), "查询租户店铺分类列表成功");
  }

  /**
   * 租户店铺分类列表(分页)
   *
   * @param request 租户店铺分类实体
   * @return {@link CommonResult<Page<SysTenantCategoryQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Description("系统管理/租户店铺分类/查询租户店铺分类")
  @SaCheckPermission(
      value = {"sys:tenantCategory:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/tenantCategory/page")
  @ResponseBody
  public CommonResult<Page<SysTenantCategoryQueryVO>> page(SysTenantCategoryPageDTO request)
      throws Exception {
    return CommonResult.success(sysTenantCategoryService.page(request), "分页查询租户店铺分类成功");
  }

  /**
   * 租户店铺分类详情
   *
   * @param id 租户店铺分类id
   * @return {@link CommonResult<SysTenantCategoryQueryVO>}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Description("系统管理/租户店铺分类/查询租户店铺分类")
  @SaCheckPermission(
      value = {"sys:tenantCategory:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/tenantCategory/details/{id}")
  @ResponseBody
  public CommonResult<SysTenantCategoryQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(sysTenantCategoryService.details(id), "查询租户店铺分类详情成功");
  }

  /**
   * 删除租户店铺分类(支持批量)
   *
   * @param ids 租户店铺分类id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Description("系统管理/租户店铺分类/删除租户店铺分类")
  @SaCheckPermission(
      value = {"sys:tenantCategory:delete"},
      orRole = "admin")
  @PostMapping(value = "/sys/tenantCategory/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (sysTenantCategoryService.delete(ids)) {
      return CommonResult.success(null, "删除租户店铺分类成功");
    } else {
      return CommonResult.failed("删除租户店铺分类失败");
    }
  }

  /**
   * 编辑租户店铺分类
   *
   * @param request 租户店铺分类实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Description("系统管理/租户店铺分类/编辑租户店铺分类")
  @SaCheckPermission(
      value = {"sys:tenantCategory:edit"},
      orRole = "admin")
  @PostMapping(value = "/sys/tenantCategory/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated SysTenantCategoryEditDTO request)
      throws Exception {
    if (sysTenantCategoryService.edit(request)) {
      return CommonResult.success(null, "修改租户店铺分类成功");
    } else {
      return CommonResult.failed("修改租户店铺分类失败");
    }
  }

  /**
   * 新增租户店铺分类
   *
   * @param request 租户店铺分类实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Description("系统管理/租户店铺分类/新增租户店铺分类")
  @SaCheckPermission(
      value = {"sys:tenantCategory:add"},
      orRole = "admin")
  @PostMapping(value = "/sys/tenantCategory/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated SysTenantCategoryAddDTO request)
      throws Exception {
    if (sysTenantCategoryService.add(request)) {
      return CommonResult.success(null, "新增租户店铺分类成功");
    } else {
      return CommonResult.failed("新增租户店铺分类失败");
    }
  }
}
