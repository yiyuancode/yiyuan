package net.yiyuan.tenant.cofig.satoken;

import cn.dev33.satoken.stp.StpInterface;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.service.AuthAdminRoleService;
import net.yiyuan.service.AuthAdminService;
import net.yiyuan.service.AuthRoleMenuService;
import net.yiyuan.service.AuthRoleService;
import net.yiyuan.tenant.redis.TenantRedisService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * stp接口自定义权限验证接口扩展 保证此类被SpringBoot扫描，完成Sa-Token的对平台端和租户端的自定义权限验证扩展
 *
 * @author 一源团队-花和尚
 * @date 2023/06/23
 */
@Slf4j
@Component
public class AdminStpInterfaceImpl implements StpInterface {

  @Resource private AuthAdminService authAdminService;

  @Resource private AuthRoleService authRoleService;

  @Resource private AuthAdminRoleService authAdminRoleService;

  @Resource private AuthRoleMenuService authRoleMenuService;

  @Resource private TenantRedisService tenantRedisService;

  // 返回一个账号所拥有的权限码集合
  @Override
  public List<String> getPermissionList(Object loginId, String loginType) {

    // 1. 声明权限码集合
    List<String> permissionList = tenantRedisService.GET_TENANT_USER_PERMISSION((String) loginId);

    log.info("登录账号所有权限:{}", permissionList);
    // 3. 返回权限码集合
    return permissionList;
  }

  // 返回一个账号所拥有的角色标识集合
  @Override
  public List<String> getRoleList(Object loginId, String loginType) {
    List<String> rolesCodeList = tenantRedisService.GET_TENANT_USER_ROLE((String) loginId);
    //
    log.info("登录账号所有角色:{}", rolesCodeList);
    //        rolesCodeList.add("admin" );
    return rolesCodeList;
  }
}
