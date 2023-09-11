package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.*;
import net.yiyuan.model.SysHostMonitor;
import net.yiyuan.vo.SysHostMonitorQueryCountVO;
import net.yiyuan.vo.SysHostMonitorQueryVO;

import java.util.List;

/**
 * 服务器监控采集Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
public interface SysHostMonitorService extends JoinIService<SysHostMonitor> {

  /**
   * 服务器监控采集列表(全部)
   *
   * @param request 服务器监控采集实体
   * @return {@link List< SysHostMonitorQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  List<SysHostMonitorQueryVO> list(SysHostMonitorListDTO request) throws Exception;

  /**
   * 服务器监控采集列表(分页)
   *
   * @param request 服务器监控采集实体
   * @return {@link Page< SysHostMonitorQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  Page<SysHostMonitorQueryVO> page(SysHostMonitorPageDTO request) throws Exception;

  /**
   * 服务器监控采集详情
   *
   * @param id 服务器监控采集id
   * @return {@link SysHostMonitorQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  SysHostMonitorQueryVO details(String id) throws Exception;

  /**
   * 服务器监控采集详情
   *
   * @param request 服务器监控采集实体
   * @return {@link SysHostMonitor}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  SysHostMonitorQueryVO details(SysHostMonitor request) throws Exception;

  /**
   * 删除服务器监控采集(支持批量)
   *
   * @param ids 服务器监控采集id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑服务器监控采集
   *
   * @param request 服务器监控采集实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  boolean edit(SysHostMonitorEditDTO request) throws Exception;

  /**
   * 新增服务器监控采集
   *
   * @param request 服务器监控采集实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  boolean add(SysHostMonitorAddDTO request) throws Exception;

  /**
   * 服务器监控统计查询
   *
   * @param request 服务器监控统计查询实体
   * @return {@link List<SysHostMonitorQueryCountVO>}
   * @author ${author}
   * @date 2023-07-30
   */
  List<SysHostMonitorQueryCountVO> queryCount(SysHostMonitorQueryCountDTO request) throws Exception;
}
