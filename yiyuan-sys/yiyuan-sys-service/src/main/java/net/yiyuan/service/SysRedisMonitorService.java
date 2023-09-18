package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.SysRedisMonitorAddDTO;
import net.yiyuan.dto.SysRedisMonitorEditDTO;
import net.yiyuan.dto.SysRedisMonitorListDTO;
import net.yiyuan.dto.SysRedisMonitorPageDTO;
import net.yiyuan.model.SysRedisMonitor;
import net.yiyuan.vo.SysRedisMonitorQueryVO;

import java.util.List;

/**
 * Redis监控采集Service层接口
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
public interface SysRedisMonitorService extends JoinIService<SysRedisMonitor> {

  /**
   * Redis监控采集列表(全部)
   *
   * @param request Redis监控采集实体
   * @return {@link List< SysRedisMonitorQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  List<SysRedisMonitorQueryVO> list(SysRedisMonitorListDTO request) throws Exception;

  /**
   * Redis监控采集列表(分页)
   *
   * @param request Redis监控采集实体
   * @return {@link Page< SysRedisMonitorQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  Page<SysRedisMonitorQueryVO> page(SysRedisMonitorPageDTO request) throws Exception;

  /**
   * Redis监控采集详情
   *
   * @param id Redis监控采集id
   * @return {@link SysRedisMonitorQueryVO}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  SysRedisMonitorQueryVO details(String id) throws Exception;

  /**
   * Redis监控采集详情
   *
   * @param request Redis监控采集实体
   * @return {@link SysRedisMonitor}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  SysRedisMonitorQueryVO details(SysRedisMonitor request) throws Exception;

  /**
   * 删除Redis监控采集(支持批量)
   *
   * @param ids Redis监控采集id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑Redis监控采集
   *
   * @param request Redis监控采集实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  boolean edit(SysRedisMonitorEditDTO request) throws Exception;

  /**
   * 新增Redis监控采集
   *
   * @param request Redis监控采集实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  boolean add(SysRedisMonitorAddDTO request) throws Exception;
}
