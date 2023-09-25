package net.yiyuan.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.constatnt.ResultCode;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.common.utils.StringUtilsPlus;
import net.yiyuan.common.utils.TreeUtil;
import net.yiyuan.dto.*;
import net.yiyuan.mapper.*;
import net.yiyuan.model.*;
import net.yiyuan.plugins.mp.utils.CenterJoinUtils;
import net.yiyuan.redis.SysUserRedisService;
import net.yiyuan.service.SysUserService;
import net.yiyuan.vo.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 管理端用户Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Slf4j
@Service
public class SysUserServiceImpl extends JoinServiceImpl<SysUserMapper, SysUser>
    implements SysUserService {
  @Resource private SysUserMapper sysUserMapper;
  @Resource private SysUserRoleMapper sysUserRoleMapper;
  @Resource private SysRoleMapper sysRoleMapper;
  @Resource private SysMenuMapper sysMenuMapper;
  @Resource private SysRoleMenuMapper sysRoleMenuMapper;
  @Resource private SysUserRedisService sysUserRedisService;
  private CenterJoinUtils<SysUser, SysUserRole, SysRole, SysUserQueryVO> userRoleJoin;
  private CenterJoinUtils<SysRole, SysRoleMenu, SysMenu, SysRoleQueryVO> roleMenuJoin;

  /**
   * 管理端用户列表(全部)
   *
   * @param request 管理端用户实体
   * @return {@link List< SysUserQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public List<SysUserQueryVO> list(SysUserListDTO request) throws Exception {

    SysUser po = new SysUser();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysUser> wrapper = new JoinLambdaWrapper<>(po);
    List<SysUserQueryVO> voList = sysUserMapper.joinSelectList(wrapper, SysUserQueryVO.class);

    return voList;
  }

  /**
   * 管理端用户列表(分页)
   *
   * @param request 管理端用户实体
   * @return {@link Page< SysUserQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public Page<SysUserQueryVO> page(SysUserPageDTO request) throws Exception {
    SysUser po = new SysUser();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysUser> wrapper = new JoinLambdaWrapper<>(po);
    Page<SysUserQueryVO> voPage =
        sysUserMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()), wrapper, SysUserQueryVO.class);

    //    CenterJoinUtils<SysUserQueryVO, SysUser, SysUserRole, SysRole, SysRoleQueryVO>
    // centerJoinUtils =
    //        new CenterJoinUtils<>(
    //            voPage.getRecords(),
    //            SysUserQueryVO::getId,
    //            SysUser::getId,
    //            SysUserRole::getSysUserId,
    //            SysUserRole::getSysRoleId,
    //            SysRole::getId);
    //
    //    centerJoinUtils.joinList2(SysUserQueryVO::setRolesList);
    return voPage;
  }

  /**
   * 管理端用户详情
   *
   * @param id 管理端用户id
   * @return {@link SysUserQueryVO}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public SysUserQueryVO details(String id) throws Exception {
    SysUser po = new SysUser();
    po.setId(id);
    JoinLambdaWrapper<SysUser> wrapper = new JoinLambdaWrapper<>(po);
    SysUserQueryVO voBean = sysUserMapper.joinSelectOne(wrapper, SysUserQueryVO.class);
    return voBean;
  }

  /**
   * 管理端用户详情
   *
   * @param request 管理端用户实体
   * @return {@link SysUser}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public SysUserQueryVO details(SysUser request) throws Exception {
    JoinLambdaWrapper<SysUser> wrapper = new JoinLambdaWrapper<>(request);
    SysUserQueryVO voBean = sysUserMapper.joinSelectOne(wrapper, SysUserQueryVO.class);
    return voBean;
  }

  /**
   * 删除管理端用户(支持批量)
   *
   * @param ids 管理端用户id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    int i = sysUserMapper.deleteBatchIds(idList);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑管理端用户
   *
   * @param request 管理端用户实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean edit(SysUserEditDTO request) throws Exception {
    SysUser po = new SysUser();
    BeanUtilsPlus.copy(request, po);
    int i = sysUserMapper.updateById(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增管理端用户
   *
   * @param request 管理端用户实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean add(SysUserAddDTO request) throws Exception {
    SysUser po = new SysUser();
    BeanUtilsPlus.copy(request, po);
    int i = sysUserMapper.insert(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }

  @Override
  public SysUserLoginVO adminAccoutLogin(SysUserLoginDTO request) throws Exception {
    SysUser po = new SysUser();
    BeanUtilsPlus.copy(request, po);
    // 查询用户名是否存在
    JoinLambdaWrapper<SysUser> sysUserwrapper = new JoinLambdaWrapper<>(SysUser.class);
    sysUserwrapper.eq(SysUser::getUsername, request.getUsername());
    sysUserwrapper.eq(SysUser::getPlatform, request.getPlatform());
    SysUserQueryVO sysUserResp = sysUserMapper.joinSelectOne(sysUserwrapper, SysUserQueryVO.class);
    if (StringUtilsPlus.isNull(sysUserResp)) {
      throw new BusinessException(ResultCode.USER_NOT_FIND);
    }
    if (!sysUserResp.getPassword().equals(po.getPassword())) {
      throw new BusinessException(ResultCode.USER_PASS_ERROR);
    }
    // 使用用户id完成satoken登录,并返回token
    StpUtil.login(sysUserResp.getId());
    String loginIdAsString = sysUserResp.getId();
    SysUserLoginVO voBean = new SysUserLoginVO();
    voBean.setToken(StpUtil.getTokenValue());
    // 构造成list 调用
    userRoleJoin =
        new CenterJoinUtils<>(
            SysUser::getId,
            SysUserRole::getSysUserId,
            SysUserRole::getSysRoleId,
            SysRole::getId,
            sysUserResp,
            SysUserQueryVO::getId,
            SysUserQueryVO::setRolesList);

    // 缓存redisObjList ,查询用户信息给前端用
    sysUserRedisService.set(
        SysUserRedisService.KEY_SYS_USER_ROLE, loginIdAsString, sysUserResp.getRolesList(), null);

    // 获取关联表code编码字段缓存redis,作为satoken角色权限判断
    List<String> roleCodeList = userRoleJoin.getRightAnyFieldList(SysRole::getCode);
    // 缓存redis,用作satoken的接口角色权限拦截
    sysUserRedisService.set(
        SysUserRedisService.KEY_SYS_USER_ROLE_CODE, loginIdAsString, roleCodeList, null);
    // 判断当前角色编码是否包含admin角色编码，如果则查询角色_菜单时候主表的id加条件，如果不包含，就得查询当前拥有那些角色id
    List<String> roleIdList = new ArrayList<>();
    if (!roleCodeList.contains("admin")) {
      roleIdList = userRoleJoin.getRightAnyFieldList(SysRole::getId);
    }
    // 关联角色菜单权限表,查询对应权限表达式数据
    roleMenuJoin =
        new CenterJoinUtils<>(
            SysRole::getId,
            SysRoleMenu::getSysRoleId,
            SysRoleMenu::getSysMenuId,
            SysMenu::getId,
            roleIdList);
    List<String> menuPermissionList = roleMenuJoin.getRightAnyFieldList(SysMenu::getPermission);
    // 缓存权限表达式到redis，用作satoken的接口权限拦截
    sysUserRedisService.set(
        SysUserRedisService.KEY_SYS_USER_MENU_PERMISSION,
        loginIdAsString,
        menuPermissionList,
        null);

    // 缓存菜单对象list进去，支持树据结构缓存
    List<SysMenu> sysMenuList = roleMenuJoin.getRighList();
    List<SysMenuQueryVO> sysMenuVoList =
        BeanUtilsPlus.copyToList(sysMenuList, SysMenuQueryVO.class);
    List<SysMenuQueryVO> sysMenuTreeList =
        TreeUtil.buildTreeByTwoLayersFor(
            sysMenuVoList,
            SysMenuQueryVO::getId,
            SysMenuQueryVO::getParentId,
            SysMenuQueryVO::getChildren,
            "0");
    sysUserRedisService.set(
        SysUserRedisService.KEY_SYS_USER_MENU, loginIdAsString, sysMenuTreeList, null);

    // 缓存用户数据
    sysUserResp.setPassword(null);
    sysUserRedisService.set(
        SysUserRedisService.KEY_SYS_USER_ROLE, loginIdAsString, roleMenuJoin.getRighList(), null);
    return voBean;
  }

  @Override
  public SysUserGetUserInfoVO getUserInfo() throws Exception {
    SysUserGetUserInfoVO voResp = new SysUserGetUserInfoVO();
    String loginIdAsString = StpUtil.getLoginIdAsString();
    List<String> menuPermissionList =
        sysUserRedisService.getList(
            SysUserRedisService.KEY_SYS_USER_MENU_PERMISSION, loginIdAsString, String.class);

    // 获取缓存得菜单树结构数据，支持json转化
    List<SysMenuQueryVO> sysMenuList =
        sysUserRedisService.getList(
            SysUserRedisService.KEY_SYS_USER_MENU, loginIdAsString, SysMenuQueryVO.class);

    // 获取角色list
    List<SysRole> sysRoleList =
        sysUserRedisService.getList(
            SysUserRedisService.KEY_SYS_USER_ROLE, loginIdAsString, SysRole.class);

    // 获取用户数据
    SysUser sysUser =
        sysUserRedisService.get(SysUserRedisService.KEY_SYS_USER, loginIdAsString, SysUser.class);
    log.info("sysMenuList{}", sysMenuList);
    voResp.setMenuTreeList(sysMenuList);
    voResp.setPermissionsList(this.convertPermissionList(menuPermissionList));
    voResp.setUsername(sysUser.getUsername());
    voResp.setRoleList(sysRoleList);
    return voResp;
  }

  @Override
  public void excel(HttpServletResponse response) throws Exception {
    JoinLambdaWrapper<SysUser> wrapper = new JoinLambdaWrapper<>(SysUser.class);
    List<SysUserExcelVO> voList = sysUserMapper.joinSelectList(wrapper, SysUserExcelVO.class);
    //    wrapper.leftJoin(SysUserRole.class, SysUserRole::getSysRoleId, SysUserRole::getSysRoleId,
    // )
    //    wrapper.selectAs(SysUser::getUsername, SysUserExcelVO::getId);

    log.info("voList:{}", voList);
    //    Workbook workbook =
    //        ExcelExportUtil.exportExcel(new ExportParams("用户导出", "学生"), SysUserExcelVO.class,
    // voList);

    //    ExcelUtil.exportExcelX(voList, "测试导出表", "sheet1", SysUserExcelVO.class, "测试导出表.xlsx",
    // response);
    //    Workbook workbook =
    //        ExcelExportUtil.exportExcel(new ExportParams("物资库存信息", "物资"), SysUserExcelVO.class,
    // voList);
    //
    //    ServletOutputStream outputStream = response.getOutputStream();
    //    workbook.write(outputStream);
    response.setHeader("Content-Disposition", "attachment; filename=" + "用户信息统计File.xlsx");
    ExcelUtils.exportExcel(
        voList, "用户信息统计表Title", "用户表Sheet", SysUserExcelVO.class, "用户信息统计File", response);
  }

  /**
   * 将权限表达式转成antd要求格式式
   *
   * @param permissions 一维数组格式得前端表达式
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  public List<Map<String, Object>> convertPermissionList(List<String> permissions) {
    // 将权限数据转换成菜单项列表
    List<Map<String, Object>> result = new ArrayList<>();
    Map<String, Map<String, Object>> secendMap = new HashMap<>();
    for (String permission : permissions) {
      if (permission.lastIndexOf(":") == -1) {
        Map<String, Object> item = new HashMap<>();
        item.put("id", permission);
        result.add(item);
      }
      if (permission.lastIndexOf(":") != permission.indexOf(":") && permission.indexOf(":") != -1) {
        String secendPermission = permission.substring(0, permission.lastIndexOf(":"));
        Map<String, Object> permissionCur = secendMap.get(secendPermission);
        if (StringUtilsPlus.isEmpty(permissionCur)) {
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
    return result;
  }
}
