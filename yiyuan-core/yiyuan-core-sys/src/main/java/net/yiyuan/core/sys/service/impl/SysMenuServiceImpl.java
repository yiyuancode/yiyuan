package net.yiyuan.core.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.core.sys.mapper.SysMenuMapper;
import net.yiyuan.core.sys.model.SysMenu;
import net.yiyuan.core.sys.service.SysMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 菜单管理Service层接口实现
 *
 * @author 一源团队--花和尚
 * @date 2023-06-24
 */
@Slf4j
@Service
public class SysMenuServiceImpl extends JoinServiceImpl<SysMenuMapper, SysMenu>
    implements SysMenuService {
  private static final Logger LOGGER = LoggerFactory.getLogger(SysMenuServiceImpl.class);
  @Resource private SysMenuMapper sysMenuMapper;

  /**
   * 菜单列表(全部)
   *
   * @param request 菜单实体
   * @return {@link List}
   * @author 一源团队--花和尚
   * @date 2023-06-24
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
   * @date 2023-06-24
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
   * @param request 菜单实体
   * @return {@link SysMenu}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  @Override
  public SysMenu details(SysMenu request) throws Exception {
    SysMenu query = new SysMenu();
    JoinLambdaWrapper<SysMenu> wrapper = new JoinLambdaWrapper<>(request);
    return joinGetOne(wrapper, SysMenu.class);
  }

  /**
   * 删除菜单表
   *
   * @param request 菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  @Transactional
  @Override
  public boolean del(SysMenu request) throws Exception {
    return removeById(request);
  }

  /**
   * 批量删除菜单表
   *
   * @param ids 逗号分割id
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  @Transactional
  @Override
  public boolean dels(String ids) throws Exception {
    log.info("dels:list{}", Arrays.asList(ids.split(",")));
    removeByIds(Arrays.asList(ids.split(",")));
    return true;
  }

  /**
   * 编辑菜单表
   *
   * @param request 菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-06-24
   */
  @Transactional
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
   * @date 2023-06-24
   */
  @Transactional
  @Override
  public boolean add(SysMenu request) throws Exception {
    request.setCreatedTime(new Date());
    request.setUpdatedTime(new Date());
    return save(request);
  }
}
