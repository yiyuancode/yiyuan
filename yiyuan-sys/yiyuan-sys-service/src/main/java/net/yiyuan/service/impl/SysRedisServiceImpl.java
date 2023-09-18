package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.SysRedisAddDTO;
import net.yiyuan.dto.SysRedisEditDTO;
import net.yiyuan.dto.SysRedisListDTO;
import net.yiyuan.dto.SysRedisPageDTO;
import net.yiyuan.mapper.SysRedisMapper;
import net.yiyuan.model.SysRedis;
import net.yiyuan.service.SysRedisService;
import net.yiyuan.vo.SysRedisQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * Redis记录Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Slf4j
@Service
public class SysRedisServiceImpl extends JoinServiceImpl<SysRedisMapper, SysRedis>
    implements SysRedisService {
  @Resource private SysRedisMapper sysRedisMapper;

  /**
   * Redis记录列表(全部)
   *
   * @param request Redis记录实体
   * @return {@link List< SysRedisQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public List<SysRedisQueryVO> list(SysRedisListDTO request) throws Exception {

    SysRedis po = new SysRedis();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysRedis> wrapper = new JoinLambdaWrapper<>(po);
    List<SysRedisQueryVO> voList = sysRedisMapper.joinSelectList(wrapper, SysRedisQueryVO.class);

    return voList;
  }

  /**
   * Redis记录列表(分页)
   *
   * @param request Redis记录实体
   * @return {@link Page< SysRedisQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public Page<SysRedisQueryVO> page(SysRedisPageDTO request) throws Exception {
    SysRedis po = new SysRedis();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysRedis> wrapper = new JoinLambdaWrapper<>(po);
    Page<SysRedisQueryVO> voPage =
        sysRedisMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            SysRedisQueryVO.class);
    return voPage;
  }

  /**
   * Redis记录详情
   *
   * @param id Redis记录id
   * @return {@link SysRedisQueryVO}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public SysRedisQueryVO details(String id) throws Exception {
    SysRedis po = new SysRedis();
    po.setId(id);
    JoinLambdaWrapper<SysRedis> wrapper = new JoinLambdaWrapper<>(po);
    SysRedisQueryVO voBean = sysRedisMapper.joinSelectOne(wrapper, SysRedisQueryVO.class);
    return voBean;
  }

  /**
   * Redis记录详情
   *
   * @param request Redis记录实体
   * @return {@link SysRedis}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public SysRedisQueryVO details(SysRedis request) throws Exception {
    JoinLambdaWrapper<SysRedis> wrapper = new JoinLambdaWrapper<>(request);
    SysRedisQueryVO voBean = sysRedisMapper.joinSelectOne(wrapper, SysRedisQueryVO.class);
    return voBean;
  }

  /**
   * 删除Redis记录(支持批量)
   *
   * @param ids Redis记录id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    int i = sysRedisMapper.deleteBatchIds(idList);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑Redis记录
   *
   * @param request Redis记录实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean edit(SysRedisEditDTO request) throws Exception {
    SysRedis po = new SysRedis();
    BeanUtilsPlus.copy(request, po);
    int i = sysRedisMapper.updateById(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增Redis记录
   *
   * @param request Redis记录实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean add(SysRedisAddDTO request) throws Exception {
    SysRedis po = new SysRedis();
    BeanUtilsPlus.copy(request, po);
    int i = sysRedisMapper.insert(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }
}
