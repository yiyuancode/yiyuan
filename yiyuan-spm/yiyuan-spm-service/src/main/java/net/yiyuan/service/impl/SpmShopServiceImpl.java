package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.SpmShopAddDTO;
import net.yiyuan.dto.SpmShopEditDTO;
import net.yiyuan.dto.SpmShopListDTO;
import net.yiyuan.dto.SpmShopPageDTO;
import net.yiyuan.enums.SpmShopIsDelEnum;
import net.yiyuan.mapper.SpmShopMapper;
import net.yiyuan.model.SpmShop;
import net.yiyuan.service.SpmShopService;
import net.yiyuan.vo.SpmShopQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 店铺Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-22
 */
@Slf4j
@Service
public class SpmShopServiceImpl extends JoinServiceImpl<SpmShopMapper, SpmShop>
    implements SpmShopService {
  @Resource private SpmShopMapper spmShopMapper;

  /**
   * 店铺列表(全部)
   *
   * @param request 店铺实体
   * @return {@link List< SpmShopQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @Override
  public List<SpmShopQueryVO> list(SpmShopListDTO request) throws Exception {

    SpmShop po = new SpmShop();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SpmShop> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.eq(SpmShop::getIsDel, SpmShopIsDelEnum.NOT_DELETED);
    wrapper.orderByDesc(SpmShop::getSort);
    wrapper.orderByDesc(SpmShop::getCreateTime);
    List<SpmShopQueryVO> voList = spmShopMapper.joinSelectList(wrapper, SpmShopQueryVO.class);

    return voList;
  }

  /**
   * 店铺列表(分页)
   *
   * @param request 店铺实体
   * @return {@link Page< SpmShopQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @Override
  public Page<SpmShopQueryVO> page(SpmShopPageDTO request) throws Exception {
    SpmShop po = new SpmShop();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SpmShop> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.eq(SpmShop::getIsDel, SpmShopIsDelEnum.NOT_DELETED);
    wrapper.orderByDesc(SpmShop::getSort);
    wrapper.orderByDesc(SpmShop::getCreateTime);
    Page<SpmShopQueryVO> voPage =
        spmShopMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()), wrapper, SpmShopQueryVO.class);
    return voPage;
  }

  /**
   * 店铺详情
   *
   * @param id 店铺id
   * @return {@link SpmShopQueryVO}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @Override
  public SpmShopQueryVO details(String id) throws Exception {
    SpmShop po = new SpmShop();
    po.setId(id);
    JoinLambdaWrapper<SpmShop> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.eq(SpmShop::getIsDel, SpmShopIsDelEnum.NOT_DELETED);
    SpmShopQueryVO voBean = spmShopMapper.joinSelectOne(wrapper, SpmShopQueryVO.class);
    return voBean;
  }

  /**
   * 店铺详情
   *
   * @param request 店铺实体
   * @return {@link SpmShop}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @Override
  public SpmShopQueryVO details(SpmShop request) throws Exception {
    JoinLambdaWrapper<SpmShop> wrapper = new JoinLambdaWrapper<>(request);
    wrapper.eq(SpmShop::getIsDel, SpmShopIsDelEnum.NOT_DELETED);
    SpmShopQueryVO voBean = spmShopMapper.joinSelectOne(wrapper, SpmShopQueryVO.class);
    return voBean;
  }

  /**
   * 删除店铺(支持批量)
   *
   * @param ids 店铺id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    int i = spmShopMapper.deleteBatchIds(idList);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑店铺
   *
   * @param request 店铺实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @Override
  public boolean edit(SpmShopEditDTO request) throws Exception {
    SpmShop po = new SpmShop();
    BeanUtilsPlus.copy(request, po);
    int i = spmShopMapper.updateById(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增店铺
   *
   * @param request 店铺实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @Override
  public boolean add(SpmShopAddDTO request) throws Exception {
    SpmShop po = new SpmShop();
    BeanUtilsPlus.copy(request, po);
    int i = spmShopMapper.insert(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }
}
