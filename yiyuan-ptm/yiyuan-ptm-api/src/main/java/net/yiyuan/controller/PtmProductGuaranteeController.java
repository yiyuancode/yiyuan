package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.PtmProductGuaranteeAddDTO;
import net.yiyuan.dto.PtmProductGuaranteeEditDTO;
import net.yiyuan.dto.PtmProductGuaranteeListDTO;
import net.yiyuan.dto.PtmProductGuaranteePageDTO;
import net.yiyuan.service.PtmProductGuaranteeService;
import net.yiyuan.vo.PtmProductGuaranteeQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 保障服务管理
 *
 * @author 一源团队-花和尚
 * @date 2023-11-09
 * @folder 商品管理/保障服务管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class PtmProductGuaranteeController {
  @Autowired private PtmProductGuaranteeService ptmProductGuaranteeService;

  /**
   * 保障服务列表(全部)
   *
   * @param request 保障服务实体
   * @return {@link CommonResult<List<PtmProductGuaranteeQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  @Description("商品管理/保障服务管理/查询保障服务")
  @SaCheckPermission(
      value = {"ptm:productGuarantee:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productGuarantee/list")
  @ResponseBody
  public CommonResult<List<PtmProductGuaranteeQueryVO>> list(PtmProductGuaranteeListDTO request)
      throws Exception {
    return CommonResult.success(ptmProductGuaranteeService.list(request), "查询保障服务列表成功");
  }

  /**
   * 保障服务列表(分页)
   *
   * @param request 保障服务实体
   * @return {@link CommonResult<Page<PtmProductGuaranteeQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  @Description("商品管理/保障服务管理/查询保障服务")
  @SaCheckPermission(
      value = {"ptm:productGuarantee:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productGuarantee/page")
  @ResponseBody
  public CommonResult<Page<PtmProductGuaranteeQueryVO>> page(PtmProductGuaranteePageDTO request)
      throws Exception {
    return CommonResult.success(ptmProductGuaranteeService.page(request), "分页查询保障服务成功");
  }

  /**
   * 保障服务详情
   *
   * @param id 保障服务id
   * @return {@link CommonResult<PtmProductGuaranteeQueryVO>}
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  @Description("商品管理/保障服务管理/查询保障服务")
  @SaCheckPermission(
      value = {"ptm:productGuarantee:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productGuarantee/details/{id}")
  @ResponseBody
  public CommonResult<PtmProductGuaranteeQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(ptmProductGuaranteeService.details(id), "查询保障服务详情成功");
  }

  /**
   * 删除保障服务(支持批量)
   *
   * @param ids 保障服务id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  @Description("商品管理/保障服务管理/删除保障服务")
  @SaCheckPermission(
      value = {"ptm:productGuarantee:delete"},
      orRole = "admin")
  @PostMapping(value = "/ptm/productGuarantee/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (ptmProductGuaranteeService.delete(ids)) {
      return CommonResult.success(null, "删除保障服务成功");
    } else {
      return CommonResult.failed("删除保障服务失败");
    }
  }

  /**
   * 编辑保障服务
   *
   * @param request 保障服务实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  @Description("商品管理/保障服务管理/编辑保障服务")
  @SaCheckPermission(
      value = {"ptm:productGuarantee:edit"},
      orRole = "admin")
  @PostMapping(value = "/ptm/productGuarantee/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated PtmProductGuaranteeEditDTO request)
      throws Exception {
    if (ptmProductGuaranteeService.edit(request)) {
      return CommonResult.success(null, "修改保障服务成功");
    } else {
      return CommonResult.failed("修改保障服务失败");
    }
  }

  /**
   * 新增保障服务
   *
   * @param request 保障服务实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  @Description("商品管理/保障服务管理/新增保障服务")
  @SaCheckPermission(
      value = {"ptm:productGuarantee:add"},
      orRole = "admin")
  @PostMapping(value = "/ptm/productGuarantee/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated PtmProductGuaranteeAddDTO request)
      throws Exception {
    if (ptmProductGuaranteeService.add(request)) {
      return CommonResult.success(null, "新增保障服务成功");
    } else {
      return CommonResult.failed("新增保障服务失败");
    }
  }
}
