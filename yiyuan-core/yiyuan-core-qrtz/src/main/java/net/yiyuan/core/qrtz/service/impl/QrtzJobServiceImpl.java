package net.yiyuan.core.qrtz.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.constatnt.ResultCode;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.common.utils.StringUtilsPlus;
import net.yiyuan.core.qrtz.dto.QrtzJobAddDTO;
import net.yiyuan.core.qrtz.dto.QrtzJobEditDTO;
import net.yiyuan.core.qrtz.dto.QrtzJobListDTO;
import net.yiyuan.core.qrtz.dto.QrtzJobPageDTO;
import net.yiyuan.core.qrtz.mapper.QrtzJobMapper;
import net.yiyuan.core.qrtz.model.QrtzJob;
import net.yiyuan.core.qrtz.service.QrtzJobService;
import net.yiyuan.core.qrtz.utils.JobUtil;
import net.yiyuan.core.qrtz.vo.QrtzJobQueryVO;
import org.quartz.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 定时任务管理管理Service层接口实现
 *
 * @author 一源团队--花和尚
 * @date 2023-07-28
 */
@Slf4j
@Service
public class QrtzJobServiceImpl extends JoinServiceImpl<QrtzJobMapper, QrtzJob>
    implements QrtzJobService {
  @Resource private QrtzJobMapper qrtzJobMapper;
  @Resource private Scheduler scheduler;
  /**
   * 定时任务管理列表(全部)
   *
   * @param request 定时任务管理实体
   * @return {@link List< QrtzJobQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Override
  public List<QrtzJobQueryVO> list(QrtzJobListDTO request) throws Exception {

    QrtzJob po = new QrtzJob();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<QrtzJob> wrapper = new JoinLambdaWrapper<>(po);
    List<QrtzJobQueryVO> voList = joinList(wrapper, QrtzJobQueryVO.class);

    return voList;
  }

  /**
   * 定时任务管理列表(分页)
   *
   * @param request 定时任务管理实体
   * @return {@link Page< QrtzJobQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Override
  public Page<QrtzJobQueryVO> page(QrtzJobPageDTO request) throws Exception {
    QrtzJob po = new QrtzJob();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<QrtzJob> wrapper = new JoinLambdaWrapper<>(po);
    Page<QrtzJobQueryVO> voPage =
        joinPage(
            new Page<>(request.getPageNum(), request.getPageSize()), wrapper, QrtzJobQueryVO.class);
    return voPage;
  }

  /**
   * 定时任务管理详情
   *
   * @param id 定时任务管理id
   * @return {@link QrtzJobQueryVO}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Override
  public QrtzJobQueryVO details(String id) throws Exception {
    QrtzJob po = new QrtzJob();
    po.setId(id);
    JoinLambdaWrapper<QrtzJob> wrapper = new JoinLambdaWrapper<>(po);
    QrtzJobQueryVO voBean = joinGetOne(wrapper, QrtzJobQueryVO.class);
    return voBean;
  }

  /**
   * 定时任务管理详情
   *
   * @param request 定时任务管理实体
   * @return {@link QrtzJob}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Override
  public QrtzJobQueryVO details(QrtzJob request) throws Exception {

    JoinLambdaWrapper<QrtzJob> wrapper = new JoinLambdaWrapper<>(request);
    QrtzJobQueryVO voBean = joinGetOne(wrapper, QrtzJobQueryVO.class);
    return voBean;
  }

  /**
   * 删除定时任务管理(支持批量)
   *
   * @param ids 定时任务管理id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Override
  public boolean delete(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids.split(",")));
  }

  /**
   * 批量删除定时任务管理(根据同一属性,针对中间表)
   *
   * @param request 定时任务管理实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Override
  public boolean delete(QrtzJob request) throws Exception {
    JoinLambdaWrapper<QrtzJob> wrapper = new JoinLambdaWrapper<>(request);
    return remove(wrapper);
  }

  /**
   * 编辑定时任务管理
   *
   * @param request 定时任务管理实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Override
  public boolean edit(QrtzJobEditDTO request) throws Exception {
    QrtzJob po = new QrtzJob();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<QrtzJob> wrapper = new JoinLambdaWrapper<>(po);
    return updateById(po);
  }

  /**
   * 新增定时任务管理
   *
   * @param request 定时任务管理实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Override
  public boolean add(QrtzJobAddDTO request) throws Exception {
    // 通过任务组名和任务名称联合查询任务，如果已存在不允许重复添加
    QrtzJob po = new QrtzJob();
    po.setJobClassName(request.getJobClassName());
    po.setJobGroup(request.getJobGroup());
    QrtzJobQueryVO details = details(po);
    if (StringUtilsPlus.isNotNUll(details)) {
      throw new BusinessException(ResultCode.JOB_EXISTS);
    }
    BeanUtilsPlus.copy(request, po);
    // 构建Job信息
    JobDetail jobDetail =
        JobBuilder.newJob(JobUtil.getClass(request.getJobName()).getClass())
            .withIdentity(request.getJobName(), request.getJobGroup())
            .build();

    // Cron表达式调度构建器(即任务执行的时间)
    CronScheduleBuilder cron = CronScheduleBuilder.cronSchedule(request.getJobCronExpression());
    // 根据Cron表达式构建一个Trigger
    TriggerBuilder<CronTrigger> cronTriggerTriggerBuilder =
        TriggerBuilder.newTrigger()
            .withIdentity(request.getJobName(), request.getJobGroup())
            .withSchedule(cron);
    // 时间不为空设置开始时间和结束时间
    if (StringUtilsPlus.isNotNUll(request.getStartTime())) {
      cronTriggerTriggerBuilder.startAt(request.getStartTime());
    }
    if (StringUtilsPlus.isNotNUll(request.getStartTime())) {
      cronTriggerTriggerBuilder.endAt(request.getEndTime());
    }
    CronTrigger trigger = cronTriggerTriggerBuilder.build();
    scheduler.scheduleJob(jobDetail, trigger);
    // 插入定时任务管理表
    return save(po);
  }
}
