package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.*;
import net.yiyuan.service.PtmProductSkuService;
import net.yiyuan.vo.PtmProductSkuQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 商品sku管理
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 * @folder 商品管理/商品sku管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class PtmProductSkuController {
  @Autowired private PtmProductSkuService ptmProductSkuService;

  /**
   * 商品sku列表(全部)
   *
   * @param request 商品sku实体
   * @return {@link CommonResult<List<PtmProductSkuQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/商品sku管理/查询商品sku")
  @SaCheckPermission(
      value = {"ptm:productSku:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productSku/list")
  @ResponseBody
  public CommonResult<List<PtmProductSkuQueryVO>> list(PtmProductSkuListDTO request)
      throws Exception {
    return CommonResult.success(ptmProductSkuService.list(request), "查询商品sku列表成功");
  }

  /**
   * 商品sku列表(分页)
   *
   * @param request 商品sku实体
   * @return {@link CommonResult<Page<PtmProductSkuQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/商品sku管理/查询商品sku")
  @SaCheckPermission(
      value = {"ptm:productSku:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productSku/page")
  @ResponseBody
  public CommonResult<Page<PtmProductSkuQueryVO>> page(PtmProductSkuPageDTO request)
      throws Exception {
    return CommonResult.success(ptmProductSkuService.page(request), "分页查询商品sku成功");
  }

  /**
   * 商品sku详情
   *
   * @param id 商品skuid
   * @return {@link CommonResult<PtmProductSkuQueryVO>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/商品sku管理/查询商品sku")
  @SaCheckPermission(
      value = {"ptm:productSku:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productSku/details/{id}")
  @ResponseBody
  public CommonResult<PtmProductSkuQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(ptmProductSkuService.details(id), "查询商品sku详情成功");
  }

  /**
   * 删除商品sku(支持批量)
   *
   * @param ids 商品skuid(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/商品sku管理/删除商品sku")
  @SaCheckPermission(
      value = {"ptm:productSku:delete"},
      orRole = "admin")
  @PostMapping(value = "/ptm/productSku/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (ptmProductSkuService.delete(ids)) {
      return CommonResult.success(null, "删除商品sku成功");
    } else {
      return CommonResult.failed("删除商品sku失败");
    }
  }

  /**
   * 编辑商品sku
   *
   * @param request 商品sku实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/商品sku管理/编辑商品sku")
  @SaCheckPermission(
      value = {"ptm:productSku:edit"},
      orRole = "admin")
  @PostMapping(value = "/ptm/productSku/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated PtmProductSkuEditDTO request)
      throws Exception {
    if (ptmProductSkuService.edit(request)) {
      return CommonResult.success(null, "修改商品sku成功");
    } else {
      return CommonResult.failed("修改商品sku失败");
    }
  }

  /**
   * 新增商品sku
   *
   * @param request 商品sku实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/商品sku管理/新增商品sku")
  @SaCheckPermission(
      value = {"ptm:productSku:add"},
      orRole = "admin")
  @PostMapping(value = "/ptm/productSku/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated PtmProductSkuAddDTO request)
      throws Exception {
    if (ptmProductSkuService.add(request)) {
      return CommonResult.success(null, "新增商品sku成功");
    } else {
      return CommonResult.failed("新增商品sku失败");
    }
  }

  /**
   * 根据前端attr_key和attr_val生成临时sku集合
   *
   * @param request attr组合
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @PostMapping(value = "/ptm/productSku/makeSkuTempList")
  @ResponseBody
  public CommonResult<List<PtmProductSkuQueryVO>> makeSkuTempList(
      @RequestBody @Validated PtmProductSkuMakeSkuTempListDTO request) throws Exception {
    return CommonResult.success(ptmProductSkuService.makeSkuTempList(request), "");
  }
}
