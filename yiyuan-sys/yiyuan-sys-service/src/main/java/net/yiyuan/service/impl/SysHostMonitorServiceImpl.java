package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.SysHostMonitorAddDTO;
import net.yiyuan.dto.SysHostMonitorEditDTO;
import net.yiyuan.dto.SysHostMonitorListDTO;
import net.yiyuan.dto.SysHostMonitorPageDTO;
import net.yiyuan.mapper.SysHostMonitorMapper;
import net.yiyuan.model.SysHostMonitor;
import net.yiyuan.service.SysHostMonitorService;
import net.yiyuan.vo.SysHostMonitorQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 服务器监控数据采集Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Slf4j
@Service
public class SysHostMonitorServiceImpl extends JoinServiceImpl<SysHostMonitorMapper, SysHostMonitor>
    implements SysHostMonitorService {
  @Resource private SysHostMonitorMapper sysHostMonitorMapper;

  /**
   * 服务器监控数据采集列表(全部)
   *
   * @param request 服务器监控数据采集实体
   * @return {@link List< SysHostMonitorQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public List<SysHostMonitorQueryVO> list(SysHostMonitorListDTO request) throws Exception {

    SysHostMonitor po = new SysHostMonitor();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysHostMonitor> wrapper = new JoinLambdaWrapper<>(po);
    List<SysHostMonitorQueryVO> voList =
        sysHostMonitorMapper.joinSelectList(wrapper, SysHostMonitorQueryVO.class);

    return voList;
  }

  /**
   * 服务器监控数据采集列表(分页)
   *
   * @param request 服务器监控数据采集实体
   * @return {@link Page< SysHostMonitorQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public Page<SysHostMonitorQueryVO> page(SysHostMonitorPageDTO request) throws Exception {
    SysHostMonitor po = new SysHostMonitor();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysHostMonitor> wrapper = new JoinLambdaWrapper<>(po);
    Page<SysHostMonitorQueryVO> voPage =
        sysHostMonitorMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            SysHostMonitorQueryVO.class);
    return voPage;
  }

  /**
   * 服务器监控数据采集详情
   *
   * @param id 服务器监控数据采集id
   * @return {@link SysHostMonitorQueryVO}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public SysHostMonitorQueryVO details(String id) throws Exception {
    SysHostMonitor po = new SysHostMonitor();
    po.setId(id);
    JoinLambdaWrapper<SysHostMonitor> wrapper = new JoinLambdaWrapper<>(po);
    SysHostMonitorQueryVO voBean =
        sysHostMonitorMapper.joinSelectOne(wrapper, SysHostMonitorQueryVO.class);
    return voBean;
  }

  /**
   * 服务器监控数据采集详情
   *
   * @param request 服务器监控数据采集实体
   * @return {@link SysHostMonitor}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public SysHostMonitorQueryVO details(SysHostMonitor request) throws Exception {
    JoinLambdaWrapper<SysHostMonitor> wrapper = new JoinLambdaWrapper<>(request);
    SysHostMonitorQueryVO voBean =
        sysHostMonitorMapper.joinSelectOne(wrapper, SysHostMonitorQueryVO.class);
    return voBean;
  }

  /**
   * 删除服务器监控数据采集(支持批量)
   *
   * @param ids 服务器监控数据采集id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    int i = sysHostMonitorMapper.deleteBatchIds(idList);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑服务器监控数据采集
   *
   * @param request 服务器监控数据采集实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean edit(SysHostMonitorEditDTO request) throws Exception {
    SysHostMonitor po = new SysHostMonitor();
    BeanUtilsPlus.copy(request, po);
    int i = sysHostMonitorMapper.updateById(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增服务器监控数据采集
   *
   * @param request 服务器监控数据采集实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean add(SysHostMonitorAddDTO request) throws Exception {
    SysHostMonitor po = new SysHostMonitor();
    BeanUtilsPlus.copy(request, po);
    int i = sysHostMonitorMapper.insert(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }
}
