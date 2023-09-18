package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.SysRoleAddDTO;
import net.yiyuan.dto.SysRoleEditDTO;
import net.yiyuan.dto.SysRoleListDTO;
import net.yiyuan.dto.SysRolePageDTO;
import net.yiyuan.mapper.SysRoleMapper;
import net.yiyuan.model.SysRole;
import net.yiyuan.service.SysRoleService;
import net.yiyuan.vo.SysRoleQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 管理端角色Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Slf4j
@Service
public class SysRoleServiceImpl extends JoinServiceImpl<SysRoleMapper, SysRole>
    implements SysRoleService {
  @Resource private SysRoleMapper sysRoleMapper;

  /**
   * 管理端角色列表(全部)
   *
   * @param request 管理端角色实体
   * @return {@link List< SysRoleQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public List<SysRoleQueryVO> list(SysRoleListDTO request) throws Exception {

    SysRole po = new SysRole();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysRole> wrapper = new JoinLambdaWrapper<>(po);
    List<SysRoleQueryVO> voList = sysRoleMapper.joinSelectList(wrapper, SysRoleQueryVO.class);

    return voList;
  }

  /**
   * 管理端角色列表(分页)
   *
   * @param request 管理端角色实体
   * @return {@link Page< SysRoleQueryVO >}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public Page<SysRoleQueryVO> page(SysRolePageDTO request) throws Exception {
    SysRole po = new SysRole();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysRole> wrapper = new JoinLambdaWrapper<>(po);
    Page<SysRoleQueryVO> voPage =
        sysRoleMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()), wrapper, SysRoleQueryVO.class);
    return voPage;
  }

  /**
   * 管理端角色详情
   *
   * @param id 管理端角色id
   * @return {@link SysRoleQueryVO}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public SysRoleQueryVO details(String id) throws Exception {
    SysRole po = new SysRole();
    po.setId(id);
    JoinLambdaWrapper<SysRole> wrapper = new JoinLambdaWrapper<>(po);
    SysRoleQueryVO voBean = sysRoleMapper.joinSelectOne(wrapper, SysRoleQueryVO.class);
    return voBean;
  }

  /**
   * 管理端角色详情
   *
   * @param request 管理端角色实体
   * @return {@link SysRole}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public SysRoleQueryVO details(SysRole request) throws Exception {
    JoinLambdaWrapper<SysRole> wrapper = new JoinLambdaWrapper<>(request);
    SysRoleQueryVO voBean = sysRoleMapper.joinSelectOne(wrapper, SysRoleQueryVO.class);
    return voBean;
  }

  /**
   * 删除管理端角色(支持批量)
   *
   * @param ids 管理端角色id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    int i = sysRoleMapper.deleteBatchIds(idList);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑管理端角色
   *
   * @param request 管理端角色实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean edit(SysRoleEditDTO request) throws Exception {
    SysRole po = new SysRole();
    BeanUtilsPlus.copy(request, po);
    int i = sysRoleMapper.updateById(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增管理端角色
   *
   * @param request 管理端角色实体
   * @return {@link boolean}
   * @author 一源-花和尚
   * @date 2023-09-18
   */
  @Override
  public boolean add(SysRoleAddDTO request) throws Exception {
    SysRole po = new SysRole();
    BeanUtilsPlus.copy(request, po);
    int i = sysRoleMapper.insert(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }
}
