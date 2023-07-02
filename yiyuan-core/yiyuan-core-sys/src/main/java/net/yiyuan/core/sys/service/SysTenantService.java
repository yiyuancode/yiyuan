package net.yiyuan.core.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.core.sys.model.SysTenant;

import java.util.List;

/**
 * 租户管理Service层接口
 *
 * @author 一源团队--花和尚
 * @date 2023-07-02
 */
public interface SysTenantService extends JoinIService<SysTenant> {

  /**
   * 租户列表(全部)
   *
   * @param request 租户实体
   * @return {@link List}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  List<SysTenant> list(SysTenant request) throws Exception;

  /**
   * 租户列表(分页)
   *
   * @param request 租户实体
   * @return {@link Page}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  Page<SysTenant> pages(SysTenant request, Integer pageSize, Integer pageNum) throws Exception;

  /**
   * 租户详情
   *
   * @param request 租户实体
   * @return {@link SysTenant}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  SysTenant details(SysTenant request) throws Exception;

  /**
   * 删除租户表
   *
   * @param request 租户实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  boolean del(SysTenant request) throws Exception;

  /**
   * 批量删除租户表
   *
   * @param ids 逗号分割id
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  boolean dels(String ids) throws Exception;

  /**
   * 编辑租户表
   *
   * @param request 租户实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  boolean edit(SysTenant request) throws Exception;

  /**
   * 新增租户表
   *
   * @param request 租户实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-02
   */
  boolean add(SysTenant request) throws Exception;
}
