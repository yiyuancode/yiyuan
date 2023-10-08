package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.PtmProductCategoryMapper;
import net.yiyuan.model.PtmProductCategory;
import net.yiyuan.service.PtmProductCategoryAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * 商品分类移动端Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-10-06
 */
@Slf4j
@Service
public class PtmProductCategoryAppServiceImpl
    extends JoinServiceImpl<PtmProductCategoryMapper, PtmProductCategory>
    implements PtmProductCategoryAppService {
  @Resource private PtmProductCategoryMapper ptmProductCategoryMapper;
}
