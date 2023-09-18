package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.SysRedisMonitorAddDTO;
import net.yiyuan.dto.SysRedisMonitorEditDTO;
import net.yiyuan.dto.SysRedisMonitorListDTO;
import net.yiyuan.dto.SysRedisMonitorPageDTO;
import net.yiyuan.mapper.SysRedisMonitorMapper;
import net.yiyuan.model.SysRedisMonitor;
import net.yiyuan.service.SysRedisMonitorService;
import net.yiyuan.vo.SysRedisMonitorQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * Redis监控采集Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-18
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
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public List<SysRedisMonitorQueryVO> list(SysRedisMonitorListDTO request) throws Exception {

    SysRedisMonitor po = new SysRedisMonitor();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysRedisMonitor> wrapper = new JoinLambdaWrapper<>(po);
    List<SysRedisMonitorQueryVO> voList =
        sysRedisMonitorMapper.joinSelectList(wrapper, SysRedisMonitorQueryVO.class);

    return voList;
  }

  /**
   * Redis监控采集列表(分页)
   *
   * @param request Redis监控采集实体
   * @return {@link Page< SysRedisMonitorQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public Page<SysRedisMonitorQueryVO> page(SysRedisMonitorPageDTO request) throws Exception {
    SysRedisMonitor po = new SysRedisMonitor();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysRedisMonitor> wrapper = new JoinLambdaWrapper<>(po);
    Page<SysRedisMonitorQueryVO> voPage =
        sysRedisMonitorMapper.joinSelectPage(
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
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public SysRedisMonitorQueryVO details(String id) throws Exception {
    SysRedisMonitor po = new SysRedisMonitor();
    po.setId(id);
    JoinLambdaWrapper<SysRedisMonitor> wrapper = new JoinLambdaWrapper<>(po);
    SysRedisMonitorQueryVO voBean =
        sysRedisMonitorMapper.joinSelectOne(wrapper, SysRedisMonitorQueryVO.class);
    return voBean;
  }

  /**
   * Redis监控采集详情
   *
   * @param request Redis监控采集实体
   * @return {@link SysRedisMonitor}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public SysRedisMonitorQueryVO details(SysRedisMonitor request) throws Exception {
    JoinLambdaWrapper<SysRedisMonitor> wrapper = new JoinLambdaWrapper<>(request);
    SysRedisMonitorQueryVO voBean =
        sysRedisMonitorMapper.joinSelectOne(wrapper, SysRedisMonitorQueryVO.class);
    return voBean;
  }

  /**
   * 删除Redis监控采集(支持批量)
   *
   * @param ids Redis监控采集id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    int i = sysRedisMonitorMapper.deleteBatchIds(idList);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑Redis监控采集
   *
   * @param request Redis监控采集实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean edit(SysRedisMonitorEditDTO request) throws Exception {
    SysRedisMonitor po = new SysRedisMonitor();
    BeanUtilsPlus.copy(request, po);
    int i = sysRedisMonitorMapper.updateById(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增Redis监控采集
   *
   * @param request Redis监控采集实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean add(SysRedisMonitorAddDTO request) throws Exception {
    SysRedisMonitor po = new SysRedisMonitor();
    BeanUtilsPlus.copy(request, po);
    int i = sysRedisMonitorMapper.insert(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }
}
