package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.SysHostMapper;
import net.yiyuan.model.SysHost;
import net.yiyuan.service.SysHostAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * 服务器移动端Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Slf4j
@Service
public class SysHostAppServiceImpl extends JoinServiceImpl<SysHostMapper, SysHost>
    implements SysHostAppService {
  @Resource private SysHostMapper sysHostMapper;
}
