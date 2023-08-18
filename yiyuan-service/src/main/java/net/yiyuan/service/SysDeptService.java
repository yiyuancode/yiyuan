package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.SysDeptAddDTO;
import net.yiyuan.dto.SysDeptEditDTO;
import net.yiyuan.dto.SysDeptListDTO;
import net.yiyuan.dto.SysDeptPageDTO;
import net.yiyuan.model.SysDept;
import net.yiyuan.vo.SysDeptQueryVO;

import java.util.List;

/**
 * 部门Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
public interface SysDeptService extends JoinIService<SysDept> {

  /**
   * 部门列表(全部)
   *
   * @param request 部门实体
   * @return {@link List< SysDeptQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  List<SysDeptQueryVO> list(SysDeptListDTO request) throws Exception;

  /**
   * 部门列表(分页)
   *
   * @param request 部门实体
   * @return {@link Page< SysDeptQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  Page<SysDeptQueryVO> page(SysDeptPageDTO request) throws Exception;

  /**
   * 部门详情
   *
   * @param id 部门id
   * @return {@link SysDeptQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  SysDeptQueryVO details(String id) throws Exception;

  /**
   * 部门详情
   *
   * @param request 部门实体
   * @return {@link SysDept}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  SysDeptQueryVO details(SysDept request) throws Exception;

  /**
   * 删除部门(支持批量)
   *
   * @param ids 部门id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑部门
   *
   * @param request 部门实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  boolean edit(SysDeptEditDTO request) throws Exception;

  /**
   * 新增部门
   *
   * @param request 部门实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  boolean add(SysDeptAddDTO request) throws Exception;
}
