package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.FtmFreightTempPriceAddDTO;
import net.yiyuan.dto.FtmFreightTempPriceEditDTO;
import net.yiyuan.dto.FtmFreightTempPriceListDTO;
import net.yiyuan.dto.FtmFreightTempPricePageDTO;
import net.yiyuan.model.FtmFreightTempPrice;
import net.yiyuan.vo.FtmFreightTempPriceQueryVO;

import java.util.List;

/**
 * 物流模板价格Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-11-04
 */
public interface FtmFreightTempPriceService extends JoinIService<FtmFreightTempPrice> {

  /**
   * 物流模板价格列表(全部)
   *
   * @param request 物流模板价格实体
   * @return {@link List< FtmFreightTempPriceQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  List<FtmFreightTempPriceQueryVO> list(FtmFreightTempPriceListDTO request) throws Exception;

  /**
   * 物流模板价格列表(分页)
   *
   * @param request 物流模板价格实体
   * @return {@link Page< FtmFreightTempPriceQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  Page<FtmFreightTempPriceQueryVO> page(FtmFreightTempPricePageDTO request) throws Exception;

  /**
   * 物流模板价格详情
   *
   * @param id 物流模板价格id
   * @return {@link FtmFreightTempPriceQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  FtmFreightTempPriceQueryVO details(String id) throws Exception;

  /**
   * 物流模板价格详情
   *
   * @param request 物流模板价格实体
   * @return {@link FtmFreightTempPrice}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  FtmFreightTempPriceQueryVO details(FtmFreightTempPrice request) throws Exception;

  /**
   * 删除物流模板价格(支持批量)
   *
   * @param ids 物流模板价格id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑物流模板价格
   *
   * @param request 物流模板价格实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  boolean edit(FtmFreightTempPriceEditDTO request) throws Exception;

  /**
   * 新增物流模板价格
   *
   * @param request 物流模板价格实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  boolean add(FtmFreightTempPriceAddDTO request) throws Exception;
}
