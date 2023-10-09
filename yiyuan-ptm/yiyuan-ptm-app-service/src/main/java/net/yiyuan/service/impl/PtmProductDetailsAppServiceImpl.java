package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.PtmProductDetailsMapper;
import net.yiyuan.model.PtmProductDetails;
import net.yiyuan.service.PtmProductDetailsAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 商品详情移动端Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Slf4j
@Service
public class PtmProductDetailsAppServiceImpl extends JoinServiceImpl
        <PtmProductDetailsMapper, PtmProductDetails>
        implements PtmProductDetailsAppService {
    @Resource
    private PtmProductDetailsMapper ptmProductDetailsMapper;

}
