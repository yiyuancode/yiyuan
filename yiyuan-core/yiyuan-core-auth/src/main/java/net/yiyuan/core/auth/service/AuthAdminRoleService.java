package net.yiyuan.core.auth.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.core.auth.dto.AuthAdminRoleAddDTO;
import net.yiyuan.core.auth.dto.AuthAdminRoleEditDTO;
import net.yiyuan.core.auth.dto.AuthAdminRoleListDTO;
import net.yiyuan.core.auth.dto.AuthAdminRolePageDTO;
import net.yiyuan.core.auth.model.AuthAdminRole;
import net.yiyuan.core.auth.vo.AuthAdminRoleQueryVO;

import java.util.List;

/**
 * 用户_角色管理Service层接口
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
public interface AuthAdminRoleService extends JoinIService<AuthAdminRole> {

    /**
     * 用户_角色列表(全部)
     *
     * @param request 用户_角色实体
     * @return {@link List< AuthAdminRoleQueryVO >}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    List<AuthAdminRoleQueryVO> list(AuthAdminRoleListDTO request) throws Exception;


    /**
     * 用户_角色列表(分页)
     *
     * @param request 用户_角色实体
     * @return {@link Page< AuthAdminRoleQueryVO >}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    Page<AuthAdminRoleQueryVO> page(AuthAdminRolePageDTO request) throws Exception;


    /**
     * 用户_角色详情
     *
     * @param id 用户_角色id
     * @return {@link AuthAdminRoleQueryVO}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    AuthAdminRoleQueryVO details(String id) throws Exception;


    /**
     * 用户_角色详情
     *
     * @param request 用户_角色实体
     * @return {@link AuthAdminRole}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    AuthAdminRoleQueryVO details(AuthAdminRole request) throws Exception;


    /**
     * 删除用户_角色(支持批量)
     *
     * @param ids 用户_角色id(多个逗号分割)
     * @return {@link boolean}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */

    boolean delete(String ids) throws Exception;


    /**
     * 批量删除用户_角色(根据同一属性,针对中间表)
     *
     * @param request 用户_角色实体
     * @return {@link boolean}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    boolean delete(AuthAdminRole request) throws Exception;

    /**
     * 编辑用户_角色
     *
     * @param request 用户_角色实体
     * @return {@link boolean}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    boolean edit(AuthAdminRoleEditDTO request) throws Exception;


    /**
     * 新增用户_角色
     *
     * @param request 用户_角色实体
     * @return {@link boolean}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    boolean add(AuthAdminRoleAddDTO request) throws Exception;

}