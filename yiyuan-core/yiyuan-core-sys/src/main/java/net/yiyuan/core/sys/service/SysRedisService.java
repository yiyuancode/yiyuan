package net.yiyuan.core.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.core.sys.dto.SysRedisAddDTO;
import net.yiyuan.core.sys.dto.SysRedisEditDTO;
import net.yiyuan.core.sys.dto.SysRedisListDTO;
import net.yiyuan.core.sys.dto.SysRedisPageDTO;
import net.yiyuan.core.sys.model.SysRedis;
import net.yiyuan.core.sys.vo.SysRedisQueryVO;

import java.util.List;
/**
 * Redis记录管理Service层接口
 *
 * @author 一源团队--花和尚
 * @date 2023-08-02
 */
public interface SysRedisService extends JoinIService<SysRedis> {

  /**
   * Redis记录列表(全部)
   *
   * @param request Redis记录实体
   * @return {@link List< SysRedisQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  List<SysRedisQueryVO> list(SysRedisListDTO request) throws Exception;

  /**
   * Redis记录列表(分页)
   *
   * @param request Redis记录实体
   * @return {@link Page< SysRedisQueryVO >}
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  Page<SysRedisQueryVO> page(SysRedisPageDTO request) throws Exception;

  /**
   * Redis记录详情
   *
   * @param id Redis记录id
   * @return {@link SysRedisQueryVO}
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  SysRedisQueryVO details(String id) throws Exception;

  /**
   * Redis记录详情
   *
   * @param request Redis记录实体
   * @return {@link SysRedis}
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  SysRedisQueryVO details(SysRedis request) throws Exception;

  /**
   * 删除Redis记录(支持批量)
   *
   * @param ids Redis记录id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  boolean delete(String ids) throws Exception;

  /**
   * 批量删除Redis记录(根据同一属性,针对中间表)
   *
   * @param request Redis记录实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  boolean delete(SysRedis request) throws Exception;

  /**
   * 编辑Redis记录
   *
   * @param request Redis记录实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  boolean edit(SysRedisEditDTO request) throws Exception;

  /**
   * 新增Redis记录
   *
   * @param request Redis记录实体
   * @return {@link boolean}
   * @author 一源团队--花和尚
   * @date 2023-08-02
   */
  boolean add(SysRedisAddDTO request) throws Exception;
}
