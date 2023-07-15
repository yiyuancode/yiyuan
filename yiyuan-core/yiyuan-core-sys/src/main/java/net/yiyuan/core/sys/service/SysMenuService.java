package net.yiyuan.core.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.core.sys.model.SysMenu;

import java.util.List;
/**
 * 菜单管理Service层接口
 *
 * @author 一源团队--花和尚
 * @date 2023-07-15
 */
public interface SysMenuService extends JoinIService<SysMenu> {

  /**
   * 菜单列表(全部)
   *
   * @param request 菜单实体
   * @return {@link List}
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  List<SysMenu> list(SysMenu request) throws Exception;

  /**
   * 菜单列表(分页)
   *
   * @param request 菜单实体
   * @return {@link Page}
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  Page<SysMenu> pages(SysMenu request, Integer pageSize, Integer pageNum) throws Exception;

  /**
   * 菜单详情
   *
   * @param id 菜单id
   * @return {@link SysMenu}
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  SysMenu details(String id) throws Exception;

  /**
   * 菜单详情
   *
   * @param request 菜单实体
   * @return {@link SysMenu}
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  SysMenu details(SysMenu request) throws Exception;

  /**
   * 删除菜单(支持批量)
   *
   * @param ids 菜单id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  boolean delete(String ids) throws Exception;

  /**
   * 批量删除菜单表(根据同一属性,针对中间表)
   *
   * @param request 菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  boolean delete(SysMenu request) throws Exception;

  /**
   * 编辑菜单表
   *
   * @param request 菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  boolean edit(SysMenu request) throws Exception;

  /**
   * 新增菜单表
   *
   * @param request 菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-15
   */
  boolean add(SysMenu request) throws Exception;
}
