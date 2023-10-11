package net.yiyuan.service.impl;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.hutool.core.lang.ClassScanner;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import icu.mhb.mybatisplus.plugln.extend.Joins;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.SysMenuAddDTO;
import net.yiyuan.dto.SysMenuEditDTO;
import net.yiyuan.dto.SysMenuListDTO;
import net.yiyuan.dto.SysMenuPageDTO;
import net.yiyuan.enums.SysMenuTypeEnum;
import net.yiyuan.mapper.SysMenuMapper;
import net.yiyuan.mapper.SysRoleMapper;
import net.yiyuan.mapper.SysRoleMenuMapper;
import net.yiyuan.model.SysMenu;
import net.yiyuan.model.SysRole;
import net.yiyuan.model.SysRoleMenu;
import net.yiyuan.service.SysMenuService;
import net.yiyuan.vo.SysMenuQueryVO;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 菜单Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-26
 */
@Slf4j
@Service
public class SysMenuServiceImpl extends JoinServiceImpl<SysMenuMapper, SysMenu>
    implements SysMenuService {
  @Resource private SysMenuMapper sysMenuMapper;
  @Resource private SysRoleMapper sysRoleMapper;
  @Resource private SysRoleMenuMapper sysRoleMenuMapper;

  /**
   * 菜单列表(全部)
   *
   * @param request 菜单实体
   * @return {@link List< SysMenuQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @Override
  public List<SysMenuQueryVO> list(SysMenuListDTO request) throws Exception {

    SysMenu po = new SysMenu();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysMenu> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.orderByDesc(SysMenu::getSort);
    wrapper.orderByDesc(SysMenu::getCreateTime);
    List<SysMenuQueryVO> voList = sysMenuMapper.joinSelectList(wrapper, SysMenuQueryVO.class);

    return voList;
  }

  /**
   * 菜单列表(分页)
   *
   * @param request 菜单实体
   * @return {@link Page< SysMenuQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @Override
  public Page<SysMenuQueryVO> page(SysMenuPageDTO request) throws Exception {
    SysMenu po = new SysMenu();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysMenu> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.orderByDesc(SysMenu::getSort);
    wrapper.orderByDesc(SysMenu::getCreateTime);
    Page<SysMenuQueryVO> voPage =
        sysMenuMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()), wrapper, SysMenuQueryVO.class);
    return voPage;
  }

  /**
   * 菜单详情
   *
   * @param id 菜单id
   * @return {@link SysMenuQueryVO}
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @Override
  public SysMenuQueryVO details(String id) throws Exception {
    SysMenu po = new SysMenu();
    po.setId(id);
    JoinLambdaWrapper<SysMenu> wrapper = new JoinLambdaWrapper<>(po);
    SysMenuQueryVO voBean = sysMenuMapper.joinSelectOne(wrapper, SysMenuQueryVO.class);
    return voBean;
  }

  /**
   * 菜单详情
   *
   * @param request 菜单实体
   * @return {@link SysMenu}
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @Override
  public SysMenuQueryVO details(SysMenu request) throws Exception {
    JoinLambdaWrapper<SysMenu> wrapper = new JoinLambdaWrapper<>(request);
    SysMenuQueryVO voBean = sysMenuMapper.joinSelectOne(wrapper, SysMenuQueryVO.class);
    return voBean;
  }

  /**
   * 删除菜单(支持批量)
   *
   * @param ids 菜单id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    int i = sysMenuMapper.deleteBatchIds(idList);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑菜单
   *
   * @param request 菜单实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @Override
  public boolean edit(SysMenuEditDTO request) throws Exception {
    SysMenu po = new SysMenu();
    BeanUtilsPlus.copy(request, po);
    int i = sysMenuMapper.updateById(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增菜单
   *
   * @param request 菜单实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-26
   */
  @Override
  public boolean add(SysMenuAddDTO request) throws Exception {
    SysMenu po = new SysMenu();
    BeanUtilsPlus.copy(request, po);
    int i = sysMenuMapper.insert(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }

  /**
   * 自动生成菜单
   *
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public boolean autoScanMenu() throws Exception {

    String[] packageNames = {"net.yiyuan"};
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
            if (menuName.contains("文件管理")) {
              continue;
            }
            try {
              String btnPerm = permissions[0];
              String[] btnPermAarry = permissions[0].split(":");
              String[] menuNameAarry = menuName.split("/");
              SysMenuQueryVO moudelDetails = new SysMenuQueryVO();
              SysMenuQueryVO childMoudelDetails = new SysMenuQueryVO();
              // 如果是0 表示这个类第一次插入
              if (menuList.size() == 0) {
                // 查询大模块目录是否存在
                SysMenu sysMenuQuery = new SysMenu();
                sysMenuQuery.setName(btnPermAarry[0]);

                moudelDetails = this.details(sysMenuQuery);
                if (ObjectUtil.isEmpty(moudelDetails)) {
                  //                  sysMenuQuery.setName(menuNameAarry[0]);
                  sysMenuQuery.setTitle(menuNameAarry[0]);
                  sysMenuQuery.setName(btnPermAarry[0]);
                  sysMenuQuery.setType(SysMenuTypeEnum.CATALOGUE);
                  sysMenuQuery.setPid("0");
                  sysMenuQuery.setIsFrame(false);
                  sysMenuQuery.setIsCurWin(true);
                  sysMenuQuery.setSort(0);
                  sysMenuQuery.setComponent("/components/layout/Layout/index.vue");
                  sysMenuQuery.setPermission(btnPermAarry[0]);
                  this.save(sysMenuQuery);
                  moudelDetails = new SysMenuQueryVO();
                  BeanUtilsPlus.copy(sysMenuQuery, moudelDetails);
                }
                // 查询大模块目录是否存在
                sysMenuQuery = new SysMenu();
                sysMenuQuery.setName(btnPermAarry[1]);
                childMoudelDetails = this.details(sysMenuQuery);
                if (ObjectUtil.isEmpty(childMoudelDetails)) {
                  // sysMenuQuery.setName(menuNameAarry[1]);
                  sysMenuQuery.setTitle(menuNameAarry[1]);
                  sysMenuQuery.setName(btnPermAarry[1]);
                  sysMenuQuery.setType(SysMenuTypeEnum.MENU);
                  sysMenuQuery.setPid(moudelDetails.getId());
                  sysMenuQuery.setIsFrame(false);
                  sysMenuQuery.setIsCurWin(true);
                  sysMenuQuery.setSort(0);
                  sysMenuQuery.setComponent("/pages/" + btnPermAarry[0] + "/" + btnPermAarry[1]);
                  sysMenuQuery.setPermission(btnPermAarry[0] + ":" + btnPermAarry[1]);
                  this.save(sysMenuQuery);
                  childMoudelDetails = new SysMenuQueryVO();
                  BeanUtilsPlus.copy(sysMenuQuery, childMoudelDetails);
                }
              }
              // 查询按钮表达式是否存在
              SysMenu sysMenuQuery = new SysMenu();
              //              sysMenuQuery.setPermission(btnPerm);
              sysMenuQuery.setName(btnPermAarry[0] + ":" + btnPermAarry[1] + ":" + btnPermAarry[2]);
              SysMenuQueryVO btnDetails = this.details(sysMenuQuery);
              if (ObjectUtil.isEmpty(btnDetails)) {
                //                sysMenuQuery.setName(menuNameAarry[2]);
                sysMenuQuery.setTitle(menuNameAarry[2]);
                // 如果是按钮搞成和菜单一样
                sysMenuQuery.setName(
                    btnPermAarry[0] + ":" + btnPermAarry[1] + ":" + btnPermAarry[2]);
                sysMenuQuery.setType(SysMenuTypeEnum.BUTTON);
                sysMenuQuery.setPid(childMoudelDetails.getId());
                sysMenuQuery.setIsFrame(false);
                sysMenuQuery.setIsCurWin(true);
                sysMenuQuery.setSort(0);
                sysMenuQuery.setComponent("/pages/" + btnPermAarry[0] + "/" + btnPermAarry[1]);
                sysMenuQuery.setPermission(
                    btnPermAarry[0] + ":" + btnPermAarry[1] + ":" + btnPermAarry[2]);
                this.save(sysMenuQuery);
                btnDetails = new SysMenuQueryVO();
                BeanUtilsPlus.copy(sysMenuQuery, btnDetails);
              }

            } catch (Exception e) {

              e.printStackTrace();
              throw new Error("自动生成菜单异常");
            }
          }
        }
      }
    }

    // 给admin角色关联所有id
    SysRole sysRoleQuery = new SysRole();
    JoinLambdaWrapper<SysRole> sysRoleWrapper = Joins.of(SysRole.class);
    sysRoleWrapper.eq(SysRole::getCode, "admin");
    SysRole sysRoleResp = sysRoleMapper.joinSelectOne(sysRoleWrapper, SysRole.class);
    JoinLambdaWrapper<SysRoleMenu> sysRoleMenuJoinLambdaWrapper = Joins.of(SysRoleMenu.class);
    sysRoleMenuJoinLambdaWrapper.eq(SysRoleMenu::getSysRoleId, sysRoleResp.getId());
    sysRoleMenuMapper.delete(sysRoleMenuJoinLambdaWrapper);

    JoinLambdaWrapper<SysMenu> sysMenuJoinLambdaWrapper = Joins.of(SysMenu.class);
    List<SysMenu> sysMenuList =
        sysMenuMapper.joinSelectList(sysMenuJoinLambdaWrapper, SysMenu.class);
    sysMenuList.forEach(
        (item) -> {
          SysRoleMenu po = new SysRoleMenu();
          po.setSysMenuId(item.getId());
          po.setSysRoleId(sysRoleResp.getId());
          sysRoleMenuMapper.insert(po);
        });

    return true;
  }
}
