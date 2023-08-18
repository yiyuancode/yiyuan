package net.yiyuan.common.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;

import java.util.List;

public interface IBaseService<T, D, V> extends JoinIService<T> {

  /**
   * 通用查询列表
   *
   * @author ${author}
   * @date 2023-07-27
   */
  List<V> list(D request) throws Exception;

  /**
   * 通用查询分页
   *
   * @author ${author}
   * @date 2023-07-27
   */
  Page<V> page(D request) throws Exception;

  /**
   * 通用根据id查询详情
   *
   * @author ${author}
   * @date 2023-07-27
   */
  V details(String id) throws Exception;

  /**
   * 通用根据实体查询详情
   *
   * @author ${author}
   * @date 2023-07-27
   */
  V details(T request) throws Exception;

  /**
   * 通用根据id集合批量删除
   *
   * @author ${author}
   * @date 2023-07-27
   */
  boolean delete(String ids) throws Exception;

  /**
   * 通用根据实体删除
   *
   * @author ${author}
   * @date 2023-07-27
   */
  boolean delete(T request) throws Exception;

  /**
   * 通用编辑
   *
   * @author ${author}
   * @date 2023-07-27
   */
  boolean edit(D request) throws Exception;

  /**
   * 通用新增
   *
   * @author ${author}
   * @date 2023-07-27
   */
  boolean add(D request) throws Exception;
}
