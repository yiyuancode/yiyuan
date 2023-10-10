package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.PtmProductDetailsAddDTO;
import net.yiyuan.dto.PtmProductDetailsEditDTO;
import net.yiyuan.dto.PtmProductDetailsListDTO;
import net.yiyuan.dto.PtmProductDetailsPageDTO;
import net.yiyuan.service.PtmProductDetailsService;
import net.yiyuan.vo.PtmProductDetailsQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 商品详情管理
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 * @folder 商品管理/商品详情管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class PtmProductDetailsController {
  @Autowired private PtmProductDetailsService ptmProductDetailsService;

  /**
   * 商品详情列表(全部)
   *
   * @param request 商品详情实体
   * @return {@link CommonResult<List<PtmProductDetailsQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/商品详情管理/查询商品详情")
  @SaCheckPermission(
      value = {"ptm:productDetails:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productDetails/list")
  @ResponseBody
  public CommonResult<List<PtmProductDetailsQueryVO>> list(PtmProductDetailsListDTO request)
      throws Exception {
    return CommonResult.success(ptmProductDetailsService.list(request), "查询商品详情列表成功");
  }

  /**
   * 商品详情列表(分页)
   *
   * @param request 商品详情实体
   * @return {@link CommonResult<Page<PtmProductDetailsQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/商品详情管理/查询商品详情")
  @SaCheckPermission(
      value = {"ptm:productDetails:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productDetails/page")
  @ResponseBody
  public CommonResult<Page<PtmProductDetailsQueryVO>> page(PtmProductDetailsPageDTO request)
      throws Exception {
    return CommonResult.success(ptmProductDetailsService.page(request), "分页查询商品详情成功");
  }

  /**
   * 商品详情详情
   *
   * @param id 商品详情id
   * @return {@link CommonResult<PtmProductDetailsQueryVO>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/商品详情管理/查询商品详情")
  @SaCheckPermission(
      value = {"ptm:productDetails:query"},
      orRole = "admin")
  @GetMapping(value = "/ptm/productDetails/details/{id}")
  @ResponseBody
  public CommonResult<PtmProductDetailsQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(ptmProductDetailsService.details(id), "查询商品详情详情成功");
  }

  /**
   * 删除商品详情(支持批量)
   *
   * @param ids 商品详情id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/商品详情管理/删除商品详情")
  @SaCheckPermission(
      value = {"ptm:productDetails:delete"},
      orRole = "admin")
  @PostMapping(value = "/ptm/productDetails/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (ptmProductDetailsService.delete(ids)) {
      return CommonResult.success(null, "删除商品详情成功");
    } else {
      return CommonResult.failed("删除商品详情失败");
    }
  }

  /**
   * 编辑商品详情
   *
   * @param request 商品详情实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/商品详情管理/编辑商品详情")
  @SaCheckPermission(
      value = {"ptm:productDetails:edit"},
      orRole = "admin")
  @PostMapping(value = "/ptm/productDetails/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated PtmProductDetailsEditDTO request)
      throws Exception {
    if (ptmProductDetailsService.edit(request)) {
      return CommonResult.success(null, "修改商品详情成功");
    } else {
      return CommonResult.failed("修改商品详情失败");
    }
  }

  /**
   * 新增商品详情
   *
   * @param request 商品详情实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Description("商品管理/商品详情管理/新增商品详情")
  @SaCheckPermission(
      value = {"ptm:productDetails:add"},
      orRole = "admin")
  @PostMapping(value = "/ptm/productDetails/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated PtmProductDetailsAddDTO request)
      throws Exception {
    if (ptmProductDetailsService.add(request)) {
      return CommonResult.success(null, "新增商品详情成功");
    } else {
      return CommonResult.failed("新增商品详情失败");
    }
  }
}
