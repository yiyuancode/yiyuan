package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import icu.mhb.mybatisplus.plugln.extend.Joins;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.PtmProductGetPageListDTO;
import net.yiyuan.mapper.PtmProductMapper;
import net.yiyuan.model.PtmProduct;
import net.yiyuan.model.SpmShop;
import net.yiyuan.plugins.mp.utils.QueryWrapperUtils;
import net.yiyuan.service.PtmProductAppService;
import net.yiyuan.vo.PtmProductQueryVO;
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

  @Override
  public Page<PtmProductQueryVO> getPageList(PtmProductGetPageListDTO request) throws Exception {
    PtmProduct po = new PtmProduct();
    BeanUtilsPlus.copy(request, po);
    SpmShop spmShopPo = new SpmShop();
    BeanUtilsPlus.copy(request, spmShopPo);
    JoinLambdaWrapper<PtmProduct> wrapper = Joins.of(PtmProduct.class);
    wrapper.select(
        PtmProduct::getId,
        PtmProduct::getName,
        PtmProduct::getSalePrice,
        PtmProduct::getKeyword,
        PtmProduct::getSales,
        PtmProduct::getFictiSales);
    QueryWrapperUtils.eq(wrapper, po, PtmProduct::getTenantCategoryId);
    wrapper
        .leftJoin(SpmShop.class, SpmShop::getId, PtmProduct::getTenantId)
        .select(SpmShop::getShopName)
        .end();

    Page<PtmProductQueryVO> ptmProductPage =
        ptmProductMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            PtmProductQueryVO.class);
    return ptmProductPage;
  }
}
