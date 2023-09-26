package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.SysMenuMapper;
import net.yiyuan.model.SysMenu;
import net.yiyuan.service.SysMenuAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * 菜单移动端Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-26
 */
@Slf4j
@Service
public class SysMenuAppServiceImpl extends JoinServiceImpl<SysMenuMapper, SysMenu>
    implements SysMenuAppService {
  @Resource private SysMenuMapper sysMenuMapper;
}
