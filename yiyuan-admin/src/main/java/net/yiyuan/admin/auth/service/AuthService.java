package net.yiyuan.admin.auth.service;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.context.model.SaRequest;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.ClassScanner;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.admin.auth.model.get_user_info.GetUserInfoVo;
import net.yiyuan.admin.auth.model.get_user_info.SysMenuTreeVo;
import net.yiyuan.admin.auth.model.login.LoginReq;
import net.yiyuan.admin.auth.model.login.LoginVo;
import net.yiyuan.admin.auth.model.vo.GetUserInfoForAntdVo;
import net.yiyuan.admin.auth.model.vo.PermissionsForAntdVo;
import net.yiyuan.admin.auth.model.vo.SysMenuTreeForAntdVo;
import net.yiyuan.common.constatnt.ResultCode;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.common.utils.StringUtilsPlus;
import net.yiyuan.core.auth.enums.AuthAdminPlatformEnum;
import net.yiyuan.core.auth.model.AuthAdmin;
import net.yiyuan.core.auth.model.AuthAdminRole;
import net.yiyuan.core.auth.model.AuthRole;
import net.yiyuan.core.auth.model.AuthRoleMenu;
import net.yiyuan.core.auth.service.AuthAdminRoleService;
import net.yiyuan.core.auth.service.AuthAdminService;
import net.yiyuan.core.auth.service.AuthRoleMenuService;
import net.yiyuan.core.sys.enums.*;
import net.yiyuan.core.sys.model.SysMenu;
import net.yiyuan.core.sys.service.SysMenuService;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AuthService {
  @Resource AuthAdminService authAdminService;
  @Resource AuthAdminRoleService authAdminRoleService;
  @Resource AuthRoleMenuService authRoleMenuService;
  @Resource SysMenuService sysMenuService;
  @Resource private TransactionTemplate transactionTemplate;

  private static void printMenu(List<Map<String, Object>> menuList, String prefix) {
    for (Map<String, Object> menu : menuList) {
      System.out.println(prefix + menu.get("id"));
      List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) menu.get("subMenuList");
      if (subMenuList != null && !subMenuList.isEmpty()) {
        printMenu(subMenuList, prefix + "--");
      }
      List<String> operationList = (List<String>) menu.get("operation");
      if (operationList != null && !operationList.isEmpty()) {
        for (String operation : operationList) {
          System.out.println(prefix + "----" + operation);
        }
      }
    }
  }

  /**
   * 用户_角色列表(全部)
   *
   * @param request 用户_角色实体
   * @return {@link List}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  public LoginVo login(LoginReq request) throws Exception {
    SaRequest httpRequest = SaHolder.getRequest();
    // platform 平台区分 0 平台  1 租户 2 c端
    String platform = httpRequest.getHeader("platform");
    //    String tenantId = httpRequest.getHeader("tenantId");
    // 查询用户信息
    AuthAdmin query = new AuthAdmin();
    query.setUsername(request.getUsername());
    query.setPlatform(
        "0".equals(platform)
            ? AuthAdminPlatformEnum.NAME_AND_ADDRESS_OF_FLAT
            : AuthAdminPlatformEnum.THE_TENANT_SIDE);
    AuthAdmin details = authAdminService.details(query);
    // 用户不存在
    if (ObjectUtil.isNull(details)) {
      throw new BusinessException(ResultCode.USER_NOT_FIND);
    }
    // 密码错误
    if (!details.getPassword().equals(request.getPassword())) {
      throw new BusinessException(ResultCode.USER_ERROR);
    }
    // satoken登录
    StpUtil.login(details.getId());
    String tokenValue = StpUtil.getTokenValue();
    LoginVo result = new LoginVo();
    result.setToken(tokenValue);
    //    try {
    //
    //    } catch (Exception e) {
    //      // 当上面的方法发生异常时
    //      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    //      e.printStackTrace();
    //    }
    //    return CommonResult.success(authAdminService.list(request));
    return result;
  }

  /**
   * 用户_角色列表(全部)
   *
   * @param
   * @return {@link List}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  public void register() throws Exception {
    //    return CommonResult.success(authAdminService.list(request));
  }

  /**
   * 退出登录
   *
   * @return {@link CommonResult}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  public boolean loginout() throws Exception {
    StpUtil.logout();
    return true;
    //    return CommonResult.success(authAdminService.list(request));
  }

  /**
   * 获取当前登录用户信息,包括角色以及权限菜单
   *
   * @return {@link CommonResult}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  public GetUserInfoVo getUserInfo() throws Exception {
    String loginId = StpUtil.getLoginIdAsString();
    AuthAdmin adminQuery = new AuthAdmin();
    adminQuery.setId(loginId);
    AuthAdmin details = authAdminService.details(adminQuery);
    // 查询角色
    JoinLambdaWrapper<AuthAdminRole> wrapper = new JoinLambdaWrapper<>(AuthAdminRole.class);
    wrapper.eq(AuthAdminRole::getUserId, loginId);
    wrapper.select(AuthAdminRole::getRoleId);
    wrapper
        .leftJoin(AuthRole.class, AuthRole::getId, AuthAdminRole::getRoleId)
        .select(AuthRole::getId, AuthRole::getCode, AuthRole::getName)
        .end();

    List<AuthRole> authRoles = authAdminRoleService.joinList(wrapper, AuthRole.class);

    // 查询菜单
    List<String> authRolesIdsList =
        authRoles.stream().map(p -> p.getId()).collect(Collectors.toList());
    JoinLambdaWrapper<AuthRoleMenu> wrapper2 = new JoinLambdaWrapper<>(AuthRoleMenu.class);
    wrapper2.in(AuthRoleMenu::getRoleId, authRolesIdsList);
    wrapper2.leftJoin(SysMenu.class, SysMenu::getId, AuthRoleMenu::getMenuId).selectAll().end();
    List<SysMenu> sysMenus = authRoleMenuService.joinList(wrapper2, SysMenu.class);

    // 转成权限表达式数组
    List<String> permissionList =
        sysMenus.stream().map(p -> p.getPermission()).collect(Collectors.toList());

    // 菜单list获取树结构
    List<SysMenuTreeVo> voList = selectOrganizationTree(sysMenus);

    GetUserInfoVo result = new GetUserInfoVo();
    result.setUsername(details.getUsername());
    result.setMenuTreeVoList(voList);
    result.setPermList(permissionList);
    result.setRoleList(authRoles);
    return result;
  }

  /**
   * 获取当前登录用户信息,包括角色以及权限菜单(ForAntd)
   *
   * @return {@link CommonResult}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  public GetUserInfoForAntdVo getUserInfoForAntd() throws Exception {
    String loginId = StpUtil.getLoginIdAsString();
    AuthAdmin adminQuery = new AuthAdmin();
    adminQuery.setId(loginId);
    AuthAdmin details = authAdminService.details(adminQuery);
    // 查询角色
    JoinLambdaWrapper<AuthAdminRole> wrapper = new JoinLambdaWrapper<>(AuthAdminRole.class);
    wrapper.eq(AuthAdminRole::getUserId, loginId);
    wrapper.select(AuthAdminRole::getRoleId);
    wrapper
        .leftJoin(AuthRole.class, AuthRole::getId, AuthAdminRole::getRoleId)
        .select(AuthRole::getId, AuthRole::getCode, AuthRole::getName)
        .end();

    List<AuthRole> authRoles = authAdminRoleService.joinList(wrapper, AuthRole.class);
    if(StringUtilsPlus.isEmpty(authRoles)){
      throw new BusinessException(ResultCode.UNBOUND_ROLE);
    }
    // 转成antd前端所需要的角色数组格式
    List<AuthRole> authForAntdRoles =
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

    List<SysMenu> sysMenus = new ArrayList<>();
    // 如果没有admin角色才使用角色id关联查询菜单,如果包含admin直接查询所有菜单
    if (authRolesFilterList.size() == 0) {
      JoinLambdaWrapper<AuthRoleMenu> wrapper2 = new JoinLambdaWrapper<>(AuthRoleMenu.class);
      // 查询菜单
      List<String> authRolesIdsList =
          authRoles.stream().map(p -> p.getId()).collect(Collectors.toList());
      wrapper2.in(AuthRoleMenu::getRoleId, authRolesIdsList);
      wrapper2.leftJoin(SysMenu.class, SysMenu::getId, AuthRoleMenu::getMenuId).selectAll().end();
      sysMenus = authRoleMenuService.joinList(wrapper2, SysMenu.class);
      if(StringUtilsPlus.isEmpty(sysMenus)){
        throw new BusinessException(ResultCode.UNBOUND_MENU);
      }
    } else {
      sysMenus = sysMenuService.list(new SysMenu());
    }

    // 转成权限表达式数组
    List<String> permissionList =
        sysMenus.stream().map(p -> p.getPermission()).collect(Collectors.toList());
    log.info("permissionList{}", permissionList);
    // 转成antd前端所需要的表达式的格式
    List<PermissionsForAntdVo> permissionsForAntdVoList = convertPermissionList(permissionList);

    // 转成antd前端所需要的动态路由结构
    List<SysMenuTreeForAntdVo> voList = selectOrganizationTreeForAntd(sysMenus);

    SysMenuTreeForAntdVo root = new SysMenuTreeForAntdVo();
    root.setRouter("root");
    root.setChildren(voList);
    List<SysMenuTreeForAntdVo> asyncRoutesList = new ArrayList<>();
    asyncRoutesList.add(root);

    GetUserInfoForAntdVo result = new GetUserInfoForAntdVo();
    result.setUsername(details.getUsername());
    result.setAsyncRoutes(asyncRoutesList);
    result.setPermissions(permissionsForAntdVoList);
    result.setRoleList(authRoles);
    result.setRoleAntdList(authForAntdRoles);
    return result;
  }

  /**
   * 平台超管查询所有菜单(树结构)
   *
   * @return {@link List<SysMenuTreeVo>}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  public List<SysMenuTreeVo> adminGetMenuTree() throws Exception {
    List<SysMenu> list = sysMenuService.list(new SysMenu());
    // 菜单list获取树结构
    return selectOrganizationTree(list);
    //    return CommonResult.success(authAdminService.list(request));
  }

  /**
   * 平台超管查询所有菜单(树结构)
   *
   * @return {@link List<SysMenuTreeVo>}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  public List<SysMenuTreeVo> tenantGetMenuTree() throws Exception {
    GetUserInfoVo userInfo = getUserInfo();
    return userInfo.getMenuTreeVoList();
    //    return CommonResult.success(authAdminService.list(request));
  }

  /**
   * 自动生成菜单数据
   *
   * @return boolean
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  public boolean autoScanMenu() throws Exception {
    transactionTemplate.execute(
        status -> {
          String[] packageNames = {
            "net.yiyuan.core.auth.controller", "net.yiyuan.core.sys.controller"
          };
          Class<RestController> annotationClass = RestController.class;

          // 扫描指定包下标注了指定注解的类和方法
          Set<Class<?>> classes = new HashSet<>();
          for (String packageName : packageNames) {
            classes.addAll(ClassScanner.scanPackageByAnnotation(packageName, annotationClass));
          }
          //    Set<Class<?>> classes = ClassScanner.scanAllPackage();
          log.info("ClassUtil.classes", classes.size());
          // 定义存储菜单的列表

          // 遍历所有标注了 @SaCheckPermission 注解的类和方法
          for (Class<?> clazz : classes) {
            List<SysMenu> menuList = new ArrayList<>();

            log.info("classes", clazz);
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
              SaCheckPermission permission = method.getAnnotation(SaCheckPermission.class);
              if (permission != null) {
                // 获取权限表达式
                String[] permissions = permission.value();

                // 从注解中获取中文注释作为菜单名称
                String menuName2 = "";
                Description annotation = method.getAnnotation(Description.class);
                if (!ObjectUtil.isEmpty(annotation)) {
                  String menuName = annotation.value();
                  // menuName = (String) declaredMethod.invoke(permission);
                  //          menuName2 = description;

                  try {
                    String btnPerm = permissions[0];
                    String[] btnPermAarry = permissions[0].split(":");
                    String[] menuNameAarry = menuName.split("/");
                    SysMenu moudelDetails = new SysMenu();
                    SysMenu childMoudelDetails = new SysMenu();
                    // 如果是0 表示这个类第一次插入
                    if (menuList.size() == 0) {
                      // 查询大模块目录是否存在
                      SysMenu sysMenuQuery = new SysMenu();
                      sysMenuQuery.setPermission(btnPermAarry[0]);
                      moudelDetails = sysMenuService.details(sysMenuQuery);
                      if (ObjectUtil.isEmpty(moudelDetails)) {
                        sysMenuQuery.setName(menuNameAarry[0]);
                        sysMenuQuery.setType(SysMenuTypeEnum.DIRECTORY);
                        sysMenuQuery.setParentId("0");
                        sysMenuQuery.setIsFrame(SysMenuIsFrameEnum.NO);
                        sysMenuQuery.setIsAffix(SysMenuIsAffixEnum.SHUT_DOWN);
                        sysMenuQuery.setStatus(SysMenuStatusEnum.NORMAL);
                        sysMenuQuery.setIsAlwaysShow(SysMenuIsAlwaysShowEnum.OPEN);
                        sysMenuQuery.setOpenType(SysMenuOpenTypeEnum.THE_CURRENT_WINDOW);
                        sysMenuQuery.setSort(0);
                        sysMenuQuery.setRouteComponent("/layouts/BlankView.vue");
                        sysMenuQuery.setRouteName(btnPermAarry[0]);
                        sysMenuService.save(sysMenuQuery);
                        moudelDetails = new SysMenu();
                        BeanUtilsPlus.copy(sysMenuQuery, moudelDetails);
                      }
                      // 查询大模块目录是否存在
                      sysMenuQuery = new SysMenu();
                      sysMenuQuery.setPermission(btnPermAarry[0] + ":" + btnPermAarry[1]);
                      childMoudelDetails = sysMenuService.details(sysMenuQuery);
                      if (ObjectUtil.isEmpty(childMoudelDetails)) {
                        sysMenuQuery.setName(menuNameAarry[1]);
                        sysMenuQuery.setType(SysMenuTypeEnum.THE_MENU);
                        sysMenuQuery.setParentId(moudelDetails.getId());

                        sysMenuQuery.setIsFrame(SysMenuIsFrameEnum.NO);
                        sysMenuQuery.setIsAffix(SysMenuIsAffixEnum.SHUT_DOWN);
                        sysMenuQuery.setStatus(SysMenuStatusEnum.NORMAL);
                        sysMenuQuery.setIsAlwaysShow(SysMenuIsAlwaysShowEnum.OPEN);
                        sysMenuQuery.setOpenType(SysMenuOpenTypeEnum.THE_CURRENT_WINDOW);

                        sysMenuQuery.setSort(0);
                        sysMenuQuery.setRouteComponent(
                            "/pages/" + btnPermAarry[0] + "/" + btnPermAarry[1]);
                        sysMenuQuery.setRouteName(btnPermAarry[1]);
                        sysMenuService.save(sysMenuQuery);
                        childMoudelDetails = new SysMenu();
                        BeanUtilsPlus.copy(sysMenuQuery, childMoudelDetails);
                      }
                    }
                    // 查询按钮表达式是否存在
                    SysMenu sysMenuQuery = new SysMenu();
                    sysMenuQuery.setPermission(btnPerm);
                    SysMenu btnDetails = sysMenuService.details(sysMenuQuery);
                    if (ObjectUtil.isEmpty(btnDetails)) {
                      sysMenuQuery.setName(menuNameAarry[2]);
                      sysMenuQuery.setType(SysMenuTypeEnum.BUTTON);
                      sysMenuQuery.setParentId(childMoudelDetails.getId());
                      sysMenuQuery.setIsFrame(SysMenuIsFrameEnum.NO);
                      sysMenuQuery.setIsAffix(SysMenuIsAffixEnum.SHUT_DOWN);
                      sysMenuQuery.setStatus(SysMenuStatusEnum.NORMAL);
                      sysMenuQuery.setIsAlwaysShow(SysMenuIsAlwaysShowEnum.OPEN);
                      sysMenuQuery.setOpenType(SysMenuOpenTypeEnum.THE_CURRENT_WINDOW);

                      sysMenuQuery.setSort(0);
                      sysMenuQuery.setRouteComponent(null);
                      sysMenuQuery.setRouteName(null);
                      sysMenuService.save(sysMenuQuery);
                      btnDetails = new SysMenu();
                      BeanUtilsPlus.copy(sysMenuQuery, btnDetails);
                    }

                  } catch (Exception e) {
                    status.setRollbackOnly();
                    e.printStackTrace();
                    throw new Error("分配角色异常");
                  }
                }
              }
            }
          }

          return true;
        });

    return true;
  }

  public List<SysMenuTreeVo> selectOrganizationTree(List<SysMenu> list) {
    //    List<SysMenuTreeVo> voList = new ArrayList<>();
    //    List list1 = BeanUtilsPlus.copyToList(list, SysMenuTreeVo.class);
    List<SysMenuTreeVo> voList = BeanUtil.copyToList(list, SysMenuTreeVo.class);
    log.info("voList:{}", voList);
    // 操作所有组织机构数据
    Map<String, List<SysMenuTreeVo>> groupMap =
        voList.stream().collect(Collectors.groupingBy(SysMenuTreeVo::getParentId));

    log.info("groupMap:{}", groupMap);
    voList.forEach(
        organization -> {
          organization.setChildren(groupMap.get(organization.getId()));
        });
    log.info("groupMap:{}", groupMap);
    List<SysMenuTreeVo> collect =
        voList.stream()
            .filter(organization -> organization.getParentId().equals("0"))
            .collect(Collectors.toList());
    return collect;
  }

  public List<SysMenuTreeForAntdVo> selectOrganizationTreeForAntd(List<SysMenu> list) {
    //    List<SysMenuTreeVo> voList = new ArrayList<>();
    //    List list1 = BeanUtilsPlus.copyToList(list, SysMenuTreeVo.class);
    List<SysMenuTreeForAntdVo> voList =
        list.stream()
            // 过滤掉按钮数据
            .filter(source -> !StrUtil.isEmpty(source.getRouteName()))
            .map(
                source -> {
                  SysMenuTreeForAntdVo target = new SysMenuTreeForAntdVo();
                  BeanUtil.copyProperties(source, target);
                  target.setRouter(source.getRouteName());
                  return target;
                })
            .collect(Collectors.toList());

    log.info("voList:{}", voList);
    // 操作所有组织机构数据
    Map<String, List<SysMenuTreeForAntdVo>> groupMap =
        voList.stream().collect(Collectors.groupingBy(SysMenuTreeForAntdVo::getParentId));

    log.info("groupMap:{}", groupMap);
    voList.forEach(
        organization -> {
          organization.setChildren(groupMap.get(organization.getId()));
        });
    log.info("groupMap:{}", groupMap);
    List<SysMenuTreeForAntdVo> collect =
        voList.stream()
            .filter(organization -> organization.getParentId().equals("0"))
            .collect(Collectors.toList());
    collect.forEach(
        item -> {
          item.setId(null);
          item.setParentId(null);
        });
    return collect;
  }

  public List<PermissionsForAntdVo> convertPermissionList(List<String> permissions) {
    log.info("permissionList源数据:{}", permissions);
    // 将权限数据转换成菜单项列表
    List<PermissionsForAntdVo> result = new ArrayList<>();
    Map<String, PermissionsForAntdVo> secendMap = new HashMap<>();
    for (String permission : permissions) {
      log.info("permission.lastIndexOf{},{}", permission, permission.lastIndexOf(":"));
      if (permission.lastIndexOf(":") == -1) {
        PermissionsForAntdVo item = new PermissionsForAntdVo();
        item.setId(permission);
        result.add(item);
      }
      //      if (permission.lastIndexOf(":") == 1) {
      //        PermissionsForAntdVo permissionCur = secendMap.get(secendMap);
      //        if (ObjectUtil.isEmpty(permissionCur)) {
      //          PermissionsForAntdVo item = new PermissionsForAntdVo();
      //          item.setId(permission);
      //          item.setOperation(new ArrayList<>());
      //          secendMap.put(permission, item);
      //        }
      //      }
      if (permission.lastIndexOf(":") != permission.indexOf(":") && permission.indexOf(":") != -1) {
        String secendPermission = permission.substring(0, permission.lastIndexOf(":"));
        log.info("permission.secendPermission{},{}", secendPermission);

        PermissionsForAntdVo permissionCur = secendMap.get(secendPermission);
        if (ObjectUtil.isEmpty(permissionCur)) {
          PermissionsForAntdVo item = new PermissionsForAntdVo();
          item.setId(secendPermission);
          List<String> permList = new ArrayList<>();
          permList.add(permission);
          item.setOperation(permList);
          secendMap.put(secendPermission, item);
        } else {
          permissionCur.getOperation().add(permission);
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
