package net.yiyuan.core.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.core.sys.dto.SysMenuAddDTO;
import net.yiyuan.core.sys.dto.SysMenuEditDTO;
import net.yiyuan.core.sys.dto.SysMenuListDTO;
import net.yiyuan.core.sys.dto.SysMenuPageDTO;
import net.yiyuan.core.sys.model.SysMenu;
import net.yiyuan.core.sys.vo.SysMenuQueryVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 菜单管理Service层接口
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
public interface SysMenuService extends JoinIService<SysMenu> {

    /**
     * 菜单列表(全部)
     *
     * @param request 菜单实体
     * @return {@link List< SysMenuQueryVO >}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    List<SysMenuQueryVO> list(SysMenuListDTO request) throws Exception;


    /**
     * 菜单列表(分页)
     *
     * @param request 菜单实体
     * @return {@link Page< SysMenuQueryVO >}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    Page<SysMenuQueryVO> page(SysMenuPageDTO request) throws Exception;


    /**
     * 菜单详情
     *
     * @param id 菜单id
     * @return {@link SysMenuQueryVO}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    SysMenuQueryVO details(String id) throws Exception;


    /**
     * 菜单详情
     *
     * @param request 菜单实体
     * @return {@link SysMenu}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    SysMenuQueryVO details(SysMenu request) throws Exception;


    /**
     * 菜单详情-表达式精确匹配
     *
     * @param request 菜单实体
     * @return {@link SysMenu}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    SysMenuQueryVO detailsEqual(SysMenu request) throws Exception;


    /**
     * 删除菜单(支持批量)
     *
     * @param ids 菜单id(多个逗号分割)
     * @return {@link boolean}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */

    boolean delete(String ids) throws Exception;


    /**
     * 批量删除菜单(根据同一属性,针对中间表)
     *
     * @param request 菜单实体
     * @return {@link boolean}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    boolean delete(SysMenu request) throws Exception;

    /**
     * 编辑菜单
     *
     * @param request 菜单实体
     * @return {@link boolean}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    boolean edit(SysMenuEditDTO request) throws Exception;


    /**
     * 新增菜单
     *
     * @param request 菜单实体
     * @return {@link boolean}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    boolean add(SysMenuAddDTO request) throws Exception;

    /**
     * 自动扫描 @Description注解生成菜单数据
     *
     * @return {@link boolean}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    @Transactional
    boolean autoScanMenu() throws Exception;


}