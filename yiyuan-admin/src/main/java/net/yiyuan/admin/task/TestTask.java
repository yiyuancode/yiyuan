package net.yiyuan.admin.task;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.core.task.model.BaseJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试定时任务执行
 *
 * @author 一源团队-花和尚
 * @date 2023/06/23
 */
@Slf4j
public class TestTask implements BaseJob {
  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    log.warn("Test Job 执行时间: {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
  }
}
