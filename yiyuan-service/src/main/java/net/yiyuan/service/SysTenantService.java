package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.*;
import net.yiyuan.model.SysTenant;
import net.yiyuan.vo.SysTenantQueryVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商户Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-09-08
 */
public interface SysTenantService extends JoinIService<SysTenant> {

  /**
   * 商户列表(全部)
   *
   * @param request 商户实体
   * @return {@link List< SysTenantQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  List<SysTenantQueryVO> list(SysTenantListDTO request) throws Exception;

  /**
   * 商户列表(分页)
   *
   * @param request 商户实体
   * @return {@link Page< SysTenantQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  Page<SysTenantQueryVO> page(SysTenantPageDTO request) throws Exception;

  /**
   * 商户详情
   *
   * @param id 商户id
   * @return {@link SysTenantQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  SysTenantQueryVO details(String id) throws Exception;

  /**
   * 商户详情
   *
   * @param request 商户实体
   * @return {@link SysTenant}
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  SysTenantQueryVO details(SysTenant request) throws Exception;

  /**
   * 删除商户(支持批量)
   *
   * @param ids 商户id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑商户
   *
   * @param request 商户实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  boolean edit(SysTenantEditDTO request) throws Exception;

  /**
   * 新增商户
   *
   * @param request 商户实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  boolean add(SysTenantAddDTO request) throws Exception;

  /**
   * 发起商户入驻申请
   *
   * @param request 商户实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  boolean apply(SysTenantApplyDTO request) throws Exception;

  /**
   * 发起商户入驻申请
   *
   * @param request 商户实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @Transactional
  boolean process(SysTenantProcessDTO request) throws Exception;
}
