package net.yiyuan.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.common.utils.SkuUtil;
import net.yiyuan.dto.*;
import net.yiyuan.mapper.PtmProductSkuMapper;
import net.yiyuan.model.PtmProductSku;
import net.yiyuan.service.PtmProductSkuService;
import net.yiyuan.vo.PtmProductSkuQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 商品skuService层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Slf4j
@Service
public class PtmProductSkuServiceImpl extends JoinServiceImpl<PtmProductSkuMapper, PtmProductSku>
    implements PtmProductSkuService {
  @Resource private PtmProductSkuMapper ptmProductSkuMapper;

  /**
   * 商品sku列表(全部)
   *
   * @param request 商品sku实体
   * @return {@link List< PtmProductSkuQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public List<PtmProductSkuQueryVO> list(PtmProductSkuListDTO request) throws Exception {

    PtmProductSku po = new PtmProductSku();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<PtmProductSku> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.orderByDesc(PtmProductSku::getCreateTime);
    List<PtmProductSkuQueryVO> voList =
        ptmProductSkuMapper.joinSelectList(wrapper, PtmProductSkuQueryVO.class);

    return voList;
  }

  /**
   * 商品sku列表(分页)
   *
   * @param request 商品sku实体
   * @return {@link Page< PtmProductSkuQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public Page<PtmProductSkuQueryVO> page(PtmProductSkuPageDTO request) throws Exception {
    PtmProductSku po = new PtmProductSku();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<PtmProductSku> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.orderByDesc(PtmProductSku::getCreateTime);
    Page<PtmProductSkuQueryVO> voPage =
        ptmProductSkuMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            PtmProductSkuQueryVO.class);
    return voPage;
  }

  /**
   * 商品sku详情
   *
   * @param id 商品skuid
   * @return {@link PtmProductSkuQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public PtmProductSkuQueryVO details(String id) throws Exception {
    PtmProductSku po = new PtmProductSku();
    po.setId(id);
    JoinLambdaWrapper<PtmProductSku> wrapper = new JoinLambdaWrapper<>(po);
    PtmProductSkuQueryVO voBean =
        ptmProductSkuMapper.joinSelectOne(wrapper, PtmProductSkuQueryVO.class);
    return voBean;
  }

  /**
   * 商品sku详情
   *
   * @param request 商品sku实体
   * @return {@link PtmProductSku}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public PtmProductSkuQueryVO details(PtmProductSku request) throws Exception {
    JoinLambdaWrapper<PtmProductSku> wrapper = new JoinLambdaWrapper<>(request);
    PtmProductSkuQueryVO voBean =
        ptmProductSkuMapper.joinSelectOne(wrapper, PtmProductSkuQueryVO.class);
    return voBean;
  }

  /**
   * 删除商品sku(支持批量)
   *
   * @param ids 商品skuid(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    int i = ptmProductSkuMapper.deleteBatchIds(idList);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑商品sku
   *
   * @param request 商品sku实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public boolean edit(PtmProductSkuEditDTO request) throws Exception {
    PtmProductSku po = new PtmProductSku();
    BeanUtilsPlus.copy(request, po);
    int i = ptmProductSkuMapper.updateById(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增商品sku
   *
   * @param request 商品sku实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public boolean add(PtmProductSkuAddDTO request) throws Exception {
    PtmProductSku po = new PtmProductSku();
    BeanUtilsPlus.copy(request, po);
    int i = ptmProductSkuMapper.insert(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }

  @Override
  public List<PtmProductSkuQueryVO> makeSkuTempList(PtmProductSkuMakeSkuTempListDTO request) {
    List<PtmProductSkuQueryVO> resultSkuList = new ArrayList<>();
    List<Map<String, String>> skuList =
        SkuUtil.generateCombinations(request.getAttrKeyList(), request.getAttrValList());
    skuList.forEach(
        (item) -> {
          PtmProductSkuQueryVO newSku = new PtmProductSkuQueryVO();
          newSku.setSku(JSONObject.toJSONString(item));
          newSku.setCostPrice(new BigDecimal(0.00));
          newSku.setCrossedPrice(new BigDecimal(0.00));
          newSku.setSalePrice(new BigDecimal(0.00));
          newSku.setStock(0);
          newSku.setIsShow(true);
          resultSkuList.add(newSku);
        });
    return resultSkuList;
  }
}
