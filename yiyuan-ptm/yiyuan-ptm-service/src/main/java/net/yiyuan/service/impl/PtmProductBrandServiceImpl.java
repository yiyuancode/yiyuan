package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.PtmProductBrandAddDTO;
import net.yiyuan.dto.PtmProductBrandEditDTO;
import net.yiyuan.dto.PtmProductBrandListDTO;
import net.yiyuan.dto.PtmProductBrandPageDTO;
import net.yiyuan.mapper.PtmProductBrandMapper;
import net.yiyuan.model.PtmProductBrand;
import net.yiyuan.service.PtmProductBrandService;
import net.yiyuan.vo.PtmProductBrandQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    PtmProductBrandQueryVO voBean =
        ptmProductBrandMapper.joinSelectOne(wrapper, PtmProductBrandQueryVO.class);
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
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }
}
