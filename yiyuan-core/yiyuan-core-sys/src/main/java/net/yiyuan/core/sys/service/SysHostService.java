package net.yiyuan.core.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.core.sys.model.SysHost;

import java.util.List;
/**
 * 主机记录管理Service层接口
 *
 * @author 一源团队--花和尚
 * @date 2023-07-16
 */
public interface SysHostService extends JoinIService<SysHost> {

  /**
   * 主机记录列表(全部)
   *
   * @param request 主机记录实体
   * @return {@link List}
   * @author 一源团队--花和尚
   * @date 2023-07-16
   */
  List<SysHost> list(SysHost request) throws Exception;

  /**
   * 主机记录列表(分页)
   *
   * @param request 主机记录实体
   * @return {@link Page}
   * @author 一源团队--花和尚
   * @date 2023-07-16
   */
  Page<SysHost> pages(SysHost request, Integer pageSize, Integer pageNum) throws Exception;

  /**
   * 主机记录详情
   *
   * @param id 主机记录id
   * @return {@link SysHost}
   * @author 一源团队--花和尚
   * @date 2023-07-16
   */
  SysHost details(String id) throws Exception;

  /**
   * 主机记录详情
   *
   * @param request 主机记录实体
   * @return {@link SysHost}
   * @author 一源团队--花和尚
   * @date 2023-07-16
   */
  SysHost details(SysHost request) throws Exception;

  /**
   * 删除主机记录(支持批量)
   *
   * @param ids 主机记录id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-16
   */
  boolean delete(String ids) throws Exception;

  /**
   * 批量删除主机记录表(根据同一属性,针对中间表)
   *
   * @param request 主机记录实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-16
   */
  boolean delete(SysHost request) throws Exception;

  /**
   * 编辑主机记录表
   *
   * @param request 主机记录实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-16
   */
  boolean edit(SysHost request) throws Exception;

  /**
   * 新增主机记录表
   *
   * @param request 主机记录实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-16
   */
  boolean add(SysHost request) throws Exception;
}
