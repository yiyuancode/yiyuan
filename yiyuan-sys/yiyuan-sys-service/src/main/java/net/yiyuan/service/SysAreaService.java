package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.SysAreaAddDTO;
import net.yiyuan.dto.SysAreaEditDTO;
import net.yiyuan.dto.SysAreaListDTO;
import net.yiyuan.dto.SysAreaPageDTO;
import net.yiyuan.model.SysArea;
import net.yiyuan.vo.SysAreaQueryVO;

import java.util.List;

/**
 * 行政区域Service层接口
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
public interface SysAreaService extends JoinIService<SysArea> {

  /**
   * 行政区域列表(全部)
   *
   * @param request 行政区域实体
   * @return {@link List< SysAreaQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  List<SysAreaQueryVO> list(SysAreaListDTO request) throws Exception;

  /**
   * 行政区域列表(分页)
   *
   * @param request 行政区域实体
   * @return {@link Page< SysAreaQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  Page<SysAreaQueryVO> page(SysAreaPageDTO request) throws Exception;

  /**
   * 行政区域详情
   *
   * @param id 行政区域id
   * @return {@link SysAreaQueryVO}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  SysAreaQueryVO details(String id) throws Exception;

  /**
   * 行政区域详情
   *
   * @param request 行政区域实体
   * @return {@link SysArea}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  SysAreaQueryVO details(SysArea request) throws Exception;

  /**
   * 删除行政区域(支持批量)
   *
   * @param ids 行政区域id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑行政区域
   *
   * @param request 行政区域实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  boolean edit(SysAreaEditDTO request) throws Exception;

  /**
   * 新增行政区域
   *
   * @param request 行政区域实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  boolean add(SysAreaAddDTO request) throws Exception;

  List<SysAreaQueryVO> getAreaTreeById(String id) throws Exception;

  List<SysAreaQueryVO> getAreaTree(String pid) throws Exception;
}
