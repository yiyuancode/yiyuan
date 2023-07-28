package net.yiyuan.core.qrtz.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.core.qrtz.dto.QrtzJobAddDTO;
import net.yiyuan.core.qrtz.dto.QrtzJobEditDTO;
import net.yiyuan.core.qrtz.dto.QrtzJobListDTO;
import net.yiyuan.core.qrtz.dto.QrtzJobPageDTO;
import net.yiyuan.core.qrtz.model.QrtzJob;
import net.yiyuan.core.qrtz.vo.QrtzJobQueryVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 定时任务管理管理Service层接口
 *
 * @author 一源团队--花和尚
 * @date 2023-07-28
 */
public interface QrtzJobService extends JoinIService<QrtzJob> {

  /**
   * 定时任务管理列表(全部)
   *
   * @param request 定时任务管理实体
   * @return {@link List< QrtzJobQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  List<QrtzJobQueryVO> list(QrtzJobListDTO request) throws Exception;

  /**
   * 定时任务管理列表(分页)
   *
   * @param request 定时任务管理实体
   * @return {@link Page< QrtzJobQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  Page<QrtzJobQueryVO> page(QrtzJobPageDTO request) throws Exception;

  /**
   * 定时任务管理详情
   *
   * @param id 定时任务管理id
   * @return {@link QrtzJobQueryVO}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  QrtzJobQueryVO details(String id) throws Exception;

  /**
   * 定时任务管理详情
   *
   * @param request 定时任务管理实体
   * @return {@link QrtzJob}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  QrtzJobQueryVO details(QrtzJob request) throws Exception;

  /**
   * 删除定时任务管理(支持批量)
   *
   * @param ids 定时任务管理id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  boolean delete(String ids) throws Exception;

  /**
   * 批量删除定时任务管理(根据同一属性,针对中间表)
   *
   * @param request 定时任务管理实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  boolean delete(QrtzJob request) throws Exception;

  /**
   * 编辑定时任务管理
   *
   * @param request 定时任务管理实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  boolean edit(QrtzJobEditDTO request) throws Exception;

  /**
   * 新增定时任务管理
   *
   * @param request 定时任务管理实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Transactional
  boolean add(QrtzJobAddDTO request) throws Exception;
}
