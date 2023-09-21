package net.yiyuan.admin.cofig.satoken;

import cn.dev33.satoken.stp.StpInterface;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.redis.SysUserRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
  @Autowired private SysUserRedisService sysUserRedisService;

  // 返回一个账号所拥有的权限码集合
  @Override
  public List<String> getPermissionList(Object loginId, String loginType) {
    // 1. 声明权限码集合
    List<String> permissionList =
        sysUserRedisService.getList(
            SysUserRedisService.KEY_SYS_USER_PERMISSION, (String) loginId, String.class);
    log.info("登录账号所有权限:{}", permissionList);
    // 3. 返回权限码集合
    return permissionList;
  }

  // 返回一个账号所拥有的角色标识集合
  @Override
  public List<String> getRoleList(Object loginId, String loginType) {
    List<String> rolesCodeList =
        sysUserRedisService.getList(
            SysUserRedisService.KEY_SYS_USER_ROLE, (String) loginId, String.class);
    log.info("登录账号所有角色:{}", rolesCodeList);
    return rolesCodeList;
  }
}
