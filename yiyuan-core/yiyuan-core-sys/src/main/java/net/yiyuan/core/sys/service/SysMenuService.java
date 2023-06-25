package net.yiyuan.core.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import net.yiyuan.core.sys.model.SysMenu;

import java.util.List;

/**
 * 菜单管理Service层接口
 *
 * @author 一源团队--花和尚
 * @date 2023-06-24
 */
public interface SysMenuService extends IService<SysMenu> {

  /**
   * 菜单列表(全部)
   *
   * @param request 菜单实体
   * @return {@link List}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  List<SysMenu> list(SysMenu request) throws Exception;

  /**
   * 菜单列表(分页)
   *
   * @param request 菜单实体
   * @return {@link Page}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  Page<SysMenu> pages(SysMenu request, Integer pageSize, Integer pageNum) throws Exception;

  /**
   * 菜单详情
   *
   * @param request 菜单实体
   * @return {@link SysMenu}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  SysMenu details(SysMenu request) throws Exception;

  /**
   * 删除菜单表
   *
   * @param request 菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  boolean del(SysMenu request) throws Exception;

  /**
   * 批量删除菜单表
   *
   * @param ids 逗号分割id
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  boolean dels(String ids) throws Exception;

  /**
   * 编辑菜单表
   *
   * @param request 菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  boolean edit(SysMenu request) throws Exception;

  /**
   * 新增菜单表
   *
   * @param request 菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  boolean add(SysMenu request) throws Exception;
}
