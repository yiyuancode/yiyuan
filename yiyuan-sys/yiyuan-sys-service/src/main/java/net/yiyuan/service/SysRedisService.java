package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.SysRedisAddDTO;
import net.yiyuan.dto.SysRedisEditDTO;
import net.yiyuan.dto.SysRedisListDTO;
import net.yiyuan.dto.SysRedisPageDTO;
import net.yiyuan.model.SysRedis;
import net.yiyuan.vo.SysRedisQueryVO;

import java.util.List;

/**
 * Redis记录Service层接口
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
public interface SysRedisService extends JoinIService<SysRedis> {

  /**
   * Redis记录列表(全部)
   *
   * @param request Redis记录实体
   * @return {@link List< SysRedisQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  List<SysRedisQueryVO> list(SysRedisListDTO request) throws Exception;

  /**
   * Redis记录列表(分页)
   *
   * @param request Redis记录实体
   * @return {@link Page< SysRedisQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  Page<SysRedisQueryVO> page(SysRedisPageDTO request) throws Exception;

  /**
   * Redis记录详情
   *
   * @param id Redis记录id
   * @return {@link SysRedisQueryVO}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  SysRedisQueryVO details(String id) throws Exception;

  /**
   * Redis记录详情
   *
   * @param request Redis记录实体
   * @return {@link SysRedis}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  SysRedisQueryVO details(SysRedis request) throws Exception;

  /**
   * 删除Redis记录(支持批量)
   *
   * @param ids Redis记录id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  boolean delete(String ids) throws Exception;

  /**
   * 编辑Redis记录
   *
   * @param request Redis记录实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  boolean edit(SysRedisEditDTO request) throws Exception;

  /**
   * 新增Redis记录
   *
   * @param request Redis记录实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  boolean add(SysRedisAddDTO request) throws Exception;
}
