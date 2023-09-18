package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.SysQrtzMapper;
import net.yiyuan.model.SysQrtz;
import net.yiyuan.service.SysQrtzAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * 定时任务移动端Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Slf4j
@Service
public class SysQrtzAppServiceImpl extends JoinServiceImpl<SysQrtzMapper, SysQrtz>
    implements SysQrtzAppService {
  @Resource private SysQrtzMapper sysQrtzMapper;
}
