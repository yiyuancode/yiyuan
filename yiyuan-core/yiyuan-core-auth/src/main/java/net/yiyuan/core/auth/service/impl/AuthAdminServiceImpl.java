package net.yiyuan.core.auth.service.impl;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.core.auth.dto.*;
import net.yiyuan.core.auth.mapper.AuthAdminMapper;
import net.yiyuan.core.auth.model.AuthAdmin;
import net.yiyuan.core.auth.model.AuthAdminRole;
import net.yiyuan.core.auth.model.AuthRole;
import net.yiyuan.core.auth.model.AuthRoleMenu;
import net.yiyuan.core.auth.service.AuthAdminRoleService;
import net.yiyuan.core.auth.service.AuthAdminService;
import net.yiyuan.core.auth.service.AuthRoleMenuService;
import net.yiyuan.core.auth.vo.AuthAdminQueryVO;
import net.yiyuan.core.sys.dto.SysMenuListDTO;
import net.yiyuan.core.sys.model.SysMenu;
import net.yiyuan.core.sys.service.SysMenuService;
import net.yiyuan.core.sys.vo.SysMenuQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

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
    @Resource
    private AuthAdminRoleService authAdminRoleService;
    @Resource
    AuthRoleMenuService authRoleMenuService;
    @Resource
    SysMenuService sysMenuService;

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

    @Override
    public AuthAdminQueryVO detailsEqual(AuthAdmin request) throws Exception {
        JoinLambdaWrapper<AuthAdmin> wrapper = new JoinLambdaWrapper<>(request);
        wrapper.eq(AuthAdmin::getUsername, request.getUsername());
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
        return removeByIds(Arrays.asList(ids.split(",")));
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

    @Override
    public boolean assignRole(AuthAdminAssignRoleDTO request) throws Exception {
        List<AuthAdminRole> addList = new ArrayList<>();
        List<String> rolesIdList = request.getRolesIdList();
        rolesIdList.forEach(
                (e) -> {
                    AuthAdminRole item = new AuthAdminRole();
                    item.setUserId(request.getUserId());
                    item.setRoleId(e);
                    addList.add(item);
                });

        // 先删除原来绑定的菜单id
        AuthAdminRole query = new AuthAdminRole();
        query.setRoleId(request.getUserId());
        authAdminRoleService.delete(query);
        // 在全量增加现在的
        authAdminRoleService.saveBatch(addList);

        return true;
    }

    @Override
    public AuthAdminQueryVO detailsJoinRoleAndPermission(String id) throws Exception {
//        AuthAdminQueryVO queryVO = this.details(id);
        AuthAdminQueryVO voResult = new AuthAdminQueryVO();

        // 查询角色
        JoinLambdaWrapper<AuthAdminRole> wrapper = new JoinLambdaWrapper<>(AuthAdminRole.class);
        wrapper.eq(AuthAdminRole::getUserId, id);
        wrapper.select(AuthAdminRole::getRoleId);
        wrapper
                .leftJoin(AuthRole.class, AuthRole::getId, AuthAdminRole::getRoleId)
                .select(AuthRole::getId, AuthRole::getCode, AuthRole::getName)
                .end();
        List<AuthRole> authRoles = authAdminRoleService.joinList(wrapper, AuthRole.class);

        // 转成antd前端所需要的角色数组格式
        List<AuthRole> roleList =
                authRoles.stream()
                        .map(
                                source -> {
                                    AuthRole target = new AuthRole();
                                    //                  BeanUtil.copyProperties(source, target);
                                    target.setId(source.getCode());
                                    return target;
                                })
                        .collect(Collectors.toList());

        // 查询角色编码是否包含admin
        List<AuthRole> authRolesFilterList =
                authRoles.stream()
                        // 过滤掉按钮数据
                        .filter(source -> StrUtil.equals(source.getCode(), "admin"))
                        .collect(Collectors.toList());
        List<SysMenuQueryVO> sysMenus = new ArrayList<>();
        if (authRolesFilterList.size() == 0) {
            //查询菜单
            List<String> authRolesIdsList =
                    authRoles.stream().map(p -> p.getId()).collect(Collectors.toList());
            JoinLambdaWrapper<AuthRoleMenu> wrapper2 = new JoinLambdaWrapper<>(AuthRoleMenu.class);
            wrapper2.in(AuthRoleMenu::getRoleId, authRolesIdsList);
            //主表不查询，不然id会错乱
            wrapper2.notDefaultSelectAll();
            wrapper2.leftJoin(SysMenu.class, SysMenu::getId, AuthRoleMenu::getMenuId).selectAll().end();
            sysMenus = authRoleMenuService.joinList(wrapper2, SysMenuQueryVO.class);

        } else {
            sysMenus = sysMenuService.list(new SysMenuListDTO());
        }

        // 转成权限表达式数组
        List<String> permissionList =
                sysMenus.stream().map(p -> p.getPermission()).collect(Collectors.toList());
        log.info("permissionList{}", permissionList);
        // 转成antd前端所需要的表达式的格式
        List<Map<String, Object>> permissionsList = convertPermissionList(permissionList);

        //菜单list转树结构
        //配置
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        treeNodeConfig.setIdKey("id");
        treeNodeConfig.setWeightKey("sort");
        treeNodeConfig.setParentIdKey("parentId");
        treeNodeConfig.setChildrenKey("children");

        //转换器 (含义:找出父节点为字符串零的所有子节点, 并递归查找对应的子节点, 深度最多为 3)
        List<Tree<String>> treeNodes = TreeUtil.build(sysMenus, "0", treeNodeConfig,
                (treeNode, tree) -> {
                    tree.setId(treeNode.getId());
                    tree.setParentId(treeNode.getParentId());
                    tree.setWeight(treeNode.getSort());
                    tree.setName(treeNode.getName());
                    // 扩展属性 ...
                    tree.putExtra("permission", treeNode.getPermission());
                    tree.putExtra("isFrame", treeNode.getIsFrame());
                    tree.putExtra("isAffix", treeNode.getIsAffix());
                    tree.putExtra("status", treeNode.getStatus());
                    tree.putExtra("isAlwaysShow", treeNode.getIsAlwaysShow());
                    tree.putExtra("isCache", treeNode.getIsCache());
                    tree.putExtra("type", treeNode.getType());
                    tree.putExtra("openType", treeNode.getOpenType());


                });

        voResult.setPermissionsList(permissionsList);
        voResult.setMenuTreeList(treeNodes);
        voResult.setRoleList(roleList);
        return voResult;
    }


    public List<Map<String, Object>> convertPermissionList(List<String> permissions) {
        log.info("permissionList源数据:{}", permissions);
        // 将权限数据转换成菜单项列表
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Map<String, Object>> secendMap = new HashMap<>();
        for (String permission : permissions) {
            log.info("permission.lastIndexOf{},{}", permission, permission.lastIndexOf(":"));
            if (permission.lastIndexOf(":") == -1) {
                Map<String, Object> item = new HashMap<>();
                item.put("id", permission);
                result.add(item);
            }
            if (permission.lastIndexOf(":") != permission.indexOf(":") && permission.indexOf(":") != -1) {
                String secendPermission = permission.substring(0, permission.lastIndexOf(":"));
                log.info("permission.secendPermission{},{}", secendPermission);

                Map<String, Object> permissionCur = secendMap.get(secendPermission);
                if (ObjectUtil.isEmpty(permissionCur)) {
                    Map<String, Object> item = new HashMap<>();
                    item.put("id", secendPermission);
                    List<String> permList = new ArrayList<>();
                    permList.add(permission);
                    item.put("operation", permList);
                    secendMap.put(secendPermission, item);
                } else {
                    List<String> newList = (List<String>) permissionCur.get("operation");
                    newList.add(permission);
                    secendMap.put(secendPermission, permissionCur);
                }
            }
        }
        secendMap
                .values()
                .forEach(
                        (item) -> {
                            result.add(item);
                        });

        // 打印菜单的层级结构
        log.info("printMenu{}", result);
        // 打印菜单的层级结构
        return result;
    }
}

