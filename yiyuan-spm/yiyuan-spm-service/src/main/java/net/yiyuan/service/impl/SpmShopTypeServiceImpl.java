package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.SpmShopTypeAddDTO;
import net.yiyuan.dto.SpmShopTypeEditDTO;
import net.yiyuan.dto.SpmShopTypeListDTO;
import net.yiyuan.dto.SpmShopTypePageDTO;
import net.yiyuan.enums.SpmShopTypeIsDelEnum;
import net.yiyuan.mapper.SpmShopTypeMapper;
import net.yiyuan.model.SpmShopType;
import net.yiyuan.service.SpmShopTypeService;
import net.yiyuan.vo.SpmShopTypeQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 店铺类型Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-22
 */
@Slf4j
@Service
public class SpmShopTypeServiceImpl extends JoinServiceImpl<SpmShopTypeMapper, SpmShopType>
    implements SpmShopTypeService {
  @Resource private SpmShopTypeMapper spmShopTypeMapper;

  /**
   * 店铺类型列表(全部)
   *
   * @param request 店铺类型实体
   * @return {@link List< SpmShopTypeQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @Override
  public List<SpmShopTypeQueryVO> list(SpmShopTypeListDTO request) throws Exception {

    SpmShopType po = new SpmShopType();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SpmShopType> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.eq(SpmShopType::getIsDel, SpmShopTypeIsDelEnum.NOT_DELETED);
    wrapper.orderByDesc(SpmShopType::getSort);
    wrapper.orderByDesc(SpmShopType::getCreateTime);
    List<SpmShopTypeQueryVO> voList =
        spmShopTypeMapper.joinSelectList(wrapper, SpmShopTypeQueryVO.class);

    return voList;
  }

  /**
   * 店铺类型列表(分页)
   *
   * @param request 店铺类型实体
   * @return {@link Page< SpmShopTypeQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @Override
  public Page<SpmShopTypeQueryVO> page(SpmShopTypePageDTO request) throws Exception {
    SpmShopType po = new SpmShopType();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SpmShopType> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.eq(SpmShopType::getIsDel, SpmShopTypeIsDelEnum.NOT_DELETED);
    wrapper.orderByDesc(SpmShopType::getSort);
    wrapper.orderByDesc(SpmShopType::getCreateTime);
    Page<SpmShopTypeQueryVO> voPage =
        spmShopTypeMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            SpmShopTypeQueryVO.class);
    return voPage;
  }

  /**
   * 店铺类型详情
   *
   * @param id 店铺类型id
   * @return {@link SpmShopTypeQueryVO}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @Override
  public SpmShopTypeQueryVO details(String id) throws Exception {
    SpmShopType po = new SpmShopType();
    po.setId(id);
    JoinLambdaWrapper<SpmShopType> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.eq(SpmShopType::getIsDel, SpmShopTypeIsDelEnum.NOT_DELETED);
    SpmShopTypeQueryVO voBean = spmShopTypeMapper.joinSelectOne(wrapper, SpmShopTypeQueryVO.class);
    return voBean;
  }

  /**
   * 店铺类型详情
   *
   * @param request 店铺类型实体
   * @return {@link SpmShopType}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @Override
  public SpmShopTypeQueryVO details(SpmShopType request) throws Exception {
    JoinLambdaWrapper<SpmShopType> wrapper = new JoinLambdaWrapper<>(request);
    wrapper.eq(SpmShopType::getIsDel, SpmShopTypeIsDelEnum.NOT_DELETED);
    SpmShopTypeQueryVO voBean = spmShopTypeMapper.joinSelectOne(wrapper, SpmShopTypeQueryVO.class);
    return voBean;
  }

  /**
   * 删除店铺类型(支持批量)
   *
   * @param ids 店铺类型id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    int i = spmShopTypeMapper.deleteBatchIds(idList);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑店铺类型
   *
   * @param request 店铺类型实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @Override
  public boolean edit(SpmShopTypeEditDTO request) throws Exception {
    SpmShopType po = new SpmShopType();
    BeanUtilsPlus.copy(request, po);
    int i = spmShopTypeMapper.updateById(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增店铺类型
   *
   * @param request 店铺类型实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  @Override
  public boolean add(SpmShopTypeAddDTO request) throws Exception {
    SpmShopType po = new SpmShopType();
    BeanUtilsPlus.copy(request, po);
    int i = spmShopTypeMapper.insert(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }
}
