package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.PtmProductBrandAddDTO;
import net.yiyuan.dto.PtmProductBrandEditDTO;
import net.yiyuan.dto.PtmProductBrandListDTO;
import net.yiyuan.dto.PtmProductBrandPageDTO;
import net.yiyuan.model.PtmProductBrand;
import net.yiyuan.vo.PtmProductBrandQueryVO;

import java.util.List;

/**
 * 品牌Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
public interface PtmProductBrandService extends JoinIService<PtmProductBrand> {

  /**
   * 品牌列表(全部)
   *
   * @param request 品牌实体
   * @return {@link List< PtmProductBrandQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  List<PtmProductBrandQueryVO> list(PtmProductBrandListDTO request) throws Exception;

  /**
   * 品牌列表(分页)
   *
   * @param request 品牌实体
   * @return {@link Page< PtmProductBrandQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  Page<PtmProductBrandQueryVO> page(PtmProductBrandPageDTO request) throws Exception;

  /**
   * 品牌详情
   *
   * @param id 品牌id
   * @return {@link PtmProductBrandQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  PtmProductBrandQueryVO details(String id) throws Exception;

  /**
   * 品牌详情
   *
   * @param request 品牌实体
   * @return {@link PtmProductBrand}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  PtmProductBrandQueryVO details(PtmProductBrand request) throws Exception;

  /**
   * 删除品牌(支持批量)
   *
   * @param ids 品牌id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑品牌
   *
   * @param request 品牌实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  boolean edit(PtmProductBrandEditDTO request) throws Exception;

  /**
   * 新增品牌
   *
   * @param request 品牌实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  boolean add(PtmProductBrandAddDTO request) throws Exception;
}
