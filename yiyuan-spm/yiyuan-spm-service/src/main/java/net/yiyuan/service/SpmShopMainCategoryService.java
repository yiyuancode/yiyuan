package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.SpmShopMainCategoryAddDTO;
import net.yiyuan.dto.SpmShopMainCategoryEditDTO;
import net.yiyuan.dto.SpmShopMainCategoryListDTO;
import net.yiyuan.dto.SpmShopMainCategoryPageDTO;
import net.yiyuan.model.SpmShopMainCategory;
import net.yiyuan.vo.SpmShopMainCategoryQueryVO;

import java.util.List;

/**
 * 店铺主营类目Service层接口
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
public interface SpmShopMainCategoryService extends JoinIService<SpmShopMainCategory> {

  /**
   * 店铺主营类目列表(全部)
   *
   * @param request 店铺主营类目实体
   * @return {@link List< SpmShopMainCategoryQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  List<SpmShopMainCategoryQueryVO> list(SpmShopMainCategoryListDTO request) throws Exception;

  /**
   * 店铺主营类目列表(分页)
   *
   * @param request 店铺主营类目实体
   * @return {@link Page< SpmShopMainCategoryQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  Page<SpmShopMainCategoryQueryVO> page(SpmShopMainCategoryPageDTO request) throws Exception;

  /**
   * 店铺主营类目详情
   *
   * @param id 店铺主营类目id
   * @return {@link SpmShopMainCategoryQueryVO}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  SpmShopMainCategoryQueryVO details(String id) throws Exception;

  /**
   * 店铺主营类目详情
   *
   * @param request 店铺主营类目实体
   * @return {@link SpmShopMainCategory}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  SpmShopMainCategoryQueryVO details(SpmShopMainCategory request) throws Exception;

  /**
   * 删除店铺主营类目(支持批量)
   *
   * @param ids 店铺主营类目id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑店铺主营类目
   *
   * @param request 店铺主营类目实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  boolean edit(SpmShopMainCategoryEditDTO request) throws Exception;

  /**
   * 新增店铺主营类目
   *
   * @param request 店铺主营类目实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  boolean add(SpmShopMainCategoryAddDTO request) throws Exception;
}
