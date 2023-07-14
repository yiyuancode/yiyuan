package net.yiyuan.core.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.core.sys.mapper.SysMenuMapper;
import net.yiyuan.core.sys.model.SysMenu;
import net.yiyuan.core.sys.service.SysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
/**
 * 菜单管理Service层接口实现
 *
 * @author 一源团队--花和尚
 * @date 2023-07-14
 */
@Slf4j
@Service
public class SysMenuServiceImpl extends JoinServiceImpl<SysMenuMapper, SysMenu>
    implements SysMenuService {
  @Resource private SysMenuMapper sysMenuMapper;

  /**
   * 菜单列表(全部)
   *
   * @param request 菜单实体
   * @return {@link List}
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  @Override
  public List<SysMenu> list(SysMenu request) throws Exception {
    SysMenu query = new SysMenu();
    JoinLambdaWrapper<SysMenu> wrapper = new JoinLambdaWrapper<>(request);
    return joinList(wrapper, SysMenu.class);
  }

  /**
   * 菜单列表(分页)
   *
   * @param request 菜单实体
   * @return {@link Page}
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  @Override
  public Page<SysMenu> pages(SysMenu request, Integer pageSize, Integer pageNum) throws Exception {
    SysMenu query = new SysMenu();
    JoinLambdaWrapper<SysMenu> wrapper = new JoinLambdaWrapper<>(request);
    wrapper.orderByDesc(SysMenu::getCreatedTime);

    Page<SysMenu> page = joinPage(new Page<>(pageNum, pageSize), wrapper, SysMenu.class);
    return page;
  }

  /**
   * 菜单详情
   *
   * @param id 菜单id
   * @return {@link SysMenu}
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  @Override
  public SysMenu details(String id) throws Exception {
    SysMenu query = new SysMenu();
    query.setId(id);
    JoinLambdaWrapper<SysMenu> wrapper = new JoinLambdaWrapper<>(query);
    return joinGetOne(wrapper, SysMenu.class);
  }

  /**
   * 菜单详情
   *
   * @param request 菜单实体
   * @return {@link SysMenu}
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  @Override
  public SysMenu details(SysMenu request) throws Exception {
    JoinLambdaWrapper<SysMenu> wrapper = new JoinLambdaWrapper<>(request);
    return joinGetOne(wrapper, SysMenu.class);
  }

  /**
   * 删除菜单(支持批量)
   *
   * @param ids 菜单id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  @Override
  public boolean delete(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids.split(",")));
  }

  /**
   * 批量删除菜单表(根据同一属性,针对中间表)
   *
   * @param request 菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  @Override
  public boolean delete(SysMenu request) throws Exception {
    JoinLambdaWrapper<SysMenu> wrapper = new JoinLambdaWrapper<>(request);
    return remove(wrapper);
  }

  /**
   * 编辑菜单表
   *
   * @param request 菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  @Override
  public boolean edit(SysMenu request) throws Exception {
    request.setUpdatedTime(new Date());
    return updateById(request);
  }

  /**
   * 新增菜单表
   *
   * @param request 菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-14
   */
  @Override
  public boolean add(SysMenu request) throws Exception {
    request.setCreatedTime(new Date());
    request.setUpdatedTime(new Date());
    return save(request);
  }
}
