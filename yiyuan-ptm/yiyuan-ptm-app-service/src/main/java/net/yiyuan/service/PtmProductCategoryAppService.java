package net.yiyuan.service;

import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.model.PtmProductCategory;
import net.yiyuan.vo.PtmProductCategoryGetTreeVO;

import java.util.List;

/**
 * 商品分类移动端Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
public interface PtmProductCategoryAppService extends JoinIService<PtmProductCategory> {

  public List<PtmProductCategoryGetTreeVO> getTree() throws Exception;
}
