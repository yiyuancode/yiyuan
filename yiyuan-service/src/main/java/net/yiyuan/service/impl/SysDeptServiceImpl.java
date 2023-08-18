package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.SysDeptAddDTO;
import net.yiyuan.dto.SysDeptEditDTO;
import net.yiyuan.dto.SysDeptListDTO;
import net.yiyuan.dto.SysDeptPageDTO;
import net.yiyuan.mapper.SysDeptMapper;
import net.yiyuan.model.SysDept;
import net.yiyuan.service.SysDeptService;
import net.yiyuan.vo.SysDeptQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 部门Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-08-17
 */
@Slf4j
@Service
public class SysDeptServiceImpl extends JoinServiceImpl<SysDeptMapper, SysDept>
    implements SysDeptService {
  @Resource private SysDeptMapper sysDeptMapper;

  /**
   * 部门列表(全部)
   *
   * @param request 部门实体
   * @return {@link List< SysDeptQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public List<SysDeptQueryVO> list(SysDeptListDTO request) throws Exception {

    SysDept po = new SysDept();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysDept> wrapper = new JoinLambdaWrapper<>(po);
    List<SysDeptQueryVO> voList = joinList(wrapper, SysDeptQueryVO.class);

    return voList;
  }

  /**
   * 部门列表(分页)
   *
   * @param request 部门实体
   * @return {@link Page< SysDeptQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public Page<SysDeptQueryVO> page(SysDeptPageDTO request) throws Exception {
    SysDept po = new SysDept();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysDept> wrapper = new JoinLambdaWrapper<>(po);
    Page<SysDeptQueryVO> voPage =
        joinPage(
            new Page<>(request.getPageNum(), request.getPageSize()), wrapper, SysDeptQueryVO.class);
    return voPage;
  }

  /**
   * 部门详情
   *
   * @param id 部门id
   * @return {@link SysDeptQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public SysDeptQueryVO details(String id) throws Exception {
    SysDept po = new SysDept();
    po.setId(id);
    JoinLambdaWrapper<SysDept> wrapper = new JoinLambdaWrapper<>(po);
    SysDeptQueryVO voBean = joinGetOne(wrapper, SysDeptQueryVO.class);
    return voBean;
  }

  /**
   * 部门详情
   *
   * @param request 部门实体
   * @return {@link SysDept}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public SysDeptQueryVO details(SysDept request) throws Exception {

    JoinLambdaWrapper<SysDept> wrapper = new JoinLambdaWrapper<>(request);
    SysDeptQueryVO voBean = joinGetOne(wrapper, SysDeptQueryVO.class);
    return voBean;
  }

  /**
   * 删除部门(支持批量)
   *
   * @param ids 部门id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public boolean delete(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids.split(",")));
  }

  /**
   * 编辑部门
   *
   * @param request 部门实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public boolean edit(SysDeptEditDTO request) throws Exception {
    SysDept po = new SysDept();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysDept> wrapper = new JoinLambdaWrapper<>(po);
    return updateById(po);
  }

  /**
   * 新增部门
   *
   * @param request 部门实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-17
   */
  @Override
  public boolean add(SysDeptAddDTO request) throws Exception {
    SysDept po = new SysDept();
    BeanUtilsPlus.copy(request, po);
    return save(po);
  }
}
