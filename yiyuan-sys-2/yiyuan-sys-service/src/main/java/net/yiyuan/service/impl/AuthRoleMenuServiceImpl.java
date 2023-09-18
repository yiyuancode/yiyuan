package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.AuthRoleMenuAddDTO;
import net.yiyuan.dto.AuthRoleMenuEditDTO;
import net.yiyuan.dto.AuthRoleMenuListDTO;
import net.yiyuan.dto.AuthRoleMenuPageDTO;
import net.yiyuan.mapper.AuthRoleMenuMapper;
import net.yiyuan.model.AuthRoleMenu;
import net.yiyuan.service.AuthRoleMenuService;
import net.yiyuan.vo.AuthRoleMenuQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 角色_菜单Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
@Slf4j
@Service
public class AuthRoleMenuServiceImpl extends JoinServiceImpl<AuthRoleMenuMapper, AuthRoleMenu>
    implements AuthRoleMenuService {
  @Resource private AuthRoleMenuMapper authRoleMenuMapper;

  /**
   * 角色_菜单列表(全部)
   *
   * @param request 角色_菜单实体
   * @return {@link List< AuthRoleMenuQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public List<AuthRoleMenuQueryVO> list(AuthRoleMenuListDTO request) throws Exception {

    AuthRoleMenu po = new AuthRoleMenu();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<AuthRoleMenu> wrapper = new JoinLambdaWrapper<>(po);
    List<AuthRoleMenuQueryVO> voList = joinList(wrapper, AuthRoleMenuQueryVO.class);

    return voList;
  }

  /**
   * 角色_菜单列表(分页)
   *
   * @param request 角色_菜单实体
   * @return {@link Page< AuthRoleMenuQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public Page<AuthRoleMenuQueryVO> page(AuthRoleMenuPageDTO request) throws Exception {
    AuthRoleMenu po = new AuthRoleMenu();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<AuthRoleMenu> wrapper = new JoinLambdaWrapper<>(po);
    Page<AuthRoleMenuQueryVO> voPage =
        joinPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            AuthRoleMenuQueryVO.class);
    return voPage;
  }

  /**
   * 角色_菜单详情
   *
   * @param id 角色_菜单id
   * @return {@link AuthRoleMenuQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public AuthRoleMenuQueryVO details(String id) throws Exception {
    AuthRoleMenu po = new AuthRoleMenu();
    po.setId(id);
    JoinLambdaWrapper<AuthRoleMenu> wrapper = new JoinLambdaWrapper<>(po);
    AuthRoleMenuQueryVO voBean = joinGetOne(wrapper, AuthRoleMenuQueryVO.class);
    return voBean;
  }

  /**
   * 角色_菜单详情
   *
   * @param request 角色_菜单实体
   * @return {@link AuthRoleMenu}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public AuthRoleMenuQueryVO details(AuthRoleMenu request) throws Exception {

    JoinLambdaWrapper<AuthRoleMenu> wrapper = new JoinLambdaWrapper<>(request);
    AuthRoleMenuQueryVO voBean = joinGetOne(wrapper, AuthRoleMenuQueryVO.class);
    return voBean;
  }

  /**
   * 删除角色_菜单(支持批量)
   *
   * @param ids 角色_菜单id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public boolean delete(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids.split(",")));
  }

  /**
   * 编辑角色_菜单
   *
   * @param request 角色_菜单实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public boolean edit(AuthRoleMenuEditDTO request) throws Exception {
    AuthRoleMenu po = new AuthRoleMenu();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<AuthRoleMenu> wrapper = new JoinLambdaWrapper<>(po);
    return updateById(po);
  }

  /**
   * 新增角色_菜单
   *
   * @param request 角色_菜单实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public boolean add(AuthRoleMenuAddDTO request) throws Exception {
    AuthRoleMenu po = new AuthRoleMenu();
    BeanUtilsPlus.copy(request, po);
    return save(po);
  }

  @Override
  public boolean deleteByRoleId(String roleId) throws Exception {
    AuthRoleMenu po = new AuthRoleMenu();
    po.setRoleId(roleId);
    JoinLambdaWrapper<AuthRoleMenu> wrapper = new JoinLambdaWrapper<>(po);

    return remove(wrapper);
  }
}
