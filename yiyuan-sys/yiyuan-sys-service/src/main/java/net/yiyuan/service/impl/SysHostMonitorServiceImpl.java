package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.*;
import net.yiyuan.enums.SysHostIsMonitorQueryCountParticleEnum;
import net.yiyuan.mapper.SysHostMonitorMapper;
import net.yiyuan.model.SysHostMonitor;
import net.yiyuan.service.SysHostMonitorService;
import net.yiyuan.vo.SysHostMonitorQueryCountVO;
import net.yiyuan.vo.SysHostMonitorQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 服务器监控采集Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
@Slf4j
@Service
public class SysHostMonitorServiceImpl extends JoinServiceImpl<SysHostMonitorMapper, SysHostMonitor>
    implements SysHostMonitorService {
  @Resource private SysHostMonitorMapper sysHostMonitorMapper;

  /**
   * 服务器监控采集列表(全部)
   *
   * @param request 服务器监控采集实体
   * @return {@link List< SysHostMonitorQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public List<SysHostMonitorQueryVO> list(SysHostMonitorListDTO request) throws Exception {

    SysHostMonitor po = new SysHostMonitor();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysHostMonitor> wrapper = new JoinLambdaWrapper<>(po);
    List<SysHostMonitorQueryVO> voList = joinList(wrapper, SysHostMonitorQueryVO.class);

    return voList;
  }

  /**
   * 服务器监控采集列表(分页)
   *
   * @param request 服务器监控采集实体
   * @return {@link Page< SysHostMonitorQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public Page<SysHostMonitorQueryVO> page(SysHostMonitorPageDTO request) throws Exception {
    SysHostMonitor po = new SysHostMonitor();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysHostMonitor> wrapper = new JoinLambdaWrapper<>(po);
    Page<SysHostMonitorQueryVO> voPage =
        joinPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            SysHostMonitorQueryVO.class);
    return voPage;
  }

  /**
   * 服务器监控采集详情
   *
   * @param id 服务器监控采集id
   * @return {@link SysHostMonitorQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public SysHostMonitorQueryVO details(String id) throws Exception {
    SysHostMonitor po = new SysHostMonitor();
    po.setId(id);
    JoinLambdaWrapper<SysHostMonitor> wrapper = new JoinLambdaWrapper<>(po);
    SysHostMonitorQueryVO voBean = joinGetOne(wrapper, SysHostMonitorQueryVO.class);
    return voBean;
  }

  /**
   * 服务器监控采集详情
   *
   * @param request 服务器监控采集实体
   * @return {@link SysHostMonitor}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public SysHostMonitorQueryVO details(SysHostMonitor request) throws Exception {

    JoinLambdaWrapper<SysHostMonitor> wrapper = new JoinLambdaWrapper<>(request);
    SysHostMonitorQueryVO voBean = joinGetOne(wrapper, SysHostMonitorQueryVO.class);
    return voBean;
  }

  /**
   * 删除服务器监控采集(支持批量)
   *
   * @param ids 服务器监控采集id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public boolean delete(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids.split(",")));
  }

  /**
   * 编辑服务器监控采集
   *
   * @param request 服务器监控采集实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public boolean edit(SysHostMonitorEditDTO request) throws Exception {
    SysHostMonitor po = new SysHostMonitor();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysHostMonitor> wrapper = new JoinLambdaWrapper<>(po);
    return updateById(po);
  }

  /**
   * 新增服务器监控采集
   *
   * @param request 服务器监控采集实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public boolean add(SysHostMonitorAddDTO request) throws Exception {
    SysHostMonitor po = new SysHostMonitor();
    BeanUtilsPlus.copy(request, po);
    return save(po);
  }

  @Override
  public List<SysHostMonitorQueryCountVO> queryCount(SysHostMonitorQueryCountDTO request)
      throws Exception {
    QueryWrapper<SysHostMonitor> lambdaQueryWrapper = new QueryWrapper();
    lambdaQueryWrapper.eq("host_id", request.getHostId());
    lambdaQueryWrapper.ge("create_time", request.getCreateTimeStart());
    lambdaQueryWrapper.le("create_time", request.getCreateTimeEnd());

    SysHostIsMonitorQueryCountParticleEnum particleEnum = request.getParticle();
    // 如果时间跨度
    switch (particleEnum) {
      case BY_MINUTE_5:
        // 统计颗粒度为每5分钟
        lambdaQueryWrapper.select(
            "DATE_FORMAT(DATE_SUB(create_time, INTERVAL MINUTE(create_time) % 5 MINUTE), '%Y-%m-%d %H:%i:00') ");
        break;
      case BY_HOUR:
        // 统计颗粒度为每小时
        lambdaQueryWrapper.select("DATE_FORMAT(create_time, '%Y-%m-%d %H:00:00') ");
        break;
      case BY_DAYS:
        // 统计颗粒度为天
        lambdaQueryWrapper.select("DATE(create_time)");
        break;
      case BY_WEEK:
        // 统计颗粒度为周
        lambdaQueryWrapper.select("YEAR(create_time) ");
        break;
      case BY_MONTH:
        // 统计颗粒度为月
        lambdaQueryWrapper.select("DATE_FORMAT(create_time, '%Y-%m') ");
        break;
    }

    List<SysHostMonitorQueryCountVO> maps = sysHostMonitorMapper.queryCount(lambdaQueryWrapper);

    return maps;
  }
}
