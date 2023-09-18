package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.SysHostMonitorMapper;
import net.yiyuan.model.SysHostMonitor;
import net.yiyuan.service.SysHostMonitorAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * 服务器监控数据采集移动端Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Slf4j
@Service
public class SysHostMonitorAppServiceImpl
    extends JoinServiceImpl<SysHostMonitorMapper, SysHostMonitor>
    implements SysHostMonitorAppService {
  @Resource private SysHostMonitorMapper sysHostMonitorMapper;
}
