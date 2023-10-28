package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.SysAreaAddDTO;
import net.yiyuan.dto.SysAreaEditDTO;
import net.yiyuan.dto.SysAreaListDTO;
import net.yiyuan.dto.SysAreaPageDTO;
import net.yiyuan.service.SysAreaService;
import net.yiyuan.vo.SysAreaQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 行政区域管理
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 * @folder 系统管理/行政区域管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class SysAreaController {
  @Autowired private SysAreaService sysAreaService;

  /**
   * 行政区域列表(全部)
   *
   * @param request 行政区域实体
   * @return {@link CommonResult<List<SysAreaQueryVO>>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Description("系统管理/行政区域管理/查询行政区域")
  @SaCheckPermission(
      value = {"sys:area:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/area/list")
  @ResponseBody
  public CommonResult<List<SysAreaQueryVO>> list(SysAreaListDTO request) throws Exception {
    return CommonResult.success(sysAreaService.list(request), "查询行政区域列表成功");
  }

  /**
   * 行政区域列表(分页)
   *
   * @param request 行政区域实体
   * @return {@link CommonResult<Page<SysAreaQueryVO>>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Description("系统管理/行政区域管理/查询行政区域")
  @SaCheckPermission(
      value = {"sys:area:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/area/page")
  @ResponseBody
  public CommonResult<Page<SysAreaQueryVO>> page(SysAreaPageDTO request) throws Exception {
    return CommonResult.success(sysAreaService.page(request), "分页查询行政区域成功");
  }

  /**
   * 行政区域详情
   *
   * @param id 行政区域id
   * @return {@link CommonResult<SysAreaQueryVO>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Description("系统管理/行政区域管理/查询行政区域")
  @SaCheckPermission(
      value = {"sys:area:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/area/details/{id}")
  @ResponseBody
  public CommonResult<SysAreaQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(sysAreaService.details(id), "查询行政区域详情成功");
  }

  /**
   * 删除行政区域(支持批量)
   *
   * @param ids 行政区域id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Description("系统管理/行政区域管理/删除行政区域")
  @SaCheckPermission(
      value = {"sys:area:delete"},
      orRole = "admin")
  @PostMapping(value = "/sys/area/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (sysAreaService.delete(ids)) {
      return CommonResult.success(null, "删除行政区域成功");
    } else {
      return CommonResult.failed("删除行政区域失败");
    }
  }

  /**
   * 编辑行政区域
   *
   * @param request 行政区域实体
   * @return {@link CommonResult<String>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Description("系统管理/行政区域管理/编辑行政区域")
  @SaCheckPermission(
      value = {"sys:area:edit"},
      orRole = "admin")
  @PostMapping(value = "/sys/area/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated SysAreaEditDTO request)
      throws Exception {
    if (sysAreaService.edit(request)) {
      return CommonResult.success(null, "修改行政区域成功");
    } else {
      return CommonResult.failed("修改行政区域失败");
    }
  }

  /**
   * 新增行政区域
   *
   * @param request 行政区域实体
   * @return {@link CommonResult<String>}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Description("系统管理/行政区域管理/新增行政区域")
  @SaCheckPermission(
      value = {"sys:area:add"},
      orRole = "admin")
  @PostMapping(value = "/sys/area/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated SysAreaAddDTO request) throws Exception {
    if (sysAreaService.add(request)) {
      return CommonResult.success(null, "新增行政区域成功");
    } else {
      return CommonResult.failed("新增行政区域失败");
    }
  }

  /**
   * 根据子id反查上下级得树结构
   *
   * @param id 区域id
   * @author 一源团队-花和尚
   * @date 2023-09-09
   */
  @Description("系统管理/区域管理/查询区域")
  @SaCheckPermission(
      value = {"sys:area:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/area/getAreaTreeById/{id}")
  @ResponseBody
  public CommonResult<List<SysAreaQueryVO>> getCityTreeById(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(sysAreaService.getAreaTreeById(id), "根据id查询城市区域树结构");
  }
  /**
   * 根据父id查询下一级树结构
   *
   * @author 一源团队-花和尚
   * @date 2023-09-09
   */
  @Description("系统管理/区域管理/查询区域")
  @SaCheckPermission(
      value = {"sys:area:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/area/getAreaTree/{pid}")
  @ResponseBody
  public CommonResult<List<SysAreaQueryVO>> getCityTree(@PathVariable("pid") @NotBlank String pid)
      throws Exception {
    return CommonResult.success(sysAreaService.getAreaTree(pid), "查询城市区域树结构");
  }
}
