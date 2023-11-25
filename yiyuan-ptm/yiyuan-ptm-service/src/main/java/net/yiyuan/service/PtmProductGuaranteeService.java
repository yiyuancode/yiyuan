package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.PtmProductGuaranteeAddDTO;
import net.yiyuan.dto.PtmProductGuaranteeEditDTO;
import net.yiyuan.dto.PtmProductGuaranteeListDTO;
import net.yiyuan.dto.PtmProductGuaranteePageDTO;
import net.yiyuan.model.PtmProductGuarantee;
import net.yiyuan.vo.PtmProductGuaranteeQueryVO;

import java.util.List;

/**
 * 保障服务Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-11-09
 */
public interface PtmProductGuaranteeService extends JoinIService<PtmProductGuarantee> {

  /**
   * 保障服务列表(全部)
   *
   * @param request 保障服务实体
   * @return {@link List< PtmProductGuaranteeQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  List<PtmProductGuaranteeQueryVO> list(PtmProductGuaranteeListDTO request) throws Exception;

  /**
   * 保障服务列表(分页)
   *
   * @param request 保障服务实体
   * @return {@link Page< PtmProductGuaranteeQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  Page<PtmProductGuaranteeQueryVO> page(PtmProductGuaranteePageDTO request) throws Exception;

  /**
   * 保障服务详情
   *
   * @param id 保障服务id
   * @return {@link PtmProductGuaranteeQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  PtmProductGuaranteeQueryVO details(String id) throws Exception;

  /**
   * 保障服务详情
   *
   * @param request 保障服务实体
   * @return {@link PtmProductGuarantee}
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  PtmProductGuaranteeQueryVO details(PtmProductGuarantee request) throws Exception;

  /**
   * 删除保障服务(支持批量)
   *
   * @param ids 保障服务id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑保障服务
   *
   * @param request 保障服务实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  boolean edit(PtmProductGuaranteeEditDTO request) throws Exception;

  /**
   * 新增保障服务
   *
   * @param request 保障服务实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-11-09
   */
  boolean add(PtmProductGuaranteeAddDTO request) throws Exception;
}
