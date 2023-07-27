package net.yiyuan.admin.login.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.admin.login.dto.AccountLoginDTO;
import net.yiyuan.admin.login.service.AdminLoginService;
import net.yiyuan.admin.login.vo.AccountLoginVo;
import net.yiyuan.core.sys.mapper.SysTenantMapper;
import net.yiyuan.core.sys.model.SysTenant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 登录管理Service层接口实现
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Slf4j
@Service
public class AdminLoginServiceImpl extends JoinServiceImpl<SysTenantMapper, SysTenant> implements AdminLoginService {
    @Resource
    private SysTenantMapper sysTenantMapper;


    /**
     * 账号密码登录
     *
     * @param request
     * @return {@link AccountLoginVo }
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    @Override
    public AccountLoginVo accountLogin(AccountLoginDTO request) throws Exception {
        StpUtil.login(request.getUsername());
        AccountLoginVo voBean = new AccountLoginVo();
        voBean.setToken(StpUtil.getTokenValue());
        return voBean;
    }
}

