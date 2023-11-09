package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.PtmProductGuaranteeAddDTO;
import net.yiyuan.dto.PtmProductGuaranteeEditDTO;
import net.yiyuan.dto.PtmProductGuaranteeListDTO;
import net.yiyuan.dto.PtmProductGuaranteePageDTO;
import net.yiyuan.mapper.PtmProductGuaranteeMapper;
import net.yiyuan.model.PtmProductGuarantee;
import net.yiyuan.service.PtmProductGuaranteeService;
import net.yiyuan.vo.PtmProductGuaranteeQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 保障服务Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-11-09
 */
@Slf4j
@Service
public class PtmProductGuaranteeServiceImpl
    extends JoinServiceImpl<PtmProductGuaranteeMapper, PtmProductGuarantee>
    implements PtmProductGuaranteeService {
  @Resource private PtmProductGuaranteeMapper ptmProductGuaranteeMapper;

  /**
   * 保障服务列表(全部)
   *
   * @param request 保障服务实体
   * @return {@link List< PtmProductGuaranteeQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  @Override
  public List<PtmProductGuaranteeQueryVO> list(PtmProductGuaranteeListDTO request)
      throws Exception {

    PtmProductGuarantee po = new PtmProductGuarantee();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<PtmProductGuarantee> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.orderByDesc(PtmProductGuarantee::getSort);
    wrapper.orderByDesc(PtmProductGuarantee::getCreateTime);
    List<PtmProductGuaranteeQueryVO> voList =
        ptmProductGuaranteeMapper.joinSelectList(wrapper, PtmProductGuaranteeQueryVO.class);

    return voList;
  }

  /**
   * 保障服务列表(分页)
   *
   * @param request 保障服务实体
   * @return {@link Page< PtmProductGuaranteeQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  @Override
  public Page<PtmProductGuaranteeQueryVO> page(PtmProductGuaranteePageDTO request)
      throws Exception {
    PtmProductGuarantee po = new PtmProductGuarantee();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<PtmProductGuarantee> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.orderByDesc(PtmProductGuarantee::getSort);
    wrapper.orderByDesc(PtmProductGuarantee::getCreateTime);
    Page<PtmProductGuaranteeQueryVO> voPage =
        ptmProductGuaranteeMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            PtmProductGuaranteeQueryVO.class);
    return voPage;
  }

  /**
   * 保障服务详情
   *
   * @param id 保障服务id
   * @return {@link PtmProductGuaranteeQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  @Override
  public PtmProductGuaranteeQueryVO details(String id) throws Exception {
    PtmProductGuarantee po = new PtmProductGuarantee();
    po.setId(id);
    JoinLambdaWrapper<PtmProductGuarantee> wrapper = new JoinLambdaWrapper<>(po);
    PtmProductGuaranteeQueryVO voBean =
        ptmProductGuaranteeMapper.joinSelectOne(wrapper, PtmProductGuaranteeQueryVO.class);
    return voBean;
  }

  /**
   * 保障服务详情
   *
   * @param request 保障服务实体
   * @return {@link PtmProductGuarantee}
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  @Override
  public PtmProductGuaranteeQueryVO details(PtmProductGuarantee request) throws Exception {
    JoinLambdaWrapper<PtmProductGuarantee> wrapper = new JoinLambdaWrapper<>(request);
    PtmProductGuaranteeQueryVO voBean =
        ptmProductGuaranteeMapper.joinSelectOne(wrapper, PtmProductGuaranteeQueryVO.class);
    return voBean;
  }

  /**
   * 删除保障服务(支持批量)
   *
   * @param ids 保障服务id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    int i = ptmProductGuaranteeMapper.deleteBatchIds(idList);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑保障服务
   *
   * @param request 保障服务实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  @Override
  public boolean edit(PtmProductGuaranteeEditDTO request) throws Exception {
    PtmProductGuarantee po = new PtmProductGuarantee();
    BeanUtilsPlus.copy(request, po);
    int i = ptmProductGuaranteeMapper.updateById(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增保障服务
   *
   * @param request 保障服务实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  @Override
  public boolean add(PtmProductGuaranteeAddDTO request) throws Exception {
    PtmProductGuarantee po = new PtmProductGuarantee();
    BeanUtilsPlus.copy(request, po);
    int i = ptmProductGuaranteeMapper.insert(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }
}
