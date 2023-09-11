package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.SysHostAddDTO;
import net.yiyuan.dto.SysHostEditDTO;
import net.yiyuan.dto.SysHostListDTO;
import net.yiyuan.dto.SysHostPageDTO;
import net.yiyuan.model.SysHost;
import net.yiyuan.vo.SysHostQueryVO;

import java.util.List;

/**
 * 主机记录Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
public interface SysHostService extends JoinIService<SysHost> {

  /**
   * 主机记录列表(全部)
   *
   * @param request 主机记录实体
   * @return {@link List< SysHostQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  List<SysHostQueryVO> list(SysHostListDTO request) throws Exception;

  /**
   * 主机记录列表(分页)
   *
   * @param request 主机记录实体
   * @return {@link Page< SysHostQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  Page<SysHostQueryVO> page(SysHostPageDTO request) throws Exception;

  /**
   * 主机记录详情
   *
   * @param id 主机记录id
   * @return {@link SysHostQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  SysHostQueryVO details(String id) throws Exception;

  /**
   * 主机记录详情
   *
   * @param request 主机记录实体
   * @return {@link SysHost}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  SysHostQueryVO details(SysHost request) throws Exception;

  /**
   * 删除主机记录(支持批量)
   *
   * @param ids 主机记录id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑主机记录
   *
   * @param request 主机记录实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  boolean edit(SysHostEditDTO request) throws Exception;

  /**
   * 新增主机记录
   *
   * @param request 主机记录实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  boolean add(SysHostAddDTO request) throws Exception;
}
