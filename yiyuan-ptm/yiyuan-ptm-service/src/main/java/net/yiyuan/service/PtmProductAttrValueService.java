package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.PtmProductAttrValueAddDTO;
import net.yiyuan.dto.PtmProductAttrValueEditDTO;
import net.yiyuan.dto.PtmProductAttrValueListDTO;
import net.yiyuan.dto.PtmProductAttrValuePageDTO;
import net.yiyuan.model.PtmProductAttrValue;
import net.yiyuan.vo.PtmProductAttrValueQueryVO;

import java.util.List;

/**
 * 商品属性valueService层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
public interface PtmProductAttrValueService extends JoinIService<PtmProductAttrValue> {

  /**
   * 商品属性value列表(全部)
   *
   * @param request 商品属性value实体
   * @return {@link List< PtmProductAttrValueQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  List<PtmProductAttrValueQueryVO> list(PtmProductAttrValueListDTO request) throws Exception;

  /**
   * 商品属性value列表(分页)
   *
   * @param request 商品属性value实体
   * @return {@link Page< PtmProductAttrValueQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  Page<PtmProductAttrValueQueryVO> page(PtmProductAttrValuePageDTO request) throws Exception;

  /**
   * 商品属性value详情
   *
   * @param id 商品属性valueid
   * @return {@link PtmProductAttrValueQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  PtmProductAttrValueQueryVO details(String id) throws Exception;

  /**
   * 商品属性value详情
   *
   * @param request 商品属性value实体
   * @return {@link PtmProductAttrValue}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  PtmProductAttrValueQueryVO details(PtmProductAttrValue request) throws Exception;

  /**
   * 删除商品属性value(支持批量)
   *
   * @param ids 商品属性valueid(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑商品属性value
   *
   * @param request 商品属性value实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  boolean edit(PtmProductAttrValueEditDTO request) throws Exception;

  /**
   * 新增商品属性value
   *
   * @param request 商品属性value实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  boolean add(PtmProductAttrValueAddDTO request) throws Exception;
}
