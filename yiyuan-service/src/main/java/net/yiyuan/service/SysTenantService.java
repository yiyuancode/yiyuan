package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.SysTenantAddDTO;
import net.yiyuan.dto.SysTenantEditDTO;
import net.yiyuan.dto.SysTenantListDTO;
import net.yiyuan.dto.SysTenantPageDTO;
import net.yiyuan.model.SysTenant;
import net.yiyuan.vo.SysTenantQueryVO;

import java.util.List;

/**
 * 租户Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
public interface SysTenantService extends JoinIService<SysTenant> {

  /**
   * 租户列表(全部)
   *
   * @param request 租户实体
   * @return {@link List< SysTenantQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  List<SysTenantQueryVO> list(SysTenantListDTO request) throws Exception;

  /**
   * 租户列表(分页)
   *
   * @param request 租户实体
   * @return {@link Page< SysTenantQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  Page<SysTenantQueryVO> page(SysTenantPageDTO request) throws Exception;

  /**
   * 租户详情
   *
   * @param id 租户id
   * @return {@link SysTenantQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  SysTenantQueryVO details(String id) throws Exception;

  /**
   * 租户详情
   *
   * @param request 租户实体
   * @return {@link SysTenant}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  SysTenantQueryVO details(SysTenant request) throws Exception;

  /**
   * 删除租户(支持批量)
   *
   * @param ids 租户id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑租户
   *
   * @param request 租户实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  boolean edit(SysTenantEditDTO request) throws Exception;

  /**
   * 新增租户
   *
   * @param request 租户实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  boolean add(SysTenantAddDTO request) throws Exception;
}