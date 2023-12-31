package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import icu.mhb.mybatisplus.plugln.extend.Joins;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.common.utils.EnumUtils;
import net.yiyuan.common.utils.TreeUtil;
import net.yiyuan.dto.PtmProductCategoryAddDTO;
import net.yiyuan.dto.PtmProductCategoryEditDTO;
import net.yiyuan.dto.PtmProductCategoryListDTO;
import net.yiyuan.dto.PtmProductCategoryPageDTO;
import net.yiyuan.enums.PtmProductCategoryLevelEnum;
import net.yiyuan.mapper.PtmProductCategoryMapper;
import net.yiyuan.model.PtmProductCategory;
import net.yiyuan.plugins.mp.utils.QueryWrapperUtils;
import net.yiyuan.service.PtmProductCategoryService;
import net.yiyuan.vo.PtmProductCategoryQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 商品分类Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Slf4j
@Service
public class PtmProductCategoryServiceImpl
    extends JoinServiceImpl<PtmProductCategoryMapper, PtmProductCategory>
    implements PtmProductCategoryService {
  @Resource private PtmProductCategoryMapper ptmProductCategoryMapper;

  /**
   * 商品分类列表(全部)
   *
   * @param request 商品分类实体
   * @return {@link List< PtmProductCategoryQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public List<PtmProductCategoryQueryVO> list(PtmProductCategoryListDTO request) throws Exception {

    PtmProductCategory po = new PtmProductCategory();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<PtmProductCategory> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.orderByDesc(PtmProductCategory::getSort);
    wrapper.orderByDesc(PtmProductCategory::getCreateTime);
    // 重置eq为like，支持多个字段
    QueryWrapperUtils.resetLikeRight(wrapper, po, PtmProductCategory::getName);
    List<PtmProductCategoryQueryVO> voList =
        ptmProductCategoryMapper.joinSelectList(wrapper, PtmProductCategoryQueryVO.class);

    return voList;
  }

  /**
   * 商品分类列表(分页)
   *
   * @param request 商品分类实体
   * @return {@link Page< PtmProductCategoryQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public Page<PtmProductCategoryQueryVO> page(PtmProductCategoryPageDTO request) throws Exception {
    PtmProductCategory po = new PtmProductCategory();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<PtmProductCategory> wrapper = new JoinLambdaWrapper<>(po);

    //    wrapper.like(
    //        StringUtilsPlus.isNotEmpty(po.getName()), PtmProductCategory::getName, po.getName());
    //    po.setName(null);
    // 重置eq查询为like查询
    QueryWrapperUtils.resetLikeRight(wrapper, po, PtmProductCategory::getName);

    wrapper.orderByDesc(PtmProductCategory::getSort);
    wrapper.orderByDesc(PtmProductCategory::getCreateTime);
    Page<PtmProductCategoryQueryVO> voPage =
        ptmProductCategoryMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            PtmProductCategoryQueryVO.class);
    return voPage;
  }

  /**
   * 商品分类详情
   *
   * @param id 商品分类id
   * @return {@link PtmProductCategoryQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public PtmProductCategoryQueryVO details(String id) throws Exception {
    PtmProductCategory po = new PtmProductCategory();
    po.setId(id);
    JoinLambdaWrapper<PtmProductCategory> wrapper = new JoinLambdaWrapper<>(po);
    PtmProductCategoryQueryVO voBean =
        ptmProductCategoryMapper.joinSelectOne(wrapper, PtmProductCategoryQueryVO.class);
    return voBean;
  }

  /**
   * 商品分类详情
   *
   * @param request 商品分类实体
   * @return {@link PtmProductCategory}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public PtmProductCategoryQueryVO details(PtmProductCategory request) throws Exception {
    JoinLambdaWrapper<PtmProductCategory> wrapper = new JoinLambdaWrapper<>(request);
    PtmProductCategoryQueryVO voBean =
        ptmProductCategoryMapper.joinSelectOne(wrapper, PtmProductCategoryQueryVO.class);
    return voBean;
  }

  /**
   * 删除商品分类(支持批量)
   *
   * @param ids 商品分类id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    int i = ptmProductCategoryMapper.deleteBatchIds(idList);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑商品分类
   *
   * @param request 商品分类实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public boolean edit(PtmProductCategoryEditDTO request) throws Exception {
    PtmProductCategory po = new PtmProductCategory();
    BeanUtilsPlus.copy(request, po);
    if ("0".equals(request.getPid())) {
      po.setLevel(PtmProductCategoryLevelEnum.FIRST_LEVEL_CLASSIFICATION);
    } else {
      PtmProductCategory parent = ptmProductCategoryMapper.selectById(request.getPid());
      Integer parentLevel = parent.getLevel().getValue();
      PtmProductCategoryLevelEnum poLevel =
          EnumUtils.getEnumByValue(parentLevel + 1, PtmProductCategoryLevelEnum.class);
      po.setLevel(poLevel);
    }
    int i = ptmProductCategoryMapper.updateById(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增商品分类
   *
   * @param request 商品分类实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Override
  public boolean add(PtmProductCategoryAddDTO request) throws Exception {
    PtmProductCategory po = new PtmProductCategory();
    BeanUtilsPlus.copy(request, po);
    if ("0".equals(request.getPid())) {
      po.setLevel(PtmProductCategoryLevelEnum.FIRST_LEVEL_CLASSIFICATION);
    } else {
      PtmProductCategory parent = ptmProductCategoryMapper.selectById(request.getPid());
      Integer parentLevel = parent.getLevel().getValue();
      PtmProductCategoryLevelEnum poLevel =
          EnumUtils.getEnumByValue(parentLevel + 1, PtmProductCategoryLevelEnum.class);
      po.setLevel(poLevel);
    }

    int i = ptmProductCategoryMapper.insert(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }

  @Override
  public List<PtmProductCategoryQueryVO> treeList(PtmProductCategoryListDTO request) {
    PtmProductCategory po = new PtmProductCategory();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<PtmProductCategory> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.orderByDesc(PtmProductCategory::getSort);
    wrapper.orderByDesc(PtmProductCategory::getCreateTime);
    List<PtmProductCategoryQueryVO> voList =
        ptmProductCategoryMapper.joinSelectList(wrapper, PtmProductCategoryQueryVO.class);
    List<PtmProductCategoryQueryVO> getTreeVOList = TreeUtil.buildTreeByTwoLayersFor(voList);
    return getTreeVOList;
  }

  @Override
  public List<PtmProductCategoryQueryVO> treeListForShop(PtmProductCategoryListDTO request)
      throws Exception {
    request.setLevel(PtmProductCategoryLevelEnum.THIRD_LEVEL_CLASSIFICATION);
    JoinLambdaWrapper<PtmProductCategory> wrapper = Joins.of(PtmProductCategory.class);
    wrapper.orderByDesc(PtmProductCategory::getSort);
    wrapper.orderByDesc(PtmProductCategory::getCreateTime);
    QueryWrapperUtils.resetGt(wrapper, request, PtmProductCategoryListDTO::getLevel);

    PtmProductCategory po = new PtmProductCategory();
    BeanUtilsPlus.copy(request, po);
    List<PtmProductCategoryQueryVO> voList =
        ptmProductCategoryMapper.joinSelectList(wrapper, PtmProductCategoryQueryVO.class);
    voList.forEach(
        (item) -> {
          if (PtmProductCategoryLevelEnum.FOUR_LEVEL_CLASSIFICATION.equals(item.getLevel())) {
            item.setPid("0");
          }
        });
    List<PtmProductCategoryQueryVO> getTreeVOList = TreeUtil.buildTreeByTwoLayersFor(voList);
    return getTreeVOList;
  }

  @Override
  public List<PtmProductCategoryQueryVO> treeListForPlat(PtmProductCategoryListDTO request)
      throws Exception {
    request.setLevel(PtmProductCategoryLevelEnum.FOUR_LEVEL_CLASSIFICATION);
    JoinLambdaWrapper<PtmProductCategory> wrapper = Joins.of(PtmProductCategory.class);
    wrapper.orderByDesc(PtmProductCategory::getSort);
    wrapper.orderByDesc(PtmProductCategory::getCreateTime);
    QueryWrapperUtils.resetLt(wrapper, request, PtmProductCategoryListDTO::getLevel);
    PtmProductCategory po = new PtmProductCategory();
    BeanUtilsPlus.copy(request, po);
    List<PtmProductCategoryQueryVO> voList =
        ptmProductCategoryMapper.joinSelectList(wrapper, PtmProductCategoryQueryVO.class);

    List<PtmProductCategoryQueryVO> getTreeVOList = TreeUtil.buildTreeByTwoLayersFor(voList);
    return getTreeVOList;
  }
}
