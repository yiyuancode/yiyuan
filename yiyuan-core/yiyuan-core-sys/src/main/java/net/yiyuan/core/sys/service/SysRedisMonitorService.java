package net.yiyuan.core.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.core.sys.dto.*;
import net.yiyuan.core.sys.model.SysRedisMonitor;
import net.yiyuan.core.sys.vo.SysRedisMonitorQueryCountVO;
import net.yiyuan.core.sys.vo.SysRedisMonitorQueryVO;

import java.util.List;
import java.util.Map;

/**
 * Redis监控采集管理Service层接口
 *
 * @author 一源团队--花和尚
 * @date 2023-08-02
 */
public interface SysRedisMonitorService extends JoinIService<SysRedisMonitor> {

  /**
   * Redis监控采集列表(全部)
   *
   * @param request Redis监控采集实体
   * @return {@link List< SysRedisMonitorQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  List<SysRedisMonitorQueryVO> list(SysRedisMonitorListDTO request) throws Exception;

  /**
   * Redis监控采集列表(分页)
   *
   * @param request Redis监控采集实体
   * @return {@link Page< SysRedisMonitorQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  Page<SysRedisMonitorQueryVO> page(SysRedisMonitorPageDTO request) throws Exception;

  /**
   * Redis监控采集详情
   *
   * @param id Redis监控采集id
   * @return {@link SysRedisMonitorQueryVO}
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  SysRedisMonitorQueryVO details(String id) throws Exception;

  /**
   * Redis监控采集详情
   *
   * @param request Redis监控采集实体
   * @return {@link SysRedisMonitor}
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  SysRedisMonitorQueryVO details(SysRedisMonitor request) throws Exception;

  /**
   * 删除Redis监控采集(支持批量)
   *
   * @param ids Redis监控采集id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  boolean delete(String ids) throws Exception;

  /**
   * 批量删除Redis监控采集(根据同一属性,针对中间表)
   *
   * @param request Redis监控采集实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  boolean delete(SysRedisMonitor request) throws Exception;

  /**
   * 编辑Redis监控采集
   *
   * @param request Redis监控采集实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  boolean edit(SysRedisMonitorEditDTO request) throws Exception;

  /**
   * 新增Redis监控采集
   *
   * @param request Redis监控采集实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  boolean add(SysRedisMonitorAddDTO request) throws Exception;

  /**
   * Redis监控统计查询
   *
   * @param request Redis监控统计查询实体
   * @return {@link List< Map >}
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  List<SysRedisMonitorQueryCountVO> queryCount(SysrRedisMonitorQueryCountDTO request)
      throws Exception;
}
