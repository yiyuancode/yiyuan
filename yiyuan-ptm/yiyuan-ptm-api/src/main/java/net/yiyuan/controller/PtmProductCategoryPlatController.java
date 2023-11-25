package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.PtmProductCategoryPlatAddDTO;
import net.yiyuan.dto.PtmProductCategoryPlatEditDTO;
import net.yiyuan.dto.PtmProductCategoryPlatListDTO;
import net.yiyuan.dto.PtmProductCategoryPlatPageDTO;
import net.yiyuan.service.PtmProductCategoryPlatService;
import net.yiyuan.vo.PtmProductCategoryPlatQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 平台商品分类
 *
 * @author 一源团队-花和尚
 * @date 2023-11-19
 * @folder 商品管理/平台商品分类
 */
@SaCheckLogin
@Slf4j
@RestController
public class PtmProductCategoryPlatController {
  @Autowired private PtmProductCategoryPlatService ptmProductCategoryPlatService;

  /**
   * 平台商品分类列表(全部)
   *
   * @param request 平台商品分类实体
   * @return {@link CommonResult<List<PtmProductCategoryPlatQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Description("商品管理/平台商品分类/查询平台商品分类")
  @SaCheckPermission(
      value = {"ptm:productCategoryPlat:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productCategoryPlat/list")
  @ResponseBody
  public CommonResult<List<PtmProductCategoryPlatQueryVO>> list(
      PtmProductCategoryPlatListDTO request) throws Exception {
    return CommonResult.success(ptmProductCategoryPlatService.list(request), "查询平台商品分类列表成功");
  }

  /**
   * 平台商品分类列表(分页)
   *
   * @param request 平台商品分类实体
   * @return {@link CommonResult<Page<PtmProductCategoryPlatQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Description("商品管理/平台商品分类/查询平台商品分类")
  @SaCheckPermission(
      value = {"ptm:productCategoryPlat:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productCategoryPlat/page")
  @ResponseBody
  public CommonResult<Page<PtmProductCategoryPlatQueryVO>> page(
      PtmProductCategoryPlatPageDTO request) throws Exception {
    return CommonResult.success(ptmProductCategoryPlatService.page(request), "分页查询平台商品分类成功");
  }

  /**
   * 平台商品分类详情
   *
   * @param id 平台商品分类id
   * @return {@link CommonResult<PtmProductCategoryPlatQueryVO>}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Description("商品管理/平台商品分类/查询平台商品分类")
  @SaCheckPermission(
      value = {"ptm:productCategoryPlat:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productCategoryPlat/details/{id}")
  @ResponseBody
  public CommonResult<PtmProductCategoryPlatQueryVO> details(
      @PathVariable("id") @NotBlank String id) throws Exception {
    return CommonResult.success(ptmProductCategoryPlatService.details(id), "查询平台商品分类详情成功");
  }

  /**
   * 删除平台商品分类(支持批量)
   *
   * @param ids 平台商品分类id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Description("商品管理/平台商品分类/删除平台商品分类")
  @SaCheckPermission(
      value = {"ptm:productCategoryPlat:delete"},
      orRole = "admin")
  @PostMapping(value = "/ptm/productCategoryPlat/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (ptmProductCategoryPlatService.delete(ids)) {
      return CommonResult.success(null, "删除平台商品分类成功");
    } else {
      return CommonResult.failed("删除平台商品分类失败");
    }
  }

  /**
   * 编辑平台商品分类
   *
   * @param request 平台商品分类实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Description("商品管理/平台商品分类/编辑平台商品分类")
  @SaCheckPermission(
      value = {"ptm:productCategoryPlat:edit"},
      orRole = "admin")
  @PostMapping(value = "/ptm/productCategoryPlat/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated PtmProductCategoryPlatEditDTO request)
      throws Exception {
    if (ptmProductCategoryPlatService.edit(request)) {
      return CommonResult.success(null, "修改平台商品分类成功");
    } else {
      return CommonResult.failed("修改平台商品分类失败");
    }
  }

  /**
   * 新增平台商品分类
   *
   * @param request 平台商品分类实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Description("商品管理/平台商品分类/新增平台商品分类")
  @SaCheckPermission(
      value = {"ptm:productCategoryPlat:add"},
      orRole = "admin")
  @PostMapping(value = "/ptm/productCategoryPlat/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated PtmProductCategoryPlatAddDTO request)
      throws Exception {
    if (ptmProductCategoryPlatService.add(request)) {
      return CommonResult.success(null, "新增平台商品分类成功");
    } else {
      return CommonResult.failed("新增平台商品分类失败");
    }
  }

  /**
   * 查查询平台商品分类树结构
   *
   * @param request 平台商品分类实体
   * @return {@link CommonResult<List<PtmProductCategoryPlatQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Description("商品管理/平台商品分类/查询平台商品分类树结构")
  @SaCheckPermission(
      value = {"ptm:productCategoryPlat:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productCategoryPlat/tree")
  @ResponseBody
  public CommonResult<List<PtmProductCategoryPlatQueryVO>> tree(
      PtmProductCategoryPlatListDTO request) throws Exception {
    return CommonResult.success(ptmProductCategoryPlatService.tree(request), "查询平台商品分类树结构成功");
  }
}
