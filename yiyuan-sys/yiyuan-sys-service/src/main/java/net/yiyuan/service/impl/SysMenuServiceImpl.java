package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.SysMenuAddDTO;
import net.yiyuan.dto.SysMenuEditDTO;
import net.yiyuan.dto.SysMenuListDTO;
import net.yiyuan.dto.SysMenuPageDTO;
import net.yiyuan.mapper.SysMenuMapper;
import net.yiyuan.model.SysMenu;
import net.yiyuan.service.SysMenuService;
import net.yiyuan.vo.SysMenuQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 菜单Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Slf4j
@Service
public class SysMenuServiceImpl extends JoinServiceImpl<SysMenuMapper, SysMenu>
    implements SysMenuService {
  @Resource private SysMenuMapper sysMenuMapper;

  /**
   * 菜单列表(全部)
   *
   * @param request 菜单实体
   * @return {@link List< SysMenuQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public List<SysMenuQueryVO> list(SysMenuListDTO request) throws Exception {

    SysMenu po = new SysMenu();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysMenu> wrapper = new JoinLambdaWrapper<>(po);
    List<SysMenuQueryVO> voList = sysMenuMapper.joinSelectList(wrapper, SysMenuQueryVO.class);

    return voList;
  }

  /**
   * 菜单列表(分页)
   *
   * @param request 菜单实体
   * @return {@link Page< SysMenuQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public Page<SysMenuQueryVO> page(SysMenuPageDTO request) throws Exception {
    SysMenu po = new SysMenu();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysMenu> wrapper = new JoinLambdaWrapper<>(po);
    Page<SysMenuQueryVO> voPage =
        sysMenuMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()), wrapper, SysMenuQueryVO.class);
    return voPage;
  }

  /**
   * 菜单详情
   *
   * @param id 菜单id
   * @return {@link SysMenuQueryVO}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public SysMenuQueryVO details(String id) throws Exception {
    SysMenu po = new SysMenu();
    po.setId(id);
    JoinLambdaWrapper<SysMenu> wrapper = new JoinLambdaWrapper<>(po);
    SysMenuQueryVO voBean = sysMenuMapper.joinSelectOne(wrapper, SysMenuQueryVO.class);
    return voBean;
  }

  /**
   * 菜单详情
   *
   * @param request 菜单实体
   * @return {@link SysMenu}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public SysMenuQueryVO details(SysMenu request) throws Exception {
    JoinLambdaWrapper<SysMenu> wrapper = new JoinLambdaWrapper<>(request);
    SysMenuQueryVO voBean = sysMenuMapper.joinSelectOne(wrapper, SysMenuQueryVO.class);
    return voBean;
  }

  /**
   * 删除菜单(支持批量)
   *
   * @param ids 菜单id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    int i = sysMenuMapper.deleteBatchIds(idList);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑菜单
   *
   * @param request 菜单实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean edit(SysMenuEditDTO request) throws Exception {
    SysMenu po = new SysMenu();
    BeanUtilsPlus.copy(request, po);
    int i = sysMenuMapper.updateById(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增菜单
   *
   * @param request 菜单实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean add(SysMenuAddDTO request) throws Exception {
    SysMenu po = new SysMenu();
    BeanUtilsPlus.copy(request, po);
    int i = sysMenuMapper.insert(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }
}
