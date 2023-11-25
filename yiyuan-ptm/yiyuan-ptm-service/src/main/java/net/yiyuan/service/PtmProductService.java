package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.*;
import net.yiyuan.model.PtmProduct;
import net.yiyuan.vo.PtmProductQueryVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品信息Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
public interface PtmProductService extends JoinIService<PtmProduct> {

  /**
   * 商品信息列表(全部)
   *
   * @param request 商品信息实体
   * @return {@link List< PtmProductQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  List<PtmProductQueryVO> list(PtmProductListDTO request) throws Exception;

  /**
   * 商品信息列表(分页)
   *
   * @param request 商品信息实体
   * @return {@link Page< PtmProductQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  Page<PtmProductQueryVO> page(PtmProductPageDTO request) throws Exception;

  /**
   * 商品信息详情
   *
   * @param id 商品信息id
   * @return {@link PtmProductQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  PtmProductQueryVO details(String id) throws Exception;

  /**
   * 商品信息详情
   *
   * @param request 商品信息实体
   * @return {@link PtmProduct}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  PtmProductQueryVO details(PtmProduct request) throws Exception;

  /**
   * 删除商品信息(支持批量)
   *
   * @param ids 商品信息id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑商品信息
   *
   * @param request 商品信息实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Transactional
  boolean edit(PtmProductEditDTO request) throws Exception;

  /**
   * 新增商品信息
   *
   * @param request 商品信息实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Transactional
  boolean add(PtmProductAddDTO request) throws Exception;

  /**
   * 商品审核
   *
   * @param request 商品审核实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @Transactional
  boolean audit(PtmProductAuditDTO request) throws Exception;
}
