package net.yiyuan.core.task.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.core.task.mapper.QrtzTriggersMapper;
import net.yiyuan.core.task.model.QrtzTriggers;
import net.yiyuan.core.task.service.QrtzTriggersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 触发器详细信息管理Service层接口实现
 *
 * @author 一源团队--花和尚
 * @date 2023-07-06
 */
@Slf4j
@Service
public class QrtzTriggersServiceImpl extends JoinServiceImpl<QrtzTriggersMapper, QrtzTriggers>
    implements QrtzTriggersService {
  @Resource private QrtzTriggersMapper qrtzTriggersMapper;

  /**
   * 触发器详细信息列表(全部)
   *
   * @param request 触发器详细信息实体
   * @return {@link List}
   * @author 一源团队--花和尚
   * @date 2023-07-06
   */
  @Override
  public List<QrtzTriggers> list(QrtzTriggers request) throws Exception {
    QrtzTriggers query = new QrtzTriggers();
    JoinLambdaWrapper<QrtzTriggers> wrapper = new JoinLambdaWrapper<>(request);
    return joinList(wrapper, QrtzTriggers.class);
  }

  /**
   * 触发器详细信息列表(分页)
   *
   * @param request 触发器详细信息实体
   * @return {@link Page}
   * @author 一源团队--花和尚
   * @date 2023-07-06
   */
  @Override
  public Page<QrtzTriggers> pages(QrtzTriggers request, Integer pageSize, Integer pageNum)
      throws Exception {
    QrtzTriggers query = new QrtzTriggers();
    JoinLambdaWrapper<QrtzTriggers> wrapper = new JoinLambdaWrapper<>(request);
    Page<QrtzTriggers> page = joinPage(new Page<>(pageNum, pageSize), wrapper, QrtzTriggers.class);
    return page;
  }

  /**
   * 触发器详细信息详情
   *
   * @param request 触发器详细信息实体
   * @return {@link QrtzTriggers}
   * @author 一源团队--花和尚
   * @date 2023-07-06
   */
  @Override
  public QrtzTriggers details(QrtzTriggers request) throws Exception {
    QrtzTriggers query = new QrtzTriggers();
    JoinLambdaWrapper<QrtzTriggers> wrapper = new JoinLambdaWrapper<>(request);
    wrapper.select(
        QrtzTriggers::getCalendarName,
        QrtzTriggers::getDescription,
        QrtzTriggers::getEndTime,
        QrtzTriggers::getJobGroup,
        QrtzTriggers::getStartTime,
        QrtzTriggers::getPrevFireTime,
        QrtzTriggers::getNextFireTime,
        QrtzTriggers::getTriggerState,
        QrtzTriggers::getTriggerState,
        QrtzTriggers::getJobGroup,
        QrtzTriggers::getJobName);
    return joinGetOne(wrapper, QrtzTriggers.class);
  }

  /**
   * 删除触发器详细信息表
   *
   * @param request 触发器详细信息实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-06
   */
  @Transactional
  @Override
  public boolean del(QrtzTriggers request) throws Exception {
    return removeById(request);
  }

  /**
   * 批量删除触发器详细信息表
   *
   * @param ids 逗号分割id
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-06
   */
  @Transactional
  @Override
  public boolean dels(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids.split(",")));
  }

  /**
   * 编辑触发器详细信息表
   *
   * @param request 触发器详细信息实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-06
   */
  @Transactional
  @Override
  public boolean edit(QrtzTriggers request) throws Exception {
    return updateById(request);
  }

  /**
   * 新增触发器详细信息表
   *
   * @param request 触发器详细信息实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-06
   */
  @Transactional
  @Override
  public boolean add(QrtzTriggers request) throws Exception {
    return save(request);
  }
}
