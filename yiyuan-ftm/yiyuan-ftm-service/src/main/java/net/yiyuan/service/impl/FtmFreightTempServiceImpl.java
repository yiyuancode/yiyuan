package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.common.utils.StringUtilsPlus;
import net.yiyuan.dto.*;
import net.yiyuan.enums.FtmFreightTempPackageTypeEnum;
import net.yiyuan.mapper.FtmFreightTempMapper;
import net.yiyuan.mapper.FtmFreightTempPriceMapper;
import net.yiyuan.model.FtmFreightTemp;
import net.yiyuan.model.FtmFreightTempPrice;
import net.yiyuan.service.FtmFreightTempService;
import net.yiyuan.vo.FtmFreightTempPriceQueryVO;
import net.yiyuan.vo.FtmFreightTempQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 物流模板Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-11-04
 */
@Slf4j
@Service
public class FtmFreightTempServiceImpl extends JoinServiceImpl<FtmFreightTempMapper, FtmFreightTemp>
    implements FtmFreightTempService {
  @Resource private FtmFreightTempMapper ftmFreightTempMapper;
  @Resource private FtmFreightTempPriceMapper ftmFreightTempPriceMapper;

  /**
   * 物流模板列表(全部)
   *
   * @param request 物流模板实体
   * @return {@link List< FtmFreightTempQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Override
  public List<FtmFreightTempQueryVO> list(FtmFreightTempListDTO request) throws Exception {

    FtmFreightTemp po = new FtmFreightTemp();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<FtmFreightTemp> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.orderByDesc(FtmFreightTemp::getSort);
    wrapper.orderByDesc(FtmFreightTemp::getCreateTime);
    List<FtmFreightTempQueryVO> voList =
        ftmFreightTempMapper.joinSelectList(wrapper, FtmFreightTempQueryVO.class);

    return voList;
  }

  /**
   * 物流模板列表(分页)
   *
   * @param request 物流模板实体
   * @return {@link Page< FtmFreightTempQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Override
  public Page<FtmFreightTempQueryVO> page(FtmFreightTempPageDTO request) throws Exception {
    FtmFreightTemp po = new FtmFreightTemp();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<FtmFreightTemp> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.orderByDesc(FtmFreightTemp::getSort);
    wrapper.orderByDesc(FtmFreightTemp::getCreateTime);
    Page<FtmFreightTempQueryVO> voPage =
        ftmFreightTempMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            FtmFreightTempQueryVO.class);
    return voPage;
  }

  /**
   * 物流模板详情
   *
   * @param id 物流模板id
   * @return {@link FtmFreightTempQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Override
  public FtmFreightTempQueryVO details(String id) throws Exception {
    FtmFreightTemp po = new FtmFreightTemp();
    po.setId(id);
    JoinLambdaWrapper<FtmFreightTemp> wrapper = new JoinLambdaWrapper<>(po);
    wrapper
        .leftJoin(
            FtmFreightTempPrice.class,
            FtmFreightTempPrice::getFtmFreightTempId,
            FtmFreightTemp::getId)
        .manyToManySelect(FtmFreightTempQueryVO::getPriceList, FtmFreightTempPriceQueryVO.class)
        .end();
    FtmFreightTempQueryVO voBean =
        ftmFreightTempMapper.joinSelectOne(wrapper, FtmFreightTempQueryVO.class);
    return voBean;
  }

  /**
   * 物流模板详情
   *
   * @param request 物流模板实体
   * @return {@link FtmFreightTemp}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Override
  public FtmFreightTempQueryVO details(FtmFreightTemp request) throws Exception {
    JoinLambdaWrapper<FtmFreightTemp> wrapper = new JoinLambdaWrapper<>(request);
    FtmFreightTempQueryVO voBean =
        ftmFreightTempMapper.joinSelectOne(wrapper, FtmFreightTempQueryVO.class);
    return voBean;
  }

  /**
   * 删除物流模板(支持批量)
   *
   * @param ids 物流模板id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    int i = ftmFreightTempMapper.deleteBatchIds(idList);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑物流模板
   *
   * @param request 物流模板实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Override
  public boolean edit(FtmFreightTempEditDTO request) throws Exception {
    FtmFreightTemp po = new FtmFreightTemp();
    BeanUtilsPlus.copy(request, po);
    int i = ftmFreightTempMapper.updateById(po);
    if (FtmFreightTempPackageTypeEnum.PARTIAL_PACKAGE_SHIPPING.equals(request.getPackageType())) {
      List<FtmFreightTempPriceEditDTO> priceList = request.getPriceList();
      if (StringUtilsPlus.isEmpty(priceList)) {
        throw new BusinessException("部分包邮方式下运费集合不能为空");
      }
      // 修改
      priceList.forEach(
          (item) -> {
            FtmFreightTempPrice pricePo = new FtmFreightTempPrice();
            BeanUtilsPlus.copy(item, pricePo);
            ftmFreightTempPriceMapper.updateById(pricePo);
          });
    }

    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增物流模板
   *
   * @param request 物流模板实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Override
  public boolean add(FtmFreightTempAddDTO request) throws Exception {
    FtmFreightTemp po = new FtmFreightTemp();
    BeanUtilsPlus.copy(request, po);
    int i = ftmFreightTempMapper.insert(po);
    // 部分包邮逻辑，全部包邮不操作运费表
    if (FtmFreightTempPackageTypeEnum.PARTIAL_PACKAGE_SHIPPING.equals(request.getPackageType())) {
      List<FtmFreightTempPriceAddDTO> priceList = request.getPriceList();
      if (StringUtilsPlus.isEmpty(priceList)) {
        throw new BusinessException("部分包邮方式下运费集合不能为空");
      }
      // 插入运费集合
      priceList.forEach(
          (item) -> {
            FtmFreightTempPrice pricePo = new FtmFreightTempPrice();
            BeanUtilsPlus.copy(item, pricePo);
            pricePo.setFtmFreightTempId(po.getId());
            ftmFreightTempPriceMapper.insert(pricePo);
          });
    }
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }
}
