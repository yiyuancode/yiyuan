package net.yiyuan.core.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.core.sys.dto.SysHostAddDTO;
import net.yiyuan.core.sys.dto.SysHostEditDTO;
import net.yiyuan.core.sys.dto.SysHostListDTO;
import net.yiyuan.core.sys.dto.SysHostPageDTO;
import net.yiyuan.core.sys.model.SysHost;
import net.yiyuan.core.sys.vo.SysHostQueryVO;

import java.util.List;

/**
 * 主机记录管理Service层接口
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
public interface SysHostService extends JoinIService<SysHost> {

  /**
   * 主机记录列表(全部)
   *
   * @param request 主机记录实体
   * @return {@link List< SysHostQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  List<SysHostQueryVO> list(SysHostListDTO request) throws Exception;

  /**
   * 主机记录列表(分页)
   *
   * @param request 主机记录实体
   * @return {@link Page< SysHostQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  Page<SysHostQueryVO> page(SysHostPageDTO request) throws Exception;

  /**
   * 主机记录详情
   *
   * @param id 主机记录id
   * @return {@link SysHostQueryVO}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  SysHostQueryVO details(String id) throws Exception;

  /**
   * 主机记录详情
   *
   * @param request 主机记录实体
   * @return {@link SysHost}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  SysHostQueryVO details(SysHost request) throws Exception;

  /**
   * 删除主机记录(支持批量)
   *
   * @param ids 主机记录id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  boolean delete(String ids) throws Exception;

  /**
   * 批量删除主机记录(根据同一属性,针对中间表)
   *
   * @param request 主机记录实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  boolean delete(SysHost request) throws Exception;

  /**
   * 编辑主机记录
   *
   * @param request 主机记录实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  boolean edit(SysHostEditDTO request) throws Exception;

  /**
   * 新增主机记录
   *
   * @param request 主机记录实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  boolean add(SysHostAddDTO request) throws Exception;
}
