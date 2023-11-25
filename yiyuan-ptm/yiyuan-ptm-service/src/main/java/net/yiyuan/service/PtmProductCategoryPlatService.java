package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.PtmProductCategoryPlatAddDTO;
import net.yiyuan.dto.PtmProductCategoryPlatEditDTO;
import net.yiyuan.dto.PtmProductCategoryPlatListDTO;
import net.yiyuan.dto.PtmProductCategoryPlatPageDTO;
import net.yiyuan.model.PtmProductCategoryPlat;
import net.yiyuan.vo.PtmProductCategoryPlatQueryVO;

import java.util.List;

/**
 * 平台商品分类Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-11-19
 */
public interface PtmProductCategoryPlatService extends JoinIService<PtmProductCategoryPlat> {

  /**
   * 平台商品分类列表(全部)
   *
   * @param request 平台商品分类实体
   * @return {@link List< PtmProductCategoryPlatQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  List<PtmProductCategoryPlatQueryVO> list(PtmProductCategoryPlatListDTO request) throws Exception;

  /**
   * 平台商品分类列表(分页)
   *
   * @param request 平台商品分类实体
   * @return {@link Page< PtmProductCategoryPlatQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  Page<PtmProductCategoryPlatQueryVO> page(PtmProductCategoryPlatPageDTO request) throws Exception;

  /**
   * 平台商品分类详情
   *
   * @param id 平台商品分类id
   * @return {@link PtmProductCategoryPlatQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  PtmProductCategoryPlatQueryVO details(String id) throws Exception;

  /**
   * 平台商品分类详情
   *
   * @param request 平台商品分类实体
   * @return {@link PtmProductCategoryPlat}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  PtmProductCategoryPlatQueryVO details(PtmProductCategoryPlat request) throws Exception;

  /**
   * 删除平台商品分类(支持批量)
   *
   * @param ids 平台商品分类id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑平台商品分类
   *
   * @param request 平台商品分类实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  boolean edit(PtmProductCategoryPlatEditDTO request) throws Exception;

  /**
   * 新增平台商品分类
   *
   * @param request 平台商品分类实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-19
   */
  boolean add(PtmProductCategoryPlatAddDTO request) throws Exception;

  List<PtmProductCategoryPlatQueryVO> tree(PtmProductCategoryPlatListDTO request) throws Exception;
}
