package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.SpmShopTypeAddDTO;
import net.yiyuan.dto.SpmShopTypeEditDTO;
import net.yiyuan.dto.SpmShopTypeListDTO;
import net.yiyuan.dto.SpmShopTypePageDTO;
import net.yiyuan.model.SpmShopType;
import net.yiyuan.vo.SpmShopTypeQueryVO;

import java.util.List;

/**
 * 店铺类型Service层接口
 *
 * @author 一源-花和尚
 * @date 2023-09-22
 */
public interface SpmShopTypeService extends JoinIService<SpmShopType> {

  /**
   * 店铺类型列表(全部)
   *
   * @param request 店铺类型实体
   * @return {@link List< SpmShopTypeQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  List<SpmShopTypeQueryVO> list(SpmShopTypeListDTO request) throws Exception;

  /**
   * 店铺类型列表(分页)
   *
   * @param request 店铺类型实体
   * @return {@link Page< SpmShopTypeQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  Page<SpmShopTypeQueryVO> page(SpmShopTypePageDTO request) throws Exception;

  /**
   * 店铺类型详情
   *
   * @param id 店铺类型id
   * @return {@link SpmShopTypeQueryVO}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  SpmShopTypeQueryVO details(String id) throws Exception;

  /**
   * 店铺类型详情
   *
   * @param request 店铺类型实体
   * @return {@link SpmShopType}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  SpmShopTypeQueryVO details(SpmShopType request) throws Exception;

  /**
   * 删除店铺类型(支持批量)
   *
   * @param ids 店铺类型id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑店铺类型
   *
   * @param request 店铺类型实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  boolean edit(SpmShopTypeEditDTO request) throws Exception;

  /**
   * 新增店铺类型
   *
   * @param request 店铺类型实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-22
   */
  boolean add(SpmShopTypeAddDTO request) throws Exception;
}
