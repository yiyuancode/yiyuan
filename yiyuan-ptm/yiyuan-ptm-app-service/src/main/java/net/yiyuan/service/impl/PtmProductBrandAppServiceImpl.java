package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.PtmProductBrandMapper;
import net.yiyuan.model.PtmProductBrand;
import net.yiyuan.service.PtmProductBrandAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 品牌移动端Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Slf4j
@Service
public class PtmProductBrandAppServiceImpl extends JoinServiceImpl
        <PtmProductBrandMapper, PtmProductBrand>
        implements PtmProductBrandAppService {
    @Resource
    private PtmProductBrandMapper ptmProductBrandMapper;

}
