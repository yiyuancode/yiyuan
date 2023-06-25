package net.yiyuan.core.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import net.yiyuan.core.sys.mapper.SysTenantMapper;
import net.yiyuan.core.sys.model.SysTenant;
import net.yiyuan.core.sys.service.SysTenantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 租户管理Service层接口实现
 *
 * @author 一源团队--花和尚
 * @date 2023-06-24
 */
@Service
public class SysTenantServiceImpl extends JoinServiceImpl<SysTenantMapper, SysTenant>
    implements SysTenantService {
  private static final Logger LOGGER = LoggerFactory.getLogger(SysTenantServiceImpl.class);
  @Resource private SysTenantMapper sysTenantMapper;

  /**
   * 租户列表(全部)
   *
   * @param request 租户实体
   * @return {@link List}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  @Override
  public List<SysTenant> list(SysTenant request) throws Exception {
    SysTenant query = new SysTenant();
    JoinLambdaWrapper<SysTenant> wrapper = new JoinLambdaWrapper<>(request);
    return joinList(wrapper, SysTenant.class);
  }

  /**
   * 租户列表(分页)
   *
   * @param request 租户实体
   * @return {@link Page}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  @Override
  public Page<SysTenant> pages(SysTenant request, Integer pageSize, Integer pageNum)
      throws Exception {
    SysTenant query = new SysTenant();
    JoinLambdaWrapper<SysTenant> wrapper = new JoinLambdaWrapper<>(request);
    wrapper.orderByDesc(SysTenant::getCreatedTime);

    Page<SysTenant> page = joinPage(new Page<>(pageNum, pageSize), wrapper, SysTenant.class);
    return page;
  }

  /**
   * 租户详情
   *
   * @param request 租户实体
   * @return {@link SysTenant}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  @Override
  public SysTenant details(SysTenant request) throws Exception {
    SysTenant query = new SysTenant();
    JoinLambdaWrapper<SysTenant> wrapper = new JoinLambdaWrapper<>(request);
    return joinGetOne(wrapper, SysTenant.class);
  }

  /**
   * 删除租户表
   *
   * @param request 租户实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  @Transactional
  @Override
  public boolean del(SysTenant request) throws Exception {
    SysTenant query = new SysTenant();
    return removeById(request);
  }

  /**
   * 批量删除租户表
   *
   * @param ids 逗号分割id
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  @Transactional
  @Override
  public boolean dels(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids));
  }

  /**
   * 编辑租户表
   *
   * @param request 租户实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  @Transactional
  @Override
  public boolean edit(SysTenant request) throws Exception {
    SysTenant query = new SysTenant();
    request.setUpdatedTime(new Date());
    return updateById(request);
  }

  /**
   * 新增租户表
   *
   * @param request 租户实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  @Transactional
  @Override
  public boolean add(SysTenant request) throws Exception {
    request.setCreatedTime(new Date());
    request.setUpdatedTime(new Date());
    return save(request);
  }
}
