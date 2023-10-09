package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.PtmProductAttrValueMapper;
import net.yiyuan.model.PtmProductAttrValue;
import net.yiyuan.service.PtmProductAttrValueAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 商品属性value移动端Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Slf4j
@Service
public class PtmProductAttrValueAppServiceImpl extends JoinServiceImpl
        <PtmProductAttrValueMapper, PtmProductAttrValue>
        implements PtmProductAttrValueAppService {
    @Resource
    private PtmProductAttrValueMapper ptmProductAttrValueMapper;

}
