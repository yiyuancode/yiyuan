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
import net.yiyuan.dto.PtmProductCategoryShopAddDTO;
import net.yiyuan.dto.PtmProductCategoryShopEditDTO;
import net.yiyuan.dto.PtmProductCategoryShopListDTO;
import net.yiyuan.dto.PtmProductCategoryShopPageDTO;
import net.yiyuan.enums.PtmProductCategoryShopLevelEnum;
import net.yiyuan.mapper.PtmProductCategoryShopMapper;
import net.yiyuan.model.PtmProductCategoryShop;
import net.yiyuan.service.PtmProductCategoryShopService;
import net.yiyuan.vo.PtmProductCategoryShopQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 店铺商品分类Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-11-19
 */
@Slf4j
@Service
public class PtmProductCategoryShopServiceImpl
    extends JoinServiceImpl<PtmProductCategoryShopMapper, PtmProductCategoryShop>
    implements PtmProductCategoryShopService {
  @Resource private PtmProductCategoryShopMapper ptmProductCategoryShopMapper;

  /**
   * 店铺商品分类列表(全部)
   *
   * @param request 店铺商品分类实体
   * @return {@link List< PtmProductCategoryShopQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Override
  public List<PtmProductCategoryShopQueryVO> list(PtmProductCategoryShopListDTO request)
      throws Exception {

    PtmProductCategoryShop po = new PtmProductCategoryShop();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<PtmProductCategoryShop> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.orderByDesc(PtmProductCategoryShop::getSort);
    wrapper.orderByDesc(PtmProductCategoryShop::getCreateTime);
    List<PtmProductCategoryShopQueryVO> voList =
        ptmProductCategoryShopMapper.joinSelectList(wrapper, PtmProductCategoryShopQueryVO.class);

    return voList;
  }

  /**
   * 店铺商品分类列表(分页)
   *
   * @param request 店铺商品分类实体
   * @return {@link Page< PtmProductCategoryShopQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Override
  public Page<PtmProductCategoryShopQueryVO> page(PtmProductCategoryShopPageDTO request)
      throws Exception {
    PtmProductCategoryShop po = new PtmProductCategoryShop();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<PtmProductCategoryShop> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.orderByDesc(PtmProductCategoryShop::getSort);
    wrapper.orderByDesc(PtmProductCategoryShop::getCreateTime);
    Page<PtmProductCategoryShopQueryVO> voPage =
        ptmProductCategoryShopMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            PtmProductCategoryShopQueryVO.class);
    return voPage;
  }

  /**
   * 店铺商品分类详情
   *
   * @param id 店铺商品分类id
   * @return {@link PtmProductCategoryShopQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Override
  public PtmProductCategoryShopQueryVO details(String id) throws Exception {
    PtmProductCategoryShop po = new PtmProductCategoryShop();
    po.setId(id);
    JoinLambdaWrapper<PtmProductCategoryShop> wrapper = new JoinLambdaWrapper<>(po);
    PtmProductCategoryShopQueryVO voBean =
        ptmProductCategoryShopMapper.joinSelectOne(wrapper, PtmProductCategoryShopQueryVO.class);
    return voBean;
  }

  /**
   * 店铺商品分类详情
   *
   * @param request 店铺商品分类实体
   * @return {@link PtmProductCategoryShop}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Override
  public PtmProductCategoryShopQueryVO details(PtmProductCategoryShop request) throws Exception {
    JoinLambdaWrapper<PtmProductCategoryShop> wrapper = new JoinLambdaWrapper<>(request);
    PtmProductCategoryShopQueryVO voBean =
        ptmProductCategoryShopMapper.joinSelectOne(wrapper, PtmProductCategoryShopQueryVO.class);
    return voBean;
  }

  /**
   * 删除店铺商品分类(支持批量)
   *
   * @param ids 店铺商品分类id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    int i = ptmProductCategoryShopMapper.deleteBatchIds(idList);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑店铺商品分类
   *
   * @param request 店铺商品分类实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Override
  public boolean edit(PtmProductCategoryShopEditDTO request) throws Exception {
    PtmProductCategoryShop po = new PtmProductCategoryShop();
    BeanUtilsPlus.copy(request, po);
    if (StringUtilsPlus.isEmpty(request.getPid())) {
      po.setLevel(PtmProductCategoryShopLevelEnum.FIRST_LEVEL_CLASSIFICATION);
    } else {
      PtmProductCategoryShop parent = ptmProductCategoryShopMapper.selectById(request.getPid());
      Integer parentLevel = parent.getLevel().getValue();
      PtmProductCategoryShopLevelEnum poLevel =
          EnumUtils.getEnumByValue(parentLevel + 1, PtmProductCategoryShopLevelEnum.class);
      po.setLevel(poLevel);
    }
    int i = ptmProductCategoryShopMapper.updateById(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增店铺商品分类
   *
   * @param request 店铺商品分类实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Override
  public boolean add(PtmProductCategoryShopAddDTO request) throws Exception {
    PtmProductCategoryShop po = new PtmProductCategoryShop();
    BeanUtilsPlus.copy(request, po);
    if (StringUtilsPlus.isEmpty(request.getPid())) {
      po.setLevel(PtmProductCategoryShopLevelEnum.FIRST_LEVEL_CLASSIFICATION);
    } else {
      PtmProductCategoryShop parent = ptmProductCategoryShopMapper.selectById(request.getPid());
      Integer parentLevel = parent.getLevel().getValue();
      PtmProductCategoryShopLevelEnum poLevel =
          EnumUtils.getEnumByValue(parentLevel + 1, PtmProductCategoryShopLevelEnum.class);
      po.setLevel(poLevel);
    }
    int i = ptmProductCategoryShopMapper.insert(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }

  /**
   * 查询店铺商品分类树结构
   *
   * @param request 店铺商品分类实体
   * @return {@link List< PtmProductCategoryShopQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  @Override
  public List<PtmProductCategoryShopQueryVO> tree(PtmProductCategoryShopListDTO request)
      throws Exception {

    PtmProductCategoryShop po = new PtmProductCategoryShop();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<PtmProductCategoryShop> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.orderByDesc(PtmProductCategoryShop::getSort);
    wrapper.orderByDesc(PtmProductCategoryShop::getCreateTime);
    List<PtmProductCategoryShopQueryVO> voList =
        ptmProductCategoryShopMapper.joinSelectList(wrapper, PtmProductCategoryShopQueryVO.class);
    List<PtmProductCategoryShopQueryVO> getTreeVOList = TreeUtil.buildTreeByTwoLayersFor(voList);
    return getTreeVOList;
  }
}
