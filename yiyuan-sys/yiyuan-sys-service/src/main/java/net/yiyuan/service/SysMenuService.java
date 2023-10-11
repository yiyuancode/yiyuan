package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.SysMenuAddDTO;
import net.yiyuan.dto.SysMenuEditDTO;
import net.yiyuan.dto.SysMenuListDTO;
import net.yiyuan.dto.SysMenuPageDTO;
import net.yiyuan.model.SysMenu;
import net.yiyuan.vo.SysMenuQueryVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 菜单Service层接口
 *
 * @author 一源-花和尚
 * @date 2023-09-26
 */
public interface SysMenuService extends JoinIService<SysMenu> {

  /**
   * 菜单列表(全部)
   *
   * @param request 菜单实体
   * @return {@link List< SysMenuQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  List<SysMenuQueryVO> list(SysMenuListDTO request) throws Exception;

  /**
   * 菜单列表(分页)
   *
   * @param request 菜单实体
   * @return {@link Page< SysMenuQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  Page<SysMenuQueryVO> page(SysMenuPageDTO request) throws Exception;

  /**
   * 菜单详情
   *
   * @param id 菜单id
   * @return {@link SysMenuQueryVO}
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  SysMenuQueryVO details(String id) throws Exception;

  /**
   * 菜单详情
   *
   * @param request 菜单实体
   * @return {@link SysMenu}
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  SysMenuQueryVO details(SysMenu request) throws Exception;

  /**
   * 删除菜单(支持批量)
   *
   * @param ids 菜单id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑菜单
   *
   * @param request 菜单实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  boolean edit(SysMenuEditDTO request) throws Exception;

  /**
   * 新增菜单
   *
   * @param request 菜单实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  boolean add(SysMenuAddDTO request) throws Exception;

  /**
   * 自动生成菜单
   *
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Transactional
  public boolean autoScanMenu() throws Exception;
}
