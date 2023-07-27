package net.yiyuan.core.sys.service.impl;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.hutool.core.lang.ClassScanner;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.core.sys.dto.SysMenuAddDTO;
import net.yiyuan.core.sys.dto.SysMenuEditDTO;
import net.yiyuan.core.sys.dto.SysMenuListDTO;
import net.yiyuan.core.sys.dto.SysMenuPageDTO;
import net.yiyuan.core.sys.enums.*;
import net.yiyuan.core.sys.mapper.SysMenuMapper;
import net.yiyuan.core.sys.model.SysMenu;
import net.yiyuan.core.sys.service.SysMenuService;
import net.yiyuan.core.sys.vo.SysMenuQueryVO;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 菜单管理Service层接口实现
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Slf4j
@Service
public class SysMenuServiceImpl extends JoinServiceImpl<SysMenuMapper, SysMenu>
    implements SysMenuService {
  @Resource private SysMenuMapper sysMenuMapper;

  /**
   * 菜单列表(全部)
   *
   * @param request 菜单实体
   * @return {@link List< SysMenuQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public List<SysMenuQueryVO> list(SysMenuListDTO request) throws Exception {

    SysMenu po = new SysMenu();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysMenu> wrapper = new JoinLambdaWrapper<>(po);
    List<SysMenuQueryVO> voList = joinList(wrapper, SysMenuQueryVO.class);

    return voList;
  }

  /**
   * 菜单列表(分页)
   *
   * @param request 菜单实体
   * @return {@link Page< SysMenuQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public Page<SysMenuQueryVO> page(SysMenuPageDTO request) throws Exception {
    SysMenu po = new SysMenu();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysMenu> wrapper = new JoinLambdaWrapper<>(po);
    Page<SysMenuQueryVO> voPage =
        joinPage(
            new Page<>(request.getPageNum(), request.getPageSize()), wrapper, SysMenuQueryVO.class);
    return voPage;
  }

  /**
   * 菜单详情
   *
   * @param id 菜单id
   * @return {@link SysMenuQueryVO}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public SysMenuQueryVO details(String id) throws Exception {
    SysMenu po = new SysMenu();
    po.setId(id);
    JoinLambdaWrapper<SysMenu> wrapper = new JoinLambdaWrapper<>(po);
    SysMenuQueryVO voBean = joinGetOne(wrapper, SysMenuQueryVO.class);
    return voBean;
  }

  /**
   * 菜单详情
   *
   * @param request 菜单实体
   * @return {@link SysMenu}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public SysMenuQueryVO details(SysMenu request) throws Exception {

    JoinLambdaWrapper<SysMenu> wrapper = new JoinLambdaWrapper<>(request);
    SysMenuQueryVO voBean = joinGetOne(wrapper, SysMenuQueryVO.class);
    return voBean;
  }

  @Override
  public SysMenuQueryVO detailsEqual(SysMenu request) throws Exception {
    JoinLambdaWrapper<SysMenu> wrapper = new JoinLambdaWrapper<>(request);
    wrapper.eq(SysMenu::getPermission, request.getPermission());
    SysMenuQueryVO voBean = joinGetOne(wrapper, SysMenuQueryVO.class);
    return voBean;
  }

  /**
   * 删除菜单(支持批量)
   *
   * @param ids 菜单id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public boolean delete(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids.split(",")));
  }

  /**
   * 批量删除菜单(根据同一属性,针对中间表)
   *
   * @param request 菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public boolean delete(SysMenu request) throws Exception {
    JoinLambdaWrapper<SysMenu> wrapper = new JoinLambdaWrapper<>(request);
    return remove(wrapper);
  }

  /**
   * 编辑菜单
   *
   * @param request 菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public boolean edit(SysMenuEditDTO request) throws Exception {
    SysMenu po = new SysMenu();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysMenu> wrapper = new JoinLambdaWrapper<>(po);
    return updateById(po);
  }

  /**
   * 新增菜单
   *
   * @param request 菜单实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public boolean add(SysMenuAddDTO request) throws Exception {
    SysMenu po = new SysMenu();
    BeanUtilsPlus.copy(request, po);
    return save(po);
  }

  /**
   * 新增菜单
   *
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  @Override
  public boolean autoScanMenu() throws Exception {

    String[] packageNames = {"net.yiyuan.core.auth.controller", "net.yiyuan.core.sys.controller"};
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
                sysMenuQuery.setPermission(btnPermAarry[0]);

                moudelDetails = this.detailsEqual(sysMenuQuery);
                if (ObjectUtil.isEmpty(moudelDetails)) {
                  sysMenuQuery.setName(menuNameAarry[0]);
                  sysMenuQuery.setType(SysMenuTypeEnum.CATALOGUE);
                  sysMenuQuery.setParentId("0");
                  sysMenuQuery.setIsFrame(SysMenuIsFrameEnum.NO);
                  sysMenuQuery.setIsAffix(SysMenuIsAffixEnum.CLOSE);
                  sysMenuQuery.setStatus(SysMenuStatusEnum.NORMAL);
                  sysMenuQuery.setIsAlwaysShow(SysMenuIsAlwaysShowEnum.OPEN);
                  sysMenuQuery.setOpenType(SysMenuOpenTypeEnum.CURRENT_WINDOW);
                  sysMenuQuery.setSort(0);
                  sysMenuQuery.setRouteComponent("/layouts/BlankView.vue");
                  sysMenuQuery.setRouteName(btnPermAarry[0]);
                  this.save(sysMenuQuery);
                  moudelDetails = new SysMenuQueryVO();
                  BeanUtilsPlus.copy(sysMenuQuery, moudelDetails);
                }
                // 查询大模块目录是否存在
                sysMenuQuery = new SysMenu();
                sysMenuQuery.setPermission(btnPermAarry[0] + ":" + btnPermAarry[1]);
                childMoudelDetails = this.detailsEqual(sysMenuQuery);
                if (ObjectUtil.isEmpty(childMoudelDetails)) {
                  sysMenuQuery.setName(menuNameAarry[1]);
                  sysMenuQuery.setType(SysMenuTypeEnum.MENU);
                  sysMenuQuery.setParentId(moudelDetails.getId());

                  sysMenuQuery.setIsFrame(SysMenuIsFrameEnum.NO);
                  sysMenuQuery.setIsAffix(SysMenuIsAffixEnum.CLOSE);
                  sysMenuQuery.setStatus(SysMenuStatusEnum.NORMAL);
                  sysMenuQuery.setIsAlwaysShow(SysMenuIsAlwaysShowEnum.OPEN);
                  sysMenuQuery.setOpenType(SysMenuOpenTypeEnum.CURRENT_WINDOW);

                  sysMenuQuery.setSort(0);
                  sysMenuQuery.setRouteComponent(
                      "/pages/" + btnPermAarry[0] + "/" + btnPermAarry[1]);
                  sysMenuQuery.setRouteName(btnPermAarry[1]);
                  this.save(sysMenuQuery);
                  childMoudelDetails = new SysMenuQueryVO();
                  BeanUtilsPlus.copy(sysMenuQuery, childMoudelDetails);
                }
              }
              // 查询按钮表达式是否存在
              SysMenu sysMenuQuery = new SysMenu();
              sysMenuQuery.setPermission(btnPerm);
              SysMenuQueryVO btnDetails = this.detailsEqual(sysMenuQuery);
              if (ObjectUtil.isEmpty(btnDetails)) {
                sysMenuQuery.setName(menuNameAarry[2]);
                sysMenuQuery.setType(SysMenuTypeEnum.BUTTON);
                sysMenuQuery.setParentId(childMoudelDetails.getId());
                sysMenuQuery.setIsFrame(SysMenuIsFrameEnum.NO);
                sysMenuQuery.setIsAffix(SysMenuIsAffixEnum.CLOSE);
                sysMenuQuery.setStatus(SysMenuStatusEnum.NORMAL);
                sysMenuQuery.setIsAlwaysShow(SysMenuIsAlwaysShowEnum.OPEN);
                sysMenuQuery.setOpenType(SysMenuOpenTypeEnum.CURRENT_WINDOW);

                sysMenuQuery.setSort(0);
                sysMenuQuery.setRouteComponent(null);
                sysMenuQuery.setRouteName(null);
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

    return true;
  }
}
