package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import icu.mhb.mybatisplus.plugln.extend.Joins;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.TreeUtil;
import net.yiyuan.mapper.PtmProductCategoryMapper;
import net.yiyuan.model.PtmProductCategory;
import net.yiyuan.service.PtmProductCategoryAppService;
import net.yiyuan.vo.PtmProductCategoryGetTreeVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品分类移动端Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Slf4j
@Service
public class PtmProductCategoryAppServiceImpl
    extends JoinServiceImpl<PtmProductCategoryMapper, PtmProductCategory>
    implements PtmProductCategoryAppService {
  @Resource private PtmProductCategoryMapper ptmProductCategoryMapper;

  @Override
  public List<PtmProductCategoryGetTreeVO> getTree() throws Exception {
    JoinLambdaWrapper<PtmProductCategory> wrapper = Joins.of(PtmProductCategory.class);
    wrapper.select(
        PtmProductCategory::getId,
        PtmProductCategory::getPid,
        PtmProductCategory::getIcon,
        PtmProductCategory::getName);
    wrapper.eq(PtmProductCategory::getIsShow, true);
    wrapper.orderByDesc(PtmProductCategory::getSort);
    wrapper.orderByDesc(PtmProductCategory::getCreateTime);
    List<PtmProductCategoryGetTreeVO> vOList =
        ptmProductCategoryMapper.joinSelectList(wrapper, PtmProductCategoryGetTreeVO.class);
    List<PtmProductCategoryGetTreeVO> getTreeVOList = TreeUtil.buildTreeByTwoLayersFor(vOList);
    return getTreeVOList;
  }
}
