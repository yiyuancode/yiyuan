package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.SysHostAddDTO;
import net.yiyuan.dto.SysHostEditDTO;
import net.yiyuan.dto.SysHostListDTO;
import net.yiyuan.dto.SysHostPageDTO;
import net.yiyuan.mapper.SysHostMapper;
import net.yiyuan.model.SysHost;
import net.yiyuan.service.SysHostService;
import net.yiyuan.vo.SysHostQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 主机记录Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
@Slf4j
@Service
public class SysHostServiceImpl extends JoinServiceImpl<SysHostMapper, SysHost>
    implements SysHostService {
  @Resource private SysHostMapper sysHostMapper;

  /**
   * 主机记录列表(全部)
   *
   * @param request 主机记录实体
   * @return {@link List< SysHostQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public List<SysHostQueryVO> list(SysHostListDTO request) throws Exception {

    SysHost po = new SysHost();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysHost> wrapper = new JoinLambdaWrapper<>(po);
    List<SysHostQueryVO> voList = joinList(wrapper, SysHostQueryVO.class);

    return voList;
  }

  /**
   * 主机记录列表(分页)
   *
   * @param request 主机记录实体
   * @return {@link Page< SysHostQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public Page<SysHostQueryVO> page(SysHostPageDTO request) throws Exception {
    SysHost po = new SysHost();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysHost> wrapper = new JoinLambdaWrapper<>(po);
    Page<SysHostQueryVO> voPage =
        joinPage(
            new Page<>(request.getPageNum(), request.getPageSize()), wrapper, SysHostQueryVO.class);
    return voPage;
  }

  /**
   * 主机记录详情
   *
   * @param id 主机记录id
   * @return {@link SysHostQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public SysHostQueryVO details(String id) throws Exception {
    SysHost po = new SysHost();
    po.setId(id);
    JoinLambdaWrapper<SysHost> wrapper = new JoinLambdaWrapper<>(po);
    SysHostQueryVO voBean = joinGetOne(wrapper, SysHostQueryVO.class);
    return voBean;
  }

  /**
   * 主机记录详情
   *
   * @param request 主机记录实体
   * @return {@link SysHost}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public SysHostQueryVO details(SysHost request) throws Exception {

    JoinLambdaWrapper<SysHost> wrapper = new JoinLambdaWrapper<>(request);
    SysHostQueryVO voBean = joinGetOne(wrapper, SysHostQueryVO.class);
    return voBean;
  }

  /**
   * 删除主机记录(支持批量)
   *
   * @param ids 主机记录id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public boolean delete(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids.split(",")));
  }

  /**
   * 编辑主机记录
   *
   * @param request 主机记录实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public boolean edit(SysHostEditDTO request) throws Exception {
    SysHost po = new SysHost();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysHost> wrapper = new JoinLambdaWrapper<>(po);
    return updateById(po);
  }

  /**
   * 新增主机记录
   *
   * @param request 主机记录实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public boolean add(SysHostAddDTO request) throws Exception {
    SysHost po = new SysHost();
    BeanUtilsPlus.copy(request, po);
    return save(po);
  }
}
