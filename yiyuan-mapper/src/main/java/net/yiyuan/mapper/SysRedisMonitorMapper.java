package net.yiyuan.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import icu.mhb.mybatisplus.plugln.base.mapper.JoinBaseMapper;
import net.yiyuan.model.SysRedisMonitor;
import net.yiyuan.vo.SysRedisMonitorQueryCountVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Redis监控采集 Mapper接口
 *
 * @author 一源团队-花和尚
 * @date 2023-07-27
 */
public interface SysRedisMonitorMapper extends JoinBaseMapper<SysRedisMonitor> {
  /**
   * Redis监控统计查询
   *
   * @param wrapper Redis监控统计查询实体
   * @return {@link List<SysRedisMonitorQueryCountVO>}
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  @Select(
      "SELECT ${ew.sqlSelect} AS time,\n"
          + " AVG(connected_clients) AS `avg_connected_clients`,\n"
          + "  AVG(cluster_connections) AS `avg_cluster_connections`,\n"
          + "  AVG(max_clients) AS `avg_max_clients`,\n"
          + "  AVG(blocked_clients) AS `avg_blocked_clients`,\n"
          + "  AVG(tracking_clients) AS `avg_tracking_clients`,\n"
          + "  AVG(clients_in_timeout_table) AS `avg_clients_in_timeout_table`,\n"
          + "  AVG(total_net_input_bytes) AS `avg_total_net_input_bytes`,\n"
          + "  AVG(total_net_output_bytes) AS `avg_total_net_output_bytes`,\n"
          + "  AVG(total_connections_received) AS `avg_total_connections_received`,\n"
          + "  AVG(total_commands_processed) AS `avg_total_commands_processed`,\n"
          + "  AVG(instantaneous_ops_per_sec) AS `avg_instantaneous_ops_per_sec`,\n"
          + "  AVG(total_key_count) AS `avg_total_key_count`,\n"
          + "  AVG(total_expired_key_count) AS `avg_total_expired_key_count`,\n"
          + "  AVG(used_memory) AS `avg_used_memory`,\n"
          + "  AVG(total_system_memory) AS `avg_total_system_memory`,\n"
          + "  AVG(maxmemory) AS `avg_maxmemory`,\n"
          + "  AVG(used_memory_peak) AS `avg_used_memory_peak`"
          + "FROM sys_redis_monitor ${ew.customSqlSegment}\n"
          + "GROUP BY time\n"
          + "ORDER BY time DESC ")
  List<SysRedisMonitorQueryCountVO> queryCount(@Param(Constants.WRAPPER) Wrapper wrapper)
      throws Exception;
}
