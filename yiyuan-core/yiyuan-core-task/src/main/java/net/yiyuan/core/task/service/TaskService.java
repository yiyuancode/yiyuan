package net.yiyuan.core.task.service;

import cn.hutool.core.util.ReflectUtil;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.core.task.model.add_task.AddTaskReq;
import org.quartz.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class TaskService {
  @Resource private Scheduler scheduler;

  /**
   * 添加定时任务
   *
   * @param request 用户_角色实体
   * @return {@link Boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  public Boolean addTask(AddTaskReq request) throws Exception {
    // 启动调度器
    scheduler.start();

    // 构建Job信息
    JobDetail jobDetail =
        JobBuilder.newJob(ReflectUtil.newInstance(request.getJobClassName()))
            .withIdentity(request.getJobClassName(), request.getJobGroupName())
            .build();

    // Cron表达式调度构建器(即任务执行的时间)
    CronScheduleBuilder cron = CronScheduleBuilder.cronSchedule(request.getCronExpression());

    // 根据Cron表达式构建一个Trigger
    CronTrigger trigger =
        TriggerBuilder.newTrigger()
            .withIdentity(request.getJobClassName(), request.getJobGroupName())
            .withSchedule(cron)
            .build();

    scheduler.scheduleJob(jobDetail, trigger);
    return true;
  }

  /**
   * 删除定时任务
   *
   * @param request 用户_角色实体
   * @return {@link Boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  public Boolean delTask(AddTaskReq request) throws Exception {
    scheduler.pauseTrigger(
        TriggerKey.triggerKey(request.getJobClassName(), request.getJobGroupName()));
    scheduler.unscheduleJob(
        TriggerKey.triggerKey(request.getJobClassName(), request.getJobGroupName()));
    scheduler.deleteJob(JobKey.jobKey(request.getJobClassName(), request.getJobGroupName()));
    return true;
  }

  /**
   * 暂停定时任务
   *
   * @param request 用户_角色实体
   * @return {@link Boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  public Boolean stopTask(AddTaskReq request) throws Exception {
    scheduler.pauseJob(JobKey.jobKey(request.getJobClassName(), request.getJobGroupName()));
    return true;
  }

  /**
   * 恢复定时任务
   *
   * @param request 用户_角色实体
   * @return {@link Boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  public Boolean restartTask(AddTaskReq request) throws Exception {
    scheduler.resumeJob(JobKey.jobKey(request.getJobClassName(), request.getJobGroupName()));
    return true;
  }
}
