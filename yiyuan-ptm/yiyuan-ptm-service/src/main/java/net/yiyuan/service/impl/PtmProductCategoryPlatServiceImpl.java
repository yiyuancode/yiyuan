package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.common.utils.EnumUtils;
import net.yiyuan.common.utils.StringUtilsPlus;
import net.yiyuan.common.utils.TreeUtil;
import net.yiyuan.dto.PtmProductCategoryPlatAddDTO;
import net.yiyuan.dto.PtmProductCategoryPlatEditDTO;
import net.yiyuan.dto.PtmProductCategoryPlatListDTO;
import net.yiyuan.dto.PtmProductCategoryPlatPageDTO;
import net.yiyuan.enums.PtmProductCategoryPlatLevelEnum;
import net.yiyuan.mapper.PtmProductCategoryPlatMapper;
import net.yiyuan.model.PtmProductCategoryPlat;
import net.yiyuan.service.PtmProductCategoryPlatService;
import net.yiyuan.vo.PtmProductCategoryPlatQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 平台商品分类Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-11-19
 */
@Slf4j
@Service
public class PtmProductCategoryPlatServiceImpl
    extends JoinServiceImpl<PtmProductCategoryPlatMapper, PtmProductCategoryPlat>
    implements PtmProductCategoryPlatService {
  @Resource private PtmProductCategoryPlatMapper ptmProductCategoryPlatMapper;

  /**
   * 平台商品分类列表(全部)
   *
   * @param request 平台商品分类实体
   * @return {@link List< PtmProductCategoryPlatQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Override
  public List<PtmProductCategoryPlatQueryVO> list(PtmProductCategoryPlatListDTO request)
      throws Exception {

    PtmProductCategoryPlat po = new PtmProductCategoryPlat();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<PtmProductCategoryPlat> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.orderByDesc(PtmProductCategoryPlat::getSort);
    wrapper.orderByDesc(PtmProductCategoryPlat::getCreateTime);
    List<PtmProductCategoryPlatQueryVO> voList =
        ptmProductCategoryPlatMapper.joinSelectList(wrapper, PtmProductCategoryPlatQueryVO.class);

    return voList;
  }

  /**
   * 平台商品分类列表(分页)
   *
   * @param request 平台商品分类实体
   * @return {@link Page< PtmProductCategoryPlatQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Override
  public Page<PtmProductCategoryPlatQueryVO> page(PtmProductCategoryPlatPageDTO request)
      throws Exception {
    PtmProductCategoryPlat po = new PtmProductCategoryPlat();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<PtmProductCategoryPlat> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.orderByDesc(PtmProductCategoryPlat::getSort);
    wrapper.orderByDesc(PtmProductCategoryPlat::getCreateTime);
    Page<PtmProductCategoryPlatQueryVO> voPage =
        ptmProductCategoryPlatMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            PtmProductCategoryPlatQueryVO.class);
    return voPage;
  }

  /**
   * 平台商品分类详情
   *
   * @param id 平台商品分类id
   * @return {@link PtmProductCategoryPlatQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Override
  public PtmProductCategoryPlatQueryVO details(String id) throws Exception {
    PtmProductCategoryPlat po = new PtmProductCategoryPlat();
    po.setId(id);
    JoinLambdaWrapper<PtmProductCategoryPlat> wrapper = new JoinLambdaWrapper<>(po);
    PtmProductCategoryPlatQueryVO voBean =
        ptmProductCategoryPlatMapper.joinSelectOne(wrapper, PtmProductCategoryPlatQueryVO.class);
    return voBean;
  }

  /**
   * 平台商品分类详情
   *
   * @param request 平台商品分类实体
   * @return {@link PtmProductCategoryPlat}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Override
  public PtmProductCategoryPlatQueryVO details(PtmProductCategoryPlat request) throws Exception {
    JoinLambdaWrapper<PtmProductCategoryPlat> wrapper = new JoinLambdaWrapper<>(request);
    PtmProductCategoryPlatQueryVO voBean =
        ptmProductCategoryPlatMapper.joinSelectOne(wrapper, PtmProductCategoryPlatQueryVO.class);
    return voBean;
  }

  /**
   * 删除平台商品分类(支持批量)
   *
   * @param ids 平台商品分类id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    int i = ptmProductCategoryPlatMapper.deleteBatchIds(idList);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑平台商品分类
   *
   * @param request 平台商品分类实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Override
  public boolean edit(PtmProductCategoryPlatEditDTO request) throws Exception {
    PtmProductCategoryPlat po = new PtmProductCategoryPlat();
    BeanUtilsPlus.copy(request, po);
    if (StringUtilsPlus.isEmpty(request.getPid())) {
      po.setLevel(PtmProductCategoryPlatLevelEnum.FIRST_LEVEL_CLASSIFICATION);
    } else {
      PtmProductCategoryPlat parent = ptmProductCategoryPlatMapper.selectById(request.getPid());
      Integer parentLevel = parent.getLevel().getValue();
      PtmProductCategoryPlatLevelEnum poLevel =
          EnumUtils.getEnumByValue(parentLevel + 1, PtmProductCategoryPlatLevelEnum.class);
      po.setLevel(poLevel);
    }
    int i = ptmProductCategoryPlatMapper.updateById(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增平台商品分类
   *
   * @param request 平台商品分类实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Override
  public boolean add(PtmProductCategoryPlatAddDTO request) throws Exception {
    PtmProductCategoryPlat po = new PtmProductCategoryPlat();
    BeanUtilsPlus.copy(request, po);
    if (StringUtilsPlus.isEmpty(request.getPid())) {
      po.setLevel(PtmProductCategoryPlatLevelEnum.FIRST_LEVEL_CLASSIFICATION);
    } else {
      PtmProductCategoryPlat parent = ptmProductCategoryPlatMapper.selectById(request.getPid());
      Integer parentLevel = parent.getLevel().getValue();
      PtmProductCategoryPlatLevelEnum poLevel =
          EnumUtils.getEnumByValue(parentLevel + 1, PtmProductCategoryPlatLevelEnum.class);
      po.setLevel(poLevel);
    }
    int i = ptmProductCategoryPlatMapper.insert(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }

  /**
   * 查询平台商品分类树结构
   *
   * @param request 平台商品分类实体
   * @return {@link List< PtmProductCategoryPlatQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Override
  public List<PtmProductCategoryPlatQueryVO> tree(PtmProductCategoryPlatListDTO request)
      throws Exception {
    PtmProductCategoryPlat po = new PtmProductCategoryPlat();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<PtmProductCategoryPlat> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.orderByDesc(PtmProductCategoryPlat::getSort);
    wrapper.orderByDesc(PtmProductCategoryPlat::getCreateTime);
    List<PtmProductCategoryPlatQueryVO> voList =
        ptmProductCategoryPlatMapper.joinSelectList(wrapper, PtmProductCategoryPlatQueryVO.class);
    List<PtmProductCategoryPlatQueryVO> getTreeVOList = TreeUtil.buildTreeByTwoLayersFor(voList);
    return getTreeVOList;
  }
}
