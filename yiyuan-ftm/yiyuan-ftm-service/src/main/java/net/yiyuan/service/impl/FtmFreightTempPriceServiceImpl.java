package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.FtmFreightTempPriceAddDTO;
import net.yiyuan.dto.FtmFreightTempPriceEditDTO;
import net.yiyuan.dto.FtmFreightTempPriceListDTO;
import net.yiyuan.dto.FtmFreightTempPricePageDTO;
import net.yiyuan.mapper.FtmFreightTempPriceMapper;
import net.yiyuan.model.FtmFreightTempPrice;
import net.yiyuan.service.FtmFreightTempPriceService;
import net.yiyuan.vo.FtmFreightTempPriceQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 物流模板价格Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-11-04
 */
@Slf4j
@Service
public class FtmFreightTempPriceServiceImpl
    extends JoinServiceImpl<FtmFreightTempPriceMapper, FtmFreightTempPrice>
    implements FtmFreightTempPriceService {
  @Resource private FtmFreightTempPriceMapper ftmFreightTempPriceMapper;

  /**
   * 物流模板价格列表(全部)
   *
   * @param request 物流模板价格实体
   * @return {@link List< FtmFreightTempPriceQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Override
  public List<FtmFreightTempPriceQueryVO> list(FtmFreightTempPriceListDTO request)
      throws Exception {

    FtmFreightTempPrice po = new FtmFreightTempPrice();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<FtmFreightTempPrice> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.orderByDesc(FtmFreightTempPrice::getSort);
    wrapper.orderByDesc(FtmFreightTempPrice::getCreateTime);
    List<FtmFreightTempPriceQueryVO> voList =
        ftmFreightTempPriceMapper.joinSelectList(wrapper, FtmFreightTempPriceQueryVO.class);

    return voList;
  }

  /**
   * 物流模板价格列表(分页)
   *
   * @param request 物流模板价格实体
   * @return {@link Page< FtmFreightTempPriceQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Override
  public Page<FtmFreightTempPriceQueryVO> page(FtmFreightTempPricePageDTO request)
      throws Exception {
    FtmFreightTempPrice po = new FtmFreightTempPrice();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<FtmFreightTempPrice> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.orderByDesc(FtmFreightTempPrice::getSort);
    wrapper.orderByDesc(FtmFreightTempPrice::getCreateTime);
    Page<FtmFreightTempPriceQueryVO> voPage =
        ftmFreightTempPriceMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            FtmFreightTempPriceQueryVO.class);
    return voPage;
  }

  /**
   * 物流模板价格详情
   *
   * @param id 物流模板价格id
   * @return {@link FtmFreightTempPriceQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Override
  public FtmFreightTempPriceQueryVO details(String id) throws Exception {
    FtmFreightTempPrice po = new FtmFreightTempPrice();
    po.setId(id);
    JoinLambdaWrapper<FtmFreightTempPrice> wrapper = new JoinLambdaWrapper<>(po);
    FtmFreightTempPriceQueryVO voBean =
        ftmFreightTempPriceMapper.joinSelectOne(wrapper, FtmFreightTempPriceQueryVO.class);
    return voBean;
  }

  /**
   * 物流模板价格详情
   *
   * @param request 物流模板价格实体
   * @return {@link FtmFreightTempPrice}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Override
  public FtmFreightTempPriceQueryVO details(FtmFreightTempPrice request) throws Exception {
    JoinLambdaWrapper<FtmFreightTempPrice> wrapper = new JoinLambdaWrapper<>(request);
    FtmFreightTempPriceQueryVO voBean =
        ftmFreightTempPriceMapper.joinSelectOne(wrapper, FtmFreightTempPriceQueryVO.class);
    return voBean;
  }

  /**
   * 删除物流模板价格(支持批量)
   *
   * @param ids 物流模板价格id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    int i = ftmFreightTempPriceMapper.deleteBatchIds(idList);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑物流模板价格
   *
   * @param request 物流模板价格实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Override
  public boolean edit(FtmFreightTempPriceEditDTO request) throws Exception {
    FtmFreightTempPrice po = new FtmFreightTempPrice();
    BeanUtilsPlus.copy(request, po);
    int i = ftmFreightTempPriceMapper.updateById(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增物流模板价格
   *
   * @param request 物流模板价格实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Override
  public boolean add(FtmFreightTempPriceAddDTO request) throws Exception {
    FtmFreightTempPrice po = new FtmFreightTempPrice();
    BeanUtilsPlus.copy(request, po);
    int i = ftmFreightTempPriceMapper.insert(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }
}
