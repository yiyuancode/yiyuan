package net.yiyuan.core.task.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.core.task.model.QrtzTriggers;

import java.util.List;

/**
 * 触发器详细信息管理Service层接口
 *
 * @author 一源团队--花和尚
 * @date 2023-07-06
 */
public interface QrtzTriggersService extends JoinIService<QrtzTriggers> {

  /**
   * 触发器详细信息列表(全部)
   *
   * @param request 触发器详细信息实体
   * @return {@link List}
   * @author 一源团队--花和尚
   * @date 2023-07-06
   */
  List<QrtzTriggers> list(QrtzTriggers request) throws Exception;

  /**
   * 触发器详细信息列表(分页)
   *
   * @param request 触发器详细信息实体
   * @return {@link Page}
   * @author 一源团队--花和尚
   * @date 2023-07-06
   */
  Page<QrtzTriggers> pages(QrtzTriggers request, Integer pageSize, Integer pageNum)
      throws Exception;

  /**
   * 触发器详细信息详情
   *
   * @param request 触发器详细信息实体
   * @return {@link QrtzTriggers}
   * @author 一源团队--花和尚
   * @date 2023-07-06
   */
  QrtzTriggers details(QrtzTriggers request) throws Exception;

  /**
   * 删除触发器详细信息表
   *
   * @param request 触发器详细信息实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-06
   */
  boolean del(QrtzTriggers request) throws Exception;

  /**
   * 批量删除触发器详细信息表
   *
   * @param ids 逗号分割id
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-06
   */
  boolean dels(String ids) throws Exception;

  /**
   * 编辑触发器详细信息表
   *
   * @param request 触发器详细信息实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-06
   */
  boolean edit(QrtzTriggers request) throws Exception;

  /**
   * 新增触发器详细信息表
   *
   * @param request 触发器详细信息实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-06
   */
  boolean add(QrtzTriggers request) throws Exception;
}
