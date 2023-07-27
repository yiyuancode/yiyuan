package net.yiyuan.admin.login.service.impl;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.context.model.SaRequest;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.admin.login.dto.AccountLoginDTO;
import net.yiyuan.admin.login.service.AdminLoginService;
import net.yiyuan.admin.login.vo.AccountLoginVo;
import net.yiyuan.admin.login.vo.LoginGetUserInfoVo;
import net.yiyuan.common.constatnt.ResultCode;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.core.auth.enums.AuthAdminPlatformEnum;
import net.yiyuan.core.auth.model.AuthAdmin;
import net.yiyuan.core.auth.service.AuthAdminService;
import net.yiyuan.core.auth.vo.AuthAdminQueryVO;
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
    private AuthAdminService authAdminService;


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


        SaRequest httpRequest = SaHolder.getRequest();
        // platform 平台区分 0 平台  1 租户 2 c端
        String platform = httpRequest.getHeader("platform");
        //    String tenantId = httpRequest.getHeader("tenantId");
        // 查询用户信息
        AuthAdmin query = new AuthAdmin();
        query.setUsername(request.getUsername());
        query.setPlatform(AuthAdminPlatformEnum.PLATFORM_SIDE);
        AuthAdminQueryVO adminQueryVO = authAdminService.detailsEqual(query);
        // 用户不存在
        if (ObjectUtil.isNull(adminQueryVO)) {
            throw new BusinessException(ResultCode.USER_NOT_FIND);
        }
        // 密码错误
        if (!adminQueryVO.getPassword().equals(request.getPassword())) {
            throw new BusinessException(ResultCode.USER_ERROR);
        }
        // satoken登录
        StpUtil.login(adminQueryVO.getId());
        String tokenValue = StpUtil.getTokenValue();
        AccountLoginVo voResult = new AccountLoginVo();
        voResult.setToken(tokenValue);

        return voResult;
    }

    @Override
    public LoginGetUserInfoVo getUserInfo() throws Exception {
        LoginGetUserInfoVo voResult = new LoginGetUserInfoVo();
        String loginId = StpUtil.getLoginIdAsString();
        //获取用户信息的菜单树结构
        AuthAdminQueryVO authAdminQueryVO = authAdminService.detailsJoinRoleAndPermission(loginId);
        BeanUtilsPlus.copy(authAdminQueryVO, voResult);
        return voResult;
    }
}

