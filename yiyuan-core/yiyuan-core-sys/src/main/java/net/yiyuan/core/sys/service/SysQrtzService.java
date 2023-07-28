package net.yiyuan.core.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.core.sys.dto.SysQrtzAddDTO;
import net.yiyuan.core.sys.dto.SysQrtzEditDTO;
import net.yiyuan.core.sys.dto.SysQrtzListDTO;
import net.yiyuan.core.sys.dto.SysQrtzPageDTO;
import net.yiyuan.core.sys.model.SysQrtz;
import net.yiyuan.core.sys.vo.SysQrtzQueryVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * 定时任务管理Service层接口
 *
 * @author 一源团队--花和尚
 * @date 2023-07-28
 */
public interface SysQrtzService extends JoinIService<SysQrtz> {

  /**
   * 定时任务列表(全部)
   *
   * @param request 定时任务实体
   * @return {@link List< SysQrtzQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  List<SysQrtzQueryVO> list(SysQrtzListDTO request) throws Exception;

  /**
   * 定时任务列表(分页)
   *
   * @param request 定时任务实体
   * @return {@link Page< SysQrtzQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  Page<SysQrtzQueryVO> page(SysQrtzPageDTO request) throws Exception;

  /**
   * 定时任务详情
   *
   * @param id 定时任务id
   * @return {@link SysQrtzQueryVO}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  SysQrtzQueryVO details(String id) throws Exception;

  /**
   * 定时任务详情
   *
   * @param request 定时任务实体
   * @return {@link SysQrtz}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  SysQrtzQueryVO details(SysQrtz request) throws Exception;

  /**
   * 删除定时任务(支持批量)
   *
   * @param ids 定时任务id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Transactional
  boolean delete(String ids) throws Exception;

  /**
   * 批量删除定时任务(根据同一属性,针对中间表)
   *
   * @param request 定时任务实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Transactional
  boolean delete(SysQrtz request) throws Exception;

  /**
   * 编辑定时任务
   *
   * @param request 定时任务实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Transactional
  boolean edit(SysQrtzEditDTO request) throws Exception;

  /**
   * 新增定时任务
   *
   * @param request 定时任务实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Transactional
  boolean add(SysQrtzAddDTO request) throws Exception;

  /**
   * 重启定时任务(支持批量)
   *
   * @param ids 定时任务管理id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Transactional
  boolean restar(String ids) throws Exception;

  /**
   * 暂停定时任务(支持批量)
   *
   * @param ids 定时任务管理id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-28
   */
  @Transactional
  boolean stop(String ids) throws Exception;
}
