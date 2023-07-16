package net.yiyuan.core.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.core.sys.mapper.SysHostMapper;
import net.yiyuan.core.sys.model.SysHost;
import net.yiyuan.core.sys.service.SysHostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 主机记录管理Service层接口实现
 *
 * @author 一源团队--花和尚
 * @date 2023-07-16
 */
@Slf4j
@Service
public class SysHostServiceImpl extends JoinServiceImpl<SysHostMapper, SysHost>
    implements SysHostService {
  @Resource private SysHostMapper sysHostMapper;

  /**
   * 主机记录列表(全部)
   *
   * @param request 主机记录实体
   * @return {@link List}
   * @author 一源团队--花和尚
   * @date 2023-07-16
   */
  @Override
  public List<SysHost> list(SysHost request) throws Exception {
    JoinLambdaWrapper<SysHost> wrapper = new JoinLambdaWrapper<>(request);
    return joinList(wrapper, SysHost.class);
  }

  /**
   * 主机记录列表(分页)
   *
   * @param request 主机记录实体
   * @return {@link Page}
   * @author 一源团队--花和尚
   * @date 2023-07-16
   */
  @Override
  public Page<SysHost> pages(SysHost request, Integer pageSize, Integer pageNum) throws Exception {
    JoinLambdaWrapper<SysHost> wrapper = new JoinLambdaWrapper<>(request);
    Page<SysHost> page = joinPage(new Page<>(pageNum, pageSize), wrapper, SysHost.class);
    return page;
  }

  /**
   * 主机记录详情
   *
   * @param id 主机记录id
   * @return {@link SysHost}
   * @author 一源团队--花和尚
   * @date 2023-07-16
   */
  @Override
  public SysHost details(String id) throws Exception {
    SysHost query = new SysHost();
    query.setId(id);
    JoinLambdaWrapper<SysHost> wrapper = new JoinLambdaWrapper<>(query);
    return joinGetOne(wrapper, SysHost.class);
  }

  /**
   * 主机记录详情
   *
   * @param request 主机记录实体
   * @return {@link SysHost}
   * @author 一源团队--花和尚
   * @date 2023-07-16
   */
  @Override
  public SysHost details(SysHost request) throws Exception {
    JoinLambdaWrapper<SysHost> wrapper = new JoinLambdaWrapper<>(request);
    return joinGetOne(wrapper, SysHost.class);
  }

  /**
   * 删除主机记录(支持批量)
   *
   * @param ids 主机记录id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-16
   */
  @Override
  public boolean delete(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids.split(",")));
  }

  /**
   * 批量删除主机记录表(根据同一属性,针对中间表)
   *
   * @param request 主机记录实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-16
   */
  @Override
  public boolean delete(SysHost request) throws Exception {
    JoinLambdaWrapper<SysHost> wrapper = new JoinLambdaWrapper<>(request);
    return remove(wrapper);
  }

  /**
   * 编辑主机记录表
   *
   * @param request 主机记录实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-16
   */
  @Override
  public boolean edit(SysHost request) throws Exception {
    return updateById(request);
  }

  /**
   * 新增主机记录表
   *
   * @param request 主机记录实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-16
   */
  @Override
  public boolean add(SysHost request) throws Exception {
    return save(request);
  }
}
