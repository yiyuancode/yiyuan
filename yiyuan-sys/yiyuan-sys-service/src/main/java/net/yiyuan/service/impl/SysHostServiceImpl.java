package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
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
 * 服务器Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Slf4j
@Service
public class SysHostServiceImpl extends JoinServiceImpl<SysHostMapper, SysHost>
    implements SysHostService {
  @Resource private SysHostMapper sysHostMapper;

  /**
   * 服务器列表(全部)
   *
   * @param request 服务器实体
   * @return {@link List< SysHostQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public List<SysHostQueryVO> list(SysHostListDTO request) throws Exception {

    SysHost po = new SysHost();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysHost> wrapper = new JoinLambdaWrapper<>(po);
    List<SysHostQueryVO> voList = sysHostMapper.joinSelectList(wrapper, SysHostQueryVO.class);

    return voList;
  }

  /**
   * 服务器列表(分页)
   *
   * @param request 服务器实体
   * @return {@link Page< SysHostQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public Page<SysHostQueryVO> page(SysHostPageDTO request) throws Exception {
    SysHost po = new SysHost();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysHost> wrapper = new JoinLambdaWrapper<>(po);
    Page<SysHostQueryVO> voPage =
        sysHostMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()), wrapper, SysHostQueryVO.class);
    return voPage;
  }

  /**
   * 服务器详情
   *
   * @param id 服务器id
   * @return {@link SysHostQueryVO}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public SysHostQueryVO details(String id) throws Exception {
    SysHost po = new SysHost();
    po.setId(id);
    JoinLambdaWrapper<SysHost> wrapper = new JoinLambdaWrapper<>(po);
    SysHostQueryVO voBean = sysHostMapper.joinSelectOne(wrapper, SysHostQueryVO.class);
    return voBean;
  }

  /**
   * 服务器详情
   *
   * @param request 服务器实体
   * @return {@link SysHost}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public SysHostQueryVO details(SysHost request) throws Exception {
    JoinLambdaWrapper<SysHost> wrapper = new JoinLambdaWrapper<>(request);
    SysHostQueryVO voBean = sysHostMapper.joinSelectOne(wrapper, SysHostQueryVO.class);
    return voBean;
  }

  /**
   * 删除服务器(支持批量)
   *
   * @param ids 服务器id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    int i = sysHostMapper.deleteBatchIds(idList);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑服务器
   *
   * @param request 服务器实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean edit(SysHostEditDTO request) throws Exception {
    SysHost po = new SysHost();
    BeanUtilsPlus.copy(request, po);
    int i = sysHostMapper.updateById(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增服务器
   *
   * @param request 服务器实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean add(SysHostAddDTO request) throws Exception {
    SysHost po = new SysHost();
    BeanUtilsPlus.copy(request, po);
    int i = sysHostMapper.insert(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }
}
