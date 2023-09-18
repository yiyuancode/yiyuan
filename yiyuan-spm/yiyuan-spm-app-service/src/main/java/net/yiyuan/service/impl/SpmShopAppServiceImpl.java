package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.SpmShopMapper;
import net.yiyuan.model.SpmShop;
import net.yiyuan.service.SpmShopAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * 店铺移动端Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Slf4j
@Service
public class SpmShopAppServiceImpl extends JoinServiceImpl<SpmShopMapper, SpmShop>
    implements SpmShopAppService {
  @Resource private SpmShopMapper spmShopMapper;
}
