package net.yiyuan.core.sys.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.core.sys.dto.SysrRedisMonitorQueryCountDTO;
import net.yiyuan.core.sys.service.SysRedisMonitorService;
import net.yiyuan.core.sys.vo.SysRedisMonitorQueryCountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Redis监控采集管理
 *
 * @author 一源团队--花和尚
 * @date 2023-08-02
 * @module 系统管理
 * @folder 系统管理/Redis监控采集管理
 */
@SaCheckLogin
@Slf4j
@RestController
public class SysRedisMonitorController {
  @Autowired private SysRedisMonitorService sysRedisMonitorService;

  /**
   * redis监控统计查询
   *
   * @param request redis监控采集实体
   * @return {@link CommonResult<List< SysRedisMonitorQueryCountVO >>}
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @Description("系统管理/Redis监控采集管理/redis监控统计查询")
  @SaCheckPermission(
      value = {"sys:hostMonitor:queryCount"},
      orRole = "admin")
  @GetMapping(value = "/sys/reidsMonitor/queryCount")
  @ResponseBody
  public CommonResult<List<SysRedisMonitorQueryCountVO>> queryCount(
      @Validated SysrRedisMonitorQueryCountDTO request) throws Exception {

    return CommonResult.success(sysRedisMonitorService.queryCount(request), "查询服务器监控采集列表成功");
  }
}
