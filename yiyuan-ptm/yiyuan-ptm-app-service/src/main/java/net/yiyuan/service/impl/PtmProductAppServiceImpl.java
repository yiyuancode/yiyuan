package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.PtmProductMapper;
import net.yiyuan.model.PtmProduct;
import net.yiyuan.service.PtmProductAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 商品移动端Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-22
 */
@Slf4j
@Service
public class PtmProductAppServiceImpl extends JoinServiceImpl<PtmProductMapper, PtmProduct>
    implements PtmProductAppService {
  @Resource private PtmProductMapper ptmProductMapper;
}
