package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.PtmProductAddDTO;
import net.yiyuan.dto.PtmProductEditDTO;
import net.yiyuan.dto.PtmProductListDTO;
import net.yiyuan.dto.PtmProductPageDTO;
import net.yiyuan.mapper.PtmProductMapper;
import net.yiyuan.model.PtmProduct;
import net.yiyuan.service.PtmProductService;
import net.yiyuan.vo.PtmProductQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 商品信息Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-10-06
 */
@Slf4j
@Service
public class PtmProductServiceImpl extends JoinServiceImpl<PtmProductMapper, PtmProduct>
    implements PtmProductService {
  @Resource private PtmProductMapper ptmProductMapper;

  /**
   * 商品信息列表(全部)
   *
   * @param request 商品信息实体
   * @return {@link List< PtmProductQueryVO >}
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @Override
  public List<PtmProductQueryVO> list(PtmProductListDTO request) throws Exception {

    PtmProduct po = new PtmProduct();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<PtmProduct> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.orderByDesc(PtmProduct::getSort);
    wrapper.orderByDesc(PtmProduct::getCreateTime);
    List<PtmProductQueryVO> voList =
        ptmProductMapper.joinSelectList(wrapper, PtmProductQueryVO.class);

    return voList;
  }

  /**
   * 商品信息列表(分页)
   *
   * @param request 商品信息实体
   * @return {@link Page< PtmProductQueryVO >}
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @Override
  public Page<PtmProductQueryVO> page(PtmProductPageDTO request) throws Exception {
    PtmProduct po = new PtmProduct();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<PtmProduct> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.orderByDesc(PtmProduct::getSort);
    wrapper.orderByDesc(PtmProduct::getCreateTime);
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
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @Override
  public PtmProductQueryVO details(String id) throws Exception {
    PtmProduct po = new PtmProduct();
    po.setId(id);
    JoinLambdaWrapper<PtmProduct> wrapper = new JoinLambdaWrapper<>(po);
    PtmProductQueryVO voBean = ptmProductMapper.joinSelectOne(wrapper, PtmProductQueryVO.class);
    return voBean;
  }

  /**
   * 商品信息详情
   *
   * @param request 商品信息实体
   * @return {@link PtmProduct}
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @Override
  public PtmProductQueryVO details(PtmProduct request) throws Exception {
    JoinLambdaWrapper<PtmProduct> wrapper = new JoinLambdaWrapper<>(request);
    PtmProductQueryVO voBean = ptmProductMapper.joinSelectOne(wrapper, PtmProductQueryVO.class);
    return voBean;
  }

  /**
   * 删除商品信息(支持批量)
   *
   * @param ids 商品信息id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-10-06
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
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @Override
  public boolean edit(PtmProductEditDTO request) throws Exception {
    PtmProduct po = new PtmProduct();
    BeanUtilsPlus.copy(request, po);
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
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  @Override
  public boolean add(PtmProductAddDTO request) throws Exception {
    PtmProduct po = new PtmProduct();
    BeanUtilsPlus.copy(request, po);
    int i = ptmProductMapper.insert(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }
}
