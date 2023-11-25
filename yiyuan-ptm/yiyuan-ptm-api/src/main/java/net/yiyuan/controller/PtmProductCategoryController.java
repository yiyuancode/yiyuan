package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.PtmProductCategoryAddDTO;
import net.yiyuan.dto.PtmProductCategoryEditDTO;
import net.yiyuan.dto.PtmProductCategoryListDTO;
import net.yiyuan.dto.PtmProductCategoryPageDTO;
import net.yiyuan.service.PtmProductCategoryService;
import net.yiyuan.vo.PtmProductCategoryQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 商品分类管理
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 * @folder 商品管理/商品分类管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class PtmProductCategoryController {
  @Autowired private PtmProductCategoryService ptmProductCategoryService;

  /**
   * 商品分类列表(全部)
   *
   * @param request 商品分类实体
   * @return {@link CommonResult<List<PtmProductCategoryQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/商品分类管理/查询商品分类")
  @SaCheckPermission(
      value = {"ptm:productCategory:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productCategory/list")
  @ResponseBody
  public CommonResult<List<PtmProductCategoryQueryVO>> list(PtmProductCategoryListDTO request)
      throws Exception {
    return CommonResult.success(ptmProductCategoryService.list(request), "查询商品分类列表成功");
  }

  /**
   * 商品分类列表(分页)
   *
   * @param request 商品分类实体
   * @return {@link CommonResult<Page<PtmProductCategoryQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/商品分类管理/查询商品分类")
  @SaCheckPermission(
      value = {"ptm:productCategory:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productCategory/page")
  @ResponseBody
  public CommonResult<Page<PtmProductCategoryQueryVO>> page(PtmProductCategoryPageDTO request)
      throws Exception {
    return CommonResult.success(ptmProductCategoryService.page(request), "分页查询商品分类成功");
  }

  /**
   * 商品分类详情
   *
   * @param id 商品分类id
   * @return {@link CommonResult<PtmProductCategoryQueryVO>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/商品分类管理/查询商品分类")
  @SaCheckPermission(
      value = {"ptm:productCategory:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productCategory/details/{id}")
  @ResponseBody
  public CommonResult<PtmProductCategoryQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(ptmProductCategoryService.details(id), "查询商品分类详情成功");
  }

  /**
   * 删除商品分类(支持批量)
   *
   * @param ids 商品分类id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/商品分类管理/删除商品分类")
  @SaCheckPermission(
      value = {"ptm:productCategory:delete"},
      orRole = "admin")
  @PostMapping(value = "/ptm/productCategory/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (ptmProductCategoryService.delete(ids)) {
      return CommonResult.success(null, "删除商品分类成功");
    } else {
      return CommonResult.failed("删除商品分类失败");
    }
  }

  /**
   * 编辑商品分类
   *
   * @param request 商品分类实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/商品分类管理/编辑商品分类")
  @SaCheckPermission(
      value = {"ptm:productCategory:edit"},
      orRole = "admin")
  @PostMapping(value = "/ptm/productCategory/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated PtmProductCategoryEditDTO request)
      throws Exception {
    if (ptmProductCategoryService.edit(request)) {
      return CommonResult.success(null, "修改商品分类成功");
    } else {
      return CommonResult.failed("修改商品分类失败");
    }
  }

  /**
   * 新增商品分类
   *
   * @param request 商品分类实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/商品分类管理/新增商品分类")
  @SaCheckPermission(
      value = {"ptm:productCategory:add"},
      orRole = "admin")
  @PostMapping(value = "/ptm/productCategory/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated PtmProductCategoryAddDTO request)
      throws Exception {
    if (ptmProductCategoryService.add(request)) {
      return CommonResult.success(null, "新增商品分类成功");
    } else {
      return CommonResult.failed("新增商品分类失败");
    }
  }

  /**
   * 商品分类树结构查询
   *
   * @param request 商品分类实体
   * @return {@link CommonResult<List<PtmProductCategoryQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/商品分类管理/查询商品分类")
  @SaCheckPermission(
      value = {"ptm:productCategory:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productCategory/treeList")
  @ResponseBody
  public CommonResult<List<PtmProductCategoryQueryVO>> treeList(PtmProductCategoryListDTO request)
      throws Exception {
    return CommonResult.success(ptmProductCategoryService.treeList(request), "查询商品分类列表成功");
  }

  /**
   * 商品分类树结构查询(只查询店铺分类)
   *
   * @param request 商品分类实体
   * @return {@link CommonResult<List<PtmProductCategoryQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/商品分类管理/查询商品分类")
  @SaCheckPermission(
      value = {"ptm:productCategory:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productCategory/treeListForShop")
  @ResponseBody
  public CommonResult<List<PtmProductCategoryQueryVO>> treeListForShop(
      PtmProductCategoryListDTO request) throws Exception {
    return CommonResult.success(ptmProductCategoryService.treeListForShop(request), "查询商品分类列表成功");
  }
  /**
   * 商品分类树结构查询(只查询平台分类)
   *
   * @param request 商品分类实体
   * @return {@link CommonResult<List<PtmProductCategoryQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/商品分类管理/查询商品分类")
  @SaCheckPermission(
      value = {"ptm:productCategory:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productCategory/treeListForPlat")
  @ResponseBody
  public CommonResult<List<PtmProductCategoryQueryVO>> treeListForPlat(
      PtmProductCategoryListDTO request) throws Exception {
    return CommonResult.success(ptmProductCategoryService.treeListForPlat(request), "查询商品分类列表成功");
  }
}
