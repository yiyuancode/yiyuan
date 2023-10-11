package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.SpmShopTypeMapper;
import net.yiyuan.model.SpmShopType;
import net.yiyuan.service.SpmShopTypeAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * 店铺类型移动端Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-10-06
 */
@Slf4j
@Service
public class SpmShopTypeAppServiceImpl extends JoinServiceImpl<SpmShopTypeMapper, SpmShopType>
    implements SpmShopTypeAppService {
  @Resource private SpmShopTypeMapper spmShopTypeMapper;
}
