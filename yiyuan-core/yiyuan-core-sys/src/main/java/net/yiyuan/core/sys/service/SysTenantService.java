package net.yiyuan.core.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.core.sys.dto.SysTenantAddDTO;
import net.yiyuan.core.sys.dto.SysTenantEditDTO;
import net.yiyuan.core.sys.dto.SysTenantListDTO;
import net.yiyuan.core.sys.dto.SysTenantPageDTO;
import net.yiyuan.core.sys.model.SysTenant;
import net.yiyuan.core.sys.vo.SysTenantQueryVO;

import java.util.List;

/**
 * 租户管理Service层接口
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
public interface SysTenantService extends JoinIService<SysTenant> {
    
    /**
     * 租户列表(全部)
     *
     * @param request 租户实体
     * @return {@link List< SysTenantQueryVO >}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    List<SysTenantQueryVO> list(SysTenantListDTO request) throws Exception;
    
    
    /**
     * 租户列表(分页)
     *
     * @param request 租户实体
     * @return {@link Page< SysTenantQueryVO >}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    Page<SysTenantQueryVO> page(SysTenantPageDTO request) throws Exception;
    
    
    /**
     * 租户详情
     *
     * @param id 租户id
     * @return {@link SysTenantQueryVO}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    SysTenantQueryVO details(String id) throws Exception;
    
    
    /**
     * 租户详情
     *
     * @param request 租户实体
     * @return {@link SysTenant}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    SysTenantQueryVO details(SysTenant request) throws Exception;
    
    
    /**
     * 删除租户(支持批量)
     *
     * @param ids 租户id(多个逗号分割)
     * @return {@link boolean}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    
    boolean delete(String ids) throws Exception;
    
    
    /**
     * 批量删除租户(根据同一属性,针对中间表)
     *
     * @param request 租户实体
     * @return {@link boolean}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    boolean delete(SysTenant request) throws Exception;
    
    /**
     * 编辑租户
     *
     * @param request 租户实体
     * @return {@link boolean}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    boolean edit(SysTenantEditDTO request) throws Exception;
    
    
    /**
     * 新增租户
     *
     * @param request 租户实体
     * @return {@link boolean}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    boolean add(SysTenantAddDTO request) throws Exception;
    
}