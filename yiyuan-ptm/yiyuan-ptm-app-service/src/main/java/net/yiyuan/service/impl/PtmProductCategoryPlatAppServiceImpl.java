package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.PtmProductCategoryPlatMapper;
import net.yiyuan.model.PtmProductCategoryPlat;
import net.yiyuan.service.PtmProductCategoryPlatAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * 平台商品分类移动端Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-11-19
 */
@Slf4j
@Service
public class PtmProductCategoryPlatAppServiceImpl
    extends JoinServiceImpl<PtmProductCategoryPlatMapper, PtmProductCategoryPlat>
    implements PtmProductCategoryPlatAppService {
  @Resource private PtmProductCategoryPlatMapper ptmProductCategoryPlatMapper;
}
