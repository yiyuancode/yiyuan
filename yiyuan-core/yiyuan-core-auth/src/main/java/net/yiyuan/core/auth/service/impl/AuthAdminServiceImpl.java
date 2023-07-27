package net.yiyuan.core.auth.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.core.auth.dto.AuthAdminAddDTO;
import net.yiyuan.core.auth.dto.AuthAdminEditDTO;
import net.yiyuan.core.auth.dto.AuthAdminListDTO;
import net.yiyuan.core.auth.dto.AuthAdminPageDTO;
import net.yiyuan.core.auth.mapper.AuthAdminMapper;
import net.yiyuan.core.auth.model.AuthAdmin;
import net.yiyuan.core.auth.service.AuthAdminService;
import net.yiyuan.core.auth.vo.AuthAdminQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 用户管理Service层接口实现
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Slf4j
@Service
public class AuthAdminServiceImpl extends JoinServiceImpl<AuthAdminMapper, AuthAdmin> implements AuthAdminService {
    @Resource
    private AuthAdminMapper authAdminMapper;

    /**
     * 用户列表(全部)
     *
     * @param request 用户实体
     * @return {@link List< AuthAdminQueryVO >}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    @Override
    public List<AuthAdminQueryVO> list(AuthAdminListDTO request) throws Exception {

        AuthAdmin po = new AuthAdmin();
        BeanUtilsPlus.copy(request, po);
        JoinLambdaWrapper<AuthAdmin> wrapper = new JoinLambdaWrapper<>(po);
        List<AuthAdminQueryVO> voList = joinList(wrapper, AuthAdminQueryVO.class);

        return voList;
    }


    /**
     * 用户列表(分页)
     *
     * @param request 用户实体
     * @return {@link Page< AuthAdminQueryVO >}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    @Override
    public Page<AuthAdminQueryVO> page(AuthAdminPageDTO request) throws Exception {
        AuthAdmin po = new AuthAdmin();
        BeanUtilsPlus.copy(request, po);
        JoinLambdaWrapper<AuthAdmin> wrapper = new JoinLambdaWrapper<>(po);
        Page<AuthAdminQueryVO> voPage = joinPage(new Page<>(request.getPageNum(), request.getPageSize()), wrapper, AuthAdminQueryVO.class);
        return voPage;
    }


    /**
     * 用户详情
     *
     * @param id 用户id
     * @return {@link AuthAdminQueryVO}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    @Override
    public AuthAdminQueryVO details(String id) throws Exception {
        AuthAdmin po = new AuthAdmin();
        po.setId(id);
        JoinLambdaWrapper<AuthAdmin> wrapper = new JoinLambdaWrapper<>(po);
        AuthAdminQueryVO voBean = joinGetOne(wrapper, AuthAdminQueryVO.class);
        return voBean;
    }


    /**
     * 用户详情
     *
     * @param request 用户实体
     * @return {@link AuthAdmin}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    @Override
    public AuthAdminQueryVO details(AuthAdmin request) throws Exception {

        JoinLambdaWrapper<AuthAdmin> wrapper = new JoinLambdaWrapper<>(request);
        AuthAdminQueryVO voBean = joinGetOne(wrapper, AuthAdminQueryVO.class);
        return voBean;
    }


    /**
     * 删除用户(支持批量)
     *
     * @param ids 用户id(多个逗号分割)
     * @return {@link boolean}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */

    @Override
    public boolean delete(String ids) throws Exception {
        return removeByIds(Arrays.asList(ids.split("," )));
    }

    /**
     * 批量删除用户(根据同一属性,针对中间表)
     *
     * @param request 用户实体
     * @return {@link boolean}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */
    @Override
    public boolean delete(AuthAdmin request) throws Exception {
        JoinLambdaWrapper<AuthAdmin> wrapper = new JoinLambdaWrapper<>(request);
        return remove(wrapper);
    }

    /**
     * 编辑用户
     *
     * @param request 用户实体
     * @return {@link boolean}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */

    @Override
    public boolean edit(AuthAdminEditDTO request) throws Exception {
        AuthAdmin po = new AuthAdmin();
        BeanUtilsPlus.copy(request, po);
        JoinLambdaWrapper<AuthAdmin> wrapper = new JoinLambdaWrapper<>(po);
        return updateById(po);
    }


    /**
     * 新增用户
     *
     * @param request 用户实体
     * @return {@link boolean}
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */

    @Override
    public boolean add(AuthAdminAddDTO request) throws Exception {
        AuthAdmin po = new AuthAdmin();
        BeanUtilsPlus.copy(request, po);
        return save(po);

    }
}

