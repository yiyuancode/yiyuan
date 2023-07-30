package net.yiyuan.core.sys.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.core.sys.dto.*;
import net.yiyuan.core.sys.model.SysHostMonitor;
import net.yiyuan.core.sys.vo.SysHostMonitorQueryCountVO;
import net.yiyuan.core.sys.vo.SysHostMonitorQueryVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 服务器监控采集管理Service层接口
 *
 * @author 一源团队--花和尚
 * @date 2023-07-30
 */
public interface SysHostMonitorService extends JoinIService<SysHostMonitor> {

  /**
   * 服务器监控采集列表(全部)
   *
   * @param request 服务器监控采集实体
   * @return {@link List< SysHostMonitorQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  List<SysHostMonitorQueryVO> list(SysHostMonitorListDTO request) throws Exception;

  /**
   * 服务器监控采集列表(分页)
   *
   * @param request 服务器监控采集实体
   * @return {@link Page< SysHostMonitorQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  Page<SysHostMonitorQueryVO> page(SysHostMonitorPageDTO request) throws Exception;

  /**
   * 服务器监控采集详情
   *
   * @param id 服务器监控采集id
   * @return {@link SysHostMonitorQueryVO}
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  SysHostMonitorQueryVO details(String id) throws Exception;

  /**
   * 服务器监控采集详情
   *
   * @param request 服务器监控采集实体
   * @return {@link SysHostMonitor}
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  SysHostMonitorQueryVO details(SysHostMonitor request) throws Exception;

  /**
   * 删除服务器监控采集(支持批量)
   *
   * @param ids 服务器监控采集id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  boolean delete(String ids) throws Exception;

  /**
   * 批量删除服务器监控采集(根据同一属性,针对中间表)
   *
   * @param request 服务器监控采集实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  boolean delete(SysHostMonitor request) throws Exception;

  /**
   * 编辑服务器监控采集
   *
   * @param request 服务器监控采集实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  boolean edit(SysHostMonitorEditDTO request) throws Exception;

  /**
   * 新增服务器监控采集
   *
   * @param request 服务器监控采集实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  boolean add(SysHostMonitorAddDTO request) throws Exception;

  /**
   * 服务器监控统计查询
   *
   * @param request 服务器监控统计查询实体
   * @return {@link List<Map>}
   * @author 一源团队--花和尚
   * @date 2023-07-30
   */
  List<SysHostMonitorQueryCountVO> queryCount(SysHostMonitorQueryCountDTO request) throws Exception;
}
