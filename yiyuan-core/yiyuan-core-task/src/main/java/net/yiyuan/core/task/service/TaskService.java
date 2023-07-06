package net.yiyuan.core.task.service;

import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.core.task.model.QrtzTriggers;
import net.yiyuan.core.task.model.req.AddTaskReq;
import net.yiyuan.core.task.model.vo.TaskDeatilVo;
import net.yiyuan.core.task.utils.JobUtil;
import org.quartz.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@Service
public class TaskService {
  @Resource private Scheduler scheduler;
  @Resource private QrtzTriggersService qrtzTriggersService;

  /**
   * 查询定时任务详情
   *
   * @param request 定时任务请求实体
   * @return {@link Boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  public TaskDeatilVo taskDeatil(AddTaskReq request) throws Exception {
    //    // 响应结果
    TaskDeatilVo result = new TaskDeatilVo();
    //    JobKey jobKey = new JobKey(request.getJobClassName(), request.getJobGroupName());
    //    // 获取任务详情
    //    JobDetail jobDetail = scheduler.getJobDetail(jobKey);
    //    // 创建TriggerKey对象
    //    TriggerKey triggerKey = new TriggerKey(request.getJobClassName(),
    // request.getJobGroupName());
    //    // 获取触发器详情信息
    //    Trigger trigger = scheduler.getTrigger(triggerKey);
    //    //    trigger.get
    //    log.info("trigger{}", JSONString);
    //    BeanUtilsPlus.copy(trigger, result);
    QrtzTriggers query = new QrtzTriggers();
    query.setJobName(request.getJobName());
    query.setJobGroup(request.getJobGroup());
    QrtzTriggers details = qrtzTriggersService.details(query);
    BeanUtilsPlus.copy(details, result);
    return result;
  }
  /**
   * 添加定时任务
   *
   * @param request 定时任务请求实体
   * @return {@link Boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  public Boolean addTask(AddTaskReq request) throws Exception {
    // 构建Job信息
    JobDetail jobDetail =
        JobBuilder.newJob(JobUtil.getClass(request.getJobName()).getClass())
            .withIdentity(request.getJobName(), request.getJobGroup())
            .build();

    // Cron表达式调度构建器(即任务执行的时间)
    CronScheduleBuilder cron = CronScheduleBuilder.cronSchedule(request.getCronExpression());
    // 根据Cron表达式构建一个Trigger
    TriggerBuilder<CronTrigger> cronTriggerTriggerBuilder =
        TriggerBuilder.newTrigger()
            .withIdentity(request.getJobName(), request.getJobGroup())
            .withSchedule(cron);
    // 时间不为空设置开始时间和结束时间
    if (ObjectUtil.isNull(request.getStartTime())) {
      cronTriggerTriggerBuilder.startAt(request.getStartTime());
    }
    if (ObjectUtil.isNull(request.getStartTime())) {
      cronTriggerTriggerBuilder.endAt(request.getEndTime());
    }
    CronTrigger trigger = cronTriggerTriggerBuilder.build();

    scheduler.scheduleJob(jobDetail, trigger);
    return true;
  }

  /**
   * 删除定时任务
   *
   * @param request 定时任务请求实体
   * @return {@link Boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  public Boolean delTask(AddTaskReq request) throws Exception {
    // 暂停已注册的该定时器
    scheduler.pauseTrigger(TriggerKey.triggerKey(request.getJobName(), request.getJobGroup()));
    // 取消已注册的该定时器
    scheduler.unscheduleJob(TriggerKey.triggerKey(request.getJobName(), request.getJobGroup()));
    // 删除任务
    scheduler.deleteJob(JobKey.jobKey(request.getJobName(), request.getJobGroup()));
    return true;
  }

  /**
   * 暂停定时任务
   *
   * @param request 定时任务请求实体
   * @return {@link Boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  public Boolean stopTask(AddTaskReq request) throws Exception {
    scheduler.pauseJob(JobKey.jobKey(request.getJobName(), request.getJobGroup()));
    return true;
  }

  /**
   * 恢复定时任务
   *
   * @param request 定时任务请求实体
   * @return {@link Boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  public Boolean restartTask(AddTaskReq request) throws Exception {
    scheduler.resumeJob(JobKey.jobKey(request.getJobName(), request.getJobGroup()));
    return true;
  }

  /**
   * 修改定时任务执行实践
   *
   * @param request 定时任务请求实体
   * @return {@link Boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  public Boolean editTaskCron(AddTaskReq request) throws Exception {

    // build触发key
    TriggerKey triggerKey = TriggerKey.triggerKey(request.getJobName(), request.getJobGroup());

    // build新的cron执行器
    CronScheduleBuilder cronScheduleBuilder =
        CronScheduleBuilder.cronSchedule(request.getCronExpression());

    try {

      // 获取当前正在运行的触发器
      CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);

      if (Objects.isNull(cronTrigger)) {
        log.error("未找到触发器，jobName:{}", request.getJobName());
        return false;
      }

      // 根据新的执行器重新关联触发器
      cronTrigger =
          cronTrigger
              .getTriggerBuilder()
              .withIdentity(triggerKey)
              .withSchedule(cronScheduleBuilder)
              .build();

      log.info("重置了任务时间" + LocalDateTime.now());

      // 重置对应的job
      scheduler.rescheduleJob(triggerKey, cronTrigger);
    } catch (SchedulerException e) {
      throw new RuntimeException(e);
    }

    //    TriggerKey triggerKey =
    //        TriggerKey.triggerKey(request.getJobClassName(), request.getJobGroupName());
    //    // 表达式调度构建器
    //    CronScheduleBuilder scheduleBuilder =
    //        CronScheduleBuilder.cronSchedule(request.getCronExpression());
    //
    //    CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
    //
    //    // 根据Cron表达式构建一个Trigger
    //    trigger =
    //
    // trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
    //
    //    // 按新的trigger重新设置job执行
    //    scheduler.rescheduleJob(triggerKey, trigger);
    return true;
  }
}
