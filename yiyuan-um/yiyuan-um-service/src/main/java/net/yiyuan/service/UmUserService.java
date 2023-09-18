package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.UmUserAddDTO;
import net.yiyuan.dto.UmUserEditDTO;
import net.yiyuan.dto.UmUserListDTO;
import net.yiyuan.dto.UmUserPageDTO;
import net.yiyuan.model.UmUser;
import net.yiyuan.vo.UmUserQueryVO;

import java.util.List;

/**
 * 用户Service层接口
 *
 * @author 小林同学
 * @date 2023-09-18
 */
public interface UmUserService extends JoinIService<UmUser> {

    /**
     * 用户列表(全部)
     *
     * @param request 用户实体
     * @return {@link List< UmUserQueryVO >}
     * @author 小林同学
     * @date 2023-09-18
     */
    List<UmUserQueryVO> list(UmUserListDTO request) throws Exception;

    /**
     * 用户列表(分页)
     *
     * @param request 用户实体
     * @return {@link Page< UmUserQueryVO >}
     * @author 小林同学
     * @date 2023-09-18
     */
    Page<UmUserQueryVO> page(UmUserPageDTO request) throws Exception;

    /**
     * 用户详情
     *
     * @param id 用户id
     * @return {@link UmUserQueryVO}
     * @author 小林同学
     * @date 2023-09-18
     */
    UmUserQueryVO details(String id) throws Exception;

    /**
     * 用户详情
     *
     * @param request 用户实体
     * @return {@link UmUser}
     * @author 小林同学
     * @date 2023-09-18
     */
    UmUserQueryVO details(UmUser request) throws Exception;

    /**
     * 删除用户(支持批量)
     *
     * @param ids 用户id(多个逗号分割)
     * @return {@link boolean}
     * @author 小林同学
     * @date 2023-09-18
     */
    boolean delete(String ids) throws Exception;

    /**
     * 编辑用户
     *
     * @param request 用户实体
     * @return {@link boolean}
     * @author 小林同学
     * @date 2023-09-18
     */
    boolean edit(UmUserEditDTO request) throws Exception;

    /**
     * 新增用户
     *
     * @param request 用户实体
     * @return {@link boolean}
     * @author 小林同学
     * @date 2023-09-18
     */
    boolean add(UmUserAddDTO request) throws Exception;
}
