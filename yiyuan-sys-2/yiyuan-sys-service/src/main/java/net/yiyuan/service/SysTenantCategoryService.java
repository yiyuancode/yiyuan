package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.SysTenantCategoryAddDTO;
import net.yiyuan.dto.SysTenantCategoryEditDTO;
import net.yiyuan.dto.SysTenantCategoryListDTO;
import net.yiyuan.dto.SysTenantCategoryPageDTO;
import net.yiyuan.model.SysTenantCategory;
import net.yiyuan.vo.SysTenantCategoryQueryVO;

import java.util.List;

/**
 * 租户店铺分类Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
public interface SysTenantCategoryService extends JoinIService<SysTenantCategory> {

  /**
   * 租户店铺分类列表(全部)
   *
   * @param request 租户店铺分类实体
   * @return {@link List< SysTenantCategoryQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  List<SysTenantCategoryQueryVO> list(SysTenantCategoryListDTO request) throws Exception;

  /**
   * 租户店铺分类列表(分页)
   *
   * @param request 租户店铺分类实体
   * @return {@link Page< SysTenantCategoryQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  Page<SysTenantCategoryQueryVO> page(SysTenantCategoryPageDTO request) throws Exception;

  /**
   * 租户店铺分类详情
   *
   * @param id 租户店铺分类id
   * @return {@link SysTenantCategoryQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  SysTenantCategoryQueryVO details(String id) throws Exception;

  /**
   * 租户店铺分类详情
   *
   * @param request 租户店铺分类实体
   * @return {@link SysTenantCategory}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  SysTenantCategoryQueryVO details(SysTenantCategory request) throws Exception;

  /**
   * 删除租户店铺分类(支持批量)
   *
   * @param ids 租户店铺分类id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑租户店铺分类
   *
   * @param request 租户店铺分类实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  boolean edit(SysTenantCategoryEditDTO request) throws Exception;

  /**
   * 新增租户店铺分类
   *
   * @param request 租户店铺分类实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  boolean add(SysTenantCategoryAddDTO request) throws Exception;
}
