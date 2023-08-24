package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.SysTenantInfoAddDTO;
import net.yiyuan.dto.SysTenantInfoEditDTO;
import net.yiyuan.dto.SysTenantInfoListDTO;
import net.yiyuan.dto.SysTenantInfoPageDTO;
import net.yiyuan.model.SysTenantInfo;
import net.yiyuan.vo.SysTenantInfoQueryVO;

import java.util.List;

/**
 * 租户信息Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
public interface SysTenantInfoService extends JoinIService<SysTenantInfo> {

  /**
   * 租户信息列表(全部)
   *
   * @param request 租户信息实体
   * @return {@link List< SysTenantInfoQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  List<SysTenantInfoQueryVO> list(SysTenantInfoListDTO request) throws Exception;

  /**
   * 租户信息列表(分页)
   *
   * @param request 租户信息实体
   * @return {@link Page< SysTenantInfoQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  Page<SysTenantInfoQueryVO> page(SysTenantInfoPageDTO request) throws Exception;

  /**
   * 租户信息详情
   *
   * @param id 租户信息id
   * @return {@link SysTenantInfoQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  SysTenantInfoQueryVO details(String id) throws Exception;

  /**
   * 租户信息详情
   *
   * @param request 租户信息实体
   * @return {@link SysTenantInfo}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  SysTenantInfoQueryVO details(SysTenantInfo request) throws Exception;

  /**
   * 删除租户信息(支持批量)
   *
   * @param ids 租户信息id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑租户信息
   *
   * @param request 租户信息实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  boolean edit(SysTenantInfoEditDTO request) throws Exception;

  /**
   * 新增租户信息
   *
   * @param request 租户信息实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  boolean add(SysTenantInfoAddDTO request) throws Exception;
}
