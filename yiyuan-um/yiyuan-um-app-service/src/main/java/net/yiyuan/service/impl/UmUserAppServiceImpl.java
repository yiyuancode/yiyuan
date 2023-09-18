package net.yiyuan.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.common.utils.StringUtilsPlus;
import net.yiyuan.dto.UmUserTokenDTO;
import net.yiyuan.enums.UmUserSexEnum;
import net.yiyuan.enums.UmUserStatusEnum;
import net.yiyuan.mapper.UmUserMapper;
import net.yiyuan.model.UmUser;
import net.yiyuan.redis.SmsRedisService;
import net.yiyuan.service.UmUserAppService;
import net.yiyuan.vo.GetUmUserInfoVO;
import net.yiyuan.vo.UmUserQueryVO;
import net.yiyuan.vo.UmUserTokenVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 用户移动端Service层接口实现
 *
 * @author 小林同学
 * @date 2023-09-18
 */
@Slf4j
@Service
public class UmUserAppServiceImpl extends JoinServiceImpl<UmUserMapper, UmUser>
        implements UmUserAppService {
    @Resource
    private UmUserMapper umUserMapper;
    @Resource
    private SmsRedisService smsRedisService;

    /**
     * 用户登录
     *
     * @return
     */
    @Override
    public UmUserTokenVO getUmUserToken(UmUserTokenDTO umUserTokenDto) {
        //sa-token登录固定格式
        StpUtil.login(umUserTokenDto.getPhoneOrEmail());
        UmUserTokenVO umUserTokenVo = new UmUserTokenVO();
        UmUser umUser = new UmUser();
        umUser.setAccount(umUserTokenDto.getPhoneOrEmail());
        JoinLambdaWrapper<UmUser> wrapper = new JoinLambdaWrapper<>(umUser);
        if (StringUtilsPlus.isNotEmpty(umUser.getAccount())) {
            wrapper.eq(UmUser::getAccount, umUser.getAccount());
        }
        UmUserQueryVO umUserQueryVO = joinGetOne(wrapper, UmUserQueryVO.class);
        //验证类型
        if ("0".equals(umUserTokenDto.getType())) {
            if (StringUtilsPlus.isNull(umUserQueryVO)) {
                String phoneCode = smsRedisService.GET_SMS_PERMISSION(umUserTokenDto.getPhoneOrEmail());
                if (umUserTokenDto.getCode().equals(phoneCode)) {
                    //获取token
                    String tokenValue = insertUmUser(umUser, umUserTokenDto);
                    umUserTokenVo.setToken(tokenValue);
                    return umUserTokenVo;
                } else {
                    throw new BusinessException("验证码不正确");
                }
            } else {
                //如果用户已经完成注册。用户不为空
                String phoneCode = smsRedisService.GET_SMS_PERMISSION(umUserTokenDto.getPhoneOrEmail());
                if (umUserTokenDto.getCode().equals(phoneCode)) {
                    StpUtil.login(umUserQueryVO.getId());
                    String tokenValue = StpUtil.getTokenValue();
                    umUserTokenVo.setToken(tokenValue);
                    return umUserTokenVo;
                } else {
                    throw new BusinessException("验证码不正确");
                }
            }
        } else if ("1".equals(umUserTokenDto.getType())) {
            if (StringUtilsPlus.isNull(umUserQueryVO)) {
                String emailCode = smsRedisService.GET_EMAIL_PERMISSION(umUserTokenDto.getPhoneOrEmail());
                if (umUserTokenDto.getCode().equals(emailCode)) {
                    //获取token
                    String tokenValue = insertUmUser(umUser, umUserTokenDto);
                    umUserTokenVo.setToken(tokenValue);
                    return umUserTokenVo;
                } else {
                    throw new BusinessException("验证码不正确");
                }
            } else {
                //如果用户已经完成注册。用户不为空
                String emailCode = smsRedisService.GET_EMAIL_PERMISSION(umUserTokenDto.getPhoneOrEmail());
                if (umUserTokenDto.getCode().equals(emailCode)) {
                    StpUtil.login(umUserQueryVO.getId());
                    String tokenValue = StpUtil.getTokenValue();
                    umUserTokenVo.setToken(tokenValue);
                    return umUserTokenVo;
                } else {
                    throw new BusinessException("验证码不正确");
                }
            }
        } else {
            throw new BusinessException("请选择正确的登录类型");
        }
    }

    @Override
    public GetUmUserInfoVO getUmUserInfo() throws Exception {
        GetUmUserInfoVO getUmUserInfo = new GetUmUserInfoVO();
        String loginId = StpUtil.getLoginIdAsString();
        UmUser umUser = umUserMapper.selectById(loginId);
        umUser.setPwd("");
        BeanUtilsPlus.copy(umUser, getUmUserInfo);
        return getUmUserInfo;
    }


    public String insertUmUser(UmUser umUser, UmUserTokenDTO umUserTokenDto) {

        umUser.setAccount(umUserTokenDto.getPhoneOrEmail());
        umUser.setName(umUserTokenDto.getPhoneOrEmail());
        umUser.setSex(UmUserSexEnum.UNKNOWN);
//                    umUser.setIntegral(0);
//                    umUser.setExperience(0);
//                    umUser.setNowMoney(BigDecimal.valueOf(0));
//                    umUser.setBrokeragePrice(BigDecimal.valueOf(0));
//                    Byte b = 1;
//                    umUser.setLevel(b);
//                    umUser.setSignNum(0);
//                    umUser.setTransactionCount(0);
        umUser.setRegisterType(umUserTokenDto.getRegistryType());
        umUser.setLastLoginTime(new Date());
        umUser.setStatus(UmUserStatusEnum.NORMAL);
        umUser.setCreateTime(new Date());
        umUser.setUpdateTime(new Date());
        //插入用户
        umUserMapper.insert(umUser);
        String id = umUser.getId();
        StpUtil.login(id);
        String tokenValue = StpUtil.getTokenValue();
        return tokenValue;
    }

}



