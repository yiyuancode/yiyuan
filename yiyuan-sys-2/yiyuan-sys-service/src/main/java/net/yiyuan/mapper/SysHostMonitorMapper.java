package net.yiyuan.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import icu.mhb.mybatisplus.plugln.base.mapper.JoinBaseMapper;
import net.yiyuan.model.SysHostMonitor;
import net.yiyuan.vo.SysHostMonitorQueryCountVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 服务器监控采集 Mapper接口
 *
 * @author 一源团队-花和尚
 * @date 2023-07-27
 */
public interface SysHostMonitorMapper extends JoinBaseMapper<SysHostMonitor> {
  /**
   * 服务器监控统计查询
   *
   * @param wrapper 服务器监控统计查询实体
   * @return {@link List<SysHostMonitorQueryCountVO>}
   * @author ${author}
   * @date 2023-07-30
   */
  @Select(
      "SELECT ${ew.sqlSelect} AS time,\n"
          + "       AVG(cpu_usage) AS avg_cpu_usage,\n"
          + "       AVG(memory_usage) AS avg_memory_usage,\n"
          + "       AVG(memory_used) AS avg_memory_used,\n"
          + "       AVG(memory_total) AS avg_memory_total,\n"
          + "       AVG(disk_usage) AS avg_disk_usage,\n"
          + "       AVG(disk_used) AS avg_disk_used,\n"
          + "       AVG(disk_total) AS avg_disk_total,\n"
          + "       SUM(network_usage) AS total_network_usage,\n"
          + "       SUM(process_count) AS total_process_count\n"
          + "FROM sys_host_monitor ${ew.customSqlSegment}\n"
          + "GROUP BY time\n"
          + "ORDER BY time DESC ")
  List<SysHostMonitorQueryCountVO> queryCount(@Param(Constants.WRAPPER) Wrapper wrapper)
      throws Exception;
}
