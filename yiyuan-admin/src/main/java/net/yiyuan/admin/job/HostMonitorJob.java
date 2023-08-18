package net.yiyuan.admin.job;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.cofig.BaseJob;
import net.yiyuan.dto.SysHostListDTO;
import net.yiyuan.dto.SysHostMonitorAddDTO;
import net.yiyuan.enums.SysHostIsMonitorEnabledEnum;
import net.yiyuan.plugins.ssh.utils.SshUtil;
import net.yiyuan.service.SysHostMonitorService;
import net.yiyuan.service.SysHostService;
import net.yiyuan.vo.SysHostQueryVO;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

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
public class HostMonitorJob implements BaseJob {
  private final String HOST_MONITOR_SCRIPT =
      "echo '{\"cpuUsage\":'$(top -bn1 | grep \"Cpu(s)\" | awk '{print $2}')', \"memoryUsage\":'$(free -m | awk '/Mem/{printf \"{\\\"usagePercent\\\":%.2f, \\\"used\\\":%d, \\\"total\\\":%d}\", $3/$2*100,$3,$2}')', \"diskUsage\":'$(df -h | awk '$NF==\"/\"{printf \"{\\\"usagePercent\\\":%d, \\\"used\\\":\\\"%s\\\", \\\"total\\\":\\\"%s\\\"}\", $5,$3,$2}')', \"networkUsage\":'$(ifconfig eth0 | awk '/RX p/{printf \"%d\", $5}')', \"processCount\":'$(ps -ef | wc -l)'}'";
  @Resource SysHostService sysHostService;
  @Resource SysHostMonitorService sysHostMonitorService;

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    log.warn("主机监控任务222 执行时间: {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    try {
      SysHostListDTO sysHost = new SysHostListDTO();
      sysHost.setIsMonitorEnabled(SysHostIsMonitorEnabledEnum.OPEN);
      List<SysHostQueryVO> sysHostList = sysHostService.list(sysHost);
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
              log.warn("主机监控任务22 执行结果: {}", scriptResp);

              JSONObject jsonObject = JSONObject.parseObject(scriptResp);

              SysHostMonitorAddDTO sysHostMonitorAddDTO = new SysHostMonitorAddDTO();
              sysHostMonitorAddDTO.setCpuUsage(jsonObject.getFloat("cpuUsage"));
              // 设置内存数据
              JSONObject memoryUsage = jsonObject.getJSONObject("memoryUsage");
              sysHostMonitorAddDTO.setMemoryTotal(memoryUsage.getFloat("total"));
              sysHostMonitorAddDTO.setMemoryUsage(memoryUsage.getFloat("usagePercent"));
              sysHostMonitorAddDTO.setMemoryUsed(memoryUsage.getFloat("used"));
              // 设置磁盘数据
              JSONObject diskUsage = jsonObject.getJSONObject("diskUsage");
              sysHostMonitorAddDTO.setDiskUsage(diskUsage.getFloat("usagePercent"));
              sysHostMonitorAddDTO.setDiskTotal(
                  new Float(diskUsage.getString("total").replace("G", "")));
              sysHostMonitorAddDTO.setDiskUsed(
                  new Float(diskUsage.getString("used").replace("G", "")));
              sysHostMonitorAddDTO.setNetworkUsage(jsonObject.getFloat("networkUsage"));
              sysHostMonitorAddDTO.setProcessCount(jsonObject.getInteger("processCount"));
              // 设置主机表id
              sysHostMonitorAddDTO.setHostId(item.getId());

              sysHostMonitorService.add(sysHostMonitorAddDTO);
            } catch (Exception e) {
              e.printStackTrace();
            }
          });

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
