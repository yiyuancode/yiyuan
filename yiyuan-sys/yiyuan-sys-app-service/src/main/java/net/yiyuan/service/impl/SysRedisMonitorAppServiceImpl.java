package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.SysRedisMonitorMapper;
import net.yiyuan.model.SysRedisMonitor;
import net.yiyuan.service.SysRedisMonitorAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * Redis监控采集移动端Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Slf4j
@Service
public class SysRedisMonitorAppServiceImpl
    extends JoinServiceImpl<SysRedisMonitorMapper, SysRedisMonitor>
    implements SysRedisMonitorAppService {
  @Resource private SysRedisMonitorMapper sysRedisMonitorMapper;
}
