package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.SysAreaMapper;
import net.yiyuan.model.SysArea;
import net.yiyuan.service.SysAreaAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * 行政区域移动端Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Slf4j
@Service
public class SysAreaAppServiceImpl extends JoinServiceImpl<SysAreaMapper, SysArea>
    implements SysAreaAppService {
  @Resource private SysAreaMapper sysAreaMapper;
}
