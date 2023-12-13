package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.UmIntegralPageDTO;
import net.yiyuan.mapper.UmIntegralMapper;
import net.yiyuan.model.UmIntegral;
import net.yiyuan.service.UmIntegralService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Slf4j
@Service
public class UmIntegralServiceImpl extends JoinServiceImpl<UmIntegralMapper, UmIntegral> implements UmIntegralService {

    @Resource
    private UmIntegralMapper umIntegralMapper;

    @Override
    public Page<UmIntegral> list(UmIntegralPageDTO request) throws Exception {
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
