package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.*;
import net.yiyuan.service.SysTenantService;
import net.yiyuan.vo.SysTenantQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 商户管理
 *
 * @author 一源团队-花和尚
 * @date 2023-09-08
 * @folder 系统管理/商户管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class SysTenantController {
  @Autowired private SysTenantService sysTenantService;

  /**
   * 商户列表(全部)
   *
   * @param request 商户实体
   * @return {@link CommonResult<List<SysTenantQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @Description("系统管理/商户管理/查询商户")
  @SaCheckPermission(
      value = {"sys:tenant:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/tenant/list")
  @ResponseBody
  public CommonResult<List<SysTenantQueryVO>> list(SysTenantListDTO request) throws Exception {
    return CommonResult.success(sysTenantService.list(request), "查询商户列表成功");
  }

  /**
   * 商户列表(分页)
   *
   * @param request 商户实体
   * @return {@link CommonResult<Page<SysTenantQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @Description("系统管理/商户管理/查询商户")
  @SaCheckPermission(
      value = {"sys:tenant:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/tenant/page")
  @ResponseBody
  public CommonResult<Page<SysTenantQueryVO>> page(SysTenantPageDTO request) throws Exception {
    return CommonResult.success(sysTenantService.page(request), "分页查询商户成功");
  }

  /**
   * 商户详情
   *
   * @param id 商户id
   * @return {@link CommonResult<SysTenantQueryVO>}
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @Description("系统管理/商户管理/查询商户")
  @SaCheckPermission(
      value = {"sys:tenant:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/tenant/details/{id}")
  @ResponseBody
  public CommonResult<SysTenantQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(sysTenantService.details(id), "查询商户详情成功");
  }

  /**
   * 删除商户(支持批量)
   *
   * @param ids 商户id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @Description("系统管理/商户管理/删除商户")
  @SaCheckPermission(
      value = {"sys:tenant:delete"},
      orRole = "admin")
  @PostMapping(value = "/sys/tenant/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (sysTenantService.delete(ids)) {
      return CommonResult.success(null, "删除商户成功");
    } else {
      return CommonResult.failed("删除商户失败");
    }
  }

  /**
   * 编辑商户
   *
   * @param request 商户实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @Description("系统管理/商户管理/编辑商户")
  @SaCheckPermission(
      value = {"sys:tenant:edit"},
      orRole = "admin")
  @PostMapping(value = "/sys/tenant/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated SysTenantEditDTO request)
      throws Exception {
    if (sysTenantService.edit(request)) {
      return CommonResult.success(null, "修改商户成功");
    } else {
      return CommonResult.failed("修改商户失败");
    }
  }

  /**
   * 商户入驻审核
   *
   * @param request 商户入驻审核请求实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @Description("系统管理/商户管理/商户入驻审核")
  @SaCheckPermission(
      value = {"sys:tenant:process"},
      orRole = "admin")
  @PostMapping(value = "/sys/tenant/process")
  @ResponseBody
  public CommonResult<String> process(@RequestBody @Validated SysTenantProcessDTO request)
      throws Exception {
    if (sysTenantService.process(request)) {
      return CommonResult.success(null, "商户入驻审核成功");
    } else {
      return CommonResult.failed("商户入驻审核失败");
    }
  }

  /**
   * 商户入驻申请
   *
   * @param request 商户入驻申请请求实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @PostMapping(value = "/sys/tenant/apply")
  @ResponseBody
  public CommonResult<String> apply(@RequestBody @Validated SysTenantApplyDTO request)
      throws Exception {
    if (sysTenantService.apply(request)) {
      return CommonResult.success(null, "商户入驻申请成功");
    } else {
      return CommonResult.failed("商户入驻申请失败");
    }
  }
}
