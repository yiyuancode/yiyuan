package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import icu.mhb.mybatisplus.plugln.extend.Joins;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.common.utils.StringUtilsPlus;
import net.yiyuan.dto.*;
import net.yiyuan.mapper.PtmProductMapper;
import net.yiyuan.mapper.PtmProductSkuMapper;
import net.yiyuan.model.PtmProduct;
import net.yiyuan.model.PtmProductSku;
import net.yiyuan.model.SpmShop;
import net.yiyuan.plugins.mp.utils.QueryWrapperUtils;
import net.yiyuan.service.PtmProductService;
import net.yiyuan.service.SysUserService;
import net.yiyuan.vo.PtmProductQueryVO;
import net.yiyuan.vo.PtmProductSkuQueryVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品信息Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Slf4j
@Service
public class PtmProductServiceImpl extends JoinServiceImpl<PtmProductMapper, PtmProduct>
    implements PtmProductService {
  @Resource private PtmProductMapper ptmProductMapper;
  @Resource private PtmProductSkuMapper ptmProductSkuMapper;
  @Resource private SysUserService sysUserService;

  /**
   * 商品信息列表(全部)
   *
   * @param request 商品信息实体
   * @return {@link List< PtmProductQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public List<PtmProductQueryVO> list(PtmProductListDTO request) throws Exception {

    PtmProduct po = new PtmProduct();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<PtmProduct> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.orderByDesc(PtmProduct::getSort);
    wrapper.orderByDesc(PtmProduct::getCreateTime);
    QueryWrapperUtils.resetLikeRight(
        wrapper, po, PtmProduct::getName, PtmProduct::getKeyword, PtmProduct::getTitle);
    List<PtmProductQueryVO> voList =
        ptmProductMapper.joinSelectList(wrapper, PtmProductQueryVO.class);

    return voList;
  }

  /**
   * 商品信息列表(分页)
   *
   * @param request 商品信息实体
   * @return {@link Page< PtmProductQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public Page<PtmProductQueryVO> page(PtmProductPageDTO request) throws Exception {
    JoinLambdaWrapper<PtmProduct> wrapper = Joins.of(PtmProduct.class);
    wrapper.orderByDesc(PtmProduct::getSort);
    wrapper.orderByDesc(PtmProduct::getCreateTime);
    QueryWrapperUtils.resetLikeRight(
        wrapper,
        request,
        PtmProductPageDTO::getName,
        PtmProductPageDTO::getKeyword,
        PtmProductPageDTO::getTitle);

    QueryWrapperUtils.resetBetween(
        wrapper,
        request,
        Arrays.asList(PtmProductPageDTO::getCreateTimeStart, PtmProductPageDTO::getCreateTimeEnd),
        Arrays.asList(PtmProductPageDTO::getStockStart, PtmProductPageDTO::getStockEnd));

    PtmProduct po = new PtmProduct();
    BeanUtilsPlus.copy(request, po);
    wrapper.setEntity(po);
    Page<PtmProductQueryVO> voPage =
        ptmProductMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            PtmProductQueryVO.class);
    return voPage;
  }

  /**
   * 商品信息详情
   *
   * @param id 商品信息id
   * @return {@link PtmProductQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public PtmProductQueryVO details(String id) throws Exception {
    PtmProduct po = new PtmProduct();
    po.setId(id);
    JoinLambdaWrapper<PtmProduct> wrapper = new JoinLambdaWrapper<>(po);
    PtmProductQueryVO voBean = ptmProductMapper.joinSelectOne(wrapper, PtmProductQueryVO.class);
    JoinLambdaWrapper<PtmProductSku> wrapper2 = Joins.of(PtmProductSku.class);
    wrapper2.eq(StringUtilsPlus.isNotEmpty(id), PtmProductSku::getPtmProductId, id);
    List<PtmProductSkuQueryVO> ptmProductSkus =
        ptmProductSkuMapper.joinSelectList(wrapper2, PtmProductSkuQueryVO.class);
    voBean.setSkuList(ptmProductSkus);
    return voBean;
  }

  /**
   * 商品信息详情
   *
   * @param request 商品信息实体
   * @return {@link PtmProduct}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public PtmProductQueryVO details(PtmProduct request) throws Exception {
    JoinLambdaWrapper<PtmProduct> wrapper = new JoinLambdaWrapper<>(request);
    PtmProductQueryVO voBean = ptmProductMapper.joinSelectOne(wrapper, PtmProductQueryVO.class);
    JoinLambdaWrapper<PtmProductSku> wrapper2 = Joins.of(PtmProductSku.class);
    wrapper2.eq(
        StringUtilsPlus.isNotEmpty(request.getId()),
        PtmProductSku::getPtmProductId,
        request.getId());
    List<PtmProductSkuQueryVO> ptmProductSkus =
        ptmProductSkuMapper.joinSelectList(wrapper2, PtmProductSkuQueryVO.class);
    voBean.setSkuList(ptmProductSkus);
    return voBean;
  }

  /**
   * 删除商品信息(支持批量)
   *
   * @param ids 商品信息id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    int i = ptmProductMapper.deleteBatchIds(idList);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑商品信息
   *
   * @param request 商品信息实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Transactional
  @Override
  public boolean edit(PtmProductEditDTO request) throws Exception {
    PtmProduct po = new PtmProduct();
    BeanUtilsPlus.copy(request, po);
    // 取出sku的总库存,以及最低各个价格
    List<PtmProductSkuEditDTO> skuList = request.getSkuList();
    if (StringUtilsPlus.isNotEmpty(skuList)) {
      Integer totalStock = skuList.stream().mapToInt(PtmProductSkuEditDTO::getStock).sum();
      BigDecimal minCrossedPrice =
          skuList.stream()
              .map(PtmProductSkuEditDTO::getCrossedPrice)
              .reduce(BigDecimal::min)
              .orElse(BigDecimal.ZERO);

      BigDecimal minCostPrice =
          skuList.stream()
              .map(PtmProductSkuEditDTO::getCostPrice)
              .reduce(BigDecimal::min)
              .orElse(BigDecimal.ZERO);

      BigDecimal minSalePrice =
          skuList.stream()
              .map(PtmProductSkuEditDTO::getSalePrice)
              .reduce(BigDecimal::min)
              .orElse(BigDecimal.ZERO);
      // 设置商品总体价格
      po.setCostPrice(minCostPrice);
      po.setSalePrice(minSalePrice);
      po.setCrossedPrice(minCrossedPrice);
      // 设置总库存
      po.setStock(totalStock);

      // 添加sku
      skuList.forEach(
          (sku) -> {
            if (StringUtilsPlus.isEmpty(sku.getId())) {
              sku.setPtmProductId(po.getId());
              PtmProductSku insert = new PtmProductSku();
              BeanUtilsPlus.copy(sku, insert);
              ptmProductSkuMapper.insert(insert);
            } else {
              PtmProductSku insert = new PtmProductSku();
              BeanUtilsPlus.copy(sku, insert);
              ptmProductSkuMapper.updateById(insert);
            }
          });

      List<String> skuIdList =
          skuList.stream()
              .map(PtmProductSkuEditDTO::getId) // 使用map操作提取id字段
              .filter(id -> StringUtilsPlus.isNotEmpty(id)) // 使用filter操作过滤为空的id
              .collect(Collectors.toList()); // 收集id字段到新的List

      JoinLambdaWrapper<PtmProductSku> skuWp = Joins.of(PtmProductSku.class);
      skuWp.notIn(PtmProductSku::getId, skuIdList);
      skuWp.eq(PtmProductSku::getPtmProductId, po.getId());
      List<PtmProductSkuQueryVO> skuVoList =
          ptmProductSkuMapper.joinSelectList(skuWp, PtmProductSkuQueryVO.class);

      List<String> delSkuIdList =
              skuVoList.stream()
                      .map(PtmProductSkuQueryVO::getId) // 使用map操作提取id字段
                      .filter(id -> StringUtilsPlus.isNotEmpty(id)) // 使用filter操作过滤为空的id
                      .collect(Collectors.toList()); // 收集id字段到新的List

      if (StringUtilsPlus.isNotEmpty(delSkuIdList)) {
        ptmProductSkuMapper.deleteBatchIds(delSkuIdList);
      }
    }

    int i = ptmProductMapper.updateById(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增商品信息
   *
   * @param request 商品信息实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public boolean add(PtmProductAddDTO request) throws Exception {
    PtmProduct po = new PtmProduct();
    BeanUtilsPlus.copy(request, po);
    // 取出sku的总库存,以及最低各个价格
    List<PtmProductSkuAddDTO> skuList = request.getSkuList();
    Integer totalStock = skuList.stream().mapToInt(PtmProductSkuAddDTO::getStock).sum();
    BigDecimal minCrossedPrice =
        skuList.stream()
            .map(PtmProductSkuAddDTO::getCrossedPrice)
            .reduce(BigDecimal::min)
            .orElse(BigDecimal.ZERO);

    BigDecimal minCostPrice =
        skuList.stream()
            .map(PtmProductSkuAddDTO::getCostPrice)
            .reduce(BigDecimal::min)
            .orElse(BigDecimal.ZERO);

    BigDecimal minSalePrice =
        skuList.stream()
            .map(PtmProductSkuAddDTO::getSalePrice)
            .reduce(BigDecimal::min)
            .orElse(BigDecimal.ZERO);
    // 设置商品总体价格
    po.setCostPrice(minCostPrice);
    po.setSalePrice(minSalePrice);
    po.setCrossedPrice(minCrossedPrice);
    // 设置总库存
    po.setStock(totalStock);

    // 根据店铺配置标记商品是否需要审核
    SpmShop shopOfUser = sysUserService.getShopOfUser();
    if (StringUtilsPlus.isNotNUll(shopOfUser)) {
      po.setIsAudit(shopOfUser.getIsAudit());
    }

    int i = ptmProductMapper.insert(po);
    // 添加sku
    skuList.forEach(
        (sku) -> {
          sku.setPtmProductId(po.getId());
          PtmProductSku insert = new PtmProductSku();
          BeanUtilsPlus.copy(sku, insert);
          ptmProductSkuMapper.insert(insert);
        });
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }

  @Override
  public boolean audit(PtmProductAuditDTO request) throws Exception {
    PtmProduct po = new PtmProduct();
    BeanUtilsPlus.copy(request, po);
    int i = ptmProductMapper.updateById(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("审核异常");
    }
  }
}
