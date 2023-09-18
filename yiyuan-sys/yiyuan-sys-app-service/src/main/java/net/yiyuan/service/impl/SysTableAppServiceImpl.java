package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.SysTableMapper;
import net.yiyuan.model.SysTable;
import net.yiyuan.service.SysTableAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * 数据库移动端Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Slf4j
@Service
public class SysTableAppServiceImpl extends JoinServiceImpl<SysTableMapper, SysTable>
    implements SysTableAppService {
  @Resource private SysTableMapper sysTableMapper;
}
