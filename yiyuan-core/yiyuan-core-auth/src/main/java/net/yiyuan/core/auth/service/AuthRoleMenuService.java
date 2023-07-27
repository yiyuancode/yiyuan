package net.yiyuan.core.auth.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.core.auth.dto.AuthRoleMenuAddDTO;
import net.yiyuan.core.auth.dto.AuthRoleMenuEditDTO;
import net.yiyuan.core.auth.dto.AuthRoleMenuListDTO;
import net.yiyuan.core.auth.dto.AuthRoleMenuPageDTO;
import net.yiyuan.core.auth.model.AuthRoleMenu;
import net.yiyuan.core.auth.vo.AuthRoleMenuQueryVO;

import java.util.List;

/**
 * 角色_菜单管理Service层接口
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
public interface AuthRoleMenuService extends JoinIService<AuthRoleMenu> {
    
    /**
     * 角色_菜单列表(全部)
     *
     * @param request 角色_菜单实体
     * @return {@link List< AuthRoleMenuQueryVO >}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    List<AuthRoleMenuQueryVO> list(AuthRoleMenuListDTO request) throws Exception;
    
    
    /**
     * 角色_菜单列表(分页)
     *
     * @param request 角色_菜单实体
     * @return {@link Page< AuthRoleMenuQueryVO >}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    Page<AuthRoleMenuQueryVO> page(AuthRoleMenuPageDTO request) throws Exception;
    
    
    /**
     * 角色_菜单详情
     *
     * @param id 角色_菜单id
     * @return {@link AuthRoleMenuQueryVO}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    AuthRoleMenuQueryVO details(String id) throws Exception;
    
    
    /**
     * 角色_菜单详情
     *
     * @param request 角色_菜单实体
     * @return {@link AuthRoleMenu}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    AuthRoleMenuQueryVO details(AuthRoleMenu request) throws Exception;
    
    
    /**
     * 删除角色_菜单(支持批量)
     *
     * @param ids 角色_菜单id(多个逗号分割)
     * @return {@link boolean}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    boolean delete(String ids) throws Exception;
    
    
    /**
     * 批量删除角色_菜单(根据同一属性,针对中间表)
     *
     * @param request 角色_菜单实体
     * @return {@link boolean}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    boolean delete(AuthRoleMenu request) throws Exception;
    
    /**
     * 编辑角色_菜单
     *
     * @param request 角色_菜单实体
     * @return {@link boolean}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    boolean edit(AuthRoleMenuEditDTO request) throws Exception;
    
    
    /**
     * 新增角色_菜单
     *
     * @param request 角色_菜单实体
     * @return {@link boolean}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    boolean add(AuthRoleMenuAddDTO request) throws Exception;
    
}