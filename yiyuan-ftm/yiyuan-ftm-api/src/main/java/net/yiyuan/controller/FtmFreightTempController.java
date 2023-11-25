package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.FtmFreightTempAddDTO;
import net.yiyuan.dto.FtmFreightTempEditDTO;
import net.yiyuan.dto.FtmFreightTempListDTO;
import net.yiyuan.dto.FtmFreightTempPageDTO;
import net.yiyuan.service.FtmFreightTempService;
import net.yiyuan.vo.FtmFreightTempQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 物流模板管理
 *
 * @author 一源团队-花和尚
 * @date 2023-11-04
 * @folder 物流模块/物流模板管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class FtmFreightTempController {
  @Autowired private FtmFreightTempService ftmFreightTempService;

  /**
   * 物流模板列表(全部)
   *
   * @param request 物流模板实体
   * @return {@link CommonResult<List<FtmFreightTempQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Description("物流模块/物流模板管理/查询物流模板")
  @SaCheckPermission(
      value = {"ftm:freightTemp:query"},
      orRole = "admin")
  @GetMapping(value = "/ftm/freightTemp/list")
  @ResponseBody
  public CommonResult<List<FtmFreightTempQueryVO>> list(FtmFreightTempListDTO request)
      throws Exception {
    return CommonResult.success(ftmFreightTempService.list(request), "查询物流模板列表成功");
  }

  /**
   * 物流模板列表(分页)
   *
   * @param request 物流模板实体
   * @return {@link CommonResult<Page<FtmFreightTempQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Description("物流模块/物流模板管理/查询物流模板")
  @SaCheckPermission(
      value = {"ftm:freightTemp:query"},
      orRole = "admin")
  @GetMapping(value = "/ftm/freightTemp/page")
  @ResponseBody
  public CommonResult<Page<FtmFreightTempQueryVO>> page(FtmFreightTempPageDTO request)
      throws Exception {
    return CommonResult.success(ftmFreightTempService.page(request), "分页查询物流模板成功");
  }

  /**
   * 物流模板详情
   *
   * @param id 物流模板id
   * @return {@link CommonResult<FtmFreightTempQueryVO>}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Description("物流模块/物流模板管理/查询物流模板")
  @SaCheckPermission(
      value = {"ftm:freightTemp:query"},
      orRole = "admin")
  @GetMapping(value = "/ftm/freightTemp/details/{id}")
  @ResponseBody
  public CommonResult<FtmFreightTempQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(ftmFreightTempService.details(id), "查询物流模板详情成功");
  }

  /**
   * 删除物流模板(支持批量)
   *
   * @param ids 物流模板id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Description("物流模块/物流模板管理/删除物流模板")
  @SaCheckPermission(
      value = {"ftm:freightTemp:delete"},
      orRole = "admin")
  @PostMapping(value = "/ftm/freightTemp/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (ftmFreightTempService.delete(ids)) {
      return CommonResult.success(null, "删除物流模板成功");
    } else {
      return CommonResult.failed("删除物流模板失败");
    }
  }

  /**
   * 编辑物流模板
   *
   * @param request 物流模板实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Description("物流模块/物流模板管理/编辑物流模板")
  @SaCheckPermission(
      value = {"ftm:freightTemp:edit"},
      orRole = "admin")
  @PostMapping(value = "/ftm/freightTemp/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated FtmFreightTempEditDTO request)
      throws Exception {
    if (ftmFreightTempService.edit(request)) {
      return CommonResult.success(null, "修改物流模板成功");
    } else {
      return CommonResult.failed("修改物流模板失败");
    }
  }

  /**
   * 新增物流模板
   *
   * @param request 物流模板实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Description("物流模块/物流模板管理/新增物流模板")
  @SaCheckPermission(
      value = {"ftm:freightTemp:add"},
      orRole = "admin")
  @PostMapping(value = "/ftm/freightTemp/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated FtmFreightTempAddDTO request)
      throws Exception {
    if (ftmFreightTempService.add(request)) {
      return CommonResult.success(null, "新增物流模板成功");
    } else {
      return CommonResult.failed("新增物流模板失败");
    }
  }
}
