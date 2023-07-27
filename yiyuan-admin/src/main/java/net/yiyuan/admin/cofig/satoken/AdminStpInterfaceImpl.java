package net.yiyuan.admin.cofig.satoken;

import cn.dev33.satoken.stp.StpInterface;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.core.auth.model.AuthAdminRole;
import net.yiyuan.core.auth.model.AuthRole;
import net.yiyuan.core.auth.model.AuthRoleMenu;
import net.yiyuan.core.auth.service.AuthAdminRoleService;
import net.yiyuan.core.auth.service.AuthAdminService;
import net.yiyuan.core.auth.service.AuthRoleMenuService;
import net.yiyuan.core.auth.service.AuthRoleService;
import net.yiyuan.core.sys.model.SysMenu;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * stp接口自定义权限验证接口扩展 保证此类被SpringBoot扫描，完成Sa-Token的对平台端和租户端的自定义权限验证扩展
 *
 * @author 一源团队-花和尚
 * @date 2023/06/23
 */
@Slf4j
@Component
public class AdminStpInterfaceImpl implements StpInterface {

    @Resource
    private AuthAdminService authAdminService;

    @Resource
    private AuthRoleService authRoleService;

    @Resource
    private AuthAdminRoleService authAdminRoleService;

    @Resource
    private AuthRoleMenuService authRoleMenuService;

    // 返回一个账号所拥有的权限码集合
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {

        // 1. 声明权限码集合
        List<String> permissionList = new ArrayList<>();
        List<String> roleList = getRoleList(loginId, loginType);
       

        // 包含平台管理员角色 不用查询权限表达式了
        if (roleList.contains("admin" )) {
            return permissionList;
        }

        // 从数据库查询这个角色所拥有的权限列表
        JoinLambdaWrapper<AuthAdminRole> wrapper = new JoinLambdaWrapper<>(AuthAdminRole.class);
        wrapper.eq(AuthAdminRole::getUserId, loginId);
        wrapper.select(AuthAdminRole::getRoleId);
        wrapper
                .leftJoin(AuthRole.class, AuthRole::getId, AuthAdminRole::getRoleId)
                .select(AuthRole::getId, AuthRole::getCode)
                .end();
        wrapper
                .leftJoin(AuthRoleMenu.class, AuthRoleMenu::getRoleId, AuthRole::getId)
                .select(AuthRoleMenu::getMenuId)
                .end();
        wrapper
                .leftJoin(SysMenu.class, SysMenu::getId, AuthRoleMenu::getMenuId)
                .select(SysMenu::getPermission)
                .end();
        List<SysMenu> roleMenuList = authAdminRoleService.joinList(wrapper, SysMenu.class);
        List<String> rolePermissionList =
                roleMenuList.stream().map(p -> p.getPermission()).collect(Collectors.toList());
        permissionList.addAll(rolePermissionList);
        log.info("登录账号所有权限:{}", permissionList);
        // 3. 返回权限码集合
        return permissionList;
    }

    // 返回一个账号所拥有的角色标识集合
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {

        JoinLambdaWrapper<AuthAdminRole> wrapper = new JoinLambdaWrapper<>(AuthAdminRole.class);
        wrapper.eq(AuthAdminRole::getUserId, loginId);
        wrapper
                .leftJoin(AuthRole.class, AuthRole::getId, AuthAdminRole::getRoleId)
                .select(AuthRole::getId, AuthRole::getCode)
                .end();
        List<AuthRole> authRoles = authAdminRoleService.joinList(wrapper, AuthRole.class);
        List<String> rolesCodeList =
                //        authRoles.stream().map(p -> p.getId() + "-" +
                // p.getCode()).collect(Collectors.toList());
                authRoles.stream().map(p -> p.getCode()).collect(Collectors.toList());
        //
        log.info("登录账号所有角色:{}", rolesCodeList);
        rolesCodeList.add("admin" );
        return rolesCodeList;
    }
}
