package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.*;
import net.yiyuan.enums.SysRedisMonitorQueryCountParticleEnum;
import net.yiyuan.mapper.SysRedisMonitorMapper;
import net.yiyuan.model.SysRedisMonitor;
import net.yiyuan.service.SysRedisMonitorService;
import net.yiyuan.vo.SysRedisMonitorQueryCountVO;
import net.yiyuan.vo.SysRedisMonitorQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * Redis监控采集Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
@Slf4j
@Service
public class SysRedisMonitorServiceImpl
    extends JoinServiceImpl<SysRedisMonitorMapper, SysRedisMonitor>
    implements SysRedisMonitorService {
  @Resource private SysRedisMonitorMapper sysRedisMonitorMapper;

  /**
   * Redis监控采集列表(全部)
   *
   * @param request Redis监控采集实体
   * @return {@link List< SysRedisMonitorQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public List<SysRedisMonitorQueryVO> list(SysRedisMonitorListDTO request) throws Exception {

    SysRedisMonitor po = new SysRedisMonitor();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysRedisMonitor> wrapper = new JoinLambdaWrapper<>(po);
    List<SysRedisMonitorQueryVO> voList = joinList(wrapper, SysRedisMonitorQueryVO.class);

    return voList;
  }

  /**
   * Redis监控采集列表(分页)
   *
   * @param request Redis监控采集实体
   * @return {@link Page< SysRedisMonitorQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public Page<SysRedisMonitorQueryVO> page(SysRedisMonitorPageDTO request) throws Exception {
    SysRedisMonitor po = new SysRedisMonitor();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysRedisMonitor> wrapper = new JoinLambdaWrapper<>(po);
    Page<SysRedisMonitorQueryVO> voPage =
        joinPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            SysRedisMonitorQueryVO.class);
    return voPage;
  }

  /**
   * Redis监控采集详情
   *
   * @param id Redis监控采集id
   * @return {@link SysRedisMonitorQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public SysRedisMonitorQueryVO details(String id) throws Exception {
    SysRedisMonitor po = new SysRedisMonitor();
    po.setId(id);
    JoinLambdaWrapper<SysRedisMonitor> wrapper = new JoinLambdaWrapper<>(po);
    SysRedisMonitorQueryVO voBean = joinGetOne(wrapper, SysRedisMonitorQueryVO.class);
    return voBean;
  }

  /**
   * Redis监控采集详情
   *
   * @param request Redis监控采集实体
   * @return {@link SysRedisMonitor}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public SysRedisMonitorQueryVO details(SysRedisMonitor request) throws Exception {

    JoinLambdaWrapper<SysRedisMonitor> wrapper = new JoinLambdaWrapper<>(request);
    SysRedisMonitorQueryVO voBean = joinGetOne(wrapper, SysRedisMonitorQueryVO.class);
    return voBean;
  }

  /**
   * 删除Redis监控采集(支持批量)
   *
   * @param ids Redis监控采集id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public boolean delete(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids.split(",")));
  }

  /**
   * 编辑Redis监控采集
   *
   * @param request Redis监控采集实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public boolean edit(SysRedisMonitorEditDTO request) throws Exception {
    SysRedisMonitor po = new SysRedisMonitor();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysRedisMonitor> wrapper = new JoinLambdaWrapper<>(po);
    return updateById(po);
  }

  /**
   * 新增Redis监控采集
   *
   * @param request Redis监控采集实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public boolean add(SysRedisMonitorAddDTO request) throws Exception {
    SysRedisMonitor po = new SysRedisMonitor();
    BeanUtilsPlus.copy(request, po);
    return save(po);
  }

  @Override
  public List<SysRedisMonitorQueryCountVO> queryCount(SysrRedisMonitorQueryCountDTO request)
      throws Exception {
    QueryWrapper<SysRedisMonitor> lambdaQueryWrapper = new QueryWrapper();
    lambdaQueryWrapper.eq("redis_id", request.getRedisId());
    lambdaQueryWrapper.ge("create_time", request.getCreateTimeStart());
    lambdaQueryWrapper.le("create_time", request.getCreateTimeEnd());

    SysRedisMonitorQueryCountParticleEnum particleEnum = request.getParticle();
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

    List<SysRedisMonitorQueryCountVO> maps = sysRedisMonitorMapper.queryCount(lambdaQueryWrapper);
    return maps;
  }
}
