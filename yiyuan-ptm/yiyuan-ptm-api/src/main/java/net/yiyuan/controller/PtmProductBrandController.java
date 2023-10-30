package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.PtmProductBrandAddDTO;
import net.yiyuan.dto.PtmProductBrandEditDTO;
import net.yiyuan.dto.PtmProductBrandListDTO;
import net.yiyuan.dto.PtmProductBrandPageDTO;
import net.yiyuan.service.PtmProductBrandService;
import net.yiyuan.vo.PtmProductBrandQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 品牌管理
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 * @folder 商品管理/品牌管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class PtmProductBrandController {
  @Autowired private PtmProductBrandService ptmProductBrandService;

  /**
   * 品牌列表(全部)
   *
   * @param request 品牌实体
   * @return {@link CommonResult<List<PtmProductBrandQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/品牌管理/查询品牌")
  @SaCheckPermission(
      value = {"ptm:productBrand:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productBrand/list")
  @ResponseBody
  public CommonResult<List<PtmProductBrandQueryVO>> list(PtmProductBrandListDTO request)
      throws Exception {
    return CommonResult.success(ptmProductBrandService.list(request), "查询品牌列表成功");
  }

  /**
   * 品牌列表(分页)
   *
   * @param request 品牌实体
   * @return {@link CommonResult<Page<PtmProductBrandQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/品牌管理/查询品牌")
  @SaCheckPermission(
      value = {"ptm:productBrand:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productBrand/page")
  @ResponseBody
  public CommonResult<Page<PtmProductBrandQueryVO>> page(PtmProductBrandPageDTO request)
      throws Exception {
    return CommonResult.success(ptmProductBrandService.page(request), "分页查询品牌成功");
  }

  /**
   * 品牌详情
   *
   * @param id 品牌id
   * @return {@link CommonResult<PtmProductBrandQueryVO>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/品牌管理/查询品牌")
  @SaCheckPermission(
      value = {"ptm:productBrand:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productBrand/details/{id}")
  @ResponseBody
  public CommonResult<PtmProductBrandQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(ptmProductBrandService.details(id), "查询品牌详情成功");
  }

  /**
   * 删除品牌(支持批量)
   *
   * @param ids 品牌id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/品牌管理/删除品牌")
  @SaCheckPermission(
      value = {"ptm:productBrand:delete"},
      orRole = "admin")
  @PostMapping(value = "/ptm/productBrand/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (ptmProductBrandService.delete(ids)) {
      return CommonResult.success(null, "删除品牌成功");
    } else {
      return CommonResult.failed("删除品牌失败");
    }
  }

  /**
   * 编辑品牌
   *
   * @param request 品牌实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/品牌管理/编辑品牌")
  @SaCheckPermission(
      value = {"ptm:productBrand:edit"},
      orRole = "admin")
  @PostMapping(value = "/ptm/productBrand/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated PtmProductBrandEditDTO request)
      throws Exception {
    if (ptmProductBrandService.edit(request)) {
      return CommonResult.success(null, "修改品牌成功");
    } else {
      return CommonResult.failed("修改品牌失败");
    }
  }

  /**
   * 新增品牌
   *
   * @param request 品牌实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/品牌管理/新增品牌")
  @SaCheckPermission(
      value = {"ptm:productBrand:add"},
      orRole = "admin")
  @PostMapping(value = "/ptm/productBrand/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated PtmProductBrandAddDTO request)
      throws Exception {
    if (ptmProductBrandService.add(request)) {
      return CommonResult.success(null, "新增品牌成功");
    } else {
      return CommonResult.failed("新增品牌失败");
    }
  }

  /**
   * 根据分类id查询全部品牌
   *
   * @param categoryId 分类id
   * @return {@link CommonResult<List<PtmProductBrandQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/品牌管理/根据分类id查询全部品牌")
  @SaCheckPermission(
      value = {"ptm:productBrand:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productBrand/listOfCategory/{categoryIds}")
  @ResponseBody
  public CommonResult<List<PtmProductBrandQueryVO>> listOfCategory(
      @PathVariable("categoryIds") @NotBlank String categoryIds) throws Exception {
    return CommonResult.success(ptmProductBrandService.listOfCategory(categoryIds), "查询品牌列表成功");
  }
}
