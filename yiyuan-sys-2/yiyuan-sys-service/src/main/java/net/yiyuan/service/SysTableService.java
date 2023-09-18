package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.*;
import net.yiyuan.model.SysTable;
import net.yiyuan.vo.SysTableQueryVO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 数据库Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-08-25
 */
public interface SysTableService extends JoinIService<SysTable> {

  /**
   * 数据库列表(全部)
   *
   * @param request 数据库实体
   * @return {@link List< SysTableQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  List<SysTableQueryVO> list(SysTableListDTO request) throws Exception;

  /**
   * 数据库列表(分页)
   *
   * @param request 数据库实体
   * @return {@link Page< SysTableQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  Page<SysTableQueryVO> page(SysTablePageDTO request) throws Exception;

  /**
   * 数据库详情
   *
   * @param id 数据库id
   * @return {@link SysTableQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  SysTableQueryVO details(String id) throws Exception;

  /**
   * 数据库详情
   *
   * @param request 数据库实体
   * @return {@link SysTable}
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  SysTableQueryVO details(SysTable request) throws Exception;

  /**
   * 删除数据库(支持批量)
   *
   * @param ids 数据库id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑数据库
   *
   * @param request 数据库实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  boolean edit(SysTableEditDTO request) throws Exception;

  /**
   * 新增数据库
   *
   * @param request 数据库实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  boolean add(SysTableAddDTO request) throws Exception;

  /**
   * 刷新数据库
   *
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  boolean refresh() throws Exception;

  /**
   * 生成代码
   *
   * @param request 生成代码实体
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  void generateCode(HttpServletResponse servletResponse, SysTableGenerateCodeDTO request)
      throws Exception;
}
