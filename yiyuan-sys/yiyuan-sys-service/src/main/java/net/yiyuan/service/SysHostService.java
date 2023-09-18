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
 * 服务器Service层接口
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
public interface SysHostService extends JoinIService<SysHost> {

  /**
   * 服务器列表(全部)
   *
   * @param request 服务器实体
   * @return {@link List< SysHostQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  List<SysHostQueryVO> list(SysHostListDTO request) throws Exception;

  /**
   * 服务器列表(分页)
   *
   * @param request 服务器实体
   * @return {@link Page< SysHostQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  Page<SysHostQueryVO> page(SysHostPageDTO request) throws Exception;

  /**
   * 服务器详情
   *
   * @param id 服务器id
   * @return {@link SysHostQueryVO}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  SysHostQueryVO details(String id) throws Exception;

  /**
   * 服务器详情
   *
   * @param request 服务器实体
   * @return {@link SysHost}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  SysHostQueryVO details(SysHost request) throws Exception;

  /**
   * 删除服务器(支持批量)
   *
   * @param ids 服务器id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑服务器
   *
   * @param request 服务器实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  boolean edit(SysHostEditDTO request) throws Exception;

  /**
   * 新增服务器
   *
   * @param request 服务器实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  boolean add(SysHostAddDTO request) throws Exception;
}
