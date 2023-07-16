package net.yiyuan.admin.task;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.core.sys.enums.SysHostIsMonitorEnabledEnum;
import net.yiyuan.core.sys.model.SysHost;
import net.yiyuan.core.sys.service.SysHostService;
import net.yiyuan.core.task.model.BaseJob;
import net.yiyuan.plugins.ssh.utils.SshUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 主机监控任务
 *
 * @author 一源团队-花和尚
 * @date 2023/07/16
 */
@Component
@Slf4j
public class HostMonitorTask implements BaseJob {
  private final String HOST_MONITOR_SCRIPT =
      "echo '{\"cpu_usage\":'$(top -bn1 | grep \"Cpu(s)\" | awk '{print $2}')', \"memory_usage\":'$(free -m | awk '/Mem/{printf \"{\\\"usage_percent\\\":%.2f, \\\"used\\\":%d, \\\"total\\\":%d}\", $3/$2*100,$3,$2}')', \"disk_usage\":'$(df -h | awk '$NF==\"/\"{printf \"{\\\"usage_percent\\\":%d, \\\"used\\\":\\\"%s\\\", \\\"total\\\":\\\"%s\\\"}\", $5,$3,$2}')', \"network_usage\":'$(ifconfig eth0 | awk '/RX p/{printf \"%d\", $5}')', \"process_count\":'$(ps -ef | wc -l)'}'";
  @Resource SysHostService sysHostService;

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    log.warn("主机监控任务 执行时间: {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    try {
      SysHost sysHost = new SysHost();
      sysHost.setIsMonitorEnabled(SysHostIsMonitorEnabledEnum.OPEN);
      List<SysHost> sysHostList = sysHostService.list(sysHost);
      sysHostList.forEach(
          (item) -> {
            try {
              String scriptResp =
                  SshUtil.executeScript(
                      item.getHost(),
                      item.getSshPort(),
                      item.getSshUsername(),
                      item.getSshPassword(),
                      HOST_MONITOR_SCRIPT);
              log.warn("主机监控任务 执行结果: {}", scriptResp);
            } catch (Exception e) {
              e.printStackTrace();
            }
          });

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
