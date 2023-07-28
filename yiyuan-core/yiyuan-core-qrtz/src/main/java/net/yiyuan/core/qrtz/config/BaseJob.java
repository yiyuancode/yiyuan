package net.yiyuan.core.qrtz.config;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public interface BaseJob extends Job {
  @Override
  void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException;
}
