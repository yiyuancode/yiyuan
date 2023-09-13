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
import java.util.Map;

/**
 * 区域管理
 *
 * @author 一源团队-花和尚
 * @date 2023-09-11
 * @folder 系统管理/区域管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class SysAreaController {
  @Autowired private SysAreaService sysAreaService;

  /**
   * 区域列表(全部)
   *
   * @param request 区域实体
   * @return {@link CommonResult<List<SysAreaQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @Description("系统管理/区域管理/查询区域")
  @SaCheckPermission(
      value = {"sys:area:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/area/list")
  @ResponseBody
  public CommonResult<List<SysAreaQueryVO>> list(SysAreaListDTO request) throws Exception {
    return CommonResult.success(sysAreaService.list(request), "查询区域列表成功");
  }

  /**
   * 区域列表(分页)
   *
   * @param request 区域实体
   * @return {@link CommonResult<Page<SysAreaQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @Description("系统管理/区域管理/查询区域")
  @SaCheckPermission(
      value = {"sys:area:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/area/page")
  @ResponseBody
  public CommonResult<Page<SysAreaQueryVO>> page(SysAreaPageDTO request) throws Exception {
    return CommonResult.success(sysAreaService.page(request), "分页查询区域成功");
  }

  /**
   * 区域详情
   *
   * @param id 区域id
   * @return {@link CommonResult<SysAreaQueryVO>}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @Description("系统管理/区域管理/查询区域")
  @SaCheckPermission(
      value = {"sys:area:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/area/details/{id}")
  @ResponseBody
  public CommonResult<SysAreaQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(sysAreaService.details(id), "查询区域详情成功");
  }

  /**
   * 删除区域(支持批量)
   *
   * @param ids 区域id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @Description("系统管理/区域管理/删除区域")
  @SaCheckPermission(
      value = {"sys:area:delete"},
      orRole = "admin")
  @PostMapping(value = "/sys/area/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (sysAreaService.delete(ids)) {
      return CommonResult.success(null, "删除区域成功");
    } else {
      return CommonResult.failed("删除区域失败");
    }
  }

  /**
   * 编辑区域
   *
   * @param request 区域实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @Description("系统管理/区域管理/编辑区域")
  @SaCheckPermission(
      value = {"sys:area:edit"},
      orRole = "admin")
  @PostMapping(value = "/sys/area/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated SysAreaEditDTO request)
      throws Exception {
    if (sysAreaService.edit(request)) {
      return CommonResult.success(null, "修改区域成功");
    } else {
      return CommonResult.failed("修改区域失败");
    }
  }

  /**
   * 新增区域
   *
   * @param request 区域实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @Description("系统管理/区域管理/新增区域")
  @SaCheckPermission(
      value = {"sys:area:add"},
      orRole = "admin")
  @PostMapping(value = "/sys/area/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated SysAreaAddDTO request) throws Exception {
    if (sysAreaService.add(request)) {
      return CommonResult.success(null, "新增区域成功");
    } else {
      return CommonResult.failed("新增区域失败");
    }
  }

  /**
   * 根据id查询区域树结构
   *
   * @param id 区域id
   * @return {@link CommonResult<List<Map<String, Object>>}
   * @author 一源团队-花和尚
   * @date 2023-09-09
   */
  @Description("系统管理/区域管理/查询区域")
  @SaCheckPermission(
      value = {"sys:area:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/area/getAreaTreeById")
  @ResponseBody
  public CommonResult getCityTreeById(String id) throws Exception {
    return CommonResult.success(sysAreaService.getAreaTreeById(id), "根据id查询城市区域树结构");
  }
  /**
   * 查询区域树结构
   *
   * @return {@link CommonResult<List<Map<String, Object>>}
   * @author 一源团队-花和尚
   * @date 2023-09-09
   */
  @Description("系统管理/区域管理/查询区域")
  @SaCheckPermission(
      value = {"sys:area:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/area/getAreaTree")
  @ResponseBody
  public CommonResult getCityTree(String pid) throws Exception {
    return CommonResult.success(sysAreaService.getAreaTree(pid), "查询城市区域树结构");
  }
}
