package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.PtmProductCategoryAddDTO;
import net.yiyuan.dto.PtmProductCategoryEditDTO;
import net.yiyuan.dto.PtmProductCategoryListDTO;
import net.yiyuan.dto.PtmProductCategoryPageDTO;
import net.yiyuan.model.PtmProductCategory;
import net.yiyuan.vo.PtmProductCategoryQueryVO;

import java.util.List;

/**
 * 商品分类Service层接口
 *
 * @author 一源-花和尚
 * @date 2023-10-06
 */
public interface PtmProductCategoryService extends JoinIService<PtmProductCategory> {

  /**
   * 商品分类列表(全部)
   *
   * @param request 商品分类实体
   * @return {@link List< PtmProductCategoryQueryVO >}
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  List<PtmProductCategoryQueryVO> list(PtmProductCategoryListDTO request) throws Exception;

  /**
   * 商品分类列表(分页)
   *
   * @param request 商品分类实体
   * @return {@link Page< PtmProductCategoryQueryVO >}
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  Page<PtmProductCategoryQueryVO> page(PtmProductCategoryPageDTO request) throws Exception;

  /**
   * 商品分类详情
   *
   * @param id 商品分类id
   * @return {@link PtmProductCategoryQueryVO}
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  PtmProductCategoryQueryVO details(String id) throws Exception;

  /**
   * 商品分类详情
   *
   * @param request 商品分类实体
   * @return {@link PtmProductCategory}
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  PtmProductCategoryQueryVO details(PtmProductCategory request) throws Exception;

  /**
   * 删除商品分类(支持批量)
   *
   * @param ids 商品分类id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑商品分类
   *
   * @param request 商品分类实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  boolean edit(PtmProductCategoryEditDTO request) throws Exception;

  /**
   * 新增商品分类
   *
   * @param request 商品分类实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  boolean add(PtmProductCategoryAddDTO request) throws Exception;
}
