package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.PtmProductCategoryShopAddDTO;
import net.yiyuan.dto.PtmProductCategoryShopEditDTO;
import net.yiyuan.dto.PtmProductCategoryShopListDTO;
import net.yiyuan.dto.PtmProductCategoryShopPageDTO;
import net.yiyuan.service.PtmProductCategoryShopService;
import net.yiyuan.vo.PtmProductCategoryShopQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 店铺商品分类
 *
 * @author 一源团队-花和尚
 * @date 2023-11-19
 * @folder 商品管理/店铺商品分类
 */
@SaCheckLogin
@Slf4j
@RestController
public class PtmProductCategoryShopController {
  @Autowired private PtmProductCategoryShopService ptmProductCategoryShopService;

  /**
   * 店铺商品分类列表(全部)
   *
   * @param request 店铺商品分类实体
   * @return {@link CommonResult<List<PtmProductCategoryShopQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Description("商品管理/店铺商品分类/查询店铺商品分类")
  @SaCheckPermission(
      value = {"ptm:productCategoryShop:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productCategoryShop/list")
  @ResponseBody
  public CommonResult<List<PtmProductCategoryShopQueryVO>> list(
      PtmProductCategoryShopListDTO request) throws Exception {
    return CommonResult.success(ptmProductCategoryShopService.list(request), "查询店铺商品分类列表成功");
  }

  /**
   * 店铺商品分类列表(分页)
   *
   * @param request 店铺商品分类实体
   * @return {@link CommonResult<Page<PtmProductCategoryShopQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Description("商品管理/店铺商品分类/查询店铺商品分类")
  @SaCheckPermission(
      value = {"ptm:productCategoryShop:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productCategoryShop/page")
  @ResponseBody
  public CommonResult<Page<PtmProductCategoryShopQueryVO>> page(
      PtmProductCategoryShopPageDTO request) throws Exception {
    return CommonResult.success(ptmProductCategoryShopService.page(request), "分页查询店铺商品分类成功");
  }

  /**
   * 店铺商品分类详情
   *
   * @param id 店铺商品分类id
   * @return {@link CommonResult<PtmProductCategoryShopQueryVO>}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Description("商品管理/店铺商品分类/查询店铺商品分类")
  @SaCheckPermission(
      value = {"ptm:productCategoryShop:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productCategoryShop/details/{id}")
  @ResponseBody
  public CommonResult<PtmProductCategoryShopQueryVO> details(
      @PathVariable("id") @NotBlank String id) throws Exception {
    return CommonResult.success(ptmProductCategoryShopService.details(id), "查询店铺商品分类详情成功");
  }

  /**
   * 删除店铺商品分类(支持批量)
   *
   * @param ids 店铺商品分类id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Description("商品管理/店铺商品分类/删除店铺商品分类")
  @SaCheckPermission(
      value = {"ptm:productCategoryShop:delete"},
      orRole = "admin")
  @PostMapping(value = "/ptm/productCategoryShop/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (ptmProductCategoryShopService.delete(ids)) {
      return CommonResult.success(null, "删除店铺商品分类成功");
    } else {
      return CommonResult.failed("删除店铺商品分类失败");
    }
  }

  /**
   * 编辑店铺商品分类
   *
   * @param request 店铺商品分类实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Description("商品管理/店铺商品分类/编辑店铺商品分类")
  @SaCheckPermission(
      value = {"ptm:productCategoryShop:edit"},
      orRole = "admin")
  @PostMapping(value = "/ptm/productCategoryShop/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated PtmProductCategoryShopEditDTO request)
      throws Exception {
    if (ptmProductCategoryShopService.edit(request)) {
      return CommonResult.success(null, "修改店铺商品分类成功");
    } else {
      return CommonResult.failed("修改店铺商品分类失败");
    }
  }

  /**
   * 新增店铺商品分类
   *
   * @param request 店铺商品分类实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Description("商品管理/店铺商品分类/新增店铺商品分类")
  @SaCheckPermission(
      value = {"ptm:productCategoryShop:add"},
      orRole = "admin")
  @PostMapping(value = "/ptm/productCategoryShop/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated PtmProductCategoryShopAddDTO request)
      throws Exception {
    if (ptmProductCategoryShopService.add(request)) {
      return CommonResult.success(null, "新增店铺商品分类成功");
    } else {
      return CommonResult.failed("新增店铺商品分类失败");
    }
  }

  /**
   * 查询店铺商品分类树结构
   *
   * @param request 店铺商品分类实体
   * @return {@link CommonResult<List<PtmProductCategoryShopQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Description("商品管理/店铺商品分类/查询店铺商品分类")
  @SaCheckPermission(
      value = {"ptm:productCategoryShop:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productCategoryShop/tree")
  @ResponseBody
  public CommonResult<List<PtmProductCategoryShopQueryVO>> tree(
      PtmProductCategoryShopListDTO request) throws Exception {
    return CommonResult.success(ptmProductCategoryShopService.tree(request), "查询店铺商品分类树结构成功");
  }
}
