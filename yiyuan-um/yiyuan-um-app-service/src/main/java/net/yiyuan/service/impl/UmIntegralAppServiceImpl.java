package net.yiyuan.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.UmIntegralPageDTO;
import net.yiyuan.dto.UmUserAddressPageDTO;
import net.yiyuan.mapper.UmIntegralMapper;
import net.yiyuan.mapper.UmUserMapper;
import net.yiyuan.model.UmIntegral;
import net.yiyuan.model.UmUser;
import net.yiyuan.service.UmIntegralAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Slf4j
@Service
public class UmIntegralAppServiceImpl extends JoinServiceImpl<UmIntegralMapper, UmIntegral> implements UmIntegralAppService {


    @Resource
    private UmIntegralMapper umIntegralMapper;

    @Resource
    private UmUserMapper umUserMapper;

    /**
     * 签到
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public boolean add(UmIntegral request) throws Exception {
        UmIntegral umIntegral = new UmIntegral();
        //当前登录用户ID
        String loginId = (String) StpUtil.getLoginId();
        request.setUid(loginId);
        // 当前用户最新一条 一天只能签到一次
        LocalDateTime todayStart = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime todayEnd = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        LambdaQueryWrapper<UmIntegral> lqw = Wrappers.lambdaQuery();
        lqw.eq(UmIntegral::getUid, loginId)
                .ge(UmIntegral::getCreateTime, todayStart)
                .lt(UmIntegral::getCreateTime, todayEnd);
        Long count = umIntegralMapper.selectCount(lqw);
        if (count > 0) {
            //已签到
            return false;
        } else {
            //未签到
            //1积分签到 2、活动积分 3、抽奖积分
            request.setType("1");
            request.setIntegral(1);
            //连续签到增加积分
            LocalDate currenDate = LocalDate.now();
//            //查询最当前用户最新一条记录
//            LambdaQueryWrapper<UmIntegral> queryWrapper = Wrappers.lambdaQuery();
//            queryWrapper.eq(UmIntegral::getUid, loginId)
//                    .orderByDesc(UmIntegral::getCreateTime)
//                    .last("limit 1");
//            UmIntegral selectOne = umIntegralMapper.selectOne(queryWrapper);

            //更新用户积分
            UmUser umUser = new UmUser();
            umUser.setIntegral(1);
            umUser.setId(loginId);
            //更新用户积分总数
            umUserMapper.updateById(umUser);
            BeanUtilsPlus.copy(request, umIntegral);
            int i = umIntegralMapper.insert(umIntegral);
            if (i != 0) {
                return true;
            } else {
                throw new BusinessException("签到失败");
            }

        }
    }


    @Override
    public Page<UmIntegral> page(UmIntegralPageDTO request) throws Exception {
        String loginId = (String) StpUtil.getLoginId();
        request.setUid(loginId);
        UmIntegral po = new UmIntegral();
        BeanUtilsPlus.copy(request, po);
        JoinLambdaWrapper<UmIntegral> wrapper = new JoinLambdaWrapper<>(po);
        Page<UmIntegral> voPage =
                umIntegralMapper.joinSelectPage(
                        new Page<>(request.getPageNum(), request.getPageSize()),
                        wrapper,
                        UmIntegral.class);
        return voPage;
    }

}
