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
import net.yiyuan.mapper.UmBrowseRecordMapper;
import net.yiyuan.mapper.UmUserMapper;
import net.yiyuan.mapper.UmUserMerchantCollectMapper;
import net.yiyuan.model.UmBrowseRecord;
import net.yiyuan.model.UmUser;
import net.yiyuan.model.UmUserAddress;
import net.yiyuan.model.UmUserMerchantCollect;
import net.yiyuan.redis.SmsRedisService;
import net.yiyuan.service.UmUserAppService;
import net.yiyuan.vo.*;
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
    @Resource
    private UmBrowseRecordMapper umBrowseRecordMapper;
    @Resource
    private UmUserMerchantCollectMapper umUserMerchantCollectMapper;

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
        UmUserQueryVO umUserQueryVO = umUserMapper.joinSelectOne(wrapper, UmUserQueryVO.class);
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

    @Override
    public MyselfIndexVO findMySelfIndexVO() throws Exception {
        //链表 test
        TestVO testVO = new TestVO();
        JoinLambdaWrapper<UmUser> umWrapper = new JoinLambdaWrapper<>(UmUser.class);
        umWrapper.eq(UmUser::getId, "767dd335d2aa16f3efafd1cc86a938c1");
        umWrapper.select(UmUser::getPhone);
        //第一个参数
        umWrapper.leftJoin(UmUserAddress.class, UmUserAddress::getUid, UmUser::getId).manyToManySelect(TestVO::getAddressList, UmUserAddress.class).end();
        umWrapper.leftJoin(UmBrowseRecord.class, UmBrowseRecord::getUid, UmUser::getId).manyToManySelect(TestVO::getBrowseRecordList, UmBrowseRecord.class).end();

        TestVO testVO1 = umUserMapper.joinSelectOne(umWrapper, TestVO.class);


        // 获取用户信息
        GetUmUserInfoVO umUserInfo = this.getUmUserInfo();
        // 获取我的足迹
        JoinLambdaWrapper<UmBrowseRecord> wrapper = new JoinLambdaWrapper<>(UmBrowseRecord.class);
        wrapper.eq(UmBrowseRecord::getUid, umUserInfo.getId());
        Long myTracks = umBrowseRecordMapper.selectCount(wrapper);
        //获取我的收藏数量
        JoinLambdaWrapper<UmUserMerchantCollect> umUserMerchantCollectJoinLambdaWrapper = new JoinLambdaWrapper<>(UmUserMerchantCollect.class);
        umUserMerchantCollectJoinLambdaWrapper.eq(UmUserMerchantCollect::getUid, umUserInfo.getId());
        Long myFavorite = umUserMerchantCollectMapper.selectCount(umUserMerchantCollectJoinLambdaWrapper);
        // 卡卷待定。默认为0 目前
        MyselfIndexVO myselfIndexVO = new MyselfIndexVO();
        myselfIndexVO.setName(umUserInfo.getName());
        myselfIndexVO.setHead(umUserInfo.getAvatar());
        myselfIndexVO.setMyFavorite(myFavorite.toString());
        myselfIndexVO.setIntegral(umUserInfo.getIntegral().toString());
        myselfIndexVO.setMyTracks(myTracks.toString());
        myselfIndexVO.setMyCars("0");

        return myselfIndexVO;
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



