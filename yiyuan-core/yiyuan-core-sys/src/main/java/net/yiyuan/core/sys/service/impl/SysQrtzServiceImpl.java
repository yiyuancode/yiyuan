package net.yiyuan.core.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.constatnt.ResultCode;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.common.utils.StringUtilsPlus;
import net.yiyuan.core.sys.dto.SysQrtzAddDTO;
import net.yiyuan.core.sys.dto.SysQrtzEditDTO;
import net.yiyuan.core.sys.dto.SysQrtzListDTO;
import net.yiyuan.core.sys.dto.SysQrtzPageDTO;
import net.yiyuan.core.sys.enums.SysQrtzJobStatusEnum;
import net.yiyuan.core.sys.mapper.SysQrtzMapper;
import net.yiyuan.core.sys.model.SysQrtz;
import net.yiyuan.core.sys.service.SysQrtzService;
import net.yiyuan.core.sys.utils.JobUtil;
import net.yiyuan.core.sys.vo.SysQrtzQueryVO;
import org.quartz.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 定时任务管理Service层接口实现
 *
 * @author 一源团队--花和尚
 * @date 2023-07-28
 */
@Slf4j
@Service
public class SysQrtzServiceImpl extends JoinServiceImpl<SysQrtzMapper, SysQrtz>
    implements SysQrtzService {
  @Resource private SysQrtzMapper sysQrtzMapper;
  @Resource private Scheduler scheduler;
  /**
   * 定时任务列表(全部)
   *
   * @param request 定时任务实体
   * @return {@link List< SysQrtzQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Override
  public List<SysQrtzQueryVO> list(SysQrtzListDTO request) throws Exception {

    SysQrtz po = new SysQrtz();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysQrtz> wrapper = new JoinLambdaWrapper<>(po);
    List<SysQrtzQueryVO> voList = joinList(wrapper, SysQrtzQueryVO.class);

    return voList;
  }

  /**
   * 定时任务列表(分页)
   *
   * @param request 定时任务实体
   * @return {@link Page< SysQrtzQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Override
  public Page<SysQrtzQueryVO> page(SysQrtzPageDTO request) throws Exception {
    SysQrtz po = new SysQrtz();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysQrtz> wrapper = new JoinLambdaWrapper<>(po);
    Page<SysQrtzQueryVO> voPage =
        joinPage(
            new Page<>(request.getPageNum(), request.getPageSize()), wrapper, SysQrtzQueryVO.class);
    return voPage;
  }

  /**
   * 定时任务详情
   *
   * @param id 定时任务id
   * @return {@link SysQrtzQueryVO}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Override
  public SysQrtzQueryVO details(String id) throws Exception {
    SysQrtz po = new SysQrtz();
    po.setId(id);
    JoinLambdaWrapper<SysQrtz> wrapper = new JoinLambdaWrapper<>(po);
    SysQrtzQueryVO voBean = joinGetOne(wrapper, SysQrtzQueryVO.class);
    return voBean;
  }

  /**
   * 定时任务详情
   *
   * @param request 定时任务实体
   * @return {@link SysQrtz}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Override
  public SysQrtzQueryVO details(SysQrtz request) throws Exception {

    JoinLambdaWrapper<SysQrtz> wrapper = new JoinLambdaWrapper<>(request);
    SysQrtzQueryVO voBean = joinGetOne(wrapper, SysQrtzQueryVO.class);
    return voBean;
  }

  /**
   * 删除定时任务(支持批量)
   *
   * @param ids 定时任务id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    List<SysQrtz> qrtzJobList = listByIds(idList);
    for (SysQrtz request : qrtzJobList) {
      // 暂停已注册的该定时器
      scheduler.pauseTrigger(TriggerKey.triggerKey(request.getJobName(), request.getJobGroup()));
      // 取消已注册的该定时器
      scheduler.unscheduleJob(TriggerKey.triggerKey(request.getJobName(), request.getJobGroup()));
      // 删除任务
      scheduler.deleteJob(JobKey.jobKey(request.getJobName(), request.getJobGroup()));
    }
    return removeByIds(idList);
  }

  /**
   * 批量删除定时任务(根据同一属性,针对中间表)
   *
   * @param request 定时任务实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Override
  public boolean delete(SysQrtz request) throws Exception {
    JoinLambdaWrapper<SysQrtz> wrapper = new JoinLambdaWrapper<>(request);
    return remove(wrapper);
  }

  /**
   * 编辑定时任务
   *
   * @param request 定时任务实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Override
  public boolean edit(SysQrtzEditDTO request) throws Exception {
    SysQrtz po = new SysQrtz();
    BeanUtilsPlus.copy(request, po);
    SysQrtzJobStatusEnum jobStatus = request.getJobStatus();
    if (StringUtilsPlus.isNotNUll(jobStatus) && jobStatus.equals(SysQrtzJobStatusEnum.SUSPEND)) {
      SysQrtzQueryVO details = this.details(request.getId());
      scheduler.pauseJob(JobKey.jobKey(details.getJobName(), details.getJobGroup()));
    }
    JoinLambdaWrapper<SysQrtz> wrapper = new JoinLambdaWrapper<>(po);
    return updateById(po);
  }

  /**
   * 新增定时任务
   *
   * @param request 定时任务实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Override
  public boolean add(SysQrtzAddDTO request) throws Exception {
    // 通过任务组名和任务名称联合查询任务，如果已存在不允许重复添加
    SysQrtz po = new SysQrtz();
    po.setJobClassName(request.getJobClassName());
    po.setJobGroup(request.getJobGroup());
    SysQrtzQueryVO details = details(po);
    if (StringUtilsPlus.isNotNUll(details)) {
      throw new BusinessException(ResultCode.JOB_EXISTS);
    }
    BeanUtilsPlus.copy(request, po);
    // 构建Job信息
    JobDetail jobDetail =
        JobBuilder.newJob(JobUtil.getClass(request.getJobClassName()).getClass())
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

  @Override
  public boolean restar(String ids) throws Exception {

    List<String> idList = Arrays.asList(ids.split(","));
    List<SysQrtz> qrtzJobList = listByIds(idList);
    for (SysQrtz request : qrtzJobList) {
      scheduler.resumeJob(JobKey.jobKey(request.getJobName(), request.getJobGroup()));
      request.setJobStatus(SysQrtzJobStatusEnum.UNDER_EXECUTION);
    }

    return updateBatchById(qrtzJobList);
  }

  @Override
  public boolean stop(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    List<SysQrtz> qrtzJobList = listByIds(idList);
    for (SysQrtz request : qrtzJobList) {
      scheduler.pauseJob(JobKey.jobKey(request.getJobName(), request.getJobGroup()));
      request.setJobStatus(SysQrtzJobStatusEnum.SUSPEND);
    }

    return updateBatchById(qrtzJobList);
  }
}
