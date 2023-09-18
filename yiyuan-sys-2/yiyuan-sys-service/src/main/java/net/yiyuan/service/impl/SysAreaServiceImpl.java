package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
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
import net.yiyuan.redis.SysRedisUtilService;
import net.yiyuan.service.SysAreaService;
import net.yiyuan.vo.SysAreaQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 区域Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-09-11
 */
@Slf4j
@Service
public class SysAreaServiceImpl extends JoinServiceImpl<SysAreaMapper, SysArea>
    implements SysAreaService {
  @Resource private SysAreaMapper sysAreaMapper;
  @Resource private SysRedisUtilService sysRedisUtilService;
  /**
   * 区域列表(全部)
   *
   * @param request 区域实体
   * @return {@link List< SysAreaQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @Override
  public List<SysAreaQueryVO> list(SysAreaListDTO request) throws Exception {

    SysArea po = new SysArea();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysArea> wrapper = new JoinLambdaWrapper<>(po);
    List<SysAreaQueryVO> voList = joinList(wrapper, SysAreaQueryVO.class);

    return voList;
  }

  /**
   * 区域列表(分页)
   *
   * @param request 区域实体
   * @return {@link Page< SysAreaQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @Override
  public Page<SysAreaQueryVO> page(SysAreaPageDTO request) throws Exception {
    SysArea po = new SysArea();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysArea> wrapper = new JoinLambdaWrapper<>(po);
    Page<SysAreaQueryVO> voPage =
        joinPage(
            new Page<>(request.getPageNum(), request.getPageSize()), wrapper, SysAreaQueryVO.class);
    return voPage;
  }

  /**
   * 区域详情
   *
   * @param id 区域id
   * @return {@link SysAreaQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @Override
  public SysAreaQueryVO details(String id) throws Exception {
    SysArea po = new SysArea();
    po.setId(id);
    JoinLambdaWrapper<SysArea> wrapper = new JoinLambdaWrapper<>(po);
    SysAreaQueryVO voBean = joinGetOne(wrapper, SysAreaQueryVO.class);
    return voBean;
  }

  /**
   * 区域详情
   *
   * @param request 区域实体
   * @return {@link SysArea}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @Override
  public SysAreaQueryVO details(SysArea request) throws Exception {

    JoinLambdaWrapper<SysArea> wrapper = new JoinLambdaWrapper<>(request);
    SysAreaQueryVO voBean = joinGetOne(wrapper, SysAreaQueryVO.class);
    return voBean;
  }

  /**
   * 删除区域(支持批量)
   *
   * @param ids 区域id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @Override
  public boolean delete(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids.split(",")));
  }

  /**
   * 编辑区域
   *
   * @param request 区域实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @Override
  public boolean edit(SysAreaEditDTO request) throws Exception {
    SysArea po = new SysArea();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysArea> wrapper = new JoinLambdaWrapper<>(po);
    return updateById(po);
  }

  /**
   * 新增区域
   *
   * @param request 区域实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-09-11
   */
  @Override
  public boolean add(SysAreaAddDTO request) throws Exception {
    SysArea po = new SysArea();
    BeanUtilsPlus.copy(request, po);
    return save(po);
  }

  @Override
  public List<SysAreaQueryVO> getAreaTreeById(String id) throws Exception {
    //    JoinLambdaWrapper<SysArea> wrapper = new JoinLambdaWrapper<>(SysArea.class);
    //    wrapper.likeRight(SysArea::getId, id);
    //    List<SysAreaQueryVO> spmShopCities =
    //        sysAreaMapper.joinSelectList(wrapper, SysAreaQueryVO.class);
    //
    //    spmShopCities.forEach(
    //        (item) -> {
    //          if (item.getLevel().equals(SysAreaLevelEnum.FIVE_LEVEL_CLASSIFICATION)) {
    //            item.setIsLeaf(true);
    //          } else {
    //            item.setIsLeaf(false);
    //          }
    //        });
    //    List<SysAreaQueryVO> sysAreas =
    //        TreeUtil.buildTreeByTwoLayersFor(spmShopCities, "id", "pid", "child", "0");
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

    List<SysAreaQueryVO> sysAreas =
        TreeUtil.buildTreeByTwoLayersFor(spmShopCities, "id", "pid", "child", "0");
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
