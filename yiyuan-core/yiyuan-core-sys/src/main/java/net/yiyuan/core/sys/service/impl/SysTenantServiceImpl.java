package net.yiyuan.core.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.core.sys.dto.SysTenantAddDTO;
import net.yiyuan.core.sys.dto.SysTenantEditDTO;
import net.yiyuan.core.sys.dto.SysTenantListDTO;
import net.yiyuan.core.sys.dto.SysTenantPageDTO;
import net.yiyuan.core.sys.mapper.SysTenantMapper;
import net.yiyuan.core.sys.model.SysTenant;
import net.yiyuan.core.sys.service.SysTenantService;
import net.yiyuan.core.sys.vo.SysTenantQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 租户管理Service层接口实现
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Slf4j
@Service
public class SysTenantServiceImpl extends JoinServiceImpl<SysTenantMapper, SysTenant>
    implements SysTenantService {
  @Resource private SysTenantMapper sysTenantMapper;

  /**
   * 租户列表(全部)
   *
   * @param request 租户实体
   * @return {@link List< SysTenantQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public List<SysTenantQueryVO> list(SysTenantListDTO request) throws Exception {

    SysTenant po = new SysTenant();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysTenant> wrapper = new JoinLambdaWrapper<>(po);
    List<SysTenantQueryVO> voList = joinList(wrapper, SysTenantQueryVO.class);

    return voList;
  }

  /**
   * 租户列表(分页)
   *
   * @param request 租户实体
   * @return {@link Page< SysTenantQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public Page<SysTenantQueryVO> page(SysTenantPageDTO request) throws Exception {
    SysTenant po = new SysTenant();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysTenant> wrapper = new JoinLambdaWrapper<>(po);
    Page<SysTenantQueryVO> voPage =
        joinPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            SysTenantQueryVO.class);
    return voPage;
  }

  /**
   * 租户详情
   *
   * @param id 租户id
   * @return {@link SysTenantQueryVO}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public SysTenantQueryVO details(String id) throws Exception {
    SysTenant po = new SysTenant();
    po.setId(id);
    JoinLambdaWrapper<SysTenant> wrapper = new JoinLambdaWrapper<>(po);
    SysTenantQueryVO voBean = joinGetOne(wrapper, SysTenantQueryVO.class);
    return voBean;
  }

  /**
   * 租户详情
   *
   * @param request 租户实体
   * @return {@link SysTenant}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public SysTenantQueryVO details(SysTenant request) throws Exception {

    JoinLambdaWrapper<SysTenant> wrapper = new JoinLambdaWrapper<>(request);
    SysTenantQueryVO voBean = joinGetOne(wrapper, SysTenantQueryVO.class);
    return voBean;
  }

  /**
   * 删除租户(支持批量)
   *
   * @param ids 租户id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public boolean delete(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids.split(",")));
  }

  /**
   * 批量删除租户(根据同一属性,针对中间表)
   *
   * @param request 租户实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public boolean delete(SysTenant request) throws Exception {
    JoinLambdaWrapper<SysTenant> wrapper = new JoinLambdaWrapper<>(request);
    return remove(wrapper);
  }

  /**
   * 编辑租户
   *
   * @param request 租户实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public boolean edit(SysTenantEditDTO request) throws Exception {
    SysTenant po = new SysTenant();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysTenant> wrapper = new JoinLambdaWrapper<>(po);
    return updateById(po);
  }

  /**
   * 新增租户
   *
   * @param request 租户实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public boolean add(SysTenantAddDTO request) throws Exception {
    SysTenant po = new SysTenant();
    BeanUtilsPlus.copy(request, po);
    return save(po);
  }
}
