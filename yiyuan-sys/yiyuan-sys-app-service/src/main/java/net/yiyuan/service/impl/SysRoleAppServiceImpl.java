package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.SysRoleMapper;
import net.yiyuan.model.SysRole;
import net.yiyuan.service.SysRoleAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * 管理端角色移动端Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Slf4j
@Service
public class SysRoleAppServiceImpl extends JoinServiceImpl<SysRoleMapper, SysRole>
    implements SysRoleAppService {
  @Resource private SysRoleMapper sysRoleMapper;
}
