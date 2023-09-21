package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.PtmProductAddDTO;
import net.yiyuan.dto.PtmProductEditDTO;
import net.yiyuan.dto.PtmProductListDTO;
import net.yiyuan.dto.PtmProductPageDTO;
import net.yiyuan.service.PtmProductService;
import net.yiyuan.vo.PtmProductQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 商品管理
 *
 * @author 一源-花和尚
 * @date 2023-09-21
 * @folder 商品管理/商品管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class PtmProductController {
  @Autowired private PtmProductService ptmProductService;

  /**
   * 商品列表(全部)
   *
   * @param request 商品实体
   * @return {@link CommonResult<List<PtmProductQueryVO>>}
   * @author 一源-花和尚
   * @date 2023-09-21
   */
  @Description("商品管理/商品管理/查询商品")
  @SaCheckPermission(
      value = {"ptm:product:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/product/list")
  @ResponseBody
  public CommonResult<List<PtmProductQueryVO>> list(PtmProductListDTO request) throws Exception {
    return CommonResult.success(ptmProductService.list(request), "查询商品列表成功");
  }

  /**
   * 商品列表(分页)
   *
   * @param request 商品实体
   * @return {@link CommonResult<Page<PtmProductQueryVO>>}
   * @author 一源-花和尚
   * @date 2023-09-21
   */
  @Description("商品管理/商品管理/查询商品")
  @SaCheckPermission(
      value = {"ptm:product:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/product/page")
  @ResponseBody
  public CommonResult<Page<PtmProductQueryVO>> page(PtmProductPageDTO request) throws Exception {
    return CommonResult.success(ptmProductService.page(request), "分页查询商品成功");
  }

  /**
   * 商品详情
   *
   * @param id 商品id
   * @return {@link CommonResult<PtmProductQueryVO>}
   * @author 一源-花和尚
   * @date 2023-09-21
   */
  @Description("商品管理/商品管理/查询商品")
  @SaCheckPermission(
      value = {"ptm:product:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/product/details/{id}")
  @ResponseBody
  public CommonResult<PtmProductQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(ptmProductService.details(id), "查询商品详情成功");
  }

  /**
   * 删除商品(支持批量)
   *
   * @param ids 商品id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源-花和尚
   * @date 2023-09-21
   */
  @Description("商品管理/商品管理/删除商品")
  @SaCheckPermission(
      value = {"ptm:product:delete"},
      orRole = "admin")
  @PostMapping(value = "/ptm/product/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (ptmProductService.delete(ids)) {
      return CommonResult.success(null, "删除商品成功");
    } else {
      return CommonResult.failed("删除商品失败");
    }
  }

  /**
   * 编辑商品
   *
   * @param request 商品实体
   * @return {@link CommonResult<String>}
   * @author 一源-花和尚
   * @date 2023-09-21
   */
  @Description("商品管理/商品管理/编辑商品")
  @SaCheckPermission(
      value = {"ptm:product:edit"},
      orRole = "admin")
  @PostMapping(value = "/ptm/product/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated PtmProductEditDTO request)
      throws Exception {
    if (ptmProductService.edit(request)) {
      return CommonResult.success(null, "修改商品成功");
    } else {
      return CommonResult.failed("修改商品失败");
    }
  }

  /**
   * 新增商品
   *
   * @param request 商品实体
   * @return {@link CommonResult<String>}
   * @author 一源-花和尚
   * @date 2023-09-21
   */
  @Description("商品管理/商品管理/新增商品")
  @SaCheckPermission(
      value = {"ptm:product:add"},
      orRole = "admin")
  @PostMapping(value = "/ptm/product/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated PtmProductAddDTO request)
      throws Exception {
    if (ptmProductService.add(request)) {
      return CommonResult.success(null, "新增商品成功");
    } else {
      return CommonResult.failed("新增商品失败");
    }
  }
}
