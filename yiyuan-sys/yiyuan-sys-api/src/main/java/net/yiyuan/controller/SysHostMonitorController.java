package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.SysHostMonitorQueryCountDTO;
import net.yiyuan.service.SysHostMonitorService;
import net.yiyuan.vo.SysHostMonitorQueryCountVO;
import net.yiyuan.vo.SysHostMonitorQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 服务器监控采集管理
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 * @folder 系统管理/服务器监控采集管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class SysHostMonitorController {
  @Autowired private SysHostMonitorService sysHostMonitorService;

  /**
   * 服务器监控统计查询
   *
   * @param request 服务器监控采集实体
   * @return {@link CommonResult<List<SysHostMonitorQueryVO>>}
   * @author ${author}
   * @date 2023-07-30
   */
  @Description("系统管理/服务器监控采集管理/服务器监控统计查询")
  @SaCheckPermission(
      value = {"sys:hostMonitor:queryCount"},
      orRole = "admin")
  @GetMapping(value = "/sys/hostMonitor/queryCount")
  @ResponseBody
  public CommonResult<List<SysHostMonitorQueryCountVO>> queryCount(
      @Validated SysHostMonitorQueryCountDTO request) throws Exception {

    return CommonResult.success(sysHostMonitorService.queryCount(request), "查询服务器监控采集列表成功");
  }
}
