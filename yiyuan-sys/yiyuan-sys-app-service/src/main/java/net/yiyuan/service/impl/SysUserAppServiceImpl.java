package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.SysUserMapper;
import net.yiyuan.model.SysUser;
import net.yiyuan.service.SysUserAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * 管理端用户移动端Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Slf4j
@Service
public class SysUserAppServiceImpl extends JoinServiceImpl<SysUserMapper, SysUser>
    implements SysUserAppService {
  @Resource private SysUserMapper sysUserMapper;
}
