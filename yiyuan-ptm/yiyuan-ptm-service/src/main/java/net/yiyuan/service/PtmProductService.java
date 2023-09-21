package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.PtmProductAddDTO;
import net.yiyuan.dto.PtmProductEditDTO;
import net.yiyuan.dto.PtmProductListDTO;
import net.yiyuan.dto.PtmProductPageDTO;
import net.yiyuan.model.PtmProduct;
import net.yiyuan.vo.PtmProductQueryVO;

import java.util.List;

/**
 * 商品Service层接口
 *
 * @author 一源-花和尚
 * @date 2023-09-21
 */
public interface PtmProductService extends JoinIService<PtmProduct> {

  /**
   * 商品列表(全部)
   *
   * @param request 商品实体
   * @return {@link List< PtmProductQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-21
   */
  List<PtmProductQueryVO> list(PtmProductListDTO request) throws Exception;

  /**
   * 商品列表(分页)
   *
   * @param request 商品实体
   * @return {@link Page< PtmProductQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-21
   */
  Page<PtmProductQueryVO> page(PtmProductPageDTO request) throws Exception;

  /**
   * 商品详情
   *
   * @param id 商品id
   * @return {@link PtmProductQueryVO}
   * @author 一源-花和尚
   * @date 2023-09-21
   */
  PtmProductQueryVO details(String id) throws Exception;

  /**
   * 商品详情
   *
   * @param request 商品实体
   * @return {@link PtmProduct}
   * @author 一源-花和尚
   * @date 2023-09-21
   */
  PtmProductQueryVO details(PtmProduct request) throws Exception;

  /**
   * 删除商品(支持批量)
   *
   * @param ids 商品id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-21
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑商品
   *
   * @param request 商品实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-21
   */
  boolean edit(PtmProductEditDTO request) throws Exception;

  /**
   * 新增商品
   *
   * @param request 商品实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-21
   */
  boolean add(PtmProductAddDTO request) throws Exception;
}
