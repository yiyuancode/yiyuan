package net.yiyuan.core.auth.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.core.auth.dto.AuthAdminRoleAddDTO;
import net.yiyuan.core.auth.dto.AuthAdminRoleEditDTO;
import net.yiyuan.core.auth.dto.AuthAdminRoleListDTO;
import net.yiyuan.core.auth.dto.AuthAdminRolePageDTO;
import net.yiyuan.core.auth.mapper.AuthAdminRoleMapper;
import net.yiyuan.core.auth.model.AuthAdminRole;
import net.yiyuan.core.auth.service.AuthAdminRoleService;
import net.yiyuan.core.auth.vo.AuthAdminRoleQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 用户_角色管理Service层接口实现
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Slf4j
@Service
public class AuthAdminRoleServiceImpl extends JoinServiceImpl<AuthAdminRoleMapper, AuthAdminRole>
    implements AuthAdminRoleService {
  @Resource private AuthAdminRoleMapper authAdminRoleMapper;

  /**
   * 用户_角色列表(全部)
   *
   * @param request 用户_角色实体
   * @return {@link List< AuthAdminRoleQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public List<AuthAdminRoleQueryVO> list(AuthAdminRoleListDTO request) throws Exception {

    AuthAdminRole po = new AuthAdminRole();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<AuthAdminRole> wrapper = new JoinLambdaWrapper<>(po);
    List<AuthAdminRoleQueryVO> voList = joinList(wrapper, AuthAdminRoleQueryVO.class);

    return voList;
  }

  /**
   * 用户_角色列表(分页)
   *
   * @param request 用户_角色实体
   * @return {@link Page< AuthAdminRoleQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public Page<AuthAdminRoleQueryVO> page(AuthAdminRolePageDTO request) throws Exception {
    AuthAdminRole po = new AuthAdminRole();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<AuthAdminRole> wrapper = new JoinLambdaWrapper<>(po);
    Page<AuthAdminRoleQueryVO> voPage =
        joinPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            AuthAdminRoleQueryVO.class);
    return voPage;
  }

  /**
   * 用户_角色详情
   *
   * @param id 用户_角色id
   * @return {@link AuthAdminRoleQueryVO}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public AuthAdminRoleQueryVO details(String id) throws Exception {
    AuthAdminRole po = new AuthAdminRole();
    po.setId(id);
    JoinLambdaWrapper<AuthAdminRole> wrapper = new JoinLambdaWrapper<>(po);
    AuthAdminRoleQueryVO voBean = joinGetOne(wrapper, AuthAdminRoleQueryVO.class);
    return voBean;
  }

  /**
   * 用户_角色详情
   *
   * @param request 用户_角色实体
   * @return {@link AuthAdminRole}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public AuthAdminRoleQueryVO details(AuthAdminRole request) throws Exception {

    JoinLambdaWrapper<AuthAdminRole> wrapper = new JoinLambdaWrapper<>(request);
    AuthAdminRoleQueryVO voBean = joinGetOne(wrapper, AuthAdminRoleQueryVO.class);
    return voBean;
  }

  /**
   * 删除用户_角色(支持批量)
   *
   * @param ids 用户_角色id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public boolean delete(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids.split(",")));
  }

  /**
   * 批量删除用户_角色(根据同一属性,针对中间表)
   *
   * @param request 用户_角色实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public boolean delete(AuthAdminRole request) throws Exception {
    JoinLambdaWrapper<AuthAdminRole> wrapper = new JoinLambdaWrapper<>(request);
    return remove(wrapper);
  }

  /**
   * 编辑用户_角色
   *
   * @param request 用户_角色实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public boolean edit(AuthAdminRoleEditDTO request) throws Exception {
    AuthAdminRole po = new AuthAdminRole();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<AuthAdminRole> wrapper = new JoinLambdaWrapper<>(po);
    return updateById(po);
  }

  /**
   * 新增用户_角色
   *
   * @param request 用户_角色实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public boolean add(AuthAdminRoleAddDTO request) throws Exception {
    AuthAdminRole po = new AuthAdminRole();
    BeanUtilsPlus.copy(request, po);
    return save(po);
  }
}
