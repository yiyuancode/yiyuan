package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.SysQrtzAddDTO;
import net.yiyuan.dto.SysQrtzEditDTO;
import net.yiyuan.dto.SysQrtzListDTO;
import net.yiyuan.dto.SysQrtzPageDTO;
import net.yiyuan.mapper.SysQrtzMapper;
import net.yiyuan.model.SysQrtz;
import net.yiyuan.service.SysQrtzService;
import net.yiyuan.vo.SysQrtzQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 定时任务Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Slf4j
@Service
public class SysQrtzServiceImpl extends JoinServiceImpl<SysQrtzMapper, SysQrtz>
    implements SysQrtzService {
  @Resource private SysQrtzMapper sysQrtzMapper;

  /**
   * 定时任务列表(全部)
   *
   * @param request 定时任务实体
   * @return {@link List< SysQrtzQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public List<SysQrtzQueryVO> list(SysQrtzListDTO request) throws Exception {

    SysQrtz po = new SysQrtz();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysQrtz> wrapper = new JoinLambdaWrapper<>(po);
    List<SysQrtzQueryVO> voList = sysQrtzMapper.joinSelectList(wrapper, SysQrtzQueryVO.class);

    return voList;
  }

  /**
   * 定时任务列表(分页)
   *
   * @param request 定时任务实体
   * @return {@link Page< SysQrtzQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public Page<SysQrtzQueryVO> page(SysQrtzPageDTO request) throws Exception {
    SysQrtz po = new SysQrtz();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysQrtz> wrapper = new JoinLambdaWrapper<>(po);
    Page<SysQrtzQueryVO> voPage =
        sysQrtzMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()), wrapper, SysQrtzQueryVO.class);
    return voPage;
  }

  /**
   * 定时任务详情
   *
   * @param id 定时任务id
   * @return {@link SysQrtzQueryVO}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public SysQrtzQueryVO details(String id) throws Exception {
    SysQrtz po = new SysQrtz();
    po.setId(id);
    JoinLambdaWrapper<SysQrtz> wrapper = new JoinLambdaWrapper<>(po);
    SysQrtzQueryVO voBean = sysQrtzMapper.joinSelectOne(wrapper, SysQrtzQueryVO.class);
    return voBean;
  }

  /**
   * 定时任务详情
   *
   * @param request 定时任务实体
   * @return {@link SysQrtz}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public SysQrtzQueryVO details(SysQrtz request) throws Exception {
    JoinLambdaWrapper<SysQrtz> wrapper = new JoinLambdaWrapper<>(request);
    SysQrtzQueryVO voBean = sysQrtzMapper.joinSelectOne(wrapper, SysQrtzQueryVO.class);
    return voBean;
  }

  /**
   * 删除定时任务(支持批量)
   *
   * @param ids 定时任务id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    int i = sysQrtzMapper.deleteBatchIds(idList);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑定时任务
   *
   * @param request 定时任务实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean edit(SysQrtzEditDTO request) throws Exception {
    SysQrtz po = new SysQrtz();
    BeanUtilsPlus.copy(request, po);
    int i = sysQrtzMapper.updateById(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增定时任务
   *
   * @param request 定时任务实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean add(SysQrtzAddDTO request) throws Exception {
    SysQrtz po = new SysQrtz();
    BeanUtilsPlus.copy(request, po);
    int i = sysQrtzMapper.insert(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }
}
