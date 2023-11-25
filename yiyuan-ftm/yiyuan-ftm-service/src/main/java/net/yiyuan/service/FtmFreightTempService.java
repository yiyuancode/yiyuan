package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.FtmFreightTempAddDTO;
import net.yiyuan.dto.FtmFreightTempEditDTO;
import net.yiyuan.dto.FtmFreightTempListDTO;
import net.yiyuan.dto.FtmFreightTempPageDTO;
import net.yiyuan.model.FtmFreightTemp;
import net.yiyuan.vo.FtmFreightTempQueryVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 物流模板Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-11-04
 */
public interface FtmFreightTempService extends JoinIService<FtmFreightTemp> {

  /**
   * 物流模板列表(全部)
   *
   * @param request 物流模板实体
   * @return {@link List< FtmFreightTempQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  List<FtmFreightTempQueryVO> list(FtmFreightTempListDTO request) throws Exception;

  /**
   * 物流模板列表(分页)
   *
   * @param request 物流模板实体
   * @return {@link Page< FtmFreightTempQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  Page<FtmFreightTempQueryVO> page(FtmFreightTempPageDTO request) throws Exception;

  /**
   * 物流模板详情
   *
   * @param id 物流模板id
   * @return {@link FtmFreightTempQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  FtmFreightTempQueryVO details(String id) throws Exception;

  /**
   * 物流模板详情
   *
   * @param request 物流模板实体
   * @return {@link FtmFreightTemp}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  FtmFreightTempQueryVO details(FtmFreightTemp request) throws Exception;

  /**
   * 删除物流模板(支持批量)
   *
   * @param ids 物流模板id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑物流模板
   *
   * @param request 物流模板实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  boolean edit(FtmFreightTempEditDTO request) throws Exception;

  /**
   * 新增物流模板
   *
   * @param request 物流模板实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-04
   */
  @Transactional
  boolean add(FtmFreightTempAddDTO request) throws Exception;
}
