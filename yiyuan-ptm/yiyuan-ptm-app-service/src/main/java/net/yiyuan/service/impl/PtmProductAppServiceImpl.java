package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.PtmProductMapper;
import net.yiyuan.model.PtmProduct;
import net.yiyuan.service.PtmProductAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 商品信息移动端Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Slf4j
@Service
public class PtmProductAppServiceImpl extends JoinServiceImpl<PtmProductMapper, PtmProduct>
    implements PtmProductAppService {
  @Resource private PtmProductMapper ptmProductMapper;
}
