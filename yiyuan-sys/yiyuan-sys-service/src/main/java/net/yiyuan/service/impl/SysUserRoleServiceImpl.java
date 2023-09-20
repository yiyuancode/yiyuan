package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.SysUserRoleMapper;
import net.yiyuan.model.SysUserRole;
import net.yiyuan.service.SysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * 行政区域Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Slf4j
@Service
public class SysUserRoleServiceImpl extends JoinServiceImpl<SysUserRoleMapper, SysUserRole>
    implements SysUserRoleService {}
