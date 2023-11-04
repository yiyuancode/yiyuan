package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import icu.mhb.mybatisplus.plugln.extend.Joins;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.common.utils.StringUtilsPlus;
import net.yiyuan.dto.PtmProductBrandAddDTO;
import net.yiyuan.dto.PtmProductBrandEditDTO;
import net.yiyuan.dto.PtmProductBrandListDTO;
import net.yiyuan.dto.PtmProductBrandPageDTO;
import net.yiyuan.mapper.PtmProductBrandMapper;
import net.yiyuan.mapper.PtmProductCategoryBrandLinkMapper;
import net.yiyuan.model.PtmProductBrand;
import net.yiyuan.model.PtmProductCategory;
import net.yiyuan.model.PtmProductCategoryBrandLink;
import net.yiyuan.plugins.mp.utils.CenterJoinUtils;
import net.yiyuan.service.PtmProductBrandService;
import net.yiyuan.vo.PtmProductBrandQueryVO;
import net.yiyuan.vo.PtmProductCategoryQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 品牌Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Slf4j
@Service
public class PtmProductBrandServiceImpl
    extends JoinServiceImpl<PtmProductBrandMapper, PtmProductBrand>
    implements PtmProductBrandService {
  @Resource private PtmProductBrandMapper ptmProductBrandMapper;
  @Resource private PtmProductCategoryBrandLinkMapper ptmProductCategoryBrandLinkMapper;
  private CenterJoinUtils<
          PtmProductCategory, PtmProductCategoryBrandLink, PtmProductBrand, PtmProductBrandQueryVO>
      ptmProductCategoryBrandJoin;

  private CenterJoinUtils<
          PtmProductBrand,
          PtmProductCategoryBrandLink,
          PtmProductCategory,
          PtmProductCategoryQueryVO>
      ptmProductCategoryJoin;
  /**
   * 品牌列表(全部)
   *
   * @param request 品牌实体
   * @return {@link List< PtmProductBrandQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public List<PtmProductBrandQueryVO> list(PtmProductBrandListDTO request) throws Exception {

    PtmProductBrand po = new PtmProductBrand();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<PtmProductBrand> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.orderByDesc(PtmProductBrand::getSort);
    wrapper.orderByDesc(PtmProductBrand::getCreateTime);

    if (StringUtilsPlus.isNotEmpty(request.getCategoryId())) {
      // 构造成list 调用
      ptmProductCategoryBrandJoin =
          new CenterJoinUtils<>(
              PtmProductCategory::getId,
              PtmProductCategoryBrandLink::getPtmProductCategoryId,
              PtmProductCategoryBrandLink::getPtmProductBrandId,
              PtmProductBrand::getId,
              Arrays.asList(request.getCategoryId()));
      List<String> idList =
          ptmProductCategoryBrandJoin.getRightAnyFieldList(PtmProductBrand::getId);
      if (StringUtilsPlus.isEmpty(idList)) {
        return new ArrayList<>();
      } else {
        wrapper.in(StringUtilsPlus.isNotEmpty(idList), PtmProductBrand::getId, idList);
      }
    }

    List<PtmProductBrandQueryVO> voList =
        ptmProductBrandMapper.joinSelectList(wrapper, PtmProductBrandQueryVO.class);
    return voList;
  }

  /**
   * 品牌列表(分页)
   *
   * @param request 品牌实体
   * @return {@link Page< PtmProductBrandQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public Page<PtmProductBrandQueryVO> page(PtmProductBrandPageDTO request) throws Exception {
    PtmProductBrand po = new PtmProductBrand();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<PtmProductBrand> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.orderByDesc(PtmProductBrand::getSort);
    wrapper.orderByDesc(PtmProductBrand::getCreateTime);

    if (StringUtilsPlus.isNotEmpty(request.getCategoryIds())) {
      // 构造成list 调用
      ptmProductCategoryBrandJoin =
          new CenterJoinUtils<>(
              PtmProductCategory::getId,
              PtmProductCategoryBrandLink::getPtmProductCategoryId,
              PtmProductCategoryBrandLink::getPtmProductBrandId,
              PtmProductBrand::getId,
              Arrays.asList(request.getCategoryIds().split(",")));
      List<String> idList =
          ptmProductCategoryBrandJoin.getRightAnyFieldList(PtmProductBrand::getId);
      if (StringUtilsPlus.isEmpty(idList)) {
        return new Page<>(request.getPageNum(), request.getPageSize(), 0);
      } else {
        wrapper.in(StringUtilsPlus.isNotEmpty(idList), PtmProductBrand::getId, idList);
      }
    }
    Page<PtmProductBrandQueryVO> voPage =
        ptmProductBrandMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            PtmProductBrandQueryVO.class);
    return voPage;
  }

  /**
   * 品牌详情
   *
   * @param id 品牌id
   * @return {@link PtmProductBrandQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public PtmProductBrandQueryVO details(String id) throws Exception {
    PtmProductBrand po = new PtmProductBrand();
    po.setId(id);
    JoinLambdaWrapper<PtmProductBrand> wrapper = new JoinLambdaWrapper<>(po);
    ptmProductCategoryJoin =
        new CenterJoinUtils<>(
            PtmProductBrand::getId,
            PtmProductCategoryBrandLink::getPtmProductCategoryId,
            PtmProductCategoryBrandLink::getPtmProductBrandId,
            PtmProductCategory::getId,
            Arrays.asList(id));

    List<PtmProductCategory> righList = ptmProductCategoryJoin.getRighList();
    PtmProductBrandQueryVO voBean =
        ptmProductBrandMapper.joinSelectOne(wrapper, PtmProductBrandQueryVO.class);
    voBean.setCategoryList(righList);

    return voBean;
  }

  /**
   * 品牌详情
   *
   * @param request 品牌实体
   * @return {@link PtmProductBrand}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public PtmProductBrandQueryVO details(PtmProductBrand request) throws Exception {
    JoinLambdaWrapper<PtmProductBrand> wrapper = new JoinLambdaWrapper<>(request);
    PtmProductBrandQueryVO voBean =
        ptmProductBrandMapper.joinSelectOne(wrapper, PtmProductBrandQueryVO.class);
    return voBean;
  }

  /**
   * 删除品牌(支持批量)
   *
   * @param ids 品牌id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    int i = ptmProductBrandMapper.deleteBatchIds(idList);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑品牌
   *
   * @param request 品牌实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public boolean edit(PtmProductBrandEditDTO request) throws Exception {
    PtmProductBrand po = new PtmProductBrand();
    BeanUtilsPlus.copy(request, po);
    int i = ptmProductBrandMapper.updateById(po);

    String[] categoryIds = request.getCategoryIds().split(",");
    JoinLambdaWrapper<PtmProductCategoryBrandLink> categoryBrandLinkWarpper =
        Joins.of(PtmProductCategoryBrandLink.class);
    categoryBrandLinkWarpper.in(
        PtmProductCategoryBrandLink::getPtmProductCategoryId, Arrays.asList(categoryIds));
    ptmProductCategoryBrandLinkMapper.delete(categoryBrandLinkWarpper);
    for (String categoryId : categoryIds) {
      PtmProductCategoryBrandLink categoryBrandLinkPo = new PtmProductCategoryBrandLink();
      categoryBrandLinkPo.setPtmProductBrandId(po.getId());
      categoryBrandLinkPo.setPtmProductCategoryId(categoryId);
      ptmProductCategoryBrandLinkMapper.insert(categoryBrandLinkPo);
    }

    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增品牌
   *
   * @param request 品牌实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public boolean add(PtmProductBrandAddDTO request) throws Exception {
    PtmProductBrand po = new PtmProductBrand();
    BeanUtilsPlus.copy(request, po);
    int i = ptmProductBrandMapper.insert(po);
    String[] categoryIds = request.getCategoryIds().split(",");
    for (String categoryId : categoryIds) {
      PtmProductCategoryBrandLink categoryBrandLinkPo = new PtmProductCategoryBrandLink();
      categoryBrandLinkPo.setPtmProductBrandId(po.getId());
      categoryBrandLinkPo.setPtmProductCategoryId(categoryId);
      ptmProductCategoryBrandLinkMapper.insert(categoryBrandLinkPo);
    }
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }

  @Override
  public List<PtmProductBrandQueryVO> listOfCategory(String categoryIds) throws Exception {
    // 构造成list 调用
    ptmProductCategoryBrandJoin =
        new CenterJoinUtils<>(
            PtmProductCategory::getId,
            PtmProductCategoryBrandLink::getPtmProductCategoryId,
            PtmProductCategoryBrandLink::getPtmProductBrandId,
            PtmProductBrand::getId,
            Arrays.asList(categoryIds.split(",")));

    List<PtmProductBrandQueryVO> righList =
        ptmProductCategoryBrandJoin.getRighListForClass(PtmProductBrandQueryVO.class);
    return righList;
  }
}
