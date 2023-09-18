package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.SysRedisMapper;
import net.yiyuan.model.SysRedis;
import net.yiyuan.service.SysRedisAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * Redis记录移动端Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Slf4j
@Service
public class SysRedisAppServiceImpl extends JoinServiceImpl<SysRedisMapper, SysRedis>
    implements SysRedisAppService {
  @Resource private SysRedisMapper sysRedisMapper;
}
