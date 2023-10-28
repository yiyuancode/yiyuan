package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.common.utils.StringUtilsPlus;
import net.yiyuan.common.utils.TreeUtil;
import net.yiyuan.dto.SysAreaAddDTO;
import net.yiyuan.dto.SysAreaEditDTO;
import net.yiyuan.dto.SysAreaListDTO;
import net.yiyuan.dto.SysAreaPageDTO;
import net.yiyuan.enums.SysAreaLevelEnum;
import net.yiyuan.mapper.SysAreaMapper;
import net.yiyuan.model.SysArea;
import net.yiyuan.service.SysAreaService;
import net.yiyuan.vo.SysAreaQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 行政区域Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Slf4j
@Service
public class SysAreaServiceImpl extends JoinServiceImpl<SysAreaMapper, SysArea>
    implements SysAreaService {
  @Resource private SysAreaMapper sysAreaMapper;

  /**
   * 行政区域列表(全部)
   *
   * @param request 行政区域实体
   * @return {@link List< SysAreaQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public List<SysAreaQueryVO> list(SysAreaListDTO request) throws Exception {

    SysArea po = new SysArea();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysArea> wrapper = new JoinLambdaWrapper<>(po);
    List<SysAreaQueryVO> voList = sysAreaMapper.joinSelectList(wrapper, SysAreaQueryVO.class);

    return voList;
  }

  /**
   * 行政区域列表(分页)
   *
   * @param request 行政区域实体
   * @return {@link Page< SysAreaQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public Page<SysAreaQueryVO> page(SysAreaPageDTO request) throws Exception {
    SysArea po = new SysArea();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysArea> wrapper = new JoinLambdaWrapper<>(po);
    Page<SysAreaQueryVO> voPage =
        sysAreaMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()), wrapper, SysAreaQueryVO.class);
    return voPage;
  }

  /**
   * 行政区域详情
   *
   * @param id 行政区域id
   * @return {@link SysAreaQueryVO}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public SysAreaQueryVO details(String id) throws Exception {
    SysArea po = new SysArea();
    po.setId(id);
    JoinLambdaWrapper<SysArea> wrapper = new JoinLambdaWrapper<>(po);
    SysAreaQueryVO voBean = sysAreaMapper.joinSelectOne(wrapper, SysAreaQueryVO.class);
    return voBean;
  }

  /**
   * 行政区域详情
   *
   * @param request 行政区域实体
   * @return {@link SysArea}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public SysAreaQueryVO details(SysArea request) throws Exception {
    JoinLambdaWrapper<SysArea> wrapper = new JoinLambdaWrapper<>(request);
    SysAreaQueryVO voBean = sysAreaMapper.joinSelectOne(wrapper, SysAreaQueryVO.class);
    return voBean;
  }

  /**
   * 删除行政区域(支持批量)
   *
   * @param ids 行政区域id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    int i = sysAreaMapper.deleteBatchIds(idList);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑行政区域
   *
   * @param request 行政区域实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean edit(SysAreaEditDTO request) throws Exception {
    SysArea po = new SysArea();
    BeanUtilsPlus.copy(request, po);
    int i = sysAreaMapper.updateById(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增行政区域
   *
   * @param request 行政区域实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean add(SysAreaAddDTO request) throws Exception {
    SysArea po = new SysArea();
    BeanUtilsPlus.copy(request, po);
    int i = sysAreaMapper.insert(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }

  @Override
  public List<SysAreaQueryVO> getAreaTreeById(String id) throws Exception {
    List<String> ids = StringUtilsPlus.parseCodeToIds(id);

    JoinLambdaWrapper<SysArea> wrapper = new JoinLambdaWrapper<>(SysArea.class);
    wrapper.in(SysArea::getId, ids);
    List<SysAreaQueryVO> spmShopCities =
        sysAreaMapper.joinSelectList(wrapper, SysAreaQueryVO.class);

    spmShopCities.forEach(
        (item) -> {
          if (item.getLevel().equals(SysAreaLevelEnum.FIVE_LEVEL_CLASSIFICATION)) {
            item.setIsLeaf(true);
          } else {
            item.setIsLeaf(false);
          }
        });

    List<SysAreaQueryVO> sysAreas = TreeUtil.buildTreeByTwoLayersFor(spmShopCities);
    return sysAreas;
  }

  @Override
  public List<SysAreaQueryVO> getAreaTree(String pid) throws Exception {
    JoinLambdaWrapper<SysArea> wrapper = new JoinLambdaWrapper<>(SysArea.class);
    if (StringUtilsPlus.isEmpty(pid)) {
      wrapper.eq(SysArea::getPid, "0");
    } else {
      wrapper.eq(SysArea::getPid, pid);
    }
    List<SysAreaQueryVO> spmShopCities =
        sysAreaMapper.joinSelectList(wrapper, SysAreaQueryVO.class);

    List<String> areaIdList = StringUtilsPlus.parseCodeToIds(pid);
    if (areaIdList.size() == SysAreaLevelEnum.FOURTH_LEVEL_CLASSIFICATION.getValue()) {
      spmShopCities.forEach(
          (item) -> {
            item.setIsLeaf(true);
          });
    }
    return spmShopCities;
  }
}
