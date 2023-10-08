package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.SpmShopAddDTO;
import net.yiyuan.dto.SpmShopEditDTO;
import net.yiyuan.dto.SpmShopListDTO;
import net.yiyuan.dto.SpmShopPageDTO;
import net.yiyuan.service.SpmShopService;
import net.yiyuan.vo.SpmShopQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 店铺管理
 *
 * @author 一源-花和尚
 * @date 2023-10-06
 * @folder 商户管理/店铺管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class SpmShopController {
  @Autowired private SpmShopService spmShopService;

  /**
   * 店铺列表(全部)
   *
   * @param request 店铺实体
   * @return {@link CommonResult<List<SpmShopQueryVO>>}
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @Description("商户管理/店铺管理/查询店铺")
  @SaCheckPermission(
      value = {"spm:shop:query"},
      orRole = "admin")
  @GetMapping(value = "/spm/shop/list")
  @ResponseBody
  public CommonResult<List<SpmShopQueryVO>> list(SpmShopListDTO request) throws Exception {
    return CommonResult.success(spmShopService.list(request), "查询店铺列表成功");
  }

  /**
   * 店铺列表(分页)
   *
   * @param request 店铺实体
   * @return {@link CommonResult<Page<SpmShopQueryVO>>}
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @Description("商户管理/店铺管理/查询店铺")
  @SaCheckPermission(
      value = {"spm:shop:query"},
      orRole = "admin")
  @GetMapping(value = "/spm/shop/page")
  @ResponseBody
  public CommonResult<Page<SpmShopQueryVO>> page(SpmShopPageDTO request) throws Exception {
    return CommonResult.success(spmShopService.page(request), "分页查询店铺成功");
  }

  /**
   * 店铺详情
   *
   * @param id 店铺id
   * @return {@link CommonResult<SpmShopQueryVO>}
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @Description("商户管理/店铺管理/查询店铺")
  @SaCheckPermission(
      value = {"spm:shop:query"},
      orRole = "admin")
  @GetMapping(value = "/spm/shop/details/{id}")
  @ResponseBody
  public CommonResult<SpmShopQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(spmShopService.details(id), "查询店铺详情成功");
  }

  /**
   * 删除店铺(支持批量)
   *
   * @param ids 店铺id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @Description("商户管理/店铺管理/删除店铺")
  @SaCheckPermission(
      value = {"spm:shop:delete"},
      orRole = "admin")
  @PostMapping(value = "/spm/shop/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (spmShopService.delete(ids)) {
      return CommonResult.success(null, "删除店铺成功");
    } else {
      return CommonResult.failed("删除店铺失败");
    }
  }

  /**
   * 编辑店铺
   *
   * @param request 店铺实体
   * @return {@link CommonResult<String>}
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @Description("商户管理/店铺管理/编辑店铺")
  @SaCheckPermission(
      value = {"spm:shop:edit"},
      orRole = "admin")
  @PostMapping(value = "/spm/shop/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated SpmShopEditDTO request)
      throws Exception {
    if (spmShopService.edit(request)) {
      return CommonResult.success(null, "修改店铺成功");
    } else {
      return CommonResult.failed("修改店铺失败");
    }
  }

  /**
   * 新增店铺
   *
   * @param request 店铺实体
   * @return {@link CommonResult<String>}
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @Description("商户管理/店铺管理/新增店铺")
  @SaCheckPermission(
      value = {"spm:shop:add"},
      orRole = "admin")
  @PostMapping(value = "/spm/shop/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated SpmShopAddDTO request) throws Exception {
    if (spmShopService.add(request)) {
      return CommonResult.success(null, "新增店铺成功");
    } else {
      return CommonResult.failed("新增店铺失败");
    }
  }
}
