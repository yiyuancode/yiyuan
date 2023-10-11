package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.PtmProductSkuMapper;
import net.yiyuan.model.PtmProductSku;
import net.yiyuan.service.PtmProductSkuAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 商品sku移动端Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Slf4j
@Service
public class PtmProductSkuAppServiceImpl extends JoinServiceImpl<PtmProductSkuMapper, PtmProductSku>
    implements PtmProductSkuAppService {
  @Resource private PtmProductSkuMapper ptmProductSkuMapper;
}
