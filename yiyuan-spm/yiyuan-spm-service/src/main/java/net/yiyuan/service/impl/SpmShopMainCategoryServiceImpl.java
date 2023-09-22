package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.SpmShopMainCategoryAddDTO;
import net.yiyuan.dto.SpmShopMainCategoryEditDTO;
import net.yiyuan.dto.SpmShopMainCategoryListDTO;
import net.yiyuan.dto.SpmShopMainCategoryPageDTO;
import net.yiyuan.enums.SpmShopMainCategoryIsDelEnum;
import net.yiyuan.mapper.SpmShopMainCategoryMapper;
import net.yiyuan.model.SpmShopMainCategory;
import net.yiyuan.plugins.mp.utils.LambdaFunUtils;
import net.yiyuan.service.SpmShopMainCategoryService;
import net.yiyuan.vo.SpmShopMainCategoryQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 店铺主营类目Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-22
 */
@Slf4j
@Service
public class SpmShopMainCategoryServiceImpl
    extends JoinServiceImpl<SpmShopMainCategoryMapper, SpmShopMainCategory>
    implements SpmShopMainCategoryService {
  @Resource private SpmShopMainCategoryMapper spmShopMainCategoryMapper;

  /**
   * 店铺主营类目列表(全部)
   *
   * @param request 店铺主营类目实体
   * @return {@link List< SpmShopMainCategoryQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @Override
  public List<SpmShopMainCategoryQueryVO> list(SpmShopMainCategoryListDTO request)
      throws Exception {

    SpmShopMainCategory po = new SpmShopMainCategory();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SpmShopMainCategory> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.eq(SpmShopMainCategory::getIsDel, SpmShopMainCategoryIsDelEnum.NOT_DELETED);

    wrapper.orderByDesc(SpmShopMainCategory::getSort);
    wrapper.orderByDesc(SpmShopMainCategory::getCreateTime);

    List<SpmShopMainCategoryQueryVO> voList =
        spmShopMainCategoryMapper.joinSelectList(wrapper, SpmShopMainCategoryQueryVO.class);

    return voList;
  }

  /**
   * 店铺主营类目列表(分页)
   *
   * @param request 店铺主营类目实体
   * @return {@link Page< SpmShopMainCategoryQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @Override
  public Page<SpmShopMainCategoryQueryVO> page(SpmShopMainCategoryPageDTO request)
      throws Exception {
    SpmShopMainCategory po = new SpmShopMainCategory();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SpmShopMainCategory> wrapper = new JoinLambdaWrapper<>(po);

    wrapper.eq(SpmShopMainCategory::getIsDel, SpmShopMainCategoryIsDelEnum.NOT_DELETED);

    wrapper.orderByDesc(SpmShopMainCategory::getSort);
    wrapper.orderByDesc(SpmShopMainCategory::getCreateTime);
    Page<SpmShopMainCategoryQueryVO> voPage =
        spmShopMainCategoryMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            SpmShopMainCategoryQueryVO.class);
    return voPage;
  }

  /**
   * 店铺主营类目详情
   *
   * @param id 店铺主营类目id
   * @return {@link SpmShopMainCategoryQueryVO}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @Override
  public SpmShopMainCategoryQueryVO details(String id) throws Exception {
    SpmShopMainCategory po = new SpmShopMainCategory();
    po.setId(id);
    JoinLambdaWrapper<SpmShopMainCategory> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.eq(SpmShopMainCategory::getIsDel, SpmShopMainCategoryIsDelEnum.NOT_DELETED);

    SpmShopMainCategoryQueryVO voBean =
        spmShopMainCategoryMapper.joinSelectOne(wrapper, SpmShopMainCategoryQueryVO.class);
    return voBean;
  }

  /**
   * 店铺主营类目详情
   *
   * @param request 店铺主营类目实体
   * @return {@link SpmShopMainCategory}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @Override
  public SpmShopMainCategoryQueryVO details(SpmShopMainCategory request) throws Exception {
    JoinLambdaWrapper<SpmShopMainCategory> wrapper = new JoinLambdaWrapper<>(request);
    wrapper.eq(SpmShopMainCategory::getIsDel, SpmShopMainCategoryIsDelEnum.NOT_DELETED);
    SpmShopMainCategoryQueryVO voBean =
        spmShopMainCategoryMapper.joinSelectOne(wrapper, SpmShopMainCategoryQueryVO.class);
    return voBean;
  }

  /**
   * 删除店铺主营类目(支持批量)
   *
   * @param ids 店铺主营类目id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    UpdateWrapper<SpmShopMainCategory> updateWrapper = new UpdateWrapper();
    updateWrapper.in(LambdaFunUtils.getFieldName(SpmShopMainCategory::getId), idList);
    LambdaUpdateWrapper<SpmShopMainCategory> lambdaWrapper = updateWrapper.lambda();
    lambdaWrapper.set(SpmShopMainCategory::getIsDel, SpmShopMainCategoryIsDelEnum.DELETED);
    int i = spmShopMainCategoryMapper.update(null, updateWrapper);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑店铺主营类目
   *
   * @param request 店铺主营类目实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @Override
  public boolean edit(SpmShopMainCategoryEditDTO request) throws Exception {
    SpmShopMainCategory po = new SpmShopMainCategory();
    BeanUtilsPlus.copy(request, po);
    int i = spmShopMainCategoryMapper.updateById(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增店铺主营类目
   *
   * @param request 店铺主营类目实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @Override
  public boolean add(SpmShopMainCategoryAddDTO request) throws Exception {
    SpmShopMainCategory po = new SpmShopMainCategory();
    BeanUtilsPlus.copy(request, po);
    int i = spmShopMainCategoryMapper.insert(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }
}
