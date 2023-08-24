package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.SysTenantTypeAddDTO;
import net.yiyuan.dto.SysTenantTypeEditDTO;
import net.yiyuan.dto.SysTenantTypeListDTO;
import net.yiyuan.dto.SysTenantTypePageDTO;
import net.yiyuan.model.SysTenantType;
import net.yiyuan.vo.SysTenantTypeQueryVO;

import java.util.List;

/**
 * 租户类型Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
public interface SysTenantTypeService extends JoinIService<SysTenantType> {

  /**
   * 租户类型列表(全部)
   *
   * @param request 租户类型实体
   * @return {@link List< SysTenantTypeQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  List<SysTenantTypeQueryVO> list(SysTenantTypeListDTO request) throws Exception;

  /**
   * 租户类型列表(分页)
   *
   * @param request 租户类型实体
   * @return {@link Page< SysTenantTypeQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  Page<SysTenantTypeQueryVO> page(SysTenantTypePageDTO request) throws Exception;

  /**
   * 租户类型详情
   *
   * @param id 租户类型id
   * @return {@link SysTenantTypeQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  SysTenantTypeQueryVO details(String id) throws Exception;

  /**
   * 租户类型详情
   *
   * @param request 租户类型实体
   * @return {@link SysTenantType}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  SysTenantTypeQueryVO details(SysTenantType request) throws Exception;

  /**
   * 删除租户类型(支持批量)
   *
   * @param ids 租户类型id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑租户类型
   *
   * @param request 租户类型实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  boolean edit(SysTenantTypeEditDTO request) throws Exception;

  /**
   * 新增租户类型
   *
   * @param request 租户类型实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  boolean add(SysTenantTypeAddDTO request) throws Exception;
}
