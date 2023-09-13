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
import java.util.Map;

/**
 * 区域Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-09-11
 */
public interface SysAreaService extends JoinIService<SysArea> {

  /**
   * 区域列表(全部)
   *
   * @param request 区域实体
   * @return {@link List< SysAreaQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  List<SysAreaQueryVO> list(SysAreaListDTO request) throws Exception;

  /**
   * 区域列表(分页)
   *
   * @param request 区域实体
   * @return {@link Page< SysAreaQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  Page<SysAreaQueryVO> page(SysAreaPageDTO request) throws Exception;

  /**
   * 区域详情
   *
   * @param id 区域id
   * @return {@link SysAreaQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  SysAreaQueryVO details(String id) throws Exception;

  /**
   * 区域详情
   *
   * @param request 区域实体
   * @return {@link SysArea}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  SysAreaQueryVO details(SysArea request) throws Exception;

  /**
   * 删除区域(支持批量)
   *
   * @param ids 区域id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑区域
   *
   * @param request 区域实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  boolean edit(SysAreaEditDTO request) throws Exception;

  /**
   * 新增区域
   *
   * @param request 区域实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  boolean add(SysAreaAddDTO request) throws Exception;

  /**
   * 根据id查询所有层级
   *
   * @param id 区域id
   * @return {@link List< Map <String, Object>>}
   * @author 一源团队-花和尚
   * @date 2023-09-09
   */
  List<SysAreaQueryVO> getAreaTreeById(String id) throws Exception;

  /**
   * 查询所有层级
   *
   * @return {@link List<Map<String, Object>>}
   * @author 一源团队-花和尚
   * @date 2023-09-09
   */
  Object getAreaTree() throws Exception;
}
