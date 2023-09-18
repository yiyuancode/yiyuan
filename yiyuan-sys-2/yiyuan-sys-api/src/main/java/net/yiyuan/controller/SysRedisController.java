package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.SysRedisAddDTO;
import net.yiyuan.dto.SysRedisEditDTO;
import net.yiyuan.dto.SysRedisListDTO;
import net.yiyuan.dto.SysRedisPageDTO;
import net.yiyuan.service.SysRedisService;
import net.yiyuan.vo.SysRedisQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * Redis记录管理
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 * @folder 系统管理/Redis记录管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class SysRedisController {
  @Autowired private SysRedisService sysRedisService;

  /**
   * Redis记录列表(全部)
   *
   * @param request Redis记录实体
   * @return {@link CommonResult<List<SysRedisQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Description("系统管理/Redis记录管理/查询Redis记录")
  @SaCheckPermission(
      value = {"sys:redis:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/redis/list")
  @ResponseBody
  public CommonResult<List<SysRedisQueryVO>> list(SysRedisListDTO request) throws Exception {
    return CommonResult.success(sysRedisService.list(request), "查询Redis记录列表成功");
  }

  /**
   * Redis记录列表(分页)
   *
   * @param request Redis记录实体
   * @return {@link CommonResult<Page<SysRedisQueryVO>>}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Description("系统管理/Redis记录管理/查询Redis记录")
  @SaCheckPermission(
      value = {"sys:redis:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/redis/page")
  @ResponseBody
  public CommonResult<Page<SysRedisQueryVO>> page(SysRedisPageDTO request) throws Exception {
    return CommonResult.success(sysRedisService.page(request), "分页查询Redis记录成功");
  }

  /**
   * Redis记录详情
   *
   * @param id Redis记录id
   * @return {@link CommonResult<SysRedisQueryVO>}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Description("系统管理/Redis记录管理/查询Redis记录")
  @SaCheckPermission(
      value = {"sys:redis:query"},
      orRole = "admin")
  @GetMapping(value = "/sys/redis/details/{id}")
  @ResponseBody
  public CommonResult<SysRedisQueryVO> details(@PathVariable("id") @NotBlank String id)
      throws Exception {
    return CommonResult.success(sysRedisService.details(id), "查询Redis记录详情成功");
  }

  /**
   * 删除Redis记录(支持批量)
   *
   * @param ids Redis记录id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Description("系统管理/Redis记录管理/删除Redis记录")
  @SaCheckPermission(
      value = {"sys:redis:delete"},
      orRole = "admin")
  @PostMapping(value = "/sys/redis/delete")
  @ResponseBody
  public CommonResult<String> delete(
      @RequestParam(name = "ids") @Validated({NotBlank.class}) String ids) throws Exception {
    if (sysRedisService.delete(ids)) {
      return CommonResult.success(null, "删除Redis记录成功");
    } else {
      return CommonResult.failed("删除Redis记录失败");
    }
  }

  /**
   * 编辑Redis记录
   *
   * @param request Redis记录实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Description("系统管理/Redis记录管理/编辑Redis记录")
  @SaCheckPermission(
      value = {"sys:redis:edit"},
      orRole = "admin")
  @PostMapping(value = "/sys/redis/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated SysRedisEditDTO request)
      throws Exception {
    if (sysRedisService.edit(request)) {
      return CommonResult.success(null, "修改Redis记录成功");
    } else {
      return CommonResult.failed("修改Redis记录失败");
    }
  }

  /**
   * 新增Redis记录
   *
   * @param request Redis记录实体
   * @return {@link CommonResult<String>}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Description("系统管理/Redis记录管理/新增Redis记录")
  @SaCheckPermission(
      value = {"sys:redis:add"},
      orRole = "admin")
  @PostMapping(value = "/sys/redis/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated SysRedisAddDTO request) throws Exception {
    if (sysRedisService.add(request)) {
      return CommonResult.success(null, "新增Redis记录成功");
    } else {
      return CommonResult.failed("新增Redis记录失败");
    }
  }
}
