package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.PtmProductCategoryShopAddDTO;
import net.yiyuan.dto.PtmProductCategoryShopEditDTO;
import net.yiyuan.dto.PtmProductCategoryShopListDTO;
import net.yiyuan.dto.PtmProductCategoryShopPageDTO;
import net.yiyuan.model.PtmProductCategoryShop;
import net.yiyuan.vo.PtmProductCategoryShopQueryVO;

import java.util.List;

/**
 * 店铺商品分类Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-11-19
 */
public interface PtmProductCategoryShopService extends JoinIService<PtmProductCategoryShop> {

  /**
   * 店铺商品分类列表(全部)
   *
   * @param request 店铺商品分类实体
   * @return {@link List< PtmProductCategoryShopQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  List<PtmProductCategoryShopQueryVO> list(PtmProductCategoryShopListDTO request) throws Exception;

  /**
   * 店铺商品分类列表(分页)
   *
   * @param request 店铺商品分类实体
   * @return {@link Page< PtmProductCategoryShopQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  Page<PtmProductCategoryShopQueryVO> page(PtmProductCategoryShopPageDTO request) throws Exception;

  /**
   * 店铺商品分类详情
   *
   * @param id 店铺商品分类id
   * @return {@link PtmProductCategoryShopQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  PtmProductCategoryShopQueryVO details(String id) throws Exception;

  /**
   * 店铺商品分类详情
   *
   * @param request 店铺商品分类实体
   * @return {@link PtmProductCategoryShop}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  PtmProductCategoryShopQueryVO details(PtmProductCategoryShop request) throws Exception;

  /**
   * 删除店铺商品分类(支持批量)
   *
   * @param ids 店铺商品分类id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑店铺商品分类
   *
   * @param request 店铺商品分类实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  boolean edit(PtmProductCategoryShopEditDTO request) throws Exception;

  /**
   * 新增店铺商品分类
   *
   * @param request 店铺商品分类实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  boolean add(PtmProductCategoryShopAddDTO request) throws Exception;

  List<PtmProductCategoryShopQueryVO> tree(PtmProductCategoryShopListDTO request) throws Exception;
}
