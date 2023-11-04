package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.FtmFreightTempPriceAddDTO;
import net.yiyuan.dto.FtmFreightTempPriceEditDTO;
import net.yiyuan.dto.FtmFreightTempPriceListDTO;
import net.yiyuan.dto.FtmFreightTempPricePageDTO;
import net.yiyuan.service.FtmFreightTempPriceService;
import net.yiyuan.vo.FtmFreightTempPriceQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 物流模板价格管理
 *
 * @author 一源团队-花和尚
 * @date 2023-11-04
 * @folder 物流模块/物流模板价格管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class FtmFreightTempPriceController {
  @Autowired private FtmFreightTempPriceService ftmFreightTempPriceService;

  /**
   * 物流模板价格列表(全部)
   *
   * @param request 物流模板价格实体
   * @return {@link CommonResult<List<FtmFreightTempPriceQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Description("物流模块/物流模板价格管理/查询物流模板价格")
  @SaCheckPermission(
      value = {"ftm:freightTempPrice:query"},
      orRole = "admin")
  @GetMapping(value = "/ftm/freightTempPrice/list")
  @ResponseBody
  public CommonResult<List<FtmFreightTempPriceQueryVO>> list(FtmFreightTempPriceListDTO request)
      throws Exception {
    return CommonResult.success(ftmFreightTempPriceService.list(request), "查询物流模板价格列表成功");
  }

  /**
   * 物流模板价格列表(分页)
   *
   * @param request 物流模板价格实体
   * @return {@link CommonResult<Page<FtmFreightTempPriceQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Description("物流模块/物流模板价格管理/查询物流模板价格")
  @SaCheckPermission(
      value = {"ftm:freightTempPrice:query"},
      orRole = "admin")
  @GetMapping(value = "/ftm/freightTempPrice/page")
  @ResponseBody
  public CommonResult<Page<FtmFreightTempPriceQueryVO>> page(FtmFreightTempPricePageDTO request)
      throws Exception {
    return CommonResult.success(ftmFreightTempPriceService.page(request), "分页查询物流模板价格成功");
  }

  /**
   * 物流模板价格详情
   *
   * @param id 物流模板价格id
   * @return {@link CommonResult<FtmFreightTempPriceQueryVO>}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Description("物流模块/物流模板价格管理/查询物流模板价格")
  @SaCheckPermission(
      value = {"ftm:freightTempPrice:query"},
      orRole = "admin")
  @GetMapping(value = "/ftm/freightTempPrice/details/{id}")
  @ResponseBody
  public CommonResult<FtmFreightTempPriceQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(ftmFreightTempPriceService.details(id), "查询物流模板价格详情成功");
  }

  /**
   * 删除物流模板价格(支持批量)
   *
   * @param ids 物流模板价格id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Description("物流模块/物流模板价格管理/删除物流模板价格")
  @SaCheckPermission(
      value = {"ftm:freightTempPrice:delete"},
      orRole = "admin")
  @PostMapping(value = "/ftm/freightTempPrice/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (ftmFreightTempPriceService.delete(ids)) {
      return CommonResult.success(null, "删除物流模板价格成功");
    } else {
      return CommonResult.failed("删除物流模板价格失败");
    }
  }

  /**
   * 编辑物流模板价格
   *
   * @param request 物流模板价格实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Description("物流模块/物流模板价格管理/编辑物流模板价格")
  @SaCheckPermission(
      value = {"ftm:freightTempPrice:edit"},
      orRole = "admin")
  @PostMapping(value = "/ftm/freightTempPrice/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated FtmFreightTempPriceEditDTO request)
      throws Exception {
    if (ftmFreightTempPriceService.edit(request)) {
      return CommonResult.success(null, "修改物流模板价格成功");
    } else {
      return CommonResult.failed("修改物流模板价格失败");
    }
  }

  /**
   * 新增物流模板价格
   *
   * @param request 物流模板价格实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Description("物流模块/物流模板价格管理/新增物流模板价格")
  @SaCheckPermission(
      value = {"ftm:freightTempPrice:add"},
      orRole = "admin")
  @PostMapping(value = "/ftm/freightTempPrice/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated FtmFreightTempPriceAddDTO request)
      throws Exception {
    if (ftmFreightTempPriceService.add(request)) {
      return CommonResult.success(null, "新增物流模板价格成功");
    } else {
      return CommonResult.failed("新增物流模板价格失败");
    }
  }
}
