package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.SysTenantTypeAddDTO;
import net.yiyuan.dto.SysTenantTypeEditDTO;
import net.yiyuan.dto.SysTenantTypeListDTO;
import net.yiyuan.dto.SysTenantTypePageDTO;
import net.yiyuan.mapper.SysTenantTypeMapper;
import net.yiyuan.model.SysTenantType;
import net.yiyuan.service.SysTenantTypeService;
import net.yiyuan.vo.SysTenantTypeQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 租户类型Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
@Slf4j
@Service
public class SysTenantTypeServiceImpl extends JoinServiceImpl<SysTenantTypeMapper, SysTenantType>
    implements SysTenantTypeService {
  @Resource private SysTenantTypeMapper sysTenantTypeMapper;

  /**
   * 租户类型列表(全部)
   *
   * @param request 租户类型实体
   * @return {@link List< SysTenantTypeQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Override
  public List<SysTenantTypeQueryVO> list(SysTenantTypeListDTO request) throws Exception {

    SysTenantType po = new SysTenantType();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysTenantType> wrapper = new JoinLambdaWrapper<>(po);
    List<SysTenantTypeQueryVO> voList = joinList(wrapper, SysTenantTypeQueryVO.class);

    return voList;
  }

  /**
   * 租户类型列表(分页)
   *
   * @param request 租户类型实体
   * @return {@link Page< SysTenantTypeQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Override
  public Page<SysTenantTypeQueryVO> page(SysTenantTypePageDTO request) throws Exception {
    SysTenantType po = new SysTenantType();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysTenantType> wrapper = new JoinLambdaWrapper<>(po);
    Page<SysTenantTypeQueryVO> voPage =
        joinPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            SysTenantTypeQueryVO.class);
    return voPage;
  }

  /**
   * 租户类型详情
   *
   * @param id 租户类型id
   * @return {@link SysTenantTypeQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Override
  public SysTenantTypeQueryVO details(String id) throws Exception {
    SysTenantType po = new SysTenantType();
    po.setId(id);
    JoinLambdaWrapper<SysTenantType> wrapper = new JoinLambdaWrapper<>(po);
    SysTenantTypeQueryVO voBean = joinGetOne(wrapper, SysTenantTypeQueryVO.class);
    return voBean;
  }

  /**
   * 租户类型详情
   *
   * @param request 租户类型实体
   * @return {@link SysTenantType}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Override
  public SysTenantTypeQueryVO details(SysTenantType request) throws Exception {

    JoinLambdaWrapper<SysTenantType> wrapper = new JoinLambdaWrapper<>(request);
    SysTenantTypeQueryVO voBean = joinGetOne(wrapper, SysTenantTypeQueryVO.class);
    return voBean;
  }

  /**
   * 删除租户类型(支持批量)
   *
   * @param ids 租户类型id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Override
  public boolean delete(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids.split(",")));
  }

  /**
   * 编辑租户类型
   *
   * @param request 租户类型实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Override
  public boolean edit(SysTenantTypeEditDTO request) throws Exception {
    SysTenantType po = new SysTenantType();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysTenantType> wrapper = new JoinLambdaWrapper<>(po);
    return updateById(po);
  }

  /**
   * 新增租户类型
   *
   * @param request 租户类型实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Override
  public boolean add(SysTenantTypeAddDTO request) throws Exception {
    SysTenantType po = new SysTenantType();
    BeanUtilsPlus.copy(request, po);
    return save(po);
  }
}
