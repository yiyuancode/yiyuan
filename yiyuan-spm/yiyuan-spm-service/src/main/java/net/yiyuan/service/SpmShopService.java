package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.SpmShopAddDTO;
import net.yiyuan.dto.SpmShopEditDTO;
import net.yiyuan.dto.SpmShopListDTO;
import net.yiyuan.dto.SpmShopPageDTO;
import net.yiyuan.model.SpmShop;
import net.yiyuan.vo.SpmShopQueryVO;

import java.util.List;

/**
 * 店铺Service层接口
 *
 * @author 一源-花和尚
 * @date 2023-10-06
 */
public interface SpmShopService extends JoinIService<SpmShop> {

  /**
   * 店铺列表(全部)
   *
   * @param request 店铺实体
   * @return {@link List< SpmShopQueryVO >}
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  List<SpmShopQueryVO> list(SpmShopListDTO request) throws Exception;

  /**
   * 店铺列表(分页)
   *
   * @param request 店铺实体
   * @return {@link Page< SpmShopQueryVO >}
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  Page<SpmShopQueryVO> page(SpmShopPageDTO request) throws Exception;

  /**
   * 店铺详情
   *
   * @param id 店铺id
   * @return {@link SpmShopQueryVO}
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  SpmShopQueryVO details(String id) throws Exception;

  /**
   * 店铺详情
   *
   * @param request 店铺实体
   * @return {@link SpmShop}
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  SpmShopQueryVO details(SpmShop request) throws Exception;

  /**
   * 删除店铺(支持批量)
   *
   * @param ids 店铺id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑店铺
   *
   * @param request 店铺实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  boolean edit(SpmShopEditDTO request) throws Exception;

  /**
   * 新增店铺
   *
   * @param request 店铺实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-10-06
   */
  boolean add(SpmShopAddDTO request) throws Exception;
}
